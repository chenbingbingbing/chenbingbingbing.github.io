package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ��������ݿ�
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class SqlConnection {
	public static Connection conn;
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: �������ݿ�
*@return-type: Connection
		*/
	public  static Connection getConnection(){//�������Ӻ����ݿ����ӷ���
		String dbName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;databasename=OrderSystem";
		String dbUser="sa";
		String dbPsw="chenbing111";
		
				try {
					Class.forName(dbName);//��������
					try {
						conn=DriverManager.getConnection(dbURL, dbUser, dbPsw);//���ݿ�����
						//System.out.println("���ݿ����ӳɹ�");
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
