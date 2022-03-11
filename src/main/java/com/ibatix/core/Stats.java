package com.ibatix.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 命令执结果
 *
 * @author master
 */
public interface Stats {

    boolean getBoolean();

    Stats withBoolean(boolean arg);

    char getChar();

    Stats withChar(char arg);

    byte getByte();

    Stats withByte(byte arg);

    short getShort();

    Stats withShort(short arg);

    int getInt();

    Stats withInt(int arg);

    long getLong();

    Stats withLong(long arg);

    float getFloat();

    Stats withFloat(float arg);

    double getDouble();

    Stats withDouble(double arg);

    BigDecimal getBigDecimal();

    Stats withBigDecimal(BigDecimal arg);

    String getString();

    Stats withString(String arg);

    byte[] getBytes();

    Stats withBytes(byte[] arg);

    List<Object> getList();

    Stats withList(List<Object> arg);

    Map<?, ?> getMap();

    Stats withMap(Map<?, ?> arg);

    Object getObject();

    Stats withObject(Object arg);

}