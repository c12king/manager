package com.manage.app;

import java.util.HashMap;
import java.util.Map;

import com.manage.framework.utils.MD5;

public class Test {
	public static void main(String[] args) {
		Map paramMap = new HashMap();
		MD5 md5 = new MD5(); 
		System.out.println(md5.getMD5ofStr("admin"));
      //  System.out.println(md5.getMD5ofStr(query.getAdminPassword())

	}
}
