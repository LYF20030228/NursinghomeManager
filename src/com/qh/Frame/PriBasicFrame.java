package com.qh.Frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.*;

import com.qh.Modal.BasicInfo;
import com.qh.Modal.LoginIofo;
import com.qh.Modal.MyTableModel;
import com.qh.Tools.JDBC;


public class PriBasicFrame
{
	public JTable Table;
	private List list;
	private JComboBox comboBox,comboBox_2;
	//�������
	private Vector<String> titles=new Vector();
	//�������
	private Vector<Vector<Object>> data=new Vector<>();
	JFrame frame =new JFrame("������Ϣ��ѯ");
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	public PriBasicFrame()
	{
		
		
		//������ز���
		//��ʼ������
		titles.addElement("���");
		titles.addElement("����");
		titles.addElement("�Ա�");
		titles.addElement("����");
		titles.addElement("ְҵ");
		titles.addElement("״̬");
		
		//�������ݿ�
		JDBC jdbcConnection=new JDBC();
		
		//��ȡ����������Ϣ
		try {
			String sql="select * from JiBenXinXi where name='���³�';";
			ResultSet res=jdbcConnection.executeQuery(sql);
			int count=1;											//���
			while(res.next())
			{
				Vector<Object> dataRow=new Vector<>();				//һ������
				dataRow.add(count++);
				dataRow.add(res.getString("name"));
				dataRow.add(res.getString("sex"));
				dataRow.add(res.getString("age"));
				dataRow.add(res.getString("job"));
				dataRow.add(res.getString("state"));
				data.add(dataRow);
			}
//			System.out.println(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�����������ݴ������ģ��
		MyTableModel model=new MyTableModel(data,titles);
		
		//��ģ������ʼ�����
		Table=new JTable(model);
		
		//��ȡ���ͷ
		JTableHeader departmentHeader=Table.getTableHeader();
		//��ȡ�����
		Table.setFont(new Font(null,Font.PLAIN,12));			
		Table.setForeground(Color.BLACK);						
		Table.setGridColor(Color.BLACK);						
		Table.setRowHeight(20);								
		Table.setSelectionBackground(Color.yellow);			
		Table.setSelectionForeground(Color.red);	
		Table.setBounds(0,10,200,100);
		
		//���õ���ѡ��
		Table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//�������
		TableColumn columnCount=Table.getColumn(titles.get(0));		//��ȡ�����
		TableColumn columnNo=Table.getColumn(titles.get(1));	
		TableColumn columnName=Table.getColumn(titles.get(2));
		TableColumn columnType=Table.getColumn(titles.get(3));
		columnCount.setMaxWidth(40);											//�����������
		columnNo.setMinWidth(80);
		columnType.setMaxWidth(40);
		columnName.setMaxWidth(80);
		

		frame.setBounds(100, 100, 533, 250);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		this.Table.setVisible(false);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JScrollPane scrollPane = new JScrollPane(Table);
		scrollPane.setBounds(0, 0, 521, 94);
		frame.getContentPane().add(scrollPane);
		
		btnNewButton = new JButton("�� �� �� ѯ");
		btnNewButton.setBounds(55, 136, 146, 31);
		btnNewButton.setForeground(Color.red);
		btnNewButton.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("ȡ      ��");
		btnNewButton_1.setBounds(306, 136, 139, 31);
		btnNewButton_1.setForeground(Color.red);
		btnNewButton_1.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PriBasicFrame.this.Table.setVisible(true);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.validate();
		
	}
}