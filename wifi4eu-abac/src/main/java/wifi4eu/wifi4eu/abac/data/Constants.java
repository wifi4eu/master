package wifi4eu.wifi4eu.abac.data;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.ByteOrderMark;

public class Constants {

	public static final String MIME_TYPE_REST_RESPONE = "application/json";
	public static final String MIME_TYPE_PLAIN_TEXT_RESPONSE = "text/plain";
	public static final String MIME_TYPE_EXPORTED_DATA_FILES = "text/csv;charset=utf-16le";
	public static final String MIME_TYPE_EXPORTED_ZIP_FILES = "application/zip";
	
	public static final String IMPORT_LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "portal_exportBeneficiaryInformation.csv";
	public static final String IMPORT_LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "portal_exportBeneficiaryDocuments.csv";
	
	public static final String EXPORT_LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "airgap_exportBeneficiaryInformation.csv";
	public static final String EXPORT_BUDGETARY_COMMITMENT_INFORMATION_CSV_FILENAME = "airgap_exportBudgetaryCommitmentInformation.csv";
	public static final String EXPORT_LEGAL_COMMITMENT_INFORMATION_CSV_FILENAME = "airgap_exportLegalCommitmentInformation.csv";
	public static final String EXPORT_LEGAL_COMMITMENT_INFORMATION_ZIP_FILENAME = "airgap_exportLegalCommitments.zip";
	public static final String EXPORT_LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "airgap_exportBeneficiaryDocuments.csv";
	
	public static final String PORTAL_CSV_DATE_FORMAT = "yyyy-MM-dd";
	public static final String PORTAL_CSV_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final Charset CSV_FILES_ENCODING = StandardCharsets.UTF_16LE;
	public static final ByteOrderMark CSV_FILES_BOM = ByteOrderMark.UTF_16LE; 
}
