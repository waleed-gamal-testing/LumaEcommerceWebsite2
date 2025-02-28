package com.luma.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PropertiesUtils {
    public  static java.util.Properties loadProperties (String filePath) throws IOException {
        File file = new File(filePath);  // path of file
        InputStream inputStream = new FileInputStream(file);  //see the file
        java.util.Properties properties = new java.util.Properties();
        properties.load(inputStream); // run values from file properties
        inputStream.close();
        return properties;


    }
}
