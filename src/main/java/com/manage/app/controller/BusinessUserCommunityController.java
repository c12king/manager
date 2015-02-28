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

import com.manage.app.bean.BusinessUserCommunity;
import com.manage.app.service.BusinessUserCommunityService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessUserCommunityQuery;


@Controller
@RequestMapping("/business/businessUserCommunity")
public class BusinessUserCommunityController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserCommunityController.class);
	@Autowired
	private BusinessUserCommunityService businessUserCommunityService;
	
	private final String LIST_ACTION = "redirect:/business/businessUserCommunity/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserCommunity管理页时发生错误：/business/businessUserCommunity/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserCommunity/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessUserCommunityQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessUserCommunityService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessUserCommunity businessUserCommunity = (BusinessUserCommunity) baseBean.getList().get(i);
				result.append("{")
			    .append("\"urcoId\":\"").append(businessUserCommunity.getUrcoId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessUserCommunity.getUserId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessUserCommunity.getComId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessUserCommunity.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessUserCommunity.getEditTime()).append("\"")
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
			GSLogger.error("显示businessUserCommunity列表时发生错误：/business/businessUserCommunity/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessUserCommunityQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserCommunity新增页时发生错误：/business/businessUserCommunity/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserCommunity/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessUserCommunity
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessUserCommunityQuery query) {
		BusinessUserCommunity businessUserCommunity = new BusinessUserCommunity();
		String json = "";
		try{
		    businessUserCommunity.setUserId(query.getUserId());
		    businessUserCommunity.setComId(query.getComId());
		    businessUserCommunity.setCreateTime(query.getCreateTime());
		    businessUserCommunity.setEditTime(query.getEditTime());
			businessUserCommunityService.save(businessUserCommunity);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUserCommunity信息时发生错误：/business/businessUserCommunity/save", e);
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
	public ModelAndView modify(BusinessUserCommunityQuery query) {	
		BusinessUserCommunity businessUserCommunity=new BusinessUserCommunity();
		
		try{
			businessUserCommunity = businessUserCommunityService.findById(query.getUrcoId());
		}catch(Exception e){
			GSLogger.error("进入businessUserCommunity修改页时发生错误：/business/businessUserCommunity/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserCommunity/modify");
		mav.addObject("businessUserCommunity", businessUserCommunity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessUserCommunityQuery query) {
		BusinessUserCommunity businessUserCommunity = null;
		String json = "";
		try{
		    businessUserCommunity = businessUserCommunityService.findById(query.getUrcoId());
		    businessUserCommunity.setUserId(query.getUserId());
		    businessUserCommunity.setComId(query.getComId());
		    businessUserCommunity.setCreateTime(query.getCreateTime());
		    businessUserCommunity.setEditTime(query.getEditTime());
			businessUserCommunityService.update(businessUserCommunity);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUserCommunity信息时发生错误：/business/businessUserCommunity/update", e);
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
						businessUserCommunityService.delete(new Integer(ids[i]));
					}
				}else{
					businessUserCommunityService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessUserCommunity时发生错误：/business/businessUserCommunity/delete", e);
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
