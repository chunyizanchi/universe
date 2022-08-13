package com.cyzc.why.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BenzStatic {

	public static String POWER = "requestLog,eqCharge,issue,user,userGroup,newestActivity,currencyDealer,customerCar,activity,activity2,subscribe,dictionary,helper,driverManual,recommend,kpi,bbs,teddy,who,welfare,magazine,focus,dealer,excle,content,activitySms,message,surveyDirectory,feedBackInfo,activitySms,activitySpecialRecoro,activitySpecialShare,scanRecordInfo,scanRecordInfo,external";
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	private static final Logger logger = LoggerFactory.getLogger(BenzStatic.class);

	public static String getUniqueId() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String UniqueId = df.format(new Date());
		int s = 0;
		for (int i = 0; i < 6; i++) {
			s = (int) (Math.random() * 10);
			if (s == 10) {
				s = s - 1;
			}
			UniqueId += s;
		}
		return UniqueId;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
			System.out.println(BenzStatic.getUniqueId());
		}

	}

	/*public static String ClobToString(Clob clob) throws SQLException, IOException {
		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}

	// 获取并集
	public static List<Map<String, Object>> getAddAllList(List<Map<String, Object>> CustomerLists,
			List<Map<String, Object>> CustomerList) {
		// 自我遍历
		for (int i = 0, l = CustomerLists.size(); i < l; i++) {
			if ((i + 1) < CustomerLists.size()) {
				if (CustomerLists.get(i).get("OPENID").equals(CustomerLists.get(i + 1).get("OPENID"))) {
					CustomerLists.remove((i + 1));
					i = i - 1;
					l = CustomerLists.size();
				} else {
					continue;
				}
			}
		}
		// 并集
		for (int i = 0, l = CustomerLists.size(); i < l; i++) {
			for (int j = 0, k = CustomerList.size(); j < k; j++) {
				if (CustomerLists.get(i).get("OPENID").equals(CustomerList.get(j).get("OPENID"))) {
					CustomerList.remove(j);
					j = j - 1;
					k = CustomerList.size();
				} else {
					continue;
				}
			}
		}
		CustomerLists.addAll(CustomerList);
		return CustomerLists;
	}

	*//**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 *//*
	static Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-server1.cn.svc.corpintra.net", 3128));

	public static String net(String strUrl, Map params, String method) throws Exception {

		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {

			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}

			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection(proxy);
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}

			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);

			conn.connect();

			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
					// out.writeUTF(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Map<String, Object> pram = new HashMap<String, Object>();
		pram.put("user", "jsSign");
		pram.put("psw", "!Q@W)PLM,,");
		pram.put("appId", "wxb683a9db0c3bb076");
		
	}

	// 将list型
	public static List<Map<String, Object>> jiaMiList(List<Map<String, Object>> data) {
		List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
		Map<String, Object> newMap = new HashMap<String, Object>();
		// CommonServiceImpl commonServiceImpl = new CommonServiceImpl() ;
		for (int i = 0; i < data.size(); i++) {
			for (Map.Entry j : data.get(i).entrySet()) {
				
				
				newMap.put(j.getKey() + "", FormatUtils.format1(j.getValue().toString()));
			}
			newList.add(newMap);
		}
		return newList;
	}

	// 将map
	public static Map<String, Object> jiaMiMap(Map<String, Object> data) {
		// CommonServiceImpl commonServiceImpl = new CommonServiceImpl() ;
		Map<String, Object> newMap = new HashMap<String, Object>();
		for (Map.Entry i : data.entrySet()) {
			newMap.put(i.getKey() + "", FormatUtils.format1(i.getValue().toString()));
		}
		return newMap;
	}

	// 将String型
	public static List<String> jiaMiString(List<String> data) {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			String data1 = FormatUtils.format1(data.get(i));

			newList.add(data1);
		}
		return newList;
	}

	// 将String型
	public static List<String> jieMiString(List<String> data) {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			String data1 = FormatUtils.format2(data.get(i));
			newList.add(data1);
		}
		return newList;
	}

	// 将list型
	public static List<Map<String, Object>> jieMiList(List<Map<String, Object>> data) {
		List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
		Map<String, Object> newMap = new HashMap<String, Object>();
		// CommonServiceImpl commonServiceImpl = new CommonServiceImpl() ;
		for (int i = 0; i < data.size(); i++) {
			for (Map.Entry j : data.get(i).entrySet()) {

				newMap.put(j.getKey() + "", FormatUtils.format2(j.getValue().toString()));
			}
			newList.add(newMap);
		}
		return newList;
	}

	// 将map
	public static Map<String, Object> jieMiMap(Map<String, Object> data) {
		// CommonServiceImpl commonServiceImpl = new CommonServiceImpl() ;
		Map<String, Object> newMap = new HashMap<String, Object>();
		for (Map.Entry i : data.entrySet()) {
			newMap.put(i.getKey() + "", FormatUtils.format2(i.getValue().toString()));
		}
		return newMap;
	}

	// sha1算法
	public static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static String Utf82GBK(String inStr) {
		String outStr = "";
		try {
			byte[] temp = inStr.getBytes("utf-8");
			byte[] newtemp = new String(temp, "utf-8").getBytes("gbk");
			outStr = new String(newtemp, "gbk");

		} catch (Exception e) {

		}

		return outStr;
	}
*/
}
