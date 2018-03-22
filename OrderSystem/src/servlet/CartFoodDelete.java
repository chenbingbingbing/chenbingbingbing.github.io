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
 * 功  能：将顾客所点菜品信息从购物车删除
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class CartFoodDelete
 */
@WebServlet("/CartFoodDelete")
public class CartFoodDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GetFoods getFoods = new GetFoods();//实例化GetFoods类对象   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartFoodDelete() {
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
		if(DeleteFoodFromCart(request,response)) {//判断方法是否执行成功
			request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);
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
		String foodid = request.getParameter("id");//获取jsp页面的id传参
		Cart cart = (Cart)request.getSession().getAttribute("cart");//获取session中的cart
		Food food = getFoods.GetFoodById(Integer.parseInt(foodid));//调用GetFoods类的GetFoodById()方法
		if(cart.RemoveFoodsFromCart(food)) {//调用Cart类的RemoveFoodsFromCart(Food food)方法
			return true;
		}
		return false;
	}

}
