package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

import BUS.TaiKhoanBus;
import DAL.DBConnect;
import DTO.LoaisachDTO;
import DTO.TaiKhoan;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class LoginForm extends JFrame {

	/**
	 * Launch the application.
	 */
	public Preferences pref = Preferences.userRoot().node("Rememberme");
	public static int quyen;
	public static boolean isdangnhap = true;
	public static boolean dangnhap = false;
	public static String username = "";
	public static ArrayList<TaiKhoan> taikhoan = null;

	public void loadtaikhoan() {
		taikhoan = null;
		TaiKhoanBus bus = new TaiKhoanBus();

		taikhoan = bus.getDanhSachTL();
		for (TaiKhoan taiKhoan2 : taikhoan) {
			System.out.println("Tài Khoản :" + taiKhoan2.getUsername().trim());
			System.out.println("Mật Khẩu :" + taiKhoan2.getPassword().trim());
		}

	}

	private int x_mouse;
	private int y_mouse;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Create the frame.
	 */
	public LoginForm() {

		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 550);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 765, 590);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(
				new Font("Consolas", lblNewLabel_1.getFont().getStyle(), lblNewLabel_1.getFont().getSize() + 21));
		lblNewLabel_1.setBounds(468, 59, 107, 58);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("UserName");
		lblNewLabel_1_1.setFont(new Font("Consolas", lblNewLabel_1_1.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_1.getFont().getSize() + 8));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(378, 149, 107, 58);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("PassWord");
		lblNewLabel_1_2.setFont(new Font("Consolas", lblNewLabel_1_2.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_2.getFont().getSize() + 8));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(378, 220, 107, 58);
		panel.add(lblNewLabel_1_2);

		txtUser = new JTextField();
		txtUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		txtUser.setForeground(Color.WHITE);
		txtUser.setFont(new Font("Consolas", txtUser.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_2.getFont().getSize() + 2));
		txtUser.setBackground(new Color(206, 182, 149));
		txtUser.setBounds(476, 161, 170, 35);
		panel.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setForeground(Color.WHITE);
		txtPass.setFont(new Font("Consolas", txtUser.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_2.getFont().getSize() + 2));

		txtPass.setBackground(new Color(206, 182, 149));
		txtPass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		txtPass.setColumns(10);
		txtPass.setBounds(478, 232, 170, 35);
		panel.add(txtPass);

		JButton btnNewButton = new JButton("LOGIN");

		btnNewButton.setBounds(468, 325, 119, 58);
		panel.add(btnNewButton);

		JLabel lblexit = new JLabel("");
		lblexit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblexit.setIcon(new ImageIcon("img\\Delete.png"));
		lblexit.setBounds(613, 44, 35, 35);
		panel.add(lblexit);
		setSize(662, 588);

		JCheckBox checkboxrm = new JCheckBox("Remember Me");
		checkboxrm.setForeground(Color.WHITE);
		checkboxrm.setBackground(new Color(0, 0, 0, 0));
		checkboxrm.setFont(
				new Font("Consolas", checkboxrm.getFont().getStyle() | Font.BOLD, checkboxrm.getFont().getSize() + 8));
		checkboxrm.setBounds(372, 291, 203, 25);
		panel.add(checkboxrm);
		loadtaikhoan();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (checkboxrm.isSelected()) {
					pref.put("Email", txtUser.getText());

					pref.put("Password", txtPass.getText());
				}

				for (TaiKhoan taiKhoan2 : taikhoan) {
					if (taiKhoan2.getUsername().trim().equals(txtUser.getText().trim())
							&& taiKhoan2.getPassword().trim().equals(txtPass.getText().trim())) {

						JOptionPane.showMessageDialog(contentPane, "Đăng NhậpThành Công");
						isdangnhap = true;
						dangnhap = true;
						setVisible(false);
						username = taiKhoan2.getUsername();
						if(MainFrame.isdangxuat) {
							new MainFrame().setVisible(true);
						}
						return;
					}

				}
				JOptionPane.showMessageDialog(contentPane, "Đăng Nhập Không Thành Công");
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\loginform.png"));
		lblNewLabel.setBounds(-25, -12, 691, 628);
		panel.add(lblNewLabel);
		setBackground(new Color(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0, 0));
		addEvent();
		setLocationRelativeTo(null);
		String usr = null;
		usr = pref.get("Email", usr);
		String pass = null;
		pass = pref.get("Password", pass);
		txtUser.setText(usr);
		txtPass.setText(pass);

	}

	public void savenmailpass(String Email, String Pass) {
		if (Email == null || Pass == null) {
			System.out.println("Loi khong luu duoc email passs");

		} else {
			String user = Email;
			pref.put("Email", Email);
			String pass = Pass;
			pref.put("Password", pass);

		}
	}

	public void checked(boolean remember) {
		if (remember) {
			savenmailpass(txtUser.getText(), txtPass.getText());
		} else {
			System.out.println("null");
		}
	}

	private void moveFrame(int x, int y) {
		// TODO Auto-generated method stub
		this.setLocation(x - x_mouse, y - y_mouse);
	}

	public void addEvent() {

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				x_mouse = arg0.getX();
				y_mouse = arg0.getY();

			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				moveFrame(arg0.getXOnScreen(), arg0.getYOnScreen());

			}

		});

	}
}
