package wifi4eu.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import wifi4eu.model.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
	
	public List<BankAccount> findByOrderByAccountHolderName();
}
