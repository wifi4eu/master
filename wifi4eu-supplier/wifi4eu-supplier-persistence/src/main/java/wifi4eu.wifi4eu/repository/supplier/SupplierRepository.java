package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier,Integer> {
    Supplier findByUserId(Integer userId);
    Iterable<Supplier> findByVat(String vat);
    Iterable<Supplier> findByAccountNumber(String accountNumber);
}