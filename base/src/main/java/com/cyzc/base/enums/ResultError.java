package com.cyzc.base.enums;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 09:31]
 */
public enum ResultError {

    SUCCESS(200,"success"),
    FAILE(100,"AAAA");


    private int code;
    private String desc;
    private String enDesc;

    ResultError(int code, String msg) {
        this.code = code;
        this.desc = msg;
    }

    ResultError(int code, String msg, String enMsg) {
        this.code = code;
        this.desc = msg;
        this.enDesc = enMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEnDesc() {
        return enDesc;
    }

    public void setEnDesc(String enDesc) {
        this.enDesc = enDesc;
    }
}
