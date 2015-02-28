package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageTag;
import com.manage.app.dao.ManageTagDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.ManageTagQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("ManageTagService")
@Transactional
public class ManageTagServiceImpl implements ManageTagService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageTagServiceImpl.class);
	@Autowired
	private ManageTagDao manageTagDao;

	/**
	 * 查询单个ManageTag
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageTag findById(final Integer id) throws ServiceException {
		ManageTag manageTag = new ManageTag();
		try {
			manageTag = manageTagDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findById()：查询单个ManageTag发生错误！", e);
			e.printStackTrace();
		}
		return manageTag;
	}
	
	/**
	 * 无条件查询所有ManageTag
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageTag> findAll() throws ServiceException {
		List<ManageTag> list = new ArrayList<ManageTag>() ;
		try {
			list=manageTagDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findAll()：无条件查询所有ManageTag发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageTag
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageTag> findByMap(final Map paramMap) throws ServiceException {
		List<ManageTag> list = new ArrayList<ManageTag>() ;
		try {
			list=manageTagDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findByMap()：按Map对象条件查询所有ManageTag发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageTag-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageTag> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageTag> list = new ArrayList<ManageTag>() ;
		try {
			list=manageTagDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findByMap()：按Map对象条件查询所有ManageTag-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageTag
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageTag> findByExample(final ManageTagQuery query) throws ServiceException {
		List<ManageTag> list = new ArrayList<ManageTag>() ;
		try {
			list=manageTagDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findByExample()：按VO对象条件查询所有ManageTag发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageTag-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageTag> findByExample(final ManageTagQuery query, final Integer limit) throws ServiceException {
		List<ManageTag> list = new ArrayList<ManageTag>() ;
		try {
			list=manageTagDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findByExample()：按VO对象条件查询所有ManageTag-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageTagQuery query) throws ServiceException {
		List<ManageTag> list = new ArrayList<ManageTag>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageTagDao.findAllPage(query);
			count=manageTagDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageTagQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageTagDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageTag数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageTag entity) throws ServiceException {
		try {
			manageTagDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl save()：保存ManageTag发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageTag数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageTag entity) throws ServiceException {
		try {
			manageTagDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl update()：修改ManageTag发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageTag
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageTagDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageTagServiceImpl delete()：删除ManageTag发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
