package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：根据所传参数跳转到不同的jsp页面
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
/**
 * Servlet implementation class Cart_deal
 */
@WebServlet("/Cart_deal")
public class Cart_deal extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart_deal() {
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
		String action = request.getParameter("action");//获取jsp页面的action传参
		if(action.equals("incart")) {//判断是否相等
			request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);//转发到Cart.jsp页面
		}
		if(action.equals("lookfood")) {
			String id = request.getParameter("id");//获取jsp页面id传参
			request.setAttribute("id", id);//将id参数存入request
			request.getRequestDispatcher("WEB-INF/FoodDetail.jsp").forward(request, response);
		}
		if(action.equals("entermainuser")) {
			request.getRequestDispatcher("WEB-INF/MainUser.jsp").forward(request, response);
		}
		if(action.equals("enteruserorder")) {
			request.getRequestDispatcher("WEB-INF/UserOrder.jsp").forward(request, response);
		}
	}

}
