package com.manage.app.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;
import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.vo.BusinessPropertyQuery;

@Repository
public interface BusinessPropertyDao {
		
	/**
	 * 查询单个BusinessProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProperty findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProperty
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProperty> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessProperty
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProperty-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProperty
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProperty-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProperty> findAllPage(final BusinessPropertyQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPropertyQuery query) throws DaoException;
	
	/**
	 * 保存BusinessProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProperty entity) throws DaoException;
	
	/**
	 * 修改BusinessProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProperty entity) throws DaoException;

	/**
	 * 删除BusinessProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 获取该区域下物业下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public List<BusinessProperty> getComboboxData(final Integer countyId) throws DaoException;


}
