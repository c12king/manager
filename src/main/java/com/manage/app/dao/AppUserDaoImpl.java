package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.AppUser;
import com.utis.Page;

@Repository("AppUserDao")
@Transactional
public class AppUserDaoImpl implements AppUserDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存AppUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(AppUser entity) throws GSSException{
		this.sqlSessionTemplate.insert("addAppUser",entity);
	}

	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(AppUser entity) throws GSSException{
		this.sqlSessionTemplate.update("updateAppUserId",entity);
	}
	
	/**
	 * 删除AppUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(AppUser entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteAppUserId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个AppUser
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public AppUser get(AppUser entity) throws GSSException{
		List<AppUser> list =this.sqlSessionTemplate.selectList("selectAppUserId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<AppUser> findAllPage(Page page) throws GSSException{
		List<AppUser> list =this.sqlSessionTemplate.selectList("AppUserListData",page);
		
		return list;
	}
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectAppUserCount",page);
		return count;
	}
	
}
