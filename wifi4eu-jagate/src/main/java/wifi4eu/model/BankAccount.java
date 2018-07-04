package wifi4eu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="ACC_HOLDER_NAME")
	private String accountHolderName;
	
	@Column(name="ACC_HOLDER_ADDRESS_STR")
	private String accountHolderAddressStreet;
	
	@Column(name="ACC_HOLDER_CITY")
	private String accountHolderCity;
	
	@Column(name="ACC_HOLDER_POSTCODE")
	private String accountHolderPostCode;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ACC_HOLDER_COUNTRY_CD")
	private Country accountHolderCountry;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BANK_COUNTRY_CD")	
	private Country bankCountry;
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	@Column(name="BANK_BIC_SWIFT_CD")
	private String bankBicSwiftCode;
	
	@Column(name="BANK_ADDRESS_STR")
	private String bankAddressStreet;
	
	@Column(name="BANK_CITY")
	private String bankCity;
	
	@Column(name="BANK_POSTCODE")
	private String bankPostCode;
	
	@Column(name="ACC_NAME")
	private String accountName;
	
	@Column(name="ACC_IBAN")
	private String accountIban;
	
	@Column(name="ACC_NUMBER")
	private String accountNumber;
	
	@Column(name="ACC_BRANCH_CD")
	private String accountBranchCode;
	
	@Column(name="BAF_ID")
	private String bafId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderAddressStreet() {
		return accountHolderAddressStreet;
	}

	public void setAccountHolderAddressStreet(String accountHolderAddressStreet) {
		this.accountHolderAddressStreet = accountHolderAddressStreet;
	}

	public String getAccountHolderCity() {
		return accountHolderCity;
	}

	public void setAccountHolderCity(String accountHolderCity) {
		this.accountHolderCity = accountHolderCity;
	}

	public String getAccountHolderPostCode() {
		return accountHolderPostCode;
	}

	public void setAccountHolderPostCode(String accountHolderPostCode) {
		this.accountHolderPostCode = accountHolderPostCode;
	}

	public Country getAccountHolderCountry() {
		return accountHolderCountry;
	}

	public void setAccountHolderCountry(Country accountHolderCountry) {
		this.accountHolderCountry = accountHolderCountry;
	}

	public Country getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(Country bankCountry) {
		this.bankCountry = bankCountry;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBicSwiftCode() {
		return bankBicSwiftCode;
	}

	public void setBankBicSwiftCode(String bankBicSwiftCode) {
		this.bankBicSwiftCode = bankBicSwiftCode;
	}

	public String getBankAddressStreet() {
		return bankAddressStreet;
	}

	public void setBankAddressStreet(String bankAddressStreet) {
		this.bankAddressStreet = bankAddressStreet;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getBankPostCode() {
		return bankPostCode;
	}

	public void setBankPostCode(String bankPostCode) {
		this.bankPostCode = bankPostCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountIban() {
		return accountIban;
	}

	public void setAccountIban(String accountIban) {
		this.accountIban = accountIban;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountBranchCode() {
		return accountBranchCode;
	}

	public void setAccountBranchCode(String accountBranchCode) {
		this.accountBranchCode = accountBranchCode;
	}

	public String getBafId() {
		return bafId;
	}

	public void setBafId(String bafId) {
		this.bafId = bafId;
	}

}
