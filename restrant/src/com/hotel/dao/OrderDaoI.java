package com.hotel.dao;

import java.util.List;

import com.hotel.pojo.Order;
import com.hotel.pojo.OrderDetail;

public interface OrderDaoI {
	//获取所有订单信息
	List<Order> getOrderList();
	//获取订单详情
	List<OrderDetail> getOrderDetailById(Integer id);
	//根据订单id更改结账状态
	void closeAccount(Integer id);
	//添加订单
	Integer takeOrder(Order order);
	//生成订单详情到数据库
	void takeOrderDetail(OrderDetail orderDetail);

}
