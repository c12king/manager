package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageOrgExpress;
import com.manage.app.vo.ManageOrgExpressQuery;
import com.manage.framework.exception.DaoException;

@Repository
public interface ManageOrgExpressDao {
		
	/**
	 * 查询单个ManageOrgExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageOrgExpress findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageOrgExpress
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrgExpress> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageOrgExpress
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrgExpress> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageOrgExpress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageOrgExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageOrgExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageOrgExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrgExpress> findAllPage(final ManageOrgExpressQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageOrgExpressQuery query) throws DaoException;
	
	/**
	 * 保存ManageOrgExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageOrgExpress entity) throws DaoException;
	
	/**
	 * 修改ManageOrgExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageOrgExpress entity) throws DaoException;

	/**
	 * 删除ManageOrgExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
