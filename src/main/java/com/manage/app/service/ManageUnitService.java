package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageBuilding;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;


public interface ManageUnitService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageUnit entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageUnit entity) throws GSSException;

	/**
	 * 删除ManageUnit
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageUnit entity) throws GSSException;

	/**
	 * 查询单个ManageUnit
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageUnit findById(ManageUnit entity) throws GSSException;
	/**
	 * 查询ManageUnit列表展示数据
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
	public String treeData(ManageUnit entity);
}
