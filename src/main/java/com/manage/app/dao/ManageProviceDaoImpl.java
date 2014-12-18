package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageProvice;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;

@Repository("ManageProviceDao")
@Transactional
public class ManageProviceDaoImpl implements ManageProviceDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageProvice数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageProvice entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageProvice",entity);
	}

	/**
	 * 修改ManageProvice数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageProvice entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageProviceId",entity);
	}
	
	/**
	 * 删除ManageProvice数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageProvice entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageProviceId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageProvice
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageProvice get(ManageProvice entity) throws GSSException{
		List<ManageProvice> list =this.sqlSessionTemplate.selectList("selectManageProviceId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageProvice> findAllPage(Page page) throws GSSException{
		List<ManageProvice> list =this.sqlSessionTemplate.selectList("ManageProviceListData",page);
		
		return list;
	}
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageProviceCount",page);
		return count;
	}
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageProvice> treeData(ManageProvice entity) {
		List<ManageProvice> list =this.sqlSessionTemplate.selectList("selectManageProviceTree",entity);
		return list;
	}
	
}
