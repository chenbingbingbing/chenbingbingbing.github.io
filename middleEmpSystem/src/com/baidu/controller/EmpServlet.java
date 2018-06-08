package com.baidu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.pojo.Dept;
import com.baidu.pojo.Emp;
import com.baidu.pojo.Hobby;
import com.baidu.service.DeptServiceI;
import com.baidu.service.DeptServiceImpl;
import com.baidu.service.EmpServiceI;
import com.baidu.service.EmpServiceImpl;
import com.baidu.service.HobbyServiceI;
import com.baidu.service.HobbyServiceImpl;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpServiceI empServiceI = new EmpServiceImpl();
	private DeptServiceI deptServiceI = new DeptServiceImpl();
	private HobbyServiceI hobbyServiceI = new HobbyServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if("toupdate".equals(action)) {
			toUpdateEmp(request,response);
		}else if ("update".equals(action)) {
			UpdateEmp(request,response);
		}else if ("getemplist".equals(action)) {
			GetEmpInfo(request,response);
		}else if ("todelete".equals(action)) {
			DeleteEmpInfo(request,response);
		}else if ("addempinof".equals(action)) {
			AddEmpInof(request,response);
		}else {
			GetEmpInfo(request,response);
		}
		
	}
	//添加员工信息
	private void AddEmpInof(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("empname");
		Integer age = Integer.parseInt(request.getParameter("empage"));
		Integer sex = Integer.parseInt(request.getParameter("empsex"));
		Integer did = Integer.parseInt(request.getParameter("empdept"));
		String[] hobbys = request.getParameterValues("hobby");
		Emp emp = new Emp(null, name, sex, age, did, null, null, hobbys);
		empServiceI.addEmpInfo(emp);
		response.sendRedirect(request.getContextPath()+"/empServlet?action=getemplist");
	}
	//删除员工信息
	private void DeleteEmpInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer empid = Integer.parseInt(request.getParameter("id"));
		empServiceI.deleteEmpInfo(empid);
		response.sendRedirect(request.getContextPath()+"/empServlet?action=getemplist");
	}
	//获取员工信息
	private void GetEmpInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Emp> emplist = empServiceI.getEmp();
		request.setAttribute("emplist", emplist);
		request.getRequestDispatcher("EmpList.jsp").forward(request, response);		
	}
	//更新员工信息
	private void UpdateEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("empname");
		Integer age = Integer.parseInt(request.getParameter("empage"));
		Integer sex = Integer.parseInt(request.getParameter("empsex"));
		Integer did = Integer.parseInt(request.getParameter("empdept"));
		String[] hobbys = request.getParameterValues("hobby");
		Emp emp = new Emp(id, name, sex, age, did, null, null, hobbys);
		empServiceI.updateEmp(emp);
		response.sendRedirect(request.getContextPath()+"/empServlet?action=getemplist");
	}
	//获取员工要更新的信息
	private void toUpdateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Emp emp = empServiceI.getEmpById(id);
		List<Dept> deptlist = deptServiceI.getDeptList();
		List<Hobby> hobbylist = hobbyServiceI.getHobbyList();
		request.setAttribute("emp", emp);
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("hobbylist", hobbylist);
		request.getRequestDispatcher("toUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
