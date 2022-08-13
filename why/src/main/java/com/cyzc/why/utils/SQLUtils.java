package com.cyzc.why.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class SQLUtils {
	@Autowired
	JdbcTemplate jdbcTemplate;
	static SQLUtils sqlUtils;

	public SQLUtils() {
		sqlUtils = this;
	}

	public static void checkTempTable_OPENID(String tableName) {
		try {
			sqlUtils.jdbcTemplate.execute(
					"CREATE GLOBAL TEMPORARY TABLE " + tableName + " (OPENID VARCHAR2(50)) ON COMMIT PRESERVE ROWS");
		} catch (Exception e) {
		}

	}

	public static void checkAlias(Map<String, Object> paraMap, String alias) {
		Set set = paraMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object ob = paraMap.get(key);
			if (ob instanceof ConditionI) {
				((ConditionI) ob).setAlias(alias);
			}
		}
	}

	public static String andQueryConditon(List<ConditionItem> list) {
		String s = "";
		int i;
		if (list == null || list.size() == 0)
			return s;
		for (i = 0; i < list.size(); i++) {
			ConditionItem ob = list.get(i);
			if (ob == null)
				continue;

			s = s + " " + ((ConditionItem) ob).toString() + " and ";

		}
		if (s.length() > 0)
			s = s.substring(0, s.length() - 4);
		return s;
	}

	public static String andQueryConditon(Map<String, Object> paraMap, String alias) {

		String s = "";
		Set set = paraMap.keySet();
		Iterator it = set.iterator();
		String alias_ = "";
		if (ApplicationUtils.validStr(alias)) {
			alias_ = alias + ".";
		}
		while (it.hasNext()) {
			String key = (String) it.next();
			Object ob = paraMap.get(key);
			if (ob == null)
				continue;
			if (ob instanceof String) {
				if (ApplicationUtils.validStr((String) paraMap.get(key)))
					s = s + alias_ + key + "='" + ob.toString() + "' and ";
			} else if (ob instanceof ConditionI) {
				s = s + " " + ((ConditionI) ob).toString() + " and ";
			}

		}

		if (s.length() > 0)
			s = s.substring(0, s.length() - 4);

		return s;
	}

	public static Date getFirstSecondOfDay(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s1 = sf.format(date) + " 00:00:00";
		Date d = null;
		try {
			d = sf2.parse(s1);
		} catch (ParseException e) {

		}
		return d;
	}

	public static Date getLastSecondOfDay(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s1 = sf.format(date) + " 23:59:59";
		Date d = null;
		try {
			d = sf2.parse(s1);
		} catch (ParseException e) {

		}
		return d;
	}
}