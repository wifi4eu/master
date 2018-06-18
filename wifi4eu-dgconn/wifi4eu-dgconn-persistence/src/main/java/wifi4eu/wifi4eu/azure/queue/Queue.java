package wifi4eu.wifi4eu.azure.queue;

import com.google.common.collect.Lists;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import com.microsoft.azure.storage.queue.MessageUpdateFields;
import com.microsoft.azure.storage.queue.QueueRequestOptions;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.azure.constants.QueueConstants;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Component
public class Queue implements AzureQueue {

    private final Utils utils;

    public Queue(){
        utils = new Utils(QueueConstants.DEFAULT_QUEUE_NAME);
    }

    public Queue(final String queueName){
        utils = new Utils(queueName);
    }

    public void createAzureQueue() throws URISyntaxException,
                                            StorageException,
                                            InvalidKeyException {

        CloudQueue queue = utils.generateCloudQueue();

        // Create the queue if it doesn't already exist.
        queue.createIfNotExists();
    }

    public List<CloudQueueMessage> getMessagesAzureQueue() throws StorageException, InvalidKeyException, URISyntaxException {
        CloudQueue queue = utils.generateCloudQueue();

        List<CloudQueueMessage> list = Lists.newArrayList(queue.retrieveMessages(QueueConstants.MAX_NUMBER_OF_MESSAGES_TO_PEEK,1,null,null));

        return list;
    }

    public List<CloudQueueMessage> peekMessagesAzureQueue(final int peekNumber, final int visibilityTimeout) throws StorageException, InvalidKeyException, URISyntaxException {
        CloudQueue queue = utils.generateCloudQueue();

        List<CloudQueueMessage> list = Lists.newArrayList(queue.retrieveMessages(peekNumber,visibilityTimeout,null,null));

        return list;
    }

    public void addMessageAzureQueue(final String messageContent) throws URISyntaxException,
                                                                            StorageException,
                                                                            InvalidKeyException {

        CloudQueue queue = utils.generateCloudQueue();

        // Create the queue if it doesn't already exist.
        queue.createIfNotExists();

        // Create a message and add it to the queue.
        CloudQueueMessage message = new CloudQueueMessage(messageContent);
        queue.addMessage(message);
    }

    public CloudQueueMessage peekMessageAzureQueue() throws URISyntaxException,
                                                                InvalidKeyException,
                                                                StorageException {

        CloudQueue queue = utils.generateCloudQueue();

        // Peek at the next message.
        return queue.peekMessage();
    }

    public void updateMessageAzureQueue(final String searchMessageContent, final String updateMessageContent) throws StorageException,
                                                                                                                        URISyntaxException,
                                                                                                                        InvalidKeyException {

        CloudQueue queue = utils.generateCloudQueue();

        // Loop through the messages in the queue.
        for (CloudQueueMessage message : queue.retrieveMessages(QueueConstants.MAX_NUMBER_OF_MESSAGES_TO_PEEK,1,null,null)) {

            // Check for a specific string.
            if (message.getMessageContentAsString().equals(searchMessageContent)) {

                // Modify the content of the first matching message.
                message.setMessageContent(updateMessageContent);
                // Set it to be visible in 30 seconds.
                EnumSet<MessageUpdateFields> updateFields =
                        EnumSet.of(MessageUpdateFields.CONTENT,
                                MessageUpdateFields.VISIBILITY);
                // Update the message.
                queue.updateMessage(message, QueueConstants.VISIBILITY_TIMEOUT_SECONDS, updateFields, null, null);
                break;
            }
        }
    }

    public void removeMessages() throws URISyntaxException,
            StorageException,
            InvalidKeyException{
        CloudQueue queue = utils.generateCloudQueue();

        // Retrieve the first visible message in the queue.

        List<CloudQueueMessage> list = Lists.newArrayList(queue.retrieveMessages(QueueConstants.MAX_NUMBER_OF_MESSAGES_TO_PEEK,1,null,null));
        for(CloudQueueMessage cloudQueueMessage: list){
            queue.deleteMessage(cloudQueueMessage);
        }
    }

    public void removeMessageAzureQueue() throws URISyntaxException,
                                                    StorageException,
                                                    InvalidKeyException {

        CloudQueue queue = utils.generateCloudQueue();

        // Retrieve the first visible message in the queue.
        CloudQueueMessage retrievedMessage = queue.retrieveMessage();

        if (retrievedMessage != null) {

            // Process the message in less than 30 seconds, and then delete the message.
            queue.deleteMessage(retrievedMessage);
        }
    }

    public void removeMessageAzureQueue(CloudQueueMessage message) throws URISyntaxException,
            StorageException,
            InvalidKeyException {

        CloudQueue queue = utils.generateCloudQueue();

        if (message != null) {
            // Process the message in less than 30 seconds, and then delete the message.
            queue.deleteMessage(message);
        }
    }


    public long sizeAzureQueue() throws URISyntaxException,
                                            InvalidKeyException,
                                            StorageException {

        CloudQueue queue = utils.generateCloudQueue();

        // Download the approximate message count from the server.
        queue.downloadAttributes();

        // Retrieve the newly cached approximate message count.
        return queue.getApproximateMessageCount();
    }

    public String getQueueName() {
        return utils.getUsedQueue();
    }

    public void setQueueName(final String name) {
        utils.setUsedQueue(name);
    }
}
