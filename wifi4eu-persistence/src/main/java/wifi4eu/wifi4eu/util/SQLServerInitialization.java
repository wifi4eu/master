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
import org.springframework.stereotype.Service;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionAzureKeyVaultProvider;
import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerConnection43;
import com.microsoft.sqlserver.jdbc.SQLServerException;

@Service
public class SQLServerInitialization {

    private final Logger _log = LogManager.getLogger(SQLServerInitialization.class);
        
    @Autowired
    EntityManager em;
    
    //driver Com.Microsoft.Sqlserver.Jdbc.SQLServerDriver
    
    @EventListener(ContextRefreshedEvent.class)
    public void initSQLServerAzureProvider() {    	
        // TODO FIXME hardcoded for testing
    	
        String applicationClientID = "ae77fa68-6492-44dc-b98d-74e002e4a271";
        String applicationKey = "test";
        
        //https://github.com/Microsoft/mssql-jdbc/wiki/Constructors-for-SQLServerColumnEncryptionAzureKeyVaultProvider
        SQLServerColumnEncryptionAzureKeyVaultProvider akvProvider = null;
        Map<String, SQLServerColumnEncryptionKeyStoreProvider> map = new HashMap<String, SQLServerColumnEncryptionKeyStoreProvider>();
        
		try {
			akvProvider = new SQLServerColumnEncryptionAzureKeyVaultProvider(applicationClientID, applicationKey);
	        map.put(akvProvider.getName(), akvProvider);
		} catch (SQLServerException e) {
			System.out.println("***********************");
			System.out.println("***********************");
			System.out.println("***********************");
			System.out.println("***********************");
			_log.error("Error preparing AzureKeyVaultProvider: " + e.getMessage(), e);
		}

        try {
			SQLServerConnection.registerColumnEncryptionKeyStoreProviders(map);
			SQLServerConnection43.registerColumnEncryptionKeyStoreProviders(map);			
		} catch (SQLServerException e) {
			System.out.println("##############################");
			System.out.println("##############################");
			System.out.println("##############################");
			System.out.println("##############################");
			System.out.println("##############################");
			_log.error("Error registering AzureKeyVaultProvider: " + e.getMessage());
		}
        
		System.out.println("+++++++++++++++++++");
		System.out.println("+++++++++++++++++++");
		System.out.println("+++++++++++++++++++");
		System.out.println("+++++++++++++++++++");
		System.out.println("+++++++++++++++++++");
		_log.info("Registered provider: " + akvProvider.getName());

		_log.info("*** EM properties");
		Map<String,Object> mapEM = em.getProperties();
		for (String key: em.getProperties().keySet()) {
			Object o = em.getProperties().get(key);
			if (o == null) {
				_log.info("\t["+key+"] <null>");
			} else {
				_log.info("\t["+key+"] " + o.getClass() + " " + o.toString());
			}
		}
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