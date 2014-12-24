package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.framework.exception.DaoException;

import com.manage.app.vo.ManageOrgExpressQuery;
import com.manage.app.bean.ManageOrgExpress;
import com.manage.app.dao.ManageOrgExpressDao;

@Service("ManageOrgExpressService")
@Transactional
public class ManageOrgExpressServiceImpl implements ManageOrgExpressService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageOrgExpressServiceImpl.class);
	@Autowired
	private ManageOrgExpressDao manageOrgExpressDao;

	/**
	 * 查询单个ManageOrgExpress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageOrgExpress findById(final Integer id) throws ServiceException {
		ManageOrgExpress manageOrgExpress = new ManageOrgExpress();
		try {
			manageOrgExpress = manageOrgExpressDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findById()：查询单个ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
		return manageOrgExpress;
	}
	
	/**
	 * 无条件查询所有ManageOrgExpress
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageOrgExpress> findAll() throws ServiceException {
		List<ManageOrgExpress> list = new ArrayList<ManageOrgExpress>() ;
		try {
			list=manageOrgExpressDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findAll()：无条件查询所有ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageOrgExpress
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageOrgExpress> findByMap(final Map paramMap) throws ServiceException {
		List<ManageOrgExpress> list = new ArrayList<ManageOrgExpress>() ;
		try {
			list=manageOrgExpressDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findByMap()：按Map对象条件查询所有ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageOrgExpress-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageOrgExpress> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageOrgExpress> list = new ArrayList<ManageOrgExpress>() ;
		try {
			list=manageOrgExpressDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findByMap()：按Map对象条件查询所有ManageOrgExpress-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageOrgExpress
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query) throws ServiceException {
		List<ManageOrgExpress> list = new ArrayList<ManageOrgExpress>() ;
		try {
			list=manageOrgExpressDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findByExample()：按VO对象条件查询所有ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageOrgExpress-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query, final Integer limit) throws ServiceException {
		List<ManageOrgExpress> list = new ArrayList<ManageOrgExpress>() ;
		try {
			list=manageOrgExpressDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findByExample()：按VO对象条件查询所有ManageOrgExpress-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageOrgExpressQuery query) throws ServiceException {
		List<ManageOrgExpress> list = new ArrayList<ManageOrgExpress>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageOrgExpressDao.findAllPage(query);
			count=manageOrgExpressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageOrgExpressQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageOrgExpressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageOrgExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageOrgExpress entity) throws ServiceException {
		try {
			manageOrgExpressDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl save()：保存ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageOrgExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageOrgExpress entity) throws ServiceException {
		try {
			manageOrgExpressDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl update()：修改ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageOrgExpress
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageOrgExpressDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageOrgExpressServiceImpl delete()：删除ManageOrgExpress发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
