package com.manage.app.controller;

import java.sql.Timestamp;
import java.util.Date;

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

import com.manage.app.bean.ManageFunction;
import com.manage.app.service.ManageFunctionService;
import com.utis.Page;

/**
 * 功能管理
 * @author 武海辉
 *
 */



@Controller
@RequestMapping("/manage/manageFunction")
public class ManageFunctionController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageFunctionController.class);
	@Autowired
	private ManageFunctionService manageFunctionService;
	
	private final String LIST_ACTION = "redirect:/manage/manageFunction/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageFunction管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("manage/manageFunction/enter");
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
		String id=request.getParameter("id");
		if(id==""){
			id=null;
		}
		Page page = new Page(cpage,size,like,id);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = manageFunctionService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageFunction manageFunction = (ManageFunction) pageData.getList().get(i);
				result.append("{")
			    .append("\"functionId\":\"").append(manageFunction.getFunctionId()).append("\"").append(",")
			    .append("\"menuId\":\"").append(manageFunction.getMenuId()).append("\"").append(",")
			    .append("\"menuName\":\"").append(manageFunction.getMenuName()).append("\"").append(",")
			    .append("\"functionName\":\"").append(manageFunction.getFunctionName()).append("\"").append(",")
			    .append("\"functionDesc\":\"").append(manageFunction.getFunctionDesc()).append("\"").append(",")
			    .append("\"functionCode\":\"").append(manageFunction.getFunctionCode()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageFunction.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageFunction.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageFunction.getEditor()).append("\"")
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
			GSLogger.error("显示manageFunction列表时发生错误", e);
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
			GSLogger.error("进入manageFunction新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageFunction/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageFunction
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageFunction entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			manageFunctionService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageFunction信息时发生错误", e);
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
		ManageFunction entity=new ManageFunction();
		entity.setFunctionId(id);
		
		try{
			entity= manageFunctionService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageFunction修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageFunction/modify");
		mav.addObject("manageFunction", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageFunction entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageFunctionService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageFunction信息时发生错误", e);
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
						ManageFunction entity=new ManageFunction();
						entity.setFunctionId(Integer.parseInt(ids[i]));
						manageFunctionService.delete(entity);
					}
				}else{
					ManageFunction entity=new ManageFunction();
					entity.setFunctionId(Integer.parseInt(id));
					manageFunctionService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageFunction时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
