package com.manage.app.service;

import java.util.List;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageFunction;
import com.utis.Page;


public interface ManageFunctionService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageFunction entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageFunction entity) throws GSSException;

	/**
	 * 删除ManageFunction
	 * @param entityId
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageFunction entity) throws GSSException;

	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public ManageFunction findById(ManageFunction entity) throws GSSException;

	public Page findAllPage(Page page) throws GSSException;
	
	/**
	 * 获取菜单下的功能
	 * @param menuId
	 * @return
	 * @throws GSSException
	 */
	public List findFunctionByMenu(Integer menuId) throws GSSException;
}
