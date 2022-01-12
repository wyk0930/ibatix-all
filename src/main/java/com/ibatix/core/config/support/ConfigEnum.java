package com.ibatix.core.config.support;

public enum ConfigEnum {
    ZOOKEEPER_ENABLE("zookeeper.enable", "false"),
    ZOOKEEPER_URL("zookeeper.url", ""),
    ZOOKEEPER_USERNAME("zookeeper.username", ""),
    ZOOKEEPER_PASSWORD("zookeeper.password", ""),
    ZOOKEEPER_DRIVER_CLASS_NAME("zookeeper.driver.class.name", ""),
    REDIS_ENABLE("redis.enable", "false"),
    REDIS_IP("redis.ip", ""),
    REDIS_PORT("redis.port", ""),
    REDIS_USERNAME("redis.username", ""),
    REDIS_PASSWORD("redis.password", ""),
    REDIS_DRIVER_CLASS_NAME("redis.driver.class.name", ""),
    HBASE_ENABLE("hbase.enable", "false"),
    HBASE_URL("hbase.url", ""),
    HBASE_USERNAME("hbase.username", ""),
    HBASE_PASSWORD("hbase.password", ""),
    HBASE_DRIVER_CLASS_NAME("hbase.driver.class.name", ""),
    NEO4J_ENABLE("neo4j.enable", "false"),
    NEO4J_URL("neo4j.url", ""),
    NEO4J_USERNAME("neo4j.username", ""),
    NEO4J_PASSWORD("neo4j.password", ""),
    NEO4J_DRIVER_CLASS_NAME("neo4j.driver.class.name", ""),
    HIVE_ENABLE("hive.enable", "false"),
    HIVE_URL("hive.url", ""),
    HIVE_USERNAME("hive.username", ""),
    HIVE_PASSWORD("hive.password", ""),
    HIVE_DRIVER_CLASS_NAME("hive.driver.class.name", ""),
    RDB_ENABLE("rdb.enable", "false"),
    RDB_URL("rdb.url", ""),
    RDB_USERNAME("rdb.username", ""),
    RDB_PASSWORD("rdb.password", ""),
    RDB_DRIVER_CLASS_NAME("rdb.driver.class.name", ""),
    LOG_IMPL("log.impl","none"),
    LOG_LEVEL("log.level","info");

    ConfigEnum(String configKey, String defaultValue) {
        this.configKey = configKey;
        this.defaultValue = defaultValue;
    }

    private String configKey;
    private String defaultValue;

    public String getConfigKey() {
        return configKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
