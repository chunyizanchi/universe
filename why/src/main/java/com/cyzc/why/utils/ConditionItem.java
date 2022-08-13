package com.cyzc.why.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConditionItem implements ConditionI {

	private String key = "";
	private Object value;
	private List<Object> values;
	private String logic;
	private String alias;

	public ConditionItem() {
		logic = "";
		values = new ArrayList<Object>();
	}

	public void setLogic(String logic) {
		if (logic != null)
			this.logic = logic;

	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void addMultiValue(Object value) {
		values.add(value);
	}

	// 持续补充
	public String toString() {
		String s = "";
		String alias_ = "";
		if (ApplicationUtils.validStr(alias)) {
			alias_ = alias + ".";
		}
		if (value != null && value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (logic.equals(">=")) {
				s = alias_ + key + ">=to_date('" + sdf.format((Date) value) + "','yyyy-MM-dd HH24:mi:ss')";
			} else if (logic.equals("<")) {
				s = alias_ + key + "<to_date('" + sdf.format((Date) value) + "','yyyy-MM-dd HH24:mi:ss')";
			} else if (logic.equals("<=")) {
				s = alias_ + key + "<=to_date('" + sdf.format((Date) value) + "','yyyy-MM-dd HH24:mi:ss')";
			} else if (logic.equals("in_month")) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime((Date) value);
				// calendar.add(Calendar.MONTH, -1);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
				String firstDay = format.format(calendar.getTime());
				calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
				String lastDay = format.format(calendar.getTime());
				s = alias_ + key + ">=to_date('" + firstDay + " 00:00:00','yyyy-MM-dd HH24:mi:ss')";
				s = s + " and " + alias_ + key + "<=to_date('" + lastDay + " 23:59:59','yyyy-MM-dd HH24:mi:ss')";
			} else if (logic.equals("in_day")) {

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String startSecend = format.format((Date) value) + " 00:00:00";
				String endSecend = format.format((Date) value) + " 23:59:59";

				s = alias_ + key + ">=to_date('" + startSecend + "','yyyy-MM-dd HH24:mi:ss')";
				s = s + " and " + alias_ + key + "<=to_date('" + endSecend + "','yyyy-MM-dd HH24:mi:ss')";
			}
		}

		return s;

	}

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal_1 = Calendar.getInstance();
		cal_1.add(Calendar.MONTH, -1);
		// cal_1.set(Calendar.DAY_OF_MONTH, 1);
		cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));
		String firstDay = format.format(cal_1.getTime());
		
	}
}