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
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ�ʵ����ӹ���Ա��Ϣ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
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
		String managerId = request.getParameter("managerId");//��ȡAddManager.jsp����managerId����
		String managerPassword = request.getParameter("managerPassword");
		String managerTel = request.getParameter("managerTel");
		String managerName = request.getParameter("managerName");
		Manager manager = new Manager();//ʵ��������Ա��
		manager.setM_id(managerId);//Manager��������setM_id()������ֵ
		manager.setM_password(managerPassword);
		manager.setM_telephone(managerTel);
		manager.setM_name(managerName);
		if(AddManager(manager)) {//����AddManager()����					
			request.setAttribute("success", "��ӳɹ���");
			request.getRequestDispatcher("Admin_deal?action=addmanager").forward(request, response);
		}
		else {
			request.setAttribute("failure", "���ʧ�ܣ�");
			request.getRequestDispatcher("Admin_deal?action=addmanager").forward(request, response);			
		}
	}

	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: �����ݿ�������Ա��Ϣ
*@return-type: boolean
		*/
	private boolean AddManager(Manager manager) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();//�������ݿ�
		String sqladd = "insert into Manager_Table values(?,?,?,?)";//sql���
		try {
			preparedStatement = connection.prepareStatement(sqladd);//����prepareStatement()����ִ��
			preparedStatement.setString(1, manager.getM_id());//��Ӧsql���Ĳ�����ֵ
			preparedStatement.setString(2, manager.getM_password());			
			preparedStatement.setString(3, manager.getM_telephone());
			preparedStatement.setString(4, manager.getM_name());
			int rows = preparedStatement.executeUpdate();//��ȡִ�к�ĳɹ�����
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ�������
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
