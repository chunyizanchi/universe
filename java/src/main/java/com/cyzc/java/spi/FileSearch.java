package com.cyzc.java.spi;

import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/19 09:18]
 */
public class FileSearch implements Search {

    @Override
    public List<String> searchDoc(String keyWord) {
        System.out.println("文件搜索：" + keyWord);
        return null;
    }
}
