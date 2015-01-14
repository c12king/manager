package com.manage.app.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.BusinessShopType;
import com.manage.app.vo.BusinessShopTypeQuery;

@Repository
public interface BusinessShopTypeDao {
		
	/**
	 * 查询单个BusinessShopType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessShopType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessShopType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessShopType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessShopType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessShopType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopType> findAllPage(final BusinessShopTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessShopType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopType entity) throws DaoException;
	
	/**
	 * 修改BusinessShopType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopType entity) throws DaoException;

	/**
	 * 删除BusinessShopType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
