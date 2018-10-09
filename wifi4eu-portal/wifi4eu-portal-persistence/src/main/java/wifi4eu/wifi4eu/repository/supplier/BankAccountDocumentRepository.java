package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.BankAccountDocument;

import java.util.List;

public interface BankAccountDocumentRepository extends CrudRepository<BankAccountDocument,Integer> {

    List<BankAccountDocument> findBySupplierIdOrderByAccountId(int supplierId);
}
