package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.StringUtils;

import com.hotel.defException.MyException;
import com.hotel.pojo.DinnerTable;
import com.hotel.service.DinnerTableServiceI;
import com.hotel.service.impl.DinnerTableServiceImpl;

/**
 * 
* @ClassName: DinnerTableController 
* <p>Description:餐桌管理controller </p>
* <p>Company:baidu</p> 
* @author laomiu
* @date 2018年1月30日
 */
public class DinnerTableController extends HttpServlet {
	
	private DinnerTableServiceI dinnerTableService=new DinnerTableServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("getDinnerTableList".equals(method)){
			getDinnerTableList(request,response);
		}else if("update".equals(method)){
			update(request,response);
		}else if("saveBoard".equals(method)){
			saveBoard(request,response);
		}
		
	}

	private void saveBoard(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {			
			String tableName = request.getParameter("bName");
			if(null != tableName && tableName.length()>0){				
				dinnerTableService.saveBoard(tableName);
				//重定向到列表页面
				response.sendRedirect(request.getContextPath()+"/dinnerTableController?method=getDinnerTableList");				
			}else{
				throw new MyException("tableName不能为空");
			}					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//退桌
	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			String idString = request.getParameter("id");
			String isBookString = request.getParameter("isBook");
			if(null != idString){
				dinnerTableService.update(Integer.parseInt(idString), Integer.parseInt(isBookString));
				//重定向到列表页面
				response.sendRedirect(request.getContextPath()+"/dinnerTableController?method=getDinnerTableList");
				
			}else{
				
				throw new MyException("更新餐桌状态,餐桌id无");
				
			}
			
			
		} catch (Exception e) {
			// 日志
			e.printStackTrace();
		}
		
	}

	private void getDinnerTableList(HttpServletRequest request, HttpServletResponse response) {		
		try {
			List<DinnerTable> dinnerTableList = dinnerTableService.getDinnerTableList();
			request.setAttribute("dinnerTableList", dinnerTableList);
			request.getRequestDispatcher("/sys/board/boardList.jsp").forward(request, response);
			
		} catch (Exception e) {
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
