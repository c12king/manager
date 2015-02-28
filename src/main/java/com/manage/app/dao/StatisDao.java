package com.manage.app.dao;

import java.util.List;

import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

public interface StatisDao {

	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public List statisBySql(final String sql) throws DaoException;
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countBySql(final String sql) throws DaoException;
	
}
