package com.ibatix.data.neo4j;

import com.ibatix.core.context.ContextHolder;
import com.ibatix.core.data.AbstractDataServiceExecutor;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.Map;

public class EmbeddedNeo4jDataServiceExecutor extends AbstractDataServiceExecutor {
    private final GraphDatabaseService graphDb;
    private final EmbeddedNeo4jDataServiceExecutorFactory factory;

    EmbeddedNeo4jDataServiceExecutor(String factoryName) {
        super(factoryName);
        factory = ContextHolder.get(factoryName, EmbeddedNeo4jDataServiceExecutorFactory.class);
        EmbeddedNeo4jDataServiceConfiguration config = (EmbeddedNeo4jDataServiceConfiguration) factory.getConfig();
        File file = new File(config.getDataDir());
        if (!file.exists()) {
            file.mkdirs();
        }
        graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(file);
    }

    public Node createNode(String labelName) {
        Node node = null;
        try (Transaction tx = graphDb.beginTx()) {
            node = graphDb.createNode();
            node.addLabel(Label.label(labelName));
            tx.success();
        }
        return node;
    }

    public Node createNode(String labelName, Map<String, Object> properties) {
        Node node = null;
        try (Transaction tx = graphDb.beginTx()) {
            node = graphDb.createNode();
            node.addLabel(Label.label(labelName));
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                node.setProperty(entry.getKey(), entry.getValue());
            }
            tx.success();
        }
        return node;
    }

    public void setPropertyForNode(Node node, Map<String, Object> properties) {
        try (Transaction tx = graphDb.beginTx()) {
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                node.setProperty(entry.getKey(), entry.getValue());
            }
            tx.success();
        }
    }

    public Relationship createRelationship(Node startNode, Node endNode, String relationshipName) {
        Relationship relationship = null;
        try (Transaction tx = graphDb.beginTx()) {
            relationship = startNode.createRelationshipTo(endNode, RelationshipType.withName(relationshipName));
            tx.success();
        }
        return relationship;
    }

    public Relationship createRelationship(Node startNode, Node endNode,
                                           String relationshipName, Map<String, Object> properties) {
        Relationship relationship = null;
        try (Transaction tx = graphDb.beginTx()) {
            relationship = startNode.createRelationshipTo(endNode, RelationshipType.withName(relationshipName));
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                relationship.setProperty(entry.getKey(), entry.getValue());
            }
            tx.success();
        }
        return relationship;
    }

    public void setPropertyForRelationship(Relationship relationship, Map<String, Object> properties) {
        try (Transaction tx = graphDb.beginTx()) {
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                relationship.setProperty(entry.getKey(), entry.getValue());
            }
            tx.success();
        }
    }
}
