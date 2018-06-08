package com.lzw.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lzw.model.Booksinfo;
import com.lzw.model.Registerinfo;
import com.lzw.model.Userrent;

public class Database {
	static Connection conn;
	static Statement sql;
	static ResultSet res;
	static PreparedStatement pstm;
	public Connection getConnection(){//驱动连接和数据库连接方法
	String dbName="sun.jdbc.odbc.JdbcOdbcDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;databasename=db_libary";
	String dbUser="sa";
	String dbPsw="111";
	
			try {
				Class.forName(dbName);//驱动连接
				try {
					conn=DriverManager.getConnection(dbURL, dbUser, dbPsw);//数据库连接
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
	
	public static boolean getRegisterMannger(Registerinfo register){//通过Registerinfo模型类获取管理员用户名、密码等
		String sqlState=new String();
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		sqlState="insert into userinfo_Table(username,password)values(?,?)";	//向数据库userrent_Table插入数据
		try {
			pstm=conn.prepareStatement(sqlState);
			pstm.setString(1,register.getUsername());
			pstm.setString(2,register.getPassword());
		    pstm.executeUpdate();//执行sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean getRegisteruser(Registerinfo register){//通过Registerinfo模型类获取用户的用户名、密码等
		String sqlState=new String();
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		sqlState="insert into rentinfo_Table(username,password)values(?,?)";	//向数据库userrent_Table插入数据
		try {
			pstm=conn.prepareStatement(sqlState);
			pstm.setString(1,register.getUsername());
			pstm.setString(2,register.getPassword());
		    pstm.executeUpdate();//执行sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean checkLogin(String username,String password){//判断用户输入用户名和密码是否匹配
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		try {
			sql=conn.createStatement();
			res=sql.executeQuery("select *from userinfo_Table");
			while(res.next()){
			String Username=res.getString("username");//获取数据库用户名
			String Password=res.getString("password");//获取数据库密码
			boolean b1=Username.equals(username);
			boolean b2=Password.equals(password);
			if(b1&&b2)
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	public static boolean checkLogins(String username,String password){//判断用户输入用户名和密码是否匹配
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		try {
			sql=conn.createStatement();
			res=sql.executeQuery("select *from rentinfo_Table");
			while(res.next()){
			String Username=res.getString("username");//获取数据库用户名
			String Password=res.getString("password");//获取数据库密码
			boolean b1=Username.equals(username);
			boolean b2=Password.equals(password);
			if(b1&&b2)
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	public static  boolean judgeID(String id,String name,Booksinfo booksinfo){//判断Booksinfo中id与数据库信息是否重复
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		String sqlState=new String();
		sqlState="select * from "+ name+" where "+id+"=?";
		try {
			pstm=conn.prepareStatement(sqlState);
			pstm.setString(1,booksinfo.getid());
			res=pstm.executeQuery();//执行sql语句
			if(res.next()){
				if(res.getInt(1)>0)//数据表中是否有数据
					return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static  boolean insertOrupdate(Booksinfo booksinfo){//向数据库插入图书Booksinfo类数据模型
			String sqlState=new String();
			Database d=new Database();
			conn=d.getConnection();//连接数据库
		if(judgeID("id","booksinfo_Table",booksinfo))//调用judgeID()方法判断数据是否已经存在于数据库	
				{
				sqlState="Update booksinfo_Table set id=?,name=?,author=?,publish=?,price=?";
				try {
				pstm=conn.prepareStatement(sqlState);
				pstm.setString(1,booksinfo.getid());
				pstm.setString(2,booksinfo.getname());
				pstm.setString(3,booksinfo.getauthor());
				pstm.setString(4,booksinfo.getpublish());
				pstm.setFloat(5,booksinfo.getprice());
				pstm.executeUpdate();//执行sql语句	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
					
	   else
		{
			sqlState="insert into booksinfo_Table(id,name,author,publish,price)values(?,?,?,?,?)";	//向数据库插入数据
				try {
					pstm=conn.prepareStatement(sqlState);
					pstm.setString(1,booksinfo.getid());
					pstm.setString(2,booksinfo.getname());
					pstm.setString(3,booksinfo.getauthor());
					pstm.setString(4,booksinfo.getpublish());
					pstm.setFloat(5,booksinfo.getprice());
				    pstm.executeUpdate();//执行sql语句
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		return false;
				}
		
	public static boolean delete(Booksinfo booksinfo){//向数据库删除Booksinfo类数据模型
		String sqlState=new String();
		Database d=new Database();
		conn=d.getConnection();//连接数据库
			sqlState="delete from booksinfo_Table where id=? and name=? and author=? and publish=? and price=?";
			try {
				pstm=conn.prepareStatement(sqlState);
				pstm.setString(1,booksinfo.getid());
				pstm.setString(2,booksinfo.getname());
				pstm.setString(3,booksinfo.getauthor());
				pstm.setString(4,booksinfo.getpublish());
				pstm.setFloat(5,booksinfo.getprice());
				pstm.executeUpdate();//执行sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
	}

	public static boolean getUserrent(Userrent userrent){//通过Userrent模型类获取读者姓名、借书日期等
		String sqlState=new String();
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		sqlState="insert into userrent_Table(username,id,rentdate)values(?,?,?)";	//向数据库插入数据
		try {
			pstm=conn.prepareStatement(sqlState);
			pstm.setString(1,userrent.getusername());
			pstm.setString(2,userrent.getrentbookid());
			pstm.setString(3,userrent.getrentdate());
		    pstm.executeUpdate();//执行sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean delUserrent(Userrent userrent){//用于还书的用户方法
		String sqlState=new String();
		Database d=new Database();
		conn=d.getConnection();//连接数据库
		sqlState="delete from userrent_Table where username=? and id=? and rentdate=?";
		try {
			pstm=conn.prepareStatement(sqlState);
			pstm.setString(1, userrent.getusername());
			pstm.setString(2, userrent.getrentbookid());
			pstm.setString(3, userrent.getrentdate());
			pstm.executeUpdate();//执行sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
}

