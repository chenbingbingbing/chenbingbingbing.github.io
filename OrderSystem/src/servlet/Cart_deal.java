package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���������������ת����ͬ��jspҳ��
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
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
		String action = request.getParameter("action");//��ȡjspҳ���action����
		if(action.equals("incart")) {//�ж��Ƿ����
			request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);//ת����Cart.jspҳ��
		}
		if(action.equals("lookfood")) {
			String id = request.getParameter("id");//��ȡjspҳ��id����
			request.setAttribute("id", id);//��id��������request
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
