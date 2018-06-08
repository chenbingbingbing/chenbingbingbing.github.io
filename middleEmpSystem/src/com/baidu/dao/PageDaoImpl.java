package com.baidu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.pojo.Student;
import com.baidu.util.DButil;

public class PageDaoImpl implements PageDaoI{
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public Integer getCounter(String noclear) {
		Integer count = null;
		String sql = "select count(*) from tb_stu where sname like ?";		
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, "%"+noclear+"%");
		rs = ps.executeQuery();
		while(rs.next()) {
			count = rs.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return count;
	}

	@Override
	public List<Student> getStudentPage(Integer currentnum, Integer pagesize,String noclear) {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from tb_stu where sname like ? limit ?,?";		
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, "%"+noclear+"%");
		ps.setInt(2, currentnum);
		ps.setInt(3, pagesize);
		rs = ps.executeQuery();
		Student student = null;
		while(rs.next()) {
			student = new Student(rs.getInt(1), rs.getString(2));
			list.add(student);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return list;
	}
//	public static void main(String[] args) {
//		PageDaoImpl pageDaoImpl = new PageDaoImpl();
//		Integer count = pageDaoImpl.getCounter("sdf");
//		System.out.println(count);
//	}
}
