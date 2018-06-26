package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.SupplierNotificationEmail;

// import java.util.List;

public interface SupplierNotificationEmailRepository extends CrudRepository<SupplierNotificationEmail, Integer> {
    @Query(value = "SELECT r.id AS registrationId, s.contact_email AS supplierEmail, m.id AS municipalityId, m.name AS municipalityName, m.country AS municipalityCountry, u.lang AS userLang " +
    "FROM registrations r \n" +
    "INNER JOIN applications a ON a.registration = r.id \n" +
    "INNER JOIN suppliers s ON s.id = a.supplier \n" +
    "INNER JOIN municipalities m ON m.id = r.municipality \n" +
    "INNER JOIN users u ON u.id = r._user \n" +
    "WHERE m.id = ?#{[0]}", nativeQuery = true)
    SupplierNotificationEmail findSupplierNotificationEmailDetailsByMunicipalityId(Integer municipalityId);
}