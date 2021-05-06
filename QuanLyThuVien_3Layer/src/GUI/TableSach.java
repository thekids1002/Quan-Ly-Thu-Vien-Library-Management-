package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.SachBus;
import DTO.SachDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableSach extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel dtmsach;
	private JButton btnLuu;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TableSach() {
		setTitle("Chọn Loại Sách");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 857, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(391, 13, 53, 35);
		contentPane.add(lblNewLabel);
		dtmsach = new DefaultTableModel();
		JLabel lblTm = new JLabel("Tìm");
		lblTm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTm.setBounds(85, 88, 53, 35);
		contentPane.add(lblTm);

		textField = new JTextField();
		textField.setBounds(160, 82, 477, 49);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Tìm theo mã");
				if (!MainFrame.isNumber(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Tìm Kiếm Theo Mã Sách");
					return;
				}
				int masach = Integer.parseInt(textField.getText());
				SachDTO sach = SachBus.gI().timsach(masach);
				dtmsach.setRowCount(0);
				if (sach != null) {
					Vector<Object> vec = new Vector<Object>();
					vec.add(sach.getMasosach());
					vec.add(sach.getTensach());
					vec.add(sach.getMaloai());
					vec.add(sach.getMaNXB());
					vec.add(sach.getMatacgia());
					vec.add(sach.getNamxb());
					vec.add(sach.getSoluong());
					vec.add(sach.getMake());
					vec.add(sach.getHinhanh());
					dtmsach.addRow(vec);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(669, 88, 118, 35);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 165, 750, 211);
		contentPane.add(scrollPane);
		
		dtmsach.addColumn("Mã Sách");
		dtmsach.addColumn("Tên Sách");
		dtmsach.addColumn("Mã Loại");
		dtmsach.addColumn("Mã NXB");
		dtmsach.addColumn("Mã Tác Giả");
		dtmsach.addColumn("Năm Xuất Bản");
		dtmsach.addColumn("Số Lượng");
		dtmsach.addColumn("Mã Kệ");
		table = new MyTable(dtmsach);
		scrollPane.setViewportView(table);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLuu.setBounds(664, 389, 132, 33);
		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					String masach = dtmsach.getValueAt(i, 0).toString();
					if (MainFrame.pnPhieumuon.isShowing()) {
						MainFrame.txtmasachmuon.setText(masach);
					} else {
						MainFrame.txtMaSachctpn.setText(masach);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Chưa chọn vào table");
				}
				dispose();

			}
		});
		contentPane.add(btnLuu);
		setLocationRelativeTo(null);
		loadsach();
	}

	public void loadsach() {
		dtmsach.setRowCount(0);
		for (SachDTO sachitem : MainFrame.sach) {
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
}
