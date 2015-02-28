package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.ManageTagType;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageTagTypeQuery;
import com.manage.framework.exception.ServiceException;


public interface ManageTagTypeService {

	/**
	 * 查询单个ManageTagType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageTagType findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageTagType
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageTagType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageTagType
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageTagType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageTagType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageTagType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageTagType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageTagType> findByExample(final ManageTagTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageTagType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageTagType> findByExample(final ManageTagTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageTagTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageTagTypeQuery query) throws ServiceException;
	
	/**
	 * 保存ManageTagType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageTagType entity) throws ServiceException;
	
	/**
	 * 修改ManageTagType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageTagType entity) throws ServiceException;

	/**
	 * 删除ManageTagType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
