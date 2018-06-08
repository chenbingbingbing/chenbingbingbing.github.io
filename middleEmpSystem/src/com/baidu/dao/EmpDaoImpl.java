package com.baidu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.util.DButil;
import com.baidu.pojo.Emp;

public class EmpDaoImpl implements EmpDaoI{
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;	
	//获取包含部门名称的员工信息
	@Override
	public List<Emp> getEmp() {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select e.*,d.dname from emp e,dept d where e.did=d.did";		
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		rs = ps.executeQuery();
		Emp emp = null;
		while(rs.next()) {
			emp = new Emp(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			list.add(emp);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return list;
	}
	//根据id获取员工信息(用于数据查询的回显)
	@Override
	public Emp getEmpById(Integer id) {
		String sql = "select * from emp where id=? ";	
		Emp emp = null;
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();		
		if(rs.next()) {
			emp = new Emp(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, ps, rs);
		}
		return emp;
	}
	//更新emp表
	@Override
	public void updateEmp(Emp emp) {
		String sql = "update emp set name=?,sex=?,age=?,did=? where id=?";	
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getSex());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getDid());
		ps.setInt(5, emp.getId());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, ps);
		}
	}
	//删除emp表中对应员工id的信息
	@Override
	public void deleteEmp(Integer empid) {
		String sql = "delete from emp where id=?";	
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setInt(1, empid);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, ps);
		}
	}
	//向emp表执行添加操作并返回员工id
	@Override
	public Integer addEmp(Emp emp) {
		Integer id = null;
		String sql2 = "select last_insert_id()";	
		String sql = "insert into emp set name=?,sex=?,age=?,did=?";	
		try {
		connection = DButil.getConnection();
		ps = connection.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getSex());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getDid());
		ps.executeUpdate();
		rs = ps.executeQuery(sql2);	
		while(rs.next()) {
			id = rs.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, ps);
		}
		return id;
	}
	

}
