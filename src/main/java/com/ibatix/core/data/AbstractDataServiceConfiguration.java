package com.ibatix.core.data;

public abstract class AbstractDataServiceConfiguration implements DataServiceConfiguration {
    private String username;
    private String password;
    private String uri;
    private String type;

    @Override
    public DataServiceConfiguration withUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public DataServiceConfiguration withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public DataServiceConfiguration withURI(String uri) {
        this.uri = uri;
        return this;
    }

    @Override
    public DataServiceConfiguration withType(String type) {
        this.type = type;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }
}
