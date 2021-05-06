package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.NhaCungcapbus;
import DTO.NhaCungCapDTO;

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

public class TableNCC extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DefaultTableModel dtmncc;

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public TableNCC() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 154, 733, 240);
		contentPane.add(scrollPane);
		dtmncc = new DefaultTableModel();
		dtmncc.addColumn("Mã NCC");
		dtmncc.addColumn("Tên Nhà Cung Cấp");
		
		table = new MyTable(dtmncc);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Nhà Cung Cấp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(306, 13, 125, 47);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(128, 94, 503, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm Kiếm");
		btnNewButton.setBounds(643, 98, 97, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 93, 85, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnluu = new JButton("Lưu");
		btnluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					String masach =  dtmncc.getValueAt(i, 0).toString();
					MainFrame.txtManccPhieuNhap.setText(masach);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Chưa chọn vào table");
				}
				
			}
		});
		btnluu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnluu.setBounds(591, 397, 116, 38);
		contentPane.add(btnluu);
		loadnhacungcap();
		setLocationRelativeTo(null);
	}
	public void loadnhacungcap() {
		MainFrame.ncc = null;
		NhaCungcapbus nccbus = new NhaCungcapbus();
		MainFrame.ncc = nccbus.getdanhsachncc();
		dtmncc.setRowCount(0);
		for (NhaCungCapDTO nhaCungCapDTO : MainFrame.ncc) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nhaCungCapDTO.getMaNCC());

			vec.add(nhaCungCapDTO.getTenNCC());
			dtmncc.addRow(vec);
		}

	}
}
