package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.ManageOrgExpress;
import com.manage.app.vo.ManageOrgExpressQuery;

@Repository("ManageOrgExpressDao")
@Transactional
public class ManageOrgExpressDaoImpl implements ManageOrgExpressDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageOrgExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageOrgExpress findById(final Integer id) throws DaoException {
		ManageOrgExpress manageOrgExpress = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageOrgExpressDao.findById",id);
		return manageOrgExpress;
	}
	
	/**
	 * 无条件查询所有ManageOrgExpress
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrgExpress> findAll() throws DaoException {
		List<ManageOrgExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageOrgExpressDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageOrgExpress
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrgExpress> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageOrgExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageOrgExpressDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageOrgExpress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageOrgExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageOrgExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageOrgExpressDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageOrgExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query) throws DaoException {
		List<ManageOrgExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageOrgExpressDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageOrgExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageOrgExpress> findByExample(final ManageOrgExpressQuery query, final Integer limit) throws DaoException {
		List<ManageOrgExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageOrgExpressDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrgExpress> findAllPage(final ManageOrgExpressQuery query) throws DaoException {
		List<ManageOrgExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageOrgExpressDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageOrgExpressQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageOrgExpressDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageOrgExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageOrgExpress entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageOrgExpressDao.save",entity);
	}

	/**
	 * 修改ManageOrgExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageOrgExpress entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageOrgExpressDao.update",entity);
	}

	/**
	 * 删除ManageOrgExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageOrgExpressDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
