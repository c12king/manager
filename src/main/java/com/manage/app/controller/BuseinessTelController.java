package com.manage.app.controller;

import java.io.IOException;

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

import com.manage.app.bean.BuseinessTel;
import com.manage.app.service.BuseinessTelService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BuseinessTelQuery;
import com.utis.Page;


@Controller
@RequestMapping("/manage/buseinessTel")
public class BuseinessTelController {
	private static Logger GSLogger = LoggerFactory.getLogger(BuseinessTelController.class);
	@Autowired
	private BuseinessTelService buseinessTelService;
	
	private final String LIST_ACTION = "redirect:/buseiness/buseinessTel/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入buseinessTel管理页时发生错误：/manage/buseinessTel/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/buseinessTel/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		int cpage=Integer.parseInt(request.getParameter("page"));
		if (StringUtils.isNotBlank(request.getParameter("pageNo")))
			cpage=Integer.parseInt(request.getParameter("pageNo"));
		
		int size=Integer.parseInt(request.getParameter("rows"));
		if (StringUtils.isNotBlank(request.getParameter("pageSize")))  
			size = Integer.parseInt(request.getParameter("pageSize"));
		
		String like=request.getParameter("name");
		String id=request.getParameter("id");
		Page page = new Page(cpage,size,like,id);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page  baseBean = buseinessTelService.findAllPage(page);
			result.append("{\"total\":").append(baseBean.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BuseinessTel buseinessTel = (BuseinessTel) baseBean.getList().get(i);
				result.append("{")
			    .append("\"telId\":\"").append(buseinessTel.getTelId()).append("\"").append(",")
			    .append("\"groupId\":\"").append(buseinessTel.getGroupId()).append("\"").append(",")
			    .append("\"tel\":\"").append(buseinessTel.getTel()).append("\"").append(",")
			    .append("\"telName\":\"").append(buseinessTel.getTelName()).append("\"")
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
			GSLogger.error("显示buseinessTel列表时发生错误：/manage/buseinessTel/list", e);
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 进入电话号新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BuseinessTelQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入buseinessTel 新增页时发生错误：/manage/buseinessTel/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/buseinessTel/addTel");
//		mav.addObject("groupId", query.getGroupId());
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param buseinessTel
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BuseinessTelQuery query) {
		BuseinessTel buseinessTel = new BuseinessTel();
		String json = "";
		try{
		    buseinessTel.setGroupId(query.getGroupId());
		    buseinessTel.setTel(query.getTel());
		    buseinessTel.setTelName(query.getTelName());
			buseinessTelService.save(buseinessTel);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存buseinessTel信息时发生错误：/manage/buseinessTel/save", e);
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
	public ModelAndView modify(BuseinessTelQuery query) {	
		BuseinessTel buseinessTel=new BuseinessTel();
		
		try{
			buseinessTel = buseinessTelService.findById(query.getTelId());
		}catch(Exception e){
			GSLogger.error("进入buseinessTel修改页时发生错误：/manage/buseinessTel/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/buseinessTel/modify");
		mav.addObject("buseinessTel", buseinessTel);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BuseinessTelQuery query) {
		BuseinessTel buseinessTel = null;
		String json = "";
		try{
		    buseinessTel = buseinessTelService.findById(query.getTelId());
		    buseinessTel.setGroupId(query.getGroupId());
		    buseinessTel.setTel(query.getTel());
		    buseinessTel.setTelName(query.getTelName());
			buseinessTelService.update(buseinessTel);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑buseinessTel信息时发生错误：/buseiness/buseinessTel/update", e);
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
						buseinessTelService.delete(new Integer(ids[i]));
					}
				}else{
					buseinessTelService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BuseinessTel时发生错误：/buseiness/buseinessTel/delete", e);
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
