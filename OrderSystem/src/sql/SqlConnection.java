package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：连接数据库
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class SqlConnection {
	public static Connection conn;
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 连接数据库
*@return-type: Connection
		*/
	public  static Connection getConnection(){//驱动连接和数据库连接方法
		String dbName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;databasename=OrderSystem";
		String dbUser="sa";
		String dbPsw="chenbing111";
		
				try {
					Class.forName(dbName);//驱动连接
					try {
						conn=DriverManager.getConnection(dbURL, dbUser, dbPsw);//数据库连接
						//System.out.println("数据库连接成功");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
	}
}
