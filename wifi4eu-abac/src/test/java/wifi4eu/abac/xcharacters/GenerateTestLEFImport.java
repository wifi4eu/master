package wifi4eu.abac.xcharacters;

import org.apache.commons.csv.CSVPrinter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(SpringJUnit4ClassRunner.class)
public class GenerateTestLEFImport {

    private static final String SAMPLE_CSV_FILE_IMPORT = "LEF_Data/export-municipalities.csv";
    private static final String SAMPLE_CSV_FILE_IDENTIFICATION_FORM = "LEF_Data/doc1_identificationForm.pdf";
    private static final String SAMPLE_CSV_FILE_EXPORT_DIR ="C:\\PGM\\tmp\\WIFI\\GENERATED_DATA\\LEF\\";
    private static final String SAMPLE_CSV_FILE_EXPORT_BENEFICIARY = "portal_exportBeneficiaryInformation.csv";
    private static final String SAMPLE_CSV_FILE_EXPORT_DOCUMENTS = "portal_exportBeneficiaryDocuments.csv";

    @Test
    //@Ignore
    public void generateLEFImport() throws Exception{
        int startMunID=1010900;
        int start=100;
        int limit = 100;

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(SAMPLE_CSV_FILE_IMPORT), "UTF8"));

                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());


                OutputStream osBeneficiaryInfo = new FileOutputStream(SAMPLE_CSV_FILE_EXPORT_DIR+SAMPLE_CSV_FILE_EXPORT_BENEFICIARY);
                PrintWriter writerBeneficiaryInfo = new PrintWriter(new OutputStreamWriter(osBeneficiaryInfo, "UTF-8"));

                CSVPrinter csvPrinter = new CSVPrinter(writerBeneficiaryInfo, CSVFormat.DEFAULT
                        .withHeader("mun_id","mun_name","mun_abac_name","mun_address","mun_postalCode","mun_city","mun_countryCodeISO","mun_languageCodeISO","mun_registrationNumber","mun_abacreference","mun_CallNumber"));

                OutputStream osBeneficiaryDocs = new FileOutputStream(SAMPLE_CSV_FILE_EXPORT_DIR+SAMPLE_CSV_FILE_EXPORT_DOCUMENTS);
                PrintWriter writerBeneficiaryDocs = new PrintWriter(new OutputStreamWriter(osBeneficiaryDocs, "UTF-8"));

                CSVPrinter csvPrinterDocs = new CSVPrinter(writerBeneficiaryDocs, CSVFormat.DEFAULT
                        .withHeader("mun_id","doc_portalId","doc_name","doc_fileName","doc_mimeType","doc_date","doc_type","ares_reference"));

        ) {
            for (CSVRecord csvRecord : csvParser) {

                if(start != 0){
                    start = start-1;
                    continue;
                }

                if(limit == 0){
                    break;
                }

                // Accessing values by Header names
                String name = csvRecord.get("name")+" DIGIT " +startMunID;
                String address = csvRecord.get("address");
                String postalCode = csvRecord.get("postal_code");


                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Address : " + address);
                System.out.println("PostalCode : " + postalCode);
                System.out.println("---------------\n\n");

                csvPrinter.printRecord(startMunID, name, "", address, postalCode, name, "BE", "eng", "123456", "", 1);
                csvPrinterDocs.printRecord(startMunID, startMunID, "IDENTIFICATION_FORM DIGIT Doc "+startMunID, startMunID+"_identificationForm.pdf", "application/pdf","07/09/2018", "IDENTIFICATION_FORM", "");

                copyFileUsingStream(this.getClass().getClassLoader().getResourceAsStream(SAMPLE_CSV_FILE_IDENTIFICATION_FORM),new File(SAMPLE_CSV_FILE_EXPORT_DIR+startMunID+"_identificationForm.pdf"));

                startMunID = startMunID + 1;
                limit = limit -1;

            }

            csvPrinter.flush();
            csvPrinterDocs.flush();
        }
    }


    private void copyFileUsingStream(InputStream source, File dest) throws IOException {

        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = source.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            source.close();
            os.close();
        }
    }
}
