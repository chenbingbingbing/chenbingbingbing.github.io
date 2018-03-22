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
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ��ύ���ﳵ��Ϣͬʱ���ύ����Ϣ�ӹ��ﳵɾ��
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class CartToOrder_deal
 */
@WebServlet("/CartToOrder_deal")
public class CartToOrder_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private GetFoods getFoods = new GetFoods(); //ʵ����GetFoods�����     
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
		HttpSession session = request.getSession();//ʵ����session����
		Menu menu = new Menu();//�˵���ʵ����
		int userid = (int)session.getAttribute("userid");//��ȡ�û���ͺ�
		Date date = new Date();//��ǰ����ʵ����
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//���ڸ�ʽʵ����
		String datetime = dateFormat.format(date);//����ʵ����
		String foodname = request.getParameter("foodname");//��ȡrequest�еĲ���foodname
		String foodprice = request.getParameter("foodprice");
		String foodnum = request.getParameter("foodnum");
		String foodtotal = request.getParameter("foodtotal");
		menu.setF_name(foodname);//��foodname����Menu��Ķ���
		menu.setUf_price(Integer.valueOf(foodprice));
		menu.setUf_num(Integer.valueOf(foodnum));
		menu.setUf_totalprice(Integer.valueOf(foodtotal));
		menu.setUf_date(datetime);
		menu.setUf_id(userid);		
		if(CartFoodBuy(menu)) {//�ж�CartFoodBuy()�Ƿ�ִ�гɹ�
			if(DeleteFoodFromCart(request,response)) {//�ж�DeleteFoodFromCart()�Ƿ�ִ�гɹ�
				request.setAttribute("success", "�������ύ��");//����ʾ��Ϣ����request��
				request.getRequestDispatcher("Cart_deal?action=incart").forward(request, response);//ת��������ִ��ҳ��
			}
			else {
				request.setAttribute("failure", "�����ύʧ�ܣ�");
				request.getRequestDispatcher("Cart_deal?action=incart").forward(request, response);
			}
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
		String foodid = request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		Food food = getFoods.GetFoodById(Integer.parseInt(foodid));//����GetFoods���GetFoodById(int id)����
		if(cart.RemoveFoodsFromCart(food)) {//����Cart���RemoveFoodsFromCart(Food food)����
			return true;
		}
		return false;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ����ѡ���ﳵ��Ϣ�������ݿ�
*@return-type: boolean
		*/
	private boolean CartFoodBuy(Menu menu) {
		// TODO Auto-generated method stub
		Connection connection = null;
		connection = SqlConnection.getConnection();//�������ݿ�
		PreparedStatement preparedStatement = null;
		String sqladd = "insert into Menu_Table values(?,?,?,?,?,?)";//sql�������
		try {
			preparedStatement = connection.prepareStatement(sqladd);//ִ��sql���
			preparedStatement.setInt(1,menu.getUf_id());//����Menu_Table���һ������ֵ
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
