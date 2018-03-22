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
 * ��  �ܣ���ȡ��������²�Ʒ��Ϣ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
/**
 * Servlet implementation class EditFood2_deal
 */
@WebServlet("/EditFood2_deal")
public class EditFood2_deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;   
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config=config;
	}

	final public ServletConfig getServletConfig() {
		return config;
	}

    public EditFood2_deal() {
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
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		SmartUpload su = new SmartUpload();    
	    //����ʵ����
	    su.initialize(getServletConfig(),request,response);
	   
	    su.setAllowedFilesList("jpg");
	    //��ʼ�ϴ��ļ�
	    try {
			su.upload();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    int foodid = Integer.parseInt(su.getRequest().getParameter("foodid"));	    
	    String foodname = su.getRequest().getParameter("foodname");
	    String foodtype = su.getRequest().getParameter("foodtype");	  
	    int foodprice = Integer.parseInt(su.getRequest().getParameter("foodprice"));	    
	    String fooddescribe =su.getRequest().getParameter("fooddescribe");
	    File file = su.getFiles().getFile(0);
	    // ��浽��WEBӦ�ó���ĸ�Ŀ¼Ϊ�ļ���Ŀ¼��Ŀ¼��
	    try {
			file.saveAs("/image/"+file.getFileName(),SmartUpload.SAVE_VIRTUAL);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String foodpath = file.getFileName();
	    Food food = new Food();
	    food.setF_id(Integer.valueOf(foodid));
	    food.setF_name(foodname);
	    food.setF_kind(foodtype);
	    food.setF_price(Integer.valueOf(foodprice));
	    food.setF_describe(fooddescribe);
	    food.setF_picturepath(foodpath);
	    if(UpdateFood(food)) {
	    	request.setAttribute("success", "���³ɹ���");
			request.getRequestDispatcher("Admin_deal?action=editfood").forward(request, response);
	    }else {
	    	request.setAttribute("failure", "����ʧ�ܣ�");
			request.getRequestDispatcher("Admin_deal?action=editfood").forward(request, response);
	    }
	    
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: �����µĲ�Ʒ��Ϣ����Food_Table��
*@return-type: Food
		*/
	private boolean UpdateFood(Food food) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();
		String sql = "update Food_Table set f_id=?,f_name=?,f_kind=?,f_price=?,f_picturepath=?,f_describe=? where f_id=?";//sql�������
		try {
			preparedStatement=connection.prepareStatement(sql);
			//����ȡ��ֵ�������ݿ�
			preparedStatement.setInt(1, food.getF_id());
			preparedStatement.setString(2, food.getF_name());
			preparedStatement.setString(3, food.getF_kind());
			preparedStatement.setInt(4, food.getF_price());
			preparedStatement.setString(5, food.getF_picturepath());
			preparedStatement.setString(6, food.getF_describe());	
			preparedStatement.setInt(7, food.getF_id());
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
