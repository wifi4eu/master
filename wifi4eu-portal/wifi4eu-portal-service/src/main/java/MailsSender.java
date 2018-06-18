import com.sun.mail.smtp.SMTPTransport;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MailsSender {

    public static final String BASE_PATH = "C:\\Users\\lviverof\\Documents\\C-Lucia\\mailing";

    public static final String SEND_XLSX_FILE_PATH = BASE_PATH + "\\internal_emails.xlsx";
    public static final String SUPPLIERS_SEND_XLSX_FILE_PATH = BASE_PATH + "\\internal_emails.xlsx";
    public static final String CONTENT_XLSX_FILE_PATH = BASE_PATH + "\\Municipalities_mails_content.xlsx";
    public static final String SUPPLIERS_CONTENT_XLSX_FILE_PATH = BASE_PATH + "\\Suppliers_mails_content.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        //sendMunicipalities();
        sendSuppliers();

    }

    private static void sendSuppliers() throws IOException, InvalidFormatException {
        Map<String, String> listEmails = new HashMap<>();

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SUPPLIERS_SEND_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row : sheet) {
            String email = dataFormatter.formatCellValue(row.getCell(0));
            String ecas_email = dataFormatter.formatCellValue(row.getCell(1));
            String lang = dataFormatter.formatCellValue(row.getCell(2));

            if (lang == null || lang.isEmpty()) {
                lang = "en";
            }

            System.out.print(email + "\t");
            if (!email.equals("email")) { //skip first row

                if (email == null || email.isEmpty()) {
                    if (ecas_email == null || ecas_email.isEmpty()) {
                        System.out.println("Do nothing");
                        //do nothing
                    } else {
                        listEmails.put(ecas_email, lang);
                    }
                } else {
                    listEmails.put(email, lang);
                }
            }
            System.out.println();
        }

        System.out.println("\n\nList of emails to be sent");


        // READING LANGUAGES


        Map<String, String> titleEmails = new HashMap<>();
        Map<String, String> bodyEmails = new HashMap<>();

        workbook = WorkbookFactory.create(new File(SUPPLIERS_CONTENT_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // Getting the Sheet at index zero
        sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        dataFormatter = new DataFormatter();

        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row : sheet) {
            int index = 0;
            for (Cell cell : row) {

                String cellString = dataFormatter.formatCellValue(cell);

                System.out.print(cellString + "\t");
                if (!cellString.equals("Labels")) { //skip first row

                    if (cellString.equals("suppliers.title") || cellString.equals("suppliers.body")) {
                        index++;
                        continue;
                    } else {

                        String title = dataFormatter.formatCellValue(row.getCell(0));
                        if (title.equals("suppliers.title")) {
                            titleEmails.put(dataFormatter.formatCellValue(sheet.getRow(0).getCell(index)), cellString);
                        } else if (title.equals("suppliers.body")) {
                            bodyEmails.put(dataFormatter.formatCellValue(sheet.getRow(0).getCell(index)), cellString);
                        }
                    }
                } else {
                    break;
                }
                index++;
            }
        }

        System.out.println("\n\nList of emails to be sent");


        int counter = 0;
        for (String email : listEmails.keySet()) {
            System.out.println(counter++ + " " + email);
            String subject = getSubjectByLang(listEmails.get(email), titleEmails);
            String body = getBodyByLang(listEmails.get(email), bodyEmails);

            String[] splittedBody = body.split("#");

            String outputBody = "";

            if (splittedBody.length == 7) {
                outputBody += splittedBody[0];
                outputBody += "<a href=\"https://europa.eu/european-union/contact/write-to-us_en\">";
                outputBody += splittedBody[1];
                outputBody += "</a>";
                outputBody += splittedBody[2];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/policies/wifi4eu-free-wi-fi-europeans\">";
                outputBody += splittedBody[3];
                outputBody += "</a>";
                outputBody += splittedBody[4];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/faq/wifi4eu-questions-and-answers\">";
                outputBody += splittedBody[5];
                outputBody += "</a>";
                outputBody += splittedBody[6];

                outputBody = outputBody.replace("\n", "</p><p>");

                outputBody = "<p>" + outputBody + "</p>";


                sendEmail(email, "no-reply@wifi4eu.eu", subject, outputBody);

            } else if (splittedBody.length == 6) {
                outputBody += splittedBody[0];
                outputBody += "<a href=\"https://europa.eu/european-union/contact/write-to-us_en\">";
                outputBody += splittedBody[1];
                outputBody += "</a>";
                outputBody += splittedBody[2];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/policies/wifi4eu-free-wi-fi-europeans\">";
                outputBody += splittedBody[3];
                outputBody += "</a>";
                outputBody += splittedBody[4];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/faq/wifi4eu-questions-and-answers\">";
                outputBody += splittedBody[5];
                outputBody += "</a>";

                outputBody = outputBody.replace("\n", "</p><p>");

                outputBody = "<p>" + outputBody + "</p>";

                //sendEmail(email, "no-reply@wifi4eu.eu", subject, outputBody);
            }
            System.out.println(subject);
            System.out.println(outputBody);
            System.out.println("\n\n");
        }

    }

    private static void sendMunicipalities() throws IOException, InvalidFormatException {

        Map<String, String> listEmails = new HashMap<>();

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SEND_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row : sheet) {
            String email = dataFormatter.formatCellValue(row.getCell(0));
            String ecas_email = dataFormatter.formatCellValue(row.getCell(1));
            String lang = dataFormatter.formatCellValue(row.getCell(2));

            if (lang == null || lang.isEmpty()) {
                lang = "en";
            }

            System.out.print(email + "\t");
            if (!email.equals("email")) { //skip first row

                if (email == null || email.isEmpty()) {
                    if (ecas_email == null || ecas_email.isEmpty()) {
                        System.out.println("Do nothing");
                        //do nothing
                    } else {
                        listEmails.put(ecas_email, lang);
                    }
                } else {
                    listEmails.put(email, lang);
                }
            }
            System.out.println();
        }

        System.out.println("\n\nList of emails to be sent");


        // READING LANGUAGES


        Map<String, String> titleEmails = new HashMap<>();
        Map<String, String> bodyEmails = new HashMap<>();

        workbook = WorkbookFactory.create(new File(CONTENT_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // Getting the Sheet at index zero
        sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        dataFormatter = new DataFormatter();

        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row : sheet) {
            int index = 0;
            for (Cell cell : row) {

                String cellString = dataFormatter.formatCellValue(cell);

                if (!cellString.equals("Labels")) { //skip first row

                    if (cellString.equals("municipalities.title") || cellString.equals("municipalities.body")) {
                        index++;
                        continue;
                    } else {

                        String title = dataFormatter.formatCellValue(row.getCell(0));
                        if (title.equals("municipalities.title")) {
                            titleEmails.put(dataFormatter.formatCellValue(sheet.getRow(0).getCell(index)), cellString);
                        } else if (title.equals("municipalities.body")) {
                            cellString = formatBody(cell);
                            bodyEmails.put(dataFormatter.formatCellValue(sheet.getRow(0).getCell(index)), cellString);
                        }
                    }
                } else {
                    break;
                }
                index++;
            }
        }

        System.out.println("\n\nList of emails to be sent");


        int counter = 0;
        for (String email : listEmails.keySet()) {
            System.out.println(counter++ + " " + email);
            String subject = getSubjectByLang(listEmails.get(email), titleEmails);
            String body = getBodyByLang(listEmails.get(email), bodyEmails);

            String[] splittedBody = body.split("#");

            String outputBody = "";

            if (splittedBody.length == 7) {
                outputBody += splittedBody[0];
                outputBody += "<a href=\"https://europa.eu/european-union/contact/write-to-us_en\">";
                outputBody += splittedBody[1];
                outputBody += "</a>";
                outputBody += splittedBody[2];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/policies/wifi4eu-free-wi-fi-europeans\">";
                outputBody += splittedBody[3];
                outputBody += "</a>";
                outputBody += splittedBody[4];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/faq/wifi4eu-questions-and-answers\">";
                outputBody += splittedBody[5];
                outputBody += "</a>";
                outputBody += splittedBody[6];

                outputBody = outputBody.replace("\n", "</p><p>");

                outputBody = "<p>" + outputBody + "</p>";


                sendEmail(email, "no-reply@wifi4eu.eu", subject, outputBody);

            } else if (splittedBody.length == 6) {
                outputBody += splittedBody[0];
                outputBody += "<a href=\"https://europa.eu/european-union/contact/write-to-us_en\">";
                outputBody += splittedBody[1];
                outputBody += "</a>";
                outputBody += splittedBody[2];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/policies/wifi4eu-free-wi-fi-europeans\">";
                outputBody += splittedBody[3];
                outputBody += "</a>";
                outputBody += splittedBody[4];
                outputBody += "<a href=\"https://ec.europa.eu/digital-single-market/en/faq/wifi4eu-questions-and-answers\">";
                outputBody += splittedBody[5];
                outputBody += "</a>";

                outputBody = outputBody.replace("\n", "</p><p>");

                outputBody = "<p>" + outputBody + "</p>";

                //sendEmail(email, "no-reply@wifi4eu.eu", subject, outputBody);
            }
            System.out.println(subject);
            System.out.println(outputBody);
            System.out.println("\n\n");
        }
    }

    private static String formatBody(Cell cell) {
        String htmlText = "";

        XSSFRichTextString cellRich = (XSSFRichTextString) cell.getRichStringCellValue();
        if (cellRich.numFormattingRuns() > 0) {
            CTRElt[] array = cellRich.getCTRst().getRArray();

            for (CTRElt run : array) {
                Boolean underline = false;
                Boolean bold = false;
                String text = run.getT();
                CTRPrElt style = run.getRPr();
                if (style == null) {
                    htmlText += text;
                } else {
                    if (style.getBArray().length > 0 && style.getBArray()[0].getVal()) {
                        underline = true;
                    }
                    if (style.getUArray().length > 0 && style.getUArray()[0].getVal() != null) {
                        bold = true;
                    }


                    htmlText += (underline ? "<u>" : "") + (bold ? "<b>" : "") + text + (bold ? "</b>" : "") + (underline ? "</u>" : "");
                }
            }
        }
        return htmlText;
    }

    private static String getBodyByLang(String s, Map<String, String> bodyEmails) {
        return bodyEmails.get(s);
    }

    private static String getSubjectByLang(String s, Map<String, String> titleEmails) {
        return titleEmails.get(s);
    }

    private static void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
        try {

            //System.out.println("Sending async mail: " + fromAddress + " " + subject + " " + msgBody);

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.sendgrid.net");
            props.put("mail.smtp.auth", "true");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "false");
            props.put("mail.smtp.from", "no-reply@wifi4eu.eu");
            Session session = Session.getInstance(props, null);
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("no-reply@wifi4eu.eu"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddress, false));
            msg.setSubject(subject, "UTF-8");
            msg.setContent(msgBody, "text/html; charset=utf-8");
            msg.setHeader("X-Mailer", "Tov Are's program");
            msg.setSentDate(new Date());
            SMTPTransport t =
                    (SMTPTransport) session.getTransport("smtp");
            t.connect("smtp.sendgrid.net", "azure_efe0541f6fda2f126859caac07925571@azure.com", "BPkn4N7gOHcnUQTRyB35T7.A2W_nPriFG$M");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: " + t.getLastServerResponse());
            t.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
