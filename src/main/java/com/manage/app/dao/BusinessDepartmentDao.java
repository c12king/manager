package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessDepartment;
import com.manage.app.bean.ManageCity;
import com.utis.Page;



@Repository
public interface BusinessDepartmentDao {
		
	/**
	 * 保存BusinessDepartment数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(BusinessDepartment entity) throws GSSException;

	/**
	 * 修改BusinessDepartment数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(BusinessDepartment entity) throws GSSException;
	
	/**
	 * 删除BusinessDepartment数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(BusinessDepartment entity) throws GSSException;
	
	/**
	 * 查询单个BusinessDepartment
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public BusinessDepartment get(BusinessDepartment entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessDepartment> findAllPage(Page page) throws GSSException;

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
	public List<BusinessDepartment> treeData(BusinessDepartment entity);
}
