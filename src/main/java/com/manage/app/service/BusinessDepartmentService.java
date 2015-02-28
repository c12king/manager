package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.BusinessDepartment;
import com.utis.Page;


public interface BusinessDepartmentService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(BusinessDepartment entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(BusinessDepartment entity) throws GSSException;

	/**
	 * 删除BusinessDepartment
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(BusinessDepartment entity) throws GSSException;

	/**
	 * 查询单个BusinessDepartment
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public BusinessDepartment findById(BusinessDepartment entity) throws GSSException;
	/**
	 * 查询BusinessDepartment列表展示数据
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
	public String treeData(BusinessDepartment entity);
}
