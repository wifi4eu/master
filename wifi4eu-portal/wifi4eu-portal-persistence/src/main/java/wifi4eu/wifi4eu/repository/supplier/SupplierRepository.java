package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.supplier.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Supplier findByUserId(Integer userId);
    Iterable<Supplier> findByVat(String vat);
    Iterable<Supplier> findByAccountNumber(String accountNumber);

    Page<Supplier> findByNameContainingIgnoreCase(Pageable pageable, String name);
    Long countByNameContainingIgnoreCase(String name);
}