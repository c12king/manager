package com.manage.app.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.AppUser;
import com.manage.app.service.AppUserService;
import com.utis.Page;





@Controller
@RequestMapping("/app/appUser")
public class AppUserController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppUserController.class);
	@Autowired
	private AppUserService appUserService;
	
	private final String LIST_ACTION = "redirect:/app/appUser/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/appUser/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		int cpage=Integer.parseInt(request.getParameter("page"));
		int size=Integer.parseInt(request.getParameter("rows"));
		String like=request.getParameter("name");
		Page page = new Page(cpage,size,like);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = appUserService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				AppUser appUser = (AppUser) pageData.getList().get(i);
				result.append("{")
			    .append("\"userId\":\"").append(appUser.getUserId()).append("\"").append(",")
			    .append("\"realname\":\"").append(appUser.getRealname()).append("\"").append(",")
			    .append("\"nickname\":\"").append(appUser.getNickname()).append("\"").append(",")
			    .append("\"password\":\"").append(appUser.getPassword()).append("\"").append(",")
			    .append("\"tel\":\"").append(appUser.getTel()).append("\"").append(",")
			    .append("\"sex\":\"").append(appUser.getSex()).append("\"").append(",")
			    .append("\"birthday\":\"").append(appUser.getBirthday()).append("\"").append(",")
			    .append("\"type\":\"").append(appUser.getType()).append("\"").append(",")
			    .append("\"state\":\"").append(appUser.getState()).append("\"").append(",")
			    .append("\"random\":\"").append(appUser.getRandom()).append("\"").append(",")
			    .append("\"registTime\":\"").append(appUser.getRegistTime()).append("\"").append(",")
			    .append("\"verifyTime\":\"").append(appUser.getVerifyTime()).append("\"").append(",")
			    .append("\"verifier\":\"").append(appUser.getVerifier()).append("\"").append(",")
			    .append("\"portrait\":\"").append(appUser.getPortrait()).append("\"").append(",")
			    .append("\"idCard\":\"").append(appUser.getIdCard()).append("\"").append(",")
			    .append("\"estateId\":\"").append(appUser.getEstateId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appUser.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appUser.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appUser.getEditor()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(pageData.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("显示appUser列表时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUser新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/appUser/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appUser
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppUser entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			entity.setRegistTime(ts);
			appUserService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存appUser信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		AppUser entity=new AppUser();
		entity.setUserId(id);
		
		try{
			entity= appUserService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入appUser修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/appUser/modify");
		mav.addObject("appUser", entity);
		return mav;
	}
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppUser entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			appUserService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑appUser信息时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 删除单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public void delete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						AppUser entity=new AppUser();
						entity.setUserId(Integer.parseInt(ids[i]));
						appUserService.delete(entity);
					}
				}else{
					AppUser entity=new AppUser();
					entity.setUserId(Integer.parseInt(id));
					appUserService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除AppUser时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
