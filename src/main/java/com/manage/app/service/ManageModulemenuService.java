package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageModulemenu;
import com.manage.app.vo.ManageModulemenuQuery;


public interface ManageModulemenuService {

	/**
	 * 查询moduleId=id的ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModulemenu> findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageModulemenu
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModulemenu> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageModulemenu
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModulemenu> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageModulemenu-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModulemenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageModulemenu
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageModulemenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageModulemenuQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageModulemenuQuery query) throws ServiceException;
	
	/**
	 * 保存ManageModulemenu数据
	 * @param moduleId
	 * @param menuId
	 * @throws ServiceException
	 */
	public void save(String moduleId,String[] menuId) throws ServiceException;
	
	/**
	 * 修改ManageModulemenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageModulemenu entity) throws ServiceException;

	/**
	 * 删除ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
