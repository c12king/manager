package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageTagType;
import com.manage.app.dao.ManageTagTypeDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageTagTypeQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("ManageTagTypeService")
@Transactional
public class ManageTagTypeServiceImpl implements ManageTagTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageTagTypeServiceImpl.class);
	@Autowired
	private ManageTagTypeDao manageTagTypeDao;

	/**
	 * 查询单个ManageTagType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageTagType findById(final Integer id) throws ServiceException {
		ManageTagType manageTagType = new ManageTagType();
		try {
			manageTagType = manageTagTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findById()：查询单个ManageTagType发生错误！", e);
			e.printStackTrace();
		}
		return manageTagType;
	}
	
	/**
	 * 无条件查询所有ManageTagType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageTagType> findAll() throws ServiceException {
		List<ManageTagType> list = new ArrayList<ManageTagType>() ;
		try {
			list=manageTagTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findAll()：无条件查询所有ManageTagType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageTagType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageTagType> findByMap(final Map paramMap) throws ServiceException {
		List<ManageTagType> list = new ArrayList<ManageTagType>() ;
		try {
			list=manageTagTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findByMap()：按Map对象条件查询所有ManageTagType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageTagType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageTagType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageTagType> list = new ArrayList<ManageTagType>() ;
		try {
			list=manageTagTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findByMap()：按Map对象条件查询所有ManageTagType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageTagType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageTagType> findByExample(final ManageTagTypeQuery query) throws ServiceException {
		List<ManageTagType> list = new ArrayList<ManageTagType>() ;
		try {
			list=manageTagTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findByExample()：按VO对象条件查询所有ManageTagType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageTagType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageTagType> findByExample(final ManageTagTypeQuery query, final Integer limit) throws ServiceException {
		List<ManageTagType> list = new ArrayList<ManageTagType>() ;
		try {
			list=manageTagTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findByExample()：按VO对象条件查询所有ManageTagType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageTagTypeQuery query) throws ServiceException {
		List<ManageTagType> list = new ArrayList<ManageTagType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageTagTypeDao.findAllPage(query);
			count=manageTagTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageTagTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageTagTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageTagType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageTagType entity) throws ServiceException {
		try {
			manageTagTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl save()：保存ManageTagType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageTagType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageTagType entity) throws ServiceException {
		try {
			manageTagTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl update()：修改ManageTagType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageTagType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageTagTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageTagTypeServiceImpl delete()：删除ManageTagType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
