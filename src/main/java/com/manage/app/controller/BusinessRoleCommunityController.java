package com.manage.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessRoleCommunity;
import com.manage.app.service.BusinessRoleCommunityService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleCommunityQuery;


@Controller
@RequestMapping("/business/businessRoleCommunity")
public class BusinessRoleCommunityController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleCommunityController.class);
	@Autowired
	private BusinessRoleCommunityService businessRoleCommunityService;
	
	private final String LIST_ACTION = "redirect:/business/businessRoleCommunity/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleCommunity管理页时发生错误：/business/businessRoleCommunity/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleCommunity/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleCommunityQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleCommunityService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRoleCommunity businessRoleCommunity = (BusinessRoleCommunity) baseBean.getList().get(i);
				result.append("{")
			    .append("\"rocoId\":\"").append(businessRoleCommunity.getRocoId()).append("\"").append(",")
			    .append("\"refuId\":\"").append(businessRoleCommunity.getRefuId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessRoleCommunity.getComId()).append("\"")
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
			GSLogger.error("显示businessRoleCommunity列表时发生错误：/business/businessRoleCommunity/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleCommunityQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleCommunity新增页时发生错误：/business/businessRoleCommunity/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleCommunity/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRoleCommunity
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleCommunityQuery query) {
		BusinessRoleCommunity businessRoleCommunity = new BusinessRoleCommunity();
		String json = "";
		try{
		    businessRoleCommunity.setRefuId(query.getRefuId());
		    businessRoleCommunity.setComId(query.getComId());
			businessRoleCommunityService.save(businessRoleCommunity);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRoleCommunity信息时发生错误：/business/businessRoleCommunity/save", e);
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
	public ModelAndView modify(BusinessRoleCommunityQuery query) {	
		BusinessRoleCommunity businessRoleCommunity=new BusinessRoleCommunity();
		
		try{
			businessRoleCommunity = businessRoleCommunityService.findById(query.getRocoId());
		}catch(Exception e){
			GSLogger.error("进入businessRoleCommunity修改页时发生错误：/business/businessRoleCommunity/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleCommunity/modify");
		mav.addObject("businessRoleCommunity", businessRoleCommunity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleCommunityQuery query) {
		BusinessRoleCommunity businessRoleCommunity = null;
		String json = "";
		try{
		    businessRoleCommunity = businessRoleCommunityService.findById(query.getRocoId());
		    businessRoleCommunity.setRefuId(query.getRefuId());
		    businessRoleCommunity.setComId(query.getComId());
			businessRoleCommunityService.update(businessRoleCommunity);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRoleCommunity信息时发生错误：/business/businessRoleCommunity/update", e);
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
						businessRoleCommunityService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleCommunityService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRoleCommunity时发生错误：/business/businessRoleCommunity/delete", e);
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
