package wifi4eu.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ConfigHelper {

    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Logger LOGGER = LogManager.getLogger(ConfigHelper.class);

    public ConfigHelper() {

        String enviroment = System.getProperty("enviroment");
        if (enviroment == null) {
            LOGGER.info("Enviroment must be set : Usage -Denviroment=LOCAL  " + Enviroment.values());

        }
        Enviroment enumEnviroment = Enviroment.valueOf(enviroment);
        Properties properties = this.readPropertyFromClassPath(enumEnviroment.getPath() + "/");
    }

    public Properties readPropertyFromClassPath(String path) {

        Properties prop = new Properties();
        String configFilePath = path + CONFIG_FILE_NAME;
        LOGGER.info("Resource: " + getClass().getClassLoader().getResource(configFilePath));

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(configFilePath)) {
            prop.load(is);
        } catch (IOException e) {
            LOGGER.error("Can not read enviroment file " + configFilePath);
        }

        for(Object keyProperty : prop.keySet()){
            LOGGER.info("Property: " + keyProperty.toString() + " value " + prop.getProperty(keyProperty.toString()));
        }
        return prop;
    }
}
