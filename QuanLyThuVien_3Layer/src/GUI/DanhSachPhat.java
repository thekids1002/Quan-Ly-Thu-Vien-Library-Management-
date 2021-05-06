package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietPhieuNhapBUS;
import BUS.PhatBus;
import DTO.ChiTietPhieuNhap;
import Export.ExportExcel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;

public class DanhSachPhat extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtmdsphat;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DanhSachPhat() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 79, 616, 201);
		contentPane.add(scrollPane);
		dtmdsphat = new DefaultTableModel();
		dtmdsphat.addColumn("Mã Phiếu Phạt");
		dtmdsphat.addColumn("Mã Phiếu Mượn");
		dtmdsphat.addColumn("Lý Do");
		dtmdsphat.addColumn("Số Tiền");
		table = new MyTable(dtmdsphat);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH PHẠT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(264, 13, 145, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("In danh sách");
		btnNewButton.setBounds(525, 293, 103, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ExportExcel().xuatExcel(table);
				
			}
		});
		setLocationRelativeTo(null);
		loadphat();
	}
	
	public static ArrayList<DTO.Phat> phat = new ArrayList<DTO.Phat>();

	public void loadphat() {
		phat = null;
		phat =PhatBus.gI().getdanhsachphat(); 

		dtmdsphat.setRowCount(0);

		for (DTO.Phat pn : phat) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaphieuphat());
			vec.add(pn.getMapm());
			vec.add(pn.getLydo());
			vec.add(pn.getTienphat());
			

			dtmdsphat.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}
}
