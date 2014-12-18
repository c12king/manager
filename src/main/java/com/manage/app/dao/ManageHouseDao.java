package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageHouse;
import com.utis.Page;



@Repository
public interface ManageHouseDao {
		
	/**
	 * 保存ManageHouse数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageHouse entity) throws GSSException;

	/**
	 * 修改ManageHouse数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageHouse entity) throws GSSException;
	
	/**
	 * 删除ManageHouse数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageHouse entity) throws GSSException;
	
	/**
	 * 查询单个ManageHouse
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageHouse get(ManageHouse entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageHouse> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;

}
