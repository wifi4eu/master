package wifi4eu.wifi4eu.apply.localEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<ApplicationSQLite, Long> {
	
	Page<ApplicationSQLite> findAll(Pageable pageable);

}
