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

import com.manage.app.bean.BusinessRoleRefu;
import com.manage.app.service.BusinessRoleRefuService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleRefuQuery;


@Controller
@RequestMapping("/business/businessRoleRefu")
public class BusinessRoleRefuController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleRefuController.class);
	@Autowired
	private BusinessRoleRefuService businessRoleRefuService;
	
	private final String LIST_ACTION = "redirect:/business/businessRoleRefu/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleRefu管理页时发生错误：/business/businessRoleRefu/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleRefu/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleRefuQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleRefuService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRoleRefu businessRoleRefu = (BusinessRoleRefu) baseBean.getList().get(i);
				result.append("{")
			    .append("\"refuId\":\"").append(businessRoleRefu.getRefuId()).append("\"").append(",")
			    .append("\"roleId\":\"").append(businessRoleRefu.getRoleId()).append("\"")
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
			GSLogger.error("显示businessRoleRefu列表时发生错误：/business/businessRoleRefu/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleRefuQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleRefu新增页时发生错误：/business/businessRoleRefu/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleRefu/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRoleRefu
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleRefuQuery query) {
		BusinessRoleRefu businessRoleRefu = new BusinessRoleRefu();
		String json = "";
		try{
		    businessRoleRefu.setRoleId(query.getRoleId());
			businessRoleRefuService.save(businessRoleRefu);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRoleRefu信息时发生错误：/business/businessRoleRefu/save", e);
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
	public ModelAndView modify(BusinessRoleRefuQuery query) {	
		BusinessRoleRefu businessRoleRefu=new BusinessRoleRefu();
		
		try{
			businessRoleRefu = businessRoleRefuService.findById(query.getRefuId());
		}catch(Exception e){
			GSLogger.error("进入businessRoleRefu修改页时发生错误：/business/businessRoleRefu/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleRefu/modify");
		mav.addObject("businessRoleRefu", businessRoleRefu);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleRefuQuery query) {
		BusinessRoleRefu businessRoleRefu = null;
		String json = "";
		try{
		    businessRoleRefu = businessRoleRefuService.findById(query.getRefuId());
		    businessRoleRefu.setRoleId(query.getRoleId());
			businessRoleRefuService.update(businessRoleRefu);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRoleRefu信息时发生错误：/business/businessRoleRefu/update", e);
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
						businessRoleRefuService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleRefuService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRoleRefu时发生错误：/business/businessRoleRefu/delete", e);
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
