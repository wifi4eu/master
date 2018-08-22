package wifi4eu.wifi4eu.service.security;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.Right;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.security.RightMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class PermissionChecker {

    private final Logger _log = LogManager.getLogger(PermissionChecker.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RightMapper rightMapper;

    @Autowired
    RightRepository rightRepository;

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    @Autowired
    UserService userService;

    public boolean check(String rightDesc){
        UserContext userContext = UserHolder.getUser();
        UserDTO currentUserDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));
        return this.check(currentUserDTO, rightDesc);
    }

    public boolean check(UserDTO userDTO, String rightDesc){
        List<RightDTO> rightDTOs = rightMapper.toDTOList(Lists.newArrayList(rightRepository.findByRightdescAndUserId(rightDesc,userDTO.getId())));
        if (rightDesc.startsWith(RightConstants.REGISTRATIONS_TABLE) && userDTO.getType() == 5) {
            return true;
        }
        if (rightDTOs.isEmpty()) {
            throw new AppException("Permission error", HttpStatus.SC_FORBIDDEN, "");
        }
        return true;
    }

    @Transactional
    public void addTablePermissions(final UserDTO userDTO, final String rowId,
                                    final String destTable, final String logInfo) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + "- Adding table permissions");

        User user = userMapper.toEntity(userDTO);
        Iterable<Right> rightsFound = rightRepository.findByRightdescAndUserId(destTable + rowId, user.getId());
        if ( Iterables.isEmpty(rightsFound) ) {
            Right right = new Right(user, destTable + rowId, user.getType());
            rightRepository.save(right);
        }
    }

    public boolean checkIfDashboardUser() {
        UserContext userContext = UserHolder.getUser();
        UserDTO currentUserDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));
        if (currentUserDTO.getType() == 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfAuthorizedGrantAgreement(Integer applicationId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO currentUserDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));
        ApplicationAuthorizedPersonDTO applicationAuthorizedPerson = applicationAuthorizedPersonService.findByApplicationAndAuthorisedPerson(applicationId, currentUserDTO.getId());
        if(applicationAuthorizedPerson == null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Forbids petitions that are not from a logged user. It verifies that this user is a beneficiary.
     * This means that in localhost making petitions using postman or any other rest client is not going to work if mr
     * tester is not type 3. Please change it on your local database.
     *
     * @throws AccessDeniedException
     */
    public void checkBeneficiaryPermission(int userType, int idMunicipality, int idRegistration) throws AccessDeniedException {
        if (userType != Constant.ROLE_REPRESENTATIVE ) {
            throw new AccessDeniedException("403 FORBIDDEN");
        }

        check(RightConstants.REGISTRATIONS_TABLE + idRegistration);
        check(RightConstants.MUNICIPALITIES_TABLE +  idMunicipality);
    }

    public ResponseDTO getAccessDeniedResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setError(new ErrorDTO(403, "shared.error.notallowed"));
        return response;
    }
}