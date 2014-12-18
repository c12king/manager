package com.manage.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.bean.BusinessMenu;
import com.manage.app.bean.BusinessStation;
import com.manage.app.bean.ManageModulemenu;
import com.manage.app.service.BusinessMenuService;
import com.manage.app.service.ManageModulemenuService;
import com.manage.app.vo.BusinessStationQuery;
import com.utis.Page;
/**
 * �˵�����
 * @author Administrator
 *
 */

@Controller
@RequestMapping(value = "/manage/businessMenu")
public class BusinessMenuController {
	@Autowired
	private BusinessMenuService businessMenuService;
	
	@Autowired
	private ManageModulemenuService manageModulemenuService;
	
	/**
	 * �����û��б�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/menuTree" )
	public ModelAndView menuTree(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("/manage/businessMenu/menu");
		
		return mav;
	}
	/**
	 * ��ȡ�˵�����չʾjson����
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/treeData",produces="text/plain;charset=utf-8")
	public void treeData(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		BusinessMenu menu=new BusinessMenu();
		String id=request.getParameter("id");
		if(null==id){
			menu.setMenuId(0);
		}else{
			menu.setMenuId(Integer.parseInt(id));
		}
		
		String json=businessMenuService.treeData(menu);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	/**
	 * ����id��ѯ�˵�����
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/selectMenuId" )
	public void selectMenuId(HttpServletRequest request,HttpServletResponse response,BusinessMenu menu){
		ModelAndView mav=new ModelAndView("update");
		List<BusinessMenu> list=businessMenuService.selectMenuId(menu);
		String json=JSONObject.fromObject(list.get(0)).toString();
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		
	}
	/**
	 * �����˵�
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/addMenu" )
	public void addMenu(HttpServletRequest request,HttpServletResponse response,BusinessMenu menu){
		int id=businessMenuService.addMenu(menu);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	/**
	 * �޸Ĳ˵�
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/updateMenu" )
	public void updateMenu(HttpServletRequest request,HttpServletResponse response,BusinessMenu menu){
		ModelAndView mav=new ModelAndView("redirect:/log/select.do");
		businessMenuService.updateMenu(menu);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		
	}
	/**
	 * ɾ���˵�
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/deleteMenu" )
	public void deleteMenu(HttpServletRequest request,HttpServletResponse response,BusinessMenu menu){
		ModelAndView mav=new ModelAndView("redirect:/log/select.do");
		String json=businessMenuService.deleteMenu(menu);
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	/**
	 * ��ȡ�˵���ѡ������
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	@RequestMapping("/getComboboxData" )
	public void getComboboxData(HttpServletRequest request,HttpServletResponse response){
		String json=businessMenuService.getComboboxData();
		response.setContentType("text/plain;charset=utf-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
	/**
	 * �������˵�ҳ
	 * @return
	 */
	@RequestMapping(value="assignMenu")
	public ModelAndView assignMenu(HttpServletRequest request) {	
		BusinessStation businessStation=new BusinessStation();
		String id=request.getParameter("id");
		List<BusinessMenu> list=null;
		List<ManageModulemenu> selectedList=null;
		try{
			selectedList=manageModulemenuService.findById(new Integer(id));
			list = businessMenuService.findFarentById(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/businessMenu/assignMenu");
		mav.addObject("list", list);
		mav.addObject("selectedList", selectedList);
		mav.addObject("id", id);
		return mav;
	}

}


