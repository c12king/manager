package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessUserRole;
import com.manage.app.vo.BusinessUserRoleQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessUserRoleDao {
		
	/**
	 * 查询单个BusinessUserRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserRole findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessUserRole
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserRole> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessUserRole
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserRole> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserRole-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUserRole> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessUserRole
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserRole> findByExample(final BusinessUserRoleQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessUserRole-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUserRole> findByExample(final BusinessUserRoleQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserRole> findAllPage(final BusinessUserRoleQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserRoleQuery query) throws DaoException;
	
	/**
	 * 保存BusinessUserRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserRole entity) throws DaoException;
	
	/**
	 * 修改BusinessUserRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserRole entity) throws DaoException;

	/**
	 * 删除BusinessUserRole
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
	public List<BusinessUserRole> findAllPageByField(final Map fieldMap, final BusinessUserRoleQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUserRole> findListByField(final Map fieldMap, final BusinessUserRoleQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUserRole findByField(final Map fieldMap, final Integer id) throws DaoException;

}
