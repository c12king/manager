package com.manage.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessMenu;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;
@Repository("BusinessMenuDao")
public class BusinessMenuDaoImpl implements BusinessMenuDao{
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;


	public int addMenu(BusinessMenu menu) {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.update("updateMenuLeaf",menu);
		int id=this.sqlSessionTemplate.insert("addMenu",menu);
		return menu.getMenuId();
	}


	public void deleteMenu(BusinessMenu menu) {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.delete("deleteMenu",menu);
	}




	public List<BusinessMenu> selectMenuId(BusinessMenu menu) {
		List<BusinessMenu> list =this.sqlSessionTemplate.selectList("selectMenuId",menu);
		return list;
	}


	public void updateMenu(BusinessMenu menu) {
		this.sqlSessionTemplate.update("updateMenu",menu);
	}

	public List<BusinessMenu> treeData(BusinessMenu menu) {
		List<BusinessMenu> list =this.sqlSessionTemplate.selectList("selectTree",menu);
		return list;
	}

	public int selectMenuCount(BusinessMenu menu) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectMenuCount",menu);
		return count;
	}

	public List<BusinessMenu> getComboboxData() {
		List<BusinessMenu> list =this.sqlSessionTemplate.selectList("selectTree");
		return list;
	}

	/**
	 * 查询parnetId为id的菜单
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findFarentById(Integer id) throws DaoException {
		List<BusinessMenu> list =this.sqlSessionTemplate.selectList("BusinessMenuFindFarentById",id);
		return list;
	}
	
}
