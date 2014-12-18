package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageBuilding;
import com.manage.app.bean.BusinessPosition;
import com.utis.Page;



@Repository
public interface ManageBuildingDao {
		
	/**
	 * 保存ManageBuilding数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageBuilding entity) throws GSSException;

	/**
	 * 修改ManageBuilding数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageBuilding entity) throws GSSException;
	
	/**
	 * 删除ManageBuilding数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageBuilding entity) throws GSSException;
	
	/**
	 * 查询单个ManageBuilding
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public ManageBuilding get(ManageBuilding entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageBuilding> findAllPage(Page page) throws GSSException;

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
	public List<ManageBuilding> treeData(ManageBuilding entity);
	
	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws GSSException;

}
