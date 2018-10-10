package wifi4eu.wifi4eu.repository.call;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.call.Call;

import java.util.ArrayList;

public interface CallRepository extends JpaRepository<Call,Integer> {

    @Query(value = "SELECT * FROM calls " +
            "WHERE end_date < cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 OR " +
            "cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    ArrayList<Call> findCallsIncludeCurrent();

    @Query(value = "SELECT event FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    String getNameCurrentCall();

    @Query(value = "SELECT id FROM calls WHERE cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 BETWEEN start_date AND end_date", nativeQuery = true)
    Integer getIdCurrentCall();
}