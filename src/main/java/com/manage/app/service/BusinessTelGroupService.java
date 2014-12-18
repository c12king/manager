package com.manage.app.service;

import java.util.List;
import java.util.Map;

import com.manage.app.bean.BusinessTelGroup;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessTelGroupQuery;
import com.manage.framework.exception.ServiceException;


public interface BusinessTelGroupService {

	/**
	 * 查询单个BusinessTelGroup
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessTelGroup findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessTelGroup
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessTelGroup> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessTelGroup
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessTelGroup> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessTelGroup-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessTelGroup> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessTelGroup
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessTelGroup-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessTelGroupQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessTelGroupQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessTelGroup数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessTelGroup entity) throws ServiceException;
	
	/**
	 * 修改BusinessTelGroup数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessTelGroup entity) throws ServiceException;

	/**
	 * 删除BusinessTelGroup
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	public String treeData(String id) throws ServiceException ;

}
