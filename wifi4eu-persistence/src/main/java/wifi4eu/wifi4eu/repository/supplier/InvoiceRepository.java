package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.Invoice;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
