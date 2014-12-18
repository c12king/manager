package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.manage.app.bean.ManageHouse;
import com.utis.Page;

@Repository("ManageHouseDao")
@Transactional
public class ManageHouseDaoImpl implements ManageHouseDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageHouse数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageHouse entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageHouse",entity);
	}

	/**
	 * 修改ManageHouse数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageHouse entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageHouseId",entity);
	}
	
	/**
	 * 删除ManageHouse数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageHouse entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageHouseId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageHouse
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageHouse get(ManageHouse entity) throws GSSException{
		List<ManageHouse> list =this.sqlSessionTemplate.selectList("selectManageHouseId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageHouse> findAllPage(Page page) throws GSSException{
		List<ManageHouse> list =this.sqlSessionTemplate.selectList("ManageHouseListData",page);
		
		return list;
	}
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageHouseCount",page);
		return count;
	}
	
}
