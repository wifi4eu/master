package wifi4eu.wifi4eu.apply;

import org.springframework.core.env.Environment;

public class Config {

    private static Environment environment;


    public static void init(Environment env) {
        environment = env;
    }


    public static Environment getEnvironment() {
        return environment;
    }

    public static String getEnvironment(String key) {
        return environment.getProperty(key);
    }

}