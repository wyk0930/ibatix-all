package com.ibatix.core.support;

/**
 * 自定义厂商代码
 *
 * @author Wang Yukun
 */
public enum VendorCode {
    // 日志
    LOG_0001("LOG_0001", ""),
    // 消息
    MSG_0004("MSG_0004", "{[0]} 值无效"),
    MSG_0003("MSG_0003", "{[0]} 唯一键格式错误"),
    MSG_0002("MSG_0002", "{[0]}用户保存失败"),
    MSG_0001("MSG_0001", ""),
    MSG_0000("MSG_0000", ""),
    // 命令返回
    CMD_0002("CMD_0002", "{[]} 命令执行失败"),
    CMD_0001("CMD_0001", "{[]} 命令创建失败"),
    CMD_0000("CMD_0000", "{[]} 命令无效"),
    // 错误
    ERR_9999("EER_9999", "未知异常"),
    EER_0001("ERR_0001", "消息内容无效"),
    ERR_0000("ERR_0000", "[{0}] 信息模版不存在");

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
