package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.Food;
import dao.Manager;
import sql.SqlConnection;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���������������ת����ͬ��jspҳ���Լ���ȡ���в�Ʒ��Ϣ�͹���Ա��Ϣ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class Admin_deal
 */
@WebServlet("/Admin_deal")
public class Admin_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_deal() {
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
		String action = request.getParameter("action");//��ȡAdmin.jsp��action����
		if(action!=null) {//action��Ϊ��
			if(action.equals("admin")) {
				request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);//����ת����Admin.jspҳ��
			}
			if(action.equals("exit")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("Login.jsp");
			}
			if(action.equals("addfood")) {//�жϻ�ȡ��action������ֵ�Ƿ�Ϊaddfood
				request.getRequestDispatcher("WEB-INF/addfood.jsp").forward(request, response);//����ת����addfood.jspҳ��
			}
			if(action.equals("editfood")) {
				request.getRequestDispatcher("WEB-INF/EditFood.jsp").forward(request, response);//����ת����EditFood.jspҳ��
			}
			if(action.equals("selectfood")) {	
				List<Food> selectfoodlist = GetFoodList();			
				request.setAttribute("selectfoodlist", selectfoodlist);//��selectfoodlist�������request��
				request.getRequestDispatcher("WEB-INF/SelectFood.jsp").forward(request, response);//����ת����SelectFood.jspҳ��
			}
			if(action.equals("deletefood")) {
				List<Food> deletefoodlist = DeleteFoods();
				request.setAttribute("deletefoodlist", deletefoodlist);//��list�������request��
				request.getRequestDispatcher("WEB-INF/DeleteFood.jsp").forward(request, response);//����ת����DeleteFood.jspҳ��
			}
			if(action.equals("addmanager")) {
				request.getRequestDispatcher("WEB-INF/AddManager.jsp").forward(request, response);//����ת����AddManager.jspҳ��
			}
			if(action.equals("deletemanager")) {
				List<Manager> deletemanagerlist = DeleteManagers();
				request.setAttribute("deletemanagerlist", deletemanagerlist);//��deletemanagerlist�������request��
				request.getRequestDispatcher("WEB-INF/DeleteManager.jsp").forward(request, response);//����ת����DeleteManager.jspҳ��
			}
			if(action.equals("selectmanager")) {
				List<Manager> selectmanagerlist = SelectManagers();
				request.setAttribute("selectmanagerlist", selectmanagerlist);//��selectmanagerlist�������request��
				request.getRequestDispatcher("WEB-INF/SelectManager.jsp").forward(request, response);//����ת����SelectManager.jspҳ��
			}
		}
	}

	private List<Manager> SelectManagers() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Manager_Table"; // SQL���	
		List<Manager> selectmanagerlist = new ArrayList<Manager>();//ʵ����List<Manager>����
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//��ȡִ�к�Ľ����
			while(resultSet.next()) {
				Manager manager = new Manager();//ʵ����Manager��
				manager.setM_id(resultSet.getString("m_id"));//��ȡ���ݿ���ֵ����ΪManager������setM_id����
				manager.setM_password(resultSet.getString("m_password"));
				manager.setM_telephone(resultSet.getString("m_telephone"));
				manager.setM_name(resultSet.getString("m_name"));
				selectmanagerlist.add(manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ����ݼ�����
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
		return selectmanagerlist;
	}

	private List<Manager> DeleteManagers() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Manager_Table"; // SQL���	
		List<Manager> deletemanagerlist = new ArrayList<Manager>();//ʵ����List<Manager>����
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//��ȡִ�к�Ľ����
			while(resultSet.next()) {
				Manager manager = new Manager();//ʵ����Manager��
				manager.setM_id(resultSet.getString("m_id"));//��ȡ���ݿ���ֵ����ΪManager������setM_id����
				manager.setM_password(resultSet.getString("m_password"));
				manager.setM_telephone(resultSet.getString("m_telephone"));
				manager.setM_name(resultSet.getString("m_name"));
				deletemanagerlist.add(manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ����ݼ�����
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
		return deletemanagerlist;
	}

	private List<Food> DeleteFoods() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table"; // SQL���	
		List<Food> deletefoodlist = new ArrayList<Food>();//ʵ����List<Food>����
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//ִ��sql���
			while(resultSet.next()) {//�ж����ݿ��Ƿ���������¼
				Food food = new Food();//ʵ����Food��
				food.setF_id(resultSet.getInt("f_id"));//��ȡ���ݿ���ֵ����ΪFood������setF_id()����
				food.setF_name(resultSet.getString("f_name"));
				food.setF_kind(resultSet.getString("f_kind"));
				food.setF_price(resultSet.getInt("f_price"));
				food.setF_picturepath(resultSet.getString("f_picturepath"));
				//food.setF_describe(resultSet.getString("f_describe"));
				deletefoodlist.add(food);//����������뼯��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ����ݼ�����
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
		return deletefoodlist;
	}

	private List<Food> GetFoodList() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table"; // SQL���	
		List<Food> selectfoodlist = new ArrayList<Food>();//ʵ����List<Food>����
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//ִ��sql���
			while(resultSet.next()) {//�ж����ݿ��Ƿ���������¼
				Food food = new Food();//ʵ����Food��
				food.setF_id(resultSet.getInt("f_id"));//��ȡ���ݿ���ֵ����ΪFood������setF_id()����
				food.setF_name(resultSet.getString("f_name"));
				food.setF_kind(resultSet.getString("f_kind"));
				food.setF_price(resultSet.getInt("f_price"));
				food.setF_picturepath(resultSet.getString("f_picturepath"));
				//food.setF_describe(resultSet.getString("f_describe"));
				selectfoodlist.add(food);//����������뼯��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ����ݼ�����
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	 }
		return selectfoodlist;
	}
}
