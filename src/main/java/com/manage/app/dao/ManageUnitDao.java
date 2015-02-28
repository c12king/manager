package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageUnit;
import com.utis.Page;



@Repository
public interface ManageUnitDao {
		
	/**
	 * 保存ManageUnit数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageUnit entity) throws GSSException;

	/**
	 * 修改ManageUnit数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageUnit entity) throws GSSException;
	
	/**
	 * 删除ManageUnit数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageUnit entity) throws GSSException;
	
	/**
	 * 查询单个ManageUnit
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageUnit get(ManageUnit entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageUnit> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;
	
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageUnit> treeData(ManageUnit entity);
}
