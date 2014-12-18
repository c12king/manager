package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageCity;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;


public interface ManageCityService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageCity entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageCity entity) throws GSSException;

	/**
	 * 删除ManageCity
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageCity entity) throws GSSException;

	/**
	 * 查询单个ManageCity
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageCity findById(ManageCity entity) throws GSSException;
	/**
	 * 查询ManageCity列表展示数据
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
	public String treeData(ManageCity entity);
}
