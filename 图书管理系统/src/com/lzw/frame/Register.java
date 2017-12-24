package com.lzw.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.lzw.database.Database;
import com.lzw.model.Registerinfo;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField Username;
	JPasswordField Password;
	public Register(){
		super();
		this.setLayout(null);
		this.setTitle("管理员注册");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel jp1=new JPanel();
		jp1.add(new JLabel("新用户:"));
		Username=new JTextField("",10);
		jp1.add(Username);
		jp1.add(new JLabel("密码:"));
		Password=new JPasswordField("",10);
		jp1.add(Password);
		jp1.setBounds(120, 60, 120, 100);
		JPanel jp2=new JPanel();
		JButton jb=new JButton("注册");
		jp2.add(jb);
		jp2.setBounds(100, 200, 150, 40);
		
		this.add(jp2);this.add(jp1);
		this.setVisible(true);
		this.setBounds(100, 50, 400, 300);
		this.setResizable(false);
		jb.addActionListener(new ActionListener(){//注册按钮监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Registerinfo rsi=new Registerinfo();
				rsi.setUsername(String.valueOf(Username.getText().trim()));
				rsi.setPassword(String.valueOf(Password.getPassword()));
				Database.getRegisterMannger(rsi);
				JOptionPane.showMessageDialog(Register.this, "注册成功!");
			}
			
		});
	}
}
