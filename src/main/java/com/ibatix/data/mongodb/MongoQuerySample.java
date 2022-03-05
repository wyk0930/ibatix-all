package com.ibatix.data.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoQuerySample {
    private static final String HOST = "192.168.7.4";
    private static final Integer PORT = 27017;
    private static MongoClient mongoClient = null;

    public static void main(String[] args) {
        mongoClient = createMongoClient(HOST, PORT);
//        insert();
//        find();
        filter();
        mongoClient.close();
    }

    /**
     * 示例：查询时过滤
     */
    public static void filter() {
        MongoCollection<Document> collection = getCollection("resume", "preview");
        // 查看所有
        FindIterable<Document> documents = collection.find(Filters.ne("salary", 18000)).sort(Document.parse("{salary:-1}"));

        for (Document ele : documents) {
            System.out.println(ele);
        }
    }


    /**
     * 示例：查询操作
     */
    public static void find() {
        MongoCollection<Document> collection = getCollection("resume", "preview");
        // 查看所有
        FindIterable<Document> documents = collection.find().sort(Document.parse("{salary:-1}"));

        for (Document ele : documents) {
            System.out.println(ele);
        }
    }

    /**
     * 示例：添加数据
     */
    public static void insert() {
        MongoCollection<Document> collection = getCollection("resume", "preview");
        Document document = Document.parse("{name:'李四',city:'北京',birthday:new ISODate('1999-9-9'),salary:18000}");
        System.out.println("添加成功");
        collection.insertOne(document);
    }

    public static MongoCollection<Document> getCollection(String databaseName, String collectionName) {
        MongoDatabase database = getMongoDataBase(mongoClient, databaseName);
        return database.getCollection(collectionName);
    }

    /**
     * 获取指定数据库
     *
     * @param client 客户端
     * @param dbName 数据库名称
     * @return 数据库实例
     */
    private static MongoDatabase getMongoDataBase(MongoClient client, String dbName) {
        return client.getDatabase(dbName);
    }

    /**
     * 创建连接客户端
     *
     * @param host 主机名
     * @param port 端口号
     * @return 连接客户端
     */
    private static MongoClient createMongoClient(String host, Integer port) {
        return new MongoClient(host, port);
    }
}
