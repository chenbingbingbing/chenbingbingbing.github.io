package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.pojo.Order;
import com.hotel.pojo.OrderDetail;
import com.hotel.service.OrderServiceI;
import com.hotel.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderServiceI orderServiceI = new OrderServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("getOrderList".equals(method)) {
			getOrderList(request,response);
		}else if ("selectOrderDetail".equals(method)) {
			selectOrderDetail(request,response);
		}else if ("closeAccount".equals(method)) {
			closeAccount(request,response);
		}
	}

	private void closeAccount(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));//获取订单id
		orderServiceI.closeAccount(id);
		try {
			response.sendRedirect(request.getContextPath()+"/orderController?method=getOrderList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void selectOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<OrderDetail> list =  orderServiceI.getOrderDetailById(id);
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("sys/order/orderDetail.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void getOrderList(HttpServletRequest request, HttpServletResponse response) {
		List<Order> list = orderServiceI.getOrderList();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("sys/order/orderList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
