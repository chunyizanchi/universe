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

    public static Response<Void> success(InterfaceRequest request) {
        return new Response(request.getRequestId(), ResultError.SUCCESS.getCode(), ResultError.SUCCESS.getDesc(), (Object)null, System.currentTimeMillis());
    }

    public static <T> Response<T> failure(InterfaceRequest request, String message) {
        return new Response(request.getRequestId(), ResultError.FAILURE.getCode(), message, (Object)null, System.currentTimeMillis());
    }

    public static <T> Response<T> error(InterfaceRequest request, ResultError osError, String message) {
        return new Response(request.getRequestId(), osError.getCode(), message, (Object)null, System.currentTimeMillis());
    }

    public static <T> Response<T> code(InterfaceRequest request, Integer code, String message) {
        return new Response(request.getRequestId(), code, message, (Object)null, System.currentTimeMillis());
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
    public static class ResponseBuilder<T> {
        private String requestId;
        private Integer code;
        private String message;
        private T data;
        private Long timestamp;

        ResponseBuilder() {
        }

        public ResponseBuilder<T> requestId(final String requestId) {
            this.requestId = requestId;
            return this;
        }

        public ResponseBuilder<T> code(final Integer code) {
            this.code = code;
            return this;
        }

        public ResponseBuilder<T> message(final String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public ResponseBuilder<T> timestamp(final Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Response<T> build() {
            return new Response(this.requestId, this.code, this.message, this.data, this.timestamp);
        }

        public String toString() {
            return "PmmsResponse.PmmsResponseBuilder(requestId=" + this.requestId + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", timestamp=" + this.timestamp + ")";
        }
    }

}
