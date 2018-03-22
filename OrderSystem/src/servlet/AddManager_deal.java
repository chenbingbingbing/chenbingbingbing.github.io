package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Manager;
import sql.SqlConnection;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：实现添加管理员信息
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class AddManager_deal
 */
@WebServlet("/AddManager_deal")
public class AddManager_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManager_deal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String managerId = request.getParameter("managerId");//获取AddManager.jsp传的managerId参数
		String managerPassword = request.getParameter("managerPassword");
		String managerTel = request.getParameter("managerTel");
		String managerName = request.getParameter("managerName");
		Manager manager = new Manager();//实例化管理员类
		manager.setM_id(managerId);//Manager类对象调用setM_id()方法赋值
		manager.setM_password(managerPassword);
		manager.setM_telephone(managerTel);
		manager.setM_name(managerName);
		if(AddManager(manager)) {//调用AddManager()方法					
			request.setAttribute("success", "添加成功！");
			request.getRequestDispatcher("Admin_deal?action=addmanager").forward(request, response);
		}
		else {
			request.setAttribute("failure", "添加失败！");
			request.getRequestDispatcher("Admin_deal?action=addmanager").forward(request, response);			
		}
	}

	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 向数据库插入管理员信息
*@return-type: boolean
		*/
	private boolean AddManager(Manager manager) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();//连接数据库
		String sqladd = "insert into Manager_Table values(?,?,?,?)";//sql语句
		try {
			preparedStatement = connection.prepareStatement(sqladd);//调用prepareStatement()方法执行
			preparedStatement.setString(1, manager.getM_id());//对应sql语句的参数赋值
			preparedStatement.setString(2, manager.getM_password());			
			preparedStatement.setString(3, manager.getM_telephone());
			preparedStatement.setString(4, manager.getM_name());
			int rows = preparedStatement.executeUpdate();//获取执行后的成功行数
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 释放语句对象
				if (preparedStatement != null) {
					try {
						preparedStatement.close();
						preparedStatement = null;
						} catch (Exception ex) {
							ex.printStackTrace();
							}
						}
				if (connection != null) {
					try {
						connection.close();
						connection = null;
						} catch (Exception ex) {
							ex.printStackTrace();
							}
						}
				}

		return false;
	}

}
