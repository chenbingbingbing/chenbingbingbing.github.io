package com.lzw.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.lzw.database.Database;

public class SelectJframe extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static Statement sql;
	static ResultSet res;
	static PreparedStatement pstm;
	JTextField nametext;
	String[] colName={"图书编号","图书名称","图书作者","出版社","价格"};//表列名;
	public SelectJframe(){
		super();
		this.setTitle("查询界面");
		this.setVisible(true);
		setBounds(100,70,600,500);//设置窗体位置和大小
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		final Container container=this.getContentPane();
		String[][] colValue=new String[0][0];
		final DefaultTableModel modeltable=new DefaultTableModel(colValue,colName);//创建默认
		final JTable table=new JTable(modeltable);
		JScrollPane jspane=new JScrollPane(table);
		getContentPane().add(jspane,BorderLayout.CENTER);
		table.setRowSorter(new TableRowSorter<>(modeltable));//设置表格排序器
		jspane.setViewportView(table);
		JPanel panel=new JPanel();//创建面板
		container.add(panel,BorderLayout.NORTH);
		panel.add(new JLabel("图书编号"));
		nametext=new JTextField("",5);
		panel.add(nametext);
		JButton select=new JButton("查找");
		select.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bookname=new String(nametext.getText());
				String str="select * from booksinfo_Table where id="+bookname;
				Database d=new Database();
				conn=d.getConnection();//连接数据库
				try {
					pstm=conn.prepareStatement(str);
					res=pstm.executeQuery();
					ResultSetMetaData rsmd=pstm.getMetaData();//获取一个ResultSetMetaData实例
					while(res.next()){
						Vector<Object> vdata=new Vector<Object>();		
						for(int i=1;i<rsmd.getColumnCount()+1;i++)//循环将表列数据传给集合
						vdata.addElement(res.getObject(i));	
						modeltable.addRow(vdata);//在表格末增加行
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
		});
		panel.add(select);
	}
}
