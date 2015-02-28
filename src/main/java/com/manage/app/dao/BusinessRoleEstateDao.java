package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessRoleEstate;
import com.manage.app.vo.BusinessRoleEstateQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessRoleEstateDao {
		
	/**
	 * 查询单个BusinessRoleEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleEstate findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRoleEstate
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleEstate> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRoleEstate
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleEstate> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleEstate-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleEstate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRoleEstate
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleEstate> findByExample(final BusinessRoleEstateQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleEstate-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleEstate> findByExample(final BusinessRoleEstateQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleEstate> findAllPage(final BusinessRoleEstateQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleEstateQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRoleEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleEstate entity) throws DaoException;
	
	/**
	 * 修改BusinessRoleEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleEstate entity) throws DaoException;

	/**
	 * 删除BusinessRoleEstate
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
	public List<BusinessRoleEstate> findAllPageByField(final Map fieldMap, final BusinessRoleEstateQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleEstate> findListByField(final Map fieldMap, final BusinessRoleEstateQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleEstate findByField(final Map fieldMap, final Integer id) throws DaoException;

}
