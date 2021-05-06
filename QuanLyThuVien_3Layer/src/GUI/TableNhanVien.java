package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBus;
import DTO.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TableNhanVien extends JFrame {

	private JPanel contentPane;
	private JTable tablenhanvien;
	private JTextField txttim;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btntimnv;
	private DefaultTableModel dtmnhanvien;

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public TableNhanVien() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 194, 775, 195);
		contentPane.add(scrollPane);

		dtmnhanvien = new DefaultTableModel();
		dtmnhanvien.addColumn("Mã");
		dtmnhanvien.addColumn("Họ Tên");
		dtmnhanvien.addColumn("Năm Sinh");
		dtmnhanvien.addColumn("Giới Tính");
		dtmnhanvien.addColumn("Địa Chỉ");
		dtmnhanvien.addColumn("SĐT");
		tablenhanvien = new MyTable(dtmnhanvien);

		scrollPane.setViewportView(tablenhanvien);

		lblNewLabel = new JLabel("Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(379, 13, 107, 32);
		contentPane.add(lblNewLabel);

		txttim = new JTextField();
		txttim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttim.setBounds(122, 72, 581, 48);
		contentPane.add(txttim);
		txttim.getDocument().addDocumentListener(new DocumentListener() {
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
					if (txttim.getText().isEmpty()) {
						// nếu txtfield rỗng thì hiển thị lại cái bảng đầy đủ
						loadnhanvien(); // hàm đẩy từ csdl vào bảng //
						return;
					}
					String s = txttim.getText().toLowerCase(); // chuyển chữ trong txtfield về chữ thường
					// nhờ v mà seach chữ thường chữ hoa gì cũng ra hết
					for (NhanVien nv : MainFrame.nv) {
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
		txttim.setColumns(10);

		lblNewLabel_1 = new JLabel("Tìm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 72, 56, 48);
		contentPane.add(lblNewLabel_1);

		btntimnv = new JButton("Tìm");
		btntimnv.setBounds(715, 78, 95, 37);
		contentPane.add(btntimnv);

		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tablenhanvien.getSelectedRow();
				if(i>=0) {
					String masach =  dtmnhanvien.getValueAt(i, 0).toString();
					MainFrame.txtManhanvienphieunhap.setText(masach);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Chưa chọn vào table");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(686, 411, 124, 38);
		contentPane.add(btnNewButton);
		loadnhanvien();
		setLocationRelativeTo(null);
		
	}
	
	public void loadnhanvien() {
		MainFrame.nv = null;
		NhanVienBus nvbuss = new NhanVienBus();
		MainFrame.nv = nvbuss.getdanhsachnv();
		dtmnhanvien.setRowCount(0);
		for (NhanVien nv : MainFrame.nv) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nv.getMaNV());
			vec.add(nv.getTenNV());
			vec.add(nv.getNamSinh());
			vec.add(nv.getGioiTinh());
			vec.add(nv.getDiaChi());
			vec.add(nv.getSdt());
			dtmnhanvien.addRow(vec);
		
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}
}
