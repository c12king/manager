package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

import com.manage.app.vo.BaseBean;


import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.common.ModuleConst;
import com.manage.app.service.BusinessPropertyService;
import com.manage.app.vo.BusinessPropertyQuery;


@Controller
@RequestMapping("/manage/businessProperty")
public class BusinessPropertyController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessPropertyController.class);
	@Autowired
	private BusinessPropertyService businessPropertyService;
	
	private final String LIST_ACTION = "redirect:/manage/businessProperty/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProperty管理页时发生错误：/manage/businessProperty/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessProperty/enter");
		return mav;
	}
	
	/**
	 * 进入编辑部门页
	 * @return
	 */
	@RequestMapping(value="org")
	public ModelAndView org(HttpServletRequest request) {		
		BusinessProperty businessProperty=new BusinessProperty();
		String id= request.getParameter("id");
		try{
			businessProperty = businessPropertyService.findById(new Integer(id));
		}catch(Exception e){
			GSLogger.error("进入manageOrg管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessProperty/org");
		mav.addObject("proId",businessProperty.getProId());
		mav.addObject("proName",businessProperty.getProName());
		mav.addObject("type",ModuleConst.PROPERTY_CODE);
		return mav;
	}
	
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessPropertyQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessPropertyService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProperty businessProperty = (BusinessProperty) baseBean.getList().get(i);
				result.append("{")
			    .append("\"proId\":\"").append(businessProperty.getProId()).append("\"").append(",")
			    .append("\"orgId\":\"").append(businessProperty.getOrgId()).append("\"").append(",")
			    .append("\"proName\":\"").append(businessProperty.getProName()).append("\"").append(",")
			    .append("\"proBrief\":\"").append(businessProperty.getProBrief()).append("\"").append(",")
			    .append("\"proService\":\"").append(businessProperty.getProService()).append("\"").append(",")
			    .append("\"proTel\":\"").append(businessProperty.getProTel()).append("\"").append(",")
			    .append("\"proEmail\":\"").append(businessProperty.getProEmail()).append("\"").append(",")
			    .append("\"proWeixin\":\"").append(businessProperty.getProWeixin()).append("\"").append(",")
			    .append("\"proIcon\":\"").append(businessProperty.getProIcon()).append("\"").append(",")
			    .append("\"proLongitude\":\"").append(businessProperty.getProLongitude()).append("\"").append(",")
			    .append("\"proLatitude\":\"").append(businessProperty.getProLatitude()).append("\"").append(",")
			    .append("\"crateTime\":\"").append(businessProperty.getCrateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessProperty.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessProperty.getEditor()).append("\"")
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
			GSLogger.error("显示businessProperty列表时发生错误：/manage/businessProperty/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessPropertyQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProperty新增页时发生错误：/manage/businessProperty/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessProperty/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessProperty
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessPropertyQuery query) {
		BusinessProperty businessProperty = new BusinessProperty();
		String json = "";
		try{
		    businessProperty.setOrgId(query.getOrgId());
		    businessProperty.setProName(query.getProName());
		    businessProperty.setProBrief(query.getProBrief());
		    businessProperty.setProService(query.getProService());
		    businessProperty.setProTel(query.getProTel());
		    businessProperty.setProEmail(query.getProEmail());
		    businessProperty.setProWeixin(query.getProWeixin());
		    businessProperty.setProIcon(query.getProIcon());
		    businessProperty.setProLongitude(query.getProLongitude());
		    businessProperty.setProLatitude(query.getProLatitude());
		    businessProperty.setCrateTime(query.getCrateTime());
		    businessProperty.setEditTime(query.getEditTime());
		    businessProperty.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessProperty.setCrateTime(ts);
	        businessProperty.setEditTime(ts);
			businessPropertyService.save(businessProperty);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessProperty信息时发生错误：/manage/businessProperty/save", e);
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
	public ModelAndView modify(BusinessPropertyQuery query) {	
		BusinessProperty businessProperty=new BusinessProperty();
		
		try{
			businessProperty = businessPropertyService.findById(query.getProId());
		}catch(Exception e){
			GSLogger.error("进入businessProperty修改页时发生错误：/manage/businessProperty/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessProperty/modify");
		mav.addObject("businessProperty", businessProperty);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessPropertyQuery query) {
		BusinessProperty businessProperty = null;
		String json = "";
		try{
		    businessProperty = businessPropertyService.findById(query.getProId());
		    businessProperty.setOrgId(query.getOrgId());
		    businessProperty.setProName(query.getProName());
		    businessProperty.setProBrief(query.getProBrief());
		    businessProperty.setProService(query.getProService());
		    businessProperty.setProTel(query.getProTel());
		    businessProperty.setProEmail(query.getProEmail());
		    businessProperty.setProWeixin(query.getProWeixin());
		    businessProperty.setProIcon(query.getProIcon());
		    businessProperty.setProLongitude(query.getProLongitude());
		    businessProperty.setProLatitude(query.getProLatitude());
		    businessProperty.setCrateTime(query.getCrateTime());
		    businessProperty.setEditTime(query.getEditTime());
		    businessProperty.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessProperty.setEditTime(ts);
			businessPropertyService.update(businessProperty);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessProperty信息时发生错误：/manage/businessProperty/update", e);
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
						businessPropertyService.delete(new Integer(ids[i]));
					}
				}else{
					businessPropertyService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessProperty时发生错误：/manage/businessProperty/delete", e);
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
	 * 获取该区域下物业下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/getComboboxData" )
	public void getComboboxData(HttpServletRequest request,HttpServletResponse response){
		int countyId = new Integer(request.getParameter("countyId"));
		String json=businessPropertyService.getComboboxData(countyId);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
}
