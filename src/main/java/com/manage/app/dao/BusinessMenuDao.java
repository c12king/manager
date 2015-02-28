package com.manage.app.dao;



import java.util.List;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.BusinessMenu;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

public interface BusinessMenuDao {
	public List<BusinessMenu> selectMenuId(BusinessMenu menu);
	public int addMenu(BusinessMenu menu);
	public void updateMenu(BusinessMenu menu);
	public void deleteMenu(BusinessMenu menu);
	public List<BusinessMenu> treeData(BusinessMenu menu);
	public int selectMenuCount(BusinessMenu menu);
	/**
	 * 获取菜单复选框的json格式数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessMenu> getComboboxData();
	/**
	 * 查询parnetId为id的菜单
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findFarentById(final Integer id) throws DaoException;
	
	/**
	 * 获取所有菜单
	 */
	public List<BusinessMenu> findAllMenu() throws DaoException;
	
	/**
	 * 获取单个菜单
	 */
	public BusinessMenu findMenuById(Integer menuId) throws DaoException;

}
