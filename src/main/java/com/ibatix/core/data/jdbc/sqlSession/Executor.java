package com.ibatix.core.data.jdbc.sqlSession;

import com.ibatix.core.data.jdbc.pojo.Configuration;
import com.ibatix.core.data.jdbc.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

}
