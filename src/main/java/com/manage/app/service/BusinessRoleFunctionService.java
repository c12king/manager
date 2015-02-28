package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.BusinessRoleFunction;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleFunctionQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessRoleFunctionService {

	/**
	 * 查询单个BusinessRoleFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleFunction findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRoleFunction
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleFunction> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRoleFunction
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRoleFunction> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRoleFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRoleFunction
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRoleFunctionQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRoleFunctionQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRoleFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRoleFunction entity) throws ServiceException;
	
	/**
	 * 修改BusinessRoleFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRoleFunction entity) throws ServiceException;

	/**
	 * 删除BusinessRoleFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleFunction findByField(final Map fieldMap, final Integer id) throws ServiceException;

}
