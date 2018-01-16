package wifi4eu.wifi4eu.service.security;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.Right;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.mapper.security.RightMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class PermissionChecker {

    private final Logger _log = LoggerFactory.getLogger(PermissionChecker.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RightMapper rightMapper;

    @Autowired
    RightRepository rightRepository;

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
    public void addTablePermissions(final UserDTO userDTO, final Object rowObj,
                                    final String destTable, final String logInfo) {
        _log.debug("addTablePermissions " + logInfo);

        final String id = getIdByReflection(rowObj);
        if (id != null) {
            User user = userMapper.toEntity(userDTO);
            Right right = new Right(user, destTable+id, user.getType());
            rightRepository.save(right);
        } else {
            _log.error("Id was not recovered");
        }
    }

    private String getIdByReflection(final Object rowObj) {
        String id = null;

        try {
            Method method = rowObj.getClass().getMethod("getId");
            id = method.invoke(rowObj).toString();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            _log.error("Reflection fails");
            e.printStackTrace();
        }

        return id;
    }

}