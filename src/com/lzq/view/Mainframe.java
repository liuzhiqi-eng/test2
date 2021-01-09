package com.lzq.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.lzq.util.PageController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Mainframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Vector<String> titles;
	private JTable table;// ������
	private JTextField txtKey;// ������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;// ����������
	private ArrayList<RowSorter.SortKey> sortKeys;// �����������

	public Mainframe() {
		setTitle("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 356);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ��Ա��ѯ
		JButton btnNewButton = new JButton("\u7403\u5458\u67E5\u8BE2");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				funone f = new  funone();
				f.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 164, 35);
		contentPane.add(btnNewButton);

		// ������Ա
		JButton btnNewButton_1 = new JButton("\u65B0\u589E\u7403\u5458");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				funtwo f = new funtwo();
				f.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBounds(171, 10, 164, 35);
		contentPane.add(btnNewButton_1);

		// ��Ա����
		JButton btnNewButton_2 = new JButton("\u7403\u5458\u4EA4\u6613");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funthree f = new funthree();
				f.setVisible(true);			
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_2.setBounds(335, 10, 172, 35);
		contentPane.add(btnNewButton_2);

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(10, 44, 497, 210);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����", "���", "����", "���", "��Ա��", "�����÷�");
		Vector<Vector> stuInfo = new PageController().getPaegData();// ��ȡ��һҳ������

//				ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {// ��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		sorter = new TableRowSorter<DefaultTableModel>(model);// ����������
		table.setAutoCreateRowSorter(true);
		;// ���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ

//		JLabel lblKey = new JLabel("����ؼ��֣�");
//		lblKey.setBounds(44, 21, 79, 15);
//		contentPane.add(lblKey);
//
//		txtKey = new JTextField();
//		txtKey.setBounds(117, 18, 119, 21);
//		contentPane.add(txtKey);
//		txtKey.setColumns(10);
//
//		// ������Ұ�ť
//		JButton btnFind = new JButton("����");
//		btnFind.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String key = txtKey.getText().trim();// ��ȡ����ؼ����ı����ֵ
//				if (key.length() != 0) {
//					sorter.setRowFilter(RowFilter.regexFilter(key));// �Ƿ����������ֵ
//				} else {
//					sorter.setRowFilter(null);// �����ˣ���ʾ��������
//				}
//			}
//		});
//		btnFind.setBounds(246, 16, 95, 25);
//		contentPane.add(btnFind);

		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {// ��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().prePage(), titles);// ��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);// ���ñ�������ģ��

			}
		});
		btnPre.setBounds(10, 264, 95, 25);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {// ��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().nextPage(), titles);// ��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);// ���ñ�������ģ��
			}
		});
		btnNext.setBounds(171, 264, 95, 25);
		contentPane.add(btnNext);

		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setBounds(398, 288, 65, 15);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] { 3, 5, 10, 15, 20 });
		comboBox.addItemListener(new ItemListener() {// ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize = Integer.valueOf(comboBox.getSelectedItem().toString());// ��ȡ��������ѡ��ֵ
				PageController pcl = new PageController();
				pcl.setCountPerpage(pageSize);// ����ÿҳ��ʾ��¼����
				model = new DefaultTableModel(pcl.getPaegData(), titles);// ��������ģ��
				table.setModel(model);// ���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);// ����������Ĭ��ֵ
		comboBox.setBounds(452, 284, 55, 23);
		contentPane.add(comboBox);


	}

}
