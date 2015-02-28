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

import com.manage.app.bean.ManageUnit;
import com.manage.app.service.ManageUnitService;
import com.utis.Page;





@Controller
@RequestMapping("/manage/manageUnit")
public class ManageUnitController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageUnitController.class);
	@Autowired
	private ManageUnitService manageUnitService;
	
	private final String LIST_ACTION = "redirect:/manage/manageUnit/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageUnit管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageUnit/enter");
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
		ManageUnit manageUnit=new ManageUnit();
		String id=request.getParameter("id");
		manageUnit.setBuildingId(new Integer(id));
		String json=manageUnitService.treeData(manageUnit);
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
			Page pageData = manageUnitService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageUnit manageUnit = (ManageUnit) pageData.getList().get(i);
				result.append("{")
			    .append("\"unitId\":\"").append(manageUnit.getUnitId()).append("\"").append(",")
			    .append("\"buildingId\":\"").append(manageUnit.getBuildingId()).append("\"").append(",")
			    .append("\"unitName\":\"").append(manageUnit.getUnitName()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(manageUnit.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(manageUnit.getEstateLatitude()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageUnit.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageUnit.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageUnit.getEditor()).append("\"").append(",")
			    .append("\"unitMap\":\"").append(manageUnit.getUnitMap()).append("\"").append(",")
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
			GSLogger.error("显示manageUnit列表时发生错误", e);
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
			GSLogger.error("进入manageUnit新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageUnit/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageUnit
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageUnit entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			manageUnitService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageUnit信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id查单元信息
	 * @return
	 */
	@RequestMapping(value="selectUnitId")
	public void selectUnitId(HttpServletRequest request, HttpServletResponse response) {	
		int id= Integer.parseInt(request.getParameter("id"));
		ManageUnit entity=new ManageUnit();
		entity.setUnitId(id);
		String json="";
		try{
			entity= manageUnitService.findById(entity);
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
		ManageUnit entity=new ManageUnit();
		entity.setUnitId(id);
		
		try{
			entity= manageUnitService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageUnit修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageUnit/modify");
		mav.addObject("manageUnit", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageUnit entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageUnitService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageUnit信息时发生错误", e);
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
						ManageUnit entity=new ManageUnit();
						entity.setUnitId(Integer.parseInt(ids[i]));
						manageUnitService.delete(entity);
					}
				}else{
					ManageUnit entity=new ManageUnit();
					entity.setUnitId(Integer.parseInt(id));
					manageUnitService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageUnit时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
