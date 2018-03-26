package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryList;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BeneficiaryRepository extends Repository<Object, Integer> {

    @Query(value = "SELECT DISTINCT(m1.name) as name, l.id as lauId, l.country_code, (SELECT COUNT(1) FROM municipalities WHERE municipalities.name = m1.name) as counter, (SELECT CASE WHEN count(1) > 0 THEN 1 ELSE 0 END FROM applications app INNER JOIN registrations reg ON app.id = reg.id AND reg.municipality = m1.id) AS status, (SELECT CASE WHEN sum(th.mediation) > 0 THEN 1 ELSE 0 END FROM threads th INNER JOIN user_threads userth on th.id = userth.thread INNER JOIN registrations reg on reg._user = userth._user INNER JOIN municipalities m2 on reg.municipality = m2.id WHERE m2.id = m1.id) AS mediation FROM municipalities m1 INNER JOIN laus l ON l.id = m1.lau WHERE m1.name IS NOT null")
    List<BeneficiaryList> findBeneficiaryListAll(Pageable pageRequest);


}
