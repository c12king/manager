package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.BusinessShop;
import com.manage.app.vo.BusinessShopQuery;


public interface BusinessShopService {

	/**
	 * 查询单个BusinessShop
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessShop findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessShop
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessShop> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessShop
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessShop> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessShop-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessShop> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessShop
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessShop> findByExample(final BusinessShopQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessShop-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessShop> findByExample(final BusinessShopQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessShopQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessShopQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessShop数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessShop entity) throws ServiceException;
	
	/**
	 * 修改BusinessShop数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessShop entity) throws ServiceException;

	/**
	 * 删除BusinessShop
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
