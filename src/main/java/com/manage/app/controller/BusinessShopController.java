package com.manage.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessShop;
import com.manage.app.bean.ManageExpress;
import com.manage.app.service.BusinessShopService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessShopQuery;
import com.manage.app.vo.ManageExpressQuery;
import com.utis.TreeNode;


@Controller
@RequestMapping("/manage/businessShop")
public class BusinessShopController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessShopController.class);
	@Autowired
	private BusinessShopService businessShopService;
	
	private final String LIST_ACTION = "redirect:/manage/businessShop/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShop管理页时发生错误：/manage/businessShop/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessShop/enter");
		return mav;
	}
	
	

	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessShopQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessShopService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessShop businessShop = (BusinessShop) baseBean.getList().get(i);
				result.append("{")
			    .append("\"shopId\":\"").append(businessShop.getShopId()).append("\"").append(",")
			    .append("\"shopCode\":\"").append(businessShop.getShopCode()).append("\"").append(",")
			    .append("\"shopKey\":\"").append(businessShop.getShopKey()).append("\"").append(",")
			    .append("\"shopName\":\"").append(businessShop.getShopName()).append("\"").append(",")
			    .append("\"shopImg\":\"").append(businessShop.getShopImg()).append("\"").append(",")
			    .append("\"shopDesc\":\"").append(businessShop.getShopDesc()).append("\"").append(",")
			    .append("\"shopAddr\":\"").append(businessShop.getShopAddr()).append("\"").append(",")
			    .append("\"shopUrl\":\"").append(businessShop.getShopUrl()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessShop.getTypeId()).append("\"").append(",")
			    .append("\"creatTime\":\"").append(businessShop.getCreatTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessShop.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessShop.getEditor()).append("\"")
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
			GSLogger.error("显示businessShop列表时发生错误：/manage/businessShop/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessShopQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShop新增页时发生错误：/manage/businessShop/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessShop/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessShop
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessShopQuery query) {
		BusinessShop businessShop = new BusinessShop();
		String json = "";
		try{
		    businessShop.setShopCode(query.getShopCode());
		    businessShop.setShopKey(query.getShopKey());
		    businessShop.setShopName(query.getShopName());
		    businessShop.setShopImg(query.getShopImg());
		    businessShop.setShopDesc(query.getShopDesc());
		    businessShop.setShopAddr(query.getShopAddr());
		    businessShop.setShopUrl(query.getShopUrl());
		    businessShop.setTypeId(query.getTypeId());
		    businessShop.setCreatTime(query.getCreatTime());
		    businessShop.setEditTime(query.getEditTime());
		    businessShop.setEditor(query.getEditor());
			businessShopService.save(businessShop);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessShop信息时发生错误：/manage/businessShop/save", e);
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
	public ModelAndView modify(BusinessShopQuery query) {	
		BusinessShop businessShop=new BusinessShop();
		
		try{
			businessShop = businessShopService.findById(query.getShopId());
		}catch(Exception e){
			GSLogger.error("进入businessShop修改页时发生错误：/manage/businessShop/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessShop/modify");
		mav.addObject("businessShop", businessShop);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessShopQuery query) {
		BusinessShop businessShop = null;
		String json = "";
		try{
		    businessShop = businessShopService.findById(query.getShopId());
		    businessShop.setShopCode(query.getShopCode());
		    businessShop.setShopKey(query.getShopKey());
		    businessShop.setShopName(query.getShopName());
		    businessShop.setShopImg(query.getShopImg());
		    businessShop.setShopDesc(query.getShopDesc());
		    businessShop.setShopAddr(query.getShopAddr());
		    businessShop.setShopUrl(query.getShopUrl());
		    businessShop.setTypeId(query.getTypeId());
		    businessShop.setCreatTime(query.getCreatTime());
		    businessShop.setEditTime(query.getEditTime());
		    businessShop.setEditor(query.getEditor());
			businessShopService.update(businessShop);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessShop信息时发生错误：/manage/businessShop/update", e);
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
						businessShopService.delete(new Integer(ids[i]));
					}
				}else{
					businessShopService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessShop时发生错误：/manage/businessShop/delete", e);
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
