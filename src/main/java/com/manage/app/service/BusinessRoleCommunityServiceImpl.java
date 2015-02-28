package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleCommunity;
import com.manage.app.dao.BusinessRoleCommunityDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleCommunityQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleCommunityService")
@Transactional
public class BusinessRoleCommunityServiceImpl implements BusinessRoleCommunityService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleCommunityServiceImpl.class);
	@Autowired
	private BusinessRoleCommunityDao businessRoleCommunityDao;

	/**
	 * 查询单个BusinessRoleCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleCommunity findById(final Integer id) throws ServiceException {
		BusinessRoleCommunity businessRoleCommunity = new BusinessRoleCommunity();
		try {
			businessRoleCommunity = businessRoleCommunityDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findById()：查询单个BusinessRoleCommunity发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleCommunity;
	}
	
	/**
	 * 无条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRoleCommunity> findAll() throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		try {
			list=businessRoleCommunityDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findAll()：无条件查询所有BusinessRoleCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleCommunity> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		try {
			list=businessRoleCommunityDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleCommunity> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		try {
			list=businessRoleCommunityDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleCommunity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		try {
			list=businessRoleCommunityDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query, final Integer limit) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		try {
			list=businessRoleCommunityDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleCommunity-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRoleCommunityQuery query) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleCommunityDao.selectCount(query);
			query.setCount(count);
			list=businessRoleCommunityDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRoleCommunityQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleCommunityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRoleCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRoleCommunity entity) throws ServiceException {
		try {
			businessRoleCommunityDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl save()：保存BusinessRoleCommunity发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRoleCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRoleCommunity entity) throws ServiceException {
		try {
			businessRoleCommunityDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl update()：修改BusinessRoleCommunity发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRoleCommunity
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleCommunityDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl delete()：删除BusinessRoleCommunity发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleCommunityDao.selectCount(query);
			query.setCount(count);
			list=businessRoleCommunityDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws ServiceException {
		List<BusinessRoleCommunity> list = new ArrayList<BusinessRoleCommunity>() ;
		try {
			list=businessRoleCommunityDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessRoleCommunity findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRoleCommunity businessRoleCommunity = new BusinessRoleCommunity();
		try {
			businessRoleCommunity = businessRoleCommunityDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleCommunityServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleCommunity;
	}
	
}
