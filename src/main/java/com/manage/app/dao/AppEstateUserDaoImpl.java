package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.AppEstateUser;
import com.utis.Page;

@Repository("AppEstateUserDao")
@Transactional
public class AppEstateUserDaoImpl implements AppEstateUserDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存AppEstateUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(AppEstateUser entity) throws GSSException{
		this.sqlSessionTemplate.insert("addAppEstateUser",entity);
	}

	/**
	 * 修改AppEstateUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(AppEstateUser entity) throws GSSException{
		this.sqlSessionTemplate.update("updateAppEstateUserId",entity);
	}
	
	/**
	 * 删除AppEstateUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(AppEstateUser entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteAppEstateUserId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个AppEstateUser
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public AppEstateUser get(AppEstateUser entity) throws GSSException{
		List<AppEstateUser> list =this.sqlSessionTemplate.selectList("selectAppEstateUserId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<AppEstateUser> findAllPage(Page page) throws GSSException{
		List<AppEstateUser> list =this.sqlSessionTemplate.selectList("AppEstateUserListData",page);
		
		return list;
	}
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectAppEstateUserCount",page);
		return count;
	}
	
	
	/**
	 * 查看用户所属小区
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<AppEstateUser> estateUserList(AppEstateUser entity){
		List<AppEstateUser> list =this.sqlSessionTemplate.selectList("selectAppEstateUserId",entity);
		return list;
	}
}
