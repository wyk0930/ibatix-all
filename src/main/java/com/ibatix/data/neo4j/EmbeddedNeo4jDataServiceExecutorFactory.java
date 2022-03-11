package com.ibatix.data.neo4j;

import com.ibatix.core.data.AbstractDataServiceExecutorFactory;

public class EmbeddedNeo4jDataServiceExecutorFactory
        extends AbstractDataServiceExecutorFactory<EmbeddedNeo4jDataServiceExecutor> {

    @Override
    protected EmbeddedNeo4jDataServiceExecutor create() {
        return new EmbeddedNeo4jDataServiceExecutor(this.getName());
    }
}
