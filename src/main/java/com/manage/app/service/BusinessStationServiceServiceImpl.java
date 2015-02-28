package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessStationService;
import com.manage.app.dao.BusinessStationServiceDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessStationServiceQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessStationServiceService")
@Transactional
public class BusinessStationServiceServiceImpl implements BusinessStationServiceService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessStationServiceServiceImpl.class);
	@Autowired
	private BusinessStationServiceDao businessStationServiceDao;

	/**
	 * 查询单个BusinessStationService
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessStationService findById(final Integer id) throws ServiceException {
		BusinessStationService businessStationService = new BusinessStationService();
		try {
			businessStationService = businessStationServiceDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findById()：查询单个BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
		return businessStationService;
	}
	
	/**
	 * 无条件查询所有BusinessStationService
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessStationService> findAll() throws ServiceException {
		List<BusinessStationService> list = new ArrayList<BusinessStationService>() ;
		try {
			list=businessStationServiceDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findAll()：无条件查询所有BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationService
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationService> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessStationService> list = new ArrayList<BusinessStationService>() ;
		try {
			list=businessStationServiceDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findByMap()：按Map对象条件查询所有BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationService-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationService> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessStationService> list = new ArrayList<BusinessStationService>() ;
		try {
			list=businessStationServiceDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findByMap()：按Map对象条件查询所有BusinessStationService-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationService
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query) throws ServiceException {
		List<BusinessStationService> list = new ArrayList<BusinessStationService>() ;
		try {
			list=businessStationServiceDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findByExample()：按VO对象条件查询所有BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationService-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query, final Integer limit) throws ServiceException {
		List<BusinessStationService> list = new ArrayList<BusinessStationService>() ;
		try {
			list=businessStationServiceDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findByExample()：按VO对象条件查询所有BusinessStationService-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessStationServiceQuery query) throws ServiceException {
		List<BusinessStationService> list = new ArrayList<BusinessStationService>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessStationServiceDao.findAllPage(query);
			count=businessStationServiceDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessStationServiceQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessStationServiceDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessStationService数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessStationService entity) throws ServiceException {
		try {
			businessStationServiceDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl save()：保存BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessStationService数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessStationService entity) throws ServiceException {
		try {
			businessStationServiceDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl update()：修改BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessStationService
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessStationServiceDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceServiceImpl delete()：删除BusinessStationService发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
