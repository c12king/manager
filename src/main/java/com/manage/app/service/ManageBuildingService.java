package com.manage.app.service;

import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.ManageBuilding;
import com.manage.app.bean.BusinessPosition;
import com.utis.Page;


public interface ManageBuildingService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageBuilding entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageBuilding entity) throws GSSException;

	/**
	 * 删除ManageBuilding
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(ManageBuilding entity) throws GSSException;

	/**
	 * 查询单个ManageBuilding
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageBuilding findById(ManageBuilding entity) throws GSSException;
	/**
	 * 查询ManageBuilding列表展示数据
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
	public String treeData(ManageBuilding entity);
	
	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws GSSException;
}
