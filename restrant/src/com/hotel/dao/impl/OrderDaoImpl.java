package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.baidu.util.DButil;
import com.hotel.dao.OrderDaoI;
import com.hotel.pojo.Order;
import com.hotel.pojo.OrderDetail;

public class OrderDaoImpl implements OrderDaoI{
	private Connection connection = null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	@Override
	public List<Order> getOrderList() {
		List<Order> orderList=new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String sql="select o.*,d.tableName from orders o,dinnertable d where o.table_id=d.id";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);			
			rs = pst.executeQuery();
			Order order=null;
			while(rs.next()){
				order= new Order(rs.getInt(1), rs.getInt(2), dateFormat.format(rs.getTimestamp(3)), rs.getDouble(4), rs.getInt(5), rs.getString(6));
				orderList.add(order);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return orderList;
	}
	//id为订单id,获取菜名，菜价和数量
	@Override
	public List<OrderDetail> getOrderDetailById(Integer id) {
		List<OrderDetail> orderDetails=new ArrayList<>();
		String sql="select o.*,f.foodName,f.price from orderdetail o,food f where o.food_id=f.id and o.orderId=?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			OrderDetail orderDetail = null;
			while(rs.next()){
				orderDetail = new OrderDetail(rs.getInt("id"), rs.getInt("orderId"), rs.getInt("food_id"), rs.getString("foodName"), rs.getDouble("price"), rs.getInt("foodCount"));
				orderDetails.add(orderDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return orderDetails;
	}
	@Override
	public void closeAccount(Integer id) {
		String sql = "update orders set orderStatus=1 where id=?";	
		try {
		connection = DButil.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}
	}
	@Override
	public Integer takeOrder(Order order) {
		Integer id = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "insert into orders set table_id=?,orderDate=?,totalPrice=?,orderStatus=?";
		String sql2 = "select last_insert_id()";
		try {
		connection = DButil.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setInt(1, order.getTable_id());
		try {
			pst.setTimestamp(2, new Timestamp(simpleDateFormat.parse(order.getOrderDate()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pst.setDouble(3, order.getTotalPrice());
		pst.setInt(4, order.getOrderStatus());
		pst.executeUpdate();
		rs = pst.executeQuery(sql2);
		if(rs.next()) {
			id = rs.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}
		return id;
	}
	@Override
	public void takeOrderDetail(OrderDetail orderDetail) {
		String sql = "insert into orderdetail set orderId=?,food_id=?,foodCount=?";
		try {
		connection = DButil.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setInt(1, orderDetail.getOrderId());
		pst.setInt(2, orderDetail.getFood_id());
		pst.setInt(3, orderDetail.getFoodCount());
		pst.executeUpdate();				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}
	}

	
}
