package com.manage.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageAdmin;
import com.manage.app.service.ManageAdminService;
import com.manage.app.vo.ManageAdminQuery;
import com.manage.framework.utils.MD5;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	private static Logger GSLogger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private ManageAdminService manageAdminService;
	
	/**
	 * 进入管理业
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		HttpSession session = request.getSession();
		ManageAdmin manageAdmin = (ManageAdmin)session.getAttribute("manageAdmin");
		if(manageAdmin == null) {
			mav=new ModelAndView("login");
		}else{
			mav=new ModelAndView("main");
		}		
		return mav;
	}
	
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping(value="login")
	public void login(HttpServletRequest request, HttpServletResponse response, ManageAdminQuery query) {		
		String json = "";
		ManageAdmin manageAdmin = new ManageAdmin();
		try{
			Map paramMap = new HashMap();
			MD5 md5 = new MD5();  
	        System.out.println(md5.getMD5ofStr(query.getAdminPassword()));
			paramMap.put("adminName", query.getAdminName());
			paramMap.put("adminPassword", md5.getMD5ofStr(query.getAdminPassword()));
			List list = manageAdminService.findByMap(paramMap);
			if(list != null && list.size() > 0) {
				manageAdmin = (ManageAdmin) list.get(0);
				HttpSession session = request.getSession();
				session.setAttribute("manageAdmin", manageAdmin);
				session.setMaxInactiveInterval(60 * 60 * 1000);
				//登录成功
				json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
			}else{
				//登录失败
				json = "{\"success\":\"false\",\"message\":\"账号或者密码错误\"}";
			}			
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"账号或者密码错误\"}";
			GSLogger.error("进入IndexController管理页时发生错误：/login", e);
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
	
	/**
	 * 管理员登出
	 * @return
	 */
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, ManageAdminQuery query) {		
		ModelAndView mav=new ModelAndView();
		try{
			HttpSession session = request.getSession();
			ManageAdmin manageAdmin = (ManageAdmin)session.getAttribute("manageAdmin");
			if(manageAdmin != null) {
				session.setAttribute("manageAdmin", null);
			}
			session.invalidate();
			//登出成功		
		}catch(Exception e){
			GSLogger.error("进入IndexController管理页时发生错误：/logout", e);
			e.printStackTrace();
		}
		mav=new ModelAndView("login");
		return mav;
	}

}
