package com.cyzc.java.serializable;

import java.io.Serializable;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/08 17:46]
 */
public class SerializableTest1 implements Serializable {

    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
