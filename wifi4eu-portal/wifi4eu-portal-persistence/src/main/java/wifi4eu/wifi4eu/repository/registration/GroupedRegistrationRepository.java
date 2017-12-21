package wifi4eu.wifi4eu.repository.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.registration.GroupedRegistration;

public interface GroupedRegistrationRepository extends CrudRepository<GroupedRegistration,Integer> {
    @Query(value = "" +
        "select id, country, municipality, applicants, CASE WHEN posts is NULL THEN 0 ELSE posts END as posts, status" +
            "from (" +
                "select * from (" +
                    "select r.id, m.country, m.name as municipality, count(m.name) as applicants, r._status as status" +
                    "from registrations as r, municipalities as m" +
                    "where r.municipality = m.id" +
                    "group by m.name" +
                ") as t1" +
        "left join (" +
            "select count(m.thread) as posts, t.title" +
            "from threads as t, thread_messages as m" +
            "where t.id = m.thread" +
            "group by m.thread) as t2" +
            "on t1.municipality = t2.title" +
        ") as beneficiaries;", nativeQuery = true)
    Iterable<GroupedRegistration> findAllGroupedRegistrations();
}