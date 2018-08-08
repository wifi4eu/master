package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wifi4eu.wifi4eu.abac.data.dto.IMonitoringRowProjection;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {
	@Query(value = "SELECT c FROM Country c WHERE c.euMember = 'Y' ORDER BY c.name")
	List<Country> findCountries();
}
