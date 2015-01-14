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
import com.manage.app.bean.BusinessShopType;
import com.manage.app.bean.ManageExpress;
import com.manage.app.service.BusinessShopTypeService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessShopTypeQuery;
import com.manage.app.vo.ManageExpressQuery;
import com.utis.TreeNode;


@Controller
@RequestMapping("/manage/businessShopType")
public class BusinessShopTypeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessShopTypeController.class);
	@Autowired
	private BusinessShopTypeService businessShopTypeService;
	
	private final String LIST_ACTION = "redirect:/manage/businessShopType/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopType管理页时发生错误：/manage/businessShopType/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessShopType/enter");
		return mav;
	}
	
	
	/**
	 * 快递公司 json树
	 * @param query
	 * @param response
	 */
	@RequestMapping(value="treeData")
	public void treeData(BusinessShopTypeQuery query, HttpServletResponse response) {
		String json = "";
		try{
			query.setRows(1000);
//			BaseBean baseBean = manageExpressService.findAllPage(query);
			 List<BusinessShopType> lbst = businessShopTypeService.findAll();

			TreeNode root=null;
			root = new TreeNode("0", "0", "商铺类型", "",0);
			for(int i=0;i<lbst.size();i++) {
//				ManageExpress manageExpress = (ManageExpress) lbst.get(i);
				BusinessShopType  businessShopType = lbst.get(i);
				TreeNode node = null;
				node = new TreeNode(businessShopType.getTypeId().toString(), "0",businessShopType.getTypeName(), "", 0);   
				root.add(node);
			}
			json = JSONArray.fromObject(root).toString();
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("显示manageExpress列表时发生错误：/manage/businessShopType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessShopTypeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessShopTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessShopType businessShopType = (BusinessShopType) baseBean.getList().get(i);
				result.append("{")
			    .append("\"typeId\":\"").append(businessShopType.getTypeId()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessShopType.getTypeName()).append("\"")
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
			GSLogger.error("显示businessShopType列表时发生错误：/manage/businessShopType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessShopTypeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopType新增页时发生错误：/manage/businessShopType/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessShopType/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessShopType
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessShopTypeQuery query) {
		BusinessShopType businessShopType = new BusinessShopType();
		String json = "";
		try{
		    businessShopType.setTypeName(query.getTypeName());
			businessShopTypeService.save(businessShopType);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessShopType信息时发生错误：/manage/businessShopType/save", e);
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
	public ModelAndView modify(BusinessShopTypeQuery query) {	
		BusinessShopType businessShopType=new BusinessShopType();
		
		try{
			businessShopType = businessShopTypeService.findById(query.getTypeId());
		}catch(Exception e){
			GSLogger.error("进入businessShopType修改页时发生错误：/manage/businessShopType/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessShopType/modify");
		mav.addObject("businessShopType", businessShopType);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessShopTypeQuery query) {
		BusinessShopType businessShopType = null;
		String json = "";
		try{
		    businessShopType = businessShopTypeService.findById(query.getTypeId());
		    businessShopType.setTypeName(query.getTypeName());
			businessShopTypeService.update(businessShopType);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessShopType信息时发生错误：/manage/businessShopType/update", e);
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
						businessShopTypeService.delete(new Integer(ids[i]));
					}
				}else{
					businessShopTypeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessShopType时发生错误：/manage/businessShopType/delete", e);
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
