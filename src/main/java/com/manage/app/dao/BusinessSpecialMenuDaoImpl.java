package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessSpecialMenu;
import com.manage.app.vo.BusinessSpecialMenuQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessSpecialMenuDao")
@Transactional
public class BusinessSpecialMenuDaoImpl implements BusinessSpecialMenuDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSpecialMenu findById(final Integer id) throws DaoException {
		BusinessSpecialMenu businessSpecialMenu = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessSpecialMenuDao.findById",id);
		return businessSpecialMenu;
	}
	
	/**
	 * 无条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialMenu> findAll() throws DaoException {
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialMenu> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessSpecialMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query) throws DaoException {
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query, final Integer limit) throws DaoException {
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSpecialMenu> findAllPage(final BusinessSpecialMenuQuery query) throws DaoException {
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessSpecialMenuQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessSpecialMenuDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessSpecialMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessSpecialMenu entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessSpecialMenuDao.save",entity);
	}

	/**
	 * 修改BusinessSpecialMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessSpecialMenu entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessSpecialMenuDao.update",entity);
	}

	/**
	 * 删除BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessSpecialMenuDao.delete",id);
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
	public List<BusinessSpecialMenu> findAllPageByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSpecialMenu> findListByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessSpecialMenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessSpecialMenuDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSpecialMenu findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessSpecialMenu businessSpecialMenu = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessSpecialMenuDao.findByField",paramMap);
		return businessSpecialMenu;
	}
	
}
