package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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

import com.manage.app.bean.BusinessMenu;
import com.manage.app.bean.ManageExpress;
import com.manage.app.service.ManageExpressService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageExpressQuery;
import com.utis.TreeNode;


@Controller
@RequestMapping("/manage/manageExpress")
public class ManageExpressController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageExpressController.class);
	@Autowired
	private ManageExpressService manageExpressService;
	
	private final String LIST_ACTION = "redirect:/manage/manageExpress/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageExpress管理页时发生错误：/manage/manageExpress/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpress/enter");
		return mav;
	}
	
	
	/**
	 * 进入小区电话编辑维护页面
	 * 2014年12月18日12:29:45
	 * @return
	 */
	@RequestMapping(value="manageExpCom")
	public ModelAndView manageEstTel() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageExpressCom管理页时发生错误：/manage/manageExpress/manageExpCom", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpress/manageExpCom");
		return mav;
	}
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageExpressQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageExpressService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageExpress manageExpress = (ManageExpress) baseBean.getList().get(i);
				result.append("{")
			    .append("\"expressId\":\"").append(manageExpress.getExpressId()).append("\"").append(",")
			    .append("\"expressComppay\":\"").append(manageExpress.getExpressComppay()).append("\"").append(",")
			    .append("\"expressDesc\":\"").append(manageExpress.getExpressDesc()).append("\"").append(",")
			    .append("\"expressAddress\":\"").append(manageExpress.getExpressAddress()).append("\"").append(",")
			    .append("\"expressIcon\":\"").append(manageExpress.getExpressIcon()).append("\"").append(",")
			    .append("\"expressFee\":\"").append(manageExpress.getExpressFee()).append("\"").append(",")
			    .append("\"expressTel\":\"").append(manageExpress.getExpressTel()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageExpress.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageExpress.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageExpress.getEditor()).append("\"").append(",")
			    .append("\"state\":\"").append(manageExpress.getState()).append("\"")
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
			GSLogger.error("显示manageExpress列表时发生错误：/manage/manageExpress/list", e);
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 快递公司 json树
	 * @param query
	 * @param response
	 */
	@RequestMapping(value="treeData")
	public void treeData(ManageExpressQuery query, HttpServletResponse response) {
		String json = "";
		try{
			query.setRows(1000);
			BaseBean baseBean = manageExpressService.findAllPage(query);
			TreeNode root=null;
			root = new TreeNode("0", "0", "快递公司", "",0);
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageExpress manageExpress = (ManageExpress) baseBean.getList().get(i);
				TreeNode node = null;
				node = new TreeNode(manageExpress.getExpressId().toString(), "0",manageExpress.getExpressComppay(),"",0);   
				root.add(node);
			}
			json = JSONArray.fromObject(root).toString();
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("显示manageExpress列表时发生错误：/manage/manageExpress/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 快递公司 下拉列表
	 * @param query
	 * @param response
	 */
	@RequestMapping(value="/getComboboxData")
	public void getComboboxData(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/plain;charset=utf-8");
		String json = "";
		try{
			List<ManageExpress> expComs = manageExpressService.findAll();
			StringBuilder result = new StringBuilder();
			result.append("[");
			for (ManageExpress exp :expComs )
			{
				result.append("{");
				result.append("\"label\":").append(exp.getExpressId()).append(",");
				result.append("\"value\":").append("\""+exp.getExpressComppay()+"\"");
				result.append("},");
			}
			json = result.toString();
			if(expComs.size() > 0) {
				json = json.substring(0, json.length()-1);
		    }
		    json += "]";
		    response.getWriter().print(json);
		}catch(Exception e){
			GSLogger.error("显示getComboboxData列表时发生错误：/manage/manageExpress/getComboboxData", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageExpressQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageExpress新增页时发生错误：/manage/manageExpress/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpress/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageExpress
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageExpressQuery query) {
		ManageExpress manageExpress = new ManageExpress();
		String json = "";
		try{
		    manageExpress.setExpressComppay(query.getExpressComppay());
		    manageExpress.setExpressDesc(query.getExpressDesc());
		    manageExpress.setExpressAddress(query.getExpressAddress());
		    manageExpress.setExpressIcon(query.getExpressIcon());
		    manageExpress.setExpressFee(query.getExpressFee());
		    manageExpress.setExpressTel(query.getExpressTel());
		    manageExpress.setCreateTime(new Timestamp(new Date().getTime()));
		    manageExpress.setEditTime(new Timestamp(new Date().getTime()));
		    manageExpress.setEditor(query.getEditor());
		    manageExpress.setState(query.getState());
			manageExpressService.save(manageExpress);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageExpress信息时发生错误：/manage/manageExpress/save", e);
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
	public ModelAndView modify(ManageExpressQuery query) {	
		ManageExpress manageExpress=new ManageExpress();
		
		try{
			manageExpress = manageExpressService.findById(query.getExpressId());
		}catch(Exception e){
			GSLogger.error("进入manageExpress修改页时发生错误：/manage/manageExpress/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpress/modify");
		mav.addObject("manageExpress", manageExpress);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageExpressQuery query) {
		ManageExpress manageExpress = null;
		String json = "";
		try{
		    manageExpress = manageExpressService.findById(query.getExpressId());
		    manageExpress.setExpressComppay(query.getExpressComppay());
		    manageExpress.setExpressDesc(query.getExpressDesc());
		    manageExpress.setExpressAddress(query.getExpressAddress());
		    manageExpress.setExpressIcon(query.getExpressIcon());
		    manageExpress.setExpressFee(query.getExpressFee());
		    manageExpress.setExpressTel(query.getExpressTel());
//		    manageExpress.setCreateTime(query.getCreateTime());
		    manageExpress.setEditTime(new Timestamp(new Date().getTime()));
		    manageExpress.setEditor(query.getEditor());
		    manageExpress.setState(query.getState());
			manageExpressService.update(manageExpress);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageExpress信息时发生错误：/manage/manageExpress/update", e);
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
						manageExpressService.delete(new Integer(ids[i]));
					}
				}else{
					manageExpressService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageExpress时发生错误：/manage/manageExpress/delete", e);
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
