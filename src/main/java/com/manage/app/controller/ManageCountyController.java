package com.manage.app.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageCounty;
import com.manage.app.service.ManageCountyService;
import com.utis.Page;





@Controller
@RequestMapping("/manage/manageCounty")
public class ManageCountyController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageCountyController.class);
	@Autowired
	private ManageCountyService manageCountyService;
	
	private final String LIST_ACTION = "redirect:/manage/manageCounty/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageCounty管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageCounty/enter");
		return mav;
	}
	
	
	/**
	 * 获取菜单树形展示json数据
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/treeData",produces="text/plain;charset=utf-8")
	public void treeData(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		ManageCounty manageCounty=new ManageCounty();
		String id=request.getParameter("id");
		manageCounty.setCityId(new Integer(id));
		String json=manageCountyService.treeData(manageCounty);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
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
			Page pageData = manageCountyService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageCounty manageCounty = (ManageCounty) pageData.getList().get(i);
				result.append("{")
			    .append("\"countyId\":\"").append(manageCounty.getCountyId()).append("\"").append(",")
			    .append("\"cityId\":\"").append(manageCounty.getCityId()).append("\"").append(",")
			    .append("\"countyName\":\"").append(manageCounty.getCountyName()).append("\"").append(",")
			    .append("\"countyCode\":\"").append(manageCounty.getCountyCode()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageCounty.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageCounty.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageCounty.getEditor()).append("\"").append(",")
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
			GSLogger.error("显示manageCounty列表时发生错误", e);
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
			GSLogger.error("进入manageCounty新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageCounty/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageCounty
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageCounty entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			manageCountyService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageCounty信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据id查区域信息
	 * @return
	 */
	@RequestMapping(value="selectCountyId")
	public void selectCountyId(HttpServletRequest request, HttpServletResponse response) {	
		int id= Integer.parseInt(request.getParameter("id"));
		ManageCounty entity=new ManageCounty();
		entity.setCountyId(id);
		String json="";
		try{
			entity= manageCountyService.findById(entity);
			json=JSONObject.fromObject(entity).toString();
		}catch(Exception e){
			GSLogger.error("进入manageBuilding修改页时发生错误", e);
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
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		ManageCounty entity=new ManageCounty();
		entity.setCountyId(id);
		
		try{
			entity= manageCountyService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageCounty修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageCounty/modify");
		mav.addObject("manageCounty", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageCounty entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageCountyService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageCounty信息时发生错误", e);
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
						ManageCounty entity=new ManageCounty();
						entity.setCountyId(Integer.parseInt(ids[i]));
						manageCountyService.delete(entity);
					}
				}else{
					ManageCounty entity=new ManageCounty();
					entity.setCountyId(Integer.parseInt(id));
					manageCountyService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageCounty时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 获取区域下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/getComboboxData" )
	public void getComboboxData(HttpServletRequest request,HttpServletResponse response){
		ManageCounty ManageCounty =new ManageCounty();
		ManageCounty.setCityId(1);
		String json=manageCountyService.getComboboxData(ManageCounty);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
}
