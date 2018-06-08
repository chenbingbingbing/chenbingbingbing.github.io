package com.hotel.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baidu.util.PageUtil;
import com.hotel.pojo.Cuisine;
import com.hotel.pojo.DinnerTable;
import com.hotel.pojo.Food;
import com.hotel.pojo.Order;
import com.hotel.pojo.OrderDetail;
import com.hotel.service.CuisineServiceI;
import com.hotel.service.DinnerTableServiceI;
import com.hotel.service.FoodServiceI;
import com.hotel.service.OrderServiceI;
import com.hotel.service.impl.CuisineServiceImpl;
import com.hotel.service.impl.DinnerTableServiceImpl;
import com.hotel.service.impl.FoodServiceImpl;
import com.hotel.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodServiceI foodServiceI = new FoodServiceImpl();
	private DinnerTableServiceI dinnerTableServiceI = new DinnerTableServiceImpl();
	private OrderServiceI orderServiceI = new OrderServiceImpl();
	private CuisineServiceI cuisineServiceI = new CuisineServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("getFoodList".equals(method)) {
			getFoodList(request,response);
		}else if ("getFoodDetail".equals(method)) {
			getFoodDetatil(request,response);
		}else if ("addCart".equals(method)) {
			addCart(request,response);
		}else if ("takeOrder".equals(method)) {
			takeOrder(request,response);
		}else if ("clearAccount".equals(method)) {
			clearAccount(request,response);
		}else if ("removeCart".equals(method)) {
			removeCart(request,response);
		}else if ("getTypeFood".equals(method)) {
			getTypeFood(request,response);
		}else {
			getTables(request,response);
		}
	}

	//根据菜品类型id获取对应分类的所有菜品
	private void getTypeFood(HttpServletRequest request, HttpServletResponse response) {
		try {
			Integer foodTypeId = Integer.parseInt(request.getParameter("id"));
			String page = request.getParameter("page");
			Integer counter = foodServiceI.getFoodCount();		
			PageUtil pageUtils = new PageUtil(6, counter, page);
			List<Food> list = foodServiceI.getFoodListByPage((pageUtils.getCurrentPage()-1)*6,6,foodTypeId);					
			List<Cuisine> cuisines = cuisineServiceI.getCuisineList();
			
			request.setAttribute("foodTypeId", foodTypeId);
			request.setAttribute("list", list);
			request.setAttribute("pageUtils", pageUtils);
			request.setAttribute("cuisines", cuisines);
			request.getRequestDispatcher("/front/detail/chuancai.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除购物车内的菜品
	private void removeCart(HttpServletRequest request, HttpServletResponse response) {
		Integer foodId = Integer.parseInt(request.getParameter("id"));
		Food food = foodServiceI.getFoodById(foodId);
		Set<Food> cart = (Set<Food>)request.getSession(false).getAttribute("cart");
		cart.remove(food);
		try {
			response.sendRedirect(request.getContextPath()+"/front/detail/clientCart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//结账
	private void clearAccount(HttpServletRequest request, HttpServletResponse response) {
		Integer orderId = Integer.parseInt(request.getParameter("id"));
		orderServiceI.closeAccount(orderId);
		try {
			response.sendRedirect(request.getContextPath()+"/front/detail/jiezhang.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//下单
	private void takeOrder(HttpServletRequest request, HttpServletResponse response) {
		//下面是生成订单到数据库
		Double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));//总金额
		Integer table_id = (Integer)request.getSession(false).getAttribute("tableid");//从session获取餐桌号
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate = simpleDateFormat.format(date);//获取订单日期
		Order order = new Order(null, table_id, orderDate, totalPrice, 0, null);
		Integer orderId = orderServiceI.takeOrder(order);//获取到生成的订单id
		//下面是生成订单详情到数据库
		String foodCounts = request.getParameter("foodCounts");//获取数量字符串
		String[] foodCount =foodCounts.split("-");	
		Set<Food> cart = (Set<Food>)request.getSession(false).getAttribute("cart");
		List<OrderDetail> list = new ArrayList<>();
		for (Food food : cart) {
			OrderDetail orderDetail = new OrderDetail(null, orderId,food.getId(),food.getFoodName(),food.getPrice(), null);
			list.add(orderDetail);
		}	//遍历购物车将属性添加进订单详情类
		for(int i=0;i<foodCount.length;i++) {
			list.get(i).setFoodCount(Integer.parseInt(foodCount[i]));//遍历订单详情添加菜品数量
		}
		for (OrderDetail orderDetails : list) {
			orderServiceI.takeOrderDetail(orderDetails);
		}
		request.getSession().invalidate();//销毁所有的session
		request.setAttribute("orderId", orderId);
		request.setAttribute("list", list);//将list放入作用域显示订单
		try {
			request.getRequestDispatcher("/front/detail/clientOrderList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Integer foodid = Integer.parseInt(request.getParameter("id"));
			Food food = foodServiceI.getFoodById(foodid);
			Set<Food> cart = (Set<Food>)session.getAttribute("cart");
			if(cart==null) {
				cart = new HashSet<Food>();
				session.setAttribute("cart", cart);
			}else {					
				cart.add(food);				
				response.sendRedirect(request.getContextPath()+"/front/detail/clientCart.jsp");		
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	private void getTables(HttpServletRequest request, HttpServletResponse response) {						
			try {
				List<DinnerTable> list = dinnerTableServiceI.getDinnerTableList();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/front/index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}												
	}

	private void getFoodDetatil(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Food food = foodServiceI.getFoodById(id);
		request.setAttribute("food", food);
		try {
			request.getRequestDispatcher("/front/detail/caixiangxi.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getFoodList(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if(page==null) {//判断获得的分页是否为null,为空获取餐桌号,否则不获取
			Integer tableid = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession();
			session.setAttribute("tableid", tableid);
			Integer counter = foodServiceI.getFoodCount();		
			PageUtil pageUtil = new PageUtil(6, counter, page);
			List<Food> list = foodServiceI.getFoodListByPage((pageUtil.getCurrentPage()-1)*6,6);					
			List<Cuisine> cuisines = cuisineServiceI.getCuisineList();
			
			request.setAttribute("list", list);
			request.setAttribute("pageUtil", pageUtil);
			request.setAttribute("cuisines", cuisines);
			try {
				request.getRequestDispatcher("/front/detail/caidan.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Integer counter = foodServiceI.getFoodCount();		
			PageUtil pageUtil = new PageUtil(6, counter, page);
			List<Food> list = foodServiceI.getFoodListByPage((pageUtil.getCurrentPage()-1)*6,6);					
			List<Cuisine> cuisines = cuisineServiceI.getCuisineList();
			
			request.setAttribute("list", list);
			request.setAttribute("pageUtil", pageUtil);
			request.setAttribute("cuisines", cuisines);
			try {
				request.getRequestDispatcher("/front/detail/caidan.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
