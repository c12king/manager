package com.manage.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessTelGroup;
import com.manage.app.service.BusinessTelGroupService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessTelGroupQuery;


@Controller
@RequestMapping("/manage/businessTelGroup")
public class BusinessTelGroupController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessTelGroupController.class);
	@Autowired
	private BusinessTelGroupService businessTelGroupService;
	
	private final String LIST_ACTION = "redirect:/business/businessTelGroup/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessTelGroup管理页时发生错误：/business/businessTelGroup/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTelGroup/enter");
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
		String id=request.getParameter("id");
//		manageBuilding.setEstateId(new Integer(id));
		String json= businessTelGroupService.treeData(id) ;    //manageBuildingService.treeData(manageBuilding);
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
	public void list(BusinessTelGroupQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessTelGroupService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessTelGroup businessTelGroup = (BusinessTelGroup) baseBean.getList().get(i);
				result.append("{")
			    .append("\"groupId\":\"").append(businessTelGroup.getGroupId()).append("\"").append(",")
			    .append("\"cityId\":\"").append(businessTelGroup.getCityId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessTelGroup.getComId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessTelGroup.getEstateId()).append("\"").append(",")
			    .append("\"groupName\":\"").append(businessTelGroup.getGroupName()).append("\"").append(",")
			    .append("\"memo\":\"").append(businessTelGroup.getMemo()).append("\"")
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
			GSLogger.error("显示businessTelGroup列表时发生错误：/manage/businessTelGroup/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessTelGroupQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessTelGroup新增页时发生错误：/business/businessTelGroup/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessTelGroup/add");
		if (query.getComId() != null)
			mav.addObject("comId", query.getComId());
		else
			mav.addObject("comId", 0);
		mav.addObject("estateId", query.getEstateId());
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessTelGroup
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessTelGroupQuery query) {
		BusinessTelGroup businessTelGroup = new BusinessTelGroup();
		String json = "";
		try{
		    businessTelGroup.setCityId(query.getCityId());
		    businessTelGroup.setComId(query.getComId());
		    businessTelGroup.setEstateId(query.getEstateId());
		    businessTelGroup.setGroupName(query.getGroupName());
		    businessTelGroup.setMemo(query.getMemo());
			businessTelGroupService.save(businessTelGroup);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessTelGroup信息时发生错误：/business/businessTelGroup/save", e);
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
	public ModelAndView modify(BusinessTelGroupQuery query) {	
		BusinessTelGroup businessTelGroup=new BusinessTelGroup();
		
		try{
			businessTelGroup = businessTelGroupService.findById(query.getGroupId());
		}catch(Exception e){
			GSLogger.error("进入businessTelGroup修改页时发生错误：/manage/businessTelGroup/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessTelGroup/modify");
		mav.addObject("businessTelGroup", businessTelGroup);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessTelGroupQuery query) {
		BusinessTelGroup businessTelGroup = null;
		String json = "";
		try{
		    businessTelGroup = businessTelGroupService.findById(query.getGroupId());
		    businessTelGroup.setCityId(query.getCityId());
		    businessTelGroup.setComId(query.getComId());
		    businessTelGroup.setEstateId(query.getEstateId());
		    businessTelGroup.setGroupName(query.getGroupName());
		    businessTelGroup.setMemo(query.getMemo());
			businessTelGroupService.update(businessTelGroup);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessTelGroup信息时发生错误：/business/businessTelGroup/update", e);
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
						businessTelGroupService.delete(new Integer(ids[i]));
					}
				}else{
					businessTelGroupService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessTelGroup时发生错误：/business/businessTelGroup/delete", e);
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
