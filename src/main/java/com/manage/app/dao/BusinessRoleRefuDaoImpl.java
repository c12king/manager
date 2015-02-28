package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleRefu;
import com.manage.app.vo.BusinessRoleRefuQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleRefuDao")
@Transactional
public class BusinessRoleRefuDaoImpl implements BusinessRoleRefuDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRoleRefu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleRefu findById(final Integer id) throws DaoException {
		BusinessRoleRefu businessRoleRefu = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleRefuDao.findById",id);
		return businessRoleRefu;
	}
	
	/**
	 * 无条件查询所有BusinessRoleRefu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleRefu> findAll() throws DaoException {
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRoleRefu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleRefu> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleRefu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleRefu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleRefu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleRefu> findByExample(final BusinessRoleRefuQuery query) throws DaoException {
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleRefu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleRefu> findByExample(final BusinessRoleRefuQuery query, final Integer limit) throws DaoException {
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleRefu> findAllPage(final BusinessRoleRefuQuery query) throws DaoException {
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleRefuQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleRefuDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRoleRefu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleRefu entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleRefuDao.save",entity);
	}

	/**
	 * 修改BusinessRoleRefu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleRefu entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleRefuDao.update",entity);
	}

	/**
	 * 删除BusinessRoleRefu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleRefuDao.delete",id);
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
	public List<BusinessRoleRefu> findAllPageByField(final Map fieldMap, final BusinessRoleRefuQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleRefu> findListByField(final Map fieldMap, final BusinessRoleRefuQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleRefu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleRefuDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleRefu findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRoleRefu businessRoleRefu = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleRefuDao.findByField",paramMap);
		return businessRoleRefu;
	}
	
}
