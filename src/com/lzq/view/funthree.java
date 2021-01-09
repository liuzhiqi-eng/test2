package com.lzq.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzq.dao.exchange;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class funthree extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					funthree frame = new funthree();
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
	public funthree() {
		setTitle("\u7403\u5458\u4EA4\u6613");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(35, 53, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u7403\u961F");
		lblNewLabel_1.setBounds(24, 134, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(99, 50, 160, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 131, 160, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String teamid = textField_1.getText();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "球员不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}else if(teamid.equals("")){
					JOptionPane.showMessageDialog(null, "球队号", "tip", JOptionPane.WARNING_MESSAGE);
				}else {
					int ans = exchange.toadd(name, teamid);
				if(ans==0){
					JOptionPane.showMessageDialog(null, "球员不存在", "tip", JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "交易成功", "tip", JOptionPane.WARNING_MESSAGE);
					cl();
				}
				}
				
				
			}
		});
		btnNewButton.setBounds(125, 205, 122, 23);
		contentPane.add(btnNewButton);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

	public void cl() {
		this.dispose();
	}
}
