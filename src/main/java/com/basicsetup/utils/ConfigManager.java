package com.basicsetup.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager manager;
    private final static Properties prop = new Properties();
    /*private constructor*/

    private ConfigManager() throws IOException {
//        String classpath = System.getProperty("java.class.path");
//        String[] classPathValues = classpath.split(File.pathSeparator);
//        System.out.println(Arrays.toString(classPathValues));

        InputStream inputStream = ConfigManager.class.getResourceAsStream("/config.properties");
        prop.load(inputStream);


    }

    /*Get Instance*/

    public static ConfigManager getInstance() {
        if (manager == null) {
            synchronized (ConfigManager.class) {
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }

    /*Get String*/

    public String getString(String key) {
        return prop.getProperty(key);
    }


}
