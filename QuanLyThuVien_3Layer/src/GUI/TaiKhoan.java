package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAL.DBConnect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel UserName = new JLabel("UserName");
		UserName.setBounds(36, 86, 93, 39);
		getContentPane().add(UserName);
		
		txtusername = new JTextField();
		txtusername.setBounds(160, 86, 284, 39);
		getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(36, 165, 93, 39);
		getContentPane().add(lblPass);
		
		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBounds(160, 165, 284, 39);
		getContentPane().add(txtpass);
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idtaikhoan = DesignLai.idtaikhoan; 
					
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
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(246, 280, 97, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Quy\u1EC1n");
		lblNewLabel.setBounds(36, 232, 68, 32);
		getContentPane().add(lblNewLabel);
		
		txtquyen = new JTextField();
		txtquyen.setBounds(160, 232, 284, 32);
		getContentPane().add(txtquyen);
		txtquyen.setColumns(10);

	}
}
