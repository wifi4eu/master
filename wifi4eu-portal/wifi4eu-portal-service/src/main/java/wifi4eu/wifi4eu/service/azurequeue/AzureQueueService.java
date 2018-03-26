package wifi4eu.wifi4eu.service.azurequeue;


import com.microsoft.azure.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.azure.queue.AzureQueue;
import wifi4eu.wifi4eu.common.dto.model.AzureQueueDTO;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Service
public class AzureQueueService {

    @Autowired
    AzureQueue azureQueue;

    public AzureQueueService() {}


    public void addMessageAzureQueue(AzureQueueDTO azureQueueDTO) throws StorageException, InvalidKeyException, URISyntaxException {
        if (azureQueueDTO != null && azureQueueDTO.getMessage() != null && !azureQueueDTO.getMessage().isEmpty()) {
            azureQueue.addMessageAzureQueue( azureQueueDTO.getMessage() );
        }
    }

}
