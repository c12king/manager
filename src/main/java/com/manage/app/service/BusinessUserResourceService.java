package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.BusinessUserResource;
import com.manage.app.vo.BusinessUserResourceQuery;


public interface BusinessUserResourceService {

	/**
	 * 查询单个BusinessUserResource
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUserResource findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessUserResource
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUserResource> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessUserResource
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserResource> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserResource-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserResource> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessUserResource
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessUserResource-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessUserResourceQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessUserResourceQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessUserResource数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessUserResource entity) throws ServiceException;
	
	/**
	 * 保存BusinessUserResource数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_resources(int userId,String [] comId,String [] estateId) throws ServiceException;
	
	/**
	 * 修改BusinessUserResource数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessUserResource entity) throws ServiceException;

	/**
	 * 删除BusinessUserResource
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
