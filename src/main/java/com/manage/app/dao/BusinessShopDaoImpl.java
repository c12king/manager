package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessShop;
import com.manage.app.vo.BusinessShopQuery;
import com.manage.framework.exception.DaoException;

@Repository("BusinessShopDao")
@Transactional
public class BusinessShopDaoImpl implements BusinessShopDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessShop
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShop findById(final Integer id) throws DaoException {
		BusinessShop businessShop = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessShopDao.findById",id);
		return businessShop;
	}
	
	/**
	 * 无条件查询所有BusinessShop
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShop> findAll() throws DaoException {
		List<BusinessShop> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessShop
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShop> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessShop> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShop-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShop> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessShop> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShop
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShop> findByExample(final BusinessShopQuery query) throws DaoException {
		List<BusinessShop> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShop-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShop> findByExample(final BusinessShopQuery query, final Integer limit) throws DaoException {
		List<BusinessShop> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShop> findAllPage(final BusinessShopQuery query) throws DaoException {
		List<BusinessShop> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessShopDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BusinessShopDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessShop数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShop entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BusinessShopDao.save",entity);
	}

	/**
	 * 修改BusinessShop数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShop entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BusinessShopDao.update",entity);
	}

	/**
	 * 删除BusinessShop
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BusinessShopDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
