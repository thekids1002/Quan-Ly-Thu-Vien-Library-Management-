package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelLoaiSach extends JFrame {

	private JPanel contentPane;
	public static JPanel PanelLoaiSach;
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTable table;
	private JTextField txtSreach;
	private JLabel btnSreach;
	private JRadioButton rdtimtheoten;
	private JRadioButton rdtimtheoma;
	private DefaultTableModel dtmloaisach;
	boolean flag, flag1;
	private JLabel btnthem;
	private JLabel btnsua;
	private JLabel btnxoa;
	private JLabel btnreload;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelLoaiSach frame = new PanelLoaiSach();
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
	public PanelLoaiSach() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelLoaiSach = new JPanel();
		PanelLoaiSach.setBounds(0, 0, 1105, 672);
		PanelLoaiSach.setBackground(new Color(240, 240, 240));
		contentPane.add(PanelLoaiSach);
		PanelLoaiSach.setLayout(null);

		JLabel lblLoaiSach = new JLabel("Lo\u1EA1i S\u00E1ch");
		lblLoaiSach.setLabelFor(this);
		lblLoaiSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoaiSach.setBounds(12, 0, 207, 39);
		PanelLoaiSach.add(lblLoaiSach);

		JLabel lblMaLoai = new JLabel("M\u00E3 Lo\u1EA1i");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaLoai.setBounds(12, 117, 112, 39);
		PanelLoaiSach.add(lblMaLoai);

		JLabel lblTenLoai = new JLabel("T\u00EAn Lo\u1EA1i");
		lblTenLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenLoai.setBounds(12, 182, 112, 39);
		PanelLoaiSach.add(lblTenLoai);

		txtMaLoai = new JTextField();

		txtMaLoai.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				if (!flag && (txtMaLoai.getText().equals(" ") || txtMaLoai.getText().isEmpty())) {
					flag1 = true;
					String string = "Mã Loại Không Được Bỏ Trống";
					JOptionPane.showMessageDialog(contentPane, string, "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
					txtMaLoai.requestFocus();

					;
				} else {
					flag1 = false;
				}
				System.out.println(flag1);
				return;
			}
		});
		txtMaLoai.setBounds(124, 118, 197, 39);

		PanelLoaiSach.add(txtMaLoai);
		txtMaLoai.setColumns(10);

		txtTenLoai = new JTextField();
		txtTenLoai.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!flag1 && txtTenLoai.getText().isEmpty()) {
					flag = true;
					String string = "Tên loại không được bỏ trống!!";
					JOptionPane.showMessageDialog(contentPane, string);
					txtTenLoai.requestFocus();
				} else {
					flag = false;
				}
				return;
			}
		});
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(124, 182, 197, 39);
		PanelLoaiSach.add(txtTenLoai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 114, 678, 522);
		PanelLoaiSach.add(scrollPane);
		dtmloaisach = new DefaultTableModel();
		dtmloaisach.addColumn("Mã Loại");
		dtmloaisach.addColumn("Tên Loại");
		table = new JTable(dtmloaisach);
		scrollPane.setViewportView(table);

		JLabel LlbTimKiem = new JLabel("T\u00ECm Ki\u1EBFm Lo\u1EA1i S\u00E1ch");
		LlbTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		LlbTimKiem.setBounds(124, 277, 157, 39);
		PanelLoaiSach.add(LlbTimKiem);

		rdtimtheoma = new JRadioButton("T\u00ECm Theo M\u00E3");
		rdtimtheoma.setBackground(new Color(240, 240, 240));
		rdtimtheoma.setBounds(12, 325, 139, 39);
		PanelLoaiSach.add(rdtimtheoma);

		rdtimtheoten = new JRadioButton("T\u00ECm Theo T\u00EAn");
		rdtimtheoten.setBounds(233, 325, 127, 39);
		PanelLoaiSach.add(rdtimtheoten);
		txtSreach = new PlaceholderTextField("Sreach");
		txtSreach.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtSreach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSreach.setBounds(96, 387, 197, 33);
		PanelLoaiSach.add(txtSreach);
		// textField.set
		btnSreach = new JLabel("");
		btnSreach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Tìm kiếm thành công");
			}
		});
		btnSreach.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img\\search1.jpg"));
		btnSreach.setBounds(22, 373, 330, 98);
		PanelLoaiSach.add(btnSreach);

		btnthem = new JLabel("");
		btnthem.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\Them.png"));
		btnthem.setBounds(32, 476, 119, 56);

		PanelLoaiSach.add(btnthem);

		btnsua = new JLabel("");
		btnsua.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\them.png"));
		btnsua.setBounds(212, 476, 120, 56);
		PanelLoaiSach.add(btnsua);

		btnxoa = new JLabel("");
		btnxoa.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\them.png"));
		btnxoa.setBounds(32, 557, 119, 56);
		PanelLoaiSach.add(btnxoa);

		btnreload = new JLabel("");
		btnreload.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\them.png"));
		btnreload.setBounds(212, 557, 120, 56);
		PanelLoaiSach.add(btnreload);
		addEvent();

	}

	public void addEvent() {
		btnthem.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnthem.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\Them.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnthem.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\themhover.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnthem.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnthem.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\Them.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnthem.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\themhover.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnsua.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnsua.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\Them.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnsua.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\themhover.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnxoa.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnxoa.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\Them.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnxoa.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\themhover.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		
		btnreload.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnreload.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\Them.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnreload.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\themhover.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}
}
