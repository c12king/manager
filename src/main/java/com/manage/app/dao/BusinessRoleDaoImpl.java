package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRole;
import com.manage.app.vo.BusinessRoleQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleDao")
@Transactional
public class BusinessRoleDaoImpl implements BusinessRoleDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRole findById(final Integer id) throws DaoException {
		BusinessRole businessRole = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleDao.findById",id);
		return businessRole;
	}
	
	/**
	 * 无条件查询所有BusinessRole
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRole> findAll() throws DaoException {
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRole
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRole> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRole-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRole> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRole
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRole> findByExample(final BusinessRoleQuery query) throws DaoException {
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRole-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRole> findByExample(final BusinessRoleQuery query, final Integer limit) throws DaoException {
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRole> findAllPage(final BusinessRoleQuery query) throws DaoException {
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRole entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleDao.save",entity);
	}

	/**
	 * 修改BusinessRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRole entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleDao.update",entity);
	}

	/**
	 * 删除BusinessRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleDao.delete",id);
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
	public List<BusinessRole> findAllPageByField(final Map fieldMap, final BusinessRoleQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRole> findListByField(final Map fieldMap, final BusinessRoleQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRole> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRole findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRole businessRole = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleDao.findByField",paramMap);
		return businessRole;
	}
	
	/**
	 * 删除角色下的所有权限及菜单
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteMenuFunction(final Integer roleId) throws DaoException {
		int functionCount=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleDao.deleteRoleFunction",roleId);
		/*if(functionCount==0){
			return false;
		}*/
		int menuCount=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleDao.deleteRoleMenu",roleId);
		/*if(menuCount==0){
			return false;
		}*/
		return true;
	}
	
}
