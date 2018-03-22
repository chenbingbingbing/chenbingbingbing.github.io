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
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：根据所传参数跳转到不同的jsp页面以及获取所有菜品信息和管理员信息
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
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
		String action = request.getParameter("action");//获取Admin.jsp的action参数
		if(action!=null) {//action不为空
			if(action.equals("admin")) {
				request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);//请求转发到Admin.jsp页面
			}
			if(action.equals("exit")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("Login.jsp");
			}
			if(action.equals("addfood")) {//判断获取的action参数的值是否为addfood
				request.getRequestDispatcher("WEB-INF/addfood.jsp").forward(request, response);//请求转发到addfood.jsp页面
			}
			if(action.equals("editfood")) {
				request.getRequestDispatcher("WEB-INF/EditFood.jsp").forward(request, response);//请求转发到EditFood.jsp页面
			}
			if(action.equals("selectfood")) {	
				List<Food> selectfoodlist = GetFoodList();			
				request.setAttribute("selectfoodlist", selectfoodlist);//将selectfoodlist对象放入request中
				request.getRequestDispatcher("WEB-INF/SelectFood.jsp").forward(request, response);//请求转发到SelectFood.jsp页面
			}
			if(action.equals("deletefood")) {
				List<Food> deletefoodlist = DeleteFoods();
				request.setAttribute("deletefoodlist", deletefoodlist);//将list对象放入request中
				request.getRequestDispatcher("WEB-INF/DeleteFood.jsp").forward(request, response);//请求转发到DeleteFood.jsp页面
			}
			if(action.equals("addmanager")) {
				request.getRequestDispatcher("WEB-INF/AddManager.jsp").forward(request, response);//请求转发到AddManager.jsp页面
			}
			if(action.equals("deletemanager")) {
				List<Manager> deletemanagerlist = DeleteManagers();
				request.setAttribute("deletemanagerlist", deletemanagerlist);//将deletemanagerlist对象放入request中
				request.getRequestDispatcher("WEB-INF/DeleteManager.jsp").forward(request, response);//请求转发到DeleteManager.jsp页面
			}
			if(action.equals("selectmanager")) {
				List<Manager> selectmanagerlist = SelectManagers();
				request.setAttribute("selectmanagerlist", selectmanagerlist);//将selectmanagerlist对象放入request中
				request.getRequestDispatcher("WEB-INF/SelectManager.jsp").forward(request, response);//请求转发到SelectManager.jsp页面
			}
		}
	}

	private List<Manager> SelectManagers() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Manager_Table"; // SQL语句	
		List<Manager> selectmanagerlist = new ArrayList<Manager>();//实例化List<Manager>对象
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//获取执行后的结果集
			while(resultSet.next()) {
				Manager manager = new Manager();//实例化Manager类
				manager.setM_id(resultSet.getString("m_id"));//获取数据库列值后作为Manager类对象的setM_id参数
				manager.setM_password(resultSet.getString("m_password"));
				manager.setM_telephone(resultSet.getString("m_telephone"));
				manager.setM_name(resultSet.getString("m_name"));
				selectmanagerlist.add(manager);
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
		return selectmanagerlist;
	}

	private List<Manager> DeleteManagers() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Manager_Table"; // SQL语句	
		List<Manager> deletemanagerlist = new ArrayList<Manager>();//实例化List<Manager>对象
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//获取执行后的结果集
			while(resultSet.next()) {
				Manager manager = new Manager();//实例化Manager类
				manager.setM_id(resultSet.getString("m_id"));//获取数据库列值后作为Manager类对象的setM_id参数
				manager.setM_password(resultSet.getString("m_password"));
				manager.setM_telephone(resultSet.getString("m_telephone"));
				manager.setM_name(resultSet.getString("m_name"));
				deletemanagerlist.add(manager);
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
		return deletemanagerlist;
	}

	private List<Food> DeleteFoods() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table"; // SQL语句	
		List<Food> deletefoodlist = new ArrayList<Food>();//实例化List<Food>对象
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//执行sql语句
			while(resultSet.next()) {//判断数据库是否还有下条记录
				Food food = new Food();//实例化Food类
				food.setF_id(resultSet.getInt("f_id"));//获取数据库列值后作为Food类对象的setF_id()参数
				food.setF_name(resultSet.getString("f_name"));
				food.setF_kind(resultSet.getString("f_kind"));
				food.setF_price(resultSet.getInt("f_price"));
				food.setF_picturepath(resultSet.getString("f_picturepath"));
				//food.setF_describe(resultSet.getString("f_describe"));
				deletefoodlist.add(food);//将对象添加入集合
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
		return deletefoodlist;
	}

	private List<Food> GetFoodList() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;   
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table"; // SQL语句	
		List<Food> selectfoodlist = new ArrayList<Food>();//实例化List<Food>对象
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();//执行sql语句
			while(resultSet.next()) {//判断数据库是否还有下条记录
				Food food = new Food();//实例化Food类
				food.setF_id(resultSet.getInt("f_id"));//获取数据库列值后作为Food类对象的setF_id()参数
				food.setF_name(resultSet.getString("f_name"));
				food.setF_kind(resultSet.getString("f_kind"));
				food.setF_price(resultSet.getInt("f_price"));
				food.setF_picturepath(resultSet.getString("f_picturepath"));
				//food.setF_describe(resultSet.getString("f_describe"));
				selectfoodlist.add(food);//将对象添加入集合
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
		return selectfoodlist;
	}
}
