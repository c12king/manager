package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessUserRole;
import com.manage.app.vo.BusinessUserRoleQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessUserRoleDao")
@Transactional
public class BusinessUserRoleDaoImpl implements BusinessUserRoleDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessUserRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserRole findById(final Integer id) throws DaoException {
		BusinessUserRole businessUserRole = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessUserRoleDao.findById",id);
		return businessUserRole;
	}
	
	/**
	 * 无条件查询所有BusinessUserRole
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserRole> findAll() throws DaoException {
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessUserRole
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserRole> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserRole-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserRole> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserRole
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserRole> findByExample(final BusinessUserRoleQuery query) throws DaoException {
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserRole-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserRole> findByExample(final BusinessUserRoleQuery query, final Integer limit) throws DaoException {
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserRole> findAllPage(final BusinessUserRoleQuery query) throws DaoException {
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserRoleQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessUserRoleDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessUserRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserRole entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessUserRoleDao.save",entity);
	}

	/**
	 * 修改BusinessUserRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserRole entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessUserRoleDao.update",entity);
	}

	/**
	 * 删除BusinessUserRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessUserRoleDao.delete",id);
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
	public List<BusinessUserRole> findAllPageByField(final Map fieldMap, final BusinessUserRoleQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserRole> findListByField(final Map fieldMap, final BusinessUserRoleQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessUserRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessUserRoleDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserRole findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessUserRole businessUserRole = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessUserRoleDao.findByField",paramMap);
		return businessUserRole;
	}
	
}
