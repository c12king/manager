package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageEstate;
import com.manage.app.service.ManageEstateService;
import com.utis.Page;





@Controller
@RequestMapping("/manage/manageEstate")
public class ManageEstateController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageEstateController.class);
	@Autowired
	private ManageEstateService manageEstateService;
	
	private final String LIST_ACTION = "redirect:/manage/manageEstate/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageEstate管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/enter");
		return mav;
	}
	/**
	 * 进入小区电话管理页
	 * @return
	 */
	@RequestMapping(value="enterEstTel")
	public ModelAndView enterEstTel() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageEstate管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/enterEstTel");
		return mav;
	}
	
	/**
	 * 进入小区电话编辑维护页面
	 * 2014年12月18日12:29:45
	 * @return
	 */
	@RequestMapping(value="manageEstTel")
	public ModelAndView manageEstTel() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageEstTel管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/manageEstTel");
		return mav;
	}
	/**
	 * 获取菜单树形展示 小区 json 数据
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="treeData",produces="text/plain;charset=utf-8")
	public void treeData(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
//		ManageBuilding manageBuilding=new ManageBuilding();
//		String id=request.getParameter("id");
//		manageBuilding.setEstateId(new Integer(id));
		String json= manageEstateService.treeData() ;    //manageBuildingService.treeData(manageBuilding);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
	
	
	
	
	/**
	 * 进入编辑楼栋页
	 * @return
	 */
	@RequestMapping(value="org")
	public ModelAndView org(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageOrg管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/org");
		mav.addObject("estateId", request.getParameter("id"));
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
			Page pageData = manageEstateService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageEstate manageEstate = (ManageEstate) pageData.getList().get(i);
				result.append("{")
			    .append("\"estateId\":\"").append(manageEstate.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(manageEstate.getEstateName()).append("\"").append(",")
			    .append("\"estateDesc\":\"").append(manageEstate.getEstateDesc()).append("\"").append(",")
			    .append("\"estateAddress\":\"").append(manageEstate.getEstateAddress()).append("\"").append(",")
			    .append("\"estateMap\":\"").append(manageEstate.getEstateMap()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(manageEstate.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(manageEstate.getEstateLatitude()).append("\"").append(",")
			    .append("\"estateCarMap\":\"").append(manageEstate.getEstateCarMap()).append("\"").append(",")
			    .append("\"estateType\":\"").append(manageEstate.getEstateType()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageEstate.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageEstate.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageEstate.getEditor()).append("\"")
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
			GSLogger.error("显示manageEstate列表时发生错误", e);
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
			GSLogger.error("进入manageEstate新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageEstate
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageEstate entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			if(entity.getStationId() == null) {
				entity.setStationId(0);
			}
			if(entity.getProId() == null) {
				entity.setProId(0);
			}
			manageEstateService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageEstate信息时发生错误", e);
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
		ManageEstate entity=new ManageEstate();
		entity.setEstateId(id);
		
		try{
			entity= manageEstateService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageEstate修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/modify");
		mav.addObject("manageEstate", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageEstate entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			if(entity.getStationId() == null) {
				entity.setStationId(0);
			}
			if(entity.getProId() == null) {
				entity.setProId(0);
			}
			manageEstateService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageEstate信息时发生错误", e);
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
						ManageEstate entity=new ManageEstate();
						entity.setEstateId(Integer.parseInt(ids[i]));
						manageEstateService.delete(entity);
					}
				}else{
					ManageEstate entity=new ManageEstate();
					entity.setEstateId(Integer.parseInt(id));
					manageEstateService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageEstate时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
