package com.ibatix.core.data;

import com.ibatix.core.Stats;

public interface DataService {

    void doQuery(DataServiceArguments args);

    void doUpdate(DataServiceArguments args);

    Stats getStats();
}
