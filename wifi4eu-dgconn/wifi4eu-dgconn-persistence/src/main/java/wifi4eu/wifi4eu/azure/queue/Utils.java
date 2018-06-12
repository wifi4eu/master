package wifi4eu.wifi4eu.azure.queue;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import wifi4eu.wifi4eu.azure.constants.ConectionConstants;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public class Utils {

    private String usedQueue;

    Utils(final String workingQueue) {
        this.usedQueue = workingQueue;
    }

    CloudQueue generateCloudQueue() throws URISyntaxException,
                                                    StorageException,
                                                    InvalidKeyException {

        // Retrieve storage account from connection-string.
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

        // Create the queue client.
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        // Retrieve a reference to a queue.
        return queueClient.getQueueReference(usedQueue);
    }

    String getUsedQueue() {
        return usedQueue;
    }

    void setUsedQueue(String anUsedQueue) {
        this.usedQueue = anUsedQueue;
    }
}
