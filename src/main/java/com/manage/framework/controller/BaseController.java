package com.manage.framework.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.manage.framework.utils.converter.ConvertRegisterHelper;



/**   
 * * Multiaction Controller的基类. 对Spring的MultiActionController作了少量扩展，主要是对数据绑定校验的扩展,   
 * * 同时增加了{@link #saveMessage(HttpServletRequest, String) }，一个{@link #rendText(HttpServletResponse,String)}   
 * *    
 * */ 
public class BaseController extends MultiActionController {

	static {
		ConvertRegisterHelper.registerConverters();
	}
	
	public static void copyProperties(Object target, Object source) {
		BeanUtils.copyProperties(target, source);
	}
	
	public static <T> void copyProperties(Class<T> destClass, Object origin) {
		BeanUtils.copyProperties(destClass, origin);
	}
	
}
