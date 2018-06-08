package com.lzw.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.lzw.database.Database;

public class Loginframe extends JFrame{
	
	private static final long serialVersionUID = 1L;
	boolean flag;//为单选按钮事件设置标志值
	public  void Createlogin(){
	  JFrame jf=new JFrame("系统登录");
	  jf.setResizable(false);
	  JPanel panel1=new JPanel();  
	  JPanel panel2=new JPanel();
	  final JTextField jt1=new JTextField("",17);
	  final JPasswordField jt2=new JPasswordField("",17);
	  JButton jb1=new JButton("登录");
	  JButton jb2=new JButton("注册"); 
	  final JRadioButton jrb1=new JRadioButton("管理员");
	  final JRadioButton jrb2=new JRadioButton("用户");
	  ButtonGroup bg=new ButtonGroup();
	  bg.add(jrb1);
	  bg.add(jrb2);
	  JLabel jlabel1=new JLabel("学号:");
	  JLabel jlabel2=new JLabel("密码:");
	  
	  panel1.add(jlabel1);//将文本标签添加到面板内
	  panel1.add(jt1); 
	  panel1.add(jlabel2);
	  panel1.add(jt2);
	  panel1.setBounds(40, 40, 100, 20);
	  panel2.add(jrb1);
	  panel2.add(jrb2);
	  panel2.add(jb1);
	  panel2.add(jb2);
	  panel2.setBounds(50, 100, 150, 100);
	  jf.add(panel2);
	  jf.add(panel1);
	  
	  jf.setVisible(true);
	  jf.setBounds(400, 200, 250,250);
	  jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	  
	  jrb1.addActionListener(new ActionListener(){//管理员单选按钮监听事件

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag=true;
		}
		  
	  });
	  jrb2.addActionListener(new ActionListener(){//用户单选按钮监听事件

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag=false;
		}
		  
	  });
	  jb1.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){//登录按钮的监听事件
			  String user=new String(jt1.getText());
			  String userpsw=new String(jt2.getPassword());
			  if(flag==true&&Database.checkLogin(user, userpsw)){
				  new Mainframe();	  
			  }
			  else if(flag==false&&Database.checkLogins(user, userpsw)){
				  new Userrent();
			  }
			  else{
				  JOptionPane.showMessageDialog(Loginframe.this, "用户名或密码不匹配","登录失败", JOptionPane.ERROR_MESSAGE);
				  return;
				  } 
		  }
	  });
	  jb2.addActionListener(new ActionListener(){//注册按钮的监听事件

		@Override
		public void actionPerformed(ActionEvent e) {
			if(flag==true)
			{
				new Register();
			}
			else if(flag==false){
				new Registeruser();
			}
		}	  
	  });	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loginframe login=new Loginframe();
		login.Createlogin();
	}
}
