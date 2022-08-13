package com.cyzc.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.cyzc.springboot.entity.POSTCHECK_KEYWORDS;
import java.io.FileNotFoundException;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/29 12:47]
 */
public class TestEasyExcel {
//POSTCHECK_KEYWORDS2.xls
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "C:\\Users\\10219\\Desktop\\POSTCHECK_KEYWORDS3.xls";

        EasyExcel.read(fileName, POSTCHECK_KEYWORDS.class,
                new PageReadListener<POSTCHECK_KEYWORDS>(dataList -> {
                    for (POSTCHECK_KEYWORDS demoData : dataList) {
                     /*   if (null == demoData.getTEXT()) {
                            System.out.println(demoData.POST_KEYWORDS_ID);
                            continue;

                        }*/
                        if ("还没有开始".contains(demoData.getTEXT())) {
                            ;
                            System.out.println(demoData.getTEXT()+"ss"+demoData.getPOST_KEYWORDS_ID());
                        }

                    }
                })).sheet().doRead();

    }
}
