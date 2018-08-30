package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.repository.organization.OrganizationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierUserRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.security.PermissionChecker;

import java.util.List;

@Service
public class RegistrationUtils {

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    SupplierUserRepository supplierUserRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    PermissionChecker permissionChecker;

    public boolean enableInvitateContactByUserIdRequested(String email){
        return !(registrationUsersRepository.findByContactEmail(email).size() > 0) && !(supplierUserRepository.findByEmail(email).size() > 0) && Validator.isNull(userRepository.findByEcasEmail(email));
    }

    public boolean checkOrganizationPermissions(Integer idOrganization){
        if( Validator.isNotNull(idOrganization) && idOrganization != 0 &&Validator.isNotNull(organizationRepository.findOne(idOrganization)) ) {
            List<Registration> registrations = registrationRepository.findByOrganisationId(idOrganization);
            for (Registration registration : registrations) {
                permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registration.getId());
            }
        }
        return false;
    }

}
