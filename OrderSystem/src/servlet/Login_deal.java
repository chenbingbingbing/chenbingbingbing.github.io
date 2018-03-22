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
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：解决不同用户角色登陆身份的验证跳转至不同的页面
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class Login_deal
 */
@WebServlet("/Login_deal")
public class Login_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection connection;//静态化变量
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
		String radio = request.getParameter("optionsRadiosinline");//获取表单Radio按钮的值
		String adminName=request.getParameter("adminName");//获取表单用户名
		String adminPassword=request.getParameter("adminPassword");//获取表单密码
		if(radio.equals("option1")) {//判断选择的按钮的值
		Admin admin=new Admin();//实例化Admin类
		admin.setA_id(adminName);//对Admin类的用户名赋值
		admin.setA_password(adminPassword);//对Admin类的密码赋值
		if(Judge_LoginAdmin(admin)){//判断用户名、密码是否匹配
			HttpSession session = request.getSession();		
			session.setAttribute("adminName", adminName);//将用户名存入session
			request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);					
		}
		else {
			request.setAttribute("failure", "登陆失败！");
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
			request.setAttribute("failure", "登陆失败！");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		if(radio.equals("option3")) {
			HttpSession session = request.getSession();
			int rows = GetUserid();//调用GetUserid()方法
			session.setAttribute("userid", rows);//将获取的点餐号存入session
			if(rows<=100) {//判断点餐号是否超过100
				if(AddUserId(rows)) {//判断点餐号是否已存入数据库
					request.getRequestDispatcher("WEB-INF/MainUser.jsp").forward(request, response);
				}else {
					request.setAttribute("failure", "登陆失败！");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("failure", "点餐号已用完,请待点餐号重置后登陆！");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 对以管理员身份登陆输入的用户名和密码进行验证
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
				String username=resultSet.getString("m_id").trim();//从ResultSet结果集获取m_id
				String password=resultSet.getString("m_password").trim();
				boolean Username=username.equals(manager.getM_id());//判断用户名是否正确
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
	 *@功能: 对以经理身份登陆输入的用户名和密码进行验证
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
	 *@功能: 向User_Table表插入用户获取的点餐号
*@return-type: boolean
		*/
	private boolean AddUserId(int userid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();
		String sqladd = "insert into User_Table values(?)"; // SQL语句
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
	 *@功能: 为登陆的顾客分配点餐号
*@return-type: boolean
		*/
	private int GetUserid() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from User_Table"; // SQL语句
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
