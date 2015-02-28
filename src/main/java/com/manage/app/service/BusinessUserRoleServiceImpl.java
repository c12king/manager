package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessUserRole;
import com.manage.app.dao.BusinessUserRoleDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessUserRoleQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessUserRoleService")
@Transactional
public class BusinessUserRoleServiceImpl implements BusinessUserRoleService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserRoleServiceImpl.class);
	@Autowired
	private BusinessUserRoleDao businessUserRoleDao;

	/**
	 * 查询单个BusinessUserRole
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessUserRole findById(final Integer id) throws ServiceException {
		BusinessUserRole businessUserRole = new BusinessUserRole();
		try {
			businessUserRole = businessUserRoleDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findById()：查询单个BusinessUserRole发生错误！", e);
			e.printStackTrace();
		}
		return businessUserRole;
	}
	
	/**
	 * 无条件查询所有BusinessUserRole
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessUserRole> findAll() throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		try {
			list=businessUserRoleDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findAll()：无条件查询所有BusinessUserRole发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserRole
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserRole> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		try {
			list=businessUserRoleDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findByMap()：按Map对象条件查询所有BusinessUserRole发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserRole-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUserRole> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		try {
			list=businessUserRoleDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findByMap()：按Map对象条件查询所有BusinessUserRole-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserRole
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserRole> findByExample(final BusinessUserRoleQuery query) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		try {
			list=businessUserRoleDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findByExample()：按VO对象条件查询所有BusinessUserRole发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserRole-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUserRole> findByExample(final BusinessUserRoleQuery query, final Integer limit) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		try {
			list=businessUserRoleDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findByExample()：按VO对象条件查询所有BusinessUserRole-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessUserRoleQuery query) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessUserRoleDao.selectCount(query);
			query.setCount(count);
			list=businessUserRoleDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessUserRoleQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessUserRoleDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessUserRole数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessUserRole entity) throws ServiceException {
		try {
			businessUserRoleDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl save()：保存BusinessUserRole发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessUserRole数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessUserRole entity) throws ServiceException {
		try {
			businessUserRoleDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl update()：修改BusinessUserRole发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessUserRole
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessUserRoleDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl delete()：删除BusinessUserRole发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessUserRoleQuery query) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessUserRoleDao.selectCount(query);
			query.setCount(count);
			list=businessUserRoleDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessUserRoleQuery query) throws ServiceException {
		List<BusinessUserRole> list = new ArrayList<BusinessUserRole>() ;
		try {
			list=businessUserRoleDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessUserRole findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessUserRole businessUserRole = new BusinessUserRole();
		try {
			businessUserRole = businessUserRoleDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessUserRoleServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessUserRole;
	}
	
}
