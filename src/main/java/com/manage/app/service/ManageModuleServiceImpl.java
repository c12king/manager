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

import com.manage.app.vo.ManageModuleQuery;
import com.manage.app.bean.ManageModule;
import com.manage.app.dao.ManageModuleDao;

@Service("ManageModuleService")
@Transactional
public class ManageModuleServiceImpl implements ManageModuleService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageModuleServiceImpl.class);
	@Autowired
	private ManageModuleDao manageModuleDao;

	/**
	 * 查询单个ManageModule
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageModule findById(final Integer id) throws ServiceException {
		ManageModule manageModule = new ManageModule();
		try {
			manageModule = manageModuleDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findById()：查询单个ManageModule发生错误！", e);
			e.printStackTrace();
		}
		return manageModule;
	}
	
	/**
	 * 无条件查询所有ManageModule
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageModule> findAll() throws ServiceException {
		List<ManageModule> list = new ArrayList<ManageModule>() ;
		try {
			list=manageModuleDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findAll()：无条件查询所有ManageModule发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageModule
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageModule> findByMap(final Map paramMap) throws ServiceException {
		List<ManageModule> list = new ArrayList<ManageModule>() ;
		try {
			list=manageModuleDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findByMap()：按Map对象条件查询所有ManageModule发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageModule-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageModule> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageModule> list = new ArrayList<ManageModule>() ;
		try {
			list=manageModuleDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findByMap()：按Map对象条件查询所有ManageModule-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageModule
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageModule> findByExample(final ManageModuleQuery query) throws ServiceException {
		List<ManageModule> list = new ArrayList<ManageModule>() ;
		try {
			list=manageModuleDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findByExample()：按VO对象条件查询所有ManageModule发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageModule-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageModule> findByExample(final ManageModuleQuery query, final Integer limit) throws ServiceException {
		List<ManageModule> list = new ArrayList<ManageModule>() ;
		try {
			list=manageModuleDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findByExample()：按VO对象条件查询所有ManageModule-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final ManageModuleQuery query) throws ServiceException {
		List<ManageModule> list = new ArrayList<ManageModule>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageModuleDao.findAllPage(query);
			count=manageModuleDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageModuleQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageModuleDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageModule数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageModule entity) throws ServiceException {
		try {
			manageModuleDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl save()：保存ManageModule发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageModule数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageModule entity) throws ServiceException {
		try {
			manageModuleDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl update()：修改ManageModule发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageModule
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageModuleDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageModuleServiceImpl delete()：删除ManageModule发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
