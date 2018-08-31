package wifi4eu.wifi4eu.repository.association;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.association.AssociationUsers;

public interface AssociationUsersRepository extends CrudRepository<AssociationUsers, Integer> {

    AssociationUsers findByIdUser(Integer idUser);

}
