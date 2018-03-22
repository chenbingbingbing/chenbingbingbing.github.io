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
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ����˿������Ʒ��Ϣ�ӹ��ﳵɾ��
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class CartFoodDelete
 */
@WebServlet("/CartFoodDelete")
public class CartFoodDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GetFoods getFoods = new GetFoods();//ʵ����GetFoods�����   
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
		if(DeleteFoodFromCart(request,response)) {//�жϷ����Ƿ�ִ�гɹ�
			request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);
		}
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ���ݲ�Ʒid���˿������Ʒ��Ϣ�ӹ��ﳵɾ��
*@return-type: boolean
		*/
	private boolean DeleteFoodFromCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String foodid = request.getParameter("id");//��ȡjspҳ���id����
		Cart cart = (Cart)request.getSession().getAttribute("cart");//��ȡsession�е�cart
		Food food = getFoods.GetFoodById(Integer.parseInt(foodid));//����GetFoods���GetFoodById()����
		if(cart.RemoveFoodsFromCart(food)) {//����Cart���RemoveFoodsFromCart(Food food)����
			return true;
		}
		return false;
	}

}
