package com.cyzc.java.spi;

import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/19 09:19]
 */
public class DataSearch implements Search{

    @Override
    public List<String> searchDoc(String keyWord) {
        System.out.println("数据库搜素 "+keyWord);
        return null;
    }
}
