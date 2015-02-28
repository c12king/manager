package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessStationService;
import com.manage.app.vo.BusinessStationServiceQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessStationServiceDao")
@Transactional
public class BusinessStationServiceDaoImpl implements BusinessStationServiceDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessStationService
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationService findById(final Integer id) throws DaoException {
		BusinessStationService businessStationService = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessStationServiceDao.findById",id);
		return businessStationService;
	}
	
	/**
	 * 无条件查询所有BusinessStationService
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationService> findAll() throws DaoException {
		List<BusinessStationService> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationServiceDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessStationService
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationService> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessStationService> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationServiceDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationService-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationService> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessStationService> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationServiceDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationService
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query) throws DaoException {
		List<BusinessStationService> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationServiceDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationService-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationService> findByExample(final BusinessStationServiceQuery query, final Integer limit) throws DaoException {
		List<BusinessStationService> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationServiceDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationService> findAllPage(final BusinessStationServiceQuery query) throws DaoException {
		List<BusinessStationService> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationServiceDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationServiceQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessStationServiceDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessStationService数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationService entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessStationServiceDao.save",entity);
	}

	/**
	 * 修改BusinessStationService数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationService entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessStationServiceDao.update",entity);
	}

	/**
	 * 删除BusinessStationService
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessStationServiceDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
