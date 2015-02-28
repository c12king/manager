package com.manage.app.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageHouse;
import com.manage.app.service.ManageHouseService;
import com.utis.Page;





@Controller
@RequestMapping("/manage/manageHouse")
public class ManageHouseController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageHouseController.class);
	@Autowired
	private ManageHouseService manageHouseService;
	
	private final String LIST_ACTION = "redirect:/manage/manageHouse/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageHouse管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageHouse/enter");
		return mav;
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
		String id=request.getParameter("id");
		Page page = new Page(cpage,size,like,id);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = manageHouseService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageHouse manageHouse = (ManageHouse) pageData.getList().get(i);
				result.append("{")
			    .append("\"houseId\":\"").append(manageHouse.getHouseId()).append("\"").append(",")
			    .append("\"unitId\":\"").append(manageHouse.getUnitId()).append("\"").append(",")
			    .append("\"houseNo\":\"").append(manageHouse.getHouseNo()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(manageHouse.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(manageHouse.getEstateLatitude()).append("\"").append(",")
			    .append("\"isBind\":\"").append(manageHouse.getIsBind()).append("\"").append(",")
			    .append("\"memberId\":\"").append(manageHouse.getMemberId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageHouse.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageHouse.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageHouse.getEditor()).append("\"")
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
			GSLogger.error("显示manageHouse列表时发生错误", e);
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
			GSLogger.error("进入manageHouse新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageHouse/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageHouse
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageHouse entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			manageHouseService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存manageHouse信息时发生错误", e);
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
		ManageHouse entity=new ManageHouse();
		entity.setHouseId(id);
		
		try{
			entity= manageHouseService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入manageHouse修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageHouse/modify");
		mav.addObject("manageHouse", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageHouse entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			manageHouseService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑manageHouse信息时发生错误", e);
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
						ManageHouse entity=new ManageHouse();
						entity.setHouseId(Integer.parseInt(ids[i]));
						manageHouseService.delete(entity);
					}
				}else{
					ManageHouse entity=new ManageHouse();
					entity.setHouseId(Integer.parseInt(id));
					manageHouseService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除ManageHouse时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
