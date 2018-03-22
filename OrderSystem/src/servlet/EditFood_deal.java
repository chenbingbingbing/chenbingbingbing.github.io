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

import dao.Food;
import sql.SqlConnection;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���ȡ��Ʒ��Ϣ�����request����תҳ��
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class EditFood_deal
 */
@WebServlet("/EditFood_deal")
public class EditFood_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFood_deal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubresponse.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int foodid = Integer.parseInt(request.getParameter("foodid"));
		if(GetFoodById(foodid)==null) {
			request.setAttribute("failure", "��ѯʧ�ܣ�");
			request.getRequestDispatcher("Admin_deal?action=editfood").forward(request, response);
		}else {
			Food food = GetFoodById(foodid);//����GetFoodById(int foodid)����
			request.setAttribute("food", food);//��food����request
			request.getRequestDispatcher("WEB-INF/EditFood2.jsp").forward(request, response);
		}
				
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���ݲ�Ʒid��ȡ��Ʒ��Ϣ
*@return-type: Food
		*/
	private Food GetFoodById(int foodid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table where f_id=?"; // SQL���
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, foodid);
			resultSet = statement.executeQuery();//ִ��sql���
			while(resultSet.next()) {//�Ƿ���������¼
				Food food = new Food();//ʵ����
				food.setF_id(resultSet.getInt("f_id"));//��ResultSet�����л�ȡf_idֵ����food����
				food.setF_name(resultSet.getString("f_name"));
				food.setF_kind(resultSet.getString("f_kind"));
				food.setF_price(resultSet.getInt("f_price"));
				food.setF_picturepath(resultSet.getString("f_picturepath"));
				food.setF_describe(resultSet.getString("f_describe"));
				return food;
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
		
		return null;
		
	}

}
