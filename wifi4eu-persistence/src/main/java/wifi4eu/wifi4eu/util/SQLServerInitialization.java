package wifi4eu.wifi4eu.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionAzureKeyVaultProvider;
import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerConnection43;
import com.microsoft.sqlserver.jdbc.SQLServerException;

@Component
public class SQLServerInitialization {

    private static final Logger _log = LogManager.getLogger(SQLServerInitialization.class);
        
    @Autowired
    EntityManager em;
    
    private static boolean isProviderRegistered = false;
    
    private static boolean isUsingAzureVault = false;
    
    //driver Com.Microsoft.Sqlserver.Jdbc.SQLServerDriver
    
    public SQLServerInitialization() {
    	initSQLServerAzureProvider();
	}
    
    //@ EventListener(ContextRefreshedEvent.class)
    public static void initSQLServerAzureProvider() {    	
        // TODO FIXME hardcoded for testing
    	
        String applicationClientID = "7ea3895c-7769-4ad0-a688-d50f60642a36";
        String applicationKey = "3qAjl0R7zmpQ6+A4RhjyG9UqYppwhI2TEeXegUK2mmc=";
        
        if (isUsingAzureVault && !isProviderRegistered) {
			_log.info("Starting registering the provider");
	
	        //https://github.com/Microsoft/mssql-jdbc/wiki/Constructors-for-SQLServerColumnEncryptionAzureKeyVaultProvider
	        SQLServerColumnEncryptionAzureKeyVaultProvider akvProvider = null;
	        Map<String, SQLServerColumnEncryptionKeyStoreProvider> map = new HashMap<String, SQLServerColumnEncryptionKeyStoreProvider>();
	        
			try {
				akvProvider = new SQLServerColumnEncryptionAzureKeyVaultProvider(applicationClientID, applicationKey);
		        map.put(akvProvider.getName(), akvProvider);
			} catch (SQLServerException e) {
				System.out.println("***********************");
				System.out.println("***********************");
				_log.error("Error preparing AzureKeyVaultProvider: " + e.getMessage(), e);
			}
	
	        try {
				SQLServerConnection.registerColumnEncryptionKeyStoreProviders(map);
				isProviderRegistered = true;
			} catch (SQLServerException e) {
				System.out.println("##############################");
				System.out.println("##############################");
				_log.error("Error registering AzureKeyVaultProvider: " + e.getMessage());
			}
	        
			System.out.println("+++++++++++++++++++");
			System.out.println("+++++++++++++++++++");
			_log.info("Provider: " + akvProvider.getName());
	
			/*
	2018-09-06 10:27:50,593 - INFO  - [SQLServerInitialization:73] - *** EM properties
	2018-09-06 10:27:50,593 - INFO  - [SQLServerInitialization:80] -        [eclipselink.logging.parameters] class java.lang.String true
	2018-09-06 10:27:50,593 - INFO  - [SQLServerInitialization:80] -        [eclipselink.logging.level] class java.lang.String WARNING
	2018-09-06 10:27:50,594 - INFO  - [SQLServerInitialization:80] -        [eclipselink.cache.shared.default] class java.lang.String false
	2018-09-06 10:27:50,594 - INFO  - [SQLServerInitialization:80] -        [eclipselink.target-database] class java.lang.String SQLServer
	2018-09-06 10:27:50,594 - INFO  - [SQLServerInitialization:80] -        [javax.persistence.schema-generation.database.action] class java.lang.String create
	2018-09-06 10:27:50,595 - INFO  - [SQLServerInitialization:80] -        [eclipselink.logging.level.sql] class java.lang.String WARNING
	2018-09-06 10:27:50,595 - INFO  - [SQLServerInitialization:80] -        [eclipselink.deploy-on-startup] class java.lang.String true
			 */
			
			//SQLServerDataSource 
        }
		
    }
    
}