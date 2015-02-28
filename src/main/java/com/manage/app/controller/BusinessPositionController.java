package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessPosition;
import com.manage.app.service.BusinessPositionService;





@Controller
@RequestMapping("/business/businessPosition")
public class BusinessPositionController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessPositionController.class);
	@Autowired
	private BusinessPositionService businessPositionService;
	
	private final String LIST_ACTION = "redirect:/business/businessPosition/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessPosition管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPosition/enter");
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
		BusinessPosition businessPosition=new BusinessPosition();
		String id=request.getParameter("id");
		String depId=request.getParameter("depId");
		if(null==id){
			businessPosition.setPositionId(0);;
		}else{
			businessPosition.setPositionId(Integer.parseInt(id));
		}
		if(null==depId){
			businessPosition.setDepId(null);
		}else{
			businessPosition.setDepId(new Integer(depId));
		}
		String json=businessPositionService.treeData(businessPosition);
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
			GSLogger.error("进入business新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessPosition/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessPosition
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessPosition entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			json=businessPositionService.save(entity);
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存businessPosition信息时发生错误", e);
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
		BusinessPosition entity=new BusinessPosition();
		entity.setPositionId(id);
		try{
			entity= businessPositionService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入businessPosition修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessPosition/modify");
		mav.addObject("businessPosition", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessPosition entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			businessPositionService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑businessPosition信息时发生错误", e);
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
						BusinessPosition entity=new BusinessPosition();
						entity.setPositionId(Integer.parseInt(ids[i]));
						json=businessPositionService.delete(entity);
					}
				}else{
					BusinessPosition entity=new BusinessPosition();
					entity.setPositionId(Integer.parseInt(id));
					json=businessPositionService.delete(entity);
				}
			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除businessPosition时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
