package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageProvice;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;


public interface ManageProviceService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageProvice entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageProvice entity) throws GSSException;

	/**
	 * 删除ManageProvice
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageProvice entity) throws GSSException;

	/**
	 * 查询单个ManageProvice
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageProvice findById(ManageProvice entity) throws GSSException;
	/**
	 * 查询ManageProvice列表展示数据
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
	public String treeData(ManageProvice entity);
}
