package wifi4eu.wifi4eu.azure.constants;

public class QueueConstants {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // https://docs.microsoft.com/es-es/azure/storage/queues/storage-java-how-to-use-queue-storage#how-to-create-a-queue//
    public static final String DEFAULT_QUEUE_NAME = "myqueue";

    // https://docs.microsoft.com/es-es/azure/storage/queues/storage-java-how-to-use-queue-storage#how-to-create-a-queue//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // The maximum number of messages that can be retrieved is 32.
    public static final int MAX_NUMBER_OF_MESSAGES_TO_PEEK = 32;

    public static final int VISIBILITY_TIMEOUT_SECONDS = 30;
}
