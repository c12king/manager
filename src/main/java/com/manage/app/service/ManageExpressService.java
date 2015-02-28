package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.ManageExpress;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageExpressQuery;
import com.manage.framework.exception.ServiceException;


public interface ManageExpressService {

	/**
	 * 查询单个ManageExpress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageExpress findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageExpress
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageExpress> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageExpress
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageExpress> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageExpress-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageExpress> findByExample(final ManageExpressQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageExpress> findByExample(final ManageExpressQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageExpressQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageExpressQuery query) throws ServiceException;
	
	/**
	 * 保存ManageExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageExpress entity) throws ServiceException;
	
	/**
	 * 修改ManageExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageExpress entity) throws ServiceException;

	/**
	 * 删除ManageExpress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
