package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessTelGroup;
import com.manage.app.vo.BusinessTelGroupQuery;
import com.manage.framework.exception.DaoException;

@Repository
public interface BusinessTelGroupDao {
		
	/**
	 * 查询单个BusinessTelGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessTelGroup findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessTelGroup
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTelGroup> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessTelGroup
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTelGroup> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessTelGroup-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessTelGroup> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessTelGroup
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessTelGroup-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTelGroup> findAllPage(final BusinessTelGroupQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTelGroupQuery query) throws DaoException;
	
	/**
	 * 保存BusinessTelGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessTelGroup entity) throws DaoException;
	
	/**
	 * 修改BusinessTelGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessTelGroup entity) throws DaoException;

	/**
	 * 删除BusinessTelGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
