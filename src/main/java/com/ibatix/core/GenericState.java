package com.ibatix.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class GenericState implements State {
    private boolean _boolean;
    private char _char;
    private byte _byte;
    private short _short;
    private int _int;
    private long _long;
    private float _float;
    private double _double;
    private BigDecimal _bigDecimal;
    private String _string;
    private byte[] _bytes;
    private List<?> _list;
    private Map<?, ?> _map;
    private Object _object;

    @Override
    public boolean getBoolean() {
        return _boolean;
    }

    @Override
    public State withBoolean(boolean arg) {
        this._boolean = arg;
        return this;
    }

    @Override
    public char getChar() {
        return _char;
    }

    @Override
    public State withChar(char arg) {
        this._char = arg;
        return this;
    }

    @Override
    public byte getByte() {
        return _byte;
    }

    @Override
    public State withByte(byte arg) {
        this._byte = arg;
        return this;
    }

    @Override
    public short getShort() {
        return _short;
    }

    @Override
    public State withShort(short arg) {
        this._short = arg;
        return this;
    }

    @Override
    public int getInt() {
        return _int;
    }

    @Override
    public State withInt(int arg) {
        this._int = arg;
        return this;
    }

    @Override
    public long getLong() {
        return _long;
    }

    @Override
    public State withLong(long arg) {
        this._long = arg;
        return this;
    }

    @Override
    public float getFloat() {
        return _float;
    }

    @Override
    public State withFloat(float arg) {
        this._float = _float;
        return this;
    }

    @Override
    public double getDouble() {
        return _double;
    }

    @Override
    public State withDouble(double arg) {
        this._double = arg;
        return this;
    }

    @Override
    public BigDecimal getBigDecimal() {
        return _bigDecimal;
    }

    @Override
    public State withBigDecimal(BigDecimal arg) {
        this._bigDecimal = arg;
        return this;
    }

    @Override
    public String getString() {
        return _string;
    }

    @Override
    public State withString(String arg) {
        this._string = arg;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return _bytes;
    }

    @Override
    public State withBytes(byte[] arg) {
        this._bytes = arg;
        return this;
    }

    @Override
    public List getList() {
        return _list;
    }

    @Override
    public State withList(List arg) {
        this._list = arg;
        return this;
    }

    @Override
    public Map<?, ?> getMap() {
        return _map;
    }

    @Override
    public State withMap(Map<?, ?> arg) {
        this._map = arg;
        return this;
    }


    @Override
    public Object getObject() {
        return _object;
    }

    @Override
    public State withObject(Object arg) {
        this._object = arg;
        return this;
    }
}
