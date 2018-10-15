package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.JpaRepository;
import wifi4eu.wifi4eu.entity.exportImport.GlobalCommitment;

import java.util.List;

public interface GlobalCommitmentRepository extends JpaRepository<GlobalCommitment, Integer> {

    List<GlobalCommitment> findAllByOrderByPriority();

}
