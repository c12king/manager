package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessMenu;
import com.manage.app.bean.BusinessRole;
import com.manage.app.bean.BusinessRoleCommunity;
import com.manage.app.bean.BusinessRoleEstate;
import com.manage.app.bean.BusinessRoleFunction;
import com.manage.app.bean.BusinessRoleGroup;
import com.manage.app.bean.BusinessRoleMenu;
import com.manage.app.bean.BusinessRoleRefu;
import com.manage.app.bean.BusinessSpecialFunction;
import com.manage.app.bean.BusinessSpecialMenu;
import com.manage.app.bean.ManageEstate;
import com.manage.app.bean.ManageFunction;
import com.manage.app.service.BusinessCommunityService;
import com.manage.app.service.BusinessMenuService;
import com.manage.app.service.BusinessRoleCommunityService;
import com.manage.app.service.BusinessRoleEstateService;
import com.manage.app.service.BusinessRoleFunctionService;
import com.manage.app.service.BusinessRoleGroupService;
import com.manage.app.service.BusinessRoleMenuService;
import com.manage.app.service.BusinessRoleRefuService;
import com.manage.app.service.BusinessRoleService;
import com.manage.app.service.BusinessSpecialFunctionService;
import com.manage.app.service.BusinessSpecialMenuService;
import com.manage.app.service.ManageEstateService;
import com.manage.app.service.ManageFunctionService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleQuery;


