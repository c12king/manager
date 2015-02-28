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

import com.manage.app.bean.BusinessRoleMenu;
import com.manage.app.service.BusinessRoleMenuService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleMenuQuery;


@Controller
@RequestMapping("/manage/businessRoleMenu")
public class BusinessRoleMenuController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleMenuController.class);
	@Autowired
	private BusinessRoleMenuService businessRoleMenuService;
	
	private final String LIST_ACTION = "redirect:/manage/businessRoleMenu/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleMenu管理页时发生错误：/manage/businessRoleMenu/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRoleMenu/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleMenuQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleMenuService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRoleMenu businessRoleMenu = (BusinessRoleMenu) baseBean.getList().get(i);
				result.append("{")
			    .append("\"romeId\":\"").append(businessRoleMenu.getRomeId()).append("\"").append(",")
			    .append("\"roleId\":\"").append(businessRoleMenu.getRoleId()).append("\"").append(",")
			    .append("\"menuId\":\"").append(businessRoleMenu.getMenuId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRoleMenu.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRoleMenu.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRoleMenu.getEditor()).append("\"").append(",")
			    .append("\"no\":\"").append(businessRoleMenu.getNo()).append("\"")
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
			GSLogger.error("显示businessRoleMenu列表时发生错误：/manage/businessRoleMenu/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleMenuQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleMenu新增页时发生错误：/manage/businessRoleMenu/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRoleMenu/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRoleMenu
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleMenuQuery query) {
		BusinessRoleMenu businessRoleMenu = new BusinessRoleMenu();
		String json = "";
		try{
		    businessRoleMenu.setRoleId(query.getRoleId());
		    businessRoleMenu.setMenuId(query.getMenuId());
		    businessRoleMenu.setCreateTime(query.getCreateTime());
		    businessRoleMenu.setEditTime(query.getEditTime());
		    businessRoleMenu.setEditor(query.getEditor());
		    businessRoleMenu.setNo(query.getNo());
			businessRoleMenuService.save(businessRoleMenu);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRoleMenu信息时发生错误：/manage/businessRoleMenu/save", e);
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
	public ModelAndView modify(BusinessRoleMenuQuery query) {	
		BusinessRoleMenu businessRoleMenu=new BusinessRoleMenu();
		
		try{
			businessRoleMenu = businessRoleMenuService.findById(query.getRomeId());
		}catch(Exception e){
			GSLogger.error("进入businessRoleMenu修改页时发生错误：/manage/businessRoleMenu/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessRoleMenu/modify");
		mav.addObject("businessRoleMenu", businessRoleMenu);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleMenuQuery query) {
		BusinessRoleMenu businessRoleMenu = null;
		String json = "";
		try{
		    businessRoleMenu = businessRoleMenuService.findById(query.getRomeId());
		    businessRoleMenu.setRoleId(query.getRoleId());
		    businessRoleMenu.setMenuId(query.getMenuId());
		    businessRoleMenu.setCreateTime(query.getCreateTime());
		    businessRoleMenu.setEditTime(query.getEditTime());
		    businessRoleMenu.setEditor(query.getEditor());
		    businessRoleMenu.setNo(query.getNo());
			businessRoleMenuService.update(businessRoleMenu);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRoleMenu信息时发生错误：/manage/businessRoleMenu/update", e);
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
						businessRoleMenuService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleMenuService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRoleMenu时发生错误：/manage/businessRoleMenu/delete", e);
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
