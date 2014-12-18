package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.manage.app.vo.BaseBean;


import com.manage.app.bean.ManageModulemenu;
import com.manage.app.service.ManageModulemenuService;
import com.manage.app.vo.ManageModulemenuQuery;


@Controller
@RequestMapping("/manage/manageModulemenu")
public class ManageModulemenuController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageModulemenuController.class);
	@Autowired
	private ManageModulemenuService manageModulemenuService;
	
	private final String LIST_ACTION = "redirect:/manage/manageModulemenu/list.do";
	
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageModulemenu
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		ManageModulemenu manageModulemenu = new ManageModulemenu();
		String[] menuId = request.getParameterValues("menuId");
		String moduleId = request.getParameter("moduleId");
		String json = "";
		try{
			manageModulemenuService.save(moduleId,menuId);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageModulemenu信息时发生错误：/manage/manageModulemenu/save", e);
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