@Controller
@RequestMapping("/manage/businessRole")
public class BusinessRoleController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleController.class);
	@Autowired
	private BusinessRoleService businessRoleService;
	
	@Autowired
	private BusinessRoleGroupService businessRoleGroupService;
	
	@Autowired
	private BusinessMenuService businessMenuService;
	
	@Autowired
	private ManageFunctionService manageFunctionService;
	
	@Autowired
	private BusinessRoleMenuService businessRoleMenuService;
	
	@Autowired
	private BusinessRoleFunctionService businessRoleFunctionService;
	
	@Autowired
	private BusinessCommunityService businessCommunityService;
	
	@Autowired
	private ManageEstateService manageEstateService;
	
	@Autowired
	private BusinessRoleRefuService businessRoleRefuService;
	
	@Autowired
	private BusinessRoleCommunityService businessRoleCommunityService;
	
	@Autowired
	private BusinessRoleEstateService businessRoleEstateService;	
	
	@Autowired
	private BusinessSpecialMenuService businessSpecialMenuService;	
	
	@Autowired
	private BusinessSpecialFunctionService businessSpecialFunctionService;	
	
	private final String LIST_ACTION = "redirect:/manage/businessRole/list.do";
	
	/**
	 * 进入标准角色管理页
	 * @return
	 */
	@RequestMapping(value="standardEnter")
	public ModelAndView standardEnter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRole管理页时发生错误：/manage/businessRole/standardEnter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/standardEnter");
		return mav;
	}
	
	/**
	 * 列示或者查询标准角色所有数据
	 * @return
	 */
	@RequestMapping(value="standardList")
	public void standardList(BusinessRoleQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setIsSpecial(0);
			BaseBean baseBean = businessRoleService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRole businessRole = (BusinessRole) baseBean.getList().get(i);
				BusinessRoleGroup group  = businessRoleGroupService.findById(businessRole.getGroupId());
				result.append("{")
			    .append("\"roleId\":\"").append(businessRole.getRoleId()).append("\"").append(",")
			    .append("\"groupId\":\"").append(group.getGroupName()).append("\"").append(",")
			    .append("\"roleName\":\"").append(businessRole.getRoleName()).append("\"").append(",")
			    .append("\"roleDesc\":\"").append(businessRole.getRoleDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRole.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRole.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRole.getEditor()).append("\"").append(",")
			    .append("\"isSpecial\":\"").append(businessRole.getIsSpecial()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessRole列表时发生错误：/manage/businessRole/standardList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入标准角色新增页
	 * @return
	 * 
	 */
	@RequestMapping(value="standardAdd")
	public ModelAndView standardAdd(BusinessRoleQuery query) {	
		List groupList = new ArrayList();
		Map menuMap = null;
		List menuList = new ArrayList();
		try{
			groupList = businessRoleGroupService.findAll();
			List<BusinessMenu> moduleMenuList=businessMenuService.findAllMenu();
			for (BusinessMenu businessMenu : moduleMenuList) {
				menuMap = new HashMap();
				menuMap.put("menuId",businessMenu.getMenuId());
				menuMap.put("menuMame",businessMenu.getName());
				List<ManageFunction> manageFunctionList=manageFunctionService.findFunctionByMenu(businessMenu.getMenuId());
				menuMap.put("functionList", manageFunctionList);
				menuList.add(menuMap);
			}
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/manage/businessRole/standardAdd", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/standardAdd");
		mav.addObject("groupList", groupList);
		mav.addObject("menuList", menuList);
		return mav;
	}
	
	/**
	 * 保存标准角色对象
	 * @param request
	 * @param businessRole
	 * @return
	 */
	@RequestMapping(value="standardSave")
	public void standardSave(HttpServletRequest request, HttpServletResponse response, BusinessRoleQuery query) {
		BusinessRole businessRole = new BusinessRole();
		String json = "";
		try{
		    businessRole.setRoleName(query.getRoleName());
		    businessRole.setRoleDesc(query.getRoleDesc());
		    businessRole.setGroupId(query.getGroupId());
		    businessRole.setCreateTime(query.getCreateTime());
		    businessRole.setEditTime(query.getEditTime());
		    businessRole.setEditor(query.getEditor());
		    businessRole.setIsSpecial(0);
			businessRoleService.save(businessRole);
			
			//保存权限
			String[] menuIds = request.getParameterValues("menuId");
			for(int i=0;i<menuIds.length;i++) {
				String menuId = menuIds[i];
				//保存角色菜单
				BusinessRoleMenu menu = new BusinessRoleMenu();
				menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
				menu.setRoleId(businessRole.getRoleId());
				menu.setMenuId(new Integer(menuId));
				menu.setEditTime(new Timestamp(System.currentTimeMillis()));
				BusinessMenu businessMenu = new BusinessMenu();
				businessMenu.setMenuId(new Integer(menuId));
				List menuList = businessMenuService.selectMenuId(businessMenu);
				businessMenu = (BusinessMenu) menuList.get(0);
				menu.setNo(businessMenu.getOrd());
				businessRoleMenuService.save(menu);
				//保存功能权限
				String[] fundtionIds = request.getParameterValues("functionId_"+menuId);
				for(int j=0;j<fundtionIds.length;j++) {
					BusinessRoleFunction function = new BusinessRoleFunction();
					String functionId = fundtionIds[j];
					function.setRomeId(menu.getRomeId());
					function.setFunctionId(new Integer(functionId));
					businessRoleFunctionService.save(function);
				}
			}			
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRole信息时发生错误：/manage/businessRole/save", e);
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
	 * 进入标准角色修改页
	 * @return
	 */
	@RequestMapping(value="standardModify")
	public ModelAndView standardModify(BusinessRoleQuery query) {	
		BusinessRole businessRole=new BusinessRole();
		List groupList = new ArrayList();
		Map menuMap = null;
		List menuList = new ArrayList();
		List selectedFuntionList = new ArrayList();
		List selectedMenuList = new ArrayList();
		try{
			groupList = businessRoleGroupService.findAll();
			businessRole = businessRoleService.findById(query.getRoleId());
			//初始化
			List<BusinessMenu> moduleMenuList=businessMenuService.findAllMenu();
			for (BusinessMenu businessMenu : moduleMenuList) {
				menuMap = new HashMap();
				menuMap.put("menuId",businessMenu.getMenuId());
				menuMap.put("menuMame",businessMenu.getName());
				List<ManageFunction> manageFunctionList=manageFunctionService.findFunctionByMenu(businessMenu.getMenuId());
				menuMap.put("functionList", manageFunctionList);
				menuList.add(menuMap);
			}
			//已选
			Map roleMenuMap = new HashMap();
			roleMenuMap.put("roleId", businessRole.getRoleId());
			selectedMenuList = businessRoleMenuService.findByMap(roleMenuMap);
			for (int i=0;i<selectedMenuList.size();i++) {
				BusinessRoleMenu businessRoleMenu = (BusinessRoleMenu) selectedMenuList.get(i);
				Map roleFunctionMap = new HashMap();
				roleFunctionMap.put("romeId", businessRoleMenu.getRomeId());
				List roleFunctionList = businessRoleFunctionService.findByMap(roleFunctionMap);
				//selectedFuntionList.retainAll(roleFunctionList);
				for(int j=0;j<roleFunctionList.size();j++) {
					BusinessRoleFunction rolefunction = (BusinessRoleFunction) roleFunctionList.get(j);
					selectedFuntionList.add(rolefunction);
				}
			}
			
			
		}catch(Exception e){
			GSLogger.error("进入businessRole修改页时发生错误：/manage/businessRole/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/standardModify");
		mav.addObject("businessRole", businessRole);
		mav.addObject("groupList", groupList);
		mav.addObject("menuList", menuList);
		mav.addObject("selectedMenuList", selectedMenuList);
		mav.addObject("selectedFuntionList", selectedFuntionList);
		return mav;
	}
	
	/**
	 * 更新标准角色对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="standardUpdate")
	public void standardUpdate(HttpServletRequest request, HttpServletResponse response, BusinessRoleQuery query) {
		BusinessRole businessRole = null;
		String json = "";
		try{
		    businessRole = businessRoleService.findById(query.getRoleId());
		    businessRole.setRoleName(query.getRoleName());
		    businessRole.setRoleDesc(query.getRoleDesc());
		    businessRole.setGroupId(query.getGroupId());
		    businessRole.setCreateTime(query.getCreateTime());
		    businessRole.setEditTime(query.getEditTime());
		    businessRole.setEditor(query.getEditor());
		    //businessRole.setIsSpecial(query.getIsSpecial());
			businessRoleService.update(businessRole);
			
			//删除之前的权限
			businessRoleService.deleteMenuFunction(businessRole.getRoleId());
			
			//保存权限
			String[] menuIds = request.getParameterValues("menuId");
			for(int i=0;i<menuIds.length;i++) {
				String menuId = menuIds[i];
				//保存角色菜单
				BusinessRoleMenu menu = new BusinessRoleMenu();
				menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
				menu.setRoleId(businessRole.getRoleId());
				menu.setMenuId(new Integer(menuId));
				menu.setEditTime(new Timestamp(System.currentTimeMillis()));
				BusinessMenu businessMenu = new BusinessMenu();
				businessMenu.setMenuId(new Integer(menuId));
				List menuList = businessMenuService.selectMenuId(businessMenu);
				businessMenu = (BusinessMenu) menuList.get(0);
				menu.setNo(businessMenu.getOrd());
				businessRoleMenuService.save(menu);
				//保存功能权限
				String[] fundtionIds = request.getParameterValues("functionId_"+menuId);
				if(fundtionIds != null) {
					for(int j=0;j<fundtionIds.length;j++) {
						BusinessRoleFunction function = new BusinessRoleFunction();
						String functionId = fundtionIds[j];
						function.setRomeId(menu.getRomeId());
						function.setFunctionId(new Integer(functionId));
						businessRoleFunctionService.save(function);
					}
				}				
			}			
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRole信息时发生错误：/manage/businessRole/update", e);
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
	 * 删除标准角色单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="standardDelete")
	public void standardDelete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessRoleService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRole时发生错误：/manage/businessRole/delete", e);
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
	 * 进入特殊角色管理页
	 * @return
	 */
	@RequestMapping(value="specialEnter")
	public ModelAndView specialEnter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRole管理页时发生错误：/manage/businessRole/specialEnter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/specialEnter");
		return mav;
	}
	
	/**
	 * 列示或者查询特殊角色所有数据
	 * @return
	 */
	@RequestMapping(value="specialList")
	public void specialList(BusinessRoleQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setIsSpecial(1);
			BaseBean baseBean = businessRoleService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRole businessRole = (BusinessRole) baseBean.getList().get(i);
				BusinessRoleGroup group  = businessRoleGroupService.findById(businessRole.getGroupId());
				result.append("{")
			    .append("\"roleId\":\"").append(businessRole.getRoleId()).append("\"").append(",")
			    .append("\"groupId\":\"").append(group.getGroupName()).append("\"").append(",")
			    .append("\"roleName\":\"").append(businessRole.getRoleName()).append("\"").append(",")
			    .append("\"roleDesc\":\"").append(businessRole.getRoleDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRole.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRole.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRole.getEditor()).append("\"").append(",")
			    .append("\"isSpecial\":\"").append(businessRole.getIsSpecial()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessRole列表时发生错误：/manage/businessRole/specialList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入特殊角色新增页
	 * @return
	 * 
	 */
	@RequestMapping(value="specialAdd")
	public ModelAndView specialAdd(BusinessRoleQuery query) {	
		List groupList = new ArrayList();
		Map menuMap = null;
		List menuList = new ArrayList();
		BusinessRole businessRole = new BusinessRole();
		try{
			groupList = businessRoleGroupService.findAll();
			if(query.getRoleId() != null && query.getRoleId() != 0) {
				businessRole = businessRoleService.findById(query.getRoleId());
			}			
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/manage/businessRole/specialAdd", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/specialAdd");
		mav.addObject("groupList", groupList);
		mav.addObject("businessRole", businessRole);
		return mav;
	}
	
	/**
	 * 保存特殊角色对象
	 * @param request
	 * @param businessRole
	 * @return
	 */
	@RequestMapping(value="specialSave")
	public void specialSave(HttpServletRequest request, HttpServletResponse response, BusinessRoleQuery query) {
		BusinessRole businessRole = new BusinessRole();
		request.getParameter("resourceRightAdd");
		String json = "";
		try{
			//编辑
			if(query.getRoleId() != null && query.getRoleId() != 0) {
				businessRole = businessRoleService.findById(query.getRoleId());
			    businessRole.setRoleName(query.getRoleName());
			    businessRole.setRoleDesc(query.getRoleDesc());
			    businessRole.setGroupId(query.getGroupId());
			    businessRole.setEditTime(query.getEditTime());
			    businessRole.setEditor(query.getEditor());
				businessRoleService.update(businessRole);
				
				//删除所有的相关的信息
				Map map = new HashMap();
				map.put("roleId", businessRole.getRoleId());
				List refuList = businessRoleRefuService.findByMap(map);
				for(int i=0;i<refuList.size();i++) {
					BusinessRoleRefu businessRoleRefu = (BusinessRoleRefu) refuList.get(i);
					//资源
					map = new HashMap();
					map.put("refuId", businessRoleRefu.getRefuId());
					List businessRoleCommunityList = businessRoleCommunityService.findByMap(map);
					//社区
					for(int j=0;j<businessRoleCommunityList.size();j++) {
						BusinessRoleCommunity businessRoleCommunity = (BusinessRoleCommunity) businessRoleCommunityList.get(j);
						map = new HashMap();
						map.put("rocoId", businessRoleCommunity.getRocoId());
						List businessRoleEstateList = businessRoleEstateService.findByMap(map);
						//小区
						for(int k=0;k<businessRoleEstateList.size();k++) {
							BusinessRoleEstate businessRoleEstate = (BusinessRoleEstate) businessRoleEstateList.get(k);
							businessRoleEstateService.delete(businessRoleEstate.getEstateId());
						}
						businessRoleCommunityService.delete(businessRoleCommunity.getComId());
					}
						
					//权限
					map = new HashMap();
					map.put("refuId", businessRoleRefu.getRefuId());
					List businessSpecialMenuList = businessSpecialMenuService.findByMap(map);
					for(int j=0;j<businessSpecialMenuList.size();j++) {
						BusinessSpecialMenu businessSpecialMenu = (BusinessSpecialMenu) businessSpecialMenuList.get(j);
						map = new HashMap();
						map.put("spmeId", businessSpecialMenu.getSpmeId());
						List businessSpecialFunctionList = businessSpecialFunctionService.findByMap(map);
						for(int k=0;k<businessSpecialFunctionList.size();k++) {
							BusinessSpecialFunction businessSpecialFunction = (BusinessSpecialFunction) businessSpecialFunctionList.get(k);
							businessSpecialFunctionService.delete(businessSpecialFunction.getFunctionId());
						}
						businessSpecialMenuService.delete(businessSpecialMenu.getMenuId());
					}
					
					businessRoleRefuService.delete(businessRoleRefu.getRefuId());
				}
			}else{//新增
				businessRole.setRoleName(query.getRoleName());
			    businessRole.setRoleDesc(query.getRoleDesc());
			    businessRole.setGroupId(query.getGroupId());
			    businessRole.setCreateTime(query.getCreateTime());
			    businessRole.setEditTime(query.getEditTime());
			    businessRole.setEditor(query.getEditor());
			    businessRole.setIsSpecial(1);
				businessRoleService.save(businessRole);
			}
		    
			//保存角色下的资源权限记录下的索引记录
			JSONArray resourceRightArr = new JSONArray();
			resourceRightArr = JSONArray.fromObject(query.getResourceRightAdd());
			BusinessRoleRefu businessRoleRefu = null;
			for(int i=0;i<resourceRightArr.size();i++) {
				JSONObject resourceRightObj = (JSONObject) resourceRightArr.get(i);
				businessRoleRefu = new BusinessRoleRefu();
				businessRoleRefu.setRoleId(businessRole.getRoleId());
				businessRoleRefuService.save(businessRoleRefu);
				//保存该索引下的资源和权限
				//保存资源
				JSONArray resrouceArr = resourceRightObj.getJSONArray("resource");
				for(int j=0;j<resrouceArr.size();j++) {
					JSONObject resourceObj = (JSONObject) resrouceArr.get(j);
					//保存社区
					BusinessRoleCommunity businessRoleCommunity = new BusinessRoleCommunity();
					Integer comId = resourceObj.getInt("id");
					businessRoleCommunity.setComId(comId);
					businessRoleCommunity.setRefuId(businessRoleRefu.getRefuId());
					businessRoleCommunityService.save(businessRoleCommunity);
					//保存小区
					JSONArray estateArr = resourceObj.getJSONArray("children");
					for(int k=0;k<estateArr.size();k++) {
						JSONObject estateObj = (JSONObject) estateArr.get(k);
						//保存小区
						BusinessRoleEstate businessRoleEstate = new BusinessRoleEstate();
						Integer estateId = estateObj.getInt("id");
						businessRoleEstate.setEstateId(estateId);
						businessRoleEstate.setRocoId(businessRoleCommunity.getRocoId());
						businessRoleEstateService.save(businessRoleEstate);
					}
				}
				//保存权限
				JSONArray rightArr = resourceRightObj.getJSONArray("right");
				for(int j=0;j<rightArr.size();j++) {
					JSONObject rightObj = (JSONObject) rightArr.get(j);
					//保存菜单
					BusinessSpecialMenu businessSpecialMenu = new BusinessSpecialMenu();
					Integer menuId = rightObj.getInt("menuId");
					businessSpecialMenu.setMenuId(menuId);
					businessSpecialMenu.setRefuId(businessRoleRefu.getRefuId());
					BusinessMenu menu = businessMenuService.findMenuById(menuId);
					businessSpecialMenu.setNo(menu.getOrd());
					businessSpecialMenuService.save(businessSpecialMenu);
					//保存功能
					JSONArray functionArr = rightObj.getJSONArray("children");
					for(int k=0;k<functionArr.size();k++) {
						JSONObject functionObj = (JSONObject) functionArr.get(k);
						BusinessSpecialFunction businessSpecialFunction = new BusinessSpecialFunction();
						Integer functionId = functionObj.getInt("functionId");
						businessSpecialFunction.setFunctionId(functionId);
						businessSpecialFunction.setSpmeId(businessSpecialMenu.getSpmeId());
						businessSpecialFunctionService.save(businessSpecialFunction);
					}
				}
			}
			 
			/*//保存权限
			String[] menuIds = request.getParameterValues("menuId");
			for(int i=0;i<menuIds.length;i++) {
				String menuId = menuIds[i];
				//保存角色菜单
				BusinessRoleMenu menu = new BusinessRoleMenu();
				menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
				menu.setRoleId(businessRole.getRoleId());
				menu.setMenuId(new Integer(menuId));
				menu.setEditTime(new Timestamp(System.currentTimeMillis()));
				BusinessMenu businessMenu = new BusinessMenu();
				businessMenu.setMenuId(new Integer(menuId));
				List menuList = businessMenuService.selectMenuId(businessMenu);
				businessMenu = (BusinessMenu) menuList.get(0);
				menu.setNo(businessMenu.getOrd());
				businessRoleMenuService.save(menu);
				//保存功能权限
				String[] fundtionIds = request.getParameterValues("functionId_"+menuId);
				for(int j=0;j<fundtionIds.length;j++) {
					BusinessRoleFunction function = new BusinessRoleFunction();
					String functionId = fundtionIds[j];
					function.setRomeId(menu.getRomeId());
					function.setFunctionId(new Integer(functionId));
					businessRoleFunctionService.save(function);
				}
			}		*/	
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRole信息时发生错误：/manage/businessRole/save", e);
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
	 * 进入特殊角色修改页
	 * @return
	 */
	@RequestMapping(value="specialModify")
	public ModelAndView specialModify(BusinessRoleQuery query) {	
		BusinessRole businessRole=new BusinessRole();
		List groupList = new ArrayList();
		try{
			businessRole = businessRoleService.findById(query.getRoleId());
			groupList = businessRoleGroupService.findAll();
		}catch(Exception e){
			GSLogger.error("进入businessRole修改页时发生错误：/manage/businessRole/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/specialModify");
		mav.addObject("businessRole", businessRole);
		mav.addObject("groupList", groupList);
		return mav;
	}
	
	/**
	 * 更新特殊角色对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="specialUpdate")
	public void specialUpdate(HttpServletRequest request, HttpServletResponse response, BusinessRoleQuery query) {
		BusinessRole businessRole = null;
		String json = "";
		try{
		    businessRole = businessRoleService.findById(query.getRoleId());
		    businessRole.setRoleName(query.getRoleName());
		    businessRole.setRoleDesc(query.getRoleDesc());
		    businessRole.setGroupId(query.getGroupId());
		    businessRole.setEditTime(query.getEditTime());
		    businessRole.setEditor(query.getEditor());
			businessRoleService.update(businessRole);
			
			//删除所有的相关的信息
			Map map = new HashMap();
			map.put("roleId", businessRole.getRoleId());
			List refuList = businessRoleRefuService.findByMap(map);
			for(int i=0;i<refuList.size();i++) {
				BusinessRoleRefu businessRoleRefu = (BusinessRoleRefu) refuList.get(i);
				//资源
				map = new HashMap();
				map.put("refuId", businessRoleRefu.getRefuId());
				List businessRoleCommunityList = businessRoleCommunityService.findByMap(map);
				//社区
				for(int j=0;j<businessRoleCommunityList.size();j++) {
					BusinessRoleCommunity businessRoleCommunity = (BusinessRoleCommunity) businessRoleCommunityList.get(j);
					map = new HashMap();
					map.put("rocoId", businessRoleCommunity.getRocoId());
					List businessRoleEstateList = businessRoleEstateService.findByMap(map);
					//小区
					for(int k=0;k<businessRoleEstateList.size();k++) {
						BusinessRoleEstate businessRoleEstate = (BusinessRoleEstate) businessRoleEstateList.get(k);
						businessRoleEstateService.delete(businessRoleEstate.getEstateId());
					}
					businessRoleCommunityService.delete(businessRoleCommunity.getComId());
				}
					
				//权限
				map = new HashMap();
				map.put("refuId", businessRoleRefu.getRefuId());
				List businessSpecialMenuList = businessSpecialMenuService.findByMap(map);
				for(int j=0;j<businessSpecialMenuList.size();j++) {
					BusinessSpecialMenu businessSpecialMenu = (BusinessSpecialMenu) businessSpecialMenuList.get(j);
					map = new HashMap();
					map.put("spmeId", businessSpecialMenu.getSpmeId());
					List businessSpecialFunctionList = businessSpecialFunctionService.findByMap(map);
					for(int k=0;k<businessSpecialFunctionList.size();k++) {
						BusinessSpecialFunction businessSpecialFunction = (BusinessSpecialFunction) businessSpecialFunctionList.get(k);
						businessSpecialFunctionService.delete(businessSpecialFunction.getFunctionId());
					}
					businessSpecialMenuService.delete(businessSpecialMenu.getMenuId());
				}
				
				businessRoleRefuService.delete(businessRoleRefu.getRefuId());
			}
			
			//保存角色下的资源权限记录下的索引记录
			JSONArray resourceRightArr = new JSONArray();
			resourceRightArr = JSONArray.fromObject(query.getResourceRightAdd());
			BusinessRoleRefu businessRoleRefu = null;
			for(int i=0;i<resourceRightArr.size();i++) {
				JSONObject resourceRightObj = (JSONObject) resourceRightArr.get(i);
				businessRoleRefu = new BusinessRoleRefu();
				businessRoleRefu.setRoleId(businessRole.getRoleId());
				businessRoleRefuService.save(businessRoleRefu);
				//保存该索引下的资源和权限
				//保存资源
				JSONArray resrouceArr = resourceRightObj.getJSONArray("resource");
				for(int j=0;j<resrouceArr.size();j++) {
					JSONObject resourceObj = (JSONObject) resrouceArr.get(j);
					//保存社区
					BusinessRoleCommunity businessRoleCommunity = new BusinessRoleCommunity();
					Integer comId = resourceObj.getInt("id");
					businessRoleCommunity.setComId(comId);
					businessRoleCommunity.setRefuId(businessRoleRefu.getRefuId());
					businessRoleCommunityService.save(businessRoleCommunity);
					//保存小区
					JSONArray estateArr = resourceObj.getJSONArray("children");
					for(int k=0;k<estateArr.size();k++) {
						JSONObject estateObj = (JSONObject) estateArr.get(k);
						//保存小区
						BusinessRoleEstate businessRoleEstate = new BusinessRoleEstate();
						Integer estateId = estateObj.getInt("id");
						businessRoleEstate.setEstateId(estateId);
						businessRoleEstate.setRocoId(businessRoleCommunity.getRocoId());
						businessRoleEstateService.save(businessRoleEstate);
					}
				}
				//保存权限
				JSONArray rightArr = resourceRightObj.getJSONArray("right");
				for(int j=0;j<rightArr.size();j++) {
					JSONObject rightObj = (JSONObject) rightArr.get(j);
					//保存菜单
					BusinessSpecialMenu businessSpecialMenu = new BusinessSpecialMenu();
					Integer menuId = rightObj.getInt("menuId");
					businessSpecialMenu.setMenuId(menuId);
					businessSpecialMenu.setRefuId(businessRoleRefu.getRefuId());
					BusinessMenu menu = businessMenuService.findMenuById(menuId);
					businessSpecialMenu.setNo(menu.getOrd());
					businessSpecialMenuService.save(businessSpecialMenu);
					//保存功能
					JSONArray functionArr = rightObj.getJSONArray("children");
					for(int k=0;k<functionArr.size();k++) {
						JSONObject functionObj = (JSONObject) functionArr.get(k);
						BusinessSpecialFunction businessSpecialFunction = new BusinessSpecialFunction();
						Integer functionId = functionObj.getInt("functionId");
						businessSpecialFunction.setFunctionId(functionId);
						businessSpecialFunction.setSpmeId(businessSpecialMenu.getSpmeId());
						businessSpecialFunctionService.save(businessSpecialFunction);
					}
				}
			}
			
			/*//删除之前的权限
			businessRoleService.deleteMenuFunction(businessRole.getRoleId());
			
			//保存权限
			String[] menuIds = request.getParameterValues("menuId");
			for(int i=0;i<menuIds.length;i++) {
				String menuId = menuIds[i];
				//保存角色菜单
				BusinessRoleMenu menu = new BusinessRoleMenu();
				menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
				menu.setRoleId(businessRole.getRoleId());
				menu.setMenuId(new Integer(menuId));
				menu.setEditTime(new Timestamp(System.currentTimeMillis()));
				BusinessMenu businessMenu = new BusinessMenu();
				businessMenu.setMenuId(new Integer(menuId));
				List menuList = businessMenuService.selectMenuId(businessMenu);
				businessMenu = (BusinessMenu) menuList.get(0);
				menu.setNo(businessMenu.getOrd());
				businessRoleMenuService.save(menu);
				//保存功能权限
				String[] fundtionIds = request.getParameterValues("functionId_"+menuId);
				for(int j=0;j<fundtionIds.length;j++) {
					BusinessRoleFunction function = new BusinessRoleFunction();
					String functionId = fundtionIds[j];
					function.setRomeId(menu.getRomeId());
					function.setFunctionId(new Integer(functionId));
					businessRoleFunctionService.save(function);
				}
			}	*/		
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRole信息时发生错误：/manage/businessRole/update", e);
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
	 * 删除特殊角色单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="specialDelete")
	public void specialDelete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessRoleService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRole时发生错误：/manage/businessRole/delete", e);
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
	 * 进入特殊社区新增页
	 * @return
	 * 
	 */
	@RequestMapping(value="addSpecialCommunity")
	public ModelAndView addSpecialCommunity(BusinessRoleQuery query) {
		List resourceList = new ArrayList();
		try{
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
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/manage/businessRole/addSpecialCommunity", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/addSpecialCommunity");
		mav.addObject("resourceList", resourceList);
		return mav;
	}	
	
	/**
	 * 进入特殊权限新增页
	 * @return
	 * 
	 */
	@RequestMapping(value="addSpecialRight")
	public ModelAndView addSpecialRight(BusinessRoleQuery query) {	
		List groupList = new ArrayList();
		Map menuMap = null;
		List menuList = new ArrayList();
		try{
			groupList = businessRoleGroupService.findAll();
			List<BusinessMenu> moduleMenuList=businessMenuService.findAllMenu();
			for (BusinessMenu businessMenu : moduleMenuList) {
				menuMap = new HashMap();
				menuMap.put("menuId",businessMenu.getMenuId());
				menuMap.put("menuName",businessMenu.getName());
				List<ManageFunction> manageFunctionList=manageFunctionService.findFunctionByMenu(businessMenu.getMenuId());
				menuMap.put("functionList", manageFunctionList);
				menuList.add(menuMap);
			}
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/manage/businessRole/addSpecialRight", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/addSpecialRight");
		mav.addObject("groupList", groupList);
		mav.addObject("menuList", menuList);
		return mav;
	}
	
	/**
	 * 进入特殊社区编辑页
	 * @return
	 * 
	 */
	@RequestMapping(value="editSpecialCommunity")
	public ModelAndView editSpecialCommunity(BusinessRoleQuery query) {
		List resourceList = new ArrayList();
		try{
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
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/manage/businessRole/editSpecialCommunity", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/editSpecialCommunity");
		mav.addObject("resourceList", resourceList);
		return mav;
	}	
	
	/**
	 * 进入特殊权限编辑页
	 * @return
	 * 
	 */
	@RequestMapping(value="editSpecialRight")
	public ModelAndView editSpecialRight(BusinessRoleQuery query) {	
		List groupList = new ArrayList();
		Map menuMap = null;
		List menuList = new ArrayList();
		try{
			groupList = businessRoleGroupService.findAll();
			List<BusinessMenu> moduleMenuList=businessMenuService.findAllMenu();
			for (BusinessMenu businessMenu : moduleMenuList) {
				menuMap = new HashMap();
				menuMap.put("menuId",businessMenu.getMenuId());
				menuMap.put("menuName",businessMenu.getName());
				List<ManageFunction> manageFunctionList=manageFunctionService.findFunctionByMenu(businessMenu.getMenuId());
				menuMap.put("functionList", manageFunctionList);
				menuList.add(menuMap);
			}
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/manage/businessRole/editSpecialRight", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRole/editSpecialRight");
		mav.addObject("groupList", groupList);
		mav.addObject("menuList", menuList);
		return mav;
	}
	
	/**
	 * 初始化编辑资源权限
	 * @param id
	 * @return
	 */
	@RequestMapping(value="initSpecialResourceRight")
	public void initSpecialResourceRight(@RequestParam(value="roleId") Integer roleId, HttpServletResponse response) {
		String json = "";
		try{
			JSONArray resourceRightArray = new JSONArray();
			//获取角色下的资源权限索引
			Map paramMap = new HashMap();
			paramMap.put("roleId", roleId);
			List<BusinessRoleRefu> businessRoleRefuList = businessRoleRefuService.findByMap(paramMap);
			JSONObject resourceRightObj = null;
			for(int i=0;i<businessRoleRefuList.size();i++) {
				BusinessRoleRefu businessRoleRefu = businessRoleRefuList.get(i);
				resourceRightObj = new JSONObject();
				resourceRightObj.put("itemIndex", i+1);
				resourceRightObj.put("resourRightId", businessRoleRefu.getRefuId());
				//构造资源json
				JSONArray resourceArray = new JSONArray();
				paramMap = new HashMap();
				paramMap.put("refuId", businessRoleRefu.getRefuId());
				//构造社区
				List<BusinessRoleCommunity> businessRoleCommunityList = businessRoleCommunityService.findByMap(paramMap);
				JSONObject comObj = null;
				for(int j=0;j<businessRoleCommunityList.size();j++) {
					BusinessRoleCommunity businessRoleCommunity = businessRoleCommunityList.get(j);
					comObj = new JSONObject();
					comObj.put("id", businessRoleCommunity.getComId());
					comObj.put("text", businessRoleCommunity.getComName());
					System.out.println("com  "+ businessRoleCommunity.getComId() + "  "+businessRoleCommunity.getComName());
					//构造小区
					paramMap = new HashMap();
					paramMap.put("rocoId", businessRoleCommunity.getRocoId());
					List<BusinessRoleEstate> businessRoleEstateList = businessRoleEstateService.findByMap(paramMap);
					JSONArray estateArray = new JSONArray();
					JSONObject estateObj = null;
					for(int k=0;k<businessRoleEstateList.size();k++) {
						BusinessRoleEstate businessRoleEstate = businessRoleEstateList.get(k);
						estateObj = new JSONObject();
						estateObj.put("id", businessRoleEstate.getEstateId());
						estateObj.put("text", businessRoleEstate.getEstateName());
						System.out.println("estate  "+ businessRoleEstate.getEstateId() + "  "+businessRoleEstate.getEstateName());
						estateArray.add(estateObj);
					}	
					comObj.put("children", estateArray);
					resourceArray.add(comObj);
				}
				resourceRightObj.put("resource", resourceArray);
				
				//构造权限json
				paramMap = new HashMap();
				paramMap.put("refuId", businessRoleRefu.getRefuId());
				List<BusinessSpecialMenu> businessSpecialMenuList = businessSpecialMenuService.findByMap(paramMap);
				JSONObject menuObj = null;
				JSONArray rightArray = new JSONArray();
				for(int j=0;j<businessSpecialMenuList.size();j++) {
					BusinessSpecialMenu businessSpecialMenu = businessSpecialMenuList.get(j);
					menuObj = new JSONObject();
					menuObj.put("menuId", businessSpecialMenu.getMenuId());
					menuObj.put("menuName", businessSpecialMenu.getMenuName());
					System.out.println("estate  "+ businessSpecialMenu.getMenuId() + "  "+businessSpecialMenu.getMenuName());
					//构造功能
					paramMap = new HashMap();
					paramMap.put("spmeId", businessSpecialMenu.getSpmeId());
					List<BusinessSpecialFunction> businessSpecialFunctionList = businessSpecialFunctionService.findByMap(paramMap);
					JSONObject functionObj = null;
					JSONArray functionArray = new JSONArray();
					for(int k=0;k<businessSpecialFunctionList.size();k++) {
						BusinessSpecialFunction businessSpecialFunction = businessSpecialFunctionList.get(k);
						functionObj = new JSONObject();
						functionObj.put("functionId", businessSpecialFunction.getFunctionId());
						functionObj.put("functionName", businessSpecialFunction.getFunctionName());
						System.out.println("estate  "+ businessSpecialFunction.getFunctionId() + "  "+businessSpecialFunction.getFunctionName());
						functionArray.add(functionObj);
					}
					menuObj.put("children", functionArray);
					rightArray.add(menuObj);
				}
				resourceRightObj.put("right", rightArray);
				resourceRightArray.add(resourceRightObj);
			}				
			
			//序列化整个json
			json = resourceRightArray.toString();
			
			json = "{\"success\":\"true\",\"message\":\"获取成功\",\"data\":"+json+"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"获取失败\"}";
			GSLogger.error("获取BusinessRole时发生错误：/manage/businessRole/delete", e);
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
	
}
