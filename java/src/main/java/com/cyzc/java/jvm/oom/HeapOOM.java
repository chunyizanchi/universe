package com.cyzc.java.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-08-19
 */
public class HeapOOM {


    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();

        while (true){
            list.add(new OOMObject());
        }
    }

}