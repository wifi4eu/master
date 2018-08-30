package wifi4eu.wifi4eu.repository.organization;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.organization.OrganizationUsers;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;

public interface OrganizationUsersRepository extends CrudRepository<OrganizationUsers, Integer> {

    OrganizationUsers findByIdUser(Integer idUser);

}
