package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ValidatedBC;


public interface ValidatedBCRepository extends CrudRepository<ValidatedBC,Integer> {
    @Query(value = "SELECT \"idBc\" FROM VALIDATED_BC", nativeQuery = true)
    Iterable<ValidatedBC> findBC();
}
