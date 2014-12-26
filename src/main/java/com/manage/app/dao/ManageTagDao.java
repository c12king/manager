package com.manage.app.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.ManageTag;
import com.manage.app.vo.ManageTagQuery;

@Repository
public interface ManageTagDao {
		
	/**
	 * 查询单个ManageTag
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageTag findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageTag
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTag> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageTag
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTag> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageTag-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageTag> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageTag
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTag> findByExample(final ManageTagQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageTag-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageTag> findByExample(final ManageTagQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTag> findAllPage(final ManageTagQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageTagQuery query) throws DaoException;
	
	/**
	 * 保存ManageTag数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageTag entity) throws DaoException;
	
	/**
	 * 修改ManageTag数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageTag entity) throws DaoException;

	/**
	 * 删除ManageTag
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
