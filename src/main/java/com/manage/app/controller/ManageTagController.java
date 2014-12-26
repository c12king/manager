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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageTag;
import com.manage.app.service.ManageTagService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageTagQuery;


@Controller
@RequestMapping("/manage/manageTag")
public class ManageTagController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageTagController.class);
	@Autowired
	private ManageTagService manageTagService;
	
	private final String LIST_ACTION = "redirect:/manage/manageTag/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageTag管理页时发生错误：/manage/manageTag/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageTag/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageTagQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageTagService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageTag manageTag = (ManageTag) baseBean.getList().get(i);
				result.append("{")
			    .append("\"tagId\":\"").append(manageTag.getTagId()).append("\"").append(",")
			    .append("\"title\":\"").append(manageTag.getTitle()).append("\"").append(",")
			    .append("\"tagDesc\":\"").append(manageTag.getTagDesc()).append("\"").append(",")
			    .append("\"tagPic\":\"").append(manageTag.getTagPic()).append("\"").append(",")
			    .append("\"typeId\":\"").append(manageTag.getTypeId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageTag.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageTag.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageTag.getEditor()).append("\"")
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
			GSLogger.error("显示manageTag列表时发生错误：/manage/manageTag/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageTagQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageTag新增页时发生错误：/manage/manageTag/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageTag/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageTag
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageTagQuery query) {
		ManageTag manageTag = new ManageTag();
		String json = "";
		try{
		    manageTag.setTitle(query.getTitle());
		    manageTag.setTagDesc(query.getTagDesc().replaceAll("\r", "").replaceAll("\n", ""));
		    manageTag.setTagPic(query.getTagPic());
		   // manageTag.setTagType(query.getTagType());
		    manageTag.setTypeId(query.getTypeId());
		    manageTag.setCreateTime(query.getCreateTime());
		    manageTag.setEditTime(query.getEditTime());
		    manageTag.setEditor(query.getEditor());
			manageTagService.save(manageTag);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageTag信息时发生错误：/manage/manageTag/save", e);
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
	public ModelAndView modify(ManageTagQuery query) {	
		ManageTag manageTag=new ManageTag();
		
		try{
			manageTag = manageTagService.findById(query.getTagId());
		}catch(Exception e){
			GSLogger.error("进入manageTag修改页时发生错误：/manage/manageTag/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageTag/modify");
		mav.addObject("manageTag", manageTag);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageTagQuery query) {
		ManageTag manageTag = null;
		String json = "";
		try{
		    manageTag = manageTagService.findById(query.getTagId());
		    manageTag.setTitle(query.getTitle());
		    manageTag.setTagDesc(query.getTagDesc().replaceAll("\r", "").replaceAll("\n", ""));
		    manageTag.setTagPic(query.getTagPic());
		    manageTag.setTypeId(query.getTypeId());
//		    manageTag.setCreateTime(query.getCreateTime());
		    manageTag.setEditTime(new Timestamp(new Date().getTime()));
		    manageTag.setEditor(query.getEditor());
			manageTagService.update(manageTag);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageTag信息时发生错误：/manage/manageTag/update", e);
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
						manageTagService.delete(new Integer(ids[i]));
					}
				}else{
					manageTagService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageTag时发生错误：/manage/manageTag/delete", e);
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
