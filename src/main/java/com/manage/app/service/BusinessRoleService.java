package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.BusinessRole;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessRoleService {

	/**
	 * 查询单个BusinessRole
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRole findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRole
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRole> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRole
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRole> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRole-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRole> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRole
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRole> findByExample(final BusinessRoleQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRole-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRole> findByExample(final BusinessRoleQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRoleQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRoleQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRole数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRole entity) throws ServiceException;
	
	/**
	 * 修改BusinessRole数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRole entity) throws ServiceException;

	/**
	 * 删除BusinessRole
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessRoleQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRole findByField(final Map fieldMap, final Integer id) throws ServiceException;
	
	/**
	 * 删除角色下的所有权限及菜单
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	public boolean deleteMenuFunction(Integer roleId) throws ServiceException;

}
