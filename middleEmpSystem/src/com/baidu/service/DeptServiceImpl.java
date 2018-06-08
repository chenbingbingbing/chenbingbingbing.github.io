package com.baidu.service;

import java.util.List;

import com.baidu.dao.DeptDaoI;
import com.baidu.dao.DeptDaoImpl;
import com.baidu.pojo.Dept;

public class DeptServiceImpl implements DeptServiceI{
	private DeptDaoI deptlist = new DeptDaoImpl();
	//获取Dept表所有属性
	@Override
	public List<Dept> getDeptList() {
		return deptlist.getDeptList();
	}
	
}
