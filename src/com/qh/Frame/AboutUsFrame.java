package com.qh.Frame;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.qh.Tools.GetRelativePaths;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.ScrollPane;

public class AboutUsFrame {

	private JFrame frame;
	private JTextField textField;

	public AboutUsFrame() {
		frame = new JFrame("��������");
		frame.setBounds(300, 100, 450, 500);

		ScrollPane scrollPane = new ScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
		
		JTextArea textAreaOutput;
		textAreaOutput = new JTextArea("���Դʴʵ�", 14, 20);
		textAreaOutput.setSelectedTextColor(Color.RED);
		textAreaOutput.setLineWrap(true);        //�����Զ����й��� 
		textAreaOutput.setWrapStyleWord(true);            // ������в����ֹ���
		textAreaOutput.setText("    �ھ����·�չ��������Ϣ���ĵ���,�����˾ӻ���Ҫ��Ҳ��������,˽������Ժ����ӿ��,"
				+ "�漴�������費ƥ������.����Ժ����ϵͳ�������ʵ��ּ�ڴ�˽������Ժ�����Ż�,"
				+ "�ṩ���������Ч�ʵ����ƹ�����ϵ.Ϊ������ҵ�ṩ�����㡢����ݡ�����ȫ�������Ի��ķ�������������Ժס��������һ����Ϊ�Ӵ��Ⱥ�壬"
				+ "Ϊ�˹���ķ�����ͳһ��ͬʱҲΪ�����˵İ�ȫ��������Ҫ������������Ϣ�ļ�¼�����ŶԴ������˼�������ǿ�����һ���򵥱���������Ժ����ϵͳ��"
				+ "��һϵͳ���з���Ҫʵ���Ĵ��ܡ���CRUD������CRUD���ֱ���Ӣ�ĵ��ʡ�create,require,update,delete������д,"
				+ "�����ļ��׵�˵����Ϊ����Ϣ�Ĵ�������ѯ�����¡�ɾ����"
				+ "����ȸ��С���������ȫ������ϵͳ���ĸ����������˶�����Ժ��Ϣ����Ļ���Ҫ��\r\n"
				+ "    ��ϵͳ��Ҫ����Ծ���Ժ������Ա������Ա��Ա����Ƶġ�����Ժ����ϵͳ��IT����Ϊ����Ժ�ṩһ���ӿڱ��ڹ�����Ϣ,�洢���˸�����Ϣ��������Ϣ,"
				+ "���Һ͸�����Ϣ������Ժ����,��ʡ��Ա�����Ͷ�ʱ��,��󽵵��˳ɱ���\r\n"
				+ "    ����Ҫ���ܰ������û�����Ա��Ա����¼���Ӵ��������˹������ù��� ���Ϲ���ͳ�Ʒ�����Ա�������ϵͳ���á�"
				+ "�Լ�����Щ���ܵ�����ɾ���ġ��鴦��");
		textAreaOutput.setFont(new Font("����", Font.BOLD, 15));
		scrollPane.add(textAreaOutput, BorderLayout.CENTER);
		
		
		JLabel theold = new JLabel("New label");
		ImageIcon loginIcon=GetRelativePaths.add("Aboutus.jpg");
		theold.setIcon(loginIcon);
		theold.setOpaque(true);
		frame.getContentPane().add(theold, BorderLayout.NORTH);
		frame.setResizable(false);
	}
}
