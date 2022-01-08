package com.ibatix.core;

/**
 * 自定义厂商代码
 *
 * @author Wang Yukun
 */
public enum VendorCode {
    ZC_00008("ZC_00008", "文件下载失败，MD5=[0]"),
    ZC_00007("ZC_00007", "当前ID错误 [{0}]"),
    ZC_00006("ZC_00006", "数据格式化失败"),
    ZC_00005("ZC_00005", "用户名或密码错误"),
    ZC_00004("ZC_00004", "文件{0}失败"),
    ZC_00003("ZC_00003", "使用算法不支持 [{0}]"),
    ZC_00002("ZC_00002", "无效算法"),
    ZC_00001("ZC_00001", "消息内容无效"),
    ZC_00000("ZC_00000", "[{0}] 信息模版不存在");

    /**
     * 构造器
     *
     * @param vendorCode 厂商代代码
     * @param template   消息模板
     */
    VendorCode(String vendorCode, String template) {
        this.vendorCode = vendorCode;
        this.template = template;
    }

    /**
     * 厂商代码
     */
    private String vendorCode;

    /**
     * 消息模版
     */
    private String template;

    /**
     * 获取厂商代码
     *
     * @return 厂商代码
     */
    public String getVendorCode() {
        return vendorCode;
    }

    /**
     * 获取消息模版
     *
     * @return 消息模版
     */
    public String getTemplate() {
        return template;
    }
}
