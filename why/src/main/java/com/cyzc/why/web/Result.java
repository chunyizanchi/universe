package com.cyzc.why.web;

import com.cyzc.why.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/20 00:19]
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Result<T> {

    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("code")
    private Long code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
    @JsonProperty("timestamp")
    private Long timestamp;




    public Result() {
    }



}
