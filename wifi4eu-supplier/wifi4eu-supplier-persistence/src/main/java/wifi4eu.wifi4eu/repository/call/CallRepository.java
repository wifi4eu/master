package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.Call;

public interface CallRepository extends CrudRepository<Call, Integer> {
}