package wifi4eu.wifi4eu.common.azureblobstorage;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.helper.Validator;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Configurable
public class AzureBlobStorageUtils {


    public AzureBlobStorageUtils(){

    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public String generateFileWithToken(CloudBlob blobDownload, SharedAccessBlobPolicy policy) throws StorageException, InvalidKeyException {
        if (Validator.isNull(policy)){
            return blobDownload.getUri().toString();
        }
        String sas = blobDownload.generateSharedAccessSignature(policy, null);
        // IPRange ipRangeAccept = new IPRange("217.124.189.100");
        // String sas = blobDownload.generateSharedAccessSignature(policy,null,null,ipRangeAccept,null);
        String fullUrlDownload =  blobDownload.getUri() + "?" + sas;
        return fullUrlDownload;
    }

    public SharedAccessBlobPolicy createSharedAccessPolicySeconds(EnumSet<SharedAccessBlobPermissions> sap, int expireTimeInSeconds) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, expireTimeInSeconds);
        SharedAccessBlobPolicy policy = new SharedAccessBlobPolicy();
        policy.setPermissions(sap);
        policy.setSharedAccessExpiryTime(cal.getTime());
        return policy;
    }

    public SharedAccessBlobPolicy createSharedAccessPolicy(EnumSet<SharedAccessBlobPermissions> sap, int expireTimeYears) {
        if (expireTimeYears == 0){
            return null;
        }
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, expireTimeYears);
        SharedAccessBlobPolicy policy = new SharedAccessBlobPolicy();
        policy.setPermissions(sap);
        policy.setSharedAccessExpiryTime(cal.getTime());
        return policy;
    }

    public CloudBlobContainer createContainerAsDateName(CloudBlobClient blobClient) throws StorageException, URISyntaxException {
        CloudBlobContainer container = blobClient.getContainerReference(sdf.format(new Date()));
        System.out.println("Creating container: " + container.getName());
        BlobRequestOptions blobRequestOptions = new BlobRequestOptions();
        OperationContext operationContext = new OperationContext();
        container.createIfNotExists(BlobContainerPublicAccessType.OFF, blobRequestOptions, operationContext);
        return container;
    }

    public String generateNameFile(String currentQuery){
        String filename;
        long millis = System.currentTimeMillis();
        switch (currentQuery){
            case Constant.REPORTING_CALL_OPEN:
                filename = millis+"_Calls-Open.xls";
                break;

            case Constant.REPORTING_TYPES_INSTALLATION_REPORT:
                filename = millis+"_Types-InstallationReport.xls";
                break;

            default:
                filename = millis+"_tryExcel.xls";
                break;
        }
        return filename;
    }

}


