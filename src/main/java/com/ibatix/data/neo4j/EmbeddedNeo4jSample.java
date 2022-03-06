package com.ibatix.data.neo4j;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 嵌入式Neo4j应用示例
 *
 * @author master
 */
public class EmbeddedNeo4jSample {
    private static final File DB_DIR = new File("target/graph.db");

    public static void main(String[] args) {
//        addNodeBySimple();
//        addNodeByCql();
        matchByCql();
    }

    /**
     * 使用CQL检索数据库
     */
    public static void matchByCql() {
        // $money 表示参数
        String cql = "MATCH(p:Person) where p.money < $money return p";
        Map<String, Object> args = new HashMap<>();
        args.put("money", 40000);
        GraphDatabaseService graphDatabaseService = openConnection();
        // 开启事务
        Transaction transaction = graphDatabaseService.beginTx();
        Result result = graphDatabaseService.execute(cql, args);
        // 遍历结果集
        while (result.hasNext()) {
            Map<String, Object> dataSet = result.next();
            for (String key : result.columns()) {
                Node node = (Node) dataSet.get(key);
                System.out.printf("%s=%s:%s%n", key,
                        node.getProperty("name"),
                        node.getProperty("money"));
            }
        }
        transaction.success();
        transaction.close();
        graphDatabaseService.shutdown();
        System.out.println("exec successfully");
    }

    /**
     * 使用JavaAPI创建节点
     */
    public static void addNodeBySimple() {
        GraphDatabaseService graphDatabaseService = openConnection();
        // 开启事务
        Transaction transaction = graphDatabaseService.beginTx();
        // 新增节点
        Node n1 = graphDatabaseService.createNode();
        n1.setProperty("name", "张三");
        n1.setProperty("character", "A");
        n1.setProperty("money", 1101);
        n1.addLabel(new Label() {
            @Override
            public String name() {
                return "Person";
            }
        });
        transaction.success();
        transaction.close();
        graphDatabaseService.shutdown();
        System.out.println("exec successfully");
    }

    /**
     * 使用CQL语句创建节点
     */
    public static void addNodeByCql() {
        GraphDatabaseService graphDatabaseService = openConnection();
        // 开启事务
        Transaction transaction = graphDatabaseService.beginTx();

        // 通过CQL新增节点
        String cql = "CREATE(p:Person {name:'李四',character:'B',money:21000})";
        Result result = graphDatabaseService.execute(cql);
        transaction.success();
        transaction.close();
        graphDatabaseService.shutdown();
        System.out.println("exec successfully");
    }


    /**
     * 初始化数据库连接
     *
     * @return 数据库连接
     */
    private static GraphDatabaseService openConnection() {
        // 创建数据库工厂
        GraphDatabaseFactory graphDatabaseFactory = new GraphDatabaseFactory();
        // 获取数据库服务
        GraphDatabaseService graphDatabaseService = graphDatabaseFactory.newEmbeddedDatabase(DB_DIR);
        System.out.println("db load successfully.");
        return graphDatabaseService;
    }
}
