package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAL.DBConnect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class TaiKhoan extends JDialog {
	private JTextField txtusername;
	private JTextField txtpass;
	private JTextField txtquyen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiKhoan frame = new TaiKhoan();
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
	public TaiKhoan() {
		setBounds(100, 100, 621, 455);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel UserName = new JLabel("UserName");
		UserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		UserName.setBounds(82, 61, 93, 39);
		getContentPane().add(UserName);
		
		txtusername = new JTextField(20);
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtusername.setBounds(206, 61, 284, 39);
		getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPass.setBounds(82, 140, 93, 39);
		getContentPane().add(lblPass);
		
		txtpass = new JPasswordField(20);
		txtpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpass.setColumns(10);
		txtpass.setBounds(206, 141, 284, 39);
		getContentPane().add(txtpass);
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idtaikhoan = MainFrame.idtaikhoan; 
					
					String user = txtusername.getText();
					String pass = txtpass.getText();
					int quyen = Integer.parseInt(txtquyen.getText());
					String sql = "insert into taikhoan values( '"+idtaikhoan+"','"+user+"' ,'"+pass+" ', '"+quyen+"' ) ";
					Connection conn = DBConnect.getConnection();
					Statement stm = conn.createStatement();
					int i = stm.executeUpdate(sql);
					if(i > 0) {
						JOptionPane.showMessageDialog(null, "Thêm Tài Khoản Thành Công");
						setVisible(false);
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Nhân viên này đã có tài khoản! Nếu quên mật khẩu vui lòng liên hệ quản trị viên.");
					
				}
			}
		});
		btnNewButton.setBounds(266, 309, 97, 39);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Quy\u1EC1n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(82, 223, 68, 32);
		getContentPane().add(lblNewLabel);
		
		txtquyen = new JTextField();
		txtquyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtquyen.setBounds(206, 221, 284, 39);
		getContentPane().add(txtquyen);
		txtquyen.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("THÊM TÀI KHOẢN");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(241, 0, 162, 45);
		getContentPane().add(lblNewLabel_1);
		setLocationRelativeTo(null);

	}
}
