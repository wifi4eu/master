package wifi4eu.wifi4eu.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.user.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    Iterable<User> findByType(Integer type);

    User findByEmail(String email);

    User findByEcasUsername(String ecasUsername);

    User findByEcasEmail(String email);

    @Query(value = "select u.* from users u inner join registration_users ru on ru._user = u.id where ru.main = 1 and ru.registration = ?#{[0]}", nativeQuery = true)
    User findMainUserFromRegistration(Integer registrationId);

    @Query(value = "select u.* from users u inner join registration_users ru on ru._user = u.id where ru.registration = ?#{[0]}", nativeQuery = true)
    List<User> findUsersByRegistrationId(Integer registrationId);

    @Query(value = "select u.* from users u inner join supplier_users su on su.user_id = u.id where su.supplier_id= ?#{[0]}", nativeQuery = true)
    List<User> findUsersBySupplierId(Integer supplierId);

    @Query(value = "SELECT a.voucher_awarded FROM applications a " +
            "INNER JOIN registration_users ru ON a.registration = ru.registration " +
            "WHERE ru._user = ?#{[0]}", nativeQuery = true)
    List<Integer> getIfUserHasVouchersAwarded(Integer userId);

    @Query(value = "SELECT  \n" +
            "    u.id AS userId,\n" +
            "    u.csrf_token AS csrfToken,\n" +
            "    CASE WHEN ca.status IS NULL THEN 0 ELSE 1 END AS acceptStatus,\n" +
            "    reg.id AS regId,\n" +
            "    mun.id AS munId,\n" +
            "    reg.allFiles_flag as docStatus \n" +
            "FROM users u \n" +
            "INNER JOIN registration_users ru ON u.id = ru._user\n" +
            "INNER JOIN registrations reg ON reg.id = ru.registration\n" +
            "OUTER APPLY \n" +
            "    (SELECT TOP 1 * FROM conditions_agreement WHERE user_id=u.id AND registration_id = reg.id ORDER BY change_status_date DESC) ca\n" +
            "INNER JOIN  municipalities mun ON mun.id = reg.municipality\n" +
            "WHERE u.id = ?#{[0]}", nativeQuery = true)
    List<Object[]> updateRedisInfo(Long userId);
}