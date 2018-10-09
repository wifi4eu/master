package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;

import java.util.List;

public interface SupplierUserRepository extends CrudRepository<SupplierUser,Integer> {

    List<SupplierUser> findByEmailAndSupplierId(@Param("email") String email, @Param("supplierId") Integer supplierId);

    @Query(value = "SELECT user_id FROM supplier_users WHERE supplier_id = ?1 AND main = 1", nativeQuery = true)
    int findUserIdBySupplierId(int supplierId);

    @Modifying
    @Transactional
    @Query(value = "DELETE supplier_users WHERE supplier_id = ?1", nativeQuery = true)
    void deleteBySupplierId(@Param("supplierId") Long supplierId);
}
