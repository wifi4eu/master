package wifi4eu.wifi4eu.service.azurequeue;


import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.azure.queue.AzureQueue;
import wifi4eu.wifi4eu.common.dto.model.AzureQueueDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserService;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

@Service
public class AzureQueueService {

    @Autowired
    AzureQueue azureQueue;

    @Autowired
    UserService userService;

    private final static Logger _log = LogManager.getLogger(AzureQueueService.class);

    UserContext userContext;
    UserDTO userConnected;

    public AzureQueueService() {
    }

    public void addMessageAzureQueue(AzureQueueDTO azureQueueDTO) throws StorageException, InvalidKeyException, URISyntaxException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        if (azureQueueDTO != null && azureQueueDTO.getMessage() != null && !azureQueueDTO.getMessage().isEmpty()) {
            azureQueue.addMessageAzureQueue(azureQueueDTO.getMessage());
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Message added to azure queue");
        }
    }

    public void setAzureQueue(String name) {
        azureQueue.setQueueName(name);
    }

    public void createAzureQueue(String queueName) throws StorageException, InvalidKeyException, URISyntaxException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        azureQueue.setQueueName(queueName);
        azureQueue.createAzureQueue();
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Azure queue " + queueName + " is created");
    }

    public CloudQueueMessage peekMessageAzureQueue() throws InvalidKeyException, StorageException, URISyntaxException {
        return azureQueue.peekMessageAzureQueue();
    }

    public List<CloudQueueMessage> peekMessagesAzureQueue(int peek, int visibility) throws StorageException, InvalidKeyException, URISyntaxException {
        return azureQueue.peekMessagesAzureQueue(peek, visibility);
    }

    public List<CloudQueueMessage> getMessagesAzureQueue() throws StorageException, InvalidKeyException, URISyntaxException {
        return azureQueue.getMessagesAzureQueue();
    }

    public void removeMessageAzureQueue() throws StorageException, InvalidKeyException, URISyntaxException {
        azureQueue.removeMessageAzureQueue();
    }

    public void removeMessageAzureQueue(CloudQueueMessage cloudQueueMessage) throws StorageException, InvalidKeyException, URISyntaxException {
        azureQueue.removeMessageAzureQueue(cloudQueueMessage);
    }

    public int sizeAzureQueue() throws InvalidKeyException, StorageException, URISyntaxException {
        return (int) azureQueue.sizeAzureQueue();
    }

    public void removeMessagesQueue() throws InvalidKeyException, StorageException, URISyntaxException {
        azureQueue.removeMessages();
    }
}
