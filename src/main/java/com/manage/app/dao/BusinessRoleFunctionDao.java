package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessRoleFunction;
import com.manage.app.vo.BusinessRoleFunctionQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessRoleFunctionDao {
		
	/**
	 * 查询单个BusinessRoleFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleFunction findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRoleFunction
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleFunction> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRoleFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleFunction> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRoleFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleFunction> findAllPage(final BusinessRoleFunctionQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleFunctionQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRoleFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleFunction entity) throws DaoException;
	
	/**
	 * 修改BusinessRoleFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleFunction entity) throws DaoException;

	/**
	 * 删除BusinessRoleFunction
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
	public List<BusinessRoleFunction> findAllPageByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleFunction> findListByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleFunction findByField(final Map fieldMap, final Integer id) throws DaoException;

}
