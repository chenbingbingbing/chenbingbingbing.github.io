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
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���ȡ��ͺź�ɾ����Ӧ��ͺŵĶ�����Ϣ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class UserOrderDelete2
 */
@WebServlet("/UserOrderDelete2")
public class UserOrderDelete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderDelete2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userorderid = request.getParameter("userorderid");
		int userid = Integer.valueOf(userorderid);
		if(DeleteUserOrderById(userid)) {
			request.setAttribute("success", "��������ɣ�");
			request.getRequestDispatcher("UserOrderDelete_deal?action=orderdeal").forward(request, response);
		}else {
			request.setAttribute("failure", "����δ��ɣ�");
			request.getRequestDispatcher("UserOrderDelete_deal?action=orderdeal").forward(request, response);
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���ݵ�ͺŽ���ض�����Menu_Table��ɾ��
*@return-type: boolean
		*/
	private boolean DeleteUserOrderById(int userid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();
		String sqldelete = "delete from Menu_Table where uf_id=?";
		try {
			preparedStatement = connection.prepareStatement(sqldelete);
			preparedStatement.setInt(1, userid);
			int rows = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			if(rows>0) {
			return true;
			}else {
			return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}

}
