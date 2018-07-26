package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorage;
import wifi4eu.wifi4eu.common.azureblobstorage.AzureBlobStorageUtils;

@Service
public class AzureTest {

    @Autowired
    AzureBlobStorage azureBlobStorage;


    public void testingIt(){
        azureBlobStorage.checkContainersCreated();
    }
}
