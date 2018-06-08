package com.lzw.frame;

import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.lzw.database.Database;
import com.lzw.model.Booksinfo;
import com.lzw.model.Userrent;
public class Mainframe extends JFrame{
		JTextField idtext;
		JTextField nametext;
		JTextField authortext;
		JTextField publishtext;
		JTextField pricetext;
		JTextField counttext;
		JTextField idtext2;
		JTextField	rentname;
		JTextField	date;
		static Connection conn;
		static Statement sql;
		static ResultSet res;
		static PreparedStatement pstm;
		String[] colName={"图书编号","图书名称","图书作者","出版社","价格"};//表列名;
	private static final long serialVersionUID = 1L;
	public Mainframe(){
		super();
		this.setTitle("图书管理系统图书信息管理界面");
		this.setVisible(true);
		setBounds(100,50,1100,700);//设置窗体位置和大小
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		final Container container=this.getContentPane();
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);;
		JMenu jm=new JMenu("系统操作");
		JMenu seljm=new JMenu("查询");
		JMenuItem jt1=new JMenuItem("退出");
		JMenuItem jt2=new JMenuItem("查询");
		seljm.add(jt2);
		jm.add(jt1);
		jmb.add(jm);
		jmb.add(seljm);
		jt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}			
		});
		jt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SelectJframe();
			}			
		});
		//菜单		
		String[][] colValue=new String[0][0];
		final DefaultTableModel modeltable=new DefaultTableModel(colValue,colName);//创建默认
		final JTable table=new JTable(modeltable);
		JScrollPane jspane=new JScrollPane(table);
		container.add(jspane,BorderLayout.CENTER);
		table.setRowSorter(new TableRowSorter<>(modeltable));//设置表格排序器
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter(){//添加表格一鼠标监听事件
			public void mouseClicked(MouseEvent e){//为文本标签设置鼠标点击的一行表格元素的值
			Object oa=modeltable.getValueAt(table.getSelectedRow(), 0);
			Object ob=modeltable.getValueAt(table.getSelectedRow(), 1);
			Object oc=modeltable.getValueAt(table.getSelectedRow(), 2);
			Object od=modeltable.getValueAt(table.getSelectedRow(), 3);
			Object oe=modeltable.getValueAt(table.getSelectedRow(), 4);
			idtext.setText(String.valueOf(oa));
			nametext.setText(String.valueOf(ob));
			authortext.setText(String.valueOf(oc));
			publishtext.setText(String.valueOf(od));
			pricetext.setText(String.valueOf(oe));
			}
		});
		jspane.setViewportView(table);
		JPanel panel=new JPanel();//创建面板
		container.add(panel,BorderLayout.NORTH);
		panel.add(new JLabel("图书编号"));//向面板添加标签组件
		idtext=new JTextField("",5);
		panel.add(idtext);
		panel.add(new JLabel("图书名称"));
		nametext=new JTextField("",8);
		panel.add(nametext);
		panel.add(new JLabel("图书作者"));
		authortext=new JTextField("",8);
		panel.add(authortext);
		panel.add(new JLabel("出版社"));
		publishtext=new JTextField("",8);
		panel.add(publishtext);
		panel.add(new JLabel("单价"));
		pricetext=new JTextField("",5);
		panel.add(pricetext);
		JButton addbutton=new JButton("添加");
		JButton delbutton=new JButton("删除");
		JButton selbutton=new JButton("全部库存图书");
		JButton keepbutton=new JButton("保存");
		JButton tabledel=new JButton("清空列表");
		addbutton.addActionListener(new ActionListener(){//设置添加按钮监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//向表格添加元素
				String[] rowValues={idtext.getText(),nametext.getText(),authortext.getText(),
						publishtext.getText(),pricetext.getText()};
				modeltable.addRow(rowValues);
				Booksinfo booksinfo=new Booksinfo();
				//为Booksinfo中变量赋文本组件获取到的值
				booksinfo.setid(String.valueOf(idtext.getText().trim()));
				booksinfo.setname(String.valueOf(nametext.getText().trim()));
				booksinfo.setauthor(String.valueOf(authortext.getText().trim()));
				booksinfo.setpublish(String.valueOf(publishtext.getText().trim()));
				booksinfo.setprice(Float.parseFloat(String.valueOf(pricetext.getText().trim())));
				Database.insertOrupdate(booksinfo);//调用com.lzw.database包Database类下方法
				JOptionPane.showMessageDialog(Mainframe.this, "添加成功!");
			}
			
		});
		panel.add(addbutton);
		delbutton.addActionListener(new ActionListener(){//设置删除添加按钮监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedrow=table.getSelectedRow();
				if(selectedrow!=-1)
					//删除表格中数据
					modeltable.removeRow(selectedrow);
				Booksinfo booksinfo=new Booksinfo();
				booksinfo.setid(String.valueOf(idtext.getText().trim()));
				booksinfo.setname(String.valueOf(nametext.getText().trim()));
				booksinfo.setauthor(String.valueOf(authortext.getText().trim()));
				booksinfo.setpublish(String.valueOf(publishtext.getText().trim()));
				booksinfo.setprice(Float.parseFloat(String.valueOf(pricetext.getText().trim())));
				Database.delete(booksinfo);//调用com.lzw.database包Database类下方法删除数据库中元素
				JOptionPane.showMessageDialog(Mainframe.this, "删除成功!");
			}
			
		});
		panel.add(delbutton);
		selbutton.addActionListener(new ActionListener(){//设置显示所有图书信息添加按钮监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String str="select * from booksinfo_Table";
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
		panel.add(selbutton);
		tabledel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					for(int i=0;i<modeltable.getRowCount();i++)
						modeltable.removeRow(i);
			}
			
		});
		panel.add(tabledel);
		keepbutton.addActionListener(new ActionListener(){//存盘监听事件
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Booksinfo booksinfo=new Booksinfo();
				//为Booksinfo中变量赋文本组件获取到的值
				booksinfo.setid(String.valueOf(idtext.getText().trim()));
				booksinfo.setname(String.valueOf(nametext.getText().trim()));
				booksinfo.setauthor(String.valueOf(authortext.getText().trim()));
				booksinfo.setpublish(String.valueOf(publishtext.getText().trim()));
				booksinfo.setprice(Float.parseFloat(String.valueOf(pricetext.getText().trim())));
				Database.insertOrupdate(booksinfo);//调用com.lzw.database包Database类下方法
				JOptionPane.showMessageDialog(Mainframe.this, "存盘成功!");
			}
	});
		panel.add(keepbutton);
		JPanel panel2=new JPanel();//创建面板
		container.add(panel2,BorderLayout.SOUTH);
		panel2.add(new JLabel("借阅者"));
		rentname=new JTextField("",5);
		panel2.add(rentname);
		panel2.add(new JLabel("图书编号"));//向面板添加标签组件
		idtext2=new JTextField("",8);
		panel2.add(idtext2);
		panel2.add(new JLabel("借阅日期"));
		date=new JTextField("",10);
		panel2.add(date);
		JButton rentbutton=new JButton("借阅");
		JButton returnbutton=new JButton("还书");
		rentbutton.addActionListener(new ActionListener(){//借书按钮监听器

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Userrent user=new Userrent();
				//为Userrent中变量赋文本组件获取到的值
				user.setusername(String.valueOf(rentname.getText().trim()));
				user.setrentbookid(String.valueOf(idtext2.getText().trim()));
				user.setrentdate(String.valueOf(date.getText().trim()));
				Database.getUserrent(user);
				JOptionPane.showMessageDialog(Mainframe.this, "借书成功!");//调用com.lzw.database包Database类下方法
				}
		});
		panel2.add(rentbutton);
		returnbutton.addActionListener(new ActionListener(){//还书按钮监听器

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Userrent user=new Userrent();
				//为Userrent中变量赋文本组件获取到的值
				user.setusername(String.valueOf(rentname.getText().trim()));
				user.setrentbookid(String.valueOf(idtext2.getText().trim()));
				user.setrentdate(String.valueOf(date.getText().trim()));
				Database.delUserrent(user);//调用com.lzw.database包Database类下方法
				JOptionPane.showMessageDialog(Mainframe.this, "还书成功!");
			}
			
		});
		panel2.add(returnbutton);
		
	}
}
