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
 * ��  �ܣ�ɾ����Ʒ��Ϣ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
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
		int foodid = Integer.parseInt(request.getParameter("foodid"));//��ȡjspҳ���foodid����		
		if(DeleteFood(foodid)) {//�ж�DeleteFood()
			request.setAttribute("success", "ɾ���ɹ���");//����ʾ��Ϣ����request
			request.getRequestDispatcher("Admin_deal?action=deletefood").forward(request, response);//ת������������ҳ��
		}
		else {
			request.setAttribute("failure", "ɾ��ʧ�ܣ�");
			request.getRequestDispatcher("Admin_deal?action=deletefood").forward(request, response);
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���ݲ�Ʒid����Ʒ��Ϣ��Food_Table��ɾ��
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
