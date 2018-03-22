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
 * ��  �ܣ�ɾ������Ա��Ϣ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
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
		String managerId = request.getParameter("managerId");//��ȡjspҳ���managerId����
		if(DeleteManager(managerId)) {//�жϷ����Ƿ�ɹ�
			request.setAttribute("success", "ɾ���ɹ���");//����ʾ��Ϣ����request
			request.getRequestDispatcher("Admin_deal?action=deletemanager").forward(request, response);//ת������������ҳ��
		}else {
			request.setAttribute("failure", "ɾ��ʧ�ܣ�");
			request.getRequestDispatcher("Admin_deal?action=deletemanager").forward(request, response);
		}
		
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���ݹ���Աid������Ա��Ϣ��Manager_Table��ɾ��
*@return-type: boolean
		*/
	private boolean DeleteManager(String managerId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();//�������ݿ�
		String sqldelete = "delete from Manager_Table where m_id=?";//sql�������
		try {
			preparedStatement = connection.prepareStatement(sqldelete);//ִ��sql���
			preparedStatement.setString(1, managerId);
			preparedStatement.executeUpdate();//���ݿ����
			preparedStatement.close();//�ͷ����ݼ�
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}

}
