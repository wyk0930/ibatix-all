package com.ibatix.data.neo4j;

import com.ibatix.core.data.AbstractDataServiceConfiguration;
import com.ibatix.core.data.AbstractDataServiceExecutor;

public class EmbeddedNeo4jDataServiceConfiguration extends AbstractDataServiceConfiguration {
    private String dataDir;

    public String getDataDir() {
        return dataDir;
    }

    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }
}
