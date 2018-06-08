package com.baidu.dao;

import java.util.List;

import com.baidu.pojo.Emp;

public interface EmpDaoI {
	//获取包含部门名称的员工信息
	List<Emp> getEmp();
	//根据id获取员工信息(用于数据查询的回显)
	Emp getEmpById(Integer id);
	//更新emp表
	void updateEmp(Emp emp);
	//删除emp表中对应员工id的信息
	void deleteEmp(Integer empid);
	//向emp表执行添加操作并返回员工id
	Integer addEmp(Emp emp);
}
