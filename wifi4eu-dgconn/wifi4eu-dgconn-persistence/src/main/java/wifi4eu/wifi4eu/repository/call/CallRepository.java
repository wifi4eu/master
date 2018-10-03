package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.call.Call;

import java.util.ArrayList;
import java.util.List;

public interface CallRepository extends CrudRepository<Call,Integer> {

    @Query(value = "SELECT * FROM calls " +
            "WHERE end_date < cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 OR " +
            "cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    ArrayList<Call> findCallsIncludeCurrent();

    @Query(value = "SELECT event FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    String getNameCurrentCall();

    @Query(value = "SELECT id FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    Integer getIdCurrentCall();

    @Query(value = "SELECT * FROM calls WHERE end_date < cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000", nativeQuery = true)
    List<Call> findAllCallsClosed();

    @Query(value = "SELECT c.* FROM calls c INNER JOIN voucher_assignments va ON va.call = c.id WHERE end_date < cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 AND va.status = 3", nativeQuery = true)
    List<Call> findAllCallsClosedNotified();

    @Query(value = "SELECT COUNT(*) FROM calls c INNER JOIN voucher_assignments va ON va.call = c.id WHERE end_date < cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 AND va.status = 3", nativeQuery = true)
    Integer countCallsClosedNotified();
}