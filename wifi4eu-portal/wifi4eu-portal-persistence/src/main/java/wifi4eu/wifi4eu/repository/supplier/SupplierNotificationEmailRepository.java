package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.SupplierNotificationEmail;

public interface SupplierNotificationEmailRepository extends CrudRepository<SupplierNotificationEmail, Integer> {
    @Query(value = "SELECT u.ecas_email AS supplierEmail, m.name AS municipalityName, m.country AS municipalityCountry, u.lang AS supplierLang " +
    "FROM registrations r \n" +
    "INNER JOIN supplier_users su ON su.supplier_id = ?#{[0]} \n" +
    "INNER JOIN municipalities m ON m.id = r.municipality \n" +
    "INNER JOIN users u ON u.id = su.user_id \n" +
    "WHERE r.id = ?#{[1]}", nativeQuery = true)
    SupplierNotificationEmail findSupplierNotificationEmailDetailsByMunicipalityId(int supplierId, int registrationId);
}