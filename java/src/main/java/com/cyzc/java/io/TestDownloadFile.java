package com.cyzc.java.io;

import java.io.File;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/06 23:18]
 */
public class TestDownloadFile {
    public static void main(String[] args) throws Exception{
        String urlStr = "https://github.com/alibaba/nacos/blob/master/config/src/main/resources/META-INF/nacos-db.sql";
        URL url = new URL(urlStr);
        String tempFileName = "E://test.sql";
        File temp = new File(tempFileName);
        FileUtils.copyURLToFile(url, temp);
    }

}
