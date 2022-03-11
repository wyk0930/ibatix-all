package com.ibatix.core.data;

public interface DataServiceConfiguration {

    DataServiceConfiguration withUsername(String username);

    DataServiceConfiguration withPassword(String password);

    DataServiceConfiguration withURI(String uri);

    DataServiceConfiguration withType(String type);

}
