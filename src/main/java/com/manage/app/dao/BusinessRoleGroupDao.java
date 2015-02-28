package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessRoleGroup;
import com.manage.app.vo.BusinessRoleGroupQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessRoleGroupDao {
		
	/**
	 * 查询单个BusinessRoleGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleGroup findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRoleGroup
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleGroup> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRoleGroup
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleGroup> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleGroup-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleGroup> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRoleGroup
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleGroup> findByExample(final BusinessRoleGroupQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleGroup-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleGroup> findByExample(final BusinessRoleGroupQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleGroup> findAllPage(final BusinessRoleGroupQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleGroupQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRoleGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleGroup entity) throws DaoException;
	
	/**
	 * 修改BusinessRoleGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleGroup entity) throws DaoException;

	/**
	 * 删除BusinessRoleGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleGroup> findAllPageByField(final Map fieldMap, final BusinessRoleGroupQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleGroup> findListByField(final Map fieldMap, final BusinessRoleGroupQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleGroup findByField(final Map fieldMap, final Integer id) throws DaoException;

}
