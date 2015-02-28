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

import com.manage.app.bean.BusinessSpecialMenu;
import com.manage.app.service.BusinessSpecialMenuService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessSpecialMenuQuery;


@Controller
@RequestMapping("/business/businessSpecialMenu")
public class BusinessSpecialMenuController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessSpecialMenuController.class);
	@Autowired
	private BusinessSpecialMenuService businessSpecialMenuService;
	
	private final String LIST_ACTION = "redirect:/business/businessSpecialMenu/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessSpecialMenu管理页时发生错误：/business/businessSpecialMenu/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSpecialMenu/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessSpecialMenuQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessSpecialMenuService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessSpecialMenu businessSpecialMenu = (BusinessSpecialMenu) baseBean.getList().get(i);
				result.append("{")
			    .append("\"spmeId\":\"").append(businessSpecialMenu.getSpmeId()).append("\"").append(",")
			    .append("\"refuId\":\"").append(businessSpecialMenu.getRefuId()).append("\"").append(",")
			    .append("\"menuId\":\"").append(businessSpecialMenu.getMenuId()).append("\"").append(",")
			    .append("\"no\":\"").append(businessSpecialMenu.getNo()).append("\"")
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
			GSLogger.error("显示businessSpecialMenu列表时发生错误：/business/businessSpecialMenu/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessSpecialMenuQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessSpecialMenu新增页时发生错误：/business/businessSpecialMenu/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSpecialMenu/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessSpecialMenu
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessSpecialMenuQuery query) {
		BusinessSpecialMenu businessSpecialMenu = new BusinessSpecialMenu();
		String json = "";
		try{
		    businessSpecialMenu.setRefuId(query.getRefuId());
		    businessSpecialMenu.setMenuId(query.getMenuId());
		    businessSpecialMenu.setNo(query.getNo());
			businessSpecialMenuService.save(businessSpecialMenu);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessSpecialMenu信息时发生错误：/business/businessSpecialMenu/save", e);
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
	public ModelAndView modify(BusinessSpecialMenuQuery query) {	
		BusinessSpecialMenu businessSpecialMenu=new BusinessSpecialMenu();
		
		try{
			businessSpecialMenu = businessSpecialMenuService.findById(query.getSpmeId());
		}catch(Exception e){
			GSLogger.error("进入businessSpecialMenu修改页时发生错误：/business/businessSpecialMenu/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSpecialMenu/modify");
		mav.addObject("businessSpecialMenu", businessSpecialMenu);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessSpecialMenuQuery query) {
		BusinessSpecialMenu businessSpecialMenu = null;
		String json = "";
		try{
		    businessSpecialMenu = businessSpecialMenuService.findById(query.getSpmeId());
		    businessSpecialMenu.setRefuId(query.getRefuId());
		    businessSpecialMenu.setMenuId(query.getMenuId());
		    businessSpecialMenu.setNo(query.getNo());
			businessSpecialMenuService.update(businessSpecialMenu);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessSpecialMenu信息时发生错误：/business/businessSpecialMenu/update", e);
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
						businessSpecialMenuService.delete(new Integer(ids[i]));
					}
				}else{
					businessSpecialMenuService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessSpecialMenu时发生错误：/business/businessSpecialMenu/delete", e);
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
