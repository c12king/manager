package com.manage.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manage.app.common.ModuleConst;
import com.manage.app.service.ManageUserFunctionService;


@Controller
@RequestMapping("/manage/manageUserFunction")
public class ManageUserFunctionController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageUserFunctionController.class);
	@Autowired
	private ManageUserFunctionService manageUserFunctionService;
	
	private final String LIST_ACTION = "redirect:/manage/manageUserFunction/list.do";
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageUserFunction
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		String[] functionIdOPERATION = request.getParameterValues("functionId"+ModuleConst.OPERATION_CODE);
		String[] functionIdCOMMUNITY = request.getParameterValues("functionId"+ModuleConst.COMMUNITY_CODE);
		String[] functionIdPROPERTY = request.getParameterValues("functionId"+ModuleConst.PROPERTY_CODE);
		String[] functionIdSTATION = request.getParameterValues("functionId"+ModuleConst.STATION_CODE);
		String userId = request.getParameter("userId");
		String json = "";
		try{
			manageUserFunctionService.save(userId,functionIdOPERATION,functionIdCOMMUNITY,functionIdPROPERTY,functionIdSTATION);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageUserFunction信息时发生错误：/manage/manageUserFunction/save", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
