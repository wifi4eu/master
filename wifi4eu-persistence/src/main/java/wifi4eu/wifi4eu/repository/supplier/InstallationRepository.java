package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.Installation;

import java.util.List;

public interface InstallationRepository extends CrudRepository<Installation, Long> {
}
