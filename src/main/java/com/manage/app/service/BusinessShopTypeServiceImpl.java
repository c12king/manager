package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessShopType;
import com.manage.app.dao.BusinessShopTypeDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessShopTypeQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessShopTypeService")
@Transactional
public class BusinessShopTypeServiceImpl implements BusinessShopTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessShopTypeServiceImpl.class);
	@Autowired
	private BusinessShopTypeDao businessShopTypeDao;

	/**
	 * 查询单个BusinessShopType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessShopType findById(final Integer id) throws ServiceException {
		BusinessShopType businessShopType = new BusinessShopType();
		try {
			businessShopType = businessShopTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findById()：查询单个BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
		return businessShopType;
	}
	
	/**
	 * 无条件查询所有BusinessShopType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessShopType> findAll() throws ServiceException {
		List<BusinessShopType> list = new ArrayList<BusinessShopType>() ;
		try {
			list=businessShopTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findAll()：无条件查询所有BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopType> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessShopType> list = new ArrayList<BusinessShopType>() ;
		try {
			list=businessShopTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessShopType> list = new ArrayList<BusinessShopType>() ;
		try {
			list=businessShopTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessShopType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query) throws ServiceException {
		List<BusinessShopType> list = new ArrayList<BusinessShopType>() ;
		try {
			list=businessShopTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query, final Integer limit) throws ServiceException {
		List<BusinessShopType> list = new ArrayList<BusinessShopType>() ;
		try {
			list=businessShopTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessShopType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessShopTypeQuery query) throws ServiceException {
		List<BusinessShopType> list = new ArrayList<BusinessShopType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessShopTypeDao.findAllPage(query);
			count=businessShopTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessShopTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessShopTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessShopType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessShopType entity) throws ServiceException {
		try {
			businessShopTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl save()：保存BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessShopType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessShopType entity) throws ServiceException {
		try {
			businessShopTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl update()：修改BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessShopType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessShopTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopTypeServiceImpl delete()：删除BusinessShopType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
