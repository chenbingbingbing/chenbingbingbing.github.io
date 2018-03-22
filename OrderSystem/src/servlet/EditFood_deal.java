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
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：获取菜品信息后放入request中跳转页面
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
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
			request.setAttribute("failure", "查询失败！");
			request.getRequestDispatcher("Admin_deal?action=editfood").forward(request, response);
		}else {
			Food food = GetFoodById(foodid);//调用GetFoodById(int foodid)方法
			request.setAttribute("food", food);//将food存入request
			request.getRequestDispatcher("WEB-INF/EditFood2.jsp").forward(request, response);
		}
				
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 根据菜品id获取菜品信息
*@return-type: Food
		*/
	private Food GetFoodById(int foodid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table where f_id=?"; // SQL语句
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, foodid);
			resultSet = statement.executeQuery();//执行sql语句
			while(resultSet.next()) {//是否有下条记录
				Food food = new Food();//实例化
				food.setF_id(resultSet.getInt("f_id"));//从ResultSet集合中获取f_id值存入food对象
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
			// 释放数据集对象
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
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
