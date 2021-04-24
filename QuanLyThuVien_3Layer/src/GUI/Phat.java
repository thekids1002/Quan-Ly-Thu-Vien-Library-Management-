package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.PhatBus;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Phat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Phat() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Phiếu Mượn");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 42, 119, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(163, 46, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phạt");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(32, 112, 58, 28);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hỏng Sách");
		chckbxNewCheckBox.setBounds(82, 115, 113, 25);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mất Sách");
		chckbxNewCheckBox_1.setBounds(210, 115, 113, 25);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Không Đúng Sách đã mượn");
		chckbxNewCheckBox_2.setBounds(82, 159, 113, 25);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Lý do khác");
		chckbxNewCheckBox_3.setBounds(210, 159, 113, 25);
		contentPane.add(chckbxNewCheckBox_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số Tiền Phạt");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(32, 217, 106, 28);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 218, 129, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int mapm = Integer.parseInt(textField.getText());
				String lydo = "" ;
				if(chckbxNewCheckBox.isSelected()) {
					lydo = "Hỏng Sách" ;
				}
				else if(chckbxNewCheckBox_1.isSelected()) {
					lydo ="Mất Sách" ;
				}
				else if(chckbxNewCheckBox_2.isSelected()) {
					lydo = "Không Đúng Sách Đã Mượn"; 
				}
				else if(chckbxNewCheckBox_3.isSelected()) {
					lydo = "Khác" ;
				}
				String tienphat = textField_1.getText() ;
				
				DTO.Phat phat = new DTO.Phat(0, mapm, lydo, tienphat) ;
				if(PhatBus.gI().themke(phat) > 0) {
					JOptionPane.showMessageDialog(contentPane, "Thêm Phiếu Phạt Thành Công");
				}
				else{JOptionPane.showMessageDialog(contentPane, "Thêm Phiếu Phạt Thất Bại");

				}
				dispose();
				
			}
		});
		btnNewButton.setBounds(237, 269, 97, 25);
		contentPane.add(btnNewButton);
		textField.setText(MainFrame.Ma);
		setLocationRelativeTo(null);
	}
	
}
