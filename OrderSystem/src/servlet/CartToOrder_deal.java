package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Cart;
import dao.Food;
import dao.Menu;
import sql.GetFoods;
import sql.SqlConnection;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：提交购物车信息同时将提交的信息从购物车删除
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class CartToOrder_deal
 */
@WebServlet("/CartToOrder_deal")
public class CartToOrder_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private GetFoods getFoods = new GetFoods(); //实例化GetFoods类对象     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartToOrder_deal() {
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
		HttpSession session = request.getSession();//实例化session对象
		Menu menu = new Menu();//菜单类实例化
		int userid = (int)session.getAttribute("userid");//获取用户点餐号
		Date date = new Date();//当前日期实例化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//日期格式实例化
		String datetime = dateFormat.format(date);//日期实例化
		String foodname = request.getParameter("foodname");//获取request中的参数foodname
		String foodprice = request.getParameter("foodprice");
		String foodnum = request.getParameter("foodnum");
		String foodtotal = request.getParameter("foodtotal");
		menu.setF_name(foodname);//将foodname存入Menu类的对象
		menu.setUf_price(Integer.valueOf(foodprice));
		menu.setUf_num(Integer.valueOf(foodnum));
		menu.setUf_totalprice(Integer.valueOf(foodtotal));
		menu.setUf_date(datetime);
		menu.setUf_id(userid);		
		if(CartFoodBuy(menu)) {//判断CartFoodBuy()是否执行成功
			if(DeleteFoodFromCart(request,response)) {//判断DeleteFoodFromCart()是否执行成功
				request.setAttribute("success", "订单已提交！");//将提示信息放入request中
				request.getRequestDispatcher("Cart_deal?action=incart").forward(request, response);//转发到动作执行页面
			}
			else {
				request.setAttribute("failure", "订单提交失败！");
				request.getRequestDispatcher("Cart_deal?action=incart").forward(request, response);
			}
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 根据菜品id将顾客所点菜品信息从购物车删除
*@return-type: boolean
		*/
	private boolean DeleteFoodFromCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String foodid = request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		Food food = getFoods.GetFoodById(Integer.parseInt(foodid));//调用GetFoods类的GetFoodById(int id)方法
		if(cart.RemoveFoodsFromCart(food)) {//调用Cart类的RemoveFoodsFromCart(Food food)方法
			return true;
		}
		return false;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 将所选购物车信息存入数据库
*@return-type: boolean
		*/
	private boolean CartFoodBuy(Menu menu) {
		// TODO Auto-generated method stub
		Connection connection = null;
		connection = SqlConnection.getConnection();//连接数据库
		PreparedStatement preparedStatement = null;
		String sqladd = "insert into Menu_Table values(?,?,?,?,?,?)";//sql插入语句
		try {
			preparedStatement = connection.prepareStatement(sqladd);//执行sql语句
			preparedStatement.setInt(1,menu.getUf_id());//设置Menu_Table表第一个属性值
			preparedStatement.setString(2,menu.getF_name());
			preparedStatement.setInt(3,menu.getUf_num());
			preparedStatement.setInt(4,menu.getUf_price());
			preparedStatement.setInt(5,menu.getUf_totalprice());
			preparedStatement.setString(6,menu.getUf_date());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

}
