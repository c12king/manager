package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.ManagePositionUser;
import com.utis.Page;

@Repository("BusinessUserDao")
@Transactional
public class BusinessUserDaoImpl implements BusinessUserDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存BusinessUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public int save(BusinessUser entity) throws GSSException{
		this.sqlSessionTemplate.insert("addBusinessUser",entity);
		return entity.getUserId();
	}
	public int save(ManagePositionUser entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManagePositionUser",entity);
		return entity.getUserId();
	}

	/**
	 * 修改BusinessUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(BusinessUser entity) throws GSSException{
		this.sqlSessionTemplate.update("updateBusinessUserId",entity);
	}
	
	/**
	 * 删除BusinessUser数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(BusinessUser entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteBusinessUserId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个BusinessUser
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public BusinessUser get(BusinessUser entity) throws GSSException{
		List<BusinessUser> list =this.sqlSessionTemplate.selectList("selectBusinessUserId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<BusinessUser> findAllPage(Page page) throws GSSException{
		List<BusinessUser> list =this.sqlSessionTemplate.selectList("BusinessUserListData",page);
		
		return list;
	}
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectBusinessUserCount",page);
		return count;
	}

	public List<ManagePositionUser> selectManagePositionUser(BusinessUser entity)
			throws GSSException {
		List<ManagePositionUser> list =this.sqlSessionTemplate.selectList("selectManagePositionUser",entity);
		return list;
	}

	public boolean deleteManagePositionUserAll(ManagePositionUser entity)
			throws GSSException {
		int count=this.sqlSessionTemplate.delete("deleteManagePositionUserAll",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	public void isCharge(BusinessUser entity) throws GSSException {
		this.sqlSessionTemplate.update("updateBusinessUserIsCharge",entity);

	}

	public void noIsCharge(BusinessUser entity) throws GSSException {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.update("updateBusinessUserNoIsCharge",entity);
	}
	
	
	/**
	 * 修改职位
	 * @param entity
	 * @throws GSSException
	 */
	public void updatePosition(BusinessUser entity) throws GSSException{
		this.sqlSessionTemplate.update("updateBusinessPosition",entity);
	}
}
