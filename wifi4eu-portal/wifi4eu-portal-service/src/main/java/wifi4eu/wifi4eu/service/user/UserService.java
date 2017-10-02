package wifi4eu.wifi4eu.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.UserMapper;
import wifi4eu.wifi4eu.repository.UserRepository;

public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;
}