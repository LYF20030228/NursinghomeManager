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
import com.qh.Tools.GetRelativePaths;


public class StayManageFrame
{
	private JTable Table;
	private List list;
	private JComboBox comboBox,comboBox_2;
	//�������
	private Vector<String> titles=new Vector();
	//�������
	private Vector<Vector<Object>> data=new Vector<>();
	JFrame frame =new JFrame("ס�޹���");
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollBar scrollBar;
	
	public StayManageFrame()
	{
		
		
		//������ز���
		//��ʼ������
		titles.addElement("���");
		titles.addElement("����");
		titles.addElement("�Ա�");
		titles.addElement("�����");
		titles.addElement("��λ��");
		titles.addElement("�绰");
		titles.addElement("״̬");
		
		//�������ݿ�
		JDBC jdbcConnection=new JDBC();
		
		//��ȡ����������Ϣ
		try {
			String sql="select * from ZhuSuXinXi;";
			ResultSet res=jdbcConnection.executeQuery(sql);
			int count=1;											//���
			while(res.next())
			{
				Vector<Object> dataRow=new Vector<>();				//һ������
				dataRow.add(count++);
				dataRow.add(res.getString("name"));
				dataRow.add(res.getString("sex"));
				dataRow.add(res.getString("roomnum"));
				dataRow.add(res.getString("bednum"));
				dataRow.add(res.getString("tel"));
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
		TableColumn columnTyp=Table.getColumn(titles.get(4));
		TableColumn columnTe=Table.getColumn(titles.get(5));
		columnCount.setMaxWidth(40);											//�����������
		columnNo.setMaxWidth(80);
		columnType.setMaxWidth(40);
		columnName.setMaxWidth(80);
		columnTe.setMinWidth(100);
		columnTyp.setMaxWidth(40);

		frame.setBounds(100, 100, 533, 345);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JScrollPane scrollPane = new JScrollPane(Table);
		scrollPane.setBounds(0, 0, 521, 143);
		frame.getContentPane().add(scrollPane);
		
		scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		btnNewButton = new JButton("��  ��  ��  ��");
		btnNewButton.setBounds(313, 153, 155, 31);
		btnNewButton.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("��  ��  ɾ  ��");
		btnNewButton_1.setBounds(313, 202, 155, 31);
		btnNewButton_1.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("��  ��  ��  ��");
		btnNewButton_2.setBounds(313, 254, 155, 31);
		btnNewButton_2.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 141, 242, 179);
		ImageIcon loginIcon=GetRelativePaths.add("Every.jpg");
		lblNewLabel.setIcon(loginIcon);
		lblNewLabel.setOpaque(true);
		frame.getContentPane().add(lblNewLabel);
		
		
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.validate();
		//ɾ������
		btnNewButton_1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					int result=JOptionPane.showConfirmDialog(frame, "ȷ��ɾ�������˵�ס����Ϣ��","��ʾ",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION)
					{
						int selectedRow=Table.getSelectedRow();
						//�����ݿ���ɾ����������
						String oldNo=(String) model.getValueAt(selectedRow, 1);
						String sql="delete from ZhuSuXinXi where name='"+oldNo+"'";
						jdbcConnection.executeUpdate(sql);
						int alterRow=selectedRow+1;
						for(int i=alterRow;i<model.getRowCount();i++)
						{
							model.setValueAt(alterRow++, i, 0);			//��Ÿ���
						}
						model.removeRow(selectedRow);					//��ģ�����Ƴ�����
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������Ϣ��");
				}
				
			}
		});
		//�޸Ĺ���
		btnNewButton_2.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					StayEditorFrame stayeditorFrame=new StayEditorFrame(Table.getSelectedRow(),model);
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���Ϣ��");
				}
			
			}
		});
		//��ӹ���
		btnNewButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			StayAddFrame stayaddFrame=new StayAddFrame();
			}
		});
	}
}