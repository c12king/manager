package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageAdmin;
import com.manage.app.vo.ManageAdminQuery;


public interface ManageAdminService {

	/**
	 * 查询单个ManageAdmin
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageAdmin findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageAdmin
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageAdmin> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageAdmin
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageAdmin> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageAdmin-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageAdmin> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageAdmin
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageAdmin> findByExample(final ManageAdminQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageAdmin-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageAdmin> findByExample(final ManageAdminQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageAdminQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageAdminQuery query) throws ServiceException;
	
	/**
	 * 保存ManageAdmin数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageAdmin entity) throws ServiceException;
	
	/**
	 * 修改ManageAdmin数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageAdmin entity) throws ServiceException;

	/**
	 * 删除ManageAdmin
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPageByField(final Map fieldMap, final ManageAdminQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final ManageAdminQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageAdmin findByField(final Map fieldMap, final Integer id) throws ServiceException;

}
