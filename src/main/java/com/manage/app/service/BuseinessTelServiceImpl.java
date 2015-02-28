package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BuseinessTel;
import com.manage.app.bean.ManageHouse;
import com.manage.app.dao.BuseinessTelDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BuseinessTelQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;

@Service("BuseinessTelService")
@Transactional
public class BuseinessTelServiceImpl implements BuseinessTelService {
	
	private static Logger logger = LoggerFactory.getLogger(BuseinessTelServiceImpl.class);
	@Autowired
	private BuseinessTelDao buseinessTelDao;

	/**
	 * 查询单个BuseinessTel
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BuseinessTel findById(final Integer id) throws ServiceException {
		BuseinessTel buseinessTel = new BuseinessTel();
		try {
			buseinessTel = buseinessTelDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findById()：查询单个BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
		return buseinessTel;
	}
	
	/**
	 * 无条件查询所有BuseinessTel
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BuseinessTel> findAll() throws ServiceException {
		List<BuseinessTel> list = new ArrayList<BuseinessTel>() ;
		try {
			list=buseinessTelDao.findAll();
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findAll()：无条件查询所有BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BuseinessTel
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BuseinessTel> findByMap(final Map paramMap) throws ServiceException {
		List<BuseinessTel> list = new ArrayList<BuseinessTel>() ;
		try {
			list=buseinessTelDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findByMap()：按Map对象条件查询所有BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BuseinessTel-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BuseinessTel> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BuseinessTel> list = new ArrayList<BuseinessTel>() ;
		try {
			list=buseinessTelDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findByMap()：按Map对象条件查询所有BuseinessTel-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BuseinessTel
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BuseinessTel> findByExample(final BuseinessTelQuery query) throws ServiceException {
		List<BuseinessTel> list = new ArrayList<BuseinessTel>() ;
		try {
			list=buseinessTelDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findByExample()：按VO对象条件查询所有BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BuseinessTel-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BuseinessTel> findByExample(final BuseinessTelQuery query, final Integer limit) throws ServiceException {
		List<BuseinessTel> list = new ArrayList<BuseinessTel>() ;
		try {
			list=buseinessTelDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findByExample()：按VO对象条件查询所有BuseinessTel-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BuseinessTelQuery query) throws ServiceException {
		List<BuseinessTel> list = new ArrayList<BuseinessTel>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=buseinessTelDao.findAllPage(query);
			count=buseinessTelDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BuseinessTelQuery query) throws ServiceException {
		int count = 0;
		try {
			count = buseinessTelDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BuseinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BuseinessTel entity) throws ServiceException {
		try {
			buseinessTelDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl save()：保存BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BuseinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BuseinessTel entity) throws ServiceException {
		try {
			buseinessTelDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl update()：修改BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BuseinessTel
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return buseinessTelDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BuseinessTelServiceImpl delete()：删除BuseinessTel发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	public Page findAllPage(Page page) throws GSSException {
		int count=buseinessTelDao.selectCount(page);
		List<ManageHouse> list=buseinessTelDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
}
