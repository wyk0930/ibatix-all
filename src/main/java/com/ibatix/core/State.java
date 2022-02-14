package com.ibatix.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 命令执结果
 *
 * @author master
 */
public interface State {

    boolean getBoolean();

    State withBoolean(boolean arg);

    char getChar();

    State withChar(char arg);

    byte getByte();

    State withByte(byte arg);

    short getShort();

    State withShort(short arg);

    int getInt();

    State withInt(int arg);

    long getLong();

    State withLong(long arg);

    float getFloat();

    State withFloat(float arg);

    double getDouble();

    State withDouble(double arg);

    BigDecimal getBigDecimal();

    State withBigDecimal(BigDecimal arg);

    String getString();

    State withString(String arg);

    byte[] getBytes();

    State withBytes(byte[] arg);

    List<Object> getList();

    State withList(List<Object> arg);

    Map<?, ?> getMap();

    State withMap(Map<?, ?> arg);

    Object getObject();

    State withObject(Object arg);

}