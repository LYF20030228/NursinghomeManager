package com.qh.Frame;

import java.awt.*;
import javax.swing.tree.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.*;
import com.qh.Tools.GetRelativePaths;

public class AdminFrame extends JFrame
{
	JTree tree;
	public AdminFrame() 
	{
		setTitle("����Ժ����ϵͳ");
		setBounds(100, 100, 725, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		//����������ý��
		tree = new JTree();
		tree.setBackground(new Color(255, 228, 196));
		tree.addTreeSelectionListener(new MyTreeListener_1());
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("����Ժ����ϵͳ") {
				{
					DefaultMutableTreeNode node;
					node = new DefaultMutableTreeNode("���˹���");
					node.add(new DefaultMutableTreeNode("������Ϣ"));
					node.add(new DefaultMutableTreeNode("ס�޹���"));
					add(node);
					node = new DefaultMutableTreeNode("���ù���");
					node.add(new DefaultMutableTreeNode("������ϸ"));
					add(node);
					node = new DefaultMutableTreeNode("��������");
					node.add(new DefaultMutableTreeNode("�����Ϣ"));
					node.add(new DefaultMutableTreeNode("������ּ"));
					add(node);
				}
			}
		));
		 panel_1.add(tree);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		
		JLabel username = new JLabel("�û�����Qi.H",SwingConstants.LEFT);
		username.setFont(new Font("����", Font.BOLD, 21));
		panel.add(username);
		
		JLabel theold = new JLabel("the old");
		ImageIcon loginIcon=GetRelativePaths.add("User.jpg");
		theold.setIcon(loginIcon);
		theold.setOpaque(true);
		
		JLabel text = new JLabel("text");
		text.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon loginIcon1=GetRelativePaths.add("text.jpg");
		text.setIcon(loginIcon1);
		text.setOpaque(true);
		//������
		getContentPane().add(panel_1, BorderLayout.WEST);
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(theold, BorderLayout.CENTER);
		getContentPane().add(text, BorderLayout.SOUTH);

		
		
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
					if (str.equals("ס�޹���"))	new StayManageFrame();
					if (str.equals("�����Ϣ"))	new AboutUsFrame();
					if (str.equals("������Ϣ"))	new BasicManageFrame();
					if (str.equals("������ϸ"))	new FeeManageFrame();
					if (str.equals("������ּ"))	new ServiceTenetFrame();
				}
			}
		}
	}
	

}