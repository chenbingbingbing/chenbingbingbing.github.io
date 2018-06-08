package com.baidu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.pojo.Student;
import com.baidu.service.PageServiceI;
import com.baidu.service.PageServiceImpl;
import com.baidu.util.PageUtil;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PageServiceI pageServiceI = new PageServiceImpl();
    public PageServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String noclear = request.getParameter("noclear");
		if(noclear==null) {
			noclear="";
		}
		String page = request.getParameter("page");
		Integer counter = pageServiceI.getCounter(noclear);
		PageUtil pageUtil = new PageUtil(2, counter, page);
		//(pageUtil.getCurrentPage()-1)*2是根据当前页计算每一页的起始数
		List<Student> list = pageServiceI.getStudentPage((pageUtil.getCurrentPage()-1)*2,2,noclear);
		request.setAttribute("list", list);
		request.setAttribute("noclear", noclear);
		request.setAttribute("pageUtil", pageUtil);
		request.getRequestDispatcher("/StudentList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
