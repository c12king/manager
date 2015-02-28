package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageModule;
import com.manage.app.vo.ManageModuleQuery;
import com.manage.framework.exception.DaoException;

@Repository
public interface ManageModuleDao {
		
	/**
	 * 查询单个ManageModule
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageModule findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageModule
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModule> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageModule
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModule> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageModule-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModule> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageModule
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModule> findByExample(final ManageModuleQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageModule-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModule> findByExample(final ManageModuleQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModule> findAllPage(final ManageModuleQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageModuleQuery query) throws DaoException;
	
	/**
	 * 保存ManageModule数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageModule entity) throws DaoException;
	
	/**
	 * 修改ManageModule数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageModule entity) throws DaoException;

	/**
	 * 删除ManageModule
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 根据机构类型获取模块
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModule> findOrgTypeAll(final String type) throws DaoException;

}
