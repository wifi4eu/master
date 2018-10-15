package wifi4eu.wifi4eu.util.reporting;

import java.io.IOException;
import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;

import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobStorage;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobStorageUtils;

@Configurable
@Component
public class ReportingSystemManager {

    @Autowired
    AzureBlobStorageUtils azureBlobStorageUtils;

    @Autowired
    AzureBlobStorage azureBlobStorage;

    @Autowired
    GenerateReports generateReports;

    private static final Logger logger = LoggerFactory.getLogger(ReportingSystemManager.class);


    public ReportingSystemManager() {
    }

    public String generateReportingExcel(String currentQuery) {
        logger.debug("Generate reporting excel with arraybytes");
        String filename = azureBlobStorageUtils.generateNameFile(currentQuery);
        String urlDownload = null;
        if (Validator.isNotNull(filename)) {
            try {
                SharedAccessBlobPolicy policy = azureBlobStorageUtils.createSharedAccessPolicySeconds(
                        EnumSet.of(SharedAccessBlobPermissions.READ), 86400);
                if (Validator.isNotNull(policy)) {
                    byte[] bytesFile = generateReports.generateExcelFileBytes(currentQuery);
                    urlDownload = azureBlobStorage.getDocumentWithTokenAzureStorage(filename, bytesFile, policy);
                }
            } catch (IOException e) {
                logger.debug("Exception => " + e.getMessage());
                logger.error("ERROR => ", e);
            }
        }
        return urlDownload;
    }

    public String generateReportingExcel(String currentQuery, Integer callId) {
        logger.debug("Generate reporting excel with arraybytes");
        String filename = azureBlobStorageUtils.generateNameFile(currentQuery);
        String urlDownload = null;
        if (Validator.isNotNull(filename)) {
            try {
                SharedAccessBlobPolicy policy = azureBlobStorageUtils.createSharedAccessPolicySeconds(
                        EnumSet.of(SharedAccessBlobPermissions.READ), 86400);
                if (Validator.isNotNull(policy)) {
                    byte[] bytesFile = generateReports.generateExcelFileBytes(currentQuery, callId);
                    urlDownload = azureBlobStorage.getDocumentWithTokenAzureStorage(filename, bytesFile, policy);
                }
            } catch (IOException e) {
                logger.debug("Exception => " + e.getMessage());
                logger.error("ERROR => ", e);
            }
        }
        return urlDownload;
    }
}
