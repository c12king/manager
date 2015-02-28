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

import com.manage.app.bean.BusinessRoleEstate;
import com.manage.app.service.BusinessRoleEstateService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleEstateQuery;


@Controller
@RequestMapping("/business/businessRoleEstate")
public class BusinessRoleEstateController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleEstateController.class);
	@Autowired
	private BusinessRoleEstateService businessRoleEstateService;
	
	private final String LIST_ACTION = "redirect:/business/businessRoleEstate/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleEstate管理页时发生错误：/business/businessRoleEstate/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleEstate/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleEstateQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleEstateService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRoleEstate businessRoleEstate = (BusinessRoleEstate) baseBean.getList().get(i);
				result.append("{")
			    .append("\"roesId\":\"").append(businessRoleEstate.getRoesId()).append("\"").append(",")
			    .append("\"rocoId\":\"").append(businessRoleEstate.getRocoId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessRoleEstate.getEstateId()).append("\"")
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
			GSLogger.error("显示businessRoleEstate列表时发生错误：/business/businessRoleEstate/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleEstateQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleEstate新增页时发生错误：/business/businessRoleEstate/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleEstate/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRoleEstate
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleEstateQuery query) {
		BusinessRoleEstate businessRoleEstate = new BusinessRoleEstate();
		String json = "";
		try{
		    businessRoleEstate.setRocoId(query.getRocoId());
		    businessRoleEstate.setEstateId(query.getEstateId());
			businessRoleEstateService.save(businessRoleEstate);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRoleEstate信息时发生错误：/business/businessRoleEstate/save", e);
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
	public ModelAndView modify(BusinessRoleEstateQuery query) {	
		BusinessRoleEstate businessRoleEstate=new BusinessRoleEstate();
		
		try{
			businessRoleEstate = businessRoleEstateService.findById(query.getRoesId());
		}catch(Exception e){
			GSLogger.error("进入businessRoleEstate修改页时发生错误：/business/businessRoleEstate/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleEstate/modify");
		mav.addObject("businessRoleEstate", businessRoleEstate);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleEstateQuery query) {
		BusinessRoleEstate businessRoleEstate = null;
		String json = "";
		try{
		    businessRoleEstate = businessRoleEstateService.findById(query.getRoesId());
		    businessRoleEstate.setRocoId(query.getRocoId());
		    businessRoleEstate.setEstateId(query.getEstateId());
			businessRoleEstateService.update(businessRoleEstate);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRoleEstate信息时发生错误：/business/businessRoleEstate/update", e);
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
						businessRoleEstateService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleEstateService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRoleEstate时发生错误：/business/businessRoleEstate/delete", e);
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
