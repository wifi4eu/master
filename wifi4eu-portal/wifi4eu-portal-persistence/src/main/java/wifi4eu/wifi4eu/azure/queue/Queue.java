package wifi4eu.wifi4eu.azure.queue;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import com.microsoft.azure.storage.queue.MessageUpdateFields;
import wifi4eu.wifi4eu.azure.constants.ConectionConstants;
import wifi4eu.wifi4eu.azure.constants.QueueConstants;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.EnumSet;

public class Queue {


    public Queue(){
        //TODO: change QueueConstants.QUEUE_NAME in constructor
    }

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

    public CloudQueueMessage peekMessageAzureQueue() throws URISyntaxException,
                                                                InvalidKeyException,
                                                                StorageException {

        // Retrieve storage account from connection-string.
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

        // Create the queue client.
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        // Retrieve a reference to a queue.
        CloudQueue queue = queueClient.getQueueReference(QueueConstants.QUEUE_NAME);

        // Peek at the next message.
        return queue.peekMessage();
    }

    public void updateMessageAzureQueue(final String searchMessageContent, final String updateMessageContent) throws StorageException,
                                                                                                                        URISyntaxException,
                                                                                                                        InvalidKeyException {

        // Retrieve storage account from connection-string.
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

        // Create the queue client.
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        // Retrieve a reference to a queue.
        CloudQueue queue = queueClient.getQueueReference(QueueConstants.QUEUE_NAME);

        // The maximum number of messages that can be retrieved is 32.
        final int MAX_NUMBER_OF_MESSAGES_TO_PEEK = 32;

        // Loop through the messages in the queue.
        for (CloudQueueMessage message : queue.retrieveMessages(MAX_NUMBER_OF_MESSAGES_TO_PEEK,1,null,null)) {

            // Check for a specific string.
            if (message.getMessageContentAsString().equals(searchMessageContent)) {

                // Modify the content of the first matching message.
                message.setMessageContent(updateMessageContent);
                // Set it to be visible in 30 seconds.
                EnumSet<MessageUpdateFields> updateFields =
                        EnumSet.of(MessageUpdateFields.CONTENT,
                                MessageUpdateFields.VISIBILITY);
                // Update the message.
                queue.updateMessage(message, 30, updateFields, null, null);
                break;
            }
        }
    }

    public void removeMessageAzureQueue() throws URISyntaxException,
                                                    StorageException,
                                                    InvalidKeyException {

        // Retrieve storage account from connection-string.
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

        // Create the queue client.
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        // Retrieve a reference to a queue.
        CloudQueue queue = queueClient.getQueueReference(QueueConstants.QUEUE_NAME);

        // Retrieve the first visible message in the queue.
        CloudQueueMessage retrievedMessage = queue.retrieveMessage();

        if (retrievedMessage != null) {

            // Process the message in less than 30 seconds, and then delete the message.
            queue.deleteMessage(retrievedMessage);
        }
    }

    public long sizeAzureQueue() throws URISyntaxException,
                                            InvalidKeyException,
                                            StorageException {

        // Retrieve storage account from connection-string.
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse(ConectionConstants.STORAGE_CONNECTION_STRING);

        // Create the queue client.
        CloudQueueClient queueClient = storageAccount.createCloudQueueClient();

        // Retrieve a reference to a queue.
        CloudQueue queue = queueClient.getQueueReference(QueueConstants.QUEUE_NAME);

        // Download the approximate message count from the server.
        queue.downloadAttributes();

        // Retrieve the newly cached approximate message count.
        return queue.getApproximateMessageCount();
    }
}
