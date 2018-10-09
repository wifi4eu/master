package wifi4eu.wifi4eu.service.security;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.Right;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.common.mapper.security.RightMapper;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryDisplayedListService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

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
    UserService userService;

    @Autowired
    SupplierService supplierService;

    public boolean check(String rightDesc){

        UserContext userContext = UserHolder.getUser();

        UserDTO currentUserDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));

        return this.check(currentUserDTO, rightDesc);

    }

    public boolean check(UserDTO userDTO, String rightDesc){

        List<RightDTO> rightDTOs = rightMapper.toDTOList(Lists.newArrayList(rightRepository.findByRightdescAndUserId(rightDesc,userDTO.getId())));

        if(rightDTOs.isEmpty()){
            throw new AccessDeniedException("403 FORBIDDEN");
        }

        return true;
    }

    @Transactional
    public void addTablePermissions(final UserDTO userDTO, final String rowId,
                                    final String destTable, final String logInfo) {
        _log.debug("addTablePermissions " + logInfo);

        User user = userMapper.toEntity(userDTO);
        Iterable<Right> rightsFound = rightRepository.findByRightdescAndUserId(destTable + rowId, user.getId());

        if ( Iterables.isEmpty(rightsFound) ) {
            Right right = new Right(user, destTable + rowId, user.getType());
            rightRepository.save(right);
        }
    }

    /**
     * Forbids petitions that are not from a logged user. It verifies that this user is a supplier.
     * This means that in localhost making petitions using postman or any other rest client is not going to work if mr
     * tester is not type 1. Please change it on your local database.
     * @throws AccessDeniedException
     */
    public SupplierDTO checkSupplierPermission() throws AccessDeniedException{
        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
        SupplierDTO supplier = supplierService.getSupplierByUserId(userDTO.getId());
        if (userDTO.getType() != Constant.ROLE_SUPPLIER ||  supplier== null) {
            throw new AccessDeniedException("403 FORBIDDEN");
        }
        return supplier;
    }

    public ResponseDTO getAccessDeniedResponse(){
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setError(new ErrorDTO(403, "shared.error.notallowed"));
        return response;
    }
}