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

import com.manage.app.vo.ManageExpressFeeQuery;
import com.manage.app.bean.ManageExpressFee;
import com.manage.app.dao.ManageExpressFeeDao;

@Service("ManageExpressFeeService")
@Transactional
public class ManageExpressFeeServiceImpl implements ManageExpressFeeService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageExpressFeeServiceImpl.class);
	@Autowired
	private ManageExpressFeeDao manageExpressFeeDao;

	/**
	 * 查询单个ManageExpressFee
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageExpressFee findById(final Integer id) throws ServiceException {
		ManageExpressFee manageExpressFee = new ManageExpressFee();
		try {
			manageExpressFee = manageExpressFeeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findById()：查询单个ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
		return manageExpressFee;
	}
	
	/**
	 * 无条件查询所有ManageExpressFee
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageExpressFee> findAll() throws ServiceException {
		List<ManageExpressFee> list = new ArrayList<ManageExpressFee>() ;
		try {
			list=manageExpressFeeDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findAll()：无条件查询所有ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpressFee
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageExpressFee> findByMap(final Map paramMap) throws ServiceException {
		List<ManageExpressFee> list = new ArrayList<ManageExpressFee>() ;
		try {
			list=manageExpressFeeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findByMap()：按Map对象条件查询所有ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpressFee-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageExpressFee> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageExpressFee> list = new ArrayList<ManageExpressFee>() ;
		try {
			list=manageExpressFeeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findByMap()：按Map对象条件查询所有ManageExpressFee-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageExpressFee
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query) throws ServiceException {
		List<ManageExpressFee> list = new ArrayList<ManageExpressFee>() ;
		try {
			list=manageExpressFeeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findByExample()：按VO对象条件查询所有ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpressFee-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query, final Integer limit) throws ServiceException {
		List<ManageExpressFee> list = new ArrayList<ManageExpressFee>() ;
		try {
			list=manageExpressFeeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findByExample()：按VO对象条件查询所有ManageExpressFee-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageExpressFeeQuery query) throws ServiceException {
		List<ManageExpressFee> list = new ArrayList<ManageExpressFee>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageExpressFeeDao.findAllPage(query);
			count=manageExpressFeeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageExpressFeeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageExpressFeeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageExpressFee数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageExpressFee entity) throws ServiceException {
		try {
			manageExpressFeeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl save()：保存ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageExpressFee数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageExpressFee entity) throws ServiceException {
		try {
			manageExpressFeeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl update()：修改ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageExpressFee
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageExpressFeeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageExpressFeeServiceImpl delete()：删除ManageExpressFee发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
