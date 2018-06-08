package com.baidu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.pojo.Dept;
import com.baidu.util.DButil;

public class DeptDaoImpl implements DeptDaoI{
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//获取Dept表所有属性(用于数据查询的回显)
	@Override
	public List<Dept> getDeptList() {
		List<Dept> list = new ArrayList<Dept>();
		String sql = "select * from dept";		
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		rs = ps.executeQuery();
		Dept dept = null;
		while(rs.next()) {
			dept = new Dept(rs.getInt("did"), rs.getString("dname"));
			list.add(dept);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return list;
	}

}
