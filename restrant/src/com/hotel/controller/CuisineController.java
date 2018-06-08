package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.pojo.Cuisine;
import com.hotel.service.CuisineServiceI;
import com.hotel.service.impl.CuisineServiceImpl;

/**
 * Servlet implementation class CuisineController
 */
public class CuisineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CuisineServiceI cuisineServiceI = new CuisineServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("getCuisineList".equals(method)) {
			getCuisineList(request,response);
		}else if ("prepareUpdate".equals(method)) {
			prepareUpdate(request,response);
		}else if ("updateCuisine".equals(method)) {
			updateCuisine(request,response);
		}else if ("deleteCuisine".equals(method)) {
			deleteCuisine(request,response);
		}else if ("addCuisine".equals(method)) {
			addCuisine(request,response);
		}else if ("searchCuisineList".equals(method)) {
			searchCuisineList(request,response);
		}
	}
	
	private void searchCuisineList(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		List<Cuisine> list = cuisineServiceI.searchCuisineList(keyword);
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("/sys/foodType/cuisineList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//添加菜系信息
	private void addCuisine(HttpServletRequest request, HttpServletResponse response) {
		String cuisinename = request.getParameter("name");
		Cuisine cuisine = new Cuisine(null, cuisinename);
		cuisineServiceI.addCuisine(cuisine);
		try {
			response.sendRedirect("cuisineController?method=getCuisineList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除菜系信息
	private void deleteCuisine(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		cuisineServiceI.deleteCuisine(id);
		try {
			response.sendRedirect("cuisineController?method=getCuisineList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新菜系信息
	private void updateCuisine(HttpServletRequest request, HttpServletResponse response) {
		Integer id  = Integer.parseInt(request.getParameter("cid"));
		String cuisinename = request.getParameter("name");
		Cuisine cuisine = new Cuisine(id, cuisinename);
		cuisineServiceI.updateCuisine(cuisine);
		try {
			response.sendRedirect("cuisineController?method=getCuisineList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取准备更新的菜系数据
	private void prepareUpdate(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cuisine cuisine = cuisineServiceI.getCuisine(id);
		request.setAttribute("cuisine", cuisine);
		try {
			request.getRequestDispatcher("/sys/foodType/updateCuisine.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取菜系列表
	private void getCuisineList(HttpServletRequest request, HttpServletResponse response){
		List<Cuisine> list = cuisineServiceI.getCuisineList();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("/sys/foodType/cuisineList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
