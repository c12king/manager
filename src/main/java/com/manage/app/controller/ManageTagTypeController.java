package com.manage.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.ManageTagType;
import com.manage.app.service.ManageTagTypeService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageTagTypeQuery;
import com.utis.TreeNode;


@Controller
@RequestMapping("/manage/manageTagType")
public class ManageTagTypeController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageTagTypeController.class);
	@Autowired
	private ManageTagTypeService manageTagTypeService;
	
	private final String LIST_ACTION = "redirect:/manage/manageTagType/list.do";
	
	/**
	 * 进入标签类型管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageTagType管理页时发生错误：/manage/manageTagType/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageTagType/enter");
		return mav;
	}
	
	@RequestMapping(value="treeData")
	public void treeData(ManageTagTypeQuery query, HttpServletResponse response) {
		String json = "";
		try{
			query.setRows(1000);
			BaseBean baseBean = manageTagTypeService.findAllPage(query);
			TreeNode root=null;
			root = new TreeNode("0", "0", "标签类型", "",0);
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageTagType mtt = (ManageTagType) baseBean.getList().get(i);
				TreeNode node = null;
				node = new TreeNode(mtt.getTypeId().toString(), "0",mtt.getTagTypeName(),"",0);   
				root.add(node);
			}
			json = JSONArray.fromObject(root).toString();
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("显示manageTagType tree 时发生错误：/manage/manageTagType/treeData", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageTagTypeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageTagTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageTagType manageTagType = (ManageTagType) baseBean.getList().get(i);
				result.append("{")
			    .append("\"typeId\":\"").append(manageTagType.getTypeId()).append("\"").append(",")
			    .append("\"tagTypeName\":\"").append(manageTagType.getTagTypeName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageTagType.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageTagType.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageTagType.getEditor()).append("\"")
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
			GSLogger.error("显示manageTagType列表时发生错误：/manage/manageTagType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageTagTypeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageTagType新增页时发生错误：/manage/manageTagType/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageTagType/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageTagType
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageTagTypeQuery query) {
		ManageTagType manageTagType = new ManageTagType();
		String json = "";
		try{
		    manageTagType.setTagTypeName(query.getTagTypeName());
		    manageTagType.setCreateTime(new Timestamp(new Date().getTime()));
		    manageTagType.setEditTime(new Timestamp(new Date().getTime()));
		    manageTagType.setEditor(query.getEditor());
			manageTagTypeService.save(manageTagType);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageTagType信息时发生错误：/manage/manageTagType/save", e);
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
	public ModelAndView modify(ManageTagTypeQuery query) {	
		ManageTagType manageTagType=new ManageTagType();
		
		try{
			manageTagType = manageTagTypeService.findById(query.getTypeId());
		}catch(Exception e){
			GSLogger.error("进入manageTagType修改页时发生错误：/manage/manageTagType/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageTagType/modify");
		mav.addObject("manageTagType", manageTagType);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageTagTypeQuery query) {
		ManageTagType manageTagType = null;
		String json = "";
		try{
		    manageTagType = manageTagTypeService.findById(query.getTypeId());
		    manageTagType.setTagTypeName(query.getTagTypeName());
//		    manageTagType.setCreateTime(query.getCreateTime());
		    manageTagType.setEditTime(new Timestamp(new Date().getTime()));
		    manageTagType.setEditor(query.getEditor());
			manageTagTypeService.update(manageTagType);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageTagType信息时发生错误：/manage/manageTagType/update", e);
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
						manageTagTypeService.delete(new Integer(ids[i]));
					}
				}else{
					manageTagTypeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageTagType时发生错误：/manage/manageTagType/delete", e);
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
