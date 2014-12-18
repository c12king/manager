package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageOrg;
import com.manage.app.bean.BusinessPosition;
import com.utis.Page;



@Repository
public interface BusinessPositionDao {
		
	/**
	 * 保存BusinessPosition数据
	 * @param entity
	 * @throws GSSException
	 */
	public String save(BusinessPosition entity) throws GSSException;

	/**
	 * 修改BusinessPosition数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(BusinessPosition entity) throws GSSException;
	
	/**
	 * 删除BusinessPosition数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(BusinessPosition entity) throws GSSException;
	
	/**
	 * 查询单个BusinessPosition
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public BusinessPosition get(BusinessPosition entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessPosition> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(BusinessPosition entity) throws GSSException;
	
	/**
	 * 获取菜单树形展示json数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessPosition> treeData(BusinessPosition entity);
}
