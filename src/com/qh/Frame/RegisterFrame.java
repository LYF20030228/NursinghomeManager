package com.qh.Frame;

import java.awt.*;
import javax.swing.*;

import com.qh.Tools.*;

import java.awt.event.*;
/**
 * 
 * @author QH20010724
 * @version 1.0
 */


//�ҵĴ�����
public class RegisterFrame extends JFrame
{
	private static JTextField username,password;
	//���췽��
	public RegisterFrame()
	{
		setResizable(false);
		setTitle("���û�ע��");
		setBounds(0,0,380,450);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������
		JLabel UserName = new JLabel("�������û�����");
		UserName.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		UserName.setBounds(20, 299, 120, 31);
		
		JLabel Password = new JLabel("���������룺");
		Password.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		Password.setBounds(20, 332, 120, 31);
		
		JButton register = new JButton("ע   ��");
		register.setBackground(Color.WHITE);
		register.setForeground(Color.RED);
		register.setFont(new Font("����", Font.BOLD | Font.ITALIC, 14));
		register.setBounds(133, 373, 90, 33);
		register.addActionListener(new RegisterListener());	
		
		JLabel image = new JLabel("image");
		ImageIcon loginIcon=GetRelativePaths.add("register.jpg");
		image.setIcon(loginIcon);
		image.setOpaque(true);
		image.setBounds(0, 0, 381,300);
		
		username = new JTextField();
		username.setBounds(150, 300, 203, 31);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(150, 332, 203, 31);
		password.setColumns(10);
		password.setColumns(10);

		//������
		getContentPane().add(UserName);
		getContentPane().add(Password);
		getContentPane().add(image);
		getContentPane().add(username);
		getContentPane().add(password);
		getContentPane().add(register);
		//������ÿ��ӻ�������һЩ���������
		setVisible(true);
	}
	//ע�����
	class RegisterListener implements ActionListener {	
		public void actionPerformed(final ActionEvent e) {
			

			if(username.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
				return;
			}
			if(password.getText().length()==0){
				JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
				return;
			}
			
			String usernames=username.getText().trim();
			String passwords=password.getText().trim();
			
			int i=JDBC.Insertuser(usernames,passwords);
				
			if(i==1){
			
				JOptionPane.showMessageDialog(null, "ע��ɹ�");
			}
		}
	}
}