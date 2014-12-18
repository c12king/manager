package com.manage.app.dao;



import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;

import net.sf.json.JSONArray;

import com.manage.app.bean.BusinessMenu;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;

public interface BusinessMenuDao {
	public List<BusinessMenu> selectMenuId(BusinessMenu menu);
	public int addMenu(BusinessMenu menu);
	public void updateMenu(BusinessMenu menu);
	public void deleteMenu(BusinessMenu menu);
	public List<BusinessMenu> treeData(BusinessMenu menu);
	public int selectMenuCount(BusinessMenu menu);
	/**
	 * ��ȡ�˵���ѡ���json��ʽ����
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessMenu> getComboboxData();
	/**
	 * ��ѯparnetIdΪid�Ĳ˵�
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findFarentById(final Integer id) throws DaoException;

}
