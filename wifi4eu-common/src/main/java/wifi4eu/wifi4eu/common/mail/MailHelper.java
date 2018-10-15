package wifi4eu.wifi4eu.common.mail;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import wifi4eu.wifi4eu.common.dto.mail.MailData;

public class MailHelper {
    private static final Logger _log = LogManager.getLogger(MailHelper.class);

    private static final int INOPERATION_LAST_WARNING_LIMIT = 56;

    private MailHelper() {

    }

    /**
     * Mail for Notification of inactivity after installation confirmation.
     * <p>
     * More details on:
     * https://webgate.ec.europa.eu/CITnet/confluence/display/EUWIFIOPS/3b.+Email+from+system+to+Beneficiary+to+notify+7+days+of+inoperation+after+Installation+confirmation
     *
     * @param email
     * @param name
     * @param locale
     * @return
     */
    public static MailData buildMailInoperationNotificationAfterInstallationConfirmation(String email, String name,
                                                                                         Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.inoperationInstallation.subject");
        String body = bundle.getString("mail.inoperationInstallation.body");
        String summary = bundle.getString("mail.inoperationInstallation.summary");
        MailData mailData = new MailData(email, name, subject, body, locale);
        mailData.setSummary(summary);

        return mailData;
    }

    /**
     * Mail for Installation site not operational.
     * <p>
     * More details on:
     * https://webgate.ec.europa.eu/CITnet/confluence/pages/viewpage.action?pageId=776245984
     *
     * @param email
     * @param name
     * @param numberOfDays
     * @param locale
     * @return
     */
    public static MailData buildMailInoperationNotification(String email, String name, int numberOfDays,
                                                            Locale locale) {
        if (email == null || email.isEmpty() || name == null || name.isEmpty() || numberOfDays == 0) {
            _log.info("something empty!");
            return null;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.inoperation.subject");
        String body = bundle.getString("mail.inoperation.body");
        body = String.format(body, numberOfDays);
        String summary = bundle.getString("mail.inoperation.summary");
        MailData mailData = new MailData(email, name, subject, body, locale);
        mailData.setSummary(summary);

        return mailData;
    }

    /**
     * Mail for Last call: Installation site not operational
     *
     * @param email
     * @param name
     * @param locale
     * @return
     */
    public static MailData buildMailLastCallInoperationNotification(String email, String name, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.inoperationLastWarning.subject");
        String body = bundle.getString("mail.inoperationLastWarning.body");
        body = String.format(body, INOPERATION_LAST_WARNING_LIMIT);
        String summary = bundle.getString("mail.inoperationLastWarning.summary");
        MailData mailData = new MailData(email, name, subject, body, locale);
        mailData.setSummary(summary);

        return mailData;
    }

    /**
     * Mail for Installation Site Confirmed
     *
     * @param email
     * @param name
     * @param locale
     * @return
     */
    public static MailData buildMailInstallationConfirmationNotification(String email, String name, Locale locale) {
        /**
         * NOTE: The functionality was using another labels when the refactoring was
         * applied, probably due to some user request.
         *
         * The original labels are:
         * <ul>
         * <li>mail.installationConfirmation.subject</li>
         * <li>mail.installationConfirmation.body</li>
         * <li>mail.installationConfirmation.summary</li>
         * </ul>
         *
         */
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.submission.subject");
        String body = bundle.getString("mail.submission.body");
        MailData mailData = new MailData(email, name, subject, body, locale);
        mailData.setSummary(subject);

        return mailData;
    }

    /**
     * Mail for Approval confirmation of your installation report by the beneficiary
     *
     * @param email
     * @param name
     * @param beneficiaryName
     * @param locale
     * @return
     */
    public static MailData buildMailInstallationConfirmationFromBeneficiary(String email, String name,
                                                                            String beneficiaryName, Locale locale) {
        /**
         * NOTE: The functionality was using another labels when the refactoring was
         * applied, probably due to some user request.
         *
         * The original labels are:
         * <ul>
         * <li>mail.installationConfirmationBeneficiary.subject</li>
         * <li>mail.installationConfirmationBeneficiary.body</li>
         * <li>mail.installationConfirmationBeneficiary.summary</li>
         * </ul>
         *
         */
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.confirmation.subject");
        String body = bundle.getString("mail.confirmation.body");
        MailData mailData = new MailData(email, name, subject + beneficiaryName, body, locale);
        mailData.setSummary(subject);

        return mailData;
    }

    /**
     * Mail for Revision request of your installation report by the beneficiary
     *
     * @param email
     * @param name
     * @param beneficiaryName
     * @param locale
     * @return
     */
    public static MailData buildMailInstallationRejectionFromBeneficiary(String email, String name,
                                                                         String beneficiaryName, Locale locale) {
        /**
         * NOTE: The functionality was using another labels when the refactoring was
         * applied, probably due to some user request.
         *
         * The original labels are:
         * <ul>
         * <li>mail.installationRejectionBeneficiary.subject</li>
         * <li>mail.installationRejectionBeneficiary.body</li>
         * <li>mail.installationRejectionBeneficiary.summary</li>
         * </ul>
         *
         */
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.revision.subject");
        String body = bundle.getString("mail.revision.body");
        MailData mailData = new MailData(email, name, subject + beneficiaryName, body, locale);
        mailData.setSummary(subject);

        return mailData;
    }

    /**
     * Mail for Download Report
     *
     * @param email
     * @param name
     * @param url
     * @param locale
     * @return
     */
    public static MailData buildMailReportingSystemCallOpen(String email, String name, String url, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.reporting.subject");
        String body1 = bundle.getString("mail.reporting.body");
        String body2 = bundle.getString("mail.reporting.body2");
        String body = body1 + "<br>" + url + "<br>" + body2;
        String summary = bundle.getString("mail.reporting.summary");
        MailData mailData = new MailData(email, name, subject, body, locale);
        mailData.setSummary(summary);

        return mailData;
    }

    /**
     * Mail for Application - received
     *
     * @param toAddress
     * @param fromAddress
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailCreateApplication(String toAddress, String fromAddress, int municipalityId, String municipalityName,
                                                      String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.voucherApply.subject");
        String body = bundle.getString("mail.voucherApply.body");
        body = MessageFormat.format(body, municipalityName);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * Mail for Registration - supporting documents
     *
     * @param toAddress
     * @param fromAddress
     * @param additionalInfoUrl
     * @param locale
     * @return
     */
    public static MailData buildMailRequestSupportingDocumentsForRegistration(String toAddress, String fromAddress,
                                                                              String additionalInfoUrl, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
        String body = bundle.getString("mail.dgConn.requestDocuments.body");
        body = MessageFormat.format(body, additionalInfoUrl);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for Registration - supporting documents
     *
     * @param toAddress
     * @param fromAddress
     * @param additionalInfoUrl
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailRequestSupportingDocumentsForRegistration(String toAddress, String fromAddress,
                                                                              String additionalInfoUrl, int municipalityId, String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
        String body = bundle.getString("mail.dgConn.requestDocuments.body");
        body = MessageFormat.format(body, additionalInfoUrl);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * Mail for Beneficiary Registration - thank you for registering
     *
     * @param toAddress
     * @param fromAddress
     * @param locale
     * @return
     */
    public static MailData buildMailBeneficiaryRegistration(String toAddress, String fromAddress, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.subject");
        String body = bundle.getString("mail.body");
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for Supplier Registration - thank you for registering
     *
     * @param toAddress
     * @param fromAddress
     * @param locale
     * @return
     */
    public static MailData buildMailSupplierRegistration(String toAddress, String fromAddress, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.supplierRegistration.subject");
        String body = bundle.getString("mail.supplierRegistration.body");
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for Forgot password
     *
     * @param toAddress
     * @param fromAddress
     * @param url
     * @param locale
     * @return
     */
    public static MailData buildMailForgotPassword(String toAddress, String fromAddress, String url, Locale locale) {
        // TODO translate subject and msgBody
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = "WiFi4EU - Forgot Password";
        String body = "You can access to the next link and reset your password <a href=\"{0}\">";
        body = MessageFormat.format(body, url);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for New thread message
     *
     * @param toAddress
     * @param fromAddress
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailNewThreadMessage(String toAddress, String fromAddress, int municipalityId,
                                                     String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.thread.subject");
        String body = bundle.getString("mail.thread.body");
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * Mail for Invalid registration
     *
     * @param toAddress
     * @param fromAddress
     * @param company
     * @param locale
     * @return
     */
    public static MailData buildMailInvalidRegistration(String toAddress, String fromAddress, String company,
                                                        Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.invalidateSupplier.subject");
        String body = bundle.getString("mail.dgConn.invalidateSupplier.body");
        body = MessageFormat.format(body, company);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for New user supplier
     *
     * @param toAddress
     * @param fromAddress
     * @param url
     * @param locale
     * @return
     */
    public static MailData buildMailNewUserSupplier(String toAddress, String fromAddress, String userName,
                                                    String supplierName, String additionalInfoUrl, String newContactEmail, String registrationUrl,
                                                    Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.sendNewUserSupplier.subject");
        String body = bundle.getString("mail.sendNewUserSupplier.body");
        body = MessageFormat.format(body, userName, supplierName, additionalInfoUrl, newContactEmail, registrationUrl);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for Multiple registrations detected
     *
     * @param toAddress
     * @param fromAddress
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailMultipleRegistrations(String toAddress, String fromAddress, int municipalityId,
                                                          String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.discussionMunicipality.subject");
        String body = bundle.getString("mail.discussionMunicipality.body");
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * Mail for New user beneficiary
     *
     * @param toAddress
     * @param fromAddress
     * @param userName
     * @param municipalityName
     * @param additionalInfoUrl
     * @param newContactEmail
     * @param locale
     * @return
     */
    public static MailData buildMailNewUserBeneficiary(String toAddress, String fromAddress, String userName,
                                                       String municipalityName, String additionalInfoUrl, String newContactEmail, String registrationUrl,
                                                       Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.sendUserEmail.beneficiary.subject");
        String body = bundle.getString("mail.sendUserEmail.beneficiary.body");
        body = MessageFormat.format(body, userName, municipalityName, additionalInfoUrl, newContactEmail, registrationUrl);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

    /**
     * Mail for Voucher apply successful
     *
     * @param toAddress
     * @param fromAddress
     * @param event
     * @param additionalInfoUrl
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailVoucherApplySuccessful(String toAddress, String fromAddress, String event,
                                                           String additionalInfoUrl, int municipalityId, String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.voucherAssignment.subject");
        subject = MessageFormat.format(subject, event);
        String body = bundle.getString("mail.dgConn.voucherAssignment.successfulApplicant.body");
        body = MessageFormat.format(body, additionalInfoUrl);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * Mail for Voucher apply reserved
     *
     * @param toAddress
     * @param fromAddress
     * @param event
     * @param additionalInfoUrl
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailVoucherApplyReserved(String toAddress, String fromAddress, String event,
                                                         String additionalInfoUrl, int municipalityId, String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.voucherAssignment.subject");
        subject = MessageFormat.format(subject, event);
        String body = bundle.getString("mail.dgConn.voucherAssignment.reserveApplicant.body");
        body = MessageFormat.format(body, additionalInfoUrl);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * Mail for Voucher apply unsuccessful
     *
     * @param toAddress
     * @param fromAddress
     * @param event
     * @param additionalInfoUrl
     * @param municipalityId
     * @param action
     * @param locale
     * @return
     */
    public static MailData buildMailVoucherApplyUnsuccessful(String toAddress, String fromAddress, String event,
                                                             boolean invalidSupportingDocuments, int municipalityId, String action, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.voucherAssignment.subject");
        subject = MessageFormat.format(subject, event);
        String option;
        if (invalidSupportingDocuments) {
            option = bundle.getString("mail.dgConn.voucherAssignment.unsuccesfulApplicant.option1");
        } else {
            option = bundle.getString("mail.dgConn.voucherAssignment.unsuccesfulApplicant.option2");
        }
        String body = bundle.getString("mail.dgConn.voucherAssignment.unsuccesfulApplicant.body");
        body = MessageFormat.format(body, option);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale, municipalityId, action, true);

        return mailData;
    }

    /**
     * * Mail for Grant Agreement reminder
     */
    public static MailData buildMailGrantAgreementReminder(String toAddress, String fromAddress, int daysMessage,
                                                           Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.dgConn.grantagreement.sign.reminder.subject");
        String body = bundle.getString("mail.dgConn.grantagreement.sign.reminder.body");
        body = MessageFormat.format(body, daysMessage);
        MailData mailData = new MailData(toAddress, fromAddress, subject, body, locale);

        return mailData;
    }

}
