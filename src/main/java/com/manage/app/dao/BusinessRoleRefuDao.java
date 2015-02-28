package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessRoleRefu;
import com.manage.app.vo.BusinessRoleRefuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessRoleRefuDao {
		
	/**
	 * 查询单个BusinessRoleRefu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleRefu findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRoleRefu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleRefu> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRoleRefu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleRefu> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleRefu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleRefu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRoleRefu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleRefu> findByExample(final BusinessRoleRefuQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleRefu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleRefu> findByExample(final BusinessRoleRefuQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleRefu> findAllPage(final BusinessRoleRefuQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleRefuQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRoleRefu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleRefu entity) throws DaoException;
	
	/**
	 * 修改BusinessRoleRefu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleRefu entity) throws DaoException;

	/**
	 * 删除BusinessRoleRefu
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
	public List<BusinessRoleRefu> findAllPageByField(final Map fieldMap, final BusinessRoleRefuQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleRefu> findListByField(final Map fieldMap, final BusinessRoleRefuQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleRefu findByField(final Map fieldMap, final Integer id) throws DaoException;

}
