package wifi4eu.wifi4eu.azure.queue;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import wifi4eu.wifi4eu.azure.constants.ConectionConstants;
import wifi4eu.wifi4eu.azure.constants.QueueConstants;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public class Queue {


    public Queue(){}

    public void createAzureQueue() throws URISyntaxException,
                                            StorageException,
                                            InvalidKeyException {

        // Retrieve storage account from connection-string.
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

        // Create the queue client.
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        // Retrieve a reference to a queue.
        CloudQueue queue = queueClient.getQueueReference(QueueConstants.QUEUE_NAME);

        // Create the queue if it doesn't already exist.
        queue.createIfNotExists();
    }

    public void addMessageAzureQueue(final String messageContent) throws URISyntaxException,
                                                                            StorageException,
                                                                            InvalidKeyException {

            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount =
                    CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

            // Create the queue client.
            CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

            // Retrieve a reference to a queue.
            CloudQueue queue = queueClient.getQueueReference(QueueConstants.QUEUE_NAME);

            // Create the queue if it doesn't already exist.
            queue.createIfNotExists();

            // Create a message and add it to the queue.
            CloudQueueMessage message = new CloudQueueMessage(messageContent);
            queue.addMessage(message);
    }
}
