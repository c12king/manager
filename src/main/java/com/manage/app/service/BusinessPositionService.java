package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageOrg;
import com.manage.app.bean.BusinessPosition;
import com.utis.Page;


public interface BusinessPositionService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public String save(BusinessPosition entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(BusinessPosition entity) throws GSSException;

	/**
	 * 删除ManagePosition
	 * @param entityId
	 * @return
	 * @throws GSSException
	 */
	public String delete(BusinessPosition entity) throws GSSException;

	/**
	 * 查询单个ManagePosition
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public BusinessPosition findById(BusinessPosition entity) throws GSSException;
	/**
	 * 查询ManagePosition列表展示数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
	
	/**
	 * 获取菜单树形展示json数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String treeData(BusinessPosition managePosition);
}
