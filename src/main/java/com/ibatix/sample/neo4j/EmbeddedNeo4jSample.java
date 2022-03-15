package com.ibatix.sample.neo4j;

import com.ibatix.core.context.ContextHolder;
import com.ibatix.data.neo4j.EmbeddedNeo4jDataServiceConfiguration;
import com.ibatix.data.neo4j.EmbeddedNeo4jDataServiceExecutor;
import com.ibatix.data.neo4j.EmbeddedNeo4jDataServiceExecutorFactory;

import java.util.List;
import java.util.Map;

public class EmbeddedNeo4jSample {
    public static void main(String[] args) {
        EmbeddedNeo4jDataServiceConfiguration config = new EmbeddedNeo4jDataServiceConfiguration();
        config.withDataDir("target/db");

        EmbeddedNeo4jDataServiceExecutorFactory factory = new EmbeddedNeo4jDataServiceExecutorFactory();
        factory.setConfig(config);
        factory.setName(ContextHolder.createDefaultServiceName(EmbeddedNeo4jDataServiceExecutorFactory.class));
        ContextHolder.put(factory);

        EmbeddedNeo4jDataServiceExecutor executor = factory.connect();

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("age", 30);
//        Node person = executor.createNode("Person", map);
//
//        System.out.println(person.toString());

        List<Map<String, Object>> dataSet = executor.findNodeByLabel("Person");
        for (Map<String, Object> record : dataSet) {
            System.out.println(record);
        }


    }
}
