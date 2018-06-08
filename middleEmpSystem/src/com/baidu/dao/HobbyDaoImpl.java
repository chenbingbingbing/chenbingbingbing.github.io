package com.baidu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.pojo.Hobby;
import com.baidu.util.DButil;

public class HobbyDaoImpl implements HobbyDaoI{
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//根据emp的id查询对应的hobby列表
	@Override
	public List<Hobby> getHobbyById(Integer id) {
		List<Hobby> list = new ArrayList<Hobby>();
		String sql = "select h.* from emp_hobby eh,hobby h where eh.id=? and eh.hid=h.hid";		
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		Hobby hobby = null;
		while(rs.next()) {
			hobby = new Hobby(rs.getInt(1), rs.getString(2));
			list.add(hobby);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return list;
	}
	//获取hobby所有的属性(用于数据查询的回显)
	@Override
	public List<Hobby> getHobbyList() {
		List<Hobby> list = new ArrayList<Hobby>();
		String sql = "select * from hobby";		
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		rs = ps.executeQuery();
		Hobby hobby = null;
		while(rs.next()) {
			hobby = new Hobby(rs.getInt(1), rs.getString(2));
			list.add(hobby);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return list;
	}
	//删除emp_hobby中间表中对应的员工id的爱好
	@Override
	public void deleteEmp_Hobby(Integer id) {
		String sql = "delete from emp_hobby where id=?";	
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, ps);
		}
	}
	//添加员工id和爱好到emp_hobby中间表
	@Override
	public void addEmp_Hobby(Integer id, Integer hid) {
		String sql = "insert into emp_hobby set id=?,hid=?";	
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setInt(2, hid);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, ps);
		}		
	}
	
}
