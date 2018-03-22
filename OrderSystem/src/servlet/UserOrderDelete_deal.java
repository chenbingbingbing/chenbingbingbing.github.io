package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.SqlConnection;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：根据所传参数跳转至不同页面以及删除所有点餐号
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class UserOrderDelete_deal
 */
@WebServlet("/UserOrderDelete_deal")
public class UserOrderDelete_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderDelete_deal() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");		
		if(action.equals("orderdeal")) {
			request.getRequestDispatcher("WEB-INF/UserOrderDelete.jsp").forward(request, response);
		}
		if(action.equals("return")) {
			request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
		}
		if(action.equals("exit")) {
			HttpSession session = request.getSession();
			session.invalidate();//销毁所有session
			response.sendRedirect("Login.jsp");//重定向到Login.jsp页面
		}
		if(action.equals("userdeal")) {
			int totaluserid = GetUserTotalId();//获取数据库最大点餐号
			if(totaluserid==100) {
				if(DeleteAllUserId()) {//判断点餐号是否全删除
					request.setAttribute("success", "所有点餐号已清空！");
					request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
				}
				else {
					request.setAttribute("failure", "点餐号清空失败！");
					request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("failure", "点餐号清空失败！");
				request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
			}
		}		
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 删除所有的点餐号
*@return-type: boolean
		*/
	private boolean DeleteAllUserId() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();
		String sqldelete = "delete from User_Table";
		try {
			preparedStatement = connection.prepareStatement(sqldelete);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 获取已分配点餐号的数量
*@return-type: boolean
		*/
	private int GetUserTotalId() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from User_Table"; // SQL语句
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			int row=0;//用于记录数据库记录数
			while(resultSet.next()) {
				row++;
			}
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
	
}
