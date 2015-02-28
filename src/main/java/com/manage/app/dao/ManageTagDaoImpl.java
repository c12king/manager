package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageTag;
import com.manage.app.vo.ManageTagQuery;
import com.manage.framework.exception.DaoException;

@Repository("ManageTagDao")
@Transactional
public class ManageTagDaoImpl implements ManageTagDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageTag
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageTag findById(final Integer id) throws DaoException {
		ManageTag manageTag = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageTagDao.findById",id);
		return manageTag;
	}
	
	/**
	 * 无条件查询所有ManageTag
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTag> findAll() throws DaoException {
		List<ManageTag> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageTag
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTag> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageTag> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageTag-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageTag> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageTag> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageTag
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageTag> findByExample(final ManageTagQuery query) throws DaoException {
		List<ManageTag> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageTag-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageTag> findByExample(final ManageTagQuery query, final Integer limit) throws DaoException {
		List<ManageTag> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageTag> findAllPage(final ManageTagQuery query) throws DaoException {
		List<ManageTag> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageTagDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageTagQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageTagDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageTag数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageTag entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageTagDao.save",entity);
	}

	/**
	 * 修改ManageTag数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageTag entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageTagDao.update",entity);
	}

	/**
	 * 删除ManageTag
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageTagDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
