package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query(value = "SELECT s.* FROM suppliers s INNER JOIN supplier_users su ON s.id = su.supplier_id WHERE su.user_id = ?1 AND su.main = 1", nativeQuery = true)
    Supplier getSupplierByMainUserId(int userId);

    @Query(value = "SELECT s.* FROM suppliers s INNER JOIN supplier_users su ON s.id = su.supplier_id WHERE su.user_id = ?1", nativeQuery = true)
    Supplier getByUserId(int userId);

    @Query(value = "SELECT s.* FROM suppliers s INNER JOIN supplier_users su ON su.supplier_id = s.id WHERE su.user_id = ?#{[0]} AND s.id = ?#{[1]}", nativeQuery = true)
    Supplier findByUserIdAndSupplierId(Integer userId, Integer municipalityId);

    Iterable<Supplier> findByVat(String vat);

    Iterable<Supplier> findByAccountNumber(String accountNumber);

    Page<Supplier> findByNameContainingIgnoreCase(Pageable pageable, String name);

    Long countByNameContainingIgnoreCase(String name);

    @Query("SELECT distinct s.name FROM SuppliedRegion sr JOIN sr.region r JOIN sr.supplier s WHERE r.id = :regionId ORDER BY s.name")
    Page<String> findSuppliersByRegion(@Param("regionId") int regionId, Pageable pageable);

    @Query("SELECT distinct s.name FROM SuppliedRegion sr JOIN sr.region r JOIN sr.supplier s WHERE r.countryCode = :countryCode ORDER BY s.name")
    Page<String> findSuppliersByCountryCode(@Param("countryCode") String countryCode, Pageable pageable);

    @Query(value = "SELECT * FROM suppliers WHERE id != ?#{[0]} and (vat = (SELECT vat FROM suppliers where id = ?#{[0]}) OR account_number = (SELECT account_number FROM suppliers where id = ?#{[0]}))", nativeQuery = true)
    List<Supplier> findSimilarSuppliers(Integer supplierId);
}