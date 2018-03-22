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
 * 功  能：删除管理员信息
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class DeleteManager_deal
 */
@WebServlet("/DeleteManager_deal")
public class DeleteManager_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManager_deal() {
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
		String managerId = request.getParameter("managerId");//获取jsp页面的managerId参数
		if(DeleteManager(managerId)) {//判断方法是否成功
			request.setAttribute("success", "删除成功！");//将提示信息存入request
			request.getRequestDispatcher("Admin_deal?action=deletemanager").forward(request, response);//转发到动作发生页面
		}else {
			request.setAttribute("failure", "删除失败！");
			request.getRequestDispatcher("Admin_deal?action=deletemanager").forward(request, response);
		}
		
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 根据管理员id将管理员信息从Manager_Table表删除
*@return-type: boolean
		*/
	private boolean DeleteManager(String managerId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();//连接数据库
		String sqldelete = "delete from Manager_Table where m_id=?";//sql插入语句
		try {
			preparedStatement = connection.prepareStatement(sqldelete);//执行sql语句
			preparedStatement.setString(1, managerId);
			preparedStatement.executeUpdate();//数据库更新
			preparedStatement.close();//释放数据集
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}

}
