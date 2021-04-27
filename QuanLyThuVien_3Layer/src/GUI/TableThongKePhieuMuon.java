package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.chitietpmbus;
import DTO.ChiTieuPMDTO;
import Export.ExportExcel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JLabel;

public class TableThongKePhieuMuon extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtmthongkephieumuon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableThongKePhieuMuon frame = new TableThongKePhieuMuon();
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
	public TableThongKePhieuMuon() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 123, 708, 251);
		contentPane.add(scrollPane);
		dtmthongkephieumuon = new DefaultTableModel();
		dtmthongkephieumuon.addColumn("Mã CTPM");
		dtmthongkephieumuon.addColumn("Mã PM");
		dtmthongkephieumuon.addColumn("Mã Sách");
		dtmthongkephieumuon.addColumn("Ngày Mượn");
		dtmthongkephieumuon.addColumn("Ngày Trả");
		dtmthongkephieumuon.addColumn("Ghi Chú");
		
		table = new MyTable(dtmthongkephieumuon);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Xuất");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Export.ExportExcel ex= new ExportExcel();
				ex.xuatExcel(table);
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(499, 394, 97, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đóng");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(623, 394, 97, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ SÁCH ĐÃ MƯỢN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(201, 29, 292, 69);
		contentPane.add(lblNewLabel);
		loadthongkephieumuon();
		setLocationRelativeTo(null);
	}
	
	public static ArrayList<ChiTieuPMDTO> ctpmthongke = new ArrayList<ChiTieuPMDTO>();

	public void loadthongkephieumuon() {
		ctpmthongke = null;
		chitietpmbus ctpmbus = new chitietpmbus();
		ctpmthongke = ctpmbus.thongkephieumuon();
		dtmthongkephieumuon.setRowCount(0);

		for (ChiTieuPMDTO pm : ctpmthongke) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pm.getMaChiTietPhieuMuon());
			vec.add(pm.getMaPhieuMuon());
			vec.add(pm.getMaSach());
			vec.add(pm.getNgayMuon());
			vec.add(pm.getNgayTra());
			vec.add(pm.getGhichu());
			dtmthongkephieumuon.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}
}
