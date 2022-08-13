package com.cyzc.java.entity;

import lombok.Data;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/15 10:36]
 */
@Data
public class LuaResult<T> {
    protected String code;

    protected String msg;

    protected T data;
}
