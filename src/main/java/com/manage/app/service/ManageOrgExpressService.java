package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageOrgExpress;
import com.manage.app.vo.ManageOrgExpressQuery;


public interface ManageOrgExpressService {

	/**
	 * 查询单个ManageOrgExpress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageOrgExpress findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageOrgExpress
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageOrgExpress> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageOrgExpress
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageOrgExpress> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageOrgExpress-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageOrgExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageOrgExpress
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageOrgExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageOrgExpressQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageOrgExpressQuery query) throws ServiceException;
	
	/**
	 * 保存ManageOrgExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageOrgExpress entity) throws ServiceException;
	
	/**
	 * 修改ManageOrgExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageOrgExpress entity) throws ServiceException;

	/**
	 * 删除ManageOrgExpress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
