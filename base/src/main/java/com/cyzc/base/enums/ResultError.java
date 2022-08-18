package com.cyzc.base.enums;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 09:31]
 */
public enum ResultError {

    SUCCESS(200,"请求成功","succeed"),
    FAILURE(100,"请求失败","request error");


    private Integer code;
    private String desc;
    private String enDesc;

    ResultError(Integer code, String msg) {
        this.code = code;
        this.desc = msg;
    }

    ResultError(Integer code, String msg, String enMsg) {
        this.code = code;
        this.desc = msg;
        this.enDesc = enMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
