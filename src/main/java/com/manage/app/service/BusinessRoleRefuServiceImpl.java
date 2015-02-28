package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleRefu;
import com.manage.app.dao.BusinessRoleRefuDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleRefuQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleRefuService")
@Transactional
public class BusinessRoleRefuServiceImpl implements BusinessRoleRefuService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleRefuServiceImpl.class);
	@Autowired
	private BusinessRoleRefuDao businessRoleRefuDao;

	/**
	 * 查询单个BusinessRoleRefu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleRefu findById(final Integer id) throws ServiceException {
		BusinessRoleRefu businessRoleRefu = new BusinessRoleRefu();
		try {
			businessRoleRefu = businessRoleRefuDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findById()：查询单个BusinessRoleRefu发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleRefu;
	}
	
	/**
	 * 无条件查询所有BusinessRoleRefu
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRoleRefu> findAll() throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		try {
			list=businessRoleRefuDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findAll()：无条件查询所有BusinessRoleRefu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleRefu
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleRefu> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		try {
			list=businessRoleRefuDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleRefu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleRefu-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleRefu> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		try {
			list=businessRoleRefuDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleRefu-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleRefu
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleRefu> findByExample(final BusinessRoleRefuQuery query) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		try {
			list=businessRoleRefuDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleRefu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleRefu-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleRefu> findByExample(final BusinessRoleRefuQuery query, final Integer limit) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		try {
			list=businessRoleRefuDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleRefu-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRoleRefuQuery query) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleRefuDao.selectCount(query);
			query.setCount(count);
			list=businessRoleRefuDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRoleRefuQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleRefuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRoleRefu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRoleRefu entity) throws ServiceException {
		try {
			businessRoleRefuDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl save()：保存BusinessRoleRefu发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRoleRefu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRoleRefu entity) throws ServiceException {
		try {
			businessRoleRefuDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl update()：修改BusinessRoleRefu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRoleRefu
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleRefuDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl delete()：删除BusinessRoleRefu发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleRefuQuery query) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleRefuDao.selectCount(query);
			query.setCount(count);
			list=businessRoleRefuDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessRoleRefuQuery query) throws ServiceException {
		List<BusinessRoleRefu> list = new ArrayList<BusinessRoleRefu>() ;
		try {
			list=businessRoleRefuDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessRoleRefu findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRoleRefu businessRoleRefu = new BusinessRoleRefu();
		try {
			businessRoleRefu = businessRoleRefuDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleRefuServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleRefu;
	}
	
}
