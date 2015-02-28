package com.manage.app.service;

import java.util.List;

import com.manage.framework.exception.ServiceException;

public interface StatisService {
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public List statisBySql(final String sql) throws ServiceException;
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countBySql(final String sql) throws ServiceException;
}
