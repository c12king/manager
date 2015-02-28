package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageAdmin;
import com.manage.app.vo.ManageAdminQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface ManageAdminDao {
		
	/**
	 * 查询单个ManageAdmin
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageAdmin findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageAdmin
	 * @return
	 * @throws DaoException
	 */
	public List<ManageAdmin> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageAdmin
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageAdmin> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageAdmin-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageAdmin> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageAdmin
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageAdmin> findByExample(final ManageAdminQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageAdmin-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageAdmin> findByExample(final ManageAdminQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageAdmin> findAllPage(final ManageAdminQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageAdminQuery query) throws DaoException;
	
	/**
	 * 保存ManageAdmin数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageAdmin entity) throws DaoException;
	
	/**
	 * 修改ManageAdmin数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageAdmin entity) throws DaoException;

	/**
	 * 删除ManageAdmin
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
	public List<ManageAdmin> findAllPageByField(final Map fieldMap, final ManageAdminQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageAdmin> findListByField(final Map fieldMap, final ManageAdminQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageAdmin findByField(final Map fieldMap, final Integer id) throws DaoException;

}
