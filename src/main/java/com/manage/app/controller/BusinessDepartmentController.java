package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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

import com.manage.app.bean.BusinessDepartment;
import com.manage.app.bean.ManageUnit;
import com.manage.app.service.BusinessDepartmentService;
import com.utis.Page;





@Controller
@RequestMapping("/business/businessDepartment")
public class BusinessDepartmentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessDepartmentController.class);
	@Autowired
	private BusinessDepartmentService businessDepartmentService;
	
	private final String LIST_ACTION = "redirect:/business/businessDepartment/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessDepartment管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessDepartment/enter");
		return mav;
	}
	
	
	/**
	 * 获取菜单树形展示json数据
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/treeData",produces="text/plain;charset=utf-8")
	public void treeData(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		BusinessDepartment businessDepartment=new BusinessDepartment();
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		businessDepartment.setOrgId(new Integer(id));
		businessDepartment.setOrgType(type);
		String json=businessDepartmentService.treeData(businessDepartment);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		int cpage=Integer.parseInt(request.getParameter("page"));
		int size=Integer.parseInt(request.getParameter("rows"));
		String like=request.getParameter("name");
		Page page = new Page(cpage,size,like);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = businessDepartmentService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				BusinessDepartment businessDepartment = (BusinessDepartment) pageData.getList().get(i);
				result.append("{")
			    .append("\"depId\":\"").append(businessDepartment.getDepId()).append("\"").append(",")
			    .append("\"depName\":\"").append(businessDepartment.getDepName()).append("\"").append(",")
			    .append("\"depDesc\":\"").append(businessDepartment.getDepDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessDepartment.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessDepartment.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessDepartment.getEditor()).append("\"").append(",")
			    .append("\"orgType\":\"").append(businessDepartment.getOrgType()).append("\"").append(",")
			    .append("\"orgId\":\"").append(businessDepartment.getOrgId()).append("\"").append(",")
			    .append("\"orgName\":\"").append(businessDepartment.getOrgName()).append("\"").append(",")
				.append("}").append(",");
			}
			json = result.toString();
			if(pageData.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("显示businessDepartment列表时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessDepartment新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessDepartment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessDepartment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessDepartment entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			businessDepartmentService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存businessDepartment信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		BusinessDepartment entity=new BusinessDepartment();
		entity.setDepId(id);
		
		try{
			entity= businessDepartmentService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入businessDepartment修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessDepartment/modify");
		mav.addObject("businessDepartment", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessDepartment entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			businessDepartmentService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑businessDepartment信息时发生错误", e);
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
						BusinessDepartment entity=new BusinessDepartment();
						entity.setDepId(Integer.parseInt(ids[i]));
						businessDepartmentService.delete(entity);
					}
				}else{
					BusinessDepartment entity=new BusinessDepartment();
					entity.setDepId(Integer.parseInt(id));
					businessDepartmentService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除BusinessDepartment时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
