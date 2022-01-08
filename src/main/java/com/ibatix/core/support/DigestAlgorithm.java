package com.ibatix.core.support;

/**
 * 消息摘要
 *
 * @author master
 */
public enum DigestAlgorithm {
    MD5("MD5"),
    SHA256("SHA-256");

    private String value;

    DigestAlgorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
