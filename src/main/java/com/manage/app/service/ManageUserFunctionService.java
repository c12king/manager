package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageUserFunction;
import com.manage.app.vo.ManageUserFunctionQuery;


public interface ManageUserFunctionService {

	/**
	 * 查询单个ManageUserFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageUserFunction findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageUserFunction
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageUserFunction> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageUserFunction
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageUserFunction-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageUserFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageUserFunctionQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageUserFunctionQuery query) throws ServiceException;
	
	/**
	 * 保存ManageUserFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(String userId,String[] functionId0,String[] functionId1,String[] functionId2,String[] functionId3) throws ServiceException;
	
	/**
	 * 修改ManageUserFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageUserFunction entity) throws ServiceException;

	/**
	 * 删除ManageUserFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
