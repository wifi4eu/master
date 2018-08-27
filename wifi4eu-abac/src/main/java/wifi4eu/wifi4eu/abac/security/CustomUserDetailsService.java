package wifi4eu.wifi4eu.abac.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.Role;
import wifi4eu.wifi4eu.abac.data.entity.User;
import wifi4eu.wifi4eu.abac.data.repository.RoleRepository;
import wifi4eu.wifi4eu.abac.data.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findFirstByUserNameEquals(username);

        if(user == null){
            return new org.springframework.security.core.userdetails.User(
                    username, "", false, true, true,
                    true, new ArrayList<>());
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), "", user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(roles.stream().map( r -> r.getName() ).collect(Collectors.toList() ));
    }


    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
