package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleFunction;
import com.manage.app.vo.BusinessRoleFunctionQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleFunctionDao")
@Transactional
public class BusinessRoleFunctionDaoImpl implements BusinessRoleFunctionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRoleFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleFunction findById(final Integer id) throws DaoException {
		BusinessRoleFunction businessRoleFunction = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleFunctionDao.findById",id);
		return businessRoleFunction;
	}
	
	/**
	 * 无条件查询所有BusinessRoleFunction
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleFunction> findAll() throws DaoException {
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRoleFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleFunction> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query) throws DaoException {
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query, final Integer limit) throws DaoException {
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleFunction> findAllPage(final BusinessRoleFunctionQuery query) throws DaoException {
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleFunctionQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleFunctionDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRoleFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleFunction entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleFunctionDao.save",entity);
	}

	/**
	 * 修改BusinessRoleFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleFunction entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleFunctionDao.update",entity);
	}

	/**
	 * 删除BusinessRoleFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleFunctionDao.delete",id);
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
	public List<BusinessRoleFunction> findAllPageByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleFunction> findListByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleFunctionDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleFunction findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRoleFunction businessRoleFunction = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleFunctionDao.findByField",paramMap);
		return businessRoleFunction;
	}
	
}
