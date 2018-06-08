package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.util.DButil;
import com.hotel.dao.DinnerTableDaoI;
import com.hotel.pojo.DinnerTable;

public class DinnerTableDaoImpl implements DinnerTableDaoI{

	private Connection connection = null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	public List<DinnerTable> getDinnerTableList() throws Exception {
		List<DinnerTable> dinnerTableList=new ArrayList<>();
		String sql="select * from dinnertable";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);			
			rs = pst.executeQuery();
			DinnerTable dinnerTable=null;
			while(rs.next()){
				dinnerTable=new DinnerTable(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getTimestamp(4));
				dinnerTableList.add(dinnerTable);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}
				
		return dinnerTableList;
	}

	//退桌
	public void update(Integer id, Integer isBook) throws Exception {		
		String sql="update dinnertable set tableStatus=0   where id=?";
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}		
	}

	@Override
	public void saveBoard(String tableName) throws Exception {
		String sql="insert into  dinnertable set tableName=?,tableStatus=0";
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setString(1, tableName);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}
	}
}
