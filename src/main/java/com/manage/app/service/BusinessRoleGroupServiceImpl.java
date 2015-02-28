package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleGroup;
import com.manage.app.dao.BusinessRoleGroupDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleGroupQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleGroupService")
@Transactional
public class BusinessRoleGroupServiceImpl implements BusinessRoleGroupService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleGroupServiceImpl.class);
	@Autowired
	private BusinessRoleGroupDao businessRoleGroupDao;

	/**
	 * 查询单个BusinessRoleGroup
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleGroup findById(final Integer id) throws ServiceException {
		BusinessRoleGroup businessRoleGroup = new BusinessRoleGroup();
		try {
			businessRoleGroup = businessRoleGroupDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findById()：查询单个BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleGroup;
	}
	
	/**
	 * 无条件查询所有BusinessRoleGroup
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRoleGroup> findAll() throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		try {
			list=businessRoleGroupDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findAll()：无条件查询所有BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleGroup
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleGroup> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		try {
			list=businessRoleGroupDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleGroup-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleGroup> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		try {
			list=businessRoleGroupDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleGroup-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleGroup
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleGroup> findByExample(final BusinessRoleGroupQuery query) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		try {
			list=businessRoleGroupDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleGroup-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleGroup> findByExample(final BusinessRoleGroupQuery query, final Integer limit) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		try {
			list=businessRoleGroupDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleGroup-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessRoleGroupQuery query) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleGroupDao.selectCount(query);
			query.setCount(count);
			list=businessRoleGroupDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessRoleGroupQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleGroupDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRoleGroup数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRoleGroup entity) throws ServiceException {
		try {
			businessRoleGroupDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl save()：保存BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRoleGroup数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRoleGroup entity) throws ServiceException {
		try {
			businessRoleGroupDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl update()：修改BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRoleGroup
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleGroupDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl delete()：删除BusinessRoleGroup发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleGroupQuery query) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleGroupDao.selectCount(query);
			query.setCount(count);
			list=businessRoleGroupDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List findListByField(final Map fieldMap, final BusinessRoleGroupQuery query) throws ServiceException {
		List<BusinessRoleGroup> list = new ArrayList<BusinessRoleGroup>() ;
		try {
			list=businessRoleGroupDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleGroup findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRoleGroup businessRoleGroup = new BusinessRoleGroup();
		try {
			businessRoleGroup = businessRoleGroupDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleGroupServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleGroup;
	}
	
}
