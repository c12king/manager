package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageAdmin;
import com.manage.app.dao.ManageAdminDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageAdminQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("ManageAdminService")
@Transactional
public class ManageAdminServiceImpl implements ManageAdminService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageAdminServiceImpl.class);
	@Autowired
	private ManageAdminDao manageAdminDao;

	/**
	 * 查询单个ManageAdmin
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageAdmin findById(final Integer id) throws ServiceException {
		ManageAdmin manageAdmin = new ManageAdmin();
		try {
			manageAdmin = manageAdminDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findById()：查询单个ManageAdmin发生错误！", e);
			e.printStackTrace();
		}
		return manageAdmin;
	}
	
	/**
	 * 无条件查询所有ManageAdmin
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageAdmin> findAll() throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		try {
			list=manageAdminDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findAll()：无条件查询所有ManageAdmin发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageAdmin
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageAdmin> findByMap(final Map paramMap) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		try {
			list=manageAdminDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findByMap()：按Map对象条件查询所有ManageAdmin发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageAdmin-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageAdmin> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		try {
			list=manageAdminDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findByMap()：按Map对象条件查询所有ManageAdmin-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageAdmin
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageAdmin> findByExample(final ManageAdminQuery query) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		try {
			list=manageAdminDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findByExample()：按VO对象条件查询所有ManageAdmin发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageAdmin-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageAdmin> findByExample(final ManageAdminQuery query, final Integer limit) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		try {
			list=manageAdminDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findByExample()：按VO对象条件查询所有ManageAdmin-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageAdminQuery query) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=manageAdminDao.selectCount(query);
			query.setCount(count);
			list=manageAdminDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageAdminQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageAdminDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageAdmin数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageAdmin entity) throws ServiceException {
		try {
			manageAdminDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl save()：保存ManageAdmin发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageAdmin数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageAdmin entity) throws ServiceException {
		try {
			manageAdminDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl update()：修改ManageAdmin发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageAdmin
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageAdminDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl delete()：删除ManageAdmin发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final ManageAdminQuery query) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=manageAdminDao.selectCount(query);
			query.setCount(count);
			list=manageAdminDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final ManageAdminQuery query) throws ServiceException {
		List<ManageAdmin> list = new ArrayList<ManageAdmin>() ;
		try {
			list=manageAdminDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public ManageAdmin findByField(final Map fieldMap, final Integer id) throws ServiceException {
		ManageAdmin manageAdmin = new ManageAdmin();
		try {
			manageAdmin = manageAdminDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("ManageAdminServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return manageAdmin;
	}
	
}
