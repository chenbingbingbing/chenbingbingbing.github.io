package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Admin;
import dao.Manager;
import sql.SqlConnection;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ������ͬ�û���ɫ��½��ݵ���֤��ת����ͬ��ҳ��
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class Login_deal
 */
@WebServlet("/Login_deal")
public class Login_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection connection;//��̬������
	static Statement statement;
	static ResultSet resultSet;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_deal() {
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
		//HttpSession session = request.getSession();
		String radio = request.getParameter("optionsRadiosinline");//��ȡ��Radio��ť��ֵ
		String adminName=request.getParameter("adminName");//��ȡ���û���
		String adminPassword=request.getParameter("adminPassword");//��ȡ������
		if(radio.equals("option1")) {//�ж�ѡ��İ�ť��ֵ
		Admin admin=new Admin();//ʵ����Admin��
		admin.setA_id(adminName);//��Admin����û�����ֵ
		admin.setA_password(adminPassword);//��Admin������븳ֵ
		if(Judge_LoginAdmin(admin)){//�ж��û����������Ƿ�ƥ��
			HttpSession session = request.getSession();		
			session.setAttribute("adminName", adminName);//���û�������session
			request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);					
		}
		else {
			request.setAttribute("failure", "��½ʧ�ܣ�");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		}
		if(radio.equals("option2")) {
			Manager manager = new Manager();
			manager.setM_id(adminName);
			manager.setM_password(adminPassword);
			if(Judge_LoginManager(manager)) {
				request.getRequestDispatcher("WEB-INF/Manager.jsp").forward(request, response);
			}
		else {
			request.setAttribute("failure", "��½ʧ�ܣ�");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		if(radio.equals("option3")) {
			HttpSession session = request.getSession();
			int rows = GetUserid();//����GetUserid()����
			session.setAttribute("userid", rows);//����ȡ�ĵ�ͺŴ���session
			if(rows<=100) {//�жϵ�ͺ��Ƿ񳬹�100
				if(AddUserId(rows)) {//�жϵ�ͺ��Ƿ��Ѵ������ݿ�
					request.getRequestDispatcher("WEB-INF/MainUser.jsp").forward(request, response);
				}else {
					request.setAttribute("failure", "��½ʧ�ܣ�");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("failure", "��ͺ�������,�����ͺ����ú��½��");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���Թ���Ա��ݵ�½������û��������������֤
*@return-type: boolean
		*/
	private boolean Judge_LoginManager(Manager manager) {
		// TODO Auto-generated method stub
		connection=SqlConnection.getConnection();
		String sqlState="select m_id,m_password from Manager_Table";
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlState);
			while (resultSet.next()) {
				String username=resultSet.getString("m_id").trim();//��ResultSet�������ȡm_id
				String password=resultSet.getString("m_password").trim();
				boolean Username=username.equals(manager.getM_id());//�ж��û����Ƿ���ȷ
				boolean Password=password.equals(manager.getM_password());
				if(Username&&Password)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return false;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���Ծ�����ݵ�½������û��������������֤
*@return-type: boolean
		*/
	private boolean Judge_LoginAdmin(Admin admin) {
		connection=SqlConnection.getConnection();
		String sqlState="select * from Admin_Table";
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlState);
			while (resultSet.next()) {
				String username=resultSet.getString("a_id").trim();
				String password=resultSet.getString("a_password").trim();
				boolean Username=username.equals(admin.getA_id());
				boolean Password=password.equals(admin.getA_password());
				if(Username&&Password)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return false;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ��User_Table������û���ȡ�ĵ�ͺ�
*@return-type: boolean
		*/
	private boolean AddUserId(int userid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();
		String sqladd = "insert into User_Table values(?)"; // SQL���
		try {
			preparedStatement = connection.prepareStatement(sqladd);
			preparedStatement.setInt(1, userid);
			int rows = preparedStatement.executeUpdate();
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: Ϊ��½�Ĺ˿ͷ����ͺ�
*@return-type: boolean
		*/
	private int GetUserid() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from User_Table"; // SQL���
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			int row=0;
			while(resultSet.next()) {
				row++;
			}
			return row+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;					
	}
}
