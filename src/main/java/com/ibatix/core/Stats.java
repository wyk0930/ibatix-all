package com.ibatix.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 命令执结果
 *
 * @author master
 */
public interface Stats<T1, T2> {

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

    List<T1> getList();

    Stats withList(List<T1> arg);

    Map<T1, T2> getMap();

    Stats withMap(Map<T1, T2> arg);

    Object getObject();

    Stats withObject(Object arg);

}