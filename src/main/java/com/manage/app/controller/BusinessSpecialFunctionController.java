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

import com.manage.app.bean.BusinessSpecialFunction;
import com.manage.app.service.BusinessSpecialFunctionService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessSpecialFunctionQuery;


@Controller
@RequestMapping("/business/businessSpecialFunction")
public class BusinessSpecialFunctionController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessSpecialFunctionController.class);
	@Autowired
	private BusinessSpecialFunctionService businessSpecialFunctionService;
	
	private final String LIST_ACTION = "redirect:/business/businessSpecialFunction/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessSpecialFunction管理页时发生错误：/business/businessSpecialFunction/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSpecialFunction/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessSpecialFunctionQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessSpecialFunctionService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessSpecialFunction businessSpecialFunction = (BusinessSpecialFunction) baseBean.getList().get(i);
				result.append("{")
			    .append("\"spfuId\":\"").append(businessSpecialFunction.getSpfuId()).append("\"").append(",")
			    .append("\"spmeId\":\"").append(businessSpecialFunction.getSpmeId()).append("\"").append(",")
			    .append("\"functionId\":\"").append(businessSpecialFunction.getFunctionId()).append("\"")
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
			GSLogger.error("显示businessSpecialFunction列表时发生错误：/business/businessSpecialFunction/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessSpecialFunctionQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessSpecialFunction新增页时发生错误：/business/businessSpecialFunction/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSpecialFunction/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessSpecialFunction
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessSpecialFunctionQuery query) {
		BusinessSpecialFunction businessSpecialFunction = new BusinessSpecialFunction();
		String json = "";
		try{
		    businessSpecialFunction.setSpmeId(query.getSpmeId());
		    businessSpecialFunction.setFunctionId(query.getFunctionId());
			businessSpecialFunctionService.save(businessSpecialFunction);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessSpecialFunction信息时发生错误：/business/businessSpecialFunction/save", e);
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
	public ModelAndView modify(BusinessSpecialFunctionQuery query) {	
		BusinessSpecialFunction businessSpecialFunction=new BusinessSpecialFunction();
		
		try{
			businessSpecialFunction = businessSpecialFunctionService.findById(query.getSpfuId());
		}catch(Exception e){
			GSLogger.error("进入businessSpecialFunction修改页时发生错误：/business/businessSpecialFunction/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSpecialFunction/modify");
		mav.addObject("businessSpecialFunction", businessSpecialFunction);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessSpecialFunctionQuery query) {
		BusinessSpecialFunction businessSpecialFunction = null;
		String json = "";
		try{
		    businessSpecialFunction = businessSpecialFunctionService.findById(query.getSpfuId());
		    businessSpecialFunction.setSpmeId(query.getSpmeId());
		    businessSpecialFunction.setFunctionId(query.getFunctionId());
			businessSpecialFunctionService.update(businessSpecialFunction);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessSpecialFunction信息时发生错误：/business/businessSpecialFunction/update", e);
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
						businessSpecialFunctionService.delete(new Integer(ids[i]));
					}
				}else{
					businessSpecialFunctionService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessSpecialFunction时发生错误：/business/businessSpecialFunction/delete", e);
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
