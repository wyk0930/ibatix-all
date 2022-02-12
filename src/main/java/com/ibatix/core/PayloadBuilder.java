package com.ibatix.core;

public interface PayloadBuilder<T extends Payload> {

    T build();
}
