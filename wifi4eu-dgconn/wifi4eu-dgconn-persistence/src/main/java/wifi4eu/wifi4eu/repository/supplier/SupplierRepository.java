package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    Long countByNameContainingIgnoreCase(String name);

    @Query(value = "SELECT * FROM suppliers " +
            "WHERE id != ?#{[0]} " +
            "and (vat = (SELECT vat FROM suppliers where id = ?#{[0]}) OR account_number = (SELECT account_number FROM suppliers where id = ?#{[0]}))" +
            "ORDER BY suppliers.id DESC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY",
            nativeQuery = true)
    List<Supplier> findSimilarSuppliersPaged(Integer supplierId, Integer offset, Integer size);

    @Query(value = "SELECT count(*) FROM suppliers " +
            "WHERE id != ?#{[0]} " +
            "and (vat = (SELECT vat FROM suppliers where id = ?#{[0]}) OR account_number = (SELECT account_number FROM suppliers where id = ?#{[0]}))",
            nativeQuery = true)
    Integer countSimilarSuppliersPaged(Integer supplierId);

}
