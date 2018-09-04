package wifi4eu.wifi4eu.common.service.azureblobstorage;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.encryption.EncrypterService;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
@Configurable
public class AzureBlobStorage {

    @Autowired
    AzureBlobStorageUtils azureBlobStorageUtils;

    @Autowired
    EncrypterService encrypterService;

    private String storageConnectionString;

    @PostConstruct
    public void init() throws Exception {
        storageConnectionString = encrypterService.getAzureKeyStorage();
    }

    public void checkContainersCreated(){
        CloudStorageAccount storageAccount;
        CloudBlobClient blobClient;

        try {
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
            blobClient = storageAccount.createCloudBlobClient();
            System.out.println("****** LISTADO DE CONTAINERS POR CLIENTE ******");
            for (CloudBlobContainer container : blobClient.listContainers()){
                System.out.println(container.getName()+" => "+container.getProperties().getLastModified());
            }

        } catch (Exception e){
            System.out.println("Exit exception => "+e.getMessage());
        } finally {
            System.out.println("Everything working OK");
        }
    }

    public byte[] getFileFromContainer(String containerName, String file) throws IOException {
        CloudStorageAccount storageAccount;
        CloudBlobClient blobClient;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CloudBlobContainer cloudBlobContainer = null;

        try {
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
            blobClient = storageAccount.createCloudBlobClient();
            cloudBlobContainer = blobClient.getContainerReference(containerName);
            CloudBlockBlob blockBlob = cloudBlobContainer.getBlockBlobReference(file);
            blockBlob.download(outputStream);
            outputStream.close();
            return outputStream.toByteArray();
        } catch (Exception e){
            System.out.println("Exit exception => "+e.getMessage());
            return null;
        } finally {
            outputStream.close();
            System.out.println("Everything working OK");
        }
    }

    public void deleteContainers(){
        CloudStorageAccount storageAccount;
        CloudBlobClient blobClient;
        try {
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
            blobClient = storageAccount.createCloudBlobClient();
            DateFormat df = new SimpleDateFormat("YYYYMMDD", Locale.ENGLISH);
            for (CloudBlobContainer container : blobClient.listContainers()){
                container.deleteIfExists();
            }
        } catch (Exception e){
            System.out.println("Exit exception => "+e.getMessage());
        } finally {
            System.out.println("Everything working OK");
        }
    }

    public String getDocumentWithTokenAzureStorage(String filename, byte[] sourceFile, SharedAccessBlobPolicy policy){
        String downloadUrl = null;
        System.out.println("Azure Blob Storage Document");
        if (Validator.isNotNull(filename) && Validator.isNotNull(sourceFile)) {
            try {

                CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
                CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

                // Create the container if it does not exist with public access.
                CloudBlobContainer container = azureBlobStorageUtils.createContainerAsDateName(blobClient);

                // Getting a blob reference
                // CloudBlockBlob blob = container.getBlockBlobReference(sourceFile.getName());
                CloudBlockBlob blob = container.getBlockBlobReference(filename);

                //Creating blob and uploading file to it
                // System.out.println("Uploading the sample file to absolute path : " + sourceFile.getAbsolutePath());

                // System.out.println("Uploading bytesArray to the Azure Blob Storage");

                // blob.uploadFromFile(sourceFile.getAbsolutePath());
                blob.uploadFromByteArray(sourceFile,0,sourceFile.length);

                // System.out.println("blobReferenceName => " + filename);
                CloudBlob blobDownload = container.getBlobReferenceFromServer(filename);
                downloadUrl = azureBlobStorageUtils.generateFileWithToken(blobDownload,policy);

            } catch (StorageException ex) {
                System.out.println(String.format("Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                System.out.println("The program has completed successfully.");
                /*
                if (sourceFile != null)
                    sourceFile.delete();
                */
                // System.out.println("Final URL => " + downloadUrl);
                //return downloadUrl;
            }
        }
        return downloadUrl;
    }

}
