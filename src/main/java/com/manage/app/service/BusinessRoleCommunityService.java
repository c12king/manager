package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.BusinessRoleCommunity;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleCommunityQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessRoleCommunityService {

	/**
	 * 查询单个BusinessRoleCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleCommunity findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRoleCommunity> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRoleCommunity> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRoleCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRoleCommunityQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRoleCommunityQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRoleCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRoleCommunity entity) throws ServiceException;
	
	/**
	 * 修改BusinessRoleCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRoleCommunity entity) throws ServiceException;

	/**
	 * 删除BusinessRoleCommunity
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRoleCommunity findByField(final Map fieldMap, final Integer id) throws ServiceException;

}
