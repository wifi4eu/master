package wifi4eu.wifi4eu.azure.constants;

public class ConectionConstants {

    private static final String PROTOCOL = "http";
    private static final String STORAGE_ACCOUNT = "w4equeuestorage";
    private static final String STORAGE_ACCOUNT_KEY = "sWvFubVoxStR9G4qMDYdEhASMIYD9Ls2g5/KZdnD563NBeojhP9ehEm1qY0qc/5teR60kOjzIvl5zj0zDsW+1A==";

    // Define the connection-string with your values.
    public static final String STORAGE_CONNECTION_STRING =
            "DefaultEndpointsProtocol="+PROTOCOL+";" +
                    "AccountName="+STORAGE_ACCOUNT+";" +
                    "AccountKey="+STORAGE_ACCOUNT_KEY+";"+
                    "EndpointSuffix=core.windows.net";

}
