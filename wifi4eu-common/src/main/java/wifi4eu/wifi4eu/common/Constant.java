package wifi4eu.wifi4eu.common;

public abstract class Constant {

	//public static final String USER = "USER";
	public static final String USER = "edu.yale.its.tp.cas.client.filter.user";
	public static final String FORM = "FORM";

	public static final long ROLE_DEACTIVATED = -1;
	public static final long ROLE_SUPPLIER = 1;
	public static final long ROLE_SUPPLIER_CONTACT = 2;
	public static final long ROLE_REPRESENTATIVE = 3;
	public static final long ROLE_REPRESENTATIVE_CONTACT = 4;
	public static final long ROLE_DGCONN = 5;


	public static final String DATE_FORMAT = "dd/MM/yyyy";	
	public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";

	public static final int THREAD_REASON_LAU = 1;
	public static final int THREAD_REASON_VAT = 2;
	public static final int THREAD_REASON_IBAN = 3;

	//HELPDESK
	public static final String BROWSER = "+User+App+-+Mozilla%2F5.0+%28X11%3B+Linux+x86_64%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F64.0.3282.186+Safari%2F537.36";
	public static final String GENDER_DEFAULT = "M";
	public static final String FIRSTNAME_DEFAULT = "notRegisteredName";
	public static final String LASTNAME_DEFAULT = "notRegisteredSurname";
	public static final String EMAIL_DEFAULT = "notRegistered@domain.com";
	public static final String NATIONALITY_DEFAULT = "BE";
	public static final String ECOM_CATEG_DEFAULT = "Government (local, regional, national, European)";
	public static final String PREF_LANG_DEFAULT = "en";

	//EMAIL LOG
	public static final String LOG_EMAIL_ACTION_SEND_CORRECTION_EMAILS = "sendCorrectionEmails";

	public static final String REPORTING_CALL_OPEN = "call_open";
	public static final String REPORTING_PRE_SELECTION = "pre_selection";
	public static final String REPORTING_NOTIFICATIONS_SENT_OUT = "notifications_sent_out";
	public static final String REPORTING_TIME_TO_INFORM = "time_to_inform";
	public static final String REPORTING_TYPES_INSTALLATION_REPORT = "types_IR";
	public final static String REPORTING_DEFAULT_LANG = "en";
}
