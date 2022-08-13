package com.cyzc.base.web;

import com.cyzc.base.enums.ResultError;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 00:38]
 */

public class Response<T> {

    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
    @JsonProperty("timestamp")
    private Long timestamp;

    public static <T> Response<T> result(InterfaceRequest request, T result) {
        return new Response(request.getRequestId(), ResultError.SUCCESS.getCode(), ResultError.SUCCESS.getDesc(), result, System.currentTimeMillis());
    }


    public Response(String requestId, Integer code, String message, T data, Long timestamp) {
        this.requestId = requestId;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public Response() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


}
