package com.hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hotel.pojo.Cuisine;
import com.hotel.pojo.Food;
import com.hotel.service.CuisineServiceI;
import com.hotel.service.FoodServiceI;
import com.hotel.service.impl.CuisineServiceImpl;
import com.hotel.service.impl.FoodServiceImpl;

/**
 * Servlet implementation class FoodController
 */
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodServiceI foodServiceI = new FoodServiceImpl();
	private CuisineServiceI cuisineServiceI = new CuisineServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("getFoodList".equals(method)) {
			getFoodList(request,response);
		}else if ("prepareUpdate".equals(method)) {
			prepareUpdateFood(request,response);
		}else if ("updateFood".equals(method)) {
			updateFood(request,response);
		}else if ("deleteFood".equals(method)) {
			deleteFood(request,response);
		}else if ("prepareAddFood".equals(method)) {
			prepareAddFood(request,response);
		}else if ("addFood".equals(method)) {
			addFood(request,response);
		}else if ("searchFoodList".equals(method)) {
			searchFoodList(request,response);
		}
	}
	//搜索信息
	private void searchFoodList(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		List<Food> list = foodServiceI.searchFoodList(keyword);
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("/sys/food/foodList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//添加菜品信息
	private void addFood(HttpServletRequest request, HttpServletResponse response) {
		List<String> arr = new ArrayList<>();//将表单提交的图片信息和非图片信息存入该集合
		try {		
			//创建工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置中文文件编码
			upload.setHeaderEncoding("UTF-8");
			//判断是否是文件域
			if(upload.isMultipartContent(request)) {				
				//将请求数据转换为list集合
				List<FileItem> list = upload.parseRequest(request);			
				for (FileItem fileItem : list) {
					if(fileItem.isFormField()) {												 						
						String forminfo = fileItem.getString("utf-8");
						arr.add(forminfo);						
					}					
					else {
						//获取文件名称
						String name = fileItem.getName();											
						//设置文件名称唯一标识
						name = UUID.randomUUID().toString().replaceAll("-", "")+"_"+name;
						arr.add("upload/"+name);
						//得到上传目录
						String path = getServletContext().getRealPath("/upload");
						//创建上传的对象
						File file = new File(path);
						if(!file.exists()) {
							file.mkdir();
						}
						File file2 = new File(file, name);
						fileItem.write(file2);
						fileItem.delete();// 删除组件运行时产生的临时文件
						
					}
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			foodServiceI.addFoodInfo(arr);
			try {
				response.sendRedirect(request.getContextPath()+"/foodController?method=getFoodList");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//准备跳转到添加页面的菜品信息	
	private void prepareAddFood(HttpServletRequest request, HttpServletResponse response) {
		List<Cuisine> list = cuisineServiceI.getCuisineList(); 		
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("sys/food/saveFood.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	//删除菜品信息
	private void deleteFood(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		foodServiceI.deleteFoodById(id);
		try {
			response.sendRedirect(request.getContextPath()+"/foodController?method=getFoodList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更新菜品信息
	private void updateFood(HttpServletRequest request, HttpServletResponse response) {
		List<String> arr = new ArrayList<>();//将表单提交的图片信息和非图片信息存入该集合
		try {		
			//创建工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置中文文件编码
			upload.setHeaderEncoding("UTF-8");
			//判断是否是文件域
			if(upload.isMultipartContent(request)) {				
				//将请求数据转换为list集合
				List<FileItem> list = upload.parseRequest(request);			
				for (FileItem fileItem : list) {
					if(fileItem.isFormField()) {												 						
						String forminfo = fileItem.getString("utf-8");
						arr.add(forminfo);						
					}					
					else {
						//获取文件名称
						String name = fileItem.getName();											
						//设置文件名称唯一标识
						name = UUID.randomUUID().toString().replaceAll("-", "")+"_"+name;
						arr.add("upload/"+name);
						//得到上传目录
						String path = getServletContext().getRealPath("/upload");
						//创建上传的对象
						File file = new File(path);
						if(!file.exists()) {
							file.mkdir();
						}
						File file2 = new File(file, name);
						fileItem.write(file2);
						fileItem.delete();// 删除组件运行时产生的临时文件
						
					}
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			foodServiceI.updateFoodInfo(arr);
			try {
				response.sendRedirect(request.getContextPath()+"/foodController?method=getFoodList");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//数据回显跳转更新页面
	private void prepareUpdateFood(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<Cuisine> list = cuisineServiceI.getCuisineList(); 
		Food food = foodServiceI.prepareFoodById(id);
		request.setAttribute("list", list);
		request.setAttribute("food", food);
		try {
			request.getRequestDispatcher("sys/food/updateFood.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//获取菜品列表信息
	private void getFoodList(HttpServletRequest request, HttpServletResponse response) {
		List<Food> list = foodServiceI.getFoodList();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("sys/food/foodList.jsp").forward(request, response);
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
