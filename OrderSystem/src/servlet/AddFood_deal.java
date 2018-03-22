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
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：添加菜品信息保存到数据库
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
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
		super.init(config);//初始化ServletConfig对象config
		this.config=config;//对config赋值
	}

	final public ServletConfig getServletConfig() {
		return config;//获取config
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
		doPost(request, response);//转到dopost()方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=gbk");//设置内容编码为gbk
		request.setCharacterEncoding("gbk");//设置字符编码gbk
		SmartUpload su = new SmartUpload(); //实例化SmartUpload对象
	    
	    su.initialize(getServletConfig(),request,response);//调用jspSmartUpload的初始化方法
	   
	    su.setAllowedFilesList("jpg");//设置允许上传的图片为jpg格式	  
	    try {
			su.upload();//调用jspSmartUpload的上传方法 上传文件
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	   	 
	   
	    int foodid = Integer.parseInt(su.getRequest().getParameter("foodid"));//使用jspSmartUpload对象获取foodid	    
	    String foodname = su.getRequest().getParameter("foodname");
	    String foodtype = su.getRequest().getParameter("foodtype");	  
	    int foodprice = Integer.parseInt(su.getRequest().getParameter("foodprice"));	    
	    String fooddescribe =su.getRequest().getParameter("fooddescribe");
	    File file = su.getFiles().getFile(0);//使用jspSmartUpload对象获取文件
	    
	    try {
			file.saveAs("/image/"+file.getFileName(),SmartUpload.SAVE_VIRTUAL);// 另存到以WEB应用程序的根目录为文件根目录的目录下
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String foodpath = file.getFileName();//使用jspSmartUpload对象获取文件名
	    Food food = new Food();//实例化Food类
	    food.setF_id(foodid);//实例化对象调用get方法赋值
	    food.setF_name(foodname);
	    food.setF_kind(foodtype);
	    food.setF_price(foodprice);
	    food.setF_describe(fooddescribe);
	    food.setF_picturepath(foodpath);
	    if(AddFood(food)) {//判断food对象是否插入数据库
	    	request.setAttribute("success", "添加成功！");
			request.getRequestDispatcher("Admin_deal?action=addfood").forward(request, response);
	    }
	    else {
	    	request.setAttribute("failure", "添加失败！");
			request.getRequestDispatcher("Admin_deal?action=addfood").forward(request, response);	
	    }
	}
/**
 *@author bing
 *@Email:1789194307@qq.com
 *@功能: 向数据库插入菜品信息
*@return-type: boolean
		*/
	private boolean AddFood(Food food) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = SqlConnection.getConnection();//连接数据库
		String sqladd = "insert into Food_Table values(?,?,?,?,?,?)";//sql语句
		try {
			preparedStatement = connection.prepareStatement(sqladd);//调用prepareStatement()方法执行
			preparedStatement.setInt(1, food.getF_id());//对应sql语句的参数赋值
			preparedStatement.setString(2, food.getF_name());
			preparedStatement.setString(3, food.getF_kind());
			preparedStatement.setInt(4, food.getF_price());
			preparedStatement.setString(5, food.getF_picturepath());
			preparedStatement.setString(6, food.getF_describe());
			int rows = preparedStatement.executeUpdate();//获取执行后的成功行数
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 释放语句对象
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
