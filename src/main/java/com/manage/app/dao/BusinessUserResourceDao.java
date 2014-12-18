package com.manage.app.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.BusinessUserResource;
import com.manage.app.vo.BusinessUserResourceQuery;

@Repository
public interface BusinessUserResourceDao {
		
	/**
	 * 查询单个BusinessUserResource
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserResource findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessUserResource
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserResource> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessUserResource
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserResource> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserResource-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserResource> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessUserResource
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessUserResource-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserResource> findAllPage(final BusinessUserResourceQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserResourceQuery query) throws DaoException;
	
	/**
	 * 保存BusinessUserResource数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserResource entity) throws DaoException;
	
	/**
	 * 修改BusinessUserResource数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserResource entity) throws DaoException;

	/**
	 * 删除BusinessUserResource
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
