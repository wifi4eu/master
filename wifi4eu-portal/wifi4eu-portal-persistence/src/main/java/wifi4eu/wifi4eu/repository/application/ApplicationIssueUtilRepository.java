package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.ApplicationIssueUtil;

import java.util.List;

public interface ApplicationIssueUtilRepository extends CrudRepository<ApplicationIssueUtil,Integer> {
    @Query(value = "select r.id as id, l.country_code as countryCode, u.email as userEmail, u.ecas_email as userEcasEmail, " +
            "u.lang as userLang, may.email as mayorEmail, a._status as status from laus l \n" +
            "inner join municipalities m on m.lau = l.id \n" +
            "inner join registrations r on r.municipality = m.id \n" +
            "inner join applications a on r.id = a.registration \n" +
            "inner join users u on r._user = u.id\n" +
            "inner join mayors may on may.municipality = m.id where l.id = ?#{[0]}", nativeQuery = true)
    List<ApplicationIssueUtil> findApplicationIssueUtilByLauId(Integer lauId);

    @Query(value = "select r.id as id, l.country_code as countryCode, u.email as userEmail, u.ecas_email as userEcasEmail, " +
            "u.lang as userLang, may.email as mayorEmail, a._status as status from laus l \n" +
            "inner join municipalities m on m.lau = l.id \n" +
            "inner join registrations r on r.municipality = m.id \n" +
            "inner join applications a on r.id = a.registration \n" +
            "inner join users u on r._user = u.id\n" +
            "inner join mayors may on may.municipality = m.id where r.id = ?#{[0]}", nativeQuery = true)
    ApplicationIssueUtil findApplicationIssueUtilByRegistrationId(Integer registrationId);

}
