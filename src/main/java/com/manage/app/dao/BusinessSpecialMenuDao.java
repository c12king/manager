package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessSpecialMenu;
import com.manage.app.vo.BusinessSpecialMenuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Repository
public interface BusinessSpecialMenuDao {
		
	/**
	 * 查询单个BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSpecialMenu findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialMenu> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialMenu> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessSpecialMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialMenu> findAllPage(final BusinessSpecialMenuQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessSpecialMenuQuery query) throws DaoException;
	
	/**
	 * 保存BusinessSpecialMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessSpecialMenu entity) throws DaoException;
	
	/**
	 * 修改BusinessSpecialMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessSpecialMenu entity) throws DaoException;

	/**
	 * 删除BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessSpecialMenu> findAllPageByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessSpecialMenu> findListByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessSpecialMenu findByField(final Map fieldMap, final Integer id) throws DaoException;

}
