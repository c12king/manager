package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.ManageTag;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageTagQuery;
import com.manage.framework.exception.ServiceException;


public interface ManageTagService {

	/**
	 * 查询单个ManageTag
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageTag findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageTag
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageTag> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageTag
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageTag> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageTag-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageTag> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageTag
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageTag> findByExample(final ManageTagQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageTag-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageTag> findByExample(final ManageTagQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageTagQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageTagQuery query) throws ServiceException;
	
	/**
	 * 保存ManageTag数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageTag entity) throws ServiceException;
	
	/**
	 * 修改ManageTag数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageTag entity) throws ServiceException;

	/**
	 * 删除ManageTag
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
