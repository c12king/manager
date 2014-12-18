package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageOrg;
import com.utis.Page;


public interface ManageOrgService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public String save(ManageOrg entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageOrg entity) throws GSSException;

	/**
	 * 删除ManageOrg
	 * @param entityId
	 * @return
	 * @throws GSSException
	 */
	public String delete(ManageOrg entity) throws GSSException;

	/**
	 * 查询单个ManageOrg
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public ManageOrg findById(ManageOrg entity) throws GSSException;
	/**
	 * 获取菜单树形展示json数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String treeData(ManageOrg manageOrg);
	
	/**
	 * 获取组织机构、社区、物业、驿站tree数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String fullOrgTreeData(ManageOrg manageOrg);
	

	public Page findAllPage(Page page) throws GSSException;
	
	/**
	 * 获取组织结构复选框的json格式数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String getComboboxData();
}
