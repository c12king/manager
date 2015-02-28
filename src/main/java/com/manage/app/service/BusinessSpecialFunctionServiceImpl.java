package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessSpecialFunction;
import com.manage.app.dao.BusinessSpecialFunctionDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessSpecialFunctionQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessSpecialFunctionService")
@Transactional
public class BusinessSpecialFunctionServiceImpl implements BusinessSpecialFunctionService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessSpecialFunctionServiceImpl.class);
	@Autowired
	private BusinessSpecialFunctionDao businessSpecialFunctionDao;

	/**
	 * 查询单个BusinessSpecialFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessSpecialFunction findById(final Integer id) throws ServiceException {
		BusinessSpecialFunction businessSpecialFunction = new BusinessSpecialFunction();
		try {
			businessSpecialFunction = businessSpecialFunctionDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findById()：查询单个BusinessSpecialFunction发生错误！", e);
			e.printStackTrace();
		}
		return businessSpecialFunction;
	}
	
	/**
	 * 无条件查询所有BusinessSpecialFunction
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessSpecialFunction> findAll() throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		try {
			list=businessSpecialFunctionDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findAll()：无条件查询所有BusinessSpecialFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialFunction
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessSpecialFunction> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		try {
			list=businessSpecialFunctionDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findByMap()：按Map对象条件查询所有BusinessSpecialFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialFunction-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessSpecialFunction> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		try {
			list=businessSpecialFunctionDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findByMap()：按Map对象条件查询所有BusinessSpecialFunction-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialFunction
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessSpecialFunction> findByExample(final BusinessSpecialFunctionQuery query) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		try {
			list=businessSpecialFunctionDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findByExample()：按VO对象条件查询所有BusinessSpecialFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialFunction-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessSpecialFunction> findByExample(final BusinessSpecialFunctionQuery query, final Integer limit) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		try {
			list=businessSpecialFunctionDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findByExample()：按VO对象条件查询所有BusinessSpecialFunction-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessSpecialFunctionQuery query) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessSpecialFunctionDao.selectCount(query);
			query.setCount(count);
			list=businessSpecialFunctionDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessSpecialFunctionQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessSpecialFunctionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessSpecialFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessSpecialFunction entity) throws ServiceException {
		try {
			businessSpecialFunctionDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl save()：保存BusinessSpecialFunction发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessSpecialFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessSpecialFunction entity) throws ServiceException {
		try {
			businessSpecialFunctionDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl update()：修改BusinessSpecialFunction发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessSpecialFunction
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessSpecialFunctionDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl delete()：删除BusinessSpecialFunction发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessSpecialFunctionQuery query) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessSpecialFunctionDao.selectCount(query);
			query.setCount(count);
			list=businessSpecialFunctionDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessSpecialFunctionQuery query) throws ServiceException {
		List<BusinessSpecialFunction> list = new ArrayList<BusinessSpecialFunction>() ;
		try {
			list=businessSpecialFunctionDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessSpecialFunction findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessSpecialFunction businessSpecialFunction = new BusinessSpecialFunction();
		try {
			businessSpecialFunction = businessSpecialFunctionDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessSpecialFunctionServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessSpecialFunction;
	}
	
}
