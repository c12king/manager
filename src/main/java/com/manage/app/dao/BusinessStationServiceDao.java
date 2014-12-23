package com.manage.app.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.BusinessStationService;
import com.manage.app.vo.BusinessStationServiceQuery;

@Repository
public interface BusinessStationServiceDao {
		
	/**
	 * 查询单个BusinessStationService
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationService findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessStationService
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationService> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessStationService
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationService> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationService-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationService> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessStationService
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessStationService-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationService> findAllPage(final BusinessStationServiceQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationServiceQuery query) throws DaoException;
	
	/**
	 * 保存BusinessStationService数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationService entity) throws DaoException;
	
	/**
	 * 修改BusinessStationService数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationService entity) throws DaoException;

	/**
	 * 删除BusinessStationService
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
