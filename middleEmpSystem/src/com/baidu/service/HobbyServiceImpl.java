package com.baidu.service;

import java.util.List;

import com.baidu.dao.HobbyDaoI;
import com.baidu.dao.HobbyDaoImpl;
import com.baidu.pojo.Hobby;

public class HobbyServiceImpl implements HobbyServiceI{
	private HobbyDaoI hobbylist = new HobbyDaoImpl();
	//根据emp的id查询对应的hobby列表
	@Override
	public List<Hobby> getHobbyById(Integer id) {
		return hobbylist.getHobbyById(id);
	}
	//获取hobby所有的属性
	@Override
	public List<Hobby> getHobbyList() {
		return hobbylist.getHobbyList();
	}
	//删除emp_hobby中间表中对应的员工id的爱好
	@Override
	public void deleteEmp_Hobby(Integer id) {
		 hobbylist.deleteEmp_Hobby(id);
	}
	//添加员工id和爱好到emp_hobby中间表
	@Override
	public void addEmp_Hobby(Integer id, Integer hid) {
		hobbylist.addEmp_Hobby(id,hid);
	}
	
}
