package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageTagType;
import com.manage.app.vo.ManageTagTypeQuery;
import com.manage.framework.exception.DaoException;

@Repository
public interface ManageTagTypeDao {
		
	/**
	 * 查询单个ManageTagType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageTagType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageTagType
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTagType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageTagType
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTagType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageTagType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageTagType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageTagType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTagType> findByExample(final ManageTagTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageTagType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageTagType> findByExample(final ManageTagTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTagType> findAllPage(final ManageTagTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageTagTypeQuery query) throws DaoException;
	
	/**
	 * 保存ManageTagType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageTagType entity) throws DaoException;
	
	/**
	 * 修改ManageTagType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageTagType entity) throws DaoException;

	/**
	 * 删除ManageTagType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
