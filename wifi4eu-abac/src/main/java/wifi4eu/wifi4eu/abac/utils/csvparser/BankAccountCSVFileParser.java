package wifi4eu.wifi4eu.abac.utils.csvparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import wifi4eu.wifi4eu.abac.data.Constants;
import wifi4eu.wifi4eu.abac.data.dto.BankAccountInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BankAccount;
import wifi4eu.wifi4eu.abac.data.enums.BankAccountCSVColumn;
import wifi4eu.wifi4eu.abac.utils.CSVStringCreator;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

@Component
public class BankAccountCSVFileParser extends AbstractCSVFileParser {
	
	@Override
	protected void validateColumns(CSVParser csvParser) {
		super.validateColumns(csvParser,
			BankAccountCSVColumn.BANK_ACCOUNT_PORTAL_ID,
			BankAccountCSVColumn.BANK_ACCOUNT_NAME,
			BankAccountCSVColumn.BANK_ACCOUNT_ADDRESS,
			BankAccountCSVColumn.BANK_ACCOUNT_CITY,
			BankAccountCSVColumn.BANK_ACCOUNT_COUNTRY_CODE,
			BankAccountCSVColumn.BANK_ACCOUNT_POSTAL_CODE,
			BankAccountCSVColumn.BANK_ACCOUNT_BANK_NAME,
			BankAccountCSVColumn.BANK_ACCOUNT_BANK_ADDRESS,
			BankAccountCSVColumn.BANK_ACCOUNT_BANK_CITY,
			BankAccountCSVColumn.BANK_ACCOUNT_BANK_COUNTRY_CODE,
			BankAccountCSVColumn.BANK_ACCOUNT_BANK_POSTAL_CODE,
			BankAccountCSVColumn.BANK_ACCOUNT_IBAN,
			BankAccountCSVColumn.BANK_ACCOUNT_SWIFT_CODE
		);
	}

	@Override
	protected List<BankAccountInformationCSVRow> mapRowsToEntities(CSVParser csvParser) {

		List<BankAccountInformationCSVRow> bankAccountRows = new ArrayList<>();

		for (CSVRecord csvRecord : csvParser) {

			BankAccountInformationCSVRow bankAccountInformationCSVRow = new BankAccountInformationCSVRow();
			bankAccountInformationCSVRow.setBafId(
				StringUtils.isEmpty(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_PORTAL_ID)) ? null : Long.parseLong(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_PORTAL_ID))
			);
			bankAccountInformationCSVRow.setAccountName(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_NAME));
			bankAccountInformationCSVRow.setAddress(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_ADDRESS));
			bankAccountInformationCSVRow.setCity(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_CITY));
			bankAccountInformationCSVRow.setCountryCode(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_COUNTRY_CODE));
			bankAccountInformationCSVRow.setPostalCode(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_POSTAL_CODE));
			bankAccountInformationCSVRow.setBankName(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_BANK_NAME));
			bankAccountInformationCSVRow.setBankAddress(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_BANK_ADDRESS));
			bankAccountInformationCSVRow.setBankCity(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_BANK_CITY));
			bankAccountInformationCSVRow.setBankCountryCode(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_BANK_COUNTRY_CODE));
			bankAccountInformationCSVRow.setBankPostalCode(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_BANK_POSTAL_CODE));
			bankAccountInformationCSVRow.setIban(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_IBAN));
			bankAccountInformationCSVRow.setSwiftCode(csvRecord.get(BankAccountCSVColumn.BANK_ACCOUNT_SWIFT_CODE));
			bankAccountRows.add(bankAccountInformationCSVRow);
		}
		return bankAccountRows;
	}

	public String exportBankAccountToCSV(List<BankAccount> bankAccounts) {

		try {

			CSVStringCreator csv = new CSVStringCreator(CSVFormat.TDF.withHeader(
				BankAccountCSVColumn.BANK_ACCOUNT_PORTAL_ID.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_NAME.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_ADDRESS.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_CITY.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_COUNTRY_CODE.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_POSTAL_CODE.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_BANK_NAME.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_BANK_ADDRESS.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_BANK_CITY.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_BANK_COUNTRY_CODE.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_BANK_POSTAL_CODE.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_IBAN.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_SWIFT_CODE.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_ABAC_REFERENCE.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_ABAC_STATUS.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_DATE_EXPORTED.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_USER_EXPORTED.toString(),
				BankAccountCSVColumn.BANK_ACCOUNT_BATCH_REFERENCE.toString()
			)); 

			for (BankAccount bankAccount: bankAccounts) {
				csv.printRecord(
					bankAccount.getBafId(),
					bankAccount.getAccountName(),
					bankAccount.getAddress(),
					bankAccount.getCity(),
					bankAccount.getCountry().getIso2Code(),
					bankAccount.getPostalCode(),
					bankAccount.getBankName(),
					bankAccount.getBankAddress(),
					bankAccount.getBankCity(),
					bankAccount.getBankCountry().getIso2Code(),
					bankAccount.getBankPostalCode(),
					bankAccount.getIban(),
					bankAccount.getSwiftCode(),
					bankAccount.getAbacRef(),
					bankAccount.getWfStatus(),
					DateTimeUtils.format(bankAccount.getDateExported(), Constants.PORTAL_CSV_DATETIME_FORMAT),
					bankAccount.getUserExported(),
					bankAccount.getBatchRef()
				);
			}

			return csv.closeAndGenerateString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
