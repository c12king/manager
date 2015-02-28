package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageTagType;
import com.manage.app.vo.ManageTagTypeQuery;
import com.manage.framework.exception.DaoException;

@Repository("ManageTagTypeDao")
@Transactional
public class ManageTagTypeDaoImpl implements ManageTagTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageTagType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageTagType findById(final Integer id) throws DaoException {
		ManageTagType manageTagType = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageTagTypeDao.findById",id);
		return manageTagType;
	}
	
	/**
	 * 无条件查询所有ManageTagType
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTagType> findAll() throws DaoException {
		List<ManageTagType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageTagType
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTagType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageTagType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageTagType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageTagType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageTagType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageTagType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTagType> findByExample(final ManageTagTypeQuery query) throws DaoException {
		List<ManageTagType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageTagType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageTagType> findByExample(final ManageTagTypeQuery query, final Integer limit) throws DaoException {
		List<ManageTagType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTagType> findAllPage(final ManageTagTypeQuery query) throws DaoException {
		List<ManageTagType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageTagTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageTagTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageTagType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageTagType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageTagTypeDao.save",entity);
	}

	/**
	 * 修改ManageTagType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageTagType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageTagTypeDao.update",entity);
	}

	/**
	 * 删除ManageTagType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageTagTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
