package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleCommunity;
import com.manage.app.vo.BusinessRoleCommunityQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleCommunityDao")
@Transactional
public class BusinessRoleCommunityDaoImpl implements BusinessRoleCommunityDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRoleCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleCommunity findById(final Integer id) throws DaoException {
		BusinessRoleCommunity businessRoleCommunity = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleCommunityDao.findById",id);
		return businessRoleCommunity;
	}
	
	/**
	 * 无条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleCommunity> findAll() throws DaoException {
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query) throws DaoException {
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleCommunity> findByExample(final BusinessRoleCommunityQuery query, final Integer limit) throws DaoException {
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleCommunity> findAllPage(final BusinessRoleCommunityQuery query) throws DaoException {
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleCommunityQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleCommunityDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRoleCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleCommunity entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleCommunityDao.save",entity);
	}

	/**
	 * 修改BusinessRoleCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleCommunity entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleCommunityDao.update",entity);
	}

	/**
	 * 删除BusinessRoleCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleCommunityDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleCommunity> findAllPageByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleCommunity> findListByField(final Map fieldMap, final BusinessRoleCommunityQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleCommunity> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleCommunityDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleCommunity findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRoleCommunity businessRoleCommunity = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleCommunityDao.findByField",paramMap);
		return businessRoleCommunity;
	}
	
}
