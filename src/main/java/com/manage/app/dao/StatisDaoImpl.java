package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.framework.exception.DaoException;

@Repository("StatisDao")
@Transactional
public class StatisDaoImpl implements StatisDao {
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	public List statisBySql(String sql) throws DaoException {
		return this.sqlSessionTemplate.selectList("com.manage.app.dao.StatisDao.statisBySql",sql);
	}
	
	
	public Integer countBySql(final String sql) throws DaoException {
		return this.sqlSessionTemplate.selectOne("com.manage.app.dao.StatisDao.countBySql",sql);
	}

}
