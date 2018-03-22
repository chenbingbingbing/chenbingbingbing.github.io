package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.Cart;
import dao.Food;
import sql.GetFoods;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：添加顾客所点菜品信息到购物车
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class AddFoodToCart_deal
 */
@WebServlet("/AddFoodToCart_deal")
public class AddFoodToCart_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
     GetFoods getFoods = new GetFoods();  //实例化 GetFoods类
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFoodToCart_deal() {
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
		response.setContentType("text/html;charset=UTF-8");//设置内容编码为utf-8
		request.setCharacterEncoding("UTF-8");//设置字符编码utf-8
		String action = request.getParameter("action");
		String id =request.getParameter("id");
		if(AddFoodToCart(request,response)) {//判断AddFoodToCart()方法是否执行成功
			request.setAttribute("success", "添加购物车成功！");
			if(action.equals("fooddetail")) {
			request.getRequestDispatcher("Cart_deal?action=lookfood&id="+id).forward(request, response);	
			}
		}
		else {
			request.setAttribute("failure", "添加购物车失败！");
				if(action.equals("fooddetail")) {
				request.getRequestDispatcher("Cart_deal?action=lookfood&id="+id).forward(request, response);	
				}
		}
	}
/**
 *@author bing
 *@Email:1789194307@qq.com
 *@功能: 添加菜品记录进入购物车
*@return-type: boolean
		*/
	private boolean AddFoodToCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Food food=new Food();		
		String id =request.getParameter("id");	//获取AddFoodToCart.jsp传的参数id	
		String number =request.getParameter("num");
		food =getFoods.GetFoodById(Integer.parseInt(id));//调用 GetFoods类的GetFoodById()方法		
		if(request.getSession().getAttribute("cart")==null)//是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		{
			Cart cart = new Cart();//实例化购物车类
			request.getSession().setAttribute("cart",cart);//将购物车对象传入session中
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");//获取session中的购物车对象
		if(cart.AddFoodsInCart(food, Integer.parseInt(number)))//调用购物车类的AddFoodsInCart()方法
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
