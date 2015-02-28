package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRole;
import com.manage.app.dao.BusinessRoleDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleService")
@Transactional
public class BusinessRoleServiceImpl implements BusinessRoleService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleServiceImpl.class);
	@Autowired
	private BusinessRoleDao businessRoleDao;

	/**
	 * 查询单个BusinessRole
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRole findById(final Integer id) throws ServiceException {
		BusinessRole businessRole = new BusinessRole();
		try {
			businessRole = businessRoleDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findById()：查询单个BusinessRole发生错误！", e);
			e.printStackTrace();
		}
		return businessRole;
	}
	
	/**
	 * 无条件查询所有BusinessRole
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRole> findAll() throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		try {
			list=businessRoleDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findAll()：无条件查询所有BusinessRole发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRole
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRole> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		try {
			list=businessRoleDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findByMap()：按Map对象条件查询所有BusinessRole发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRole-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRole> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		try {
			list=businessRoleDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findByMap()：按Map对象条件查询所有BusinessRole-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRole
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRole> findByExample(final BusinessRoleQuery query) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		try {
			list=businessRoleDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findByExample()：按VO对象条件查询所有BusinessRole发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRole-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRole> findByExample(final BusinessRoleQuery query, final Integer limit) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		try {
			list=businessRoleDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findByExample()：按VO对象条件查询所有BusinessRole-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRoleQuery query) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleDao.selectCount(query);
			query.setCount(count);
			list=businessRoleDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRoleQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRole数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRole entity) throws ServiceException {
		try {
			businessRoleDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl save()：保存BusinessRole发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRole数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRole entity) throws ServiceException {
		try {
			businessRoleDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl update()：修改BusinessRole发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRole
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl delete()：删除BusinessRole发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleQuery query) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleDao.selectCount(query);
			query.setCount(count);
			list=businessRoleDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessRoleQuery query) throws ServiceException {
		List<BusinessRole> list = new ArrayList<BusinessRole>() ;
		try {
			list=businessRoleDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessRole findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRole businessRole = new BusinessRole();
		try {
			businessRole = businessRoleDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRole;
	}
	
	/**
	 * 删除角色下的所有权限及菜单
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean deleteMenuFunction(Integer roleId) throws ServiceException {
		try {
			return businessRoleDao.deleteMenuFunction(roleId);
		} catch (DaoException e) {
			logger.debug("BusinessRoleServiceImpl deleteMenuFunction()：删除角色下的所有权限及菜单发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
