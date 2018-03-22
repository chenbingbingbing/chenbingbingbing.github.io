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

import sql.SqlConnection;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：删除菜品信息
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class DeleteFood_deal
 */
@WebServlet("/DeleteFood_deal")
public class DeleteFood_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public DeleteFood_deal() {
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
		int foodid = Integer.parseInt(request.getParameter("foodid"));//获取jsp页面的foodid传参		
		if(DeleteFood(foodid)) {//判断DeleteFood()
			request.setAttribute("success", "删除成功！");//将提示信息存入request
			request.getRequestDispatcher("Admin_deal?action=deletefood").forward(request, response);//转发到动作发生页面
		}
		else {
			request.setAttribute("failure", "删除失败！");
			request.getRequestDispatcher("Admin_deal?action=deletefood").forward(request, response);
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 根据菜品id将菜品信息从Food_Table表删除
*@return-type: boolean
		*/
	private boolean DeleteFood(int foodid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();
		String sqldelete = "delete from Food_Table where f_id=?";
		try {
			preparedStatement = connection.prepareStatement(sqldelete);
			preparedStatement.setInt(1, foodid);
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

}
