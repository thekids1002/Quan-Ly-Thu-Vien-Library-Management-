package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import BUS.DocGiaBUS;
import BUS.KeSachBus;
import BUS.LoaiBUS;
import BUS.NhaCungcapbus;
import BUS.NhaXuatBanBUS;
import BUS.NhanVienBus;
import BUS.SachBus;
import BUS.TacGiaBUS;
import BUS.TaiKhoanBus;
import DAL.DocGiaDAL;
import DAL.KeSachDAL;
import DAL.LoaiSachDAL;
import DAL.NhaCungCapDAL;
import DAL.NhaXuatBanDAL;
import DAL.NhanVienDAL;
import DAL.SachDAL;
import DAL.TacGiaDAL;
import DTO.DocGia;
import DTO.KeSachDTO;
import DTO.LoaisachDTO;

import DTO.NhaCungCapDTO;
import DTO.NhaXuatBan;
import DTO.NhanVien;
import DTO.SachDTO;
import DTO.TacGiaDTO;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;

public class DesignLai extends JFrame {
	TacGiaDTO tacgiasl;
	LoaisachDTO loaisl;
	NhaXuatBan nxbsl;
	KeSachDTO kesl;
	private JPanel contentPane;
	private JLabel iconsgu;
	private JLabel exit;
	private JLabel lblTitle;
	private JLabel title;
	private JPanel menuleft;
	private JLabel ThuVienSgu;
	private JLabel lblthuviensgu;
	private JPanel PanelChinh;
	private JPanel CardLayout;
	PanelSach panelSach = new PanelSach();
	private JPanel SachPanel;
	private JPanel LoaiSach;
	private JPanel Sach;
	private JPanel pnSach;
	private JPanel pndocgia;
	private JPanel pnnhaxuatban;
	private JPanel pntacgia;
	private JPanel pnTrangChu;
	private JPanel pnnhanvien;
	private JLabel lblTenSach;
	private JLabel lblMaLoai;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblHinhAnh;
	private JLabel lbltitlepnSach;
	private JLabel lblnamxuatban;
	private JLabel lblSLng;
	private JLabel lblMaKeSach;
	private JTextField txttensach;
	private JTextField txtsoluongsach;
	private JTextField txtnamxbsach;
	private JTable table;
	private DefaultTableModel dtmsach;
	private JLabel lblNewLabel;
	private JLabel lblTrangchu;
	private JLabel lblSach;
	private JLabel lbldocgia;
	private JLabel lbltacgia;
	private JLabel lblnhaxuatban;
	private JLabel lblnhanvien;
	private JPanel panelthongtindocgia;
	private JLabel lblTendocgia;
	private JLabel lbldiachidocgia;
	private JLabel lblgioitinhdocgia;
	private JLabel lblSdtdocgia;
	private JTextField txtTendocgia;
	private JTextField txtdiachidocgia;
	private JTextField txtgioitinhdocgia;
	private JTextField txtsdtdocgia;
	private JTextField txtTimkiemdocgia;
	private JButton btnTimkiemdocgia;
	private JLabel lblTimKiem;
	private JScrollPane scrollPane_1;
	private JTable tabledocgia;
	private DefaultTableModel dtmdocgia;
	private JPanel pnthongtintacgia;
	private JLabel lblTentacgia;
	private JTextField txtTentacgia;
	private JLabel lblnamsinh;
	private JTextField txtnamsinhtacgia;
	private JLabel lblTentacgia_2;
	private JTextField txtQueQuan;
	private JScrollPane scrollPane_2;
	private JTable tabletacgia;
	private DefaultTableModel dtmtacgia;
	private JButton btnThemTacgia;
	private JButton btnsuatacgia;
	private JButton btnreloadtacgia;
	private JButton btnxoatacgia;
	private JPanel panel_1;
	private JLabel lblTennhaxuatban;
	private JLabel lblaCh;
	private JLabel lblTennhaxuatban_2;
	private JTextField txtTennhaxuatban;
	private JTextField txtdiachinxb;
	private JTextField txtsdtnxb;
	private JButton btnThemnxb;
	private JButton btnsuanxb;
	private JButton btnxoanxb;
	private JButton btnreloadnxb;
	private JLabel lblTimKiemnxb;
	private JTextField textField_3;
	private JScrollPane scrollPane_3;
	private JTable tablenhaxuatban;
	private DefaultTableModel dtmnhaxuatban;
	private JPanel pnPhieumuon;
	private JPanel pnPhieuNhap;
	private JPanel panel_2;
	private JLabel lbltennv;
	private JLabel lblnamsinhnv;
	private JLabel lblaCh_1;
	private JLabel lbltennv_3;
	private JLabel lbltennv_4;
	private JLabel lbltennv_5;
	private JTextField txttennv;
	private JTextField txtnamsinhnv;
	private JTextField txtdiachinv;
	private JTextField txtngaybatdau;
	private JTextField txtsodienthoainv;
	private JTextField txtgioitinhnv;
	private JButton btnthemnv;
	private JButton btnsuanv;
	private JButton btnxoanv;
	private JButton btnreloadnv;
	private JLabel lbltimkiem;
	private JTextField txtTimKiemnv;
	private JScrollPane scrollPane_4;
	private JTable tablenhanvien;
	private DefaultTableModel dtmnhanvien;
	protected int y_mouse;
	protected int x_mouse;
	private JPanel pnchung;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JScrollPane scrollPane_5;
	private JTable tablemuon;
	private DefaultTableModel dtmmuon;
	private JLabel lblphieumuon;
	private JLabel lbltimkiempm;
	private JTextField textField_9;
	private JScrollPane scrollPane_6;
	private JTable tablectpm;
	private DefaultTableModel dtmctpm;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField txttenloai;
	private JTable tableloai;
	private JButton btnsualoai;
	private JButton btnxoaloai;
	private DefaultTableModel dtmloai;
	private JLabel lbltenncc;
	private JTextField txtNcc;
	private JButton btnThemncc;
	private JButton btnsuancc;
	private JButton btnxoancc;
	private JScrollPane scrollPane_7;
	private JTable tablencc;
	private DefaultTableModel dtmncc;
	private JLabel lblNewLabel_10;
	private JTextField txtKeSach;
	private JButton btnthemkesach;
	private JButton btnsuakesach;
	private JButton btnxoakesach;
	private JScrollPane scrollPane_8;
	private JTable tablekesach;
	private JLabel lblchung;
	private JLabel lbldangxuat;
	private DefaultTableModel dtmke;
	private JButton btnThemloai;
	private JButton btnthemdocgia;
	private JButton btnsuadocgia;
	private JButton btnxoadocgia;
	private JComboBox cmbmaloai;
	private JComboBox cmbmanhaxuatban;
	private JComboBox cmbmatg;
	private JComboBox cmbmakesach;
	private String hinhanh = null;
	public static int idtaikhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignLai frame = new DesignLai();
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
	public DesignLai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		thanhtitle();
		menuleft();
		addEvent();
		loadloaisach();
		loadnhacungcap();
		loadkesach();
		loadnhanvien();
		loadnxb();
		loadtacgia();
		loaddocgia();
		loadsach();
	}

	public void thanhtitle() {
		iconsgu = new JLabel("");
		iconsgu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\iconsgu.png"));
		iconsgu.setBounds(0, 0, 30, 34);
		contentPane.add(iconsgu);

		exit = new JLabel("");

		exit.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\exit.png"));
		exit.setBounds(1244, 7, 24, 24);
		contentPane.add(exit);

		lblTitle = new JLabel("Qu\u1EA3n L\u00FD Th\u01B0 Vi\u1EC7n");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(535, 0, 170, 34);
		contentPane.add(lblTitle);

		title = new JLabel("");
		title.setOpaque(true);
		title.setBackground(new Color(64, 64, 64));
		title.setBounds(0, 0, 1280, 34);
		contentPane.add(title);

	}

	public void menuleft() {

		PanelChinh = new JPanel();
		PanelChinh.setBounds(175, 33, 1105, 735);
		contentPane.add(PanelChinh);
		PanelChinh.setLayout(new CardLayout(0, 0));
		pnsach();
		/* PN ĐỘC GIẢ */

		/* PANEL NHÀ XUẤT BẢN */

		/* PANEL TÁC GIẢ */

		/*
		 * // PANEL TRANG CHỦ
		 */
		trangchu();
		docgia();
		pntacgia();
		nhaxuatban();
		nhanvien();

		pnPhieumuon = new JPanel();

		pnPhieuNhap = new JPanel();

		menuleft = new JPanel();
		menuleft.setBounds(0, 33, 175, 734);
		menuleft.setBackground(new Color(64, 64, 64));
		contentPane.add(menuleft);
		menuleft.setLayout(null);

		lblthuviensgu = new JLabel("Th\u01B0 Vi\u1EC7n SGU");
		lblthuviensgu.setForeground(Color.WHITE);
		lblthuviensgu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblthuviensgu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\iconthuvien.png"));
		lblthuviensgu.setBounds(0, 13, 175, 40);
		menuleft.add(lblthuviensgu);

		ThuVienSgu = new JLabel("");
		ThuVienSgu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\goctraimaudo.png"));
		ThuVienSgu.setBounds(0, 0, 175, 62);
		menuleft.add(ThuVienSgu);

		lblTrangchu = new JLabel("TRANG CHỦ");
		lblTrangchu.setBackground(new Color(64, 64, 64));
		lblTrangchu.setOpaque(true);
		lblTrangchu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrangchu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\catory 1.png"));
		lblTrangchu.setForeground(Color.WHITE);
		lblTrangchu.setBounds(0, 74, 175, 46);

		menuleft.add(lblTrangchu);

		lblSach = new JLabel("SÁCH");
		lblSach.setBackground(new Color(64, 64, 64));
		lblSach.setOpaque(true);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSach.setBounds(0, 133, 175, 46);

		menuleft.add(lblSach);

		lbldocgia = new JLabel("ĐỌC GIẢ");
		lbldocgia.setBackground(new Color(64, 64, 64));
		lbldocgia.setOpaque(true);
		lbldocgia.setForeground(Color.WHITE);
		lbldocgia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldocgia.setBounds(0, 192, 175, 46);

		menuleft.add(lbldocgia);

		lbltacgia = new JLabel("TÁC GIẢ");
		lbltacgia.setBackground(new Color(64, 64, 64));
		lbltacgia.setOpaque(true);
		lbltacgia.setForeground(Color.WHITE);
		lbltacgia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltacgia.setBounds(0, 251, 175, 46);

		menuleft.add(lbltacgia);

		lblnhaxuatban = new JLabel("NHÀ XUẤT BẢN");
		lblnhaxuatban.setBackground(new Color(64, 64, 64));
		lblnhaxuatban.setOpaque(true);
		lblnhaxuatban.setForeground(Color.WHITE);
		lblnhaxuatban.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnhaxuatban.setBounds(0, 310, 175, 46);

		menuleft.add(lblnhaxuatban);

		lblnhanvien = new JLabel("NHÂN VIÊN");
		lblnhanvien.setBackground(new Color(64, 64, 64));
		lblnhanvien.setOpaque(true);
		lblnhanvien.setForeground(Color.WHITE);
		lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnhanvien.setBounds(0, 369, 175, 46);

		menuleft.add(lblnhanvien);

		lblphieumuon = new JLabel("PHIẾU MƯỢN");
		lblphieumuon.setOpaque(true);
		lblphieumuon.setForeground(Color.WHITE);
		lblphieumuon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblphieumuon.setBackground(Color.DARK_GRAY);
		lblphieumuon.setBounds(0, 428, 175, 46);
		menuleft.add(lblphieumuon);

		lblchung = new JLabel("CHUNG");
		lblchung.setOpaque(true);
		lblchung.setForeground(Color.WHITE);
		lblchung.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblchung.setBackground(Color.DARK_GRAY);
		lblchung.setBounds(0, 548, 175, 46);
		menuleft.add(lblchung);

		lbldangxuat = new JLabel("ĐĂNG XUẤT");
		lbldangxuat.setOpaque(true);
		lbldangxuat.setForeground(Color.WHITE);
		lbldangxuat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldangxuat.setBackground(Color.DARK_GRAY);
		lbldangxuat.setBounds(0, 648, 175, 46);
		menuleft.add(lbldangxuat);

		JLabel lblThngK = new JLabel("THỐNG KÊ");
		lblThngK.setOpaque(true);
		lblThngK.setForeground(Color.WHITE);
		lblThngK.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngK.setBackground(Color.DARK_GRAY);
		lblThngK.setBounds(0, 489, 175, 46);
		menuleft.add(lblThngK);
		PanelChinh.add(pnTrangChu, "name_890335498390600");
		PanelChinh.add(pnSach, "name_890193837575500");
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "H\u00ECnh \u1EA2nh", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM,
				null, null));
		panel_5.setBounds(903, 67, 170, 238);
		pnSach.add(panel_5);
		panel_5.setLayout(null);

		lblhinhanhpre = new JLabel("");
		lblhinhanhpre.setBounds(0, 0, 158, 212);
		panel_5.add(lblhinhanhpre);

		PanelChinh.add(pndocgia, "name_890203323464100");
		PanelChinh.add(pntacgia, "name_890226525489300");
		PanelChinh.add(pnnhaxuatban, "name_890210577532500");
		PanelChinh.add(pnnhanvien, "name_890389477283600");
		PanelChinh.add(pnPhieumuon, "name_901238608974900");
		pnPhieumuon.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 13, 516, 294);
		pnPhieumuon.add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel_1 = new JLabel("Mã PM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 13, 82, 36);
		panel_3.add(lblNewLabel_1);

		lblNewLabel_4 = new JLabel("Mã NV");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(12, 61, 82, 36);
		panel_3.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Mã Đọc Giả");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(12, 110, 97, 36);
		panel_3.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Ngày Mượn");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(12, 171, 97, 36);
		panel_3.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Tình Trạng");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(12, 227, 82, 36);
		panel_3.add(lblNewLabel_7);

		textField_4 = new JTextField();
		textField_4.setBounds(111, 13, 236, 36);
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(111, 61, 236, 36);
		panel_3.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(111, 110, 236, 36);
		panel_3.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(111, 171, 236, 36);
		panel_3.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(111, 228, 236, 36);
		panel_3.add(textField_8);

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(380, 13, 97, 36);
		panel_3.add(btnNewButton_1);

		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(380, 61, 97, 36);
		panel_3.add(btnNewButton_2);

		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(380, 110, 97, 36);
		panel_3.add(btnNewButton_3);

		btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(380, 171, 97, 36);
		panel_3.add(btnNewButton_4);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(540, 13, 553, 294);
		pnPhieumuon.add(scrollPane_5);

		dtmmuon = new DefaultTableModel();
		dtmmuon.addColumn("Mã Phiếu Mượn");
		dtmmuon.addColumn("Mã Nhân Viên");
		dtmmuon.addColumn("Mã Đọc Giả");
		dtmmuon.addColumn("Ngày Mượn");
		dtmmuon.addColumn("Tình Trạng");
		tablemuon = new JTable(dtmmuon);

		scrollPane_5.setViewportView(tablemuon);

		lbltimkiempm = new JLabel("Tìm Kiếm");
		lbltimkiempm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltimkiempm.setBounds(12, 331, 97, 39);
		pnPhieumuon.add(lbltimkiempm);

		textField_9 = new JTextField();
		textField_9.setBounds(127, 340, 317, 30);
		pnPhieumuon.add(textField_9);
		textField_9.setColumns(10);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(22, 391, 736, 331);
		pnPhieumuon.add(scrollPane_6);

		dtmctpm = new DefaultTableModel();
		dtmctpm.addColumn("Mã CTPM");
		dtmctpm.addColumn("Mã PM");
		dtmctpm.addColumn("Mã Sách");
		dtmctpm.addColumn("Ngày Trả");
		dtmctpm.addColumn("Ghi Chú");
		tablectpm = new JTable(dtmctpm);
		scrollPane_6.setViewportView(tablectpm);

		JPanel panel = new JPanel();
		panel.setBounds(770, 391, 323, 331);
		pnPhieumuon.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Mã Sách");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(12, 13, 91, 49);
		panel.add(lblNewLabel_8);

		textField_10 = new JTextField();
		textField_10.setBounds(96, 21, 142, 35);
		panel.add(textField_10);
		textField_10.setColumns(10);

		JButton btnNewButton_5 = new JButton("...");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.setBounds(250, 26, 54, 25);
		panel.add(btnNewButton_5);

		JLabel lblNewLabel_8_1 = new JLabel("Ngày Trả");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(12, 106, 91, 49);
		panel.add(lblNewLabel_8_1);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(96, 106, 142, 35);
		panel.add(textField_11);

		JLabel lblNewLabel_8_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1_1.setBounds(12, 181, 91, 49);
		panel.add(lblNewLabel_8_1_1);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(96, 189, 142, 35);
		panel.add(textField_12);

		JButton btnNewButton_6 = new JButton("Thêm");
		btnNewButton_6.setBounds(6, 243, 97, 25);
		panel.add(btnNewButton_6);

		JButton btnNewButton_6_1 = new JButton("Sửa");
		btnNewButton_6_1.setBounds(207, 243, 97, 25);
		panel.add(btnNewButton_6_1);

		JButton btnNewButton_6_2 = new JButton("Xoá");
		btnNewButton_6_2.setBounds(6, 293, 97, 25);
		panel.add(btnNewButton_6_2);

		JButton bnttailaipm = new JButton("Tải Lại");
		bnttailaipm.setBounds(207, 293, 97, 25);
		panel.add(bnttailaipm);
		PanelChinh.add(pnPhieuNhap, "name_901242535638200");

		pnchung = new JPanel();
		PanelChinh.add(pnchung, "name_903253398621700");
		pnchung.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Lo\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(69, 33, 389, 292);
		pnchung.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Tên Loại");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(12, 13, 79, 41);
		panel_4.add(lblNewLabel_9);

		txttenloai = new JTextField();
		txttenloai.setBounds(120, 13, 225, 41);
		panel_4.add(txttenloai);
		txttenloai.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 365, 137);
		panel_4.add(scrollPane);
		dtmloai = new DefaultTableModel();
		dtmloai.addColumn("Mã Loại");
		dtmloai.addColumn("Tên Loại");
		tableloai = new JTable(dtmloai);
		scrollPane.setViewportView(tableloai);

		btnThemloai = new JButton("Thêm");
		btnThemloai.setBounds(12, 93, 97, 25);
		panel_4.add(btnThemloai);

		btnsualoai = new JButton("Sửa");
		btnsualoai.setBounds(149, 93, 97, 25);
		panel_4.add(btnsualoai);

		btnxoaloai = new JButton("Xoá");
		btnxoaloai.setBounds(280, 93, 97, 25);
		panel_4.add(btnxoaloai);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(
				new TitledBorder(null, "Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4_1.setBounds(660, 33, 389, 292);
		pnchung.add(panel_4_1);
		panel_4_1.setLayout(null);

		lbltenncc = new JLabel("Tên NCC");
		lbltenncc.setForeground(Color.BLACK);
		lbltenncc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltenncc.setBounds(12, 13, 79, 41);
		panel_4_1.add(lbltenncc);

		txtNcc = new JTextField();
		txtNcc.setColumns(10);
		txtNcc.setBounds(120, 13, 225, 41);
		panel_4_1.add(txtNcc);

		btnThemncc = new JButton("Thêm");
		btnThemncc.setBounds(12, 93, 97, 25);
		panel_4_1.add(btnThemncc);

		btnsuancc = new JButton("Sửa");
		btnsuancc.setBounds(149, 93, 97, 25);
		panel_4_1.add(btnsuancc);

		btnxoancc = new JButton("Xoá");
		btnxoancc.setBounds(280, 93, 97, 25);
		panel_4_1.add(btnxoancc);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(12, 147, 365, 132);
		panel_4_1.add(scrollPane_7);
		dtmncc = new DefaultTableModel();
		dtmncc.addColumn("Mã NCC");
		dtmncc.addColumn("Tên Nhà Cung Cấp");
		tablencc = new JTable(dtmncc);
		scrollPane_7.setViewportView(tablencc);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBounds(352, 408, 389, 292);
		pnchung.add(panel_4_2);
		panel_4_2.setLayout(null);

		lblNewLabel_10 = new JLabel("Tên Kệ");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(12, 23, 79, 41);
		panel_4_2.add(lblNewLabel_10);

		txtKeSach = new JTextField();
		txtKeSach.setColumns(10);
		txtKeSach.setBounds(120, 23, 225, 41);
		panel_4_2.add(txtKeSach);

		btnthemkesach = new JButton("Thêm");
		btnthemkesach.setBounds(12, 86, 97, 25);
		panel_4_2.add(btnthemkesach);

		btnsuakesach = new JButton("Sửa");
		btnsuakesach.setBounds(149, 86, 97, 25);
		panel_4_2.add(btnsuakesach);

		btnxoakesach = new JButton("Xoá");
		btnxoakesach.setBounds(280, 86, 97, 25);
		panel_4_2.add(btnxoakesach);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(12, 143, 365, 136);
		panel_4_2.add(scrollPane_8);
		dtmke = new DefaultTableModel();
		dtmke.addColumn("Mã Kệ");
		dtmke.addColumn("Tên Kệ");
		tablekesach = new JTable(dtmke);
		scrollPane_8.setViewportView(tablekesach);

	}

	private void nhanvien() {

		pnnhanvien = new JPanel();
		pnnhanvien.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(118, 51, 866, 311);
		pnnhanvien.add(panel_2);
		panel_2.setLayout(null);

		lbltennv = new JLabel("Tên");
		lbltennv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv.setBounds(12, 13, 138, 39);
		panel_2.add(lbltennv);

		lblnamsinhnv = new JLabel("Năm Sinh");
		lblnamsinhnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamsinhnv.setBounds(12, 83, 138, 39);
		panel_2.add(lblnamsinhnv);

		lblaCh_1 = new JLabel("Địa Chỉ");
		lblaCh_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaCh_1.setBounds(12, 158, 138, 39);
		panel_2.add(lblaCh_1);

		lbltennv_3 = new JLabel("Giới Tính");
		lbltennv_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_3.setBounds(472, 13, 138, 39);
		panel_2.add(lbltennv_3);

		lbltennv_4 = new JLabel("Số Điện Thoại");
		lbltennv_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_4.setBounds(472, 83, 138, 39);
		panel_2.add(lbltennv_4);

		lbltennv_5 = new JLabel("Ngày Bắt Đầu");
		lbltennv_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_5.setBounds(472, 158, 138, 39);
		panel_2.add(lbltennv_5);

		txttennv = new JTextField();
		txttennv.setBounds(162, 13, 199, 39);
		panel_2.add(txttennv);
		txttennv.setColumns(10);

		txtnamsinhnv = new JTextField();
		txtnamsinhnv.setColumns(10);
		txtnamsinhnv.setBounds(162, 83, 199, 39);
		panel_2.add(txtnamsinhnv);

		txtdiachinv = new JTextField();
		txtdiachinv.setColumns(10);
		txtdiachinv.setBounds(162, 158, 199, 39);
		panel_2.add(txtdiachinv);

		txtngaybatdau = new JTextField();
		txtngaybatdau.setColumns(10);
		txtngaybatdau.setBounds(608, 158, 199, 39);
		panel_2.add(txtngaybatdau);

		txtsodienthoainv = new JTextField();
		txtsodienthoainv.setColumns(10);
		txtsodienthoainv.setBounds(608, 83, 199, 39);
		panel_2.add(txtsodienthoainv);

		txtgioitinhnv = new JTextField();
		txtgioitinhnv.setColumns(10);
		txtgioitinhnv.setBounds(608, 13, 199, 39);
		panel_2.add(txtgioitinhnv);

		btnthemnv = new JButton("Thêm");
		btnthemnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemnv.setBounds(58, 245, 119, 53);
		panel_2.add(btnthemnv);

		btnsuanv = new JButton("Sửa");
		btnsuanv.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsuanv.setBounds(259, 245, 119, 53);
		panel_2.add(btnsuanv);

		btnxoanv = new JButton("Xoá\r\n");
		btnxoanv.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxoanv.setBounds(467, 245, 119, 53);
		panel_2.add(btnxoanv);

		btnreloadnv = new JButton("Tải Lại");
		btnreloadnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnreloadnv.setBounds(688, 245, 119, 53);
		panel_2.add(btnreloadnv);

		lbltimkiem = new JLabel("Tìm kiếm");
		lbltimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltimkiem.setBounds(118, 405, 138, 39);
		pnnhanvien.add(lbltimkiem);

		txtTimKiemnv = new JTextField();
		txtTimKiemnv.setBounds(294, 405, 382, 39);
		pnnhanvien.add(txtTimKiemnv);
		txtTimKiemnv.setColumns(10);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(118, 469, 866, 253);
		pnnhanvien.add(scrollPane_4);
		dtmnhanvien = new DefaultTableModel();
		dtmnhanvien.addColumn("Mã");
		dtmnhanvien.addColumn("Họ Tên");
		dtmnhanvien.addColumn("Năm Sinh");
		dtmnhanvien.addColumn("Giới Tính");
		dtmnhanvien.addColumn("Địa Chi");
		dtmnhanvien.addColumn("SĐT");

		tablenhanvien = new JTable(dtmnhanvien);
		scrollPane_4.setViewportView(tablenhanvien);

	}

	private void nhaxuatban() {

		pnnhaxuatban = new JPanel();
		pnnhaxuatban.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(216, 64, 708, 327);
		pnnhaxuatban.add(panel_1);
		panel_1.setLayout(null);

		lblTennhaxuatban = new JLabel("Tên Nhà Xuất Bản");
		lblTennhaxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTennhaxuatban.setBounds(43, 38, 145, 43);
		panel_1.add(lblTennhaxuatban);

		lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaCh.setBounds(43, 104, 145, 43);
		panel_1.add(lblaCh);

		lblTennhaxuatban_2 = new JLabel("Số Điện Thoại");
		lblTennhaxuatban_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTennhaxuatban_2.setBounds(43, 172, 145, 43);
		panel_1.add(lblTennhaxuatban_2);

		txtTennhaxuatban = new JTextField();
		txtTennhaxuatban.setBounds(321, 44, 282, 37);
		panel_1.add(txtTennhaxuatban);
		txtTennhaxuatban.setColumns(10);

		txtdiachinxb = new JTextField();
		txtdiachinxb.setColumns(10);
		txtdiachinxb.setBounds(321, 110, 282, 37);
		panel_1.add(txtdiachinxb);

		txtsdtnxb = new JTextField();
		txtsdtnxb.setColumns(10);
		txtsdtnxb.setBounds(321, 172, 282, 37);
		panel_1.add(txtsdtnxb);

		btnThemnxb = new JButton("Thêm");
		btnThemnxb.setBounds(43, 252, 108, 47);
		panel_1.add(btnThemnxb);

		btnsuanxb = new JButton("Sửa");
		btnsuanxb.setBounds(221, 252, 108, 47);
		panel_1.add(btnsuanxb);

		btnxoanxb = new JButton("Xoá");
		btnxoanxb.setBounds(387, 252, 108, 47);
		panel_1.add(btnxoanxb);

		btnreloadnxb = new JButton("Tải Lại");
		btnreloadnxb.setBounds(562, 252, 108, 47);
		panel_1.add(btnreloadnxb);

		lblTimKiemnxb = new JLabel("Số Điện Thoại");
		lblTimKiemnxb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiemnxb.setBounds(260, 419, 145, 43);
		pnnhaxuatban.add(lblTimKiemnxb);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(427, 419, 282, 37);
		pnnhaxuatban.add(textField_3);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(211, 473, 713, 249);
		pnnhaxuatban.add(scrollPane_3);
		dtmnhaxuatban = new DefaultTableModel();
		dtmnhaxuatban.addColumn("Mã Nhà Xuất Bản");
		dtmnhaxuatban.addColumn("Tên Nhà Xuất Bản");
		dtmnhaxuatban.addColumn("Địa Chỉ");
		dtmnhaxuatban.addColumn("Số Điện Thoại");
		tablenhaxuatban = new JTable(dtmnhaxuatban);
		scrollPane_3.setViewportView(tablenhaxuatban);

	}

	private void docgia() {

		pndocgia = new JPanel();
		pndocgia.setLayout(null);

		panelthongtindocgia = new JPanel();
		panelthongtindocgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongtindocgia.setBounds(56, 37, 837, 252);
		pndocgia.add(panelthongtindocgia);
		panelthongtindocgia.setLayout(null);

		lblTendocgia = new JLabel("Tên Đọc Giả");
		lblTendocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTendocgia.setBounds(91, 13, 91, 36);
		panelthongtindocgia.add(lblTendocgia);

		lbldiachidocgia = new JLabel("Địa Chỉ");
		lbldiachidocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiachidocgia.setBounds(91, 119, 91, 36);
		panelthongtindocgia.add(lbldiachidocgia);

		lblgioitinhdocgia = new JLabel("Giới Tính");
		lblgioitinhdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgioitinhdocgia.setBounds(453, 119, 91, 36);
		panelthongtindocgia.add(lblgioitinhdocgia);

		lblSdtdocgia = new JLabel("Số điện thoại");
		lblSdtdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSdtdocgia.setBounds(453, 13, 109, 36);
		panelthongtindocgia.add(lblSdtdocgia);

		txtTendocgia = new JTextField();
		txtTendocgia.setBounds(192, 13, 208, 36);
		panelthongtindocgia.add(txtTendocgia);
		txtTendocgia.setColumns(10);

		txtdiachidocgia = new JTextField();
		txtdiachidocgia.setColumns(10);
		txtdiachidocgia.setBounds(192, 119, 208, 36);
		panelthongtindocgia.add(txtdiachidocgia);

		txtgioitinhdocgia = new JTextField();
		txtgioitinhdocgia.setColumns(10);
		txtgioitinhdocgia.setBounds(569, 119, 208, 36);
		panelthongtindocgia.add(txtgioitinhdocgia);

		txtsdtdocgia = new JTextField();
		txtsdtdocgia.setColumns(10);
		txtsdtdocgia.setBounds(569, 13, 208, 36);
		panelthongtindocgia.add(txtsdtdocgia);

		btnthemdocgia = new JButton("Thêm Đọc Giả");
		btnthemdocgia.setBounds(84, 190, 119, 49);
		panelthongtindocgia.add(btnthemdocgia);

		btnsuadocgia = new JButton("Sửa Đọc Giả");
		btnsuadocgia.setBounds(375, 190, 119, 49);
		panelthongtindocgia.add(btnsuadocgia);

		btnxoadocgia = new JButton("Xoá Đoc Giả");
		btnxoadocgia.setBounds(658, 190, 119, 49);
		panelthongtindocgia.add(btnxoadocgia);

		txtTimkiemdocgia = new JTextField();
		txtTimkiemdocgia.setBounds(251, 322, 442, 42);
		pndocgia.add(txtTimkiemdocgia);
		txtTimkiemdocgia.setColumns(10);

		btnTimkiemdocgia = new JButton("Tìm");
		btnTimkiemdocgia.setBounds(742, 322, 120, 42);
		pndocgia.add(btnTimkiemdocgia);

		lblTimKiem = new JLabel("Tìm Kiếm");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(98, 322, 91, 36);
		pndocgia.add(lblTimKiem);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 403, 1005, 308);
		pndocgia.add(scrollPane_1);
		dtmdocgia = new DefaultTableModel();
		dtmdocgia.addColumn("Mã Đọc Giả");
		dtmdocgia.addColumn("Họ Và Tên");
		dtmdocgia.addColumn("Giới Tính");
		dtmdocgia.addColumn("Số Điện Thạoi");
		dtmdocgia.addColumn("Địa Chỉ");
		tabledocgia = new JTable(dtmdocgia);
		scrollPane_1.setViewportView(tabledocgia);

	}

	private void pntacgia() {

		pntacgia = new JPanel();
		pntacgia.setLayout(null);

		pnthongtintacgia = new JPanel();
		pnthongtintacgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnthongtintacgia.setBounds(180, 78, 607, 281);
		pntacgia.add(pnthongtintacgia);
		pnthongtintacgia.setLayout(null);

		lblTentacgia = new JLabel("Tên Tác Giả");
		lblTentacgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTentacgia.setBounds(24, 51, 152, 37);
		pnthongtintacgia.add(lblTentacgia);

		txtTentacgia = new JTextField();
		txtTentacgia.setBounds(287, 51, 224, 37);
		pnthongtintacgia.add(txtTentacgia);
		txtTentacgia.setColumns(10);

		lblnamsinh = new JLabel("Năm Sinh");
		lblnamsinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamsinh.setBounds(24, 116, 152, 37);
		pnthongtintacgia.add(lblnamsinh);

		txtnamsinhtacgia = new JTextField();
		txtnamsinhtacgia.setColumns(10);
		txtnamsinhtacgia.setBounds(287, 117, 224, 37);
		pnthongtintacgia.add(txtnamsinhtacgia);

		lblTentacgia_2 = new JLabel("Quê Quán");
		lblTentacgia_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTentacgia_2.setBounds(24, 189, 152, 37);
		pnthongtintacgia.add(lblTentacgia_2);

		txtQueQuan = new JTextField();
		txtQueQuan.setColumns(10);
		txtQueQuan.setBounds(287, 189, 224, 37);
		pnthongtintacgia.add(txtQueQuan);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(180, 393, 792, 316);
		pntacgia.add(scrollPane_2);

		dtmtacgia = new DefaultTableModel();
		dtmtacgia.addColumn("Mã Tác Giả");
		dtmtacgia.addColumn("Tên Tác Giả");
		dtmtacgia.addColumn("Năm Sinh");
		dtmtacgia.addColumn("Quê Quán");
		tabletacgia = new JTable(dtmtacgia);
		scrollPane_2.setViewportView(tabletacgia);

		btnThemTacgia = new JButton("Thêm");
		btnThemTacgia.setBounds(834, 142, 126, 37);
		pntacgia.add(btnThemTacgia);

		btnsuatacgia = new JButton("Sửa");
		btnsuatacgia.setBounds(834, 206, 126, 37);
		pntacgia.add(btnsuatacgia);

		btnxoatacgia = new JButton("Xoá");
		btnxoatacgia.setBounds(834, 264, 126, 37);
		pntacgia.add(btnxoatacgia);

		btnreloadtacgia = new JButton("Tải Lại");
		btnreloadtacgia.setBounds(834, 322, 126, 37);
		pntacgia.add(btnreloadtacgia);

	}

	private void pnsach() {

		pnSach = new JPanel();

		pnSach.setLayout(null);

		lbltitlepnSach = new JLabel("Sách");
		lbltitlepnSach.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltitlepnSach.setBounds(502, 0, 76, 77);
		pnSach.add(lbltitlepnSach);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(70, 77, 788, 257);
		pnSach.add(panel);
		panel.setLayout(null);

		lblTenSach = new JLabel("Tên Sách");
		lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSach.setBounds(12, 13, 112, 34);
		panel.add(lblTenSach);

		lblMaLoai = new JLabel("Mã Loại");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaLoai.setBounds(12, 64, 112, 34);
		panel.add(lblMaLoai);

		lblNewLabel_2 = new JLabel("Mã Nhà Xuất Bản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 111, 132, 34);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Mã Tác Giả");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(12, 160, 112, 34);
		panel.add(lblNewLabel_3);

		lblHinhAnh = new JLabel("Hình Ảnh");
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinhAnh.setBounds(398, 13, 112, 34);
		panel.add(lblHinhAnh);

		lblnamxuatban = new JLabel("Năm Xuất Bản");
		lblnamxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamxuatban.setBounds(398, 64, 112, 34);
		panel.add(lblnamxuatban);

		lblSLng = new JLabel("Số Lượng");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSLng.setBounds(398, 111, 112, 34);
		panel.add(lblSLng);

		lblMaKeSach = new JLabel("Mã Kệ Sách");
		lblMaKeSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaKeSach.setBounds(398, 160, 112, 34);
		panel.add(lblMaKeSach);

		txttensach = new JTextField();
		txttensach.setBounds(156, 14, 203, 34);
		panel.add(txttensach);
		txttensach.setColumns(10);

		cmbmaloai = new JComboBox();
		cmbmaloai.setBounds(156, 71, 203, 27);
		cmbmaloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cmbmaloai.getSelectedItem() == null) {
					return;
				}
				loaisl = (LoaisachDTO) cmbmaloai.getSelectedItem();

			}
		});
		panel.add(cmbmaloai);

		cmbmanhaxuatban = new JComboBox();
		cmbmanhaxuatban.setBounds(156, 118, 203, 27);
		cmbmanhaxuatban.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cmbmanhaxuatban.getSelectedItem() == null) {
					return;
				}
				nxbsl = (NhaXuatBan) cmbmanhaxuatban.getSelectedItem();
			}
		});
		panel.add(cmbmanhaxuatban);

		cmbmatg = new JComboBox();
		cmbmatg.setBounds(156, 160, 203, 27);
		cmbmatg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cmbmatg.getSelectedItem() == null) {
					return;
				}
				tacgiasl = (TacGiaDTO) cmbmatg.getSelectedItem();
			}
		});
		panel.add(cmbmatg);

		cmbmakesach = new JComboBox();
		cmbmakesach.setBounds(522, 160, 207, 27);
		cmbmakesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cmbmakesach.getSelectedItem() == null) {
					return;
				}
				kesl = (KeSachDTO) cmbmakesach.getSelectedItem();
			}
		});
		panel.add(cmbmakesach);

		txtsoluongsach = new JTextField();
		txtsoluongsach.setBounds(522, 111, 207, 34);
		panel.add(txtsoluongsach);
		txtsoluongsach.setColumns(10);

		txtnamxbsach = new JTextField();
		txtnamxbsach.setColumns(10);
		txtnamxbsach.setBounds(522, 64, 207, 34);
		panel.add(txtnamxbsach);

		JButton btnNewButton = new JButton("Chọn Ảnh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter imgfiler = new FileNameExtensionFilter("Hình Ảnh", "png", "jpg");
				filechooser.setFileFilter(imgfiler);
				filechooser.setMultiSelectionEnabled(false);
				int x = filechooser.showDialog(contentPane, "Chọn");

				if (x == JFileChooser.APPROVE_OPTION) {
					File f = filechooser.getSelectedFile();
					hinhanh = f.getAbsolutePath().substring(f.getAbsolutePath().indexOf("img"),
							f.getAbsolutePath().length());
					// c/a/img/anh.png
					// cắt chuỗi lấy ảnh từ img cho đến cuối chuỗi
					// img/anh.png
					lblhinhanhpre.setIcon(new ImageIcon(f.getAbsolutePath()));

				}
			}
		});
		btnNewButton.setBounds(522, 19, 112, 28);
		panel.add(btnNewButton);

		btnthemsach = new JButton("Thêm");
		btnthemsach.setBounds(12, 219, 112, 38);
		panel.add(btnthemsach);

		btnsuasach = new JButton("Sửa");
		btnsuasach.setBounds(213, 219, 112, 38);
		panel.add(btnsuasach);

		btnxoasach = new JButton("Xoá");
		btnxoasach.setBounds(408, 219, 112, 38);
		panel.add(btnxoasach);

		btnloadlaitrang = new JButton("Tải Lại");
		btnloadlaitrang.setBounds(620, 219, 112, 38);
		panel.add(btnloadlaitrang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 406, 1024, 316);
		pnSach.add(scrollPane);
		dtmsach = new DefaultTableModel();
		dtmsach.addColumn("Mã Sách");
		dtmsach.addColumn("Tên Sách");
		dtmsach.addColumn("Mã Loại");
		dtmsach.addColumn("Mã Nhà Xuất Bản");
		dtmsach.addColumn("Mã Tác Giả");
		dtmsach.addColumn("Năm Xuất Bản");
		dtmsach.addColumn("Số Lượng");
		dtmsach.addColumn("Mã Kệ");
		
		
		table = new JTable(dtmsach);
		scrollPane.setViewportView(table);
		JPopupMenu popupMenu = new JPopupMenu();
		mntmNewMenuItem = new JMenuItem("Thông tin chi tiết");
		mntmNewMenuItem.setBounds(0, 0, 113, 19);
		popupMenu.add(mntmNewMenuItem);

		addPopup(table, popupMenu);

	}

	private void trangchu() {

		pnTrangChu = new JPanel();

		pnTrangChu.setLayout(null);

		/* PANEL NHÂN VIÊN */

		lblNewLabel = new JLabel("TRANG CHỦ");
		lblNewLabel.setBounds(282, 149, 580, 317);
		pnTrangChu.add(lblNewLabel);
	}

	public void addEvent() {
		tabledocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int i = tabledocgia.getSelectedRow();
				if (i >= 0) {
					txtTendocgia.setText(dtmdocgia.getValueAt(i, 1).toString());
					txtgioitinhdocgia.setText(dtmdocgia.getValueAt(i, 2).toString());

					txtdiachidocgia.setText(dtmdocgia.getValueAt(i, 3).toString());
					txtsdtdocgia.setText(dtmdocgia.getValueAt(i, 4).toString());
				}

			}
		});
		tabletacgia.addMouseListener(new MouseListener() {

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

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					txtTentacgia.setText(dtmtacgia.getValueAt(i, 1).toString());
					txtnamsinhtacgia.setText(dtmtacgia.getValueAt(i, 2).toString());
					txtQueQuan.setText(dtmtacgia.getValueAt(i, 3).toString());
				}

			}
		});

		lbldangxuat.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lbldangxuat.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lbldangxuat.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				setVisible(false);
				LoginForm.dangnhap = false;
				LoginForm.isdangnhap = false;
				TaiKhoanBus bus = new TaiKhoanBus();
				LoginForm.taikhoan = bus.getDanhSachTL();
				new LoginForm().setVisible(true);
				return;

			}
		});
		lblchung.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblchung.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblchung.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show();

			}
		});
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		lblnhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblnhanvien.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblnhanvien.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(true);
				pnPhieumuon.show(false);
				pnchung.show(false);
			}
		});

		lblnhaxuatban.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblnhaxuatban.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblnhaxuatban.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(true);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
			}
		});
		lbldocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbldocgia.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbldocgia.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(true);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
			}
		});
		lblTrangchu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblTrangchu.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblTrangchu.setBackground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show();
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
			}
		});
		lblSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblSach.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblSach.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(true);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
			}
		});
		lbltacgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbltacgia.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbltacgia.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				// lblTitle.setText("Tác Giả");
				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(true);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);

				pnchung.show(false);
			}
		});

		lblphieumuon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblphieumuon.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblphieumuon.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show();

				pnchung.show(false);
			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {

				x_mouse = arg0.getX();
				y_mouse = arg0.getY();

			}

			@Override
			public void mouseDragged(MouseEvent arg0) {

				moveFrame(arg0.getXOnScreen(), arg0.getYOnScreen());

			}

		});
		tableloai.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tableloai.getSelectedRow();
				if (i >= 0) {
					txttenloai.setText(dtmloai.getValueAt(i, 1).toString());
				}
			}
		});
		;

		tablencc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tablencc.getSelectedRow();
				if (i >= 0) {
					txtNcc.setText(dtmncc.getValueAt(i, 1).toString());
				}
			}
		});

		tablekesach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tablekesach.getSelectedRow();
				if (i >= 0) {
					txtKeSach.setText("" + dtmke.getValueAt(i, 1));
				}
			}
		});

		btnthemkesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				KeSachDTO ke = new KeSachDTO(2, txtKeSach.getText());
				if (KeSachBus.gI().themke(ke) >= 0) {
					loadkesach();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}
			}
		});
		btnsuakesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablekesach.getSelectedRow();
				int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
				KeSachDTO ke = new KeSachDTO(vitri, txtKeSach.getText());
				if (KeSachBus.gI().suake(ke) >= 0) {
					loadkesach();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}
			}
		});
		btnxoakesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablekesach.getSelectedRow();
				int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
				KeSachDTO ke = new KeSachDTO(vitri, txtKeSach.getText());
				if (KeSachBus.gI().xoake(ke) >= 0) {
					loadkesach();
					JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
				}
			}
		});

		btnxoaloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tableloai.getSelectedRow();
				int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
				LoaisachDTO ke = new LoaisachDTO(vitri, txttenloai.getText());
				if (LoaiBUS.gI().xoaloai(ke) >= 0) {
					loadloaisach();
					JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
				}
			}
		});
		btnThemloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				LoaisachDTO ke = new LoaisachDTO(2, txttenloai.getText());
				if (LoaiBUS.gI().themloai(ke) >= 0) {
					loadloaisach();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}
			}
		});

		btnsualoai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tableloai.getSelectedRow();
				int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
				LoaisachDTO ke = new LoaisachDTO(vitri, txttenloai.getText());
				if (LoaiBUS.gI().sualoai(ke) >= 0) {
					loadloaisach();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}
			}
		});

		btnxoancc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablencc.getSelectedRow();
				int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
				NhaCungCapDTO ke = new NhaCungCapDTO(vitri, txtNcc.getText());
				if (NhaCungcapbus.gI().xoancc(ke) >= 0) {
					loadnhacungcap();
					JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
				}
			}
		});
		btnThemncc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NhaCungCapDTO ke = new NhaCungCapDTO(0, txtNcc.getText());
				if (NhaCungcapbus.gI().themncc(ke) >= 0) {
					loadnhacungcap();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}
			}
		});

		btnsuancc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablencc.getSelectedRow();
				int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
				NhaCungCapDTO ke = new NhaCungCapDTO(vitri, txtNcc.getText());
				if (NhaCungcapbus.gI().suancc(ke) >= 0) {
					loadnhacungcap();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}
			}
		});
		tablenhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = tablenhanvien.getSelectedRow();
				if (i >= 0) {
					txttennv.setText(dtmnhanvien.getValueAt(i, 1).toString());
					txtnamsinhnv.setText(dtmnhanvien.getValueAt(i, 2).toString());
					txtgioitinhnv.setText(dtmnhanvien.getValueAt(i, 3).toString());
					txtdiachinv.setText(dtmnhanvien.getValueAt(i, 4).toString());
					txtsodienthoainv.setText(dtmnhanvien.getValueAt(i, 5).toString());
					// txtngaybatdau.setText(dtmnhanvien.getValueAt(i, 6).toString());

				}
			}
		});

		btnsuanv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhanvien.getSelectedRow();
				int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
				// JOptionPane.showMessageDialog(contentPane, vitri);
				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
				NhanVien nv;
				nv = new NhanVien(vitri, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
						txtsodienthoainv.getText(), txtdiachinv.getText());

				if (NhanVienBus.gI().suanhanvien(nv) >= 0) {
					loadnhanvien();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}

			}
		});

		btnthemnv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NhanVien nv;
				nv = new NhanVien(0, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
						txtsodienthoainv.getText(), txtdiachinv.getText());

				if (NhanVienBus.gI().themnhanvien(nv) >= 0) {
					loadnhanvien();

					try {

						idtaikhoan = Integer
								.parseInt(dtmnhanvien.getValueAt(tablenhanvien.getRowCount() - 1, 0).toString());
						System.out.println(idtaikhoan);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					new TaiKhoan().setVisible(true);

					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});
		btnxoanv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhanvien.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
					SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
					NhanVien nv;
					nv = new NhanVien(vitri, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
							txtsodienthoainv.getText(), txtdiachinv.getText());

					if (NhanVienBus.gI().xoanhanvien(nv) >= 0) {
						loadnhanvien();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		txtTimKiemnv.getDocument().addDocumentListener(new DocumentListener() {
			// text field tìm kiếm nhân viên
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// text field thay đổi gọi lại search
				searchNv();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// text field thay đổi gọi lại search
				searchNv();
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// text field thay đổi gọi lại search
				searchNv();
			}

			public void searchNv() {
				// JOptionPane.showMessageDialog(contentPane, "Chạy tới đáy");
				try {
					dtmnhanvien.setRowCount(0);
					////// mỗi lần gọi lại xoá mịa cái table đi
					if (txtTimKiemnv.getText().isEmpty()) {
						// nếu txtfield rỗng thì hiển thị lại cái bảng đầy đủ
						loadnhanvien(); // hàm đẩy từ csdl vào bảng //
						return;
					}
					String s = txtTimKiemnv.getText().toLowerCase(); // chuyển chữ trong txtfield về chữ thường
					// nhờ v mà seach chữ thường chữ hoa gì cũng ra hết
					for (NhanVien nv : nv) {
						if (nv.getTenNV().toLowerCase().contains(s)) {
							// đúng điều kiện thì đẩy nó vào table
							Vector<Object> vec = new Vector<Object>();
							vec.add(nv.getMaNV());
							vec.add(nv.getTenNV());
							vec.add(nv.getNamSinh());
							vec.add(nv.getGioiTinh());
							vec.add(nv.getDiaChi());
							vec.add(nv.getSdt());
							dtmnhanvien.addRow(vec);
						}
						// .DesignLai.dtm.addRow(vec);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		tablenhaxuatban.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				int i = tablenhaxuatban.getSelectedRow();
				if (i >= 0) {
					txtTennhaxuatban.setText(dtmnhaxuatban.getValueAt(i, 1).toString());
					txtdiachinxb.setText(dtmnhaxuatban.getValueAt(i, 2).toString());
					txtsdtnxb.setText(dtmnhaxuatban.getValueAt(i, 3).toString());
				}
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

		btnThemnxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// int i = tablenhanvien.getSelectedRow();
				// int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
				NhaXuatBan nxb = new NhaXuatBan(0, txtTennhaxuatban.getText(), txtdiachinxb.getText(),
						txtsdtnxb.getText());

				if (NhaXuatBanBUS.gI().themnxb(nxb) >= 0) {
					loadnxb();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});
		btnsuanxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhaxuatban.getSelectedRow();
				int vitri = Integer.parseInt(dtmnhaxuatban.getValueAt(i, 0).toString());
				// JOptionPane.showMessageDialog(contentPane, vitri);
				NhaXuatBan nxb = new NhaXuatBan(vitri, txtTennhaxuatban.getText(), txtdiachinxb.getText(),
						txtsdtnxb.getText());

				if (NhaXuatBanBUS.gI().suanxb(nxb) >= 0) {
					loadnxb();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}

			}
		});

		btnxoanxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhaxuatban.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnhaxuatban.getValueAt(i, 0).toString());
					NhaXuatBan nxb = new NhaXuatBan(vitri, txtTennhaxuatban.getText(), txtdiachinxb.getText(),
							txtsdtnxb.getText());
					if (NhaXuatBanBUS.gI().xoanxb(nxb) >= 0) {
						loadnxb();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		/* THÊM SỬA XOÁ TÁC GIẢ *///
		/////////////////////////////////
		/////////////////////////////////

		btnThemTacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// int i = tablenhanvien.getSelectedRow();
				// int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
				TacGiaDTO tg = new TacGiaDTO(0, txtTentacgia.getText(), txtnamsinhtacgia.getText(),
						txtQueQuan.getText());

				if (TacGiaBUS.gI().themtacgia(tg) >= 0) {
					loadtacgia();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});
		btnsuatacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabletacgia.getSelectedRow();
				int vitri = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
				TacGiaDTO tg = new TacGiaDTO(vitri, txtTentacgia.getText(), txtnamsinhtacgia.getText(),
						txtQueQuan.getText());

				if (TacGiaBUS.gI().suatacgia(tg) >= 0) {
					loadtacgia();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}

			}
		});

		btnxoatacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
					TacGiaDTO tg = new TacGiaDTO(vitri, txtTentacgia.getText(), txtnamsinhtacgia.getText(),
							txtQueQuan.getText());
					if (TacGiaBUS.gI().xoatacgia(tg) >= 0) {
						loadtacgia();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
		///////////////////////////////////////////////////
		//////////////// THÊM SỬA XOÁ ĐỌC GIẢ //////////////////////////
		/////////////////////////////////////////////////
		btnthemdocgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = tabledocgia.getRowCount();

				DocGia docgia = new DocGia(0, txtTendocgia.getText(), txtgioitinhdocgia.getText(),
						txtdiachidocgia.getText(), txtsdtdocgia.getText());
				DocGiaBUS docgiabus = new DocGiaBUS();
				if (docgiabus.themdocgia(docgia) >= 0) {
					loaddocgia();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});

		btnsuadocgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabledocgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmdocgia.getValueAt(i, 0).toString());
					DocGia docgia = new DocGia(vitri, txtTendocgia.getText(), txtgioitinhdocgia.getText(),
							txtdiachidocgia.getText(), txtsdtdocgia.getText());
					if (DocGiaBUS.gI().suadocgia(docgia) >= 0) {
						loaddocgia();
						JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Sứa Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		btnxoadocgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabledocgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmdocgia.getValueAt(i, 0).toString());
					DocGia docgia = new DocGia(vitri, txtTendocgia.getText(), txtgioitinhdocgia.getText(),
							txtdiachidocgia.getText(), txtsdtdocgia.getText());
					if (DocGiaBUS.gI().xoadocgia(docgia) >= 0) {
						loaddocgia();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất Bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
		/////////////////////////// THÊM SỬA XOÁ SÁCH///////////////////////////
		//////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////

		btnthemsach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int makesach = kesl.getMaKeSach();
				int manxb = nxbsl.getMaNXB();
				int matg = tacgiasl.getMaTacGia();
				int loai = loaisl.getMaloai();
				String anh = hinhanh;
				String tensach = txttensach.getText();
				int namxb = Integer.parseInt(txtnamxbsach.getText());
				int soluong = Integer.parseInt(txtsoluongsach.getText());
				System.out.println(makesach);
				System.out.println(manxb);
				System.out.println(matg);
				System.out.println(loai);
				System.out.println(anh);
				System.out.println(tensach);
				System.out.println(namxb);
				System.out.println(soluong);
				
				SachDTO sach = new SachDTO(0, tensach, matg, manxb, loai, namxb, soluong, anh, "", makesach);
				
				if (SachDAL.themsach(sach) >= 0) {
					loadsach();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});

	}

	private void moveFrame(int x, int y) {

		this.setLocation(x - x_mouse, y - y_mouse);
	}

	public static ArrayList<LoaisachDTO> loaisacharr;

	public void loadloaisach() {
		loaisacharr = null;
		LoaiBUS loaiBUS = new LoaiBUS();
		loaisacharr = loaiBUS.getLoaisachLoai();
		dtmloai.setRowCount(0);
		cmbmaloai.removeAllItems();
		for (LoaisachDTO loaisachDTO : loaisacharr) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(loaisachDTO.getMaloai());
			vec.add(loaisachDTO.getTenloai());
			dtmloai.addRow(vec);
			cmbmaloai.addItem(loaisachDTO);

		}
	}

	public static ArrayList<NhaXuatBan> nxb;

	public void loadnxb() {
		nxb = null;
		NhaXuatBanBUS nxbbus = new NhaXuatBanBUS();
		nxb = nxbbus.getdanhsachnxb();
		dtmnhaxuatban.setRowCount(0);
		cmbmanhaxuatban.removeAllItems();
		for (NhaXuatBan loaisachDTO : nxb) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(loaisachDTO.getMaNXB());
			vec.add(loaisachDTO.getTenNXB());
			vec.add(loaisachDTO.getDiaChi());
			vec.add(loaisachDTO.getSdt());
			cmbmanhaxuatban.addItem(loaisachDTO);
			dtmnhaxuatban.addRow(vec);

		}
	}

	public static ArrayList<NhaCungCapDTO> ncc;

	public void loadnhacungcap() {
		ncc = null;
		NhaCungcapbus nccbus = new NhaCungcapbus();
		ncc = nccbus.getdanhsachncc();
		dtmncc.setRowCount(0);
		for (NhaCungCapDTO nhaCungCapDTO : ncc) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nhaCungCapDTO.getMaNCC());

			vec.add(nhaCungCapDTO.getTenNCC());
			dtmncc.addRow(vec);
		}

	}

	public static ArrayList<KeSachDTO> ke = new ArrayList<KeSachDTO>();

	public void loadkesach() {
		ke = null;
		KeSachBus keSachBus = new KeSachBus();
		ke = keSachBus.getdanhsachncc();
		dtmke.setRowCount(0);
		cmbmakesach.removeAllItems();
		for (KeSachDTO kesach : ke) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(kesach.getMaKeSach());

			vec.add(kesach.getViTri());
			cmbmakesach.addItem(kesach);
			dtmke.addRow(vec);

			// .DesignLai.dtm.addRow(vec);
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}

	public static ArrayList<NhanVien> nv = new ArrayList<NhanVien>();

	public void loadnhanvien() {
		nv = null;
		NhanVienBus nvbuss = new NhanVienBus();
		nv = nvbuss.getdanhsachnv();
		dtmnhanvien.setRowCount(0);
		for (NhanVien nv : nv) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nv.getMaNV());
			vec.add(nv.getTenNV());
			vec.add(nv.getNamSinh());
			vec.add(nv.getGioiTinh());
			vec.add(nv.getDiaChi());
			vec.add(nv.getSdt());
			dtmnhanvien.addRow(vec);
			// .DesignLai.dtm.addRow(vec);
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}

	public static ArrayList<TacGiaDTO> tg = new ArrayList<TacGiaDTO>();

	public void loadtacgia() {
		tg = null;
		TacGiaBUS tgbus = new TacGiaBUS();
		tg = tgbus.getdanhsachtacgia();
		dtmtacgia.setRowCount(0);
		cmbmatg.removeAllItems();
		for (TacGiaDTO tg : tg) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(tg.getMaTacGia());
			vec.add(tg.getTenTacGia());
			vec.add(tg.getNamSinh());
			vec.add(tg.getQueQuan());

			dtmtacgia.addRow(vec);
			cmbmatg.addItem(tg);
			// .DesignLai.dtm.addRow(vec);
		}

	}

	private JLabel lblhinhanhpre;
	private JButton btnthemsach;
	private JButton btnsuasach;
	private JButton btnxoasach;
	private JButton btnloadlaitrang;
	public static ArrayList<DocGia> dg = new ArrayList<DocGia>();

	public void loaddocgia() {
		dg = null;
		DocGiaBUS dgbus = new DocGiaBUS();
		dg = dgbus.getdanhsachdocgia();

		dtmdocgia.setRowCount(0);

		for (DocGia dg1 : dg) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(dg1.getMaDocGia());
			vec.add(dg1.getTenDocGia());
			vec.add(dg1.getGioiTinh());
			vec.add(dg1.getSdt());
			vec.add(dg1.getDiachi());

			dtmdocgia.addRow(vec);
			// .DesignLai.dtm.addRow(vec);
		}

	}

	public static ArrayList<SachDTO> sach = new ArrayList<SachDTO>();
	private JMenuItem mntmNewMenuItem;

	public void loadsach() {
		sach = null;
		SachBus sachbus = new SachBus();
		sach = sachbus.getLoaisachLoai();

		dtmsach.setRowCount(0);
		for (SachDTO sachitem : sach) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(sachitem.getMasosach());
			vec.add(sachitem.getTensach());
			vec.add(sachitem.getMaloai());
			vec.add(sachitem.getMaNXB());
			vec.add(sachitem.getMatacgia());
			vec.add(sachitem.getNamxb());
			vec.add(sachitem.getSoluong());
			vec.add(sachitem.getMake());
			dtmsach.addRow(vec);
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}