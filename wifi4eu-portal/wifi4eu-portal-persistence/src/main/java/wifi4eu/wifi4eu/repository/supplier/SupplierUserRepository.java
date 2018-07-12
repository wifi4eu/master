package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;

public interface SupplierUserRepository extends CrudRepository<SupplierUser,Integer> {

    SupplierUser findFirstSupplierUserBySupplierIdAndEmail(@Param("supplierId") int supplierId , @Param("email") String email);

    int countByEmail(@Param("email") String email);
}
