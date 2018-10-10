package wifi4eu.wifi4eu.service.security;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.mapper.security.RightMapper;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.Right;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.List;

@Service
public class PermissionChecker {

    private static final Logger _log = LoggerFactory.getLogger(PermissionChecker.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RightMapper rightMapper;

    @Autowired
    private RightRepository rightRepository;

    @Autowired
    private UserService userService;

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
        return (currentUserDTO.getType() == 5);
    }

}