package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableNhanVien frame = new TableNhanVien();
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
	public TableNhanVien() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(686, 411, 124, 38);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
