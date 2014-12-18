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


import com.manage.app.bean.BusinessProperty;
import com.manage.app.bean.BusinessStation;
import com.manage.app.common.ModuleConst;
import com.manage.app.service.BusinessStationService;
import com.manage.app.vo.BusinessStationQuery;


@Controller
@RequestMapping("/manage/businessStation")
public class BusinessStationController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationController.class);
	@Autowired
	private BusinessStationService businessStationService;
	
	private final String LIST_ACTION = "redirect:/manage/businessStation/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStation管理页时发生错误：/manage/businessStation/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStation/enter");
		return mav;
	}
	
	
	
	/**
	 * 进入编辑部门页
	 * @return
	 */
	@RequestMapping(value="org")
	public ModelAndView org(HttpServletRequest request) {		
		BusinessStation businessStation=new BusinessStation();
		String id= request.getParameter("id");
		try{
			businessStation = businessStationService.findById(new Integer(id));
		}catch(Exception e){
			GSLogger.error("进入manageOrg管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStation/org");
		mav.addObject("staId",businessStation.getStationId());
		mav.addObject("staName",businessStation.getStaName());
		mav.addObject("type",ModuleConst.STATION_CODE);
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessStationQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessStationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStation businessStation = (BusinessStation) baseBean.getList().get(i);
				result.append("{")
			    .append("\"stationId\":\"").append(businessStation.getStationId()).append("\"").append(",")
			    .append("\"orgId\":\"").append(businessStation.getOrgId()).append("\"").append(",")
			    .append("\"staName\":\"").append(businessStation.getStaName()).append("\"").append(",")
			    .append("\"staBrief\":\"").append(businessStation.getStaBrief()).append("\"").append(",")
			    .append("\"staService\":\"").append(businessStation.getStaService()).append("\"").append(",")
			    .append("\"staTel\":\"").append(businessStation.getStaTel()).append("\"").append(",")
			    .append("\"staEmail\":\"").append(businessStation.getStaEmail()).append("\"").append(",")
			    .append("\"staWeixin\":\"").append(businessStation.getStaWeixin()).append("\"").append(",")
			    .append("\"staIcon\":\"").append(businessStation.getStaIcon()).append("\"").append(",")
			    .append("\"staLongitude\":\"").append(businessStation.getStaLongitude()).append("\"").append(",")
			    .append("\"staLatitude\":\"").append(businessStation.getStaLatitude()).append("\"").append(",")
			    .append("\"crateTime\":\"").append(businessStation.getCrateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessStation.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessStation.getEditor()).append("\"")
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
			GSLogger.error("显示businessStation列表时发生错误：/manage/businessStation/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessStationQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStation新增页时发生错误：/manage/businessStation/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStation/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessStation
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessStationQuery query) {
		BusinessStation businessStation = new BusinessStation();
		String json = "";
		try{
		    businessStation.setOrgId(query.getOrgId());
		    businessStation.setStaName(query.getStaName());
		    businessStation.setStaBrief(query.getStaBrief());
		    businessStation.setStaService(query.getStaService());
		    businessStation.setStaTel(query.getStaTel());
		    businessStation.setStaEmail(query.getStaEmail());
		    businessStation.setStaWeixin(query.getStaWeixin());
		    businessStation.setStaIcon(query.getStaIcon());
		    businessStation.setStaLongitude(query.getStaLongitude());
		    businessStation.setStaLatitude(query.getStaLatitude());
		    businessStation.setCrateTime(query.getCrateTime());
		    businessStation.setEditTime(query.getEditTime());
		    businessStation.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessStation.setCrateTime(ts);
	        businessStation.setEditTime(ts);
			businessStationService.save(businessStation);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessStation信息时发生错误：/manage/businessStation/save", e);
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
	public ModelAndView modify(BusinessStationQuery query) {	
		BusinessStation businessStation=new BusinessStation();
		
		try{
			businessStation = businessStationService.findById(query.getStationId());
		}catch(Exception e){
			GSLogger.error("进入businessStation修改页时发生错误：/manage/businessStation/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStation/modify");
		mav.addObject("businessStation", businessStation);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessStationQuery query) {
		BusinessStation businessStation = null;
		String json = "";
		try{
		    businessStation = businessStationService.findById(query.getStationId());
		    businessStation.setOrgId(query.getOrgId());
		    businessStation.setStaName(query.getStaName());
		    businessStation.setStaBrief(query.getStaBrief());
		    businessStation.setStaService(query.getStaService());
		    businessStation.setStaTel(query.getStaTel());
		    businessStation.setStaEmail(query.getStaEmail());
		    businessStation.setStaWeixin(query.getStaWeixin());
		    businessStation.setStaIcon(query.getStaIcon());
		    businessStation.setStaLongitude(query.getStaLongitude());
		    businessStation.setStaLatitude(query.getStaLatitude());
		    businessStation.setCrateTime(query.getCrateTime());
		    businessStation.setEditTime(query.getEditTime());
		    businessStation.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessStation.setEditTime(ts);
			businessStationService.update(businessStation);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessStation信息时发生错误：/manage/businessStation/update", e);
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
						businessStationService.delete(new Integer(ids[i]));
					}
				}else{
					businessStationService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessStation时发生错误：/manage/businessStation/delete", e);
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
	 * 获取该区域下驿站下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/getComboboxData" )
	public void getComboboxData(HttpServletRequest request,HttpServletResponse response){
		int countyId = new Integer(request.getParameter("countyId"));
		String json=businessStationService.getComboboxData(countyId);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
}
