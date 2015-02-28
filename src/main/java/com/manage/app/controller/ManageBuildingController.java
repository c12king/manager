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

import com.manage.app.bean.ManageBuilding;
import com.manage.app.service.ManageBuildingService;
import com.utis.Page;





@Controller
@RequestMapping("/manage/manageBuilding")
public class ManageBuildingController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageBuildingController.class);
	@Autowired
	private ManageBuildingService manageBuildingService;
	
	private final String LIST_ACTION = "redirect:/manage/manageBuilding/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageBuilding管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageBuilding/enter");
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
		ManageBuilding manageBuilding=new ManageBuilding();
		String id=request.getParameter("id");
		manageBuilding.setEstateId(new Integer(id));
		String json=manageBuildingService.treeData(manageBuilding);
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
			Page pageData = manageBuildingService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageBuilding manageBuilding = (ManageBuilding) pageData.getList().get(i);
				result.append("{")
			    .append("\"buildingId\":\"").append(manageBuilding.getBuildingId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(manageBuilding.getEstateId()).append("\"").append(",")
			    .append("\"buildingName\":\"").append(manageBuilding.getBuildingName()).append("\"").append(",")
			    .append("\"buildingDesc\":\"").append(manageBuilding.getBuildingDesc()).append("\"").append(",")
			    .append("\"buildingFloor\":\"").append(manageBuilding.getBuildingFloor()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(manageBuilding.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(manageBuilding.getEstateLatitude()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageBuilding.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageBuilding.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageBuilding.getEditor()).append("\"").append(",")
			    .append("\"buildingMap\":\"").append(manageBuilding.getBuildingMap()).append("\"").append(",")
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
			GSLogger.error("显示manageBuilding列表时发生错误", e);
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
			GSLogger.error("进入manageBuilding新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageBuilding/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageBuilding
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageBuilding entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			manageBuildingService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageBuilding信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id查楼栋信息
	 * @return
	 */
	@RequestMapping(value="selectBuildingId")
	public void selectBuildingId(HttpServletRequest request, HttpServletResponse response) {	
		int id= Integer.parseInt(request.getParameter("id"));
		ManageBuilding entity=new ManageBuilding();
		entity.setBuildingId(id);
		String json="";
		try{
			entity= manageBuildingService.findById(entity);
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
		ManageBuilding entity=new ManageBuilding();
		entity.setBuildingId(id);
		
		try{
			entity= manageBuildingService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageBuilding修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageBuilding/modify");
		mav.addObject("manageBuilding", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageBuilding entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageBuildingService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageBuilding信息时发生错误", e);
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
						ManageBuilding entity=new ManageBuilding();
						entity.setBuildingId(Integer.parseInt(ids[i]));
						manageBuildingService.delete(entity);
					}
				}else{
					ManageBuilding entity=new ManageBuilding();
					entity.setBuildingId(Integer.parseInt(id));
					manageBuildingService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageBuilding时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
