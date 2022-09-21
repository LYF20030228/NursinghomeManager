package com.qh.Frame;

import java.awt.*;
import javax.swing.*;

import com.qh.Modal.LoginIofo;
import com.qh.Tools.*;
import java.awt.event.*;
/**
 * 
 * @author QH20010724
 * @version 1.0
 */


//�ҵĴ�����
public class LoginFrame extends JFrame
{
	private static JTextField username;
	public JPasswordField password;
	//���췽��
	public LoginFrame()
	{
		setResizable(false);
		setTitle("����Ժ����ϵͳ��¼����");
		setBounds(0,0,500,500);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������
		JLabel UserName = new JLabel("�û�����");
		UserName.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		UserName.setBounds(104, 305, 90, 31);
		
		JLabel Password = new JLabel("���룺");
		Password.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		Password.setBounds(104, 346, 90, 31);

		JButton adminLogin = new JButton("����Ա��¼");
		adminLogin.setBackground(Color.WHITE);
		adminLogin.setForeground(Color.RED);
		adminLogin.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		adminLogin.setBounds(43, 402, 107, 33);
		adminLogin.addActionListener(new adminLoginListener());
		getContentPane().add(adminLogin);
		
		JButton userLogin = new JButton("�û���¼");
		userLogin.setBackground(Color.WHITE);
		userLogin.setForeground(Color.RED);
		userLogin.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		userLogin.setBounds(195, 402, 107, 33);
		userLogin.addActionListener(new userLoginListener());	
		
		JLabel image = new JLabel("image");
		ImageIcon loginIcon=GetRelativePaths.add("Login.jpg");
		image.setIcon(loginIcon);
		image.setOpaque(true);
		image.setBounds(0, 0, 648,300);
		
		JButton register = new JButton("���û�ע��");
		register.setBackground(Color.WHITE);
		register.setForeground(Color.RED);
		register.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		register.setBounds(345, 402, 107, 33);
		register.addActionListener(new registerListener());	
		
		username = new JTextField();
		username.setBounds(231, 303, 203, 31);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(231, 346, 203, 31);
		password.setEchoChar('*');
		//������
		getContentPane().add(UserName);
		getContentPane().add(Password);
		getContentPane().add(userLogin);
		getContentPane().add(image);
		getContentPane().add(username);
		getContentPane().add(password);
		getContentPane().add(register);
		//������ÿ��ӻ�������һЩ���������
		setVisible(true);
	}
	class adminLoginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			LoginIofo user = JDBC.checkadmin(username.getText(), password.getText());
			if (user.getName() != null) {

				try {

					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
					LoginFrame.this.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "�������");
				username.setText("");
				password.setText("");
			}
		}
	}
	class userLoginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			LoginIofo user = JDBC.checkuser(username.getText(), password.getText());
			if (user.getName() != null) {

				try {

					UserFrame frame = new UserFrame();
					frame.setVisible(true);
					LoginFrame.this.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "�������");
				username.setText("");
				password.setText("");
			}
		}
	}
	class registerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			RegisterFrame frame = new RegisterFrame();
			frame.setVisible(true);
		}
	}
}