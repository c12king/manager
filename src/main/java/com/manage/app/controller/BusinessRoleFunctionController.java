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

import com.manage.app.bean.BusinessRoleFunction;
import com.manage.app.service.BusinessRoleFunctionService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleFunctionQuery;


@Controller
@RequestMapping("/manage/businessRoleFunction")
public class BusinessRoleFunctionController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleFunctionController.class);
	@Autowired
	private BusinessRoleFunctionService businessRoleFunctionService;
	
	private final String LIST_ACTION = "redirect:/manage/businessRoleFunction/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleFunction管理页时发生错误：/manage/businessRoleFunction/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRoleFunction/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleFunctionQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleFunctionService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRoleFunction businessRoleFunction = (BusinessRoleFunction) baseBean.getList().get(i);
				result.append("{")
			    .append("\"rofuId\":\"").append(businessRoleFunction.getRofuId()).append("\"").append(",")
			    .append("\"romeId\":\"").append(businessRoleFunction.getRomeId()).append("\"").append(",")
			    .append("\"functionId\":\"").append(businessRoleFunction.getFunctionId()).append("\"")
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
			GSLogger.error("显示businessRoleFunction列表时发生错误：/manage/businessRoleFunction/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleFunctionQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleFunction新增页时发生错误：/manage/businessRoleFunction/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRoleFunction/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRoleFunction
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleFunctionQuery query) {
		BusinessRoleFunction businessRoleFunction = new BusinessRoleFunction();
		String json = "";
		try{
		    businessRoleFunction.setRomeId(query.getRomeId());
		    businessRoleFunction.setFunctionId(query.getFunctionId());
			businessRoleFunctionService.save(businessRoleFunction);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRoleFunction信息时发生错误：/manage/businessRoleFunction/save", e);
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
	public ModelAndView modify(BusinessRoleFunctionQuery query) {	
		BusinessRoleFunction businessRoleFunction=new BusinessRoleFunction();
		
		try{
			businessRoleFunction = businessRoleFunctionService.findById(query.getRofuId());
		}catch(Exception e){
			GSLogger.error("进入businessRoleFunction修改页时发生错误：/manage/businessRoleFunction/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRoleFunction/modify");
		mav.addObject("businessRoleFunction", businessRoleFunction);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleFunctionQuery query) {
		BusinessRoleFunction businessRoleFunction = null;
		String json = "";
		try{
		    businessRoleFunction = businessRoleFunctionService.findById(query.getRofuId());
		    businessRoleFunction.setRomeId(query.getRomeId());
		    businessRoleFunction.setFunctionId(query.getFunctionId());
			businessRoleFunctionService.update(businessRoleFunction);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRoleFunction信息时发生错误：/manage/businessRoleFunction/update", e);
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
						businessRoleFunctionService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleFunctionService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRoleFunction时发生错误：/manage/businessRoleFunction/delete", e);
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
