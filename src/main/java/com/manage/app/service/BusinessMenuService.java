package com.manage.app.service;





import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;

import net.sf.json.JSONArray;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessMenu;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;

public interface BusinessMenuService {
	public List<BusinessMenu> selectMenuId(BusinessMenu menu);
	public int addMenu(BusinessMenu menu);
	public void updateMenu(BusinessMenu menu);
	public String deleteMenu(BusinessMenu menu);
	public String treeData(BusinessMenu menu);
	/**
	 * ��ȡ�˵���ѡ���json��ʽ����
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String getComboboxData();
	
	/**
	 * ��ѯparnetIdΪid�Ĳ˵�
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findFarentById(final Integer id) throws ServiceException;

}
