package com.manage.app.service;

import java.util.List;
import java.util.Map;







import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.BusinessStation;
import com.manage.app.vo.BusinessStationQuery;


public interface BusinessStationService {

	/**
	 * 查询单个BusinessStation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessStation findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessStation
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessStation> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessStation
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStation> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessStation-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessStation
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStation> findByExample(final BusinessStationQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessStation-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStation> findByExample(final BusinessStationQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessStationQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessStationQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessStation entity) throws ServiceException;
	
	/**
	 * 修改BusinessStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessStation entity) throws ServiceException;

	/**
	 * 删除BusinessStation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 获取该区域下驿站下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public String getComboboxData(final Integer countyId) throws ServiceException;

}
