package com.baidu.service;

import java.util.List;

import com.baidu.dao.EmpDaoI;
import com.baidu.dao.EmpDaoImpl;
import com.baidu.pojo.Emp;
import com.baidu.pojo.Hobby;

public class EmpServiceImpl implements EmpServiceI{
	private EmpDaoI emplist = new EmpDaoImpl();
	private HobbyServiceI hobbylist = new HobbyServiceImpl();
	/*
	 * 在原先有部门号的emplist对象基础上加爱好hobby
	 * 
	 */
	@Override
	public List<Emp> getEmp() {
		List<Emp> list = emplist.getEmp();
		for (Emp emp : list) {
			Integer id = emp.getId();
			List<Hobby> hobbies = hobbylist.getHobbyById(id);
			emp.setHobbylist(hobbies);
		}
		return list;		
	}
	//根据id获取加有爱好hobby的员工信息
	@Override
	public Emp getEmpById(Integer id) {
		Emp emp = emplist.getEmpById(id);
		Integer eid = emp.getId();
		List<Hobby> hobbies = hobbylist.getHobbyById(eid);
		emp.setHobbylist(hobbies);
		return emp;
	}
	//更新员工信息(包含id,name,sex,age,did,hobby)
	@Override
	public void updateEmp(Emp emp) {
		emplist.updateEmp(emp);
		Integer id = emp.getId();
		hobbylist.deleteEmp_Hobby(id);//先删除员工对应id的爱好
		String[] hobbies = emp.getHobbies();
		for (String string : hobbies) {
			hobbylist.addEmp_Hobby(id,Integer.parseInt(string));//将员工id和爱好添加进中间表
		}		
	}
	//根据员工id删除员工信息
	@Override
	public void deleteEmpInfo(Integer empid) {
		emplist.deleteEmp(empid);
		hobbylist.deleteEmp_Hobby(empid);
	}
	//添加员工信息(包含name,sex,age,did,hobby)
	@Override
	public void addEmpInfo(Emp emp) {
		Integer id =emplist.addEmp(emp);
		String[] hobbies = emp.getHobbies();
		for (String string : hobbies) {
			hobbylist.addEmp_Hobby(id, Integer.parseInt(string));
		}
		
	}
	
}
