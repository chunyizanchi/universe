package com.cyzc.why.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
	/**
	 * 通过url获取返回的json字符串
	 * 
	 * @param url
	 * @return
	 */
	public static String loadJSON(String url) {
		StringBuilder sb = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
		}
		return sb.toString();
	}
	/*
	 * if s is null return true else return false
	 */
	public static boolean isNull(String s)
	{
		if (s == null)
			return true;
		else
			return false;
	}

	/**
	 * 判断s是否为空字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isSpace(String s)
	{
		if (isNull(s) || "".equals(s.trim()))
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * 获取文件类型
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName)
	{
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	public static String Html2Text(String inputString)
	{
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;

		Pattern p_html1;
		Matcher m_html1;

		try
		{
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String regEx_html1 = "<[^>]+";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			// 去掉空格
			htmlStr = htmlStr.replaceAll("&nbsp;", "");

			textStr = htmlStr;

		} catch (Exception e)
		{
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	public static String convertArrayToString(String[] src, String split)
	{
		String dest = "";
		for (int i = 0; i < src.length; i++)
		{
			dest += src[i] + split;
		}

		return dest.substring(0, dest.length() - 1);
	}

	public static String[] convertStringToArray(String src, String split)
	{
		return src.split(split);
	}

	public static String convertToBr(String src)
	{
		if (src != null && src.length() > 0)
		{
			return src.replaceAll("\n", "<br/>");
		} else
		{
			return null;
		}

	}

	// 将字符串中间几位替换成星号(*)
	public static String convertToAsterisk(String src, int start, int end)
	{
		if (end <= 0)
		{
			end = src.length() + end;
		}
		int length = end - start;
		if (end > src.length())
		{
			return null;
		} else
		{
			String as = "";
			for (int i = 0; i < length; i++)
			{
				as += "*";
			}
			String rap = src.substring(start, end);
			src = src.replace(rap, as);
			return src;
		}
	}

	// 根据身份证号获取性别0、出生日期1
	public static String[] convertId(String IDCard)
	{
		String arr[] = { null, null };
		// 身份证15位时
		if (IDCard.length() == 15)
		{
			String nian = IDCard.substring(6, 8);
			String yue = IDCard.substring(8, 10);
			String ri = IDCard.substring(10, 12);
			String xb = IDCard.substring(14, 15);
			if (Integer.valueOf(xb) % 2 == 0)
			{
				arr[0] = "女";
			} else
			{
				arr[0] = "男";
			}
			arr[1] = "19" + nian + "-" + yue + "-" + ri;
			return arr;
		}
		// 身份证18位时
		if (IDCard.length() == 18)
		{
			String nian = IDCard.substring(6, 10);
			String yue = IDCard.substring(10, 12);
			String ri = IDCard.substring(12, 14);
			String xb = IDCard.substring(16, 17);
			if (Integer.valueOf(xb) % 2 == 0)
			{
				arr[0] = "女";
			} else
			{
				arr[0] = "男";
			}
			arr[1] = nian + "-" + yue + "-" + ri;
			return arr;
		}
		return null;
	}

	// 根据长度,返回number的填充字符串
	public static String convertStr(Integer number, int lenth)
	{
		String temp_src = "";
		for (int i = 0; i < lenth; i++)
		{
			temp_src += "0";
		}
		DecimalFormat df = new DecimalFormat(temp_src);
		return df.format(number);
	}

	// DISTINCT掉重复的字符串,保留一个
	public static List<String> str_distinct(List<String> list)
	{
		List<String> distinctList = new ArrayList<String>();

		for (String str : list)
		{
			if (!distinctList.contains(str))
			{
				distinctList.add(str);
			}
		}
		return distinctList;
	}
	public static int FNVHash1(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++)
            hash = (hash ^ data.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     * 分割中文姓名
     * @param name
     * @return
     */
	public static String[] getSplitName(String name) {
		String[] bai = { "欧阳", "太史", "上官", "端木", "司马", "东方", "独孤", "南宫", "万俟", "闻人", "夏侯", "诸葛", "尉迟", "公羊", "赫连", "澹台",
				"皇甫", "宗政", "濮阳", "公冶", "太叔", "申屠", "公孙", "慕容", "仲孙", "钟离", "长孙", "宇文", "司徒", "鲜于", "司空", "闾丘", "子车",
				"亓官", "司寇", "巫马", "公西", "颛孙", "壤驷", "公良", "漆雕", "乐正", "宰父", "谷梁", "拓跋", "夹谷", "轩辕", "令狐", "段干", "百里",
				"呼延", "东郭", "南门", "羊舌", "微生", "公户", "公玉", "公仪", "梁丘", "公仲", "公上", "公门", "公山", "公坚", "左丘", "公伯", "西门",
				"公祖", "第五", "公乘", "贯丘", "公皙", "南荣", "东里", "东宫", "仲长", "子书", "子桑", "即墨", "达奚", "褚师", "吴铭" };
		String name1 = name.substring(0, 2);
		String namef = "";
		String names = "";
		boolean flag = false;
		for (int i = 0; i < bai.length; i++) {
			if (name1.equals(bai[i])) {
				flag = true;
				namef = name1;
				names = name.substring(2);
				break;
			}
		}
		if (!flag) {
			namef = name.substring(0, 1);
			names = name.substring(1);
		}
		String[] sp = new String[2];
		sp[0] = namef;
		sp[1] = names;
		return sp;
	}

    /**
     * 提取字符串中的数字
     * @param inputP
     * @return
     */
    public static String getNumber(String inputP) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(inputP);
        return m.replaceAll("").trim();
    }

	/**
	 * 判断字符串中是否有汉字
	 * @param value
	 * @return
	 */
	public static boolean hasChinese(String value) {

		// 汉字的Unicode取值范围
		String regex = "[\u4e00-\u9fa5]";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(value);

		return match.find();

	}

	/**
	 * 转UTF8
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {

					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
	
	public static String getUrlParam(String url, String name) {
	    String params = url.substring(url.indexOf("?") + 1, url.length());
	    String paraArry[] = params.split("&");
	    for (String str : paraArry) {
	    	String[] eqArry = str.split("=");
	    	if (name.equals(eqArry[0])) {
				return eqArry[1];
			} 
		}
	    return null;
	}
	
	public static int toHash(String key) {
		int arraySize = 11113; // 数组大小一般取质数
		int hashCode = 0;
		for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
			int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
													// 就代表a的值，同理b=2；
			hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
		}
		return hashCode;
	}
 
	
	public static void main(String[] args)
	{
		
		String url = "https://www.baidu.com?a=b&jumpXid=c&c=d&d=e";
		
		System.out.print(getUrlParam(url, "jumpXid"));
		
		
		
	}

}
