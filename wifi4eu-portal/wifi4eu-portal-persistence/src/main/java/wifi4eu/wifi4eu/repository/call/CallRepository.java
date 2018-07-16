package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.Call;

public interface CallRepository extends CrudRepository<Call,Integer> {

    @Query(value = "SELECT * FROM calls WHERE (CONVERT(bigint, getdate(), 121) BETWEEN start_date AND end_date)", nativeQuery = true)
    Call findCurrentCall();
}