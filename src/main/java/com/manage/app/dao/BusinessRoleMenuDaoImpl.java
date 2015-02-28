package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleMenu;
import com.manage.app.vo.BusinessRoleMenuQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessRoleMenuDao")
@Transactional
public class BusinessRoleMenuDaoImpl implements BusinessRoleMenuDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRoleMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleMenu findById(final Integer id) throws DaoException {
		BusinessRoleMenu businessRoleMenu = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleMenuDao.findById",id);
		return businessRoleMenu;
	}
	
	/**
	 * 无条件查询所有BusinessRoleMenu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleMenu> findAll() throws DaoException {
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRoleMenu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleMenu> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleMenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query) throws DaoException {
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRoleMenu> findByExample(final BusinessRoleMenuQuery query, final Integer limit) throws DaoException {
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRoleMenu> findAllPage(final BusinessRoleMenuQuery query) throws DaoException {
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleMenuQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleMenuDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRoleMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRoleMenu entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessRoleMenuDao.save",entity);
	}

	/**
	 * 修改BusinessRoleMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRoleMenu entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessRoleMenuDao.update",entity);
	}

	/**
	 * 删除BusinessRoleMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessRoleMenuDao.delete",id);
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
	public List<BusinessRoleMenu> findAllPageByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRoleMenu> findListByField(final Map fieldMap, final BusinessRoleMenuQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessRoleMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessRoleMenuDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRoleMenu findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessRoleMenu businessRoleMenu = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessRoleMenuDao.findByField",paramMap);
		return businessRoleMenu;
	}
	
}
