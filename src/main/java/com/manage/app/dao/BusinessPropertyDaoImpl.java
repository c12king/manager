package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessProperty;
import com.manage.app.vo.BusinessPropertyQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessPropertyDao")
@Transactional
public class BusinessPropertyDaoImpl implements BusinessPropertyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProperty findById(final Integer id) throws DaoException {
		BusinessProperty businessProperty = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessPropertyDao.findByIdOrgName",id);
		return businessProperty;
	}
	
	/**
	 * 无条件查询所有BusinessProperty
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProperty> findAll() throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProperty
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProperty-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProperty
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query) throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProperty-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query, final Integer limit) throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProperty> findAllPage(final BusinessPropertyQuery query) throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPropertyQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessPropertyDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProperty entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessPropertyDao.save",entity);
	}

	/**
	 * 修改BusinessProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProperty entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessPropertyDao.update",entity);
	}

	/**
	 * 删除BusinessProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessPropertyDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 获取该区域下物业下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public List<BusinessProperty> getComboboxData(final Integer id) throws DaoException {
		List<BusinessProperty> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.getComboboxData",id);
		return list;
	}
	
}
