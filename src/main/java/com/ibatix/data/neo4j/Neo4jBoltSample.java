package com.ibatix.data.neo4j;

import org.neo4j.driver.*;

import java.util.HashMap;
import java.util.Map;

import static org.neo4j.driver.Values.parameters;

/**
 * 通过bolt协议访问Neo4j数据库
 */
public class Neo4jBoltSample {
    private static final String NEO4J_URI = "bolt://192.168.7.2:7687";
    private static final String USERNAME = "neo4j";
    private static final String PASSWORD = "123456";
    private static Driver driver;

    public static void main(String[] args) {
//        query();
        queryPath();
//        queryByShortestPath();

    }

    /**
     * 最短路径查询
     */
    public static void queryByShortestPath() {
        Session session = openSession();
        String cql = "MATCH p=shortestPath((person:Person {name:$startName})-[*]-(person2:Person {name:$endName}))" +
                "RETURN p";
        Map<String, Object> args = new HashMap<>();
        args.put("startName", "王启年");
        args.put("endName", "九品射手燕小乙");

        Result result = session.run(cql, args);
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record);
            System.out.println("==================================");
        }
        session.close();
        driver.close();

    }

    /**
     * 路径查询
     */
    public static void queryPath() {
        Session session = openSession();
//        String cql = "MATCH p=(person:Person {name:$startName})-[*]-(person2:Person {name:$endName}) RETURN p";
        String cql = "MATCH p=(person:Person {name:$startName})-[*1..4]-(person2:Person {name:$endName}) RETURN p";

        Result result = session.run(cql, parameters("startName", "王启年", "endName", "九品射手燕小乙"));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record);
            System.out.println("==================================");
        }
        session.close();
        driver.close();

    }

    /**
     * 一般查询
     */
    public static void query() {
        Session session = openSession();
        String cql = "MATCH(p:Person)  WHERE p.money > $money RETURN p.name AS name," +
                " p.money AS money order by p.money";
        // 除了通过提供的工具类，还可以使用Map构建参数列表
        Result result = session.run(cql, parameters("money", 1000));
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("name").asString());
            System.out.println(record.get("money").asDouble());
            System.out.println("==================================");
        }
        session.close();
        driver.close();
    }

    /**
     * 创建会话连接
     *
     * @return 会话
     */
    private static Session openSession() {
        // 初始化连接驱动
        driver = GraphDatabase.driver(NEO4J_URI,
                AuthTokens.basic(USERNAME, PASSWORD));

        // 创建会话（数据库连接）
        Session session = driver.session();
        return session;
    }
}
