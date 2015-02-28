package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageModulemenu;
import com.manage.app.vo.ManageModulemenuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface ManageModulemenuDao {
		
	/**
	 * 查询moduleId=id的ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModulemenu> findById(final Integer id) throws DaoException;
	
	/**
	 * 查询moduleId=id的ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModulemenu> findByIdModuleId(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageModulemenu
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModulemenu> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageModulemenu
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageModulemenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageModulemenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageModulemenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModulemenu> findAllPage(final ManageModulemenuQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageModulemenuQuery query) throws DaoException;
	
	/**
	 * 保存ManageModulemenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageModulemenu entity) throws DaoException;
	
	/**
	 * 修改ManageModulemenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageModulemenu entity) throws DaoException;

	/**
	 * 删除ManageModulemenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
