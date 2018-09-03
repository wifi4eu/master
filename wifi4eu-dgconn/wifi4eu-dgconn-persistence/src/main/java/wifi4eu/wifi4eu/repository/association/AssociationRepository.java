package wifi4eu.wifi4eu.repository.association;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.association.Association;

public interface AssociationRepository extends CrudRepository<Association, Integer> {

    Association findTopByNameOrderByIdDesc(String name);

}
