package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.BusinessUserResource;
import com.manage.app.service.BusinessUserCommunityService;
import com.manage.app.service.BusinessUserResourceService;
import com.manage.app.service.BusinessUserService;
import com.manage.app.service.ManageBuildingService;
import com.manage.app.service.ManageEstateService;
import com.manage.app.vo.BusinessUserResourceQuery;


@Controller
@RequestMapping("/business/businessUserResource")
public class BusinessUserResourceController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserResourceController.class);
	@Autowired
	private BusinessUserResourceService businessUserResourceService;
	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private ManageBuildingService manageBuildingService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessUserCommunityService businessUserCommunityService;
	
	private final String LIST_ACTION = "redirect:/business/businessUserResource/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserResource管理页时发生错误：/business/businessUserResource/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserResource/enter");
		return mav;
	}
	
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessUserResourceQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserResource新增页时发生错误：/business/businessUserResource/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserResource/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessUserResource
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessUserResourceQuery query) {
		BusinessUserResource businessUserResource = new BusinessUserResource();
		String json = "";
		try{
		    businessUserResource.setUserId(query.getUserId());
		    businessUserResource.setEstateId(query.getEstateId());
		    businessUserResource.setBuildingId(query.getBuildingId());
		    businessUserResource.setUnitId(query.getUnitId());
		    businessUserResource.setEstateName(query.getEstateName());
		    businessUserResource.setBuildingName(query.getBuildingName());
		    //businessUserResource.setUnitName(query.getUnitName());
		    businessUserResource.setCreateTime(query.getCreateTime());
		    businessUserResource.setEditTime(query.getEditTime());
		    businessUserResource.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessUserResource.setCreateTime(ts);
	        businessUserResource.setEditTime(ts);
			businessUserResourceService.save(businessUserResource);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUserResource信息时发生错误：/business/businessUserResource/save", e);
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
	 * 保存对象
	 * @param request
	 * @param businessUserResource
	 * @return
	 */
	@RequestMapping(value="save_resources")
	public void save_resources(HttpServletRequest request, HttpServletResponse response) {
		BusinessUserResource businessUserResource = new BusinessUserResource();
		String json = "";
		try{
			BusinessUser entity = new BusinessUser();
			Integer userId = new Integer(request.getParameter("userId"));
			entity.setUserId(userId);
			BusinessUser businessUser = businessUserService.findById(entity);
			
			//物业，驿站
			String[] estateIds = request.getParameterValues("estateId");
			if(estateIds != null && estateIds.length > 0) {
				//先删除，再添加
				businessUserResourceService.delete(userId);
				businessUserResourceService.save_resources(new Integer(request.getParameter("userId")),null,estateIds);
			}else{
				businessUserResourceService.delete(userId);
			}
			
			/*//社区报
			String[] comIds = request.getParameterValues("comId");
			//先删除该用户下已有的社区
			businessUserCommunityService.deleteCommunity(userId);
			
			//再保存新的社区关系
			if(comIds != null && comIds.length > 0) {
				BusinessUserCommunity businessUserCommunity = new BusinessUserCommunity();
				for(int i=0;i<comIds.length;i++) {
					Integer comId = new Integer(comIds[i]);
					businessUserCommunity.setUserId(userId);
					businessUserCommunity.setComId(comId);
					businessUserCommunity.setCreateTime(new Timestamp(System.currentTimeMillis()));
					businessUserCommunity.setEditTime(new Timestamp(System.currentTimeMillis()));
					businessUserCommunityService.save(businessUserCommunity);
				}
			}*/
			
			/*if(comIds != null && comIds.length > 0) {
				//先删除，再添加
				businessUserResourceService.delete(userId);
				for(int i=0;i<comIds.length;i++) {
					Integer comId = new Integer(comIds[i]);
					Map map = new HashMap();
					map.put("comId", comId);
					List estateList = manageEstateService.selectManageEstateByComId(comId);
					if(estateList.size() > 0) {
						for(int j=0;j<estateList.size();j++) {
							ManageEstate estate = (ManageEstate) estateList.get(j);
							businessUserResource = new BusinessUserResource();
							businessUserResource.setUserId(businessUser.getUserId());
						    businessUserResource.setEstateId(estate.getEstateId());
						    //businessUserResource.setBuildingId(building.getBuildingId());
						    //businessUserResource.setUnitId(query.getUnitId());
						    businessUserResource.setEstateName(estate.getEstateName());
						    //businessUserResource.setBuildingName(building.getBuildingName());
						    //businessUserResource.setUnitName(query.getUnitName());
						    businessUserResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
						    businessUserResource.setEditTime(new Timestamp(System.currentTimeMillis()));
						    //businessUserResource.setEditor(query.getEditor());
						    businessUserResource.setComId(comId);
							businessUserResourceService.save(businessUserResource);
						}
					}else{
						businessUserResource = new BusinessUserResource();
						businessUserResource.setUserId(businessUser.getUserId());
					    businessUserResource.setEstateId(0);
					    //businessUserResource.setBuildingId(building.getBuildingId());
					    //businessUserResource.setUnitId(query.getUnitId());
					    businessUserResource.setEstateName("");
					    //businessUserResource.setBuildingName(building.getBuildingName());
					    //businessUserResource.setUnitName(query.getUnitName());
					    businessUserResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
					    businessUserResource.setEditTime(new Timestamp(System.currentTimeMillis()));
					    //businessUserResource.setEditor(query.getEditor());
					    businessUserResource.setComId(comId);
						businessUserResourceService.save(businessUserResource);
					}
				}
			}else{
				businessUserResourceService.delete(userId);
			}*/
			
			/*if(businessUser.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {
				String[] estateIds = request.getParameterValues("estateId");
				if(estateIds != null && estateIds.length > 0) {
					//先删除，再添加
					businessUserResourceService.delete(userId);
					for(int i=0;i<estateIds.length;i++) {
						Integer estateId = new Integer(estateIds[i]);
						Map map = new HashMap();
						map.put("estateId", estateId);
						List buildingList = manageBuildingService.findByMap(map);
						if(buildingList != null && buildingList.size() > 0) {
							for(int j=0;j<buildingList.size();j++) {
								ManageBuilding building = (ManageBuilding) buildingList.get(j);
								businessUserResource = new BusinessUserResource();
								businessUserResource.setUserId(businessUser.getUserId());
							    businessUserResource.setEstateId(estateId);
							    businessUserResource.setBuildingId(building.getBuildingId());
							    //businessUserResource.setUnitId(query.getUnitId());
							    ManageEstate manageEstate = manageEstateService.selectSingleManageById(estateId);
							    businessUserResource.setEstateName(manageEstate.getEstateName());
							    businessUserResource.setBuildingName(building.getBuildingName());
							    //businessUserResource.setUnitName(query.getUnitName());
							    businessUserResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
							    businessUserResource.setEditTime(new Timestamp(System.currentTimeMillis()));
							    //businessUserResource.setEditor(query.getEditor());
								businessUserResourceService.save(businessUserResource);
							}
						}
					}
				}else{
					businessUserResourceService.delete(userId);
				}
				
			}else if(businessUser.getOrgType().equals(ModuleConst.COMMUNITY_CODE)) {
				String[] comIds = request.getParameterValues("comId");
				if(comIds != null && comIds.length > 0) {
					//先删除，再添加
					businessUserResourceService.delete(userId);
					for(int i=0;i<comIds.length;i++) {
						Integer comId = new Integer(comIds[i]);
						Map map = new HashMap();
						map.put("comId", comId);
						List estateList = manageEstateService.selectManageEstateByComId(comId);
						if(estateList.size() > 0) {
							for(int j=0;j<estateList.size();j++) {
								ManageEstate estate = (ManageEstate) estateList.get(j);
								businessUserResource = new BusinessUserResource();
								businessUserResource.setUserId(businessUser.getUserId());
							    businessUserResource.setEstateId(estate.getEstateId());
							    //businessUserResource.setBuildingId(building.getBuildingId());
							    //businessUserResource.setUnitId(query.getUnitId());
							    businessUserResource.setEstateName(estate.getEstateName());
							    //businessUserResource.setBuildingName(building.getBuildingName());
							    //businessUserResource.setUnitName(query.getUnitName());
							    businessUserResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
							    businessUserResource.setEditTime(new Timestamp(System.currentTimeMillis()));
							    //businessUserResource.setEditor(query.getEditor());
							    businessUserResource.setComId(comId);
								businessUserResourceService.save(businessUserResource);
							}
						}else{
							businessUserResource = new BusinessUserResource();
							businessUserResource.setUserId(businessUser.getUserId());
						    businessUserResource.setEstateId(0);
						    //businessUserResource.setBuildingId(building.getBuildingId());
						    //businessUserResource.setUnitId(query.getUnitId());
						    businessUserResource.setEstateName("");
						    //businessUserResource.setBuildingName(building.getBuildingName());
						    //businessUserResource.setUnitName(query.getUnitName());
						    businessUserResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
						    businessUserResource.setEditTime(new Timestamp(System.currentTimeMillis()));
						    //businessUserResource.setEditor(query.getEditor());
						    businessUserResource.setComId(comId);
							businessUserResourceService.save(businessUserResource);
						}
					}
				}else{
					businessUserResourceService.delete(userId);
				}
			}else{
				//businessUserResourceService.save_resources(new Integer(request.getParameter("userId")),request.getParameterValues("comId"),request.getParameterValues("estateId"));
				businessUserResourceService.save_resources(new Integer(request.getParameter("userId")),null,request.getParameterValues("estateId"));
			}
			*/
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUserResource信息时发生错误：/business/businessUserResource/save", e);
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
	
	@RequestMapping(value="grantAllEst")
	public void grantAllEst(HttpServletRequest request, HttpServletResponse response) {
		
		String json = "";
		try{
			
			Map<String, Object> map = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(request.getParameter("userId")) && StringUtils.isNotBlank(request.getParameter("comId")))
			{
				map.put("userId", request.getParameter("userId")); 
				map.put("comId", request.getParameter("comId"));
			}
			else
			{
				json = "{\"success\":\"false\",\"message\":\"分配所有小区失败！\"}";
			}
			
			List<BusinessUserResource> chckList = businessUserResourceService.findByMap(map);
			
			if (CollectionUtils.isEmpty(chckList))
			{
				businessUserResourceService.saveUserResource(map);
				json = "{\"success\":\"true\",\"message\":\"分配该社区所有小区成功！\"}";
			}
			else
				json = "{\"success\":\"false\",\"message\":\"该社区下已有小区分配！\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"分配该社区所有小区失败\"}";
			GSLogger.error("删除AppStatisticsClick时发生错误：/app/appStatisticsClick/delete", e);
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
	public ModelAndView modify(BusinessUserResourceQuery query) {	
		BusinessUserResource businessUserResource=new BusinessUserResource();
		
		try{
			businessUserResource = businessUserResourceService.findById(query.getUsreId());
		}catch(Exception e){
			GSLogger.error("进入businessUserResource修改页时发生错误：/business/businessUserResource/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserResource/modify");
		mav.addObject("businessUserResource", businessUserResource);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessUserResourceQuery query) {
		BusinessUserResource businessUserResource = null;
		String json = "";
		try{
		    businessUserResource = businessUserResourceService.findById(query.getUsreId());
		    businessUserResource.setUserId(query.getUserId());
		    businessUserResource.setEstateId(query.getEstateId());
		    businessUserResource.setBuildingId(query.getBuildingId());
		    businessUserResource.setUnitId(query.getUnitId());
		    businessUserResource.setEstateName(query.getEstateName());
		    businessUserResource.setBuildingName(query.getBuildingName());
		    //businessUserResource.setUnitName(query.getUnitName());
		    businessUserResource.setCreateTime(query.getCreateTime());
		    businessUserResource.setEditTime(query.getEditTime());
		    businessUserResource.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessUserResource.setEditTime(ts);
			businessUserResourceService.update(businessUserResource);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUserResource信息时发生错误：/business/businessUserResource/update", e);
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
						businessUserResourceService.delete(new Integer(ids[i]));
					}
				}else{
					businessUserResourceService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessUserResource时发生错误：/business/businessUserResource/delete", e);
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
