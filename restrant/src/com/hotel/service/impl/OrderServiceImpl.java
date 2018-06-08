package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.OrderDaoI;
import com.hotel.dao.impl.OrderDaoImpl;
import com.hotel.pojo.Order;
import com.hotel.pojo.OrderDetail;
import com.hotel.service.OrderServiceI;

public class OrderServiceImpl implements OrderServiceI{
	private OrderDaoI orderDaoI = new OrderDaoImpl();
	@Override
	public List<Order> getOrderList() {
		return orderDaoI.getOrderList();
	}
	@Override
	public List<OrderDetail> getOrderDetailById(Integer id) {
		return orderDaoI.getOrderDetailById(id);
	}
	@Override
	public void closeAccount(Integer id) {
		orderDaoI.closeAccount(id);
	}
	@Override
	public Integer takeOrder(Order order) {
		return orderDaoI.takeOrder(order);
	}
	@Override
	public void takeOrderDetail(OrderDetail orderDetail) {
		orderDaoI.takeOrderDetail(orderDetail);
	}

}
