package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.Call;

import java.util.List;

public interface CallRepository extends CrudRepository<Call,Integer> {

}