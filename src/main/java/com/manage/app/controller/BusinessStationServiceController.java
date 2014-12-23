package com.manage.app.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessStation;
import com.manage.app.bean.BusinessStationService;
import com.manage.app.service.BusinessStationServiceService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessStationServiceQuery;


@Controller
@RequestMapping("/manage/businessStationService")
public class BusinessStationServiceController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationServiceController.class);
	@Autowired
	private BusinessStationServiceService businessStationServiceService;
	@Autowired
	private com.manage.app.service.BusinessStationService businessStationServiceSer;
	
	private final String LIST_ACTION = "redirect:/manage/businessStationService/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter(HttpServletRequest request) {		
		try{
			
		}catch(Exception e){
			GSLogger.error("进入businessStationService管理页时发生错误：/manage/businessStationService/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStationService/enter");
		
		if (StringUtils.isNotBlank(request.getParameter("id")))
			mav.addObject("stationId", request.getParameter("id"));
		if (StringUtils.isNotBlank(request.getParameter("staName")))
			mav.addObject("staName", decodeCNStr(request.getParameter("staName")));
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(HttpServletRequest request, BusinessStationServiceQuery query, HttpServletResponse response) {
		int cpage = 1;
		if (StringUtils.isNotBlank(request.getParameter("page")))
		    cpage=Integer.parseInt(request.getParameter("page"));
		if (StringUtils.isNotBlank(request.getParameter("pageNo")))
			cpage=Integer.parseInt(request.getParameter("pageNo"));
		int size = 10;
		if (StringUtils.isNotBlank(request.getParameter("rows")))
			size=Integer.parseInt(request.getParameter("rows"));
		if (StringUtils.isNotBlank(request.getParameter("pageSize")))  
			size = Integer.parseInt(request.getParameter("pageSize"));

	
		query.setPage(cpage);
		query.setRows(size);
		
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessStationServiceService.findAllPage(query);
			BusinessStation station = businessStationServiceSer.findById(query.getStationId());
			String staName = "";
			if (station != null)
				staName = StringUtils.trimToEmpty( station.getStaName());
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationService businessStationService = (BusinessStationService) baseBean.getList().get(i);
				result.append("{")
			    .append("\"serviceId\":\"").append(businessStationService.getServiceId()).append("\"").append(",")
			    .append("\"stationId\":\"").append(businessStationService.getStationId()).append("\"").append(",")
			    .append("\"staName\":\"").append(staName).append("\"").append(",")
			    .append("\"serviceName\":\"").append(businessStationService.getServiceName()).append("\"").append(",")
			    .append("\"servicePic\":\"").append(businessStationService.getServicePic()).append("\"").append(",")
			    .append("\"content\":\"").append(businessStationService.getContent()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessStationService.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessStationService.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(StringUtils.trimToEmpty(businessStationService.getEditor())).append("\"")
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
			GSLogger.error("显示businessStationService列表时发生错误：/manage/businessStationService/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessStationServiceQuery query) {	
		String staName = "";
		try{
			BusinessStation station = businessStationServiceSer.findById(query.getStationId());
		
			if (station != null)
				staName = StringUtils.trimToEmpty( station.getStaName());
		}catch(Exception e){
			GSLogger.error("进入businessStationService新增页时发生错误：/manage/businessStationService/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStationService/add");
		mav.addObject("staName", staName);
		mav.addObject("stationId", query.getStationId());
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessStationService
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessStationServiceQuery query) {
		BusinessStationService businessStationService = new BusinessStationService();
		String json = "";
		try{
		    businessStationService.setStationId(query.getStationId());
		    businessStationService.setServiceName(query.getServiceName());
		    businessStationService.setServicePic(query.getServicePic());
		    businessStationService.setContent(query.getContent());
		    businessStationService.setCreateTime(query.getCreateTime());
		    businessStationService.setEditTime(query.getEditTime());
		    businessStationService.setEditor(query.getEditor());
			businessStationServiceService.save(businessStationService);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessStationService信息时发生错误：/manage/businessStationService/save", e);
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
	public ModelAndView modify(BusinessStationServiceQuery query) {	
		BusinessStationService businessStationService=new BusinessStationService();
		
		try{
			businessStationService = businessStationServiceService.findById(query.getServiceId());
		}catch(Exception e){
			GSLogger.error("进入businessStationService修改页时发生错误：/manage/businessStationService/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessStationService/modify");
		mav.addObject("businessStationService", businessStationService);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessStationServiceQuery query) {
		BusinessStationService businessStationService = null;
		String json = "";
		try{
		    businessStationService = businessStationServiceService.findById(query.getServiceId());
		    businessStationService.setStationId(query.getStationId());
		    businessStationService.setServiceName(query.getServiceName());
		    businessStationService.setServicePic(query.getServicePic());
		    businessStationService.setContent(query.getContent());
//		    businessStationService.setCreateTime(query.getCreateTime()); //创建时间
		    businessStationService.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessStationService.setEditor(query.getEditor());
			businessStationServiceService.update(businessStationService);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessStationService信息时发生错误：/manage/businessStationService/update", e);
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
						businessStationServiceService.delete(new Integer(ids[i]));
					}
				}else{
					businessStationServiceService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessStationService时发生错误：/manage/businessStationService/delete", e);
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
	protected String decodeCNStr(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	protected String decodeCNString(String str) {
		try {
			return java.net.URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
