package com.baidu.dao;

import java.util.List;

import com.baidu.pojo.Hobby;

public interface HobbyDaoI {
	//根据emp的id查询对应的hobby列表
	List<Hobby> getHobbyById(Integer id);
	//获取hobby所有的属性(用于数据查询的回显)
	List<Hobby> getHobbyList();
	//删除emp_hobby中间表中对应的员工id的爱好
	void deleteEmp_Hobby(Integer id);
	//添加员工id和爱好到emp_hobby中间表
	void addEmp_Hobby(Integer id, Integer hid);
}
