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
	private JTable table;// 定义表格
	private JTextField txtKey;// 定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;// 定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;// 设置排序规则

	public Mainframe() {
		setTitle("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 356);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 球员查询
		JButton btnNewButton = new JButton("\u7403\u5458\u67E5\u8BE2");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				funone f = new  funone();
				f.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 164, 35);
		contentPane.add(btnNewButton);

		// 新增球员
		JButton btnNewButton_1 = new JButton("\u65B0\u589E\u7403\u5458");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				funtwo f = new funtwo();
				f.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBounds(171, 10, 164, 35);
		contentPane.add(btnNewButton_1);

		// 球员交易
		JButton btnNewButton_2 = new JButton("\u7403\u5458\u4EA4\u6613");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funthree f = new funthree();
				f.setVisible(true);			
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(335, 10, 172, 35);
		contentPane.add(btnNewButton_2);

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(10, 44, 497, 210);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "姓名", "身高", "体重", "球队", "球员号", "场均得分");
		Vector<Vector> stuInfo = new PageController().getPaegData();// 获取第一页的数据

//				使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {// 获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		sorter = new TableRowSorter<DefaultTableModel>(model);// 设置排序器
		table.setAutoCreateRowSorter(true);
		;// 设置表格自动排序

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

//		JLabel lblKey = new JLabel("输入关键字：");
//		lblKey.setBounds(44, 21, 79, 15);
//		contentPane.add(lblKey);
//
//		txtKey = new JTextField();
//		txtKey.setBounds(117, 18, 119, 21);
//		contentPane.add(txtKey);
//		txtKey.setColumns(10);
//
//		// 定义查找按钮
//		JButton btnFind = new JButton("查找");
//		btnFind.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String key = txtKey.getText().trim();// 获取输入关键字文本框的值
//				if (key.length() != 0) {
//					sorter.setRowFilter(RowFilter.regexFilter(key));// 是否包含输入框的值
//				} else {
//					sorter.setRowFilter(null);// 不过滤，显示所有数据
//				}
//			}
//		});
//		btnFind.setBounds(246, 16, 95, 25);
//		contentPane.add(btnFind);

		JButton btnPre = new JButton("上一页");
		btnPre.addActionListener(new ActionListener() {// 上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().prePage(), titles);// 设置数据模型中的数据为上一页内容
				table.setModel(model);// 设置表格的数据模型

			}
		});
		btnPre.setBounds(10, 264, 95, 25);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("下一页");
		btnNext.addActionListener(new ActionListener() {// 下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().nextPage(), titles);// 设置数据模型中的数据为下一页内容
				table.setModel(model);// 设置表格的数据模型
			}
		});
		btnNext.setBounds(171, 264, 95, 25);
		contentPane.add(btnNext);

		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setBounds(398, 288, 65, 15);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] { 3, 5, 10, 15, 20 });
		comboBox.addItemListener(new ItemListener() {// 页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize = Integer.valueOf(comboBox.getSelectedItem().toString());// 获取下拉框所选的值
				PageController pcl = new PageController();
				pcl.setCountPerpage(pageSize);// 设置每页显示记录条数
				model = new DefaultTableModel(pcl.getPaegData(), titles);// 设置数据模型
				table.setModel(model);// 设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);// 设置下拉框默认值
		comboBox.setBounds(452, 284, 55, 23);
		contentPane.add(comboBox);


	}

}
