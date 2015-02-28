package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageCounty;
import com.utis.Page;


public interface ManageCountyService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageCounty entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageCounty entity) throws GSSException;

	/**
	 * 删除ManageCounty
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageCounty entity) throws GSSException;

	/**
	 * 查询单个ManageCounty
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageCounty findById(ManageCounty entity) throws GSSException;
	/**
	 * 查询ManageCounty列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
	

	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public String treeData(ManageCounty entity);
	
	/**
	 * 获取区域下拉菜单json
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public String getComboboxData(ManageCounty entity);
}
