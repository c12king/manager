package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageOrg;
import com.manage.app.service.ManageOrgService;

@Controller
@RequestMapping("/manage/manageOrg")
public class ManageOrgController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageOrgController.class);
	@Autowired
	private ManageOrgService manageOrgService;
	
	private final String LIST_ACTION = "redirect:/manage/manageOrg/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="org")
	public ModelAndView org() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageOrg管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("manage/manageOrg/org");
		return mav;
	}
	
	
	/**
	 * 进入选择组织机构页
	 * @return
	 */
	@RequestMapping(value="selectOrg")
	public ModelAndView selectOrg(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入selectOrg管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrg/selectOrg");
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
		ManageOrg manageOrg=new ManageOrg();
		String id=request.getParameter("id");
		if(null==id){
			manageOrg.setOrgId(0);
		}else{
			manageOrg.setOrgId(Integer.parseInt(id));
		}
		
		String json=manageOrgService.treeData(manageOrg);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	/**
	 * 获取组织机构、社区、物业、驿站tree数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	@RequestMapping(value="/fullOrgTreeData",produces="text/plain;charset=utf-8")
	public void fullOrgTreeData(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		ManageOrg manageOrg=new ManageOrg();
		String id=request.getParameter("id");
		if(null==id){
			manageOrg.setOrgId(0);
		}else{
			manageOrg.setOrgId(Integer.parseInt(id));
		}
		
		String json=manageOrgService.fullOrgTreeData(manageOrg);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			GSLogger.error("进入manageOrg新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrg/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageOrg
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageOrg entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			json=manageOrgService.save(entity);
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageOrg信息时发生错误", e);
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
		ManageOrg entity=new ManageOrg();
		entity.setOrgId(id);
		
		try{
			entity= manageOrgService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageOrg修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrg/modify");
		mav.addObject("manageOrg", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageOrg entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageOrgService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageOrg信息时发生错误", e);
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
						ManageOrg entity=new ManageOrg();
						entity.setOrgId(Integer.parseInt(ids[i]));
						json=manageOrgService.delete(entity);
					}
				}else{
					ManageOrg entity=new ManageOrg();
					entity.setOrgId(Integer.parseInt(id));
					json=manageOrgService.delete(entity);
				}
			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageOrg时发生错误", e);
			e.printStackTrace();
		}
	}
	/**
	 * 获取菜单复选框数据
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/getComboboxData" )
	public void getComboboxData(HttpServletRequest request,HttpServletResponse response){
		String json="";
		try{
			json=manageOrgService.getComboboxData();
		}catch(Exception e){
			GSLogger.error("进入getComboboxData发生错误", e);
			e.printStackTrace();
		}
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
}
