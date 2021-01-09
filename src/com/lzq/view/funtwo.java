package com.lzq.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzq.dao.addnewone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class funtwo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					funtwo frame = new funtwo();
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
	public funtwo() {
		setTitle("\u65B0\u589E\u7403\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(10, 24, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8EAB\u9AD8");
		lblNewLabel_1.setBounds(10, 80, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F53\u91CD");
		lblNewLabel_2.setBounds(10, 131, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7403\u961F");
		lblNewLabel_3.setBounds(10, 192, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7403\u5458\u53F7");
		lblNewLabel_4.setBounds(10, 243, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u573A\u5747\u5F97\u5206");
		lblNewLabel_5.setBounds(10, 281, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u7403\u961F\u53F7");
		lblNewLabel_6.setBounds(10, 329, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(74, 24, 110, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 77, 110, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 128, 110, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 189, 110, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(74, 237, 110, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(74, 278, 110, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(74, 326, 110, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
				String stature = textField_1.getText();
				String bodyweight = textField_2.getText();
				String location = textField_3.getText();
				String playernumber = textField_4.getText();
				String averagescorepergame = textField_5.getText();
				String teamid = textField_6.getText();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "姓名不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}
				else if(stature.equals("")) {
					JOptionPane.showMessageDialog(null, "身高不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}else if(bodyweight.equals("")) {
					JOptionPane.showMessageDialog(null, "体重不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}else if(location.equals("")) {
					JOptionPane.showMessageDialog(null, "球队不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}else if(playernumber.equals("")) {
					JOptionPane.showMessageDialog(null, "球员号不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}else if(averagescorepergame.equals("")) {
					JOptionPane.showMessageDialog(null, "场均得分不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}else if(teamid.equals("")) {
					JOptionPane.showMessageDialog(null, "球队号不能为空", "tip", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int ans  = addnewone.toadd(name, stature, bodyweight, location, playernumber, averagescorepergame, teamid);
					
					if(ans==0) {
						JOptionPane.showMessageDialog(null, "球员已存在", "tip", JOptionPane.WARNING_MESSAGE);
					}else {
						
						JOptionPane.showMessageDialog(null, "球员新增成功", "tip", JOptionPane.WARNING_MESSAGE);
						
						cl();
					}
				}
				
				
				
			}
		});
		btnNewButton.setBounds(84, 361, 93, 23);
		contentPane.add(btnNewButton);
		
		
	}
public void cl() {
	this.dispose();
}
}
