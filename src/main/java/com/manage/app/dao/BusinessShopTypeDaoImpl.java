package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.framework.exception.DaoException;

import com.manage.app.bean.BusinessShopType;
import com.manage.app.vo.BusinessShopTypeQuery;

@Repository("BusinessShopTypeDao")
@Transactional
public class BusinessShopTypeDaoImpl implements BusinessShopTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessShopType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopType findById(final Integer id) throws DaoException {
		BusinessShopType businessShopType = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessShopTypeDao.findById",id);
		return businessShopType;
	}
	
	/**
	 * 无条件查询所有BusinessShopType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopType> findAll() throws DaoException {
		List<BusinessShopType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessShopType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessShopType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessShopType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query) throws DaoException {
		List<BusinessShopType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessShopType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopType> findAllPage(final BusinessShopTypeQuery query) throws DaoException {
		List<BusinessShopType> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessShopTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessShopType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessShopTypeDao.save",entity);
	}

	/**
	 * 修改BusinessShopType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessShopTypeDao.update",entity);
	}

	/**
	 * 删除BusinessShopType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessShopTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
