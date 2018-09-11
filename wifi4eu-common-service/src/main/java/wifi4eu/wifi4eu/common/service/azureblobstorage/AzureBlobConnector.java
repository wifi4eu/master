package wifi4eu.wifi4eu.common.service.azureblobstorage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

import wifi4eu.wifi4eu.common.service.encryption.EncrypterService;

/**
 * Azure Blob Storage for Legal files of the registrations.
 *
 */
@Component
@Configurable
public class AzureBlobConnector {

	private final Logger LOGGER = LogManager.getLogger(AzureBlobConnector.class);

    @Autowired
    EncrypterService encrypterService;

    private String storageConnectionString;
    
    private final static String DEFAULT_CONTAINER_NAME = "wifi4eu";
    
	//private String storageConnectionString =
	//		"DefaultEndpointsProtocol=https;AccountName=w4eudevlfstore;AccountKey=FqH8YTh8O5ZJcPyiFBjjFsQFg9MH1eev8srDcc4MUlFCupEGW66bbPFgyPO7EIgwfu3saPq/ECiuEEAgrF0b6A==;EndpointSuffix=core.windows.net;";
	
    @PostConstruct
    public void init() throws Exception {
        storageConnectionString = encrypterService.getAzureKeyStorageLegalFiles();
    }
    
	private CloudBlobContainer getContainerReference(final String containerName) {
		CloudStorageAccount storageAccount;
		CloudBlobClient blobClient = null;
		CloudBlobContainer container = null;

		try {
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference(containerName);
		} catch (StorageException | URISyntaxException | InvalidKeyException e) {
			LOGGER.error("ERRO", e);
		}

		return container;
	}
	
	public String uploadText(final String containerName, final String fileName, final String content) {
		// Returning value
		String fileUri = null;
		
		// Validating the paramenters
		this.checkContainerName(containerName);
		this.checkFileName(fileName);
				
		CloudBlobContainer container = this.getContainerReference(containerName);
		
		if (container != null) {
			//Getting a blob reference
			CloudBlockBlob blob = null;
			try {
				blob = container.getBlockBlobReference(fileName);
			} catch (URISyntaxException | StorageException e) {
				LOGGER.error("Error", e);
			}

			if (blob != null) {
				try {
					blob.uploadText(content);
				} catch (StorageException | IOException e) {
					LOGGER.error("Error", e);
				}
			}
			
			fileUri = blob.getUri().toString();
		}
		
		return fileUri;
	}
	
	public boolean downloadAsString(final String containerName, final String fileName, final String absoluteDestinationPath) throws Exception {
		boolean result = false;
		
		// Validating the paramenters
		this.checkContainerName(containerName);
		this.checkFileName(fileName);
				
		CloudBlobContainer container = this.getContainerReference(containerName);

		if (container == null) {
			CloudBlockBlob blob = container.getBlockBlobReference(fileName);

			blob.downloadToFile(absoluteDestinationPath);
			result = true;
		}
		
		return result;
	}
	
	public String downloadText(final String containerName, final String fileName) {
		String content = null;
		
		// Validating the paramenters
		this.checkContainerName(containerName);
		this.checkFileName(fileName);
				
		CloudBlobContainer container = this.getContainerReference(containerName);
		CloudBlockBlob blob = null;
		try {
			blob = container.getBlockBlobReference(fileName);
		} catch (URISyntaxException | StorageException e) {
			LOGGER.error("Error", e);
		}

		if (blob != null) {
			LOGGER.info("Downloading from containerName[{}], fileName[{}]", containerName, fileName);

			try {
				content = blob.downloadText();
				LOGGER.info("Content downloaded. Content.length [{}]", content == null ? "NULL" : String.valueOf(content.length()));
			} catch (StorageException | IOException e) {
				LOGGER.error("Error", e);
			}
		
		} 
		
		return content;
	}
	
	public boolean delete(final String containerName, final String fileName) {
		boolean result = false;
		CloudBlobContainer container = this.getContainerReference(containerName);

		CloudBlockBlob blob = null;

		try {
			blob = container.getBlockBlobReference(fileName);
		} catch (URISyntaxException | StorageException e) {
			LOGGER.error("Error getting blob reference", e);
		}
		
		if (blob != null) {
			try {
				blob.delete();
				result = true;
			} catch (StorageException e) {
				LOGGER.error("ERROR deleting blob", e);
			}
		}
		
		return result;
	}
	
	public void listAllWifi4EuOnConsole(String containerName) throws Exception {
		CloudBlobContainer container = this.getContainerReference(containerName);

		Iterable<ListBlobItem> it = container.listBlobs();
		
		System.out.println("ITEMS ON CONTAINER");

		for (ListBlobItem listBlobItem : it) {
			System.out.println("=>" + listBlobItem.getUri());
		}
	}
	
	private void checkContainerName(final String containerName) throws IllegalArgumentException {
		String errorMessage = null;
		
		if (containerName == null) {
			errorMessage = "The container name cannot be null";
		}
		
		if (containerName.length() < 3) {
			errorMessage = "The container name cannot be shorter than 3 characters";
		}
		
		if (containerName.length() > 63) {
			errorMessage = "The file name cannot be longer than 63 characters";
		}
		
		if (containerName.contains(" ")) {
			errorMessage = "The file name cannot contain \" \" (spaces)";
		}
		
		if (errorMessage != null) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
	
	private void checkFileName(final String fileName) throws IllegalArgumentException {
		String errorMessage = null;
		
		if (fileName == null) {
			errorMessage = "The file name cannot be null";
		}
		
		if (fileName.length() > 500) {
			errorMessage = "The file name cannot be longer than 500 characters";
		}
		
		if (fileName.endsWith(".")) {
			errorMessage = "The file name cannot end with \".\" character";
		}
		
		if (fileName.endsWith("/")) {
			errorMessage = "The file name cannot end with \"/\" character";
		}
		
		if (errorMessage != null) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
	
	
	public static void main(String args[]) throws Exception {
		AzureBlobConnector blobConnector = new AzureBlobConnector();
		
		
//        byte[] fileBytes = Base64Utils.decodeFromString(content);
//        FileOutputStream fos = new FileOutputStream("c:\\file.txt");
//        fos.write(fileBytes);
//        fos.flush();
//        fos.close();
		
		//String uriUploadedFile = blobConnector.uploadText("wifi4eu", "doc01", content);
		//String pathDownloadedFile = blobConnector.download("wifi4eu", "doc01", "c:\\franklin\\everis\\downloads.pdf");
		
		//System.out.println("UPLOAD=>" + uriUploadedFile);
		//System.out.println("DOWNLOAD =>" + pathDownloadedFile);
		
		blobConnector.listAllWifi4EuOnConsole("wifi4eu");
		
	}
	
	public String downloadLegalFile(final String data) {
	    String fileNameDownload = data.substring(data.lastIndexOf("/") + 1);
	    AzureBlobConnector azureBlobConnector = new AzureBlobConnector();
	    String content = null;
	    
	    try {
	    	LOGGER.info("Downloading container [{}] fileName[{}]", DEFAULT_CONTAINER_NAME, fileNameDownload);
	    	content = azureBlobConnector.downloadText(DEFAULT_CONTAINER_NAME, fileNameDownload);
	    } catch (Exception e) {
	    	LOGGER.error("ERROR", e);
	    }
	    
	    return content;
	}
	
}
