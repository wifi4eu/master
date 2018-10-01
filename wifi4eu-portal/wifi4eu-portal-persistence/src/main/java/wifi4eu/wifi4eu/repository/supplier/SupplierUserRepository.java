package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;

import java.util.List;

public interface SupplierUserRepository extends CrudRepository<SupplierUser, Integer> {

    SupplierUser findFirstSupplierUserBySupplierIdAndEmail(@Param("supplierId") int supplierId, @Param("email") String email);

    List<SupplierUser> findByEmailAndStatus(@Param("email") String email, @Param("status") Integer status);

    List<SupplierUser> findByEmail(@Param("email") String email);

    List<SupplierUser> findByEmailAndSupplierId(@Param("email") String email, @Param("supplierId") Integer supplierId);

    @Query(value = "SELECT user_id FROM supplier_users WHERE supplier_id = ?1 AND main = 1", nativeQuery = true)
    int findUserIdBySupplierId(int supplierId);

    int countByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE supplier_users WHERE supplier_id = ?1", nativeQuery = true)
    void deleteBySupplierId(@Param("supplierId") Long supplierId);

    List<SupplierUser> findByUserId(@Param("status") Integer userId);

    Integer countSupplierUserBySupplierIdAndStatusNot(Integer supplierId, Integer notStatus);

    SupplierUser findByUserIdAndSupplierId(Integer userId, Integer supplierId);
}
