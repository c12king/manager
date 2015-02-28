package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleEstate;
import com.manage.app.dao.BusinessRoleEstateDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleEstateQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleEstateService")
@Transactional
public class BusinessRoleEstateServiceImpl implements BusinessRoleEstateService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleEstateServiceImpl.class);
	@Autowired
	private BusinessRoleEstateDao businessRoleEstateDao;

	/**
	 * 查询单个BusinessRoleEstate
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleEstate findById(final Integer id) throws ServiceException {
		BusinessRoleEstate businessRoleEstate = new BusinessRoleEstate();
		try {
			businessRoleEstate = businessRoleEstateDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findById()：查询单个BusinessRoleEstate发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleEstate;
	}
	
	/**
	 * 无条件查询所有BusinessRoleEstate
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRoleEstate> findAll() throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		try {
			list=businessRoleEstateDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findAll()：无条件查询所有BusinessRoleEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleEstate
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleEstate> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		try {
			list=businessRoleEstateDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleEstate-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleEstate> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		try {
			list=businessRoleEstateDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleEstate-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleEstate
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleEstate> findByExample(final BusinessRoleEstateQuery query) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		try {
			list=businessRoleEstateDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleEstate-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleEstate> findByExample(final BusinessRoleEstateQuery query, final Integer limit) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		try {
			list=businessRoleEstateDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleEstate-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRoleEstateQuery query) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleEstateDao.selectCount(query);
			query.setCount(count);
			list=businessRoleEstateDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRoleEstateQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleEstateDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRoleEstate数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRoleEstate entity) throws ServiceException {
		try {
			businessRoleEstateDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl save()：保存BusinessRoleEstate发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRoleEstate数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRoleEstate entity) throws ServiceException {
		try {
			businessRoleEstateDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl update()：修改BusinessRoleEstate发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRoleEstate
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleEstateDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl delete()：删除BusinessRoleEstate发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleEstateQuery query) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleEstateDao.selectCount(query);
			query.setCount(count);
			list=businessRoleEstateDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessRoleEstateQuery query) throws ServiceException {
		List<BusinessRoleEstate> list = new ArrayList<BusinessRoleEstate>() ;
		try {
			list=businessRoleEstateDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessRoleEstate findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRoleEstate businessRoleEstate = new BusinessRoleEstate();
		try {
			businessRoleEstate = businessRoleEstateDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleEstateServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleEstate;
	}
	
}
