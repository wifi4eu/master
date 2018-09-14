package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierUserRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;

@Service
public class RegistrationUtils {

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    SupplierUserRepository supplierUserRepository;

    @Autowired
    UserRepository userRepository;

    public boolean enableInvitateContactByUserIdRequested(String email){
        return !(registrationUsersRepository.findByContactEmail(email).size() > 0) && !(supplierUserRepository.findByEmail(email).size() > 0) && Validator.isNull(userRepository.findByEcasEmail(email));
    }
}
