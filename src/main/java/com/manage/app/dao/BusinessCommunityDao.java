package com.manage.app.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;
import com.manage.app.bean.BusinessCommunity;
import com.manage.app.vo.BusinessCommunityQuery;

@Repository
public interface BusinessCommunityDao {
		
	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessCommunity findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findAllPage(final BusinessCommunityQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessCommunityQuery query) throws DaoException;
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessCommunity entity) throws DaoException;
	
	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessCommunity entity) throws DaoException;

	/**
	 * 删除BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 获取该区域下社区下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public List<BusinessCommunity> getComboboxData(final Integer countyId) throws DaoException;


}
