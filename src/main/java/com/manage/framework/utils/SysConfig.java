package com.manage.framework.utils;




public class SysConfig {

	/**
	 * 属性文件代理实类
	 */
	public final static PropertiesAgent PROPERTIES_AGENT = new PropertiesAgent("config/health_config");
	/**
	 * 文件上传路径
	 */
	public static final String FILE_UPLOAD_PATH = PROPERTIES_AGENT.getStringProperty("FILE_UPLOAD_PATH");
	/**
	 * 菜单项图标文件路径
	 */
	public static final String MENU_ITEM_ICON_PATH = PROPERTIES_AGENT.getStringProperty("MENU_ITEM_ICON_PATH");
	/**
	 * 菜单项图标文件大小
	 */
	public static final Integer MENU_ITEM_UPLOAD_SIZE = PROPERTIES_AGENT.getIntegerProperty("MENU_ITEM_UPLOAD_SIZE");
}
