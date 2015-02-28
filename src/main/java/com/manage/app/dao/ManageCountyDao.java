package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageCounty;
import com.utis.Page;



@Repository
public interface ManageCountyDao {
		
	/**
	 * 保存ManageCounty数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageCounty entity) throws GSSException;

	/**
	 * 修改ManageCounty数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageCounty entity) throws GSSException;
	
	/**
	 * 删除ManageCounty数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageCounty entity) throws GSSException;
	
	/**
	 * 查询单个ManageCounty
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageCounty get(ManageCounty entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageCounty> findAllPage(Page page) throws GSSException;

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
	public List<ManageCounty> treeData(ManageCounty entity);
	
}
