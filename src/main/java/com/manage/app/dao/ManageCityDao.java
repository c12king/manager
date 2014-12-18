package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageCity;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;



@Repository
public interface ManageCityDao {
		
	/**
	 * 保存ManageCity数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageCity entity) throws GSSException;

	/**
	 * 修改ManageCity数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageCity entity) throws GSSException;
	
	/**
	 * 删除ManageCity数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageCity entity) throws GSSException;
	
	/**
	 * 查询单个ManageCity
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageCity get(ManageCity entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageCity> findAllPage(Page page) throws GSSException;

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
	public List<ManageCity> treeData(ManageCity entity);
}
