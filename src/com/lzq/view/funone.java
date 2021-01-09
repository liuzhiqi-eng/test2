package com.lzq.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzq.bean.player;
import com.lzq.dao.findao;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class funone extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					funone frame = new funone();
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
	public funone() {
		setTitle("\u7403\u5458\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textField = new JTextField();
		textField.setToolTipText("\u8BF7\u8F93\u5165\u7403\u5458\u540D\u79F0");
		textField.setBounds(10, 10, 241, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 59, 352, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 113, 352, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 153, 347, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 196, 352, 30);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 241, 352, 30);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(10, 281, 347, 30);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(10, 321, 352, 30);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				player user = findao.tofind(name);
				if (user.getAns() == 1) {
					lblNewLabel.setText("姓名："+user.getName());
					lblNewLabel_1.setText("身高："+user.getStature());
					lblNewLabel_2.setText("体重："+user.getBodyweight());
					lblNewLabel_3.setText("球队："+user.getLocation());
					lblNewLabel_4.setText("球员号："+user.getPlayernumber());
					lblNewLabel_5.setText("场均得分："+user.getAveragescorepergame());
				} else {
					JOptionPane.showMessageDialog(null, "球员不存在", "标题", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(261, 9, 101, 30);
		contentPane.add(btnNewButton);
	}
}
