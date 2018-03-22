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
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���������������ת����ͬҳ���Լ�ɾ�����е�ͺ�
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
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
			session.invalidate();//��������session
			response.sendRedirect("Login.jsp");//�ض���Login.jspҳ��
		}
		if(action.equals("userdeal")) {
			int totaluserid = GetUserTotalId();//��ȡ���ݿ�����ͺ�
			if(totaluserid==100) {
				if(DeleteAllUserId()) {//�жϵ�ͺ��Ƿ�ȫɾ��
					request.setAttribute("success", "���е�ͺ�����գ�");
					request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
				}
				else {
					request.setAttribute("failure", "��ͺ����ʧ�ܣ�");
					request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("failure", "��ͺ����ʧ�ܣ�");
				request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
			}
		}		
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ɾ�����еĵ�ͺ�
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
	 *@����: ��ȡ�ѷ����ͺŵ�����
*@return-type: boolean
		*/
	private int GetUserTotalId() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from User_Table"; // SQL���
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			int row=0;//���ڼ�¼���ݿ��¼��
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
