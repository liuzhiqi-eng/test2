package com.lzq.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzq.util.registerTool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField idt;
	private JPasswordField password1;
	private JPasswordField password2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 51, 102));
		lblNewLabel.setBounds(29, 36, 72, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 51, 102));
		lblNewLabel_1.setBounds(29, 109, 72, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 51, 102));
		lblNewLabel_2.setBounds(29, 183, 72, 18);
		contentPane.add(lblNewLabel_2);

		idt = new JTextField();
		idt.setBounds(99, 38, 191, 24);
		contentPane.add(idt);
		idt.setColumns(10);

		password1 = new JPasswordField();
		password1.setBounds(99, 107, 191, 24);
		contentPane.add(password1);

		password2 = new JPasswordField();
		password2.setBounds(99, 181, 191, 24);
		contentPane.add(password2);

		// 注册
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setForeground(new Color(255, 51, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idt.getText();
				String passwordf = password1.getText();
				String passwordf1 = password2.getText();

				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "用戶名不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else if (passwordf.equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else if (passwordf1.equals("")) {
					JOptionPane.showMessageDialog(null, "请再次输入密码", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else if (!passwordf.equals(passwordf1)) {
					JOptionPane.showMessageDialog(null, "密码不一致", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else {

					if (registerTool.tores(id, passwordf) == 1) {
						JOptionPane.showMessageDialog(null, "注册成功", "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);
						clo();
						login framee = new login();
						framee.setVisible(true);
					}

				}
			}
		});
		btnNewButton.setBounds(99, 269, 169, 27);
		contentPane.add(btnNewButton);

		// 给窗体添加背景图
		ImageIcon image = new ImageIcon("images/basketfly.jpg");
		JLabel frame = new JLabel(image);// 万能的JLabel，2333
		frame.setBounds(0, 0, 850, 882);// 图片位置和大小
		getContentPane().add(frame);
	}

	public void clo() {
		this.dispose();
		login lo = new login();

	}
}
