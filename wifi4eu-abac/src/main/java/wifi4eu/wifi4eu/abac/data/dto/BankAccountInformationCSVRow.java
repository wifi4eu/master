package wifi4eu.wifi4eu.abac.data.dto;

public class BankAccountInformationCSVRow {

	private Long bafId;
	private String accountName;
	private String address;
	private String city;
	private String postalCode;
	private String countryCode;
	private String iban;
	private String swiftCode;
	private String bankName;
	private String bankAddress;
	private String bankCity;
	private String bankPostalCode;
	private String bankCountryCode;
	
	public Long getBafId() {
		return bafId;
	}

	public void setBafId(Long bafId) {
		this.bafId = bafId;
	}

	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getIban() {
		return iban;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getBankPostalCode() {
		return bankPostalCode;
	}

	public void setBankPostalCode(String bankPostalCode) {
		this.bankPostalCode = bankPostalCode;
	}

	public String getBankCountryCode() {
		return bankCountryCode;
	}

	public void setBankCountryCode(String bankCountryCode) {
		this.bankCountryCode = bankCountryCode;
	}
}
