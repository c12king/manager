package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageProvice;
import com.utis.Page;



@Repository
public interface ManageProviceDao {
		
	/**
	 * 保存ManageProvice数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageProvice entity) throws GSSException;

	/**
	 * 修改ManageProvice数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageProvice entity) throws GSSException;
	
	/**
	 * 删除ManageProvice数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageProvice entity) throws GSSException;
	
	/**
	 * 查询单个ManageProvice
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageProvice get(ManageProvice entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageProvice> findAllPage(Page page) throws GSSException;

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
	public List<ManageProvice> treeData(ManageProvice entity);
}
