package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessSpecialMenu;
import com.manage.app.dao.BusinessSpecialMenuDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessSpecialMenuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessSpecialMenuService")
@Transactional
public class BusinessSpecialMenuServiceImpl implements BusinessSpecialMenuService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessSpecialMenuServiceImpl.class);
	@Autowired
	private BusinessSpecialMenuDao businessSpecialMenuDao;

	/**
	 * 查询单个BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessSpecialMenu findById(final Integer id) throws ServiceException {
		BusinessSpecialMenu businessSpecialMenu = new BusinessSpecialMenu();
		try {
			businessSpecialMenu = businessSpecialMenuDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findById()：查询单个BusinessSpecialMenu发生错误！", e);
			e.printStackTrace();
		}
		return businessSpecialMenu;
	}
	
	/**
	 * 无条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessSpecialMenu> findAll() throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		try {
			list=businessSpecialMenuDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findAll()：无条件查询所有BusinessSpecialMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessSpecialMenu> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		try {
			list=businessSpecialMenuDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findByMap()：按Map对象条件查询所有BusinessSpecialMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessSpecialMenu> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		try {
			list=businessSpecialMenuDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findByMap()：按Map对象条件查询所有BusinessSpecialMenu-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		try {
			list=businessSpecialMenuDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findByExample()：按VO对象条件查询所有BusinessSpecialMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query, final Integer limit) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		try {
			list=businessSpecialMenuDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findByExample()：按VO对象条件查询所有BusinessSpecialMenu-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessSpecialMenuQuery query) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessSpecialMenuDao.selectCount(query);
			query.setCount(count);
			list=businessSpecialMenuDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessSpecialMenuQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessSpecialMenuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessSpecialMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessSpecialMenu entity) throws ServiceException {
		try {
			businessSpecialMenuDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl save()：保存BusinessSpecialMenu发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessSpecialMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessSpecialMenu entity) throws ServiceException {
		try {
			businessSpecialMenuDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl update()：修改BusinessSpecialMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessSpecialMenu
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessSpecialMenuDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl delete()：删除BusinessSpecialMenu发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessSpecialMenuDao.selectCount(query);
			query.setCount(count);
			list=businessSpecialMenuDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws ServiceException {
		List<BusinessSpecialMenu> list = new ArrayList<BusinessSpecialMenu>() ;
		try {
			list=businessSpecialMenuDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessSpecialMenu findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessSpecialMenu businessSpecialMenu = new BusinessSpecialMenu();
		try {
			businessSpecialMenu = businessSpecialMenuDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialMenuServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessSpecialMenu;
	}
	
}
