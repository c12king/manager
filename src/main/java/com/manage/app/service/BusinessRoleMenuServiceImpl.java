package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleMenu;
import com.manage.app.dao.BusinessRoleMenuDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleMenuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleMenuService")
@Transactional
public class BusinessRoleMenuServiceImpl implements BusinessRoleMenuService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleMenuServiceImpl.class);
	@Autowired
	private BusinessRoleMenuDao businessRoleMenuDao;

	/**
	 * 查询单个BusinessRoleMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleMenu findById(final Integer id) throws ServiceException {
		BusinessRoleMenu businessRoleMenu = new BusinessRoleMenu();
		try {
			businessRoleMenu = businessRoleMenuDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findById()：查询单个BusinessRoleMenu发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleMenu;
	}
	
	/**
	 * 无条件查询所有BusinessRoleMenu
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRoleMenu> findAll() throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		try {
			list=businessRoleMenuDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findAll()：无条件查询所有BusinessRoleMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleMenu
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleMenu> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		try {
			list=businessRoleMenuDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleMenu> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		try {
			list=businessRoleMenuDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleMenu-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleMenu
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		try {
			list=businessRoleMenuDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query, final Integer limit) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		try {
			list=businessRoleMenuDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleMenu-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRoleMenuQuery query) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleMenuDao.selectCount(query);
			query.setCount(count);
			list=businessRoleMenuDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRoleMenuQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleMenuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRoleMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRoleMenu entity) throws ServiceException {
		try {
			businessRoleMenuDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl save()：保存BusinessRoleMenu发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRoleMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRoleMenu entity) throws ServiceException {
		try {
			businessRoleMenuDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl update()：修改BusinessRoleMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRoleMenu
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleMenuDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl delete()：删除BusinessRoleMenu发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleMenuDao.selectCount(query);
			query.setCount(count);
			list=businessRoleMenuDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws ServiceException {
		List<BusinessRoleMenu> list = new ArrayList<BusinessRoleMenu>() ;
		try {
			list=businessRoleMenuDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessRoleMenu findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRoleMenu businessRoleMenu = new BusinessRoleMenu();
		try {
			businessRoleMenu = businessRoleMenuDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleMenuServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleMenu;
	}
	
}
