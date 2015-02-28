package com.manage.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessUserCommunity;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessUserCommunityQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessUserCommunityService {

	/**
	 * 查询单个BusinessUserCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUserCommunity findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessUserCommunity
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUserCommunity> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessUserCommunity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserCommunity> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessUserCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessUserCommunity
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessUserCommunityQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessUserCommunityQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessUserCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessUserCommunity entity) throws ServiceException;
	
	/**
	 * 修改BusinessUserCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessUserCommunity entity) throws ServiceException;

	/**
	 * 删除BusinessUserCommunity
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUserCommunity findByField(final Map fieldMap, final Integer id) throws ServiceException;

	/**
	 * 删除用户下的社区关系
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean deleteCommunity(Integer userId) throws ServiceException;
	
	
}
