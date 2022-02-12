package com.ibatix.core.config;

import com.ibatix.core.support.Const;
import com.ibatix.util.NullUtils;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesFactory {
    private static PropertiesFactory instance;

    private ConfigurationLoader loader;

    public static PropertiesFactory getInstance() {
        if (NullUtils.isNull(instance)) {
            synchronized (PropertiesFactory.class) {
                if (NullUtils.isNull(instance)) {
                    instance = new PropertiesFactory();
                }
            }
        }
        return instance;
    }

    public PropertiesFactory load(String fileName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Const.DEFAULT_CHARSET_STR);
        Properties properties = new Properties();
        properties.load(inputStreamReader);
        loader = PropertiesLoader.construct(properties);
        return instance;
    }

    public Configuration getConfig(){
        return loader.getConfig();
    }
}
