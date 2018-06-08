package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.supplier.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Supplier findByUserId(Integer userId);
    Iterable<Supplier> findByVat(String vat);
    Iterable<Supplier> findByAccountNumber(String accountNumber);

    Page<Supplier> findByNameContainingIgnoreCase(Pageable pageable, String name);
    Long countByNameContainingIgnoreCase(String name);

    @Query("SELECT distinct s.name FROM SuppliedRegion sr JOIN sr.region r JOIN sr.supplier s WHERE r.id = :regionId ORDER BY s.name")
    Page<String> findSuppliersByRegion(@Param("regionId") int regionId, Pageable pageable);

    @Query("SELECT distinct s.name FROM SuppliedRegion sr JOIN sr.region r JOIN sr.supplier s WHERE r.countryCode = :countryCode ORDER BY s.name")
    Page<String> findSuppliersByCountryCode(@Param("countryCode") String countryCode, Pageable pageable);

    // HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
/*     @Query("SELECT distinct s.name FROM SuppliedRegion sr JOIN sr.region r JOIN sr.supplier s WHERE r.countryCode = :countryCode ORDER BY s.name")
    Page<String> findSuppliersByCountryCode(@Param("countryCode") String countryCode, Pageable pageable); */
}