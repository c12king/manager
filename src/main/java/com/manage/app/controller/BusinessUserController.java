package com.manage.app.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessRoleGroup;
import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.BusinessUserResource;
import com.manage.app.bean.BusinessUserRole;
import com.manage.app.bean.ManageEstate;
import com.manage.app.common.ModuleConst;
import com.manage.app.service.BusinessCommunityService;
import com.manage.app.service.BusinessRoleCommunityService;
import com.manage.app.service.BusinessRoleEstateService;
import com.manage.app.service.BusinessRoleGroupService;
import com.manage.app.service.BusinessRoleService;
import com.manage.app.service.BusinessUserCommunityService;
import com.manage.app.service.BusinessUserResourceService;
import com.manage.app.service.BusinessUserRoleService;
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
	@Autowired
	private BusinessRoleGroupService businessRoleGroupService;
	
	@Autowired
	private BusinessRoleService businessRoleService;
	@Autowired
	private BusinessUserRoleService businessUserRoleService;
	@Autowired
	private BusinessUserCommunityService businessUserCommunityService;
	
	@Autowired
	private BusinessRoleCommunityService businessRoleCommunityService;
	
	@Autowired
	private BusinessRoleEstateService businessRoleEstateService;
	
	
	
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
	 * 进入添加资源页
	 * @return
	 */
	@RequestMapping(value="resources")
	public ModelAndView resources(BusinessUser businessUser) {
		List<ManageEstate> estateList = new ArrayList<ManageEstate>();
		List<BusinessCommunity> communityList = new ArrayList<BusinessCommunity>();
		List<BusinessUserResource> estateValueList = new ArrayList<BusinessUserResource>();
		BusinessUserResourceQuery businessUserResourceQuery = new BusinessUserResourceQuery();
		businessUserResourceQuery.setUserId(businessUser.getUserId());
		List comValueList = new ArrayList();
		List resourceList = new ArrayList();
		List selectedCommunityList = new ArrayList();
		List selectedResourceList = new ArrayList();
		List userResoruceList = new ArrayList();
		try{
			/*if(ModuleConst.PROPERTY_CODE.equals(businessUser.getOrgType()) || ModuleConst.STATION_CODE.equals(businessUser.getOrgType())){
				estateList=manageEstateService.findAll();
				reList=businessUserResourceService.findByExample(BusinessUserResourceQuery);
			}else if (ModuleConst.COMMUNITY_CODE.equals(businessUser.getOrgType())) {
				communityList=businessCommunityService.findAll();
				reList=businessUserResourceService.findByExample(BusinessUserResourceQuery);
			}*/
			//estateList=manageEstateService.findAll();
			//communityList=businessCommunityService.findAll();
			//businessUserResourceQuery.setUserId(businessUser.getUserId());
			//estateValueList=businessUserResourceService.findByExample(businessUserResourceQuery);
			//BusinessUserResource businessUserResource = new BusinessUserResource();
			/*for(int i=0;i<estateValueList.size();i++) {
				businessUserResource = estateValueList.get(i);
				Integer comId = businessUserResource.getComId();
				if(comId != null && comId > 0) { //社区ID
					boolean has = false;
					for(int j=0; j<comValueList.size();j++) {
						if(comValueList.get(j) == comId) {
							has = true;
						}
					}
					if(!has) comValueList.add(comId);
				}else{//小区ID
					estateValueList.add(businessUserResource);
				}
			}*/
			//Map paramMap = new HashMap();
			//paramMap.put("userId", businessUser.getUserId());
			//comValueList = businessUserCommunityService.findByMap(paramMap);
			
			//新的
			Map comMap = new HashMap();
			List<BusinessCommunity> comList = businessCommunityService.findAll();
			for (BusinessCommunity businessCommunity : comList) {
				comMap = new HashMap();
				comMap.put("comId",businessCommunity.getComId());
				comMap.put("comName",businessCommunity.getComName());
				List<ManageEstate> manageEstateList=manageEstateService.selectManageEstateByComId(businessCommunity.getComId());
				comMap.put("manageEstateList", manageEstateList);
				resourceList.add(comMap);
			}
			//已选
			Map userResourceMap = new HashMap();
			userResourceMap.put("userId", businessUser.getUserId());
			userResoruceList = businessUserResourceService.findByMap(userResourceMap);
			/*for (int i=0;i<selectedResourceList.size();i++) {
				BusinessRoleCommunity businessRoleCommunity = (BusinessRoleCommunity) selectedCommunityList.get(i);
				selectedCommunityList.add(businessRoleCommunity);
				Map roleEstateMap = new HashMap();
				roleEstateMap.put("rocoId", businessRoleCommunity.getRocoId());
				List businessRoleEstateList = businessRoleEstateService.findByMap(roleEstateMap);
				//selectedFuntionList.retainAll(roleFunctionList);
				for(int j=0;j<businessRoleEstateList.size();j++) {
					BusinessRoleEstate businessRoleEstate = (BusinessRoleEstate) businessRoleEstateList.get(j);
					selectedEstateList.add(businessRoleEstate);
				}
			}*/
			
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/resources");
		mav.addObject("userId", businessUser.getUserId());
		mav.addObject("estateList", estateList);
		mav.addObject("communityList",communityList);
		mav.addObject("estateValueList",estateValueList);
		mav.addObject("comValueList",comValueList);
		mav.addObject("resourceList",resourceList);
		mav.addObject("userResoruceList",userResoruceList);
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
				String roleName = "";
				Map paramMap = new HashMap();
				paramMap.put("userId", businessUser.getUserId());
				List userRoleList = businessUserRoleService.findByMap(paramMap);
				for(int j=0;j<userRoleList.size();j++) {
					BusinessUserRole role = (BusinessUserRole) userRoleList.get(j);
					roleName += role.getRoleName()+"<br />";
				}
				System.out.println(businessUser.getUserId());
				result.append("{")
				.append("\"userId\":\"").append(businessUser.getUserId()).append("\"").append(",")
				.append("\"roleId\":\"").append(roleName).append("\"").append(",")
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
			    .append("\"posName\":\"").append(businessUser.getPosName()==null?"":businessUser.getPosName()).append("\"").append(",")
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
		List roleList = new ArrayList();
		List groupList = new ArrayList();
		Map roleGroupMap = new HashMap();
		try{			
			List roleGroupList = businessRoleGroupService.findAll();
			for(int i=0;i<roleGroupList.size();i++) {
				BusinessRoleGroup roleGroup = (BusinessRoleGroup) roleGroupList.get(i);
				roleGroupMap = new HashMap();
				roleGroupMap.put("groupId", roleGroup.getGroupId());
				roleGroupMap.put("groupName", roleGroup.getGroupName());
				
				Map roleParamMap = new HashMap();
				roleParamMap.put("groupId", roleGroup.getGroupId());
				roleParamMap.put("isSpecial", 0);
				roleList = businessRoleService.findByMap(roleParamMap);
				roleGroupMap.put("roleList", roleList);
				groupList.add(roleGroupMap);
			}
			
		}catch(Exception e){
			GSLogger.error("进入businessUser新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/posAdd");
		mav.addObject("groupList", groupList);
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
			
			//保存角色
			String[] roleIds = request.getParameterValues("roleId");
			if(roleIds != null && roleIds.length > 0) {
				BusinessUserRole userRole = new BusinessUserRole();
				for(int i=0;i<roleIds.length;i++) {
					userRole = new BusinessUserRole();
					userRole.setRoleId(new Integer(roleIds[i]));
					userRole.setUserId(entity.getUserId());
					businessUserRoleService.save(userRole);
				}
			}
			
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
		//entity.setUserId(id);
		List groupList = new ArrayList();
		Map roleGroupMap = new HashMap();
		List roleList = new ArrayList();
		List userRoleList = new ArrayList();
		try{
			entity= businessUserService.findBusinessUserById(id);
			List roleGroupList = businessRoleGroupService.findAll();
			for(int i=0;i<roleGroupList.size();i++) {
				BusinessRoleGroup roleGroup = (BusinessRoleGroup) roleGroupList.get(i);
				roleGroupMap = new HashMap();
				roleGroupMap.put("groupId", roleGroup.getGroupId());
				roleGroupMap.put("groupName", roleGroup.getGroupName());
				
				Map roleParamMap = new HashMap();
				roleParamMap.put("groupId", roleGroup.getGroupId());
				roleParamMap.put("isSpecial", 0);
				roleList = businessRoleService.findByMap(roleParamMap);
				roleGroupMap.put("roleList", roleList);
				groupList.add(roleGroupMap);
			}
			
			//已选角色
			Map paramMap = new HashMap();
			paramMap.put("userId", id);
			userRoleList = businessUserRoleService.findByMap(paramMap);
		}catch(Exception e){
			GSLogger.error("进入businessUser修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessUser/posModify");
		mav.addObject("businessUser", entity);
		mav.addObject("groupList", groupList);
		mav.addObject("userRoleList", userRoleList);		
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
			
			//删除角色
			Map paramMap = new HashMap();
			paramMap.put("userId", entity.getUserId());
			List userRoleList = businessUserRoleService.findByMap(paramMap);
			for(int i=0;i<userRoleList.size();i++) {
				BusinessUserRole userRole = (BusinessUserRole) userRoleList.get(i);
				businessUserRoleService.delete(userRole.getUsroId());
			}
			
			//更新角色
			String[] roleIds = request.getParameterValues("roleId");
			if(roleIds != null && roleIds.length > 0) {
				BusinessUserRole userRole = new BusinessUserRole();
				for(int i=0;i<roleIds.length;i++) {
					userRole = new BusinessUserRole();
					userRole.setRoleId(new Integer(roleIds[i]));
					userRole.setUserId(entity.getUserId());
					businessUserRoleService.save(userRole);
				}
			}
			
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
