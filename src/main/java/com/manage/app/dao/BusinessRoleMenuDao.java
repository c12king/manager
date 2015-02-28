package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessRoleMenu;
import com.manage.app.vo.BusinessRoleMenuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessRoleMenuDao {
		
	/**
	 * 查询单个BusinessRoleMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleMenu findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRoleMenu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleMenu> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRoleMenu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleMenu> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRoleMenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleMenu> findAllPage(final BusinessRoleMenuQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleMenuQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRoleMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleMenu entity) throws DaoException;
	
	/**
	 * 修改BusinessRoleMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleMenu entity) throws DaoException;

	/**
	 * 删除BusinessRoleMenu
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
	public List<BusinessRoleMenu> findAllPageByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleMenu> findListByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleMenu findByField(final Map fieldMap, final Integer id) throws DaoException;

}
