package com.x.utils;

import org.apache.commons.lang3.StringUtils;



/**
 * <p>Description:</p>
 * @Author Chenkangming 
 * @Date 2014-9-26
 * @version 1.0
 */
public class NumUtils {
	/**
	 * 校验为int型
	 * 
	 * @param args
	 * @return true/flase
	 */
	public static boolean isInt(String... args) {
		for (String a : args) {
			try {
				Integer.valueOf(a);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 校验非int型
	 * 
	 * @param args
	 * @return true/flase
	 */
	public static boolean isNotInt(String... args) {
		if (!isInt(args)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 转化为int
	 * 
	 * @param value
	 * @return 0
	 */
	public static int toInt(String value) {
		int num = 0;
		if(StringUtils.isEmpty(value)){
			return num;
		}
		try {
			num = Integer.parseInt(value);
		} catch (Exception e) {
			num = 0;
		}
		return num;
	}

	/**
	 * 转化为long
	 * 
	 * @param value
	 * @return
	 */
	public static long toLong(String value) {
		long num = 0;
		if(StringUtils.isEmpty(value)){
			return num;
		}
		try {
			num = Long.valueOf(value);
		} catch (Exception e) {
			num = 0;
		}
		return num;
	}
}
