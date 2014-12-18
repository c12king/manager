package com.manage.app.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.bean.BusinessStation;
import com.manage.app.vo.BusinessStationQuery;

@Repository
public interface BusinessStationDao {
		
	/**
	 * 查询单个BusinessStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStation findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessStation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStation> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessStation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStation> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessStation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessStation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStation> findByExample(final BusinessStationQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessStation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStation> findByExample(final BusinessStationQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStation> findAllPage(final BusinessStationQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationQuery query) throws DaoException;
	
	/**
	 * 保存BusinessStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStation entity) throws DaoException;
	
	/**
	 * 修改BusinessStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStation entity) throws DaoException;

	/**
	 * 删除BusinessStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 获取该区域下驿站下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public List<BusinessStation> getComboboxData(final Integer countyId) throws DaoException;


}
