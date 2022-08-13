package com.cyzc.why.handle;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/19 23:18]
 */
@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler({NullPointerException.class}) //指定拦截异常的类型
    @ResponseStatus(HttpStatus.BAD_GATEWAY) //自定义浏览器返回状态码
    public Map<String, Object> customExceptionHandler(NullPointerException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("type","null");
        map.put("msg", e);
        return map;
    }

}
