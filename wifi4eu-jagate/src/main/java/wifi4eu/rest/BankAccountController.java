package wifi4eu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wifi4eu.model.BankAccount;
import wifi4eu.service.BankAccountService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {
	
	@Autowired BankAccountService bankAccountService;
	
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<BankAccount> listBankAccounts() {
    	List<BankAccount> bankAccounts = bankAccountService.listAllBankAccounts();
    	return bankAccounts;
    }
}
