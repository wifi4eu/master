package wifi4eu.wifi4eu.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.user.UserRepository;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;
}