package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageExpressFee;
import com.manage.app.service.ManageExpressFeeService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageExpressFeeQuery;


@Controller
@RequestMapping("/manage/manageExpressFee")
public class ManageExpressFeeController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageExpressFeeController.class);
	@Autowired
	private ManageExpressFeeService manageExpressFeeService;
	
	private final String LIST_ACTION = "redirect:/manage/manageExpressFee/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageExpressFee管理页时发生错误：/manage/manageExpressFee/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpressFee/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(HttpServletRequest request, ManageExpressFeeQuery query, HttpServletResponse response) {
		int cpage = 1;
		if (StringUtils.isNotBlank(request.getParameter("page")))
		    cpage=Integer.parseInt(request.getParameter("page"));
		if (StringUtils.isNotBlank(request.getParameter("pageNo")))
			cpage=Integer.parseInt(request.getParameter("pageNo"));
		int size = 10;
		if (StringUtils.isNotBlank(request.getParameter("rows")))
			size=Integer.parseInt(request.getParameter("rows"));
		if (StringUtils.isNotBlank(request.getParameter("pageSize")))  
			size = Integer.parseInt(request.getParameter("pageSize"));
		query.setPage(cpage);
		query.setRows(size);
		
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageExpressFeeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageExpressFee manageExpressFee = (ManageExpressFee) baseBean.getList().get(i);
				result.append("{")
			    .append("\"feeId\":\"").append(manageExpressFee.getFeeId()).append("\"").append(",")
			    .append("\"expressId\":\"").append(manageExpressFee.getExpressId()).append("\"").append(",")
			    .append("\"title\":\"").append(manageExpressFee.getTitle()).append("\"").append(",")
			    .append("\"content\":\"").append(manageExpressFee.getContent()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageExpressFee.getCreateTime()).append("\"")
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
			GSLogger.error("显示manageExpressFee列表时发生错误：/manage/manageExpressFee/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageExpressFeeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageExpressFee新增页时发生错误：/manage/manageExpressFee/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpressFee/add"); 
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageExpressFee
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageExpressFeeQuery query) {
		ManageExpressFee manageExpressFee = new ManageExpressFee();
		String json = "";
		try{
		    manageExpressFee.setExpressId(query.getExpressId());
		    manageExpressFee.setTitle(query.getTitle().replaceAll("\n", "").replace("\r", ""));
		    manageExpressFee.setContent(query.getContent().replaceAll("\n", "").replace("\r", "")); //去掉回车  
		    System.out.println(query.getContent().replaceAll("\n", "").replace("\r", ""));
		    manageExpressFee.setCreateTime(new Timestamp(new Date().getTime()));
			manageExpressFeeService.save(manageExpressFee);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageExpressFee信息时发生错误：/manage/manageExpressFee/save", e);
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
	public ModelAndView modify(ManageExpressFeeQuery query) {	
		ManageExpressFee manageExpressFee=new ManageExpressFee();
		
		try{
			manageExpressFee = manageExpressFeeService.findById(query.getFeeId());
		}catch(Exception e){
			GSLogger.error("进入manageExpressFee修改页时发生错误：/manage/manageExpressFee/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpressFee/modify");
		mav.addObject("manageExpressFee", manageExpressFee);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageExpressFeeQuery query) {
		ManageExpressFee manageExpressFee = null;
		String json = "";
		try{
		    manageExpressFee = manageExpressFeeService.findById(query.getFeeId());
		    manageExpressFee.setExpressId(query.getExpressId());
		    manageExpressFee.setTitle(query.getTitle().replaceAll("\n", "").replace("\r", ""));
		    manageExpressFee.setContent(query.getContent().replaceAll("\n", "").replace("\r", ""));
		    manageExpressFee.setCreateTime(query.getCreateTime());
			manageExpressFeeService.update(manageExpressFee);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageExpressFee信息时发生错误：/manage/manageExpressFee/update", e);
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
						manageExpressFeeService.delete(new Integer(ids[i]));
					}
				}else{
					manageExpressFeeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageExpressFee时发生错误：/manage/manageExpressFee/delete", e);
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
