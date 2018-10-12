package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;

public interface SupplierUserRepository extends CrudRepository<SupplierUser,Integer> {

    @Query(value = "SELECT user_id FROM supplier_users WHERE supplier_id = ?1 AND main = 1", nativeQuery = true)
    int findUserIdBySupplierId(int supplierId);
}
