package com.manage.app.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WSRetConfig {
	static Properties prop = new Properties();

	static {

		InputStream is;

		try {
			is = WSRetConfig.class.getClassLoader().getResourceAsStream("wsret.properties");
			prop.load(is);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) {
		 System.out.println( WSRetConfig.getProperty("WS_RET_CODE-623"));
	}
}
