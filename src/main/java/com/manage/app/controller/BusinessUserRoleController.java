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

import com.manage.app.bean.BusinessUserRole;
import com.manage.app.service.BusinessUserRoleService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessUserRoleQuery;


@Controller
@RequestMapping("/business/businessUserRole")
public class BusinessUserRoleController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserRoleController.class);
	@Autowired
	private BusinessUserRoleService businessUserRoleService;
	
	private final String LIST_ACTION = "redirect:/business/businessUserRole/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserRole管理页时发生错误：/business/businessUserRole/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserRole/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessUserRoleQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessUserRoleService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessUserRole businessUserRole = (BusinessUserRole) baseBean.getList().get(i);
				result.append("{")
			    .append("\"usroId\":\"").append(businessUserRole.getUsroId()).append("\"").append(",")
			    .append("\"roleId\":\"").append(businessUserRole.getRoleId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessUserRole.getUserId()).append("\"")
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
			GSLogger.error("显示businessUserRole列表时发生错误：/business/businessUserRole/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessUserRoleQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserRole新增页时发生错误：/business/businessUserRole/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserRole/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessUserRole
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessUserRoleQuery query) {
		BusinessUserRole businessUserRole = new BusinessUserRole();
		String json = "";
		try{
		    businessUserRole.setRoleId(query.getRoleId());
		    businessUserRole.setUserId(query.getUserId());
			businessUserRoleService.save(businessUserRole);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUserRole信息时发生错误：/business/businessUserRole/save", e);
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
	public ModelAndView modify(BusinessUserRoleQuery query) {	
		BusinessUserRole businessUserRole=new BusinessUserRole();
		
		try{
			businessUserRole = businessUserRoleService.findById(query.getUsroId());
		}catch(Exception e){
			GSLogger.error("进入businessUserRole修改页时发生错误：/business/businessUserRole/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserRole/modify");
		mav.addObject("businessUserRole", businessUserRole);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessUserRoleQuery query) {
		BusinessUserRole businessUserRole = null;
		String json = "";
		try{
		    businessUserRole = businessUserRoleService.findById(query.getUsroId());
		    businessUserRole.setRoleId(query.getRoleId());
		    businessUserRole.setUserId(query.getUserId());
			businessUserRoleService.update(businessUserRole);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUserRole信息时发生错误：/business/businessUserRole/update", e);
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
						businessUserRoleService.delete(new Integer(ids[i]));
					}
				}else{
					businessUserRoleService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessUserRole时发生错误：/business/businessUserRole/delete", e);
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
