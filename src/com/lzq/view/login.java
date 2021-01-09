package com.lzq.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lzq.dao.logindao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * 登入注册
 * @author Administrator
 *
 */
public class login extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 64, 54, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(46, 134, 54, 21);
		contentPane.add(lblNewLabel_1);

		idtext = new JTextField();
		idtext.setBounds(111, 66, 181, 21);
		contentPane.add(idtext);
		idtext.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(110, 136, 183, 21);
		contentPane.add(passwordField);

		// 登录
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idtext.getText();
				String password = passwordField.getText();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "ID不能为空", "标题", JOptionPane.WARNING_MESSAGE);
				} else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空", "标题", JOptionPane.WARNING_MESSAGE);
				} else {
					int ans = logindao.tologin(id, password);
					if (ans == 1) {
						clo();
						JOptionPane.showMessageDialog(null, "欢迎进入球员管理系统", "welcome",JOptionPane.INFORMATION_MESSAGE);
						Mainframe mfr = new Mainframe();
						mfr.setVisible(true);
					}
				}

			}
		});
		btnNewButton.setBounds(142, 200, 115, 23);
		contentPane.add(btnNewButton);

		// 注册
		JButton btnNewButton_1 = new JButton("\u7ACB\u5373\u6CE8\u518C");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register re= new register();
				re.setVisible(true);
				clo();
			}
		});
		btnNewButton_1.setBounds(331, 228, 93, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("\u7403\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(158, 10, 155, 31);
		contentPane.add(lblNewLabel_2);

		// 给窗体添加背景图
		ImageIcon image = new ImageIcon("images/back.jpg");
		JLabel frame = new JLabel(image);// 万能的JLabel，2333
		frame.setBounds(0, 0, 450, 300);// 图片位置和大小
		getContentPane().add(frame);

	}
	
	public void clo() {
		this.dispose();
		login lo = new login();

	}
}
