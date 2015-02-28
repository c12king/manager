package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.BusinessRoleMenu;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleMenuQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessRoleMenuService {

	/**
	 * 查询单个BusinessRoleMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleMenu findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRoleMenu
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleMenu> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRoleMenu
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRoleMenu> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRoleMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRoleMenu
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRoleMenuQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRoleMenuQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRoleMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRoleMenu entity) throws ServiceException;
	
	/**
	 * 修改BusinessRoleMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRoleMenu entity) throws ServiceException;

	/**
	 * 删除BusinessRoleMenu
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleMenu findByField(final Map fieldMap, final Integer id) throws ServiceException;

}
