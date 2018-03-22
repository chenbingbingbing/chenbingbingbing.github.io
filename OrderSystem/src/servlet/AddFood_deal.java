package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import dao.Food;
import sql.SqlConnection;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���Ӳ�Ʒ��Ϣ���浽���ݿ�
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class AddFood_deal
 */
@WebServlet("/AddFood_deal")
public class AddFood_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;   
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);//��ʼ��ServletConfig����config
		this.config=config;//��config��ֵ
	}

	final public ServletConfig getServletConfig() {
		return config;//��ȡconfig
	}

	
    public AddFood_deal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);//ת��dopost()����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=gbk");//�������ݱ���Ϊgbk
		request.setCharacterEncoding("gbk");//�����ַ�����gbk
		SmartUpload su = new SmartUpload(); //ʵ����SmartUpload����
	    
	    su.initialize(getServletConfig(),request,response);//����jspSmartUpload�ĳ�ʼ������
	   
	    su.setAllowedFilesList("jpg");//���������ϴ���ͼƬΪjpg��ʽ	  
	    try {
			su.upload();//����jspSmartUpload���ϴ����� �ϴ��ļ�
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	   	 
	   
	    int foodid = Integer.parseInt(su.getRequest().getParameter("foodid"));//ʹ��jspSmartUpload�����ȡfoodid	    
	    String foodname = su.getRequest().getParameter("foodname");
	    String foodtype = su.getRequest().getParameter("foodtype");	  
	    int foodprice = Integer.parseInt(su.getRequest().getParameter("foodprice"));	    
	    String fooddescribe =su.getRequest().getParameter("fooddescribe");
	    File file = su.getFiles().getFile(0);//ʹ��jspSmartUpload�����ȡ�ļ�
	    
	    try {
			file.saveAs("/image/"+file.getFileName(),SmartUpload.SAVE_VIRTUAL);// ��浽��WEBӦ�ó���ĸ�Ŀ¼Ϊ�ļ���Ŀ¼��Ŀ¼��
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String foodpath = file.getFileName();//ʹ��jspSmartUpload�����ȡ�ļ���
	    Food food = new Food();//ʵ����Food��
	    food.setF_id(foodid);//ʵ�����������get������ֵ
	    food.setF_name(foodname);
	    food.setF_kind(foodtype);
	    food.setF_price(foodprice);
	    food.setF_describe(fooddescribe);
	    food.setF_picturepath(foodpath);
	    if(AddFood(food)) {//�ж�food�����Ƿ�������ݿ�
	    	request.setAttribute("success", "��ӳɹ���");
			request.getRequestDispatcher("Admin_deal?action=addfood").forward(request, response);
	    }
	    else {
	    	request.setAttribute("failure", "���ʧ�ܣ�");
			request.getRequestDispatcher("Admin_deal?action=addfood").forward(request, response);	
	    }
	}
/**
 *@author bing
 *@Email:1789194307@qq.com
 *@����: �����ݿ�����Ʒ��Ϣ
*@return-type: boolean
		*/
	private boolean AddFood(Food food) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();//�������ݿ�
		String sqladd = "insert into Food_Table values(?,?,?,?,?,?)";//sql���
		try {
			preparedStatement = connection.prepareStatement(sqladd);//����prepareStatement()����ִ��
			preparedStatement.setInt(1, food.getF_id());//��Ӧsql���Ĳ�����ֵ
			preparedStatement.setString(2, food.getF_name());
			preparedStatement.setString(3, food.getF_kind());
			preparedStatement.setInt(4, food.getF_price());
			preparedStatement.setString(5, food.getF_picturepath());
			preparedStatement.setString(6, food.getF_describe());
			int rows = preparedStatement.executeUpdate();//��ȡִ�к�ĳɹ�����
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ�������
				if (preparedStatement != null) {
					try {
						preparedStatement.close();
						preparedStatement = null;
						} catch (Exception ex) {
							ex.printStackTrace();
							}
						}
				if (connection != null) {
					try {
						connection.close();
						connection = null;
						} catch (Exception ex) {
							ex.printStackTrace();
							}
						}
				}

		return false;
	}
}
