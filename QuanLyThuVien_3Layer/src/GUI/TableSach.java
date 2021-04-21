package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableSach frame = new TableSach();
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
	public TableSach() {
		setTitle("Chọn Loại Sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(391, 13, 53, 35);
		contentPane.add(lblNewLabel);

		JLabel lblTm = new JLabel("Tìm");
		lblTm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTm.setBounds(85, 88, 53, 35);
		contentPane.add(lblTm);

		textField = new JTextField();
		textField.setBounds(160, 82, 477, 49);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(669, 88, 118, 35);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 165, 750, 211);
		contentPane.add(scrollPane);
		dtmsach = new DefaultTableModel();
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
				
				dispose();
				
			}
		});
		contentPane.add(btnLuu);
		setLocationRelativeTo(null);
	}
}