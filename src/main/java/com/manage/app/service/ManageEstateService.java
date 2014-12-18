package com.manage.app.service;

import java.util.List;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageEstate;
import com.utis.Page;


public interface ManageEstateService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageEstate entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageEstate entity) throws GSSException;

	/**
	 * 删除ManageEstate
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageEstate entity) throws GSSException;

	/**
	 * 查询单个ManageEstate
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageEstate findById(ManageEstate entity) throws GSSException;
	/**
	 * 查询ManageEstate列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
	
	/**
	 * 查询所有
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageEstate> findAll() throws GSSException;
	
	/**
	 * 按ID获取单个小区对象
	 * @param estateId
	 * @return
	 */
	public ManageEstate selectSingleManageById(Integer estateId) throws GSSException;
	
	/**
	 * 按社区查询小区列表
	 * @param estateId
	 * @return
	 * @throws GSSException
	 */
	public List selectManageEstateByComId(Integer comId) throws GSSException;

	public String treeData() throws GSSException;
	
	
}
