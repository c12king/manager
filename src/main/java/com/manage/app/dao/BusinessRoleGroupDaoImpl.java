package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleGroup;
import com.manage.app.vo.BusinessRoleGroupQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleGroupDao")
@Transactional
public class BusinessRoleGroupDaoImpl implements BusinessRoleGroupDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRoleGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleGroup findById(final Integer id) throws DaoException {
		BusinessRoleGroup businessRoleGroup = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleGroupDao.findById",id);
		return businessRoleGroup;
	}
	
	/**
	 * 无条件查询所有BusinessRoleGroup
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleGroup> findAll() throws DaoException {
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRoleGroup
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleGroup> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleGroup-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleGroup> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleGroup
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleGroup> findByExample(final BusinessRoleGroupQuery query) throws DaoException {
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleGroup-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleGroup> findByExample(final BusinessRoleGroupQuery query, final Integer limit) throws DaoException {
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleGroup> findAllPage(final BusinessRoleGroupQuery query) throws DaoException {
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleGroupQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleGroupDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRoleGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleGroup entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleGroupDao.save",entity);
	}

	/**
	 * 修改BusinessRoleGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleGroup entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleGroupDao.update",entity);
	}

	/**
	 * 删除BusinessRoleGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleGroupDao.delete",id);
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
	public List<BusinessRoleGroup> findAllPageByField(final Map fieldMap, final BusinessRoleGroupQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleGroup> findListByField(final Map fieldMap, final BusinessRoleGroupQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleGroupDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleGroup findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRoleGroup businessRoleGroup = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleGroupDao.findByField",paramMap);
		return businessRoleGroup;
	}
	
}
