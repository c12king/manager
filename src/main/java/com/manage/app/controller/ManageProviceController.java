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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageProvice;
import com.manage.app.service.ManageProviceService;
import com.utis.Page;





@Controller
@RequestMapping("/manage/manageProvice")
public class ManageProviceController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageProviceController.class);
	@Autowired
	private ManageProviceService manageProviceService;
	
	private final String LIST_ACTION = "redirect:/manage/manageProvice/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageProvice管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageProvice/enter");
		return mav;
	}
	/**
	 * 进入省市区管理页
	 * @return
	 */
	@RequestMapping(value="ProvinceCityManagement")
	public ModelAndView ProvinceCityManagement() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageProvice管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageProvice/ProvinceCityManagement");
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
	public void treeData(HttpServletRequest request,HttpServletResponse response,ManageProvice entity) throws Exception{
		String json=manageProviceService.treeData(entity);
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
			Page pageData = manageProviceService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageProvice manageProvice = (ManageProvice) pageData.getList().get(i);
				result.append("{")
			    .append("\"proviceId\":\"").append(manageProvice.getProviceId()).append("\"").append(",")
			    .append("\"provinceName\":\"").append(manageProvice.getProvinceName()).append("\"").append(",")
			    .append("\"provinceCode\":\"").append(manageProvice.getProvinceCode()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageProvice.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageProvice.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageProvice.getEditor()).append("\"").append(",")
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
			GSLogger.error("显示manageProvice列表时发生错误", e);
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
			GSLogger.error("进入manageProvice新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageProvice/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageProvice
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageProvice entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			manageProviceService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageProvice信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据id查省份信息
	 * @return
	 */
	@RequestMapping(value="selectProviceId")
	public void selectProviceId(HttpServletRequest request, HttpServletResponse response) {	
		int id= Integer.parseInt(request.getParameter("id"));
		ManageProvice entity=new ManageProvice();
		entity.setProviceId(id);;
		String json="";
		try{
			entity= manageProviceService.findById(entity);
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
		ManageProvice entity=new ManageProvice();
		entity.setProviceId(id);
		
		try{
			entity= manageProviceService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageProvice修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageProvice/modify");
		mav.addObject("manageProvice", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageProvice entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageProviceService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageProvice信息时发生错误", e);
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
						ManageProvice entity=new ManageProvice();
						entity.setProviceId(Integer.parseInt(ids[i]));
						manageProviceService.delete(entity);
					}
				}else{
					ManageProvice entity=new ManageProvice();
					entity.setProviceId(Integer.parseInt(id));
					manageProviceService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageProvice时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
