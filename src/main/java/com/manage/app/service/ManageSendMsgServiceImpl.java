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

import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.framework.exception.DaoException;
import com.manage.app.vo.ManageSendMsgQuery;
import com.manage.app.bean.ManageHouse;
import com.manage.app.bean.ManageSendMsg;
import com.manage.app.dao.ManageSendMsgDao;
import com.utis.Page;

@Service("ManageSendMsgService")
@Transactional
public class ManageSendMsgServiceImpl implements ManageSendMsgService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageSendMsgServiceImpl.class);
	@Autowired
	private ManageSendMsgDao manageSendMsgDao;

	/**
	 * 查询单个ManageSendMsg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageSendMsg findById(final Integer id) throws ServiceException {
		ManageSendMsg manageSendMsg = new ManageSendMsg();
		try {
			manageSendMsg = manageSendMsgDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findById()：查询单个ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return manageSendMsg;
	}
	
	/**
	 * 无条件查询所有ManageSendMsg
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageSendMsg> findAll() throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findAll()：无条件查询所有ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageSendMsg> findByMap(final Map paramMap) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByMap()：按Map对象条件查询所有ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageSendMsg> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByMap()：按Map对象条件查询所有ManageSendMsg-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByExample()：按VO对象条件查询所有ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query, final Integer limit) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByExample()：按VO对象条件查询所有ManageSendMsg-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageSendMsgQuery query) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageSendMsgDao.findAllPage(query);
			count=manageSendMsgDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageSendMsgQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageSendMsgDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageSendMsg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageSendMsg entity) throws ServiceException {
		try {
			manageSendMsgDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl save()：保存ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageSendMsg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageSendMsg entity) throws ServiceException {
		try {
			manageSendMsgDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl update()：修改ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageSendMsg
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageSendMsgDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl delete()：删除ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}


	public Page findAllPage(Page page) throws GSSException {
		// TODO Auto-generated method stub
		int count = manageSendMsgDao.selectSendMsgCount(page);
		List<ManageSendMsg> list = manageSendMsgDao.SendMsgListData(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;

	}
	
	
	
//	public Page findAllPage(Page page) throws GSSException {
//		int count=buseinessTelDao.selectCount(page);
//		List<ManageHouse> list=buseinessTelDao.findAllPage(page);
//		page.setTotalRow(count);
//		page.setList(list);
//		return page;
//	}
	
}
