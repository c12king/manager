package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.ManageAdmin;
import com.manage.app.vo.ManageAdminQuery;

@Repository("ManageAdminDao")
@Transactional
public class ManageAdminDaoImpl implements ManageAdminDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageAdmin
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageAdmin findById(final Integer id) throws DaoException {
		ManageAdmin manageAdmin = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageAdminDao.findById",id);
		return manageAdmin;
	}
	
	/**
	 * 无条件查询所有ManageAdmin
	 * @return
	 * @throws DaoException
	 */
	public List<ManageAdmin> findAll() throws DaoException {
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageAdmin
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageAdmin> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageAdmin-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageAdmin> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageAdmin
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageAdmin> findByExample(final ManageAdminQuery query) throws DaoException {
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageAdmin-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageAdmin> findByExample(final ManageAdminQuery query, final Integer limit) throws DaoException {
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageAdmin> findAllPage(final ManageAdminQuery query) throws DaoException {
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageAdminQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageAdminDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageAdmin数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageAdmin entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageAdminDao.save",entity);
	}

	/**
	 * 修改ManageAdmin数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageAdmin entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageAdminDao.update",entity);
	}

	/**
	 * 删除ManageAdmin
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageAdminDao.delete",id);
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
	public List<ManageAdmin> findAllPageByField(final Map fieldMap, final ManageAdminQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageAdmin> findListByField(final Map fieldMap, final ManageAdminQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<ManageAdmin> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageAdminDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageAdmin findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		ManageAdmin manageAdmin = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageAdminDao.findByField",paramMap);
		return manageAdmin;
	}
	
}
