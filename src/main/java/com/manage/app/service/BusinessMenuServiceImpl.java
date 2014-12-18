package com.manage.app.service;




import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessMenu;
import com.manage.app.dao.BusinessMenuDao;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;
import com.utis.TreeNode;
@Service("MenuService")
@Transactional
public class BusinessMenuServiceImpl implements BusinessMenuService{
	@Autowired
	private BusinessMenuDao businessMenuDao;
	
	public int addMenu(BusinessMenu menu) {
		// TODO Auto-generated method stub
		return businessMenuDao.addMenu(menu);
	}

	public String deleteMenu(BusinessMenu menu) {
		// TODO Auto-generated method stub
		if(businessMenuDao.selectMenuCount(menu)>0){
			return "0";
		}else{
			businessMenuDao.deleteMenu(menu);
			return "1";
		}
		
	}

	public List<BusinessMenu> selectMenuId(BusinessMenu menu) {
		// TODO Auto-generated method stub
		return businessMenuDao.selectMenuId(menu);
	}

	public void updateMenu(BusinessMenu menu) {
		businessMenuDao.updateMenu(menu);
	}

	public String treeData(BusinessMenu menu) {
		List<BusinessMenu> list=businessMenuDao.treeData(menu);
		TreeNode root=null;
		if(list.size()==0){
			 root = new TreeNode(menu.getMenuId().toString(), "0", "菜单", "",0);

		}else{
			 root = new TreeNode(menu.getMenuId().toString(), "0", "菜单", "",0);

		}
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getMenuId().toString(), list.get(i).getParentId().toString(),list.get(i).getName(),list.get(i).getUrl(),list.get(i).getLeaf());   
			root.add(node);
		}
		if(menu.getMenuId()==0){
			JSONObject obj = JSONObject.fromObject(root);//有根
			return "["+obj.toString()+"]";
		}else{
			JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
			return obj.toString();
		}
		
	}

	public String getComboboxData() {
		// TODO Auto-generated method stub
		String json="";
		List<BusinessMenu> list=businessMenuDao.getComboboxData();
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (BusinessMenu menu : list) {
			result.append("{");
			result.append("\"label\":").append(menu.getMenuId()).append(",");
			result.append("\"value\":").append("\""+menu.getName()+"\"");
			result.append("},");
		}
		json = result.toString();
		if(list.size() > 0) {
			json = json.substring(0, json.length()-1);
		}
		json += "]";
		return json;
	}
	
	/**
	 * 查询parnetId为id的菜单
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessMenu> findFarentById(final Integer id) throws ServiceException {
		List<BusinessMenu> list = null;
		try {
			list= businessMenuDao.findFarentById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
