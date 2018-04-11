package wifi4eu.wifi4eu.service.azurequeue;


import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.azure.queue.AzureQueue;
import wifi4eu.wifi4eu.azure.queue.Queue;
import wifi4eu.wifi4eu.common.dto.model.AzureQueueDTO;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

@Service
public class AzureQueueService {

    @Autowired
    AzureQueue azureQueue;

    public AzureQueueService() {
    }

    public void addMessageAzureQueue(AzureQueueDTO azureQueueDTO) throws StorageException, InvalidKeyException, URISyntaxException {
        if (azureQueueDTO != null && azureQueueDTO.getMessage() != null && !azureQueueDTO.getMessage().isEmpty()) {
            azureQueue.addMessageAzureQueue( azureQueueDTO.getMessage() );
        }
    }

    public void createAzureQueue(String queueName) throws StorageException, InvalidKeyException, URISyntaxException {
        azureQueue.setQueueName(queueName);
        azureQueue.createAzureQueue();
    }

    public CloudQueueMessage peekMessageAzureQueue() throws InvalidKeyException, StorageException, URISyntaxException {
        return azureQueue.peekMessageAzureQueue();
    }

    public List<CloudQueueMessage> getMessagesAzureQueue() throws StorageException, InvalidKeyException, URISyntaxException {
        return azureQueue.getMessagesAzureQueue();
    }

    public void removeMessageAzureQueue() throws StorageException, InvalidKeyException, URISyntaxException {
        azureQueue.removeMessageAzureQueue();
    }
}
