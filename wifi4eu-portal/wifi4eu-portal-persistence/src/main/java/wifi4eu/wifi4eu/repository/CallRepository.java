package wifi4eu.wifi4eu.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.Call;

public interface CallRepository extends CrudRepository<Call,Integer> {
}