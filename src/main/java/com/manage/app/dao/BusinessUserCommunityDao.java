package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessUserCommunity;
import com.manage.app.vo.BusinessUserCommunityQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessUserCommunityDao {
		
	/**
	 * 查询单个BusinessUserCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserCommunity findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessUserCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserCommunity> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessUserCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUserCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessUserCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserCommunity> findAllPage(final BusinessUserCommunityQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserCommunityQuery query) throws DaoException;
	
	/**
	 * 保存BusinessUserCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserCommunity entity) throws DaoException;
	
	/**
	 * 修改BusinessUserCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserCommunity entity) throws DaoException;

	/**
	 * 删除BusinessUserCommunity
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
	public List<BusinessUserCommunity> findAllPageByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUserCommunity> findListByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUserCommunity findByField(final Map fieldMap, final Integer id) throws DaoException;
	
	/**
	 * 删除用户下的社区关系
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean deleteCommunity(Integer userId) throws DaoException;

}
