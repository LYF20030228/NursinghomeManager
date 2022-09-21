package com.qh.Frame;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.*;
import com.qh.Tools.GetRelativePaths;

public class UserFrame extends JFrame
{
	JTree tree;
	public UserFrame() 
	{
		setTitle("����Ժϵͳ�û�����");
		setBounds(100, 100, 725, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		tree = new JTree();
		tree.setBackground(new Color(255, 228, 196));
		tree.addTreeSelectionListener(new MyTreeListener_1());
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("����Ժ�û�����") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("��Ϣ����");
					node_1.add(new DefaultMutableTreeNode("������Ϣ"));
					node_1.add(new DefaultMutableTreeNode("ס����Ϣ"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("���ò�ѯ");
					node_1.add(new DefaultMutableTreeNode("�շ���ϸ"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("�������");
					node_1.add(new DefaultMutableTreeNode("�޸�����"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("��������");
					node_1.add(new DefaultMutableTreeNode("�����Ϣ"));
					node_1.add(new DefaultMutableTreeNode("������ּ"));
					add(node_1);
				}
			}
		));
		panel_1.add(tree);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ըÿһλ�������彡����",SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 21));
		panel.add(lblNewLabel);
		
		JLabel theold = new JLabel("the old");
		ImageIcon loginIcon=GetRelativePaths.add("User.jpg");
		theold.setIcon(loginIcon);
		theold.setOpaque(true);
		
		JLabel text = new JLabel("text");
		text.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon loginIcon1=GetRelativePaths.add("text.jpg");
		text.setIcon(loginIcon1);
		text.setOpaque(true);
		
		getContentPane().add(theold, BorderLayout.CENTER);
		getContentPane().add(text, BorderLayout.SOUTH);
		setVisible(true);
	}
	//����ڵ��¼�
	class MyTreeListener_1 implements TreeSelectionListener
	{
		public void valueChanged(TreeSelectionEvent e)
		{
			if (e.getSource() == tree)
			{
				//���屻ѡ�еĽڵ�
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(node.isLeaf()) {
					//��ȡҶ�ڵ���������ı���Ϣ
					String str = node.toString();
					if (str.equals("������Ϣ"))	new PriBasicFrame();
					if (str.equals("ס����Ϣ"))	new PriStayFrame();
					if (str.equals("�շ���ϸ"))	new PriFeeFrame();
					if (str.equals("�޸�����"))	new PassModiFrame();
					if (str.equals("�����Ϣ"))	new AboutUsFrame();
					if (str.equals("������ּ"))	new ServiceTenetFrame();
				}
			}
		}
	}
	
}
