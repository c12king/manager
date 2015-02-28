package com.manage.app.service;

import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.BuseinessTel;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BuseinessTelQuery;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;


public interface BuseinessTelService {

	/**
	 * 查询单个BuseinessTel
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BuseinessTel findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BuseinessTel
	 * @return
	 * @throws ServiceException
	 */
	public List<BuseinessTel> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BuseinessTel
	 * @return
	 * @throws ServiceException
	 */	
	public List<BuseinessTel> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BuseinessTel-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BuseinessTel> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BuseinessTel
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BuseinessTel> findByExample(final BuseinessTelQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BuseinessTel-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BuseinessTel> findByExample(final BuseinessTelQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BuseinessTelQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BuseinessTelQuery query) throws ServiceException;
	
	/**
	 * 保存BuseinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BuseinessTel entity) throws ServiceException;
	
	/**
	 * 修改BuseinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BuseinessTel entity) throws ServiceException;

	/**
	 * 删除BuseinessTel
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	 /** 
	  * 查询ManageHouse列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;

}
