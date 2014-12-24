package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.manage.app.vo.BaseBean;


import com.manage.app.bean.ManageOrgExpress;
import com.manage.app.service.ManageOrgExpressService;
import com.manage.app.vo.ManageOrgExpressQuery;


@Controller
@RequestMapping("/manage/manageOrgExpress")
public class ManageOrgExpressController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageOrgExpressController.class);
	@Autowired
	private ManageOrgExpressService manageOrgExpressService;
	
	private final String LIST_ACTION = "redirect:/manage/manageOrgExpress/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageOrgExpress管理页时发生错误：/manage/manageOrgExpress/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrgExpress/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageOrgExpressQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageOrgExpressService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageOrgExpress manageOrgExpress = (ManageOrgExpress) baseBean.getList().get(i);
				result.append("{")
			    .append("\"orgExpId\":\"").append(manageOrgExpress.getOrgExpId()).append("\"").append(",")
			    .append("\"expressId\":\"").append(manageOrgExpress.getExpressId()).append("\"").append(",")
			    .append("\"stationId\":\"").append(manageOrgExpress.getStationId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageOrgExpress.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageOrgExpress.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageOrgExpress.getEditor()).append("\"").append(",")
			    .append("\"expState\":\"").append(manageOrgExpress.getExpState()).append("\"")
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
			GSLogger.error("显示manageOrgExpress列表时发生错误：/manage/manageOrgExpress/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageOrgExpressQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageOrgExpress新增页时发生错误：/manage/manageOrgExpress/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrgExpress/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageOrgExpress
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageOrgExpressQuery query) {
		ManageOrgExpress manageOrgExpress = new ManageOrgExpress();
		String json = "";
		try{
		    manageOrgExpress.setExpressId(query.getExpressId());
		    manageOrgExpress.setStationId(query.getStationId());
		    manageOrgExpress.setCreateTime(query.getCreateTime());
		    manageOrgExpress.setEditTime(query.getEditTime());
		    manageOrgExpress.setEditor(query.getEditor());
		    manageOrgExpress.setExpState(query.getExpState());
			manageOrgExpressService.save(manageOrgExpress);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageOrgExpress信息时发生错误：/manage/manageOrgExpress/save", e);
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
	public ModelAndView modify(ManageOrgExpressQuery query) {	
		ManageOrgExpress manageOrgExpress=new ManageOrgExpress();
		
		try{
			manageOrgExpress = manageOrgExpressService.findById(query.getOrgExpId());
		}catch(Exception e){
			GSLogger.error("进入manageOrgExpress修改页时发生错误：/manage/manageOrgExpress/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrgExpress/modify");
		mav.addObject("manageOrgExpress", manageOrgExpress);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageOrgExpressQuery query) {
		ManageOrgExpress manageOrgExpress = null;
		String json = "";
		try{
		    manageOrgExpress = manageOrgExpressService.findById(query.getOrgExpId());
		    manageOrgExpress.setExpressId(query.getExpressId());
		    manageOrgExpress.setStationId(query.getStationId());
		    manageOrgExpress.setCreateTime(query.getCreateTime());
		    manageOrgExpress.setEditTime(query.getEditTime());
		    manageOrgExpress.setEditor(query.getEditor());
		    manageOrgExpress.setExpState(query.getExpState());
			manageOrgExpressService.update(manageOrgExpress);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageOrgExpress信息时发生错误：/manage/manageOrgExpress/update", e);
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
						manageOrgExpressService.delete(new Integer(ids[i]));
					}
				}else{
					manageOrgExpressService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageOrgExpress时发生错误：/manage/manageOrgExpress/delete", e);
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
