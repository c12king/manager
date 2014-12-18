package com.manage.app.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.BusinessUserResource;
import com.manage.app.bean.ManageEstate;
import com.manage.app.bean.ManagePositionUser;
import com.manage.app.common.ModuleConst;
import com.manage.app.service.BusinessCommunityService;
import com.manage.app.service.BusinessUserResourceService;
import com.manage.app.service.BusinessUserService;
import com.manage.app.service.ManageEstateService;
import com.manage.app.vo.BusinessUserResourceQuery;
import com.utis.Page;

/**
 * 用户管理控制器
 * @author zyp-2_000
 *
 */
@Controller
@RequestMapping("/manage/businessUser")
public class BusinessUserController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserController.class);
	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessUserResourceService businessUserResourceService;
	
	private final String LIST_ACTION = "redirect:/business/businessUser/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/enter");
		return mav;
	}
	/**
	 * 进入添加职位页
	 * @return
	 */
	@RequestMapping(value="org")
	public ModelAndView org(HttpServletRequest request) {	
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/org");
		return mav;
	}
	
	/**
	 * 进入添加职位页
	 * @return
	 */
	@RequestMapping(value="position")
	public ModelAndView position(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		BusinessUser entity=new BusinessUser();
		entity.setUserId(id);
		List list=null;
		try{
			entity= businessUserService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/position");
		mav.addObject("businessUser", entity);
		return mav;
	}
	
	/**
	 * 进入添加权限页
	 * @return
	 */
	@RequestMapping(value="editPermissions")
	public ModelAndView editPermissions(BusinessUser businessUser) {
		Map map = null;
		try{
			map = businessUserService.getFunction(businessUser);
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/editPermissions");
		mav.addObject("map", map);
		mav.addObject("userId", businessUser.getUserId());
		return mav;
	}
	
	/**
	 * 进入添加权限页
	 * @return
	 */
	@RequestMapping(value="resources")
	public ModelAndView resources(BusinessUser businessUser) {
		List<ManageEstate> estateList = new ArrayList<ManageEstate>();
		List<BusinessCommunity> communityList = new ArrayList<BusinessCommunity>();
		List<BusinessUserResource> reList = new ArrayList<BusinessUserResource>();
		BusinessUserResourceQuery BusinessUserResourceQuery = new BusinessUserResourceQuery();
		BusinessUserResourceQuery.setUserId(businessUser.getUserId());
		try{
			if(ModuleConst.PROPERTY_CODE.equals(businessUser.getOrgType()) || ModuleConst.STATION_CODE.equals(businessUser.getOrgType())){
				estateList=manageEstateService.findAll();
				reList=businessUserResourceService.findByExample(BusinessUserResourceQuery);
			}else if (ModuleConst.COMMUNITY_CODE.equals(businessUser.getOrgType())) {
				communityList=businessCommunityService.findAll();
				reList=businessUserResourceService.findByExample(BusinessUserResourceQuery);
			}
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/resources");
		mav.addObject("userId", businessUser.getUserId());
		mav.addObject("estateList", estateList);
		mav.addObject("communityList",communityList);
		mav.addObject("reList",reList);
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
			Page pageData = businessUserService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				BusinessUser businessUser = (BusinessUser) pageData.getList().get(i);
				result.append("{")
				.append("\"userId\":\"").append(businessUser.getUserId()).append("\"").append(",")
			    .append("\"userName\":\"").append(businessUser.getUserName()).append("\"").append(",")
			    .append("\"userTel\":\"").append(businessUser.getUserTel()).append("\"").append(",")
			    .append("\"userPassword\":\"").append(businessUser.getUserPassword()).append("\"").append(",")
			    .append("\"userCode\":\"").append(businessUser.getUserCode()).append("\"").append(",")
			    .append("\"lastLoginTime\":\"").append(businessUser.getLastLoginTime()).append("\"").append(",")
			    .append("\"userEmail\":\"").append(businessUser.getUserEmail()).append("\"").append(",")
			    .append("\"userPhoto\":\"").append(businessUser.getUserPhoto()).append("\"").append(",")
			    .append("\"userBrief\":\"").append(businessUser.getUserBrief()).append("\"").append(",")
			    .append("\"userService\":\"").append(businessUser.getUserService()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessUser.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessUser.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessUser.getEditor()).append("\"").append(",")
			    .append("\"positionId\":\"").append(businessUser.getPositionId()).append("\"").append(",")
			    .append("\"posName\":\"").append(businessUser.getPosName()).append("\"").append(",")
			    .append("\"modules\":\"").append(businessUser.getModules()).append("\"").append(",")
			    .append("\"orgType\":\"").append(businessUser.getOrgType()).append("\"").append(",")
			    .append("\"isCharge\":\"").append(businessUser.getIsCharge()).append("\"")
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
			GSLogger.error("显示businessUser列表时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="posList")
	public void posList(HttpServletRequest request, HttpServletResponse response) {
		int cpage=Integer.parseInt(request.getParameter("page"));
		int size=Integer.parseInt(request.getParameter("rows"));
		String like=request.getParameter("name");
		String positionId=request.getParameter("id");
		Page page = new Page(cpage,size,like,positionId);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = businessUserService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				BusinessUser businessUser = (BusinessUser) pageData.getList().get(i);
				result.append("{")
				.append("\"userId\":\"").append(businessUser.getUserId()).append("\"").append(",")
			    .append("\"userName\":\"").append(businessUser.getUserName()).append("\"").append(",")
			    .append("\"userTel\":\"").append(businessUser.getUserTel()).append("\"").append(",")
			    .append("\"userPassword\":\"").append(businessUser.getUserPassword()).append("\"").append(",")
			    .append("\"userCode\":\"").append(businessUser.getUserCode()).append("\"").append(",")
			    .append("\"lastLoginTime\":\"").append(businessUser.getLastLoginTime()).append("\"").append(",")
			    .append("\"userEmail\":\"").append(businessUser.getUserEmail()).append("\"").append(",")
			    .append("\"userPhoto\":\"").append(businessUser.getUserPhoto()).append("\"").append(",")
			    .append("\"userBrief\":\"").append(businessUser.getUserBrief()).append("\"").append(",")
			    .append("\"userService\":\"").append(businessUser.getUserService()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessUser.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessUser.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessUser.getEditor()).append("\"").append(",")
			    .append("\"positionId\":\"").append(businessUser.getPositionId()).append("\"").append(",")
			    .append("\"posName\":\"").append(businessUser.getPosName()).append("\"").append(",")
			    .append("\"modules\":\"").append(businessUser.getModules()).append("\"").append(",")
			    .append("\"isCharge\":\"").append(businessUser.getIsCharge()).append("\"")
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
			GSLogger.error("显示businessUser列表时发生错误", e);
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
			GSLogger.error("进入businessUser新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/add");
		return mav;
	}
	/**
	 * 进入带职位的新增页
	 * @return
	 */
	@RequestMapping(value="posAdd")
	public ModelAndView posAdd() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUser新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/posAdd");
		return mav;
	}
	
	/**
	 * 给用户添加职位
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="saveJOB")
	public void saveJOB(HttpServletRequest request, HttpServletResponse response,BusinessUser entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			businessUserService.saveJOB(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存businessUser信息时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 给用户设置为默认负责人
	 * @param request
	 * @param ManagePositionUser
	 * @return
	 */
	@RequestMapping(value="isCharge")
	public void isCharge(HttpServletRequest request, HttpServletResponse response,BusinessUser entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			businessUserService.isCharge(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存businessUser信息时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 添加用户并增加职位
	 * @param request
	 * @return
	 */
	@RequestMapping(value="savePosUser")
	public void savePosUser(HttpServletRequest request, HttpServletResponse response, BusinessUser entity) {
		String json = "";
		try{
			if(entity.getOrgType().equals(ModuleConst.OPERATION_CODE.toString())){
				entity.setModules(ModuleConst.COMMUNITY_CODE+","+ModuleConst.PROPERTY_CODE+","+ModuleConst.STATION_CODE+","+ModuleConst.OPERATION_CODE);
			}else{
				entity.setModules(entity.getOrgType());
			}
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			businessUserService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存businessUser信息时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 保存对象
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessUser entity) {
		String json = "";
		try{
			if(entity.getOrgType().equals(ModuleConst.OPERATION_CODE.toString())){
				entity.setModules(ModuleConst.COMMUNITY_CODE+","+ModuleConst.PROPERTY_CODE+","+ModuleConst.STATION_CODE+","+ModuleConst.OPERATION_CODE);
			}else{
				entity.setModules(entity.getOrgType());
			}
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			businessUserService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存businessUser信息时发生错误", e);
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
		BusinessUser entity=new BusinessUser();
		entity.setUserId(id);
		
		try{
			entity= businessUserService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入businessUser修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/modify");
		mav.addObject("businessUser", entity);
		return mav;
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="posModify")
	public ModelAndView posModify(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		BusinessUser entity=new BusinessUser();
		entity.setUserId(id);
		
		try{
			entity= businessUserService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入businessUser修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/posModify");
		mav.addObject("businessUser", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessUser entity) {
		String json = "";
		try{
			if(entity.getOrgType().equals(ModuleConst.OPERATION.toString())){
				entity.setModules(ModuleConst.COMMUNITY+","+ModuleConst.PROPERTY+","+ModuleConst.STATION+","+ModuleConst.OPERATION);
			}else{
				entity.setModules(entity.getOrgType());
			}
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			businessUserService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑businessUser信息时发生错误", e);
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
						BusinessUser entity=new BusinessUser();
						entity.setUserId(Integer.parseInt(ids[i]));
						businessUserService.delete(entity);
					}
				}else{
					BusinessUser entity=new BusinessUser();
					entity.setUserId(Integer.parseInt(id));
					businessUserService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除BusinessUser时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
