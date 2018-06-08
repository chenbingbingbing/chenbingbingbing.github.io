package com.baidu.dao;

import java.util.List;

import com.baidu.pojo.Dept;

public interface DeptDaoI {
	//获取Dept表所有属性(用于数据查询的回显)
	List<Dept> getDeptList();
}
