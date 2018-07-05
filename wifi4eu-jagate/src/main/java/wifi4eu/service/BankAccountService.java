package wifi4eu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.dao.BankAccountRepository;
import wifi4eu.model.BankAccount;

@Service
public class BankAccountService {
	
	@Autowired private BankAccountRepository bankAccountRepository;
	
	public List<BankAccount> listAllBankAccounts() {		
		return bankAccountRepository.findByOrderByAccountHolderName();
	}
	
}
