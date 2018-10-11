package wifi4eu.wifi4eu.abac.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wifi4eu.wifi4eu.abac.data.entity.BankAccount;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

public interface BankAccountRepository  extends CrudRepository<BankAccount, Integer> {

	BankAccount findById(Long id);
	
	BankAccount findByBafId(Long bafId);
	
	BankAccount findByAccountName(String accountName);
	
	@Query(value = "FROM BankAccount baf WHERE baf.wfStatus in ('ABAC_VALID', 'ABAC_ERROR' ,'ABAC_REJECTED') order by baf.dateExported desc, baf.batchRef desc, baf.accountName asc")
	List<BankAccount> findBankAccountsProcessedInAbac();
	
	List<BankAccount> findAllByWfStatusEquals(AbacWorkflowStatus wfStatus);

    List<BankAccount> findAllByWfStatusIn(List<AbacWorkflowStatus> wfStatuses);

}
