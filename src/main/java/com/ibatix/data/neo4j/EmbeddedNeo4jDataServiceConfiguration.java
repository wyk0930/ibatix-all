package com.ibatix.data.neo4j;

import com.ibatix.core.data.AbstractDataServiceConfiguration;

public class EmbeddedNeo4jDataServiceConfiguration extends AbstractDataServiceConfiguration {
    private String dataDir;

    public String getDataDir() {
        return dataDir;
    }

    public EmbeddedNeo4jDataServiceConfiguration withDataDir(String dataDir) {
        this.dataDir = dataDir;
        return this;
    }
}
