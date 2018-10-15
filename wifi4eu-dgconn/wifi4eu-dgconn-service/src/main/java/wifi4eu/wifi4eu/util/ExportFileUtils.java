package wifi4eu.wifi4eu.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.QuoteMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.entity.exportImport.ExportFile;
import wifi4eu.wifi4eu.util.parsing.LegalEntityCSVColumn;
import wifi4eu.wifi4eu.util.parsing.LegalEntityDocumentCSVColumn;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ExportFileUtils {

    private static final String SEPARATOR = ",";

    private final Logger log = LoggerFactory.getLogger(ExportFileUtils.class);

    public ByteArrayOutputStream generateZipFileStream(List<ExportFile> includedExportFiles) {
        if (includedExportFiles == null || includedExportFiles.size() == 0) {
            log.error("Invalid parameters - generateZipFile");
            return new ByteArrayOutputStream();
        }

        // -- Creating a zip
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ZipOutputStream zos = new ZipOutputStream(baos)) {

            for (ExportFile exportFile : includedExportFiles) {
                ZipEntry entry = new ZipEntry(exportFile.getFilename());
                zos.putNextEntry(entry);
                zos.write(exportFile.getData());
                zos.closeEntry();
            }
        } catch (IOException ex) {
            log.error("Could not generate a zip file", ex);
        }

        return baos;
    }

    public CSVFormat getMunicipalitiesCsvHeaders() {

        return CSVFormat.TDF.withHeader(
                LegalEntityCSVColumn.MUNICIPALITY_PORTAL_ID.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_NAME.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_ABAC_LATIN_NAME.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_ADDRESS.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_POSTAL_CODE.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_CITY.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_COUNTRY_CODE.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_LANGUAGE_CODE.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_REGISTRATION_NUMBER.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_ABAC_REFERENCE.getValue(),
                LegalEntityCSVColumn.MUNICIPALITY_CALL_NUMBER.getValue());
    }

    public CSVFormat getMunicipalitiesDocCsvHeaders() {
        return CSVFormat.TDF.withHeader(
                LegalEntityDocumentCSVColumn.MUNICIPALITY_PORTAL_ID.getValue(),
                LegalEntityDocumentCSVColumn.DOCUMENT_PORTAL_ID.getValue(),
                LegalEntityDocumentCSVColumn.DOCUMENT_NAME.getValue(),
                LegalEntityDocumentCSVColumn.DOCUMENT_FILENAME.getValue(),
                LegalEntityDocumentCSVColumn.DOCUMENT_MIMETYPE.getValue(),
                LegalEntityDocumentCSVColumn.DOCUMENT_DATE.getValue(),
                LegalEntityDocumentCSVColumn.DOCUMENT_TYPE.getValue(),
                LegalEntityDocumentCSVColumn.ARES_REFERENCE.getValue());
    }

    /**
     * Generates the headers for the CSV file according to the String[] provided.
     *
     * @return
     */
    public String generateCSVHeaders(String[] headers) {
        StringBuilder headerData = new StringBuilder();

        boolean first = true;
        for (String header : headers) {
            if (first) {
                headerData.append(header);
                first = false;
            } else {
                headerData.append(SEPARATOR).append(header);
            }
        }

        return headerData.toString();
    }

}
