package com.manage.app.service;

import java.util.List;
import java.util.Map;







import org.ietf.jgss.GSSException;

import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.ManageCounty;
import com.manage.app.vo.BusinessCommunityQuery;


public interface BusinessCommunityService {

	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessCommunity findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessCommunityQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessCommunityQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessCommunity entity) throws ServiceException;
	
	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessCommunity entity) throws ServiceException;

	/**
	 * 删除BusinessCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 获取该区域下社区下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public String getComboboxData(final Integer countyId) throws ServiceException;

}
