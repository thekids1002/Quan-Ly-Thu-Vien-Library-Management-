package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;

import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import BUS.LoaiBUS;
import BUS.SachBus;
import DAL.DBConnect;
import DTO.LoaisachDTO;
import DTO.SachDTO;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.Button;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class OldFrame extends JDialog {

	private JPanel contentPane, paneldanhmuc, panelmuonsach, paneltra, paneldmsach, panelloaisach, paneldocgia,
			panelnxb;
	private JTextField txtMaloaisach;
	private JTextField txtTenSach;
	private JTable tbl_loaisach;
	private JRadioButton rdbtimtheoma, rdbtimtheoten;
	private JTextField txtTimKiem;
	private JLayeredPane layeredPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_1;
	private JTextField textField_9;
	private JTabbedPane tabbedPane;
	private JPanel paneltabblemuontra;
	private JLabel lblNewLabel_10, lblThemdmsach_1, lblSuaTTLoaiSach;
	private JTable table_2;
	private JTable table_3;
	private JTextField txtMasosach;
	private JTextField txtTenSach1;
	private JTextField txtmaNXB;
	private JTable table_DMSach;
	private JTextField txtNamxb;
	private JTextField txtsl;
	private DefaultTableModel dtmloai, dtmsach, dtmdocgia, dtmnxb, dtmtg, dtmnhanvien;
	private ButtonGroup btng;
	private JComboBox cmbloai;

	ArrayList<LoaisachDTO> dsloai;
	private JLabel lblXoaLoaiSach;
	private JLabel lblThemdmsach;
	private JLabel lblsuattsach;
	private JLabel lblXoaDMSach;
	private JLabel lblThemdocgia;
	private JLabel lblchinhsuadocgia;
	private JLabel lblxoadocgia;
	private JLabel lbldanhsachmuon;
	private JLabel lblthemmoi;
	private JLabel lblsuadoi;
	private JLabel lbldanhsachtra;
	private Panel loaisach_menutop;
	private Panel dmsach_menutop;
	private Panel docgia_menutop;
	private DefaultTableModel dtmphieumuon;
	private DefaultTableModel dtmlichsutra;
	private JPanel ThongKeSachPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {

				} catch (InstantiationException ex) {

				} catch (IllegalAccessException ex) {

				} catch (javax.swing.UnsupportedLookAndFeelException ex) {

				}
				try {
					OldFrame frame = new OldFrame();
					ImageIcon img = new ImageIcon("img/iconsgu.png");
					frame.setIconImage(img.getImage());
					frame.setTitle("Quản Lý Thư Viện SGU");
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
	public OldFrame() {
		setModal(true);
		// setIconImage(new ImageIcon("/img/iconsgu.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		JmenuBar();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00FD Th\u01B0 Vi\u1EC7n", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.RED));
		tabbedPane.setBounds(6, 6, 1250, 638);
		contentPane.add(tabbedPane);

		paneldanhmuc = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n L\u00FD Danh M\u1EE5c", null, paneldanhmuc, null);
		paneldanhmuc.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 103, 1233, 467);
		paneldanhmuc.add(layeredPane);

		paneltabblemuontra = new JPanel();
		tabbedPane.addTab("Quản Lý Mượn - Trả Sách", null, paneltabblemuontra, null);
		paneltabblemuontra.setLayout(null);

		JPanel panelthongke = new JPanel();
		tabbedPane.addTab("Báo Cáo - Thống Kê", null, panelthongke, null);
		panelthongke.setLayout(null);

		JPanel sachco = new JPanel();
		sachco.setBounds(0, 5, 169, 77);
		panelthongke.add(sachco);
		sachco.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Sách Còn Lại");
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\book_open.png"));
		lblNewLabel_12.setBounds(6, 6, 157, 71);
		sachco.add(lblNewLabel_12);

		JPanel sachdamuon = new JPanel();
		sachdamuon.setBounds(173, 5, 169, 77);
		panelthongke.add(sachdamuon);
		sachdamuon.setLayout(null);

		JLabel lblNewLabel_12_1 = new JLabel("Sách Đã Mượn");
		lblNewLabel_12_1.setOpaque(true);
		lblNewLabel_12_1
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\sach.png"));
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12_1.setBounds(6, 6, 157, 71);
		sachdamuon.add(lblNewLabel_12_1);

		JPanel docgiamuon = new JPanel();
		docgiamuon.setBounds(343, 5, 169, 77);
		panelthongke.add(docgiamuon);
		docgiamuon.setLayout(null);

		JLabel lblNewLabel_12_2 = new JLabel("Đọc Giả Mượn");
		lblNewLabel_12_2.setOpaque(true);
		lblNewLabel_12_2
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\book.png"));
		lblNewLabel_12_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12_2.setBounds(6, 6, 157, 71);
		docgiamuon.add(lblNewLabel_12_2);

		JPanel sachconlai = new JPanel();
		sachconlai.setBounds(514, 5, 169, 77);
		panelthongke.add(sachconlai);
		sachconlai.setLayout(null);

		JLabel lblNewLabel_12_3 = new JLabel("Sách Còn Lại");
		lblNewLabel_12_3.setOpaque(true);
		lblNewLabel_12_3
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\caution.png"));
		lblNewLabel_12_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12_3.setBounds(0, 6, 157, 71);
		sachconlai.add(lblNewLabel_12_3);

		JPanel thethuvien = new JPanel();
		thethuvien.setBounds(687, 5, 169, 77);
		panelthongke.add(thethuvien);
		thethuvien.setLayout(null);

		JLabel lblNewLabel_12_4 = new JLabel("Thẻ Thư Viện");
		lblNewLabel_12_4.setOpaque(true);
		lblNewLabel_12_4.setIcon(new ImageIcon(
				"C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\bank-card-back-side.png"));
		lblNewLabel_12_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12_4.setBounds(6, 6, 157, 71);
		thethuvien.add(lblNewLabel_12_4);
		
	    ThongKeSachPanel = new JPanel();
		ThongKeSachPanel.setBounds(0, 92, 1216, 478);
		/* CHỖ NÀY VẼ PIE CHART */
		 DefaultPieDataset p=new DefaultPieDataset();

		    // Ratio of fruits
		    // Apple:Orange:Mango:Guava = 20:30:40:10
		    p.setValue("Apple",20);
		    p.setValue("Orange",30);
		    p.setValue("Mango",40);
		    p.setValue("Guava",10);

		    // Create a 3D chart with the given title that appears above the chart
		    JFreeChart chart=ChartFactory.createPieChart3D("Popular fruits this season",p);

		    // Get a ui representation of the pie chart title so that you can customize
		    // the font and padding
		    TextTitle tt=new TextTitle("Popular fruits this season",new Font("Arial",Font.BOLD,14));

		    // Space around the text and between its border
		    // top, left, bottom, right
		    tt.setPadding(5,5,5,5);
		    chart.setTitle(tt);

		    // Get the PiePlot object so that you can customize the label font
		    final PiePlot3D plot = (PiePlot3D) chart.getPlot();
		    plot.setLabelFont(new Font("Arial",Font.PLAIN,12));
		    ChartPanel panel=new ChartPanel(chart);
		    
		    // Set some preferred size
		    panel.setPreferredSize(new Dimension(1216,478));
		    
		    // Add the panel
		    ThongKeSachPanel.add(panel);
		
		/*
		 * KẾT THÚC VẼ PIE CHART
		 */
		panelthongke.add(ThongKeSachPanel);

		JPanel panelnhanvien = new JPanel();
		tabbedPane.addTab("Nhân Viên", null, panelnhanvien, null);
		if (LoginForm.quyen == 1) {

		}
		panelnhanvien.setLayout(null);

		JPanel panelloaisach = new JPanel();
		panelloaisach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelloaisach.setBackground(Color.lightGray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelloaisach.setBackground(new Color(214, 217, 233));
			}
		});
		panelloaisach.setBorder(
				new TitledBorder(null, "DS Nh\u00E2n Vi\u00EAn", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		panelloaisach.setBounds(6, 6, 132, 83);
		panelnhanvien.add(panelloaisach);
		panelloaisach.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("DSNV");
		lblNewLabel_13.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_13.setIcon(new ImageIcon(
				"C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\people-icon-people-icon-transparent-background-person-symbol-115826872.jpg"));
		lblNewLabel_13.setBounds(6, 6, 120, 58);
		panelloaisach.add(lblNewLabel_13);

		JPanel panelloaisach_1 = new JPanel();
		panelloaisach_1.setLayout(null);
		panelloaisach_1.setBorder(new TitledBorder(null, "\u0110\u0103ng K\u00FD NV", TitledBorder.CENTER,
				TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		panelloaisach_1.setBounds(147, 6, 132, 83);
		panelnhanvien.add(panelloaisach_1);

		JLabel lblNewLabel_13_1 = new JLabel("Thêm");
		lblNewLabel_13_1
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\peopleadd.png"));
		lblNewLabel_13_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_13_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_13_1.setBounds(6, 6, 120, 58);
		panelloaisach_1.add(lblNewLabel_13_1);

		JPanel panelloaisach_2 = new JPanel();
		panelloaisach_2.setLayout(null);
		panelloaisach_2.setBorder(new TitledBorder(null, "S\u1EEDa DSNV", TitledBorder.CENTER, TitledBorder.BOTTOM,
				null, new Color(59, 59, 59)));
		panelloaisach_2.setBounds(284, 6, 132, 83);
		panelnhanvien.add(panelloaisach_2);

		JLabel lblNewLabel_13_2 = new JLabel("Sửa");
		lblNewLabel_13_2
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\peopleedi.png"));
		lblNewLabel_13_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_13_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_13_2.setBounds(6, 6, 120, 58);
		panelloaisach_2.add(lblNewLabel_13_2);

		JPanel panelloaisach_3 = new JPanel();
		panelloaisach_3.setLayout(null);
		panelloaisach_3.setBorder(new TitledBorder(null, "Xo\u00E1 DSNV", TitledBorder.CENTER, TitledBorder.BOTTOM,
				null, new Color(59, 59, 59)));
		panelloaisach_3.setBounds(428, 6, 132, 83);
		panelnhanvien.add(panelloaisach_3);

		JLabel lblNewLabel_13_3 = new JLabel("Xoá");
		lblNewLabel_13_3.setIcon(
				new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\user-remove-512.png"));
		lblNewLabel_13_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_13_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_13_3.setBounds(6, 6, 120, 58);
		panelloaisach_3.add(lblNewLabel_13_3);

		JPanel panelloaisach_3_1 = new JPanel();
		panelloaisach_3_1.setLayout(null);
		panelloaisach_3_1.setBorder(new TitledBorder(null, "\u0110\u0103ng Xu\u1EA5t", TitledBorder.CENTER,
				TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		panelloaisach_3_1.setBounds(572, 6, 132, 83);
		panelnhanvien.add(panelloaisach_3_1);

		JLabel lblNewLabel_13_3_1 = new JLabel("Thoát");
		lblNewLabel_13_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new LoginForm().setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_13_3_1
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\logout.png"));
		lblNewLabel_13_3_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_13_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_13_3_1.setBounds(6, 6, 120, 58);
		panelloaisach_3_1.add(lblNewLabel_13_3_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(405, 143, 796, 427);
		panelnhanvien.add(scrollPane);
		dtmnhanvien = new DefaultTableModel();
		dtmnhanvien.addColumn("Mã Nhân Viên");
		dtmnhanvien.addColumn("Họ Và Tên");
		dtmnhanvien.addColumn("Giới Tính");
		dtmnhanvien.addColumn("Địa Chỉ");
		dtmnhanvien.addColumn("Năm sinh");
		dtmnhanvien.addColumn("Ngày vào làm");
		dtmnhanvien.addColumn("SĐT");
		tablenhanvien = new JTable(dtmnhanvien);
		scrollPane.setViewportView(tablenhanvien);

		JLabel lbltennhanvien = new JLabel("Tên Nhân Viên");
		lbltennhanvien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbltennhanvien.setBounds(6, 146, 98, 27);
		panelnhanvien.add(lbltennhanvien);

		txttennhanvien = new JTextField();
		txttennhanvien.setBounds(116, 140, 232, 33);
		panelnhanvien.add(txttennhanvien);
		txttennhanvien.setColumns(10);

		txtgioitinhnhanvien = new JTextField();
		txtgioitinhnhanvien.setColumns(10);
		txtgioitinhnhanvien.setBounds(116, 182, 232, 33);
		panelnhanvien.add(txtgioitinhnhanvien);

		JLabel lblgioitinh = new JLabel("Giới Tính");
		lblgioitinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblgioitinh.setBounds(6, 188, 98, 27);
		panelnhanvien.add(lblgioitinh);

		txtdiachinhanvien = new JTextField();
		txtdiachinhanvien.setColumns(10);
		txtdiachinhanvien.setBounds(116, 227, 232, 33);
		panelnhanvien.add(txtdiachinhanvien);

		JLabel lbldiachi = new JLabel("Địa Chỉ");
		lbldiachi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbldiachi.setBounds(6, 233, 98, 27);
		panelnhanvien.add(lbldiachi);

		txtnamsinhnhanvien = new JTextField();
		txtnamsinhnhanvien.setColumns(10);
		txtnamsinhnhanvien.setBounds(116, 272, 232, 33);
		panelnhanvien.add(txtnamsinhnhanvien);

		JLabel lblNmSinh = new JLabel("Năm Sinh");
		lblNmSinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNmSinh.setBounds(6, 278, 98, 27);
		panelnhanvien.add(lblNmSinh);

		txtngayvaolam = new JTextField();
		txtngayvaolam.setColumns(10);
		txtngayvaolam.setBounds(116, 317, 232, 33);
		panelnhanvien.add(txtngayvaolam);

		JLabel lblNgyVoLm = new JLabel("Ngày Vào Làm");
		lblNgyVoLm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNgyVoLm.setBounds(6, 323, 98, 27);
		panelnhanvien.add(lblNgyVoLm);

		txtsdtnhanvien = new JTextField();
		txtsdtnhanvien.setColumns(10);
		txtsdtnhanvien.setBounds(116, 364, 232, 33);
		panelnhanvien.add(txtsdtnhanvien);

		JLabel lblSinThoi_1 = new JLabel("Số Điện Thoại");
		lblSinThoi_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSinThoi_1.setBounds(6, 370, 98, 27);
		panelnhanvien.add(lblSinThoi_1);

		JLabel lblSinThoi_1_1 = new JLabel("Quyền");
		lblSinThoi_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSinThoi_1_1.setBounds(6, 419, 98, 27);
		panelnhanvien.add(lblSinThoi_1_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Admin");
		rdbtnNewRadioButton.setFont(new Font("Consolas", rdbtnNewRadioButton.getFont().getStyle(),
				rdbtnNewRadioButton.getFont().getSize() + 3));
		rdbtnNewRadioButton.setBounds(116, 423, 115, 18);
		panelnhanvien.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNhnVin = new JRadioButton("Nhân Viên");
		rdbtnNhnVin.setBounds(243, 423, 115, 18);
		panelnhanvien.add(rdbtnNhnVin);
		quanlymuontra();

		menutop();
		/* chỗ này để các layer panel vào */
		loaisachpane();
		DMSACH();
		docgia();
		panelnhaxuatban();
		/*
		 * kết thúc layer panel
		 */
		// loadAllData();
		addEvent();

	}

	public void loadAllData() {
		loadtablesach();
		loadtableloai();
		loadcmbloai();
	}

	public void quanlymuontra() {

		JPanel panelmuontra_menu = new JPanel();
		panelmuontra_menu.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00FD M\u01B0\u1EE3n Tr\u1EA3",
				TitledBorder.LEFT, TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		panelmuontra_menu.setBounds(0, 6, 1221, 107);
		paneltabblemuontra.add(panelmuontra_menu);
		panelmuontra_menu.setLayout(null);

		lbldanhsachmuon = new JLabel("Danh Sách\r\n Mượn");
		lbldanhsachmuon.setOpaque(true);
		lbldanhsachmuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_10.setText("Danh Sách Mượn");
				panelmuonsach.setVisible(true);
				paneltra.setVisible(false);
			}
		});
		lbldanhsachmuon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbldanhsachmuon.setIcon(new ImageIcon(
				"C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\reader-1713700-1453871.png"));
		lbldanhsachmuon.setBounds(16, 6, 190, 86);
		panelmuontra_menu.add(lbldanhsachmuon);
		lblthemmoi = new JLabel("   Thêm Mới");
		lblthemmoi.setOpaque(true);
		lblthemmoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(contentPane, "Đã Thêm Thành Công");

			}
		});
		lblthemmoi
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\add - v1.png"));
		lblthemmoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblthemmoi.setBounds(210, 6, 190, 86);
		panelmuontra_menu.add(lblthemmoi);

		lblsuadoi = new JLabel("     Sửa đổi");
		lblsuadoi.setOpaque(true);
		lblsuadoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Đã Sửa Thành Công");
			}
		});
		lblsuadoi.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\61456.png"));
		lblsuadoi.setFont(new Font("Times New Roman", Font.BOLD, 16));

		lblsuadoi.setBounds(406, 6, 190, 86);
		panelmuontra_menu.add(lblsuadoi);

		lbldanhsachtra = new JLabel("DS Trả");
		lbldanhsachtra.setOpaque(true);
		lbldanhsachtra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_10.setText("Danh Sách Trả");
				panelmuonsach.setVisible(false);
				paneltra.setVisible(true);

			}
		});
		lbldanhsachtra
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\list.png"));
		lbldanhsachtra.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbldanhsachtra.setBounds(600, 6, 190, 86);
		panelmuontra_menu.add(lbldanhsachtra);

		lblNewLabel_10 = new JLabel("Mượn Sách");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_10.setBounds(10, 125, 200, 36);
		paneltabblemuontra.add(lblNewLabel_10);

		paneltra = new JPanel();
		paneltra.setBackground(new Color(224, 255, 255));
		paneltra.setBounds(0, 159, 1221, 411);
		paneltabblemuontra.add(paneltra);
		paneltra.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh S\u00E1ch Phi\u1EBFu M\u01B0\u1EE3n", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(6, 6, 444, 399);
		paneltra.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(219, 23, 6, 6);
		panel_2.add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 23, 432, 357);
		panel_2.add(scrollPane_2);
		dtmphieumuon = new DefaultTableModel();
		dtmphieumuon.addColumn("Mã ");
		dtmphieumuon.addColumn("Mã Đọc Giả");
		dtmphieumuon.addColumn("Mã Nhân Viên");
		dtmphieumuon.addColumn("Ngày Mượn");
		dtmphieumuon.addColumn("Tình Trạng");
		table_2 = new JTable(dtmphieumuon);

		scrollPane_2.setViewportView(table_2);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "Lịch Sử Trả Các Phiếu", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_6.setBounds(453, 6, 762, 399);
		paneltra.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(6, 22, 750, 355);
		panel_6.add(scrollPane_3);

		dtmlichsutra = new DefaultTableModel();
		dtmlichsutra.addColumn("Mã Phiếu");
		dtmlichsutra.addColumn("Mã Nhân Viên");
		dtmlichsutra.addColumn("Mã Sách");
		dtmlichsutra.addColumn("Tình Trạng");
		table_3 = new JTable(dtmlichsutra);

		scrollPane_3.setViewportView(table_3);

		panelmuonsach = new JPanel();
		panelmuonsach.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 139, 139), null));
		panelmuonsach.setBounds(0, 159, 1221, 411);
		paneltabblemuontra.add(panelmuonsach);
		panelmuonsach.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(6, 6, 388, 399);
		panelmuonsach.add(tabbedPane_1);

		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Tìm Kiếm", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Ki\u1EC3u t\u00ECm ki\u1EBFm", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(128, 0, 0)));
		panel_5.setBounds(6, 6, 376, 250);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Tìm Kiếm Theo Số Phiếu Mượn");
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(46, 48, 274, 34);
		panel_5.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Tìm Theo Mã Đọc Giả");
		rdbtnNewRadioButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnNewRadioButton_1_1.setBounds(46, 118, 274, 34);
		panel_5.add(rdbtnNewRadioButton_1_1);

		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("Tìm Theo Mã Nhân Viên");
		rdbtnNewRadioButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnNewRadioButton_1_2.setBounds(46, 183, 274, 34);
		panel_5.add(rdbtnNewRadioButton_1_2);

		textField_9 = new JTextField();
		textField_9.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(143, 188, 143), null, null));
		textField_9.setIgnoreRepaint(true);
		textField_9.setInheritsPopupMenu(true);
		textField_9.setOpaque(true);
		textField_9.setBounds(6, 289, 207, 37);
		panel_4.add(textField_9);
		textField_9.setColumns(10);

		// Button button = new Button("Tìm",new ImageIcon("img/search-512 (1).png"));
		JButton button = new JButton("Tìm Kiếm", new ImageIcon("img/search-512 (1).png"));
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBounds(219, 289, 159, 37);
		panel_4.add(button);

		JPanel panelloaisach = new JPanel();
		panelloaisach.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Thông Tin", null, panelloaisach, null);
		panelloaisach.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Số Phiếu Mượn");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11.setBounds(6, 33, 111, 31);
		panelloaisach.add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("Mã đọc giả");
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11_1.setBounds(6, 85, 111, 31);
		panelloaisach.add(lblNewLabel_11_1);

		JLabel lblNewLabel_11_2 = new JLabel("Tên đọc giả");
		lblNewLabel_11_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11_2.setBounds(6, 139, 111, 31);
		panelloaisach.add(lblNewLabel_11_2);

		JLabel lblNewLabel_11_2_1 = new JLabel("Mã Nhân Viên");
		lblNewLabel_11_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11_2_1.setBounds(6, 194, 111, 31);
		panelloaisach.add(lblNewLabel_11_2_1);

		JLabel lblNewLabel_11_2_2 = new JLabel("Tên Nhân Viên");
		lblNewLabel_11_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11_2_2.setBounds(6, 256, 111, 31);
		panelloaisach.add(lblNewLabel_11_2_2);

		textField_3 = new JTextField();
		textField_3.setBounds(129, 35, 203, 28);
		panelloaisach.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(129, 87, 203, 28);
		panelloaisach.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(129, 141, 203, 28);
		panelloaisach.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(129, 196, 203, 28);
		panelloaisach.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(129, 258, 203, 28);
		panelloaisach.add(textField_7);

		JLabel lblNewLabel_11_2_2_1 = new JLabel("Ngày Mượn");
		lblNewLabel_11_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11_2_2_1.setBounds(6, 308, 111, 31);
		panelloaisach.add(lblNewLabel_11_2_2_1);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(129, 310, 203, 28);
		panelloaisach.add(textField_8);

		JButton btnNewButton_1 = new JButton("Lưu");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(43, 341, 103, 28);
		panelloaisach.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Huỷ Thao Tác");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(216, 341, 103, 28);
		panelloaisach.add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 33, 816, 372);
		panelmuonsach.add(scrollPane);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { "1", "1", "1", "25/10/2020", null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "S\u1ED1 Phi\u1EBFu M\u01B0\u1EE3n", "M\u00E3 s\u1ED1 \u0111\u1ED9c gi\u1EA3",
						"M\u00E3 s\u1ED1 nh\u00E2n vi\u00EAn", "Ng\u00E0y M\u01B0\u1EE3n", "Ghi Ch\u00FA" }));
		scrollPane.setViewportView(table_1);
	}

	public void menutop() {
		Panel panelmenutop = new Panel();
		panelmenutop.setBounds(0, 0, 1233, 97);
		paneldanhmuc.add(panelmenutop);
		panelmenutop.setLayout(null);
		loaisach_menutop = new Panel();
		loaisach_menutop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// panel_2.setBackground(new Color(255, 250, 179));

				loadtableloai();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

		});
		loaisach_menutop.setBackground(new Color(255, 255, 255));
		loaisach_menutop.setBounds(0, 0, 306, 97);
		panelmenutop.add(loaisach_menutop);
		loaisach_menutop.setLayout(null);

		JLabel lblloaisach = new JLabel("");
		lblloaisach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelloaisach.setVisible(true);
				paneldmsach.setVisible(false);
				paneldocgia.setVisible(false);
				panelnxb.setVisible(false);

				// change background
				loaisach_menutop.setBackground(Color.cyan);
				dmsach_menutop.setBackground(Color.white);
				docgia_menutop.setBackground(Color.white);
				nxb_menutop.setBackground(Color.white);

			}
		});
		lblloaisach.setIcon(new ImageIcon("img/sach.png"));
		lblloaisach.setBounds(6, 6, 89, 71);
		loaisach_menutop.add(lblloaisach);

		JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i S\u00E1ch");
		lblNewLabel_1.setBounds(6, 75, 89, 16);
		loaisach_menutop.add(lblNewLabel_1);

		lblSuaTTLoaiSach = new JLabel("S\u1EEDa TT Lo\u1EA1i S\u00E1ch");
		lblSuaTTLoaiSach.setBackground(new Color(255, 222, 173));
		lblSuaTTLoaiSach.setOpaque(true);
		lblSuaTTLoaiSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tensach = txtTenSach.getText();

				Statement stm = null;
				try {
					int i = tbl_loaisach.getSelectedRow();
					Connection conn = DBConnect.getConnection();
					stm = conn.createStatement();
					Object vitri = dtmloai.getValueAt(i, 0);

					String sql = "update loaisach set tenloai = '" + tensach + "' where maloai = '" + vitri + "'";
					stm.executeUpdate(sql);
					dtmloai.setRowCount(0);
					loadtableloai();
					JOptionPane.showMessageDialog(contentPane, "Thành Công");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		lblSuaTTLoaiSach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSuaTTLoaiSach.setForeground(Color.BLACK);
		lblSuaTTLoaiSach.setBounds(164, 38, 136, 25);

		loaisach_menutop.add(lblSuaTTLoaiSach);

		lblXoaLoaiSach = new JLabel("Xo\u00E1 Lo\u1EA1i S\u00E1ch");
		lblXoaLoaiSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				xoa_table_loaisach();

			}
		});
		lblXoaLoaiSach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblXoaLoaiSach.setBounds(164, 67, 136, 25);
		lblXoaLoaiSach.setBackground(new Color(255, 218, 185));
		lblXoaLoaiSach.setOpaque(true);
		loaisach_menutop.add(lblXoaLoaiSach);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Add.png"));
		lblNewLabel_3.setBounds(128, 10, 24, 24);
		loaisach_menutop.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Repair.png"));
		lblNewLabel_3_1.setBounds(128, 38, 24, 24);
		loaisach_menutop.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Delete.png"));
		lblNewLabel_3_2.setBounds(128, 71, 24, 24);
		loaisach_menutop.add(lblNewLabel_3_2);

		lblThemdmsach_1 = new JLabel("Thêm Sách Mới");
		lblThemdmsach_1.setOpaque(true);
		lblThemdmsach_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblThemdmsach_1.setBackground(new Color(255, 222, 173));
		lblThemdmsach_1.setBounds(164, 10, 136, 25);
		loaisach_menutop.add(lblThemdmsach_1);

		dmsach_menutop = new Panel();
		dmsach_menutop.setLayout(null);
		dmsach_menutop.setBackground(Color.WHITE);
		dmsach_menutop.setBounds(309, 0, 306, 97);
		panelmenutop.add(dmsach_menutop);

		JLabel lblDMSach = new JLabel("");
		lblDMSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cmbloai.removeAllItems();
				// loadcmbloai();
				// paneldanhmuc.setVisible(false);
				paneldocgia.setVisible(false);
				panelloaisach.setVisible(false);
				paneldmsach.setVisible(true);
				panelnxb.setVisible(false);

				loaisach_menutop.setBackground(Color.white);
				dmsach_menutop.setBackground(Color.cyan);
				docgia_menutop.setBackground(Color.white);
				nxb_menutop.setBackground(Color.white);
			}
		});
		lblDMSach
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\book_open.png"));
		lblDMSach.setBounds(6, 6, 89, 71);
		dmsach_menutop.add(lblDMSach);

		JLabel lblNewLabel_1_1 = new JLabel("DM S\u00E1ch");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(6, 75, 89, 16);
		dmsach_menutop.add(lblNewLabel_1_1);

		lblThemdmsach = new JLabel("Th\u00EAm S\u00E1ch M\u1EDBi");
		lblThemdmsach.setOpaque(true);
		lblThemdmsach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblThemdmsach.setBackground(Color.LIGHT_GRAY);
		lblThemdmsach.setBounds(164, 10, 136, 25);
		dmsach_menutop.add(lblThemdmsach);

		lblsuattsach = new JLabel("S\u1EEDa TT S\u00E1ch");
		lblsuattsach.setOpaque(true);
		lblsuattsach.setBackground(Color.LIGHT_GRAY);
		lblsuattsach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblsuattsach.setForeground(Color.BLACK);
		lblsuattsach.setBounds(164, 38, 136, 25);
		dmsach_menutop.add(lblsuattsach);

		lblXoaDMSach = new JLabel("Xo\u00E1 S\u00E1ch");
		lblXoaDMSach.setBackground(Color.LIGHT_GRAY);
		lblXoaDMSach.setOpaque(true);
		lblXoaDMSach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblXoaDMSach.setBounds(164, 67, 136, 25);
		dmsach_menutop.add(lblXoaDMSach);

		JLabel lblNewLabel_3_3 = new JLabel(" ");
		lblNewLabel_3_3
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Add.png"));
		lblNewLabel_3_3.setBounds(128, 15, 24, 24);
		dmsach_menutop.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Repair.png"));
		lblNewLabel_3_1_1.setBounds(128, 43, 24, 24);
		dmsach_menutop.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_2_1 = new JLabel("New label");
		lblNewLabel_3_2_1
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Delete.png"));
		lblNewLabel_3_2_1.setBounds(128, 71, 24, 24);
		dmsach_menutop.add(lblNewLabel_3_2_1);

		docgia_menutop = new Panel();

		docgia_menutop.setLayout(null);
		docgia_menutop.setBackground(Color.WHITE);
		docgia_menutop.setBounds(618, 0, 306, 97);
		panelmenutop.add(docgia_menutop);

		JLabel lblDocGia = new JLabel("");
		lblDocGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/// paneldanhmuc.setVisible(false);
				paneldocgia.setVisible(true);
				panelloaisach.setVisible(false);
				paneldmsach.setVisible(false);
				panelnxb.setVisible(false);

				loaisach_menutop.setBackground(Color.white);
				dmsach_menutop.setBackground(Color.white);
				docgia_menutop.setBackground(Color.cyan);
				nxb_menutop.setBackground(Color.white);
			}
		});
		lblDocGia.setIcon(new ImageIcon(
				"C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\reader-1713700-1453871.png"));
		lblDocGia.setBounds(6, 6, 89, 71);
		docgia_menutop.add(lblDocGia);

		JLabel lblNewLabel_1_2 = new JLabel("\u0110\u1ED9c Gi\u1EA3");
		lblNewLabel_1_2.setBounds(6, 75, 89, 16);
		docgia_menutop.add(lblNewLabel_1_2);

		lblThemdocgia = new JLabel("Th\u00EAm \u0110\u1ED9c Gi\u1EA3");
		lblThemdocgia.setOpaque(true);
		lblThemdocgia.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblThemdocgia.setBackground(SystemColor.text);
		lblThemdocgia.setBounds(164, 10, 136, 25);
		docgia_menutop.add(lblThemdocgia);

		lblchinhsuadocgia = new JLabel("Ch\u1EC9nh s\u1EEDa \u0111\u1ED9c gi\u1EA3");
		lblchinhsuadocgia.setOpaque(true);
		lblchinhsuadocgia.setBackground(SystemColor.text);
		lblchinhsuadocgia.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblchinhsuadocgia.setForeground(SystemColor.desktop);
		lblchinhsuadocgia.setBounds(164, 38, 136, 25);
		docgia_menutop.add(lblchinhsuadocgia);

		lblxoadocgia = new JLabel("Xo\u00E1 \u0111\u1ED9c gi\u1EA3");
		lblxoadocgia.setBackground(SystemColor.text);
		lblxoadocgia.setOpaque(true);
		lblxoadocgia.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblxoadocgia.setBounds(164, 67, 136, 25);
		docgia_menutop.add(lblxoadocgia);

		JLabel lblNewLabel_3_4 = new JLabel(" ");
		lblNewLabel_3_4
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Add.png"));
		lblNewLabel_3_4.setBounds(128, 15, 24, 24);
		docgia_menutop.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_1_2 = new JLabel("New label");
		lblNewLabel_3_1_2
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Repair.png"));
		lblNewLabel_3_1_2.setBounds(128, 43, 24, 24);
		docgia_menutop.add(lblNewLabel_3_1_2);

		JLabel lblNewLabel_3_2_2 = new JLabel("New label");
		lblNewLabel_3_2_2
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Delete.png"));
		lblNewLabel_3_2_2.setBounds(128, 71, 24, 24);
		docgia_menutop.add(lblNewLabel_3_2_2);

		nxb_menutop = new Panel();
		nxb_menutop.setFont(null);
		nxb_menutop.setLayout(null);
		nxb_menutop.setBackground(Color.WHITE);
		nxb_menutop.setBounds(927, 0, 306, 97);
		panelmenutop.add(nxb_menutop);

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelnxb.setVisible(true);
				paneldocgia.setVisible(false);
				panelloaisach.setVisible(false);
				paneldmsach.setVisible(false);

				loaisach_menutop.setBackground(Color.white);
				dmsach_menutop.setBackground(Color.white);
				docgia_menutop.setBackground(Color.white);
				nxb_menutop.setBackground(Color.cyan);

			}
		});
		lblNewLabel_5_1.setIcon(
				new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\icon-hanhchinh.png"));
		lblNewLabel_5_1.setBounds(6, 0, 89, 71);
		nxb_menutop.add(lblNewLabel_5_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Nhà Xuất Bản Và Tác Giả");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(96, 37, 204, 34);
		nxb_menutop.add(lblNewLabel_1_2_1);
		setLocationRelativeTo(null);
	}

	public void loaisachpane() {
		panelloaisach = new JPanel();
		panelloaisach.setBounds(0, 0, 1233, 467);
		layeredPane.add(panelloaisach);
		panelloaisach.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Lo\u1EA1i S\u00E1ch");
		lblNewLabel_6.setBackground(new Color(47, 79, 79));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setBounds(0, 0, 88, 37);
		panelloaisach.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("M\u00E3 Lo\u1EA1i S\u00E1ch");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(12, 99, 96, 29);
		panelloaisach.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("Tên Loại");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7_1.setBounds(12, 157, 96, 29);
		panelloaisach.add(lblNewLabel_7_1);

		txtMaloaisach = new JTextField();
		txtMaloaisach.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (checktrung_tableloai()) {
					JOptionPane.showMessageDialog(contentPane, "Mã đã trùng vui lòng nhập lại");
					txtMaloaisach.setText(null);
					txtMaloaisach.requestFocus();
				}

			}
		});
		txtMaloaisach.setBounds(120, 95, 133, 37);
		panelloaisach.add(txtMaloaisach);
		txtMaloaisach.setColumns(10);

		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(120, 153, 133, 37);
		panelloaisach.add(txtTenSach);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 33, 907, 402);
		panelloaisach.add(scrollPane);

		dtmloai = new DefaultTableModel();
		dtmloai.addColumn("Mã Loại");
		dtmloai.addColumn("Tên Loại");
		tbl_loaisach = new JTable(dtmloai);
		tbl_loaisach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int i = tbl_loaisach.getSelectedRow();
					if (i >= 0)
						txtMaloaisach.setText(String.valueOf(tbl_loaisach.getValueAt(i, 0)));
					txtTenSach.setText((String) tbl_loaisach.getValueAt(i, 1));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
					
				}
			}
		});

		scrollPane.setViewportView(tbl_loaisach);

		Panel panel_4 = new Panel();
		panel_4.setBounds(0, 210, 309, 247);
		panelloaisach.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Tìm Kiếm Loại Sách");
		lblNewLabel_8.setBackground(new Color(238, 232, 170));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(69, 13, 190, 45);
		panel_4.add(lblNewLabel_8);

		rdbtimtheoma = new JRadioButton("Tìm Theo Mã");
		rdbtimtheoma.setSelected(true);
		rdbtimtheoma.setBounds(8, 77, 127, 25);
		panel_4.add(rdbtimtheoma);

		rdbtimtheoten = new JRadioButton("Tìm Theo Tên");
		rdbtimtheoten.setBounds(162, 77, 127, 25);
		panel_4.add(rdbtimtheoten);

		btng = new ButtonGroup();
		btng.add(rdbtimtheoten);
		btng.add(rdbtimtheoma);
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(8, 154, 142, 35);
		panel_4.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm", new ImageIcon("img/search-512 (1).png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sreach_table_Loai();

			}
		});
		btnTimKiem.setBounds(162, 149, 127, 45);
		panel_4.add(btnTimKiem);

		JButton btnNewButton = new JButton("ReLoad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadtableloai();
			}
		});
		btnNewButton.setBounds(162, 206, 127, 41);
		panel_4.add(btnNewButton);
	}

	protected void sreach_table_Loai() {

		boolean flag = false;
		if (rdbtimtheoma.isSelected()) {
			flag = false;
			for (LoaisachDTO loaisachDTO : dsloai) {
				if (loaisachDTO.getMaloai() == Integer.parseInt(txtTimKiem.getText())) {
					dtmloai.setRowCount(0);
					Vector vec = new Vector();
					vec.add(loaisachDTO.getMaloai());
					vec.add(loaisachDTO.getTenloai());
					dtmloai.addRow(vec);
					flag = true;
				}
			}
		} else if (rdbtimtheoten.isSelected()) {
			flag = false;

			dtmloai.setRowCount(0);
			JOptionPane.showMessageDialog(contentPane, txtTimKiem.getText());
			for (LoaisachDTO loaisachDTO : dsloai) {

				if (loaisachDTO.getTenloai().contains(txtTimKiem.getText().toLowerCase())) {

					Vector vec = new Vector();
					vec.add(loaisachDTO.getMaloai());
					vec.add(loaisachDTO.getTenloai());

					dtmloai.addRow(vec);
					flag = true;
				}
			}
		}
		if (flag) {
			JOptionPane.showMessageDialog(contentPane, "Đã Tìm Thấy");

		} else {

			JOptionPane.showMessageDialog(contentPane, "Không Tìm Thấy");

		}

	}

	public void JmenuBar() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(mnFile);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnFile.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnFile.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnFile.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnFile.add(mntmNewMenuItem_3);

		JMenu mnNewMenu = new JMenu("System");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("About");
		menuBar.add(mnNewMenu_2);
	}

	public void DMSACH() {
		paneldmsach = new JPanel();
		paneldmsach.setBounds(6, 6, 1221, 455);
		layeredPane.add(paneldmsach);
		paneldmsach.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("Mã Số Sách");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14.setBounds(6, 6, 89, 29);
		paneldmsach.add(lblNewLabel_14);

		JLabel lblNewLabel_14_1 = new JLabel("Tên Sách");
		lblNewLabel_14_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_1.setBounds(6, 69, 89, 29);
		paneldmsach.add(lblNewLabel_14_1);

		JLabel lblNewLabel_14_2 = new JLabel("Mã Tác Giả");
		lblNewLabel_14_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_2.setBounds(6, 132, 89, 29);
		paneldmsach.add(lblNewLabel_14_2);

		JLabel lblNewLabel_14_3 = new JLabel("Mã Số NXB");
		lblNewLabel_14_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_3.setBounds(6, 199, 89, 29);
		paneldmsach.add(lblNewLabel_14_3);

		JLabel lblNewLabel_14_4 = new JLabel("Mã Loại Sách");
		lblNewLabel_14_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_4.setBounds(6, 265, 89, 29);
		paneldmsach.add(lblNewLabel_14_4);

		txtMasosach = new JTextField();
		txtMasosach.setBounds(107, 1, 164, 38);
		paneldmsach.add(txtMasosach);
		txtMasosach.setColumns(10);

		txtTenSach1 = new JTextField();
		txtTenSach1.setColumns(10);
		txtTenSach1.setBounds(107, 60, 164, 38);
		paneldmsach.add(txtTenSach1);

		txtmaNXB = new JTextField();
		txtmaNXB.setColumns(10);
		txtmaNXB.setBounds(107, 190, 164, 38);
		paneldmsach.add(txtmaNXB);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(572, 49, 643, 389);
		paneldmsach.add(scrollPane);
		dtmsach = new DefaultTableModel();
		dtmsach.addColumn("Mã Sách");
		dtmsach.addColumn("Tên Sách");
		dtmsach.addColumn("Tác Giả");
		dtmsach.addColumn("Mã NXB");
		dtmsach.addColumn("Mã Loại");
		dtmsach.addColumn("Năm XB");
		dtmsach.addColumn("Số Lượng");
		dtmsach.addColumn("Ghi Chú");
		table_DMSach = new JTable(dtmsach);
		table_DMSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table_DMSach.getSelectedRow();

				if (i >= 0) {

				}

			}
		});
		scrollPane.setViewportView(table_DMSach);

		JLabel lblNewLabel_14_5 = new JLabel("Năm Xuất Bản");
		lblNewLabel_14_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_5.setBounds(6, 338, 89, 29);
		paneldmsach.add(lblNewLabel_14_5);

		JLabel lblNewLabel_14_6 = new JLabel("Số Lượng");
		lblNewLabel_14_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_6.setBounds(6, 405, 89, 29);
		paneldmsach.add(lblNewLabel_14_6);

		JLabel lblNewLabel_14_7 = new JLabel("Mã Kệ");
		lblNewLabel_14_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_14_7.setBounds(310, 6, 89, 29);
		paneldmsach.add(lblNewLabel_14_7);

		txtNamxb = new JTextField();
		txtNamxb.setColumns(10);
		txtNamxb.setBounds(107, 333, 164, 38);
		paneldmsach.add(txtNamxb);

		txtsl = new JTextField();
		txtsl.setColumns(10);
		txtsl.setBounds(107, 400, 164, 38);
		paneldmsach.add(txtsl);

		cmbloai = new JComboBox();
		cmbloai.setBounds(105, 265, 166, 29);
		paneldmsach.add(cmbloai);

		JComboBox cmbtacgia = new JComboBox();
		cmbtacgia.setBounds(105, 133, 166, 29);
		paneldmsach.add(cmbtacgia);

		txtMaKeSach = new JTextField();
		txtMaKeSach.setColumns(10);
		txtMaKeSach.setBounds(369, 0, 164, 38);
		paneldmsach.add(txtMaKeSach);

		JLabel lblNewLabel = new JLabel("Hình Ảnh");
		lblNewLabel.setBounds(371, 95, 149, 172);
		paneldmsach.add(lblNewLabel);

	}

	public void docgia() {
		paneldocgia = new JPanel();
		paneldocgia.setBounds(0, 0, 1227, 467);
		layeredPane.add(paneldocgia);
		paneldocgia.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin \u0111\u1ECDc gi\u1EA3", TitledBorder.CENTER,
				TitledBorder.TOP, null, Color.RED));
		panel_5.setBounds(73, 29, 1050, 162);
		paneldocgia.add(panel_5);
		panel_5.setLayout(null);

		JLabel lbltendocgia = new JLabel("Họ Và Tên");
		lbltendocgia.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbltendocgia.setBounds(25, 26, 73, 19);
		panel_5.add(lbltendocgia);

		textField = new JTextField();
		textField.setBounds(110, 18, 189, 37);
		panel_5.add(textField);
		textField.setColumns(10);

		JLabel lbldiachi = new JLabel("Địa chỉ");
		lbldiachi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbldiachi.setBounds(25, 106, 73, 27);
		panel_5.add(lbldiachi);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 96, 189, 37);
		panel_5.add(textField_1);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSinThoi.setBounds(391, 18, 86, 27);
		panel_5.add(lblSinThoi);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(500, 18, 189, 37);
		panel_5.add(textField_2);

		JLabel lblNgyMTh = new JLabel("Ngày Mở Thẻ");
		lblNgyMTh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNgyMTh.setBounds(391, 106, 105, 27);
		panel_5.add(lblNgyMTh);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(500, 96, 189, 37);
		panel_5.add(textField_10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(890, 23, 123, 27);
		panel_5.add(comboBox);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGiiTnh.setBounds(803, 22, 86, 27);
		panel_5.add(lblGiiTnh);

		JPanel paneltabledocgoa = new JPanel();
		paneltabledocgoa.setBounds(73, 225, 1050, 236);
		paneldocgia.add(paneltabledocgoa);
		paneltabledocgoa.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 1038, 224);
		paneltabledocgoa.add(scrollPane);
		dtmdocgia = new DefaultTableModel();
		dtmdocgia.addColumn("Mã độc giả");
		dtmdocgia.addColumn("Họ Và Tên");
		dtmdocgia.addColumn("Giới Tính");
		dtmdocgia.addColumn("Địa chỉ");
		dtmdocgia.addColumn("Ngày mở thẻ");
		dtmdocgia.addColumn("Số điện thoại");

		tabledocgia = new JTable(dtmdocgia);
		scrollPane.setViewportView(tabledocgia);
	}

	public void panelnhaxuatban() {
		panelnxb = new JPanel();
		panelnxb.setBounds(0, 0, 1227, 477);
		layeredPane.add(panelnxb);
		panelnxb.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Tên Nhà Xuất Bản");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(25, 38, 131, 32);
		panelnxb.add(lblNewLabel_2);

		textField_11 = new JTextField();
		textField_11.setBounds(167, 41, 152, 29);
		panelnxb.add(textField_11);
		textField_11.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(25, 97, 131, 32);
		panelnxb.add(lblNewLabel_2_1);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(167, 100, 152, 29);
		panelnxb.add(textField_12);

		JLabel lblNewLabel_2_2 = new JLabel("SĐT");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(25, 159, 131, 32);
		panelnxb.add(lblNewLabel_2_2);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(167, 162, 152, 29);
		panelnxb.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setBounds(167, 276, 152, 28);
		panelnxb.add(textField_14);
		textField_14.setColumns(10);

		JLabel lblNewLabel_2_2_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_2_1.setBounds(25, 272, 131, 32);
		panelnxb.add(lblNewLabel_2_2_1);

		JButton btnthemnxb = new JButton("Thêm");
		btnthemnxb.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Add.png"));
		btnthemnxb.setBounds(346, 38, 112, 32);
		panelnxb.add(btnthemnxb);

		JButton btnsuanxb = new JButton("Sửa");
		btnsuanxb.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Repair.png"));
		btnsuanxb.setBounds(346, 100, 112, 32);
		panelnxb.add(btnsuanxb);

		JButton btnxoanxb = new JButton("Xoá");
		btnxoanxb.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Delete.png"));
		btnxoanxb.setBounds(346, 162, 112, 32);
		panelnxb.add(btnxoanxb);

		JButton btnthemnxb_3 = new JButton("Tải Lại");
		btnthemnxb_3
				.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\Refresh.png"));
		btnthemnxb_3.setBounds(346, 217, 112, 32);
		panelnxb.add(btnthemnxb_3);

		JButton btntimkiemnxb = new JButton("Tìm");
		btntimkiemnxb.setIcon(
				new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\search-512 (1).png"));
		btntimkiemnxb.setBounds(346, 272, 112, 32);
		panelnxb.add(btntimkiemnxb);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 316, 423, 144);
		panelnxb.add(scrollPane);
		dtmnxb = new DefaultTableModel();
		dtmnxb.addColumn("Mã Nhà Xuất Bản");
		dtmnxb.addColumn("Tên nhà xuất bản");
		dtmnxb.addColumn("Địa chỉ");
		dtmnxb.addColumn("SĐT");
		tablenxb = new JTable(dtmnxb);
		scrollPane.setViewportView(tablenxb);

		JLabel lbltentacgia = new JLabel("Tên Tác Giả");
		lbltentacgia.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbltentacgia.setBounds(636, 38, 131, 32);
		panelnxb.add(lbltentacgia);

		JLabel lblNewLabel_2_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(636, 97, 131, 32);
		panelnxb.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2_2 = new JLabel("SĐT");
		lblNewLabel_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_2_2.setBounds(636, 159, 131, 32);
		panelnxb.add(lblNewLabel_2_2_2);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_2_1_1.setBounds(636, 272, 131, 32);
		panelnxb.add(lblNewLabel_2_2_1_1);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(778, 276, 152, 28);
		panelnxb.add(textField_15);

		JButton btntimkiemtacgia = new JButton("Tìm");
		btntimkiemtacgia.setBounds(957, 272, 112, 32);
		panelnxb.add(btntimkiemtacgia);

		JButton btntailai = new JButton("Tải Lại");
		btntailai.setBounds(957, 217, 112, 32);
		panelnxb.add(btntailai);

		JButton btnxoatg = new JButton("Xoá");
		btnxoatg.setBounds(957, 162, 112, 32);
		panelnxb.add(btnxoatg);

		JButton btnsuatg = new JButton("Sửa");
		btnsuatg.setBounds(957, 100, 112, 32);
		panelnxb.add(btnsuatg);

		JButton btnthemtg = new JButton("Thêm");
		btnthemtg.setBounds(957, 38, 112, 32);
		panelnxb.add(btnthemtg);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(778, 41, 152, 29);
		panelnxb.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(778, 100, 152, 29);
		panelnxb.add(textField_17);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(778, 162, 152, 29);
		panelnxb.add(textField_18);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(636, 316, 423, 144);
		panelnxb.add(scrollPane_1);
		dtmtg = new DefaultTableModel();
		dtmtg.addColumn("Mã Tác Giả");
		dtmtg.addColumn("Tên Tác Giả");
		dtmtg.addColumn("Năm Sinh");
		dtmtg.addColumn("Quê Quán");

		tabletacgia = new JTable(dtmtg);
		scrollPane_1.setViewportView(tabletacgia);

		;
	}

	private boolean checktrung_tableloai() {
		for (LoaisachDTO loaisachDTO : dsloai) {
			if (txtMaloaisach.getText().equals(String.valueOf(loaisachDTO.getMaloai()))) {
				return true;
			}
		}
		return false;
	}

	protected void xoa_table_loaisach() {

		int i = tbl_loaisach.getSelectedRow();
		if (i >= 0) {
			int a = JOptionPane.showConfirmDialog(contentPane, "Bạn có xoá", "", JOptionPane.YES_NO_OPTION);
			if (a == JOptionPane.YES_OPTION) {
				int vitri = (int) tbl_loaisach.getValueAt(i, 0);

				// String sql = "DELETE FROM hocsinh WHERE mssv '"+ ma +"'";
				try {
					Connection conn = DBConnect.getConnection();
					Statement stm = conn.createStatement();
					stm.executeUpdate("DELETE FROM loaisach WHERE maloai =" + vitri + "");
					loadtableloai();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		}

	}

	private void loadcmbloai() {
		cmbloai.addItem("");
		for (LoaisachDTO loaisachDTO : dsloai) {

			cmbloai.addItem(loaisachDTO);
		}
	}

	private void loadtableloai() {

		try {
			dsloai = null;
			LoaiBUS loai = new LoaiBUS();
			dsloai = loai.getLoaisachLoai();

			dtmloai.setRowCount(0);

			for (LoaisachDTO loaisachDTO : dsloai) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(loaisachDTO.getMaloai());
				vec.add(loaisachDTO.getTenloai());

				dtmloai.addRow(vec);

			}

			/*
			 * while (rs.next()) { Vector<Object> vec = new Vector<Object>();
			 * vec.add(rs.getInt(1)); vec.add(rs.getString(2)); dtmloai.addRow(vec); }
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private ArrayList<SachDTO> dssach;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_10;
	private JTable tabledocgia;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable tablenxb;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTable tabletacgia;
	private JTable tablenhanvien;
	private JTextField txttennhanvien;
	private JTextField txtgioitinhnhanvien;
	private JTextField txtdiachinhanvien;
	private JTextField txtnamsinhnhanvien;
	private JTextField txtngayvaolam;
	private JTextField txtsdtnhanvien;
	private Panel nxb_menutop;
	private JTextField txtMaKeSach;

	private void loadtablesach() {

		try {
			dssach = null;
			SachBus sach = new SachBus();
			dssach = sach.getLoaisachLoai();
			dtmsach.setRowCount(0);
			for (SachDTO sach1 : dssach) {
				Vector vec = new Vector();
				vec.add(sach1.getMasosach());
				vec.add(sach1.getTensach());
				vec.add(sach1.getMatacgia());
				vec.add(sach1.getMaNXB());
				vec.add(sach1.getMaloai());
				vec.add(sach1.getNamxb());
				vec.add(sach1.getSoluong());
				vec.add(sach1.getGhichu());

				dtmsach.addRow(vec);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void addEvent() {

		/* ĐOẠN NÀY THÊM SỰ KIỆN RÊ CHUỘT VÀ CLICK CHỘT VÀO BẢNG LOẠI SÁCH */
		lblThemdmsach_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// lblThemdmsach_1.setBackground(new Color(255,230,173));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblThemdmsach_1.setBackground(new Color(255, 222, 173));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblThemdmsach_1.setBackground(new Color(255, 250, 173));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblSuaTTLoaiSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblSuaTTLoaiSach.setBackground(new Color(255, 222, 173));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblSuaTTLoaiSach.setBackground(new Color(255, 250, 173));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblXoaLoaiSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblXoaLoaiSach.setBackground(new Color(255, 222, 173));

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblXoaLoaiSach.setBackground(new Color(255, 250, 173));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		/* KẾT THÚC THÊM SỰ KIỆN RÊ CHUỘT VÀ CLICK CHỘT VÀO BẢNG LOẠI SÁCH */

		lblThemdmsach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblThemdmsach.setBackground(Color.LIGHT_GRAY);
				lblThemdmsach.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblThemdmsach.setBackground(Color.DARK_GRAY);
				lblThemdmsach.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblsuattsach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblsuattsach.setBackground(Color.LIGHT_GRAY);
				lblsuattsach.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblsuattsach.setBackground(Color.DARK_GRAY);

				lblsuattsach.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblXoaDMSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblXoaDMSach.setBackground(Color.LIGHT_GRAY);
				lblXoaDMSach.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblXoaDMSach.setBackground(Color.DARK_GRAY);
				lblXoaDMSach.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		/* BẮT SỰ KIỆN RÊ CHUỘT VÀO PANEL ĐỌC GIẢ */
		lblThemdocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblThemdocgia.setBackground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblThemdocgia.setBackground(Color.CYAN);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblchinhsuadocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblchinhsuadocgia.setBackground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblchinhsuadocgia.setBackground(Color.CYAN);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblxoadocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblxoadocgia.setBackground(Color.white);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblxoadocgia.setBackground(Color.cyan);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		/* BẮT SỰ KIỆN RÊ CHUỘT VÀO PANEL ĐỌC GIẢ */

		/* BẮT SỰ KIỆN RÊ CHUỘT VÀO PANEL TRẢ MƯỢN */

		lbldanhsachmuon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lbldanhsachmuon.setBackground(new Color(214, 217, 223));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lbldanhsachmuon.setBackground(new Color(255, 233, 163));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

		lblthemmoi.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblthemmoi.setBackground(new Color(214, 217, 223));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblthemmoi.setBackground(new Color(255, 233, 163));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		lblsuadoi.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblsuadoi.setBackground(new Color(214, 217, 223));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblsuadoi.setBackground(new Color(255, 233, 163));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lbldanhsachtra.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbldanhsachtra.setBackground(new Color(214, 217, 223));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbldanhsachtra.setBackground(new Color(255, 233, 163));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}
}
