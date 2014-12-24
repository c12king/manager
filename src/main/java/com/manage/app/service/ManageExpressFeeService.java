package com.manage.app.service;

import java.util.List;
import java.util.Map;






import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageExpressFee;
import com.manage.app.vo.ManageExpressFeeQuery;


public interface ManageExpressFeeService {

	/**
	 * 查询单个ManageExpressFee
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageExpressFee findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageExpressFee
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageExpressFee> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageExpressFee
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageExpressFee> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageExpressFee-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageExpressFee> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageExpressFee
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageExpressFee-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageExpressFeeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageExpressFeeQuery query) throws ServiceException;
	
	/**
	 * 保存ManageExpressFee数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageExpressFee entity) throws ServiceException;
	
	/**
	 * 修改ManageExpressFee数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageExpressFee entity) throws ServiceException;

	/**
	 * 删除ManageExpressFee
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
