package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageEstate;
import com.utis.Page;

@Repository("ManageEstateDao")
@Transactional
public class ManageEstateDaoImpl implements ManageEstateDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageEstate数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageEstate entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageEstate",entity);
	}

	/**
	 * 修改ManageEstate数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageEstate entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageEstateId",entity);
	}
	
	/**
	 * 删除ManageEstate数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageEstate entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageEstateId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageEstate
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageEstate get(ManageEstate entity) throws GSSException{
		List<ManageEstate> list =this.sqlSessionTemplate.selectList("selectManageEstateId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageEstate> findAllPage(Page page) throws GSSException{
		List<ManageEstate> list =this.sqlSessionTemplate.selectList("ManageEstateListData",page);
		
		return list;
	}
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageEstateCount",page);
		return count;
	}
	
	/**
	 * 按ID获取单个小区对象
	 * @param estateId
	 * @return
	 */
	public ManageEstate selectSingleManageById(Integer estateId) {
		return this.sqlSessionTemplate.selectOne("selectSingleManageById",estateId);
	}
	
	
	
	/**
	 * 查询所有
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageEstate> findAll() throws GSSException{
		List<ManageEstate> list =this.sqlSessionTemplate.selectList("ManageEstateListFindAll");
		return list;
	}
	
	/**
	 * 按社区查询小区列表
	 * @param comId
	 * @return
	 * @throws GSSException
	 */
	public List selectManageEstateByComId(Integer comId) throws GSSException {
		List list = null;
		list = this.sqlSessionTemplate.selectList("selectManageEstateByComId", comId);
		return list;
	}
	
}
