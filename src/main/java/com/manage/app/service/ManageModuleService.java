package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageModule;
import com.manage.app.vo.ManageModuleQuery;


public interface ManageModuleService {

	/**
	 * 查询单个ManageModule
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageModule findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageModule
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModule> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageModule
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModule> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageModule-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModule> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageModule
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModule> findByExample(final ManageModuleQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageModule-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModule> findByExample(final ManageModuleQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageModuleQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageModuleQuery query) throws ServiceException;
	
	/**
	 * 保存ManageModule数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageModule entity) throws ServiceException;
	
	/**
	 * 修改ManageModule数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageModule entity) throws ServiceException;

	/**
	 * 删除ManageModule
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
