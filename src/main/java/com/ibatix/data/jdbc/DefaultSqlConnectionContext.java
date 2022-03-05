package com.ibatix.data.jdbc;

import com.ibatix.util.NullUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认数据库连接工厂构造器
 *
 * @author master
 */
public class DefaultSqlConnectionContext implements SqlConnectionContext {
    private static Map<String, SqlConnectionFactory> CTX_HOLDER;
    private static SqlConnectionContext _instance;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private DataSource dataSource;

    /**
     * 构造器
     */
    private DefaultSqlConnectionContext() {
        CTX_HOLDER = new HashMap<>();
    }

    /**
     * 获取数据库连接工厂构造器
     *
     * @return 数据库连接工厂构造器
     */
    public static SqlConnectionContext getInstance() {
        if (NullUtils.isNull(_instance)) {
            synchronized (DefaultSqlConnectionContext.class) {
                if (NullUtils.isNull(_instance)) {
                    _instance = new DefaultSqlConnectionContext();
                }
            }
        }
        return _instance;
    }

    @Override
    public SqlConnectionFactory build() {
        SqlConfiguration config = new DefaultSqlConfiguration();
        config.setDriverClassName(driverClassName);
        config.setUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return null;
    }

    @Override
    public SqlConnectionFactory build(SqlConfiguration config) {
        return null;
    }

    public SqlConnectionContext withDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public SqlConnectionContext withUrl(String url) {
        this.url = url;
        return this;

    }

    public SqlConnectionContext withUsername(String username) {
        this.username = username;
        return this;

    }

    public SqlConnectionContext withPassword(String password) {
        this.password = password;
        return this;

    }

}
