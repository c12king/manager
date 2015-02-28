package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessSpecialFunction;
import com.manage.app.vo.BusinessSpecialFunctionQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessSpecialFunctionDao {
		
	/**
	 * 查询单个BusinessSpecialFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSpecialFunction findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessSpecialFunction
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialFunction> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessSpecialFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialFunction> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessSpecialFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialFunction> findByExample(final BusinessSpecialFunctionQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessSpecialFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessSpecialFunction> findByExample(final BusinessSpecialFunctionQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialFunction> findAllPage(final BusinessSpecialFunctionQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessSpecialFunctionQuery query) throws DaoException;
	
	/**
	 * 保存BusinessSpecialFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessSpecialFunction entity) throws DaoException;
	
	/**
	 * 修改BusinessSpecialFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessSpecialFunction entity) throws DaoException;

	/**
	 * 删除BusinessSpecialFunction
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
	public List<BusinessSpecialFunction> findAllPageByField(final Map fieldMap, final BusinessSpecialFunctionQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessSpecialFunction> findListByField(final Map fieldMap, final BusinessSpecialFunctionQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessSpecialFunction findByField(final Map fieldMap, final Integer id) throws DaoException;

}
