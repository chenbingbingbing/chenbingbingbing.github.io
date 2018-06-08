package com.baidu.service;

import java.util.List;

import com.baidu.pojo.Emp;

public interface EmpServiceI {
	//获取包含部门名称的员工信息
	List<Emp> getEmp();
	//根据id获取员工信息
	Emp getEmpById(Integer id);
	//更新员工信息(包含id,name,sex,age,did,hobby)
	void updateEmp(Emp emp);
	//根据员工id删除员工信息
	void deleteEmpInfo(Integer empid);
	//添加员工信息(包含name,sex,age,did,hobby)
	void addEmpInfo(Emp emp);
}
