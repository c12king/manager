package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessTelGroup;
import com.manage.app.vo.BusinessTelGroupQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessTelGroupDao")
@Transactional
public class BusinessTelGroupDaoImpl implements BusinessTelGroupDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessTelGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessTelGroup findById(final Integer id) throws DaoException {
		BusinessTelGroup businessTelGroup = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessTelGroupDao.findById",id);
		return businessTelGroup;
	}
	
	/**
	 * 无条件查询所有BusinessTelGroup
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTelGroup> findAll() throws DaoException {
		List<BusinessTelGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessTelGroupDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessTelGroup
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTelGroup> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessTelGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessTelGroupDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTelGroup-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessTelGroup> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessTelGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessTelGroupDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessTelGroup
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query) throws DaoException {
		List<BusinessTelGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessTelGroupDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessTelGroup-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query, final Integer limit) throws DaoException {
		List<BusinessTelGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessTelGroupDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTelGroup> findAllPage(final BusinessTelGroupQuery query) throws DaoException {
		List<BusinessTelGroup> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessTelGroupDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTelGroupQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessTelGroupDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessTelGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessTelGroup entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessTelGroupDao.save",entity);
	}

	/**
	 * 修改BusinessTelGroup数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessTelGroup entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessTelGroupDao.update",entity);
	}

	/**
	 * 删除BusinessTelGroup
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessTelGroupDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
