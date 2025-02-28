package com.luma.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    private Properties properties ;
    private static ConfigUtils configUtils ;
    /* private static com.qacart.todo.utils.ConfigUtils configUtils;*/

    //Method
    private ConfigUtils() throws IOException {
        //more dynamic
        String environment =  System.getProperty("env","PRODUCTION");
        switch (environment)
        {
            case "PRODUCTION":
                properties = PropertiesUtils.loadProperties("src/test/java/com/luma/properties/production.properties");
                break ;
            case "LOCAL":
                properties = PropertiesUtils.loadProperties("src/test/java/com/luma/properties/config/local.properties");
                break;
            default:
                throw new RuntimeException("environment is not supported");
        }
        // properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");

    }
    public static ConfigUtils getInstance() throws IOException {
        if(configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public   String getBaseUrl ()
    {
        String prop = properties.getProperty("baseUrl");
        if (prop == null )
        {
            throw new RuntimeException("could not find the base url in the property file");
        }
        return prop ;
    }

    public   String getemail ()
    {
        String prop = properties.getProperty("email");
        if (prop == null )
        {
            throw new RuntimeException("could not find the email in the property file");
        }
        return prop ;
    }

    public   String getpassword ()
    {
        String prop = properties.getProperty("password");
        if (prop == null )
        {
            throw new RuntimeException("could not find the password in the property file");
        }
        return prop ;
    }

}
