package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.dao.StatisDao;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("StatisService")
@Transactional
public class StatisServiceImpl implements StatisService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserServiceImpl.class);
	@Autowired
	private StatisDao statisDao;
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 * @throws  
	 */
	@Transactional(readOnly = true)
	public List statisBySql(final String sql) throws ServiceException {
		List list = new ArrayList();
		try {
			list = statisDao.statisBySql(sql);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 * @throws  
	 */
	@Transactional(readOnly = true)
	public Integer countBySql(final String sql) throws ServiceException {
		Integer count = 0;
		try {
			count = statisDao.countBySql(sql);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
