package com.qh.Frame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.qh.Tools.JDBC;
import com.qh.Tools.GetRelativePaths;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BasicAddFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public BasicAddFrame()
	{
		frame = new JFrame("������Ϣ���");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��   ����");
		lblNewLabel.setBounds(21, 10, 66, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 12, 81, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("��   ��");
		lblNewLabel_1.setBounds(21, 54, 66, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 54, 81, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("��   �䣺");
		lblNewLabel_2.setBounds(21, 97, 66, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 98, 81, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ְ   ҵ��");
		lblNewLabel_3.setBounds(21, 151, 66, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 149, 81, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("״   ̬��");
		lblNewLabel_4.setBounds(241, 151, 66, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(330, 152, 81, 25);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel image = new JLabel("image");
		ImageIcon loginIcon=GetRelativePaths.add("Editor.jpg");
		image.setIcon(loginIcon);
		image.setOpaque(true);
		image.setBounds(255, 0, 183,132);
		frame.getContentPane().add(image);
		
		JButton btnNewButton = new JButton("ȷ   ��");
		btnNewButton.setBounds(69, 202, 93, 34);
		btnNewButton.addActionListener(new RegisterListener());
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ȡ   ��");
		btnNewButton_1.setBounds(214, 202, 93, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		
		//ȡ������
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
		frame.setVisible(true);
		

	}
//��ӹ���
class RegisterListener implements ActionListener {	
	public void actionPerformed(final ActionEvent e) {
		if(textField.getText().length()==0){
			JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
			return;
		}
		if(textField_1.getText().length()==0){
			JOptionPane.showMessageDialog(null, "�Ա���Ϊ�գ�");
			return;
		}
		if(textField_2.getText().length()==0){
			JOptionPane.showMessageDialog(null, "���䲻��Ϊ�գ�");
			return;
		}
		if(textField_3.getText().length()==0){
			JOptionPane.showMessageDialog(null, "ְҵ����Ϊ�գ�");
			return;
		}
		if(textField_4.getText().length()==0){
			JOptionPane.showMessageDialog(null, "״̬����Ϊ�գ�");
			return;
		}

		//��ȡ�ı����������
		String name =textField.getText();
		String sex =textField_1.getText();
		String age =textField_2.getText();
		String job =textField_3.getText();
		String state =textField_4.getText();
		
		int i=JDBC.Insertold(name,sex,age,job,state);
			
		if(i==1){
		
			JOptionPane.showMessageDialog(null, "������Ϣ��ӳɹ�����ˢ�º�鿴��");
		}
	}
}
		
	
}
