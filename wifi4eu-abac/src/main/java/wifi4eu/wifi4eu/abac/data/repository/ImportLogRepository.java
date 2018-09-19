package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.ImportLog;

public interface ImportLogRepository extends CrudRepository<ImportLog, Long> {
	
	public List<ImportLog> findByBatchRef(String batchRef);
}
