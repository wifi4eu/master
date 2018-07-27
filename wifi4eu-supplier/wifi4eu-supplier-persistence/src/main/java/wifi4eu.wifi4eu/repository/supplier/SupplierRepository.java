package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
    @Query(value = "SELECT s.* FROM suppliers s " +
            "INNER JOIN supplier_users su ON s.id = su.supplier_id WHERE su.user_id = ?1", nativeQuery = true)
    Supplier findByUserId(Integer userId);

    @Query(value = "SELECT user_id FROM supplier_users WHERE supplier_id = ?1 AND main = 1", nativeQuery = true)
    Integer findMainSupplierByUserId(int id);
}