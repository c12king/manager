package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageExpressFee;
import com.manage.app.vo.ManageExpressFeeQuery;
import com.manage.framework.exception.DaoException;

@Repository
public interface ManageExpressFeeDao {
		
	/**
	 * 查询单个ManageExpressFee
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpressFee findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageExpressFee
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressFee> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageExpressFee
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressFee> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageExpressFee-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageExpressFee> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageExpressFee
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageExpressFee-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressFee> findAllPage(final ManageExpressFeeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressFeeQuery query) throws DaoException;
	
	/**
	 * 保存ManageExpressFee数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpressFee entity) throws DaoException;
	
	/**
	 * 修改ManageExpressFee数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpressFee entity) throws DaoException;

	/**
	 * 删除ManageExpressFee
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
