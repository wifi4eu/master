package wifi4eu.wifi4eu.common.service.azureblobstorage;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import com.microsoft.azure.storage.blob.ListBlobItem;

import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.encryption.EncrypterService;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;

/**
 * Azure Blob Storage for Legal files of the registrations.
 */
@Component
@Configurable
public class AzureBlobConnector {

    private static final Logger LOGGER = LogManager.getLogger(AzureBlobConnector.class);

    private static final String DEFAULT_CONTAINER_NAME = "wifi4eu";

	private static final String GRANT_AGREEMENT_CONTAINER_NAME = "grant-agreement";

    private static final String EXCEL_EXPORT_CONTAINER_NAME = "excel-exports";

    @Autowired
    EncrypterService encrypterService;

    private String storageConnectionString;

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
            container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        } catch (StorageException | URISyntaxException | InvalidKeyException e) {
            LOGGER.error("ERRO", e);
        }

        return container;
    }

	public String uploadText(final String containerName, final String fileName, final String content) {
		// Returning value
		String fileUri = null;

		String encodedFileName = null;
		try {
			encodedFileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Error", e);
		}

		if (encodedFileName != null) {

            // Validating the paramenters
            this.checkContainerName(containerName);
            this.checkFileName(encodedFileName);

            CloudBlobContainer container = this.getContainerReference(containerName);

            if (container != null) {
                //Getting a blob reference
                CloudBlockBlob blob = null;
                try {
                    blob = container.getBlockBlobReference(encodedFileName);
                } catch (URISyntaxException | StorageException e) {
                    LOGGER.error("Error", e);
                }

				if (blob != null) {
					try {
						blob.uploadText(content);
						fileUri = blob.getUri().toString();
					} catch (StorageException | IOException e) {
						LOGGER.error("Error", e);
					}
				}
			}
		}

		return fileUri;
	}

    public String uploadByteArray(final String containerName, final String fileName, final byte[] data) {
        String fileUri = null;

        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Error", e);
        }

        if (encodedFileName != null) {

            // Validating the paramenters
            this.checkContainerName(containerName);
            this.checkFileName(encodedFileName);

            CloudBlobContainer container = this.getContainerReference(containerName);

            if (container != null) {
                //Getting a blob reference
                CloudBlockBlob blob = null;
                try {
                    blob = container.getBlockBlobReference(encodedFileName);
                } catch (URISyntaxException | StorageException e) {
                    LOGGER.error("Error", e);
                }

                if (blob != null) {
                    try {
                        blob.uploadFromByteArray(data, 0, data.length);
                        fileUri = blob.getUri().toString();
                    } catch (StorageException | IOException e) {
                        LOGGER.error("Error", e);
                    }
                }
            }
        }

        return fileUri;
    }

    public String upload(final String containerName, final String fileName, final InputStream sourceStream, final long length) {

        checkContainerName(containerName);

        String fileUri = null;

        if (StringUtils.isNotEmpty(fileName)) {
            try {
                String encodedFileName = URLEncoder.encode(fileName, "UTF-8");

                // Validating the paramenters
                checkFileName(encodedFileName);

                CloudBlobContainer container = getContainerReference(containerName);

                if (container != null) {
                    fileUri = upload(container, encodedFileName, sourceStream, length);
                }
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("Error encoding the file name", e);

                throw new IllegalArgumentException(e);
            }
        }

        return fileUri;
    }

    private String upload(final CloudBlobContainer container, String encodedFileName, InputStream sourceStream, long length) {

        String fileUri = null;

        try {
            CloudBlockBlob blob = container.getBlockBlobReference(encodedFileName);

            blob.upload(sourceStream, length);
            fileUri = blob.getUri().toString();

        } catch (URISyntaxException | StorageException | IOException e) {
            LOGGER.error("Error uploading to a cloud", e);
        }

		return fileUri;
	}

	public byte[] downloadAsBytes(final String containerName, final String fileName) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
				blob.download(outputStream);
				outputStream.close();
				LOGGER.info("Content downloaded. Content.length [{}]", outputStream == null ? "NULL" : String.valueOf(outputStream.size()));
			} catch (StorageException | IOException e) {
				LOGGER.error("Error", e);
			}
		}

		return outputStream.toByteArray();
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

    public byte[] downloadFileByUri(final String azureUri) {
        URL aURL;
        byte[] content = null;
        LOGGER.info("Downloading from URI [{}]", azureUri);

        try {
            aURL = new URL(azureUri);

            String path = aURL.getPath();
            LOGGER.info("Path [{}]", path);

            String containerName = path.substring(1, path.lastIndexOf("/"));
            String fileName = path.substring(path.lastIndexOf("/") + 1);

            content = downloadAsBytes(containerName, fileName);
        } catch (MalformedURLException e) {
            LOGGER.error("ERROR", e);
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

	private void checkContainerName(final String containerName) throws IllegalArgumentException {
		String errorMessage = null;

		if (containerName == null) {
			errorMessage = "The container name cannot be null";
		} else if (containerName.length() < 3) {
			errorMessage = "The container name cannot be shorter than 3 characters";
		} else if (containerName.length() > 63) {
			errorMessage = "The file name cannot be longer than 63 characters";
		} else if (containerName.contains(" ")) {
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
		} else if (fileName.length() > 500) {
			errorMessage = "The file name cannot be longer than 500 characters";
		} else if (fileName.endsWith(".")) {
			errorMessage = "The file name cannot end with \".\" character";
		} else if (fileName.endsWith("/")) {
			errorMessage = "The file name cannot end with \"/\" character";
		}

		if (errorMessage != null) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

    public byte[] downloadGrantAgreementSigned(final String data) {
        String fileNameDownload = data.substring(data.lastIndexOf('/') + 1);
        AzureBlobConnector azureBlobConnector = new AzureBlobConnector();
        byte[] content = null;

        try {
            LOGGER.info("Downloading container [{}] fileName[{}]", GRANT_AGREEMENT_CONTAINER_NAME, fileNameDownload);
            content = downloadAsBytes(GRANT_AGREEMENT_CONTAINER_NAME, fileNameDownload);
        } catch (Exception e) {
            LOGGER.error("ERROR", e);
        }

        return content;
    }

    public byte[] downloadGrantAgreementCounterSigned(final String data) {
        String fileNameDownload = data.substring(data.lastIndexOf('/') + 1);
        AzureBlobConnector azureBlobConnector = new AzureBlobConnector();
        byte[] content = null;

        try {
            LOGGER.info("Downloading container [{}] fileName[{}]", DEFAULT_CONTAINER_NAME, fileNameDownload);
            content = downloadAsBytes(DEFAULT_CONTAINER_NAME, fileNameDownload);
        } catch (Exception e) {
            LOGGER.error("ERROR", e);
        }

        return content;
    }

	public String downloadLegalFile(final String data) {
	    String fileNameDownload = data.substring(data.lastIndexOf('/') + 1);
	    AzureBlobConnector azureBlobConnector = new AzureBlobConnector();
	    String content = null;

	    try {
	    	LOGGER.info("Downloading container [{}] fileName[{}]", DEFAULT_CONTAINER_NAME, fileNameDownload);
	    	content = downloadText(DEFAULT_CONTAINER_NAME, fileNameDownload);
	    } catch (Exception e) {
	    	LOGGER.error("ERROR", e);
	    }

	    return content;
	}

	public String uploadLegalFile(final String fileName, final String content) {
        String uri = null;

        try {
            final String encondedFileName = URLEncoder.encode(fileName, "UTF-8");

        	LOGGER.info("UPLOADING DOCUMENT container[{}] fileName[{}]", DEFAULT_CONTAINER_NAME, fileName);
        	uri = uploadText(DEFAULT_CONTAINER_NAME, encondedFileName, content);
        	LOGGER.info("URI [{}]", uri);
        } catch (Exception e) {
            LOGGER.error("error", e);
        }

        return uri;
	}

    public String uploadLegalFile(final String fileName, final InputStream fileContent, final long length) {
        return upload(DEFAULT_CONTAINER_NAME, fileName, fileContent, length);
    }

	public boolean deleteLegalFile(final String fileName) {
        return delete(DEFAULT_CONTAINER_NAME, fileName);
	}

    public String uploadExportExcelApplicantsList(final String fileName, final byte[] data){
        String uri = null;

        try {
            final String encondedFileName = URLEncoder.encode(fileName, "UTF-8");

            LOGGER.info("UPLOADING DOCUMENT container[{}] fileName[{}]", EXCEL_EXPORT_CONTAINER_NAME, fileName);
            uri = uploadByteArray(EXCEL_EXPORT_CONTAINER_NAME, encondedFileName, data);
            LOGGER.info("URI [{}]", uri);
        } catch (Exception e) {
            LOGGER.error("error", e);
        }
        return uri;
    }

    public byte[] downloadExcelExportApplicants(final String fileName) {
        String fileNameDownload = fileName;
        byte[] content = null;

        try {
            LOGGER.info("Downloading container [{}] fileName[{}]", EXCEL_EXPORT_CONTAINER_NAME, fileNameDownload);
            content = downloadAsBytes(EXCEL_EXPORT_CONTAINER_NAME, fileNameDownload);
        } catch (Exception e) {
            LOGGER.error("ERROR", e);
        }

        return content;
    }

    public boolean deleteExportExcel(String fileName){
        return delete(EXCEL_EXPORT_CONTAINER_NAME, fileName);
    }

}
