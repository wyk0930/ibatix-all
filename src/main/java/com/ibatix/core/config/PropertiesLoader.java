package com.ibatix.core.config;

import com.ibatix.util.NullUtils;

import java.util.Properties;

public class PropertiesLoader  implements ConfigurationLoader{
    private static PropertiesLoader loader;
    private final Properties properties;
    private PropertiesLoader(Properties properties) {
        this.properties = properties;
    }
    public static PropertiesLoader construct(Properties properties){
        if(NullUtils.isNull(loader)){
            synchronized (PropertiesLoader.class){
                if(NullUtils.isNull(loader)){
                    loader = new PropertiesLoader(properties);
                }
            }
        }
        return loader;
    }

    @Override
    public Configuration getConfig() {
        return null;
    }
}
