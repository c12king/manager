package com.manage.app.controller;

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

import com.manage.app.bean.AppEstateUser;
import com.manage.app.service.AppEstateUserService;
import com.utis.Page;





@Controller
@RequestMapping("/app/appEstateUser")
public class AppEstateUserController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppEstateUserController.class);
	@Autowired
	private AppEstateUserService appEstateUserService;
	
	private final String LIST_ACTION = "redirect:/app/appEstateUser/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter(HttpServletRequest request) {		
		int id= Integer.parseInt(request.getParameter("id"));
		try{
		}catch(Exception e){
			GSLogger.error("进入appEstateUser管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/appEstateUser/enter");
		mav.addObject("id", id);
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
		String id= request.getParameter("id");
		Page page = new Page(cpage,size,like,id);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = appEstateUserService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				AppEstateUser appEstateUser = (AppEstateUser) pageData.getList().get(i);
				result.append("{")
			    .append("\"estMemId\":\"").append(appEstateUser.getEstMemId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(appEstateUser.getEstateId()).append("\"").append(",")
			    .append("\"userId\":\"").append(appEstateUser.getUserId()).append("\"").append(",")
			    .append("\"buildingId\":\"").append(appEstateUser.getBuildingId()).append("\"").append(",")
			    .append("\"unitId\":\"").append(appEstateUser.getUnitId()).append("\"").append(",")
			    .append("\"houseId\":\"").append(appEstateUser.getHouseId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(appEstateUser.getEstateName()).append("\"").append(",")
			    .append("\"buildingName\":\"").append(appEstateUser.getBuildingName()).append("\"").append(",")
			    .append("\"unitName\":\"").append(appEstateUser.getUnitName()).append("\"").append(",")
			    .append("\"houseNo\":\"").append(appEstateUser.getHouseNo()).append("\"").append(",")
			    .append("\"memberType\":\"").append(appEstateUser.getMemberType()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appEstateUser.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appEstateUser.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appEstateUser.getEditor()).append("\"")
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
			GSLogger.error("显示appEstateUser列表时发生错误", e);
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
			GSLogger.error("进入appEstateUser新增页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appEstateUser/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appEstateUser
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppEstateUser entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setCreateTime(ts);
			entity.setEditTime(ts);
			appEstateUserService.save(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("保存appEstateUser信息时发生错误", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看用户所属小区
	 * @return
	 */
	@RequestMapping(value="estateUserList")
	public ModelAndView estateUserList(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		AppEstateUser entity=new AppEstateUser();
		entity.setUserId(id);
		List<AppEstateUser> list=null;
		try{
			list= appEstateUserService.estateUserList(entity);
		}catch(Exception e){
			GSLogger.error("进入appEstateUser修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/appUser/estateUserList");
		mav.addObject("list", list);
		return mav;
	}
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(HttpServletRequest request) {	
		int id= Integer.parseInt(request.getParameter("id"));
		AppEstateUser entity=new AppEstateUser();
		entity.setEstMemId(id);
		
		try{
			entity= appEstateUserService.findById(entity);
		}catch(Exception e){
			GSLogger.error("进入appEstateUser修改页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appEstateUser/modify");
		mav.addObject("appEstateUser", entity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppEstateUser entity) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			entity.setEditTime(ts);
			appEstateUserService.Update(entity);
			json = "{\"success\":\"true\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch(Exception e) {
			GSLogger.error("编辑appEstateUser信息时发生错误", e);
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
						AppEstateUser entity=new AppEstateUser();
						entity.setEstMemId(Integer.parseInt(ids[i]));
						appEstateUserService.delete(entity);
					}
				}else{
					AppEstateUser entity=new AppEstateUser();
					entity.setEstMemId(Integer.parseInt(id));
					appEstateUserService.delete(entity);
				}
			}
			
			json = "{\"success\":\"success\"}";
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("删除AppEstateUser时发生错误", e);
			e.printStackTrace();
		}
	}
	
}
