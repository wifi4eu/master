package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.repository.user.UserRepository;


@Service
public class UserUtils {

    @Autowired
    UserRepository userRepository;

    public String getUserLangByUserId(int id){
        User user = userRepository.findOne(id);
        String lang = user.getLang();
        return lang;
    }

}
