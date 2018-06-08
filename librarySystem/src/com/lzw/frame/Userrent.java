package com.lzw.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.lzw.database.Database;

public class Userrent extends JFrame{

	/**
	 * 
	 */JTextField idtext;
		JTextField nametext;
		JTextField authortext;
		JTextField publishtext;
		JTextField pricetext;
		JTextField	rentname;
		JTextField	date;
	static Connection conn;
	static Statement sql;
	static ResultSet res;
	static PreparedStatement pstm;
	String[] colName={"图书编号","图书名称","图书作者","出版社","价格","借阅者","借书时间"};//表列名;
	private static final long serialVersionUID = 1L;
	public  Userrent(){
		super();
		this.setTitle("图书管理系统用户界面");
		this.setVisible(true);
		this.setBounds(100,70,1200,700);//设置窗体位置和大小
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);;
		JMenu jm=new JMenu("系统操作");
		JMenuItem jt1=new JMenuItem("退出");
		jm.add(jt1);
		jmb.add(jm);
		//菜单
		String[][] colValue=new String[0][0];
		final DefaultTableModel modeltable=new DefaultTableModel(colValue,colName);//创建默认
		final JTable table=new JTable(modeltable);
		JScrollPane jspane=new JScrollPane(table);
		getContentPane().add(jspane,BorderLayout.CENTER);
		table.setRowSorter(new TableRowSorter<>(modeltable));//设置表格排序器
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter(){//添加鼠标监听事件
			public void mouseClicked(MouseEvent e){
			Object oa=modeltable.getValueAt(table.getSelectedRow(), 0);
			Object ob=modeltable.getValueAt(table.getSelectedRow(), 1);
			Object oc=modeltable.getValueAt(table.getSelectedRow(), 2);
			Object od=modeltable.getValueAt(table.getSelectedRow(), 3);
			Object oe=modeltable.getValueAt(table.getSelectedRow(), 4);
			Object of=modeltable.getValueAt(table.getSelectedRow(), 5);
			Object oh=modeltable.getValueAt(table.getSelectedRow(), 6);
			rentname.setText(String.valueOf(oa));
			idtext.setText(String.valueOf(ob));
			nametext.setText(String.valueOf(oc));
			authortext.setText(String.valueOf(od));
			publishtext.setText(String.valueOf(oe));
			pricetext.setText(String.valueOf(of));
			date.setText(String.valueOf(oh));
			}
		});
		jspane.setViewportView(table);
		JPanel panel=new JPanel();//创建面板
		getContentPane().add(panel,BorderLayout.NORTH);
		JButton rentbutton=new JButton("显示全部借阅图书");
		JButton deltable=new JButton("清空列表");
		rentbutton.addActionListener(new ActionListener(){//设置显示所有图书信息添加按钮监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="select * from booksinfo_Table,userrent_Table where booksinfo_Table.id=userrent_Table.id";
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
		panel.add(rentbutton);
		deltable.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<modeltable.getRowCount();i++)
					modeltable.removeRow(i);
			}
			
		});
		panel.add(deltable);
	}
}
