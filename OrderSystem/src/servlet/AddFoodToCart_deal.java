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
 * ��  �ܣ���ӹ˿������Ʒ��Ϣ�����ﳵ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class AddFoodToCart_deal
 */
@WebServlet("/AddFoodToCart_deal")
public class AddFoodToCart_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
     GetFoods getFoods = new GetFoods();  //ʵ���� GetFoods��
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
		response.setContentType("text/html;charset=UTF-8");//�������ݱ���Ϊutf-8
		request.setCharacterEncoding("UTF-8");//�����ַ�����utf-8
		String action = request.getParameter("action");
		String id =request.getParameter("id");
		if(AddFoodToCart(request,response)) {//�ж�AddFoodToCart()�����Ƿ�ִ�гɹ�
			request.setAttribute("success", "��ӹ��ﳵ�ɹ���");
			if(action.equals("fooddetail")) {
			request.getRequestDispatcher("Cart_deal?action=lookfood&id="+id).forward(request, response);	
			}
		}
		else {
			request.setAttribute("failure", "��ӹ��ﳵʧ�ܣ�");
				if(action.equals("fooddetail")) {
				request.getRequestDispatcher("Cart_deal?action=lookfood&id="+id).forward(request, response);	
				}
		}
	}
/**
 *@author bing
 *@Email:1789194307@qq.com
 *@����: ��Ӳ�Ʒ��¼���빺�ﳵ
*@return-type: boolean
		*/
	private boolean AddFoodToCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Food food=new Food();		
		String id =request.getParameter("id");	//��ȡAddFoodToCart.jsp���Ĳ���id	
		String number =request.getParameter("num");
		food =getFoods.GetFoodById(Integer.parseInt(id));//���� GetFoods���GetFoodById()����		
		if(request.getSession().getAttribute("cart")==null)//�Ƿ��ǵ�һ�θ����ﳵ�����Ʒ,��Ҫ��session�д���һ���µĹ��ﳵ����
		{
			Cart cart = new Cart();//ʵ�������ﳵ��
			request.getSession().setAttribute("cart",cart);//�����ﳵ������session��
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");//��ȡsession�еĹ��ﳵ����
		if(cart.AddFoodsInCart(food, Integer.parseInt(number)))//���ù��ﳵ���AddFoodsInCart()����
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
