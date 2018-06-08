package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.util.DButil;
import com.hotel.dao.CuisineDaoI;
import com.hotel.pojo.Cuisine;

public class CuisineDaoImpl implements CuisineDaoI{
	private Connection connection = null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	@Override
	public List<Cuisine> getCuisineList() {
		List<Cuisine> cuisineList=new ArrayList<>();
		String sql="select * from foodtype";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);			
			rs = pst.executeQuery();
			Cuisine cuisine=null;
			while(rs.next()){
				cuisine=new Cuisine(rs.getInt(1),rs.getString(2));
				cuisineList.add(cuisine);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return cuisineList;
	}
	@Override
	public Cuisine getCuisine(Integer id) {
		Cuisine cuisine=null;
		String sql="select * from foodtype where id=?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();			
			while(rs.next()){
				cuisine=new Cuisine(rs.getInt(1),rs.getString(2));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return cuisine;
	}
	@Override
	public void updateCuisine(Cuisine cuisine) {
		String sql="update foodtype set typeName=? where id=?";
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setString(1, cuisine.getTypeName());
			pst.setInt(2, cuisine.getId());
			pst.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}		
	}
	@Override
	public void deleteCuisine(Integer id) {
		String sql="delete from foodtype where id=?";
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}		
	}
	@Override
	public void addCuisine(Cuisine cuisine) {
		String sql="insert into foodtype set typeName=?";
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setString(1, cuisine.getTypeName());
			pst.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}		
	}
	@Override
	public List<Cuisine> searchCuisineList(String keyword) {
		List<Cuisine> cuisineList=new ArrayList<>();
		String sql="select * from foodtype where typeName like ?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setString(1, "%"+keyword+"%");
			rs = pst.executeQuery();
			Cuisine cuisine=null;
			while(rs.next()){
				cuisine=new Cuisine(rs.getInt(1),rs.getString(2));
				cuisineList.add(cuisine);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return cuisineList;
	}

}
