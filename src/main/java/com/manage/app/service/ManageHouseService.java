package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageHouse;
import com.utis.Page;


public interface ManageHouseService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageHouse entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageHouse entity) throws GSSException;

	/**
	 * 删除ManageHouse
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageHouse entity) throws GSSException;

	/**
	 * 查询单个ManageHouse
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageHouse findById(ManageHouse entity) throws GSSException;
	/**
	 * 查询ManageHouse列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
}
