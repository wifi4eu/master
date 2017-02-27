package wifi4eu.wifi4eu.service.security;


import eu.cec.digit.ecas.client.jaas.DetailedUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.Role;
import wifi4eu.wifi4eu.entity.security.User;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.*;

@Service
public class DBUserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SecurityUserRepository securityUserRepository;

    private final static Logger logger = Logger.getLogger(UserDetailsServiceCustom.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        try {

            User dbUser = securityUserRepository.findByEmail(username);
            return new org.springframework.security.core.userdetails.
                    User(dbUser.getEmail(), String.valueOf(dbUser.getPassword()), true, true, true, true, setRoles(dbUser.getRoles()));

        } catch (Exception ex) {
            if (ex instanceof UsernameNotFoundException) {
                throw (UsernameNotFoundException) ex;
            } else
                throw new UsernameNotFoundException("Cannot retrieve the userDetails", ex);
        }
    }


    public UserDetails getUserContext() {
        return UserHolder.getUser();
    }

    private List<GrantedAuthority> setRoles(List<Role> dbRoles){
        List<GrantedAuthority> roles = new ArrayList<>();

        for(Role dbRole : dbRoles){
            GrantedAuthority grantedAuthority =  new SimpleGrantedAuthority(dbRole.getName());
            roles.add(grantedAuthority);
        }

        return roles;
    }
}