package wifi4eu.wifi4eu.repository.location;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.location.NutCallCustom;

import java.util.ArrayList;

public interface NutCallCustomRepository extends CrudRepository<NutCallCustom,Integer> {

    @Query(value = "SELECT DISTINCT n.id, c.event, n.label FROM calls c " +
            "INNER JOIN applications a ON a.call_id = c.id " +
            "INNER JOIN registrations r ON a.registration = r.id " +
            "INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE c.id = ?1 AND n.level = 0", nativeQuery = true)
    ArrayList<NutCallCustom> findNutsByCall(int idCall);

    @Query(value = "SELECT DISTINCT n.id, c.event, n.label FROM calls c " +
            "INNER JOIN applications a ON a.call_id = c.id " +
            "INNER JOIN registrations r ON a.registration = r.id " +
            "INNER JOIN municipalities m ON r.municipality = m.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "INNER JOIN nuts n ON n.country_code = l.country_code " +
            "WHERE c.start_date < cast(Datediff(s, '1970-01-01', GETUTCDATE()) AS bigint)*1000 AND n.level = 0", nativeQuery = true)
    ArrayList<NutCallCustom> findNutsUsedFromTopCurrentCall();

}
