package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageEstate;
import com.utis.Page;



@Repository
public interface ManageEstateDao {
		
	/**
	 * 保存ManageEstate数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageEstate entity) throws GSSException;

	/**
	 * 修改ManageEstate数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageEstate entity) throws GSSException;
	
	/**
	 * 删除ManageEstate数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageEstate entity) throws GSSException;
	
	/**
	 * 查询单个ManageEstate
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageEstate get(ManageEstate entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageEstate> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;
	
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
	 * @param comId
	 * @return
	 * @throws GSSException
	 */
	public List selectManageEstateByComId(Integer comId) throws GSSException;

}
