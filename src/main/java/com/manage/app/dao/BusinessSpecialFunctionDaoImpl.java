package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessSpecialFunction;
import com.manage.app.vo.BusinessSpecialFunctionQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessSpecialFunctionDao")
@Transactional
public class BusinessSpecialFunctionDaoImpl implements BusinessSpecialFunctionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessSpecialFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSpecialFunction findById(final Integer id) throws DaoException {
		BusinessSpecialFunction businessSpecialFunction = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessSpecialFunctionDao.findById",id);
		return businessSpecialFunction;
	}
	
	/**
	 * 无条件查询所有BusinessSpecialFunction
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialFunction> findAll() throws DaoException {
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessSpecialFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialFunction> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessSpecialFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialFunction> findByExample(final BusinessSpecialFunctionQuery query) throws DaoException {
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessSpecialFunction> findByExample(final BusinessSpecialFunctionQuery query, final Integer limit) throws DaoException {
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialFunction> findAllPage(final BusinessSpecialFunctionQuery query) throws DaoException {
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessSpecialFunctionQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessSpecialFunctionDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessSpecialFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessSpecialFunction entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessSpecialFunctionDao.save",entity);
	}

	/**
	 * 修改BusinessSpecialFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessSpecialFunction entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessSpecialFunctionDao.update",entity);
	}

	/**
	 * 删除BusinessSpecialFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessSpecialFunctionDao.delete",id);
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
	public List<BusinessSpecialFunction> findAllPageByField(final Map fieldMap, final BusinessSpecialFunctionQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialFunction> findListByField(final Map fieldMap, final BusinessSpecialFunctionQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessSpecialFunction> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialFunctionDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSpecialFunction findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessSpecialFunction businessSpecialFunction = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessSpecialFunctionDao.findByField",paramMap);
		return businessSpecialFunction;
	}
	
}
