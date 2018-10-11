package wifi4eu.wifi4eu.abac.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import wifi4eu.wifi4eu.abac.data.dto.BankAccountInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BankAccount;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.repository.BankAccountRepository;
import wifi4eu.wifi4eu.abac.utils.XCharacterDecoder;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private CountryService countryService;

	public BankAccountService() {
	}
	
	//TODO This should be refactored to use javax validation.
	private void validate(BankAccount bankAccount) {
		if (StringUtils.isEmpty(bankAccount.getAccountName())) throw new RuntimeException("Account Name is empty");
		if (StringUtils.isEmpty(bankAccount.getBankName())) throw new RuntimeException("Bank Name is empty");
		if (StringUtils.isEmpty(bankAccount.getAddress())) throw new RuntimeException("Address is empty");
		if (StringUtils.isEmpty(bankAccount.getCity())) throw new RuntimeException("City is empty");
		if (bankAccount.getCountry() == null) throw new RuntimeException("Country is empty or invalid");
		if (StringUtils.isEmpty(bankAccount.getIban())) throw new RuntimeException("IBAN is empty");
		if (bankAccount.getPostalCode() != null && bankAccount.getPostalCode().length() > 10) throw new RuntimeException("Postal code should be up to 10 digits");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public BankAccount saveBankAccount(BankAccount bankAccount) {

		validate(bankAccount);

		if(StringUtils.isEmpty(bankAccount.getAbacLatinName())){
			bankAccount.setAbacLatinName(XCharacterDecoder.decode(bankAccount.getAccountName()));
		}
		bankAccount.setAbacLatinAddress(XCharacterDecoder.decode(bankAccount.getAddress()));

		return bankAccountRepository.save(bankAccount);
	}
	
	public BankAccount mapBankAccountCSVToEntity(BankAccountInformationCSVRow bankAccountInformationCSVRow) {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.setBafId(bankAccountInformationCSVRow.getBafId());
		bankAccount.setAccountName(bankAccountInformationCSVRow.getAccountName());
		bankAccount.setBankName(bankAccountInformationCSVRow.getBankName());
		bankAccount.setAddress(bankAccountInformationCSVRow.getAddress());
		bankAccount.setCity(bankAccountInformationCSVRow.getCity());
		bankAccount.setIban(bankAccountInformationCSVRow.getIban());
		bankAccount.setPostalCode(bankAccountInformationCSVRow.getPostalCode());
		Country country = countryService.getCountryByISOCode(bankAccountInformationCSVRow.getCountryCode());
		bankAccount.setCountry(country);

		return bankAccount;
	}
	
	public List<BankAccount> getAllBankAccountForExport() {
		return bankAccountRepository.findBankAccountsProcessedInAbac();
	}
	
	public BankAccount getBankAccountByBankAccountPortalId(Long bankAccountPortalId) {
		return bankAccountRepository.findByBafId(bankAccountPortalId);
	}

}
