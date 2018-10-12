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
		if (StringUtils.isEmpty(bankAccount.getAddress())) throw new RuntimeException("Account Address is empty");
		if (StringUtils.isEmpty(bankAccount.getCity())) throw new RuntimeException("Account City is empty");
		if (bankAccount.getPostalCode() != null && bankAccount.getPostalCode().length() > 10) throw new RuntimeException("Account Postal Code should be up to 10 digits");
		if (bankAccount.getCountry() == null) throw new RuntimeException("Account Country is empty or invalid");
		if (StringUtils.isEmpty(bankAccount.getBankName())) throw new RuntimeException("Bank Name is empty");
		if (StringUtils.isEmpty(bankAccount.getBankAddress())) throw new RuntimeException("Bank Address is empty");
		if (StringUtils.isEmpty(bankAccount.getBankCity())) throw new RuntimeException("Bank City is empty");
		if (bankAccount.getBankPostalCode() != null && bankAccount.getBankPostalCode().length() > 10) throw new RuntimeException("Bank Postal Code should be up to 10 digits");
		if (bankAccount.getBankCountry() == null) throw new RuntimeException("Bank Country is empty or invalid");
		if (StringUtils.isEmpty(bankAccount.getIban())) throw new RuntimeException("IBAN is empty");
		if (StringUtils.isEmpty(bankAccount.getSwiftCode())) throw new RuntimeException("Swift code is empty");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public BankAccount saveBankAccount(BankAccount bankAccount) {
		validate(bankAccount);
		bankAccount.setAbacLatinName(XCharacterDecoder.decode(bankAccount.getAccountName()));
		bankAccount.setAbacLatinAddress(XCharacterDecoder.decode(bankAccount.getAddress()));
		bankAccount.setAbacLatinCity(XCharacterDecoder.decode(bankAccount.getCity()));
		bankAccount.setAbacLatinBankName(XCharacterDecoder.decode(bankAccount.getBankName()));
		bankAccount.setAbacLatinBankAddress(XCharacterDecoder.decode(bankAccount.getBankAddress()));
		bankAccount.setAbacLatinBankCity(XCharacterDecoder.decode(bankAccount.getBankCity()));
		return bankAccountRepository.save(bankAccount);
	}
	
	public BankAccount mapBankAccountCSVToEntity(BankAccountInformationCSVRow bankAccountInformationCSVRow) {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.setBafId(bankAccountInformationCSVRow.getBafId());
		bankAccount.setAccountName(bankAccountInformationCSVRow.getAccountName());
		bankAccount.setAddress(bankAccountInformationCSVRow.getAddress());
		bankAccount.setCity(bankAccountInformationCSVRow.getCity());
		bankAccount.setPostalCode(bankAccountInformationCSVRow.getPostalCode());
		Country country = countryService.getCountryByISOCode(bankAccountInformationCSVRow.getCountryCode());
		bankAccount.setCountry(country);
		bankAccount.setBankName(bankAccountInformationCSVRow.getBankName());
		bankAccount.setBankAddress(bankAccountInformationCSVRow.getBankAddress());
		bankAccount.setBankCity(bankAccountInformationCSVRow.getBankCity());
		bankAccount.setBankPostalCode(bankAccountInformationCSVRow.getBankPostalCode());
		Country bankCountry = countryService.getCountryByISOCode(bankAccountInformationCSVRow.getBankCountryCode());
		bankAccount.setBankCountry(bankCountry);
		bankAccount.setIban(bankAccountInformationCSVRow.getIban());
		bankAccount.setSwiftCode(bankAccountInformationCSVRow.getSwiftCode());
		return bankAccount;
	}
	
	public List<BankAccount> getAllBankAccountForExport() {
		return bankAccountRepository.findBankAccountsProcessedInAbac();
	}
	
	public BankAccount getBankAccountByBankAccountPortalId(Long bankAccountPortalId) {
		return bankAccountRepository.findByBafId(bankAccountPortalId);
	}

}
