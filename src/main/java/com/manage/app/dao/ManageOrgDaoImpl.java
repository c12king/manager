package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.bean.BusinessStation;
import com.manage.app.bean.ManageOrg;
import com.utis.Page;

@Repository("ManageOrgDao")
@Transactional
public class ManageOrgDaoImpl implements ManageOrgDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageOrg数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public String save(ManageOrg entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageOrgLeaf",entity);
		this.sqlSessionTemplate.insert("addManageOrg",entity);
		return entity.getOrgId().toString();
	}

	/**
	 * 修改ManageOrg数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageOrg entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageOrgId",entity);
	}
	
	/**
	 * 删除ManageOrg数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageOrg entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageOrgId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageOrg
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageOrg get(ManageOrg entity) throws GSSException{
		List<ManageOrg> list =this.sqlSessionTemplate.selectList("selectManageOrgId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageOrg> findAllPage(Page page) throws GSSException{
		List<ManageOrg> list =this.sqlSessionTemplate.selectList("ManageOrgListData",page);
		
		return list;
	}
	public int selectCount(ManageOrg manageOrg) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageOrgCount",manageOrg);
		return count;
	}
	
	public List<ManageOrg> treeData(ManageOrg manageOrg) {
		List<ManageOrg> list =this.sqlSessionTemplate.selectList("selectOrgTree",manageOrg);
		return list;
	}
	/**
	 * 获取组织机构复选框的json格式数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<ManageOrg> getComboboxData() {
		List<ManageOrg> list =this.sqlSessionTemplate.selectList("getManageOrgComboboxData");
		return list;
	}
	
	
	/**
	 * 获取该组织下的社区
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessCommunity> getBusinessCommunity(final Integer id) {
		List<BusinessCommunity> list =this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessCommunityDao.getBusinessCommunityOrgId",id);
		return list;
	}
	
	/**
	 * 获取该组织下的社区
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessProperty> getBusinessProperty(final Integer id) {
		List<BusinessProperty> list =this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessPropertyDao.getBusinessPropertyOrgId",id);
		return list;
	}
	
	/**
	 * 获取该组织下的社区
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessStation> getBusinessStation(final Integer id) {
		List<BusinessStation> list =this.sqlSessionTemplate.selectList("com.manage.app.dao.BusinessStationDao.getBusinessStationOrgId",id);
		return list;
	}
}
