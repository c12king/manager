package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.BuseinessTel;
import com.manage.app.bean.ManageHouse;
import com.manage.app.vo.BuseinessTelQuery;
import com.manage.framework.exception.DaoException;
import com.utis.Page;

@Repository
public interface BuseinessTelDao {
		
	/**
	 * 查询单个BuseinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BuseinessTel findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BuseinessTel
	 * @return
	 * @throws DaoException
	 */
	public List<BuseinessTel> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BuseinessTel
	 * @return
	 * @throws DaoException
	 */	
	public List<BuseinessTel> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BuseinessTel-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BuseinessTel> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BuseinessTel
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BuseinessTel> findByExample(final BuseinessTelQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BuseinessTel-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BuseinessTel> findByExample(final BuseinessTelQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BuseinessTel> findAllPage(final BuseinessTelQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BuseinessTelQuery query) throws DaoException;
	
	/**
	 * 保存BuseinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BuseinessTel entity) throws DaoException;
	
	/**
	 * 修改BuseinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BuseinessTel entity) throws DaoException;

	/**
	 * 删除BuseinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;
	
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<ManageHouse> findAllPage(Page page) throws GSSException;

}
