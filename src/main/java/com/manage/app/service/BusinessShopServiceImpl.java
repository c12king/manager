package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessShop;
import com.manage.app.dao.BusinessShopDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessShopQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessShopService")
@Transactional
public class BusinessShopServiceImpl implements BusinessShopService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessShopServiceImpl.class);
	@Autowired
	private BusinessShopDao businessShopDao;

	/**
	 * 查询单个BusinessShop
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessShop findById(final Integer id) throws ServiceException {
		BusinessShop businessShop = new BusinessShop();
		try {
			businessShop = businessShopDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findById()：查询单个BusinessShop发生错误！", e);
			e.printStackTrace();
		}
		return businessShop;
	}
	
	/**
	 * 无条件查询所有BusinessShop
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessShop> findAll() throws ServiceException {
		List<BusinessShop> list = new ArrayList<BusinessShop>() ;
		try {
			list=businessShopDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findAll()：无条件查询所有BusinessShop发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShop
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShop> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessShop> list = new ArrayList<BusinessShop>() ;
		try {
			list=businessShopDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findByMap()：按Map对象条件查询所有BusinessShop发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShop-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShop> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessShop> list = new ArrayList<BusinessShop>() ;
		try {
			list=businessShopDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findByMap()：按Map对象条件查询所有BusinessShop-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShop
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShop> findByExample(final BusinessShopQuery query) throws ServiceException {
		List<BusinessShop> list = new ArrayList<BusinessShop>() ;
		try {
			list=businessShopDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findByExample()：按VO对象条件查询所有BusinessShop发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShop-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShop> findByExample(final BusinessShopQuery query, final Integer limit) throws ServiceException {
		List<BusinessShop> list = new ArrayList<BusinessShop>() ;
		try {
			list=businessShopDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findByExample()：按VO对象条件查询所有BusinessShop-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessShopQuery query) throws ServiceException {
		List<BusinessShop> list = new ArrayList<BusinessShop>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessShopDao.findAllPage(query);
			count=businessShopDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessShopQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessShopDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessShop数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessShop entity) throws ServiceException {
		try {
			businessShopDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl save()：保存BusinessShop发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessShop数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessShop entity) throws ServiceException {
		try {
			businessShopDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl update()：修改BusinessShop发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessShop
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessShopDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopServiceImpl delete()：删除BusinessShop发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
