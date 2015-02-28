package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.BusinessStationService;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessStationServiceQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessStationServiceService {

	/**
	 * 查询单个BusinessStationService
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessStationService findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessStationService
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessStationService> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessStationService
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationService> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationService-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationService> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessStationService
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessStationService-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessStationServiceQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessStationServiceQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessStationService数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessStationService entity) throws ServiceException;
	
	/**
	 * 修改BusinessStationService数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessStationService entity) throws ServiceException;

	/**
	 * 删除BusinessStationService
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
