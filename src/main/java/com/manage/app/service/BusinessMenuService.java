package com.manage.app.service;





import java.util.List;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.BusinessMenu;
import com.manage.framework.exception.ServiceException;

public interface BusinessMenuService {
	public List<BusinessMenu> selectMenuId(BusinessMenu menu);
	public int addMenu(BusinessMenu menu);
	public void updateMenu(BusinessMenu menu);
	public String deleteMenu(BusinessMenu menu);
	public String treeData(BusinessMenu menu);
	/**
	 * 获取菜单复选框的json格式数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String getComboboxData();
	
	/**
	 * 查询parnetId为id的菜单
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findFarentById(final Integer id) throws ServiceException;
	
	/**
	 * 获取所有菜单
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findAllMenu() throws ServiceException;
	
	/**
	 * 获取单个菜单
	 */
	public BusinessMenu findMenuById(Integer menuId) throws ServiceException;

}
