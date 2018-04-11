package wifi4eu.wifi4eu.azure.queue;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueueMessage;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

public interface AzureQueue {

    void createAzureQueue() throws URISyntaxException, StorageException, InvalidKeyException;
    void addMessageAzureQueue(final String messageContent) throws URISyntaxException, StorageException, InvalidKeyException;
    CloudQueueMessage peekMessageAzureQueue() throws URISyntaxException, InvalidKeyException, StorageException;
    void updateMessageAzureQueue(final String searchMessageContent, final String updateMessageContent) throws StorageException, URISyntaxException, InvalidKeyException;
    void removeMessageAzureQueue() throws URISyntaxException, StorageException, InvalidKeyException;
    long sizeAzureQueue() throws URISyntaxException, InvalidKeyException, StorageException;

    String getQueueName();
    void setQueueName(final String name);
    List<CloudQueueMessage> getMessagesAzureQueue() throws StorageException, InvalidKeyException, URISyntaxException;

}
