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

import com.manage.app.bean.ManageAdmin;
import com.manage.app.service.ManageAdminService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageAdminQuery;
import com.manage.framework.utils.MD5;


@Controller
@RequestMapping("/manage/manageAdmin")
public class ManageAdminController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageAdminController.class);
	@Autowired
	private ManageAdminService manageAdminService;
	
	private final String LIST_ACTION = "redirect:/manage/manageAdmin/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageAdmin管理页时发生错误：/manage/manageAdmin/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageAdmin/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageAdminQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageAdminService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageAdmin manageAdmin = (ManageAdmin) baseBean.getList().get(i);
				result.append("{")
			    .append("\"adminId\":\"").append(manageAdmin.getAdminId()).append("\"").append(",")
			    .append("\"adminName\":\"").append(manageAdmin.getAdminName()).append("\"").append(",")
			    .append("\"adminPassword\":\"").append(manageAdmin.getAdminPassword()).append("\"").append(",")
			    .append("\"adminType\":\"").append(manageAdmin.getAdminType()).append("\"")
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
			GSLogger.error("显示manageAdmin列表时发生错误：/manage/manageAdmin/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageAdminQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageAdmin新增页时发生错误：/manage/manageAdmin/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageAdmin/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageAdmin
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageAdminQuery query) {
		ManageAdmin manageAdmin = new ManageAdmin();
		String json = "";
		try{
		    manageAdmin.setAdminName(query.getAdminName());
		    MD5 md5 = new MD5();  
		    manageAdmin.setAdminPassword(md5.getMD5ofStr(query.getAdminPassword()));
		    manageAdmin.setAdminType(query.getAdminType());
			manageAdminService.save(manageAdmin);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageAdmin信息时发生错误：/manage/manageAdmin/save", e);
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
	public ModelAndView modify(ManageAdminQuery query) {	
		ManageAdmin manageAdmin=new ManageAdmin();
		
		try{
			manageAdmin = manageAdminService.findById(query.getAdminId());
		}catch(Exception e){
			GSLogger.error("进入manageAdmin修改页时发生错误：/manage/manageAdmin/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageAdmin/modify");
		mav.addObject("manageAdmin", manageAdmin);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageAdminQuery query) {
		ManageAdmin manageAdmin = null;
		String json = "";
		try{
		    manageAdmin = manageAdminService.findById(query.getAdminId());
		    manageAdmin.setAdminName(query.getAdminName());
		    if(query.getAdminPassword() != null && !"".equals(query.getAdminPassword())) {
		    	MD5 md5 = new MD5();  
			    manageAdmin.setAdminPassword(md5.getMD5ofStr(query.getAdminPassword()));
		    }		    
		    manageAdmin.setAdminType(query.getAdminType());
			manageAdminService.update(manageAdmin);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageAdmin信息时发生错误：/manage/manageAdmin/update", e);
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
						manageAdminService.delete(new Integer(ids[i]));
					}
				}else{
					manageAdminService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageAdmin时发生错误：/manage/manageAdmin/delete", e);
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
