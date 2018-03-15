package wifi4eu.wifi4eu.azure.constants;

public class ConectionConstants {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //https://docs.microsoft.com/es-es/azure/storage/queues/storage-java-how-to-use-queue-storage#setup-an-azure-storage-connection-string//
    private static final String PROTOCOL = "http";
    private static final String STORAGE_ACCOUNT = "???@everis.com"; //TODO: user - to make a subscription
    private static final String STORAGE_ACCOUNT_KEY = "???"; //TODO: pass - to make a subscription

    // Define the connection-string with your values.
    public static final String STORAGE_CONNECTION_STRING =
            "DefaultEndpointsProtocol="+PROTOCOL+";" +
                    "AccountName="+STORAGE_ACCOUNT+";" +
                    "AccountKey="+STORAGE_ACCOUNT_KEY+"";


    //https://docs.microsoft.com/es-es/azure/storage/queues/storage-java-how-to-use-queue-storage#setup-an-azure-storage-connection-string//
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
