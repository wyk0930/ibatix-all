package com.ibatix.core;

/**
 * 自定义厂商代码
 *
 * @author Wang Yukun
 */
public enum VendorCode {
    ERR_00004("ERR_00004", "{[0]} 值无效"),
    ERR_00003("ERR_00003", "{[0]} 唯一键格式错误"),
    ERR_00002("ERR_00002", "{[0]}用户保存失败"),
    EER_00001("ERR_00001", "消息内容无效"),
    ERR_00000("ERR_00000", "[{0}] 信息模版不存在");
//    _00008("ZC_00008", "文件下载失败，MD5=[0]"),
//    _00007("ZC_00007", "当前ID错误 [{0}]"),
//    _00006("ZC_00006", "数据格式化失败"),
//    _00005("ZC_00005", "用户名或密码错误"),
//    _00004("ZC_00004", "文件{0}失败"),
//    _00003("ZC_00003", "使用算法不支持 [{0}]"),
//    _00002("ZC_00002", "无效算法"),

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
