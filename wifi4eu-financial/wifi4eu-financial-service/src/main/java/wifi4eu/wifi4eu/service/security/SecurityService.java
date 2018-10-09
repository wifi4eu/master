package wifi4eu.wifi4eu.service.security;

import org.apache.log4j.Logger;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.entity.security.Right;
import wifi4eu.wifi4eu.entity.security.Role;
import wifi4eu.wifi4eu.entity.security.User;
import wifi4eu.wifi4eu.common.mapper.security.RightMapper;
import wifi4eu.wifi4eu.common.mapper.security.RoleMapper;
import wifi4eu.wifi4eu.common.mapper.security.UserMapper;
import wifi4eu.wifi4eu.repository.security.SecurityRightRepository;
import wifi4eu.wifi4eu.repository.security.SecurityRoleRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService {

    private final static Logger logger = Logger.getLogger(SecurityService.class);

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    SecurityRoleRepository securityRoleRepository;

    @Autowired
    SecurityRightRepository securityRightRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RightMapper rightMapper;




    // -------------------------------------------------------
    // GET RBAC roles entries for Spring Security mapped roles
    // -------------------------------------------------------

    public List<String> getSecurityUserRoles(String userEmail) {
        List<String> roles = new ArrayList<>();

        try {
            User user = securityUserRepository.findByEmail(userEmail);

            if (user.getRoles() != null) {
                for (Role role : user.getRoles()) {
                    if (role.getRights() != null) {
                        for (Right right: role.getRights()) {
                            roles.add("ROLE_RIGHT_" + right.getName());
                        }
                    }
                }
            } else {
                roles.add("ROLE_RIGHT_right.default");
            }

        } catch(Exception e) {
            logger.info("USER : " + userEmail + " NOT FOUND IN USER TABLE, providing default role....");
        } finally {
            roles.add("ROLE_RIGHT_right.default");
        }

        return roles;
    }





    // ---------------------------------
    // USERS methods
    // ---------------------------------

    @SuppressWarnings("unchecked")
    public List<UserDTO> getUsers() {
        return userMapper.toDTOList((List) securityUserRepository.findAll());
    }

    public UserDTO getUserById(Long perId) {
        return userMapper.toDTO(securityUserRepository.findOne(perId));
    }

    @Transactional
    public UserDTO saveUser(UserDTO dto) {
        User user;

        try {
            user = securityUserRepository.save(userMapper.toEntity(dto));
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e.getMessage(),"app.database.exception", e);
        }

        return userMapper.toDTO(user);
    }









    // ---------------------------------
    // ROLES methods
    // ---------------------------------


    @SuppressWarnings("unchecked")
    public List<RoleDTO> getRoles() {
        return roleMapper.toDTOList((List) securityRoleRepository.findAll());
    }

    public RoleDTO getRoleById(Long roleId) {
        return roleMapper.toDTO(securityRoleRepository.findOne(roleId));
    }

    @Transactional
    public RoleDTO saveRole(RoleDTO roleDTO) {
        Role role;

        try {
            role = securityRoleRepository.save(roleMapper.toEntity(roleDTO));
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e.getMessage(),"app.database.exception", e);
        }

        return roleMapper.toDTO(role);
    }

    @Transactional
    public void deleteRole(Long roleId) {

        try {
            securityRoleRepository.delete(roleId);
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e.getMessage(),"app.database.exception", e);
        }

    }





    // ---------------------------------
    // RIGHTS methods
    // ---------------------------------


    public RightDTO getRightById(Long rightId) {
        return rightMapper.toDTO(securityRightRepository.findOne(rightId));
    }


    public List<RightDTO> getRights(boolean isLoadRoles) {
        Iterable<Right> rights = securityRightRepository.findAll();
        List<RightDTO> rightDTOs = new ArrayList<>();
        RightDTO rightDTO;
        Iterable<Role> roles;
        List<RoleDTO> roleDTOs;

        if (rights != null) {
            for (Right r : rights) {
                rightDTO = rightMapper.toDTO(r);
                if (isLoadRoles) {
                    roles = securityRoleRepository.findByRights_rightId(rightDTO.getRightId());
                    roleDTOs = new ArrayList<>();
                    for (Role role : roles) {
                        roleDTOs.add(new RoleDTO(role.getName()));
                    }
                    rightDTO.setRoles(roleDTOs);
                    rightDTOs.add(rightDTO);
                } else {
                    rightDTOs.add(rightDTO);
                }
            }
        }

        return rightDTOs;
    }

    @Transactional
    public RightDTO saveRight(RightDTO rightDTO) {
        Right right;

        try {
            right = securityRightRepository.save(rightMapper.toEntity(rightDTO));
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e.getMessage(),"app.database.exception", e);
        }

        return rightMapper.toDTO(right);

    }

    @Transactional
    public void deleteRight(Long rightId) {

        try {
            securityRightRepository.delete(rightId);
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e.getMessage(),"app.database.exception", e);
        }

    }














}