package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleEstate;
import com.manage.app.vo.BusinessRoleEstateQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleEstateDao")
@Transactional
public class BusinessRoleEstateDaoImpl implements BusinessRoleEstateDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRoleEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleEstate findById(final Integer id) throws DaoException {
		BusinessRoleEstate businessRoleEstate = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleEstateDao.findById",id);
		return businessRoleEstate;
	}
	
	/**
	 * 无条件查询所有BusinessRoleEstate
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleEstate> findAll() throws DaoException {
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRoleEstate
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleEstate> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleEstate-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleEstate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleEstate
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleEstate> findByExample(final BusinessRoleEstateQuery query) throws DaoException {
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleEstate-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleEstate> findByExample(final BusinessRoleEstateQuery query, final Integer limit) throws DaoException {
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleEstate> findAllPage(final BusinessRoleEstateQuery query) throws DaoException {
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleEstateQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleEstateDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRoleEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleEstate entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleEstateDao.save",entity);
	}

	/**
	 * 修改BusinessRoleEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleEstate entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleEstateDao.update",entity);
	}

	/**
	 * 删除BusinessRoleEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleEstateDao.delete",id);
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
	public List<BusinessRoleEstate> findAllPageByField(final Map fieldMap, final BusinessRoleEstateQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleEstate> findListByField(final Map fieldMap, final BusinessRoleEstateQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleEstate> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleEstateDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleEstate findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRoleEstate businessRoleEstate = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleEstateDao.findByField",paramMap);
		return businessRoleEstate;
	}
	
}
