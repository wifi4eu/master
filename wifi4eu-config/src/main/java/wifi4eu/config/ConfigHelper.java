package wifi4eu.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

@Component
public class ConfigHelper {

    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Logger LOGGER = LogManager.getLogger(ConfigHelper.class);

    public ConfigHelper() {

        String enviroment = System.getProperty("enviroment");
        Enviroment enumEnviroment = Enviroment.valueOf(enviroment);
        Properties properties = this.readPropertyFromClassPath(enumEnviroment.getPath() + "/");
        LOGGER.info("Resource: " + properties.get("prueba.test"));
        this.writePropertyFromClassPath(properties);
        properties = this.readPropertyFromClassPath("");
        LOGGER.info("Resource: " + properties.get("prueba.test"));
    }

    public static  void main(String[] args) throws  Exception{
        ConfigHelper configHelper = new ConfigHelper();
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
        return prop;
    }

    public void writePropertyFromClassPath(Properties prop) {

        String configFilePath = CONFIG_FILE_NAME;
        try (FileOutputStream out = new FileOutputStream(createPropertiesFile(CONFIG_FILE_NAME))) {
            prop.store(out, null);
            out.flush();
        } catch (FileNotFoundException e) {
            LOGGER.error("Can not find enviroment file " + configFilePath);

        } catch (IOException e) {
            LOGGER.error("Can not write enviroment file " + configFilePath);
        } catch (URISyntaxException e) {
            LOGGER.error("Can not create enviroment file " + configFilePath);
        }
    }

    private File createPropertiesFile(String relativeFilePath) throws URISyntaxException {
        return new File(new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()),
                relativeFilePath);
    }

}
