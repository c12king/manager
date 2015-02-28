package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessRoleCommunity;
import com.manage.app.vo.BusinessRoleCommunityQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessRoleCommunityDao {
		
	/**
	 * 查询单个BusinessRoleCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleCommunity findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleCommunity> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleCommunity> findAllPage(final BusinessRoleCommunityQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleCommunityQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRoleCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleCommunity entity) throws DaoException;
	
	/**
	 * 修改BusinessRoleCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleCommunity entity) throws DaoException;

	/**
	 * 删除BusinessRoleCommunity
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
	public List<BusinessRoleCommunity> findAllPageByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleCommunity> findListByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleCommunity findByField(final Map fieldMap, final Integer id) throws DaoException;

}
