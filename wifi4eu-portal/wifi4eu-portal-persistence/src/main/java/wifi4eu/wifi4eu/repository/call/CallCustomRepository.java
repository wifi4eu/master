package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.CallCustom;


public interface CallCustomRepository extends CrudRepository<CallCustom,Integer> {

    @Query(value = "SELECT id,event,start_date,end_date FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    CallCustom findCurrentCall();

    @Query(value = "SELECT TOP 1 id,event,start_date,end_date FROM calls WHERE start_date > cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 ORDER BY start_date ASC", nativeQuery = true)
    CallCustom findNearestCall();
}
