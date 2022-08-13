package com.cyzc.why.utils;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUtils implements InitializingBean {

    private String deployId = "";// 在aws上面部署时，会用到

    public static boolean DebugMode = false;

    private static Map<String, BufferedImage> qrCodeMap = new HashMap<String, BufferedImage>();


    public ApplicationUtils() {
        super();
        deployId = UUID.randomUUID().toString();

    }


    public String getDeployIdKey() {
        return "scrm-instance-" + deployId;
    }


    public static boolean validStr(Object str) {
        String c = (String) str;
		if (c != null && c.length() > 0) {
			return true;
		}
        return false;
    }

    public static String BigDecimalToString(BigDecimal b) {
		if (b == null) {
			return null;
		}
        return b.toString();
    }

    public static boolean validInt(String str, int min, int max) {
        try {
            int c = Integer.parseInt(str);
			if (c < min) {
				return false;
			}
			if (c > max) {
				return false;
			}
            return true;
        } catch (Exception e) {
        }
        return false;
    }


    public String genUploadResourceFilePath(HttpServletRequest request) {

        return null;
    }

    public static String hcCode(String str) {
        // cdm会对&进行处理，encode也行不通，cdm回调会uncode；所以将&暂时替换成一个特殊的字符串，自行code和uncode
        str = str.replace("&", "aaab8d96c4398d20");
        return str;
    }

    public static String hcUnCode(String str) {
        // cdm会对&进行处理，encode也行不通，cdm回调会uncode；所以将&暂时替换成一个特殊的字符串，自行code和uncode
        str = str.replace("aaab8d96c4398d20", "&");
        return str;
    }

    public static void main(String[] args) {
        String s = "deviceId=undefined&source_system=WECHAT&client=scrm&redirect_url";
        s = hcCode(s);
        System.out.println(s);

        s = hcUnCode(s);
        System.out.println(s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}