package com.manage.framework.log;



import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

public class GSLogger {
	/**
	 * 内部使用的简单日期格式
	 */
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	/**
	 * 日志对象
	 */
	public static final Logger LOGGER = Logger.getLogger("simple");
}
