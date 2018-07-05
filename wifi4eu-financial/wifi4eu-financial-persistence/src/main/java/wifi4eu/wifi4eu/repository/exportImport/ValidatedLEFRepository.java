package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ValidatedLEF;


public interface ValidatedLEFRepository extends CrudRepository<ValidatedLEF,Integer> {
    @Query(value = "SELECT \"idLef\", \"STATUS\" FROM VALIDATED_LEF", nativeQuery = true)
    Iterable<ValidatedLEF> findLEF();
}
