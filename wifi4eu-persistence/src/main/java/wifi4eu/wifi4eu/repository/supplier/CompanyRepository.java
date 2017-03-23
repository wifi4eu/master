package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.Company;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
