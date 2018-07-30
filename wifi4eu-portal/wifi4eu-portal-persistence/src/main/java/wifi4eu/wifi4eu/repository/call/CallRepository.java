package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.Call;

import java.util.List;

public interface CallRepository extends CrudRepository<Call,Integer> {
    @Query(value = "SELECT * FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    Call findCurrentCall();

    List<Call> findAllOrderByOrderByEndDateDesc();
}