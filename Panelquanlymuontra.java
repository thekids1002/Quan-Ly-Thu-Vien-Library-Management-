package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panelquanlymuontra extends JFrame {

	public static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panelquanlymuontra frame = new Panelquanlymuontra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static JPanel panel;
	public static JPanel pnquanlymuontra;

	/**
	 * Create the frame.
	 */
	public Panelquanlymuontra() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1105, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnquanlymuontra = new JPanel();
		pnquanlymuontra.setBounds(0, 0, 1105, 735);
		pnquanlymuontra.setLayout(null);
		
		contentPane.add(pnquanlymuontra);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00FD M\u01B0\u1EE3n Tr\u1EA3", TitledBorder.LEADING, TitledBorder.BELOW_BOTTOM, null, Color.RED));
		panel.setBounds(0, 0, 1105, 104);
		pnquanlymuontra.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Danh S\u00E1ch M\u01B0\u1EE3n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\asus\\eclipse-workspace\\QuanLyThuVien_3Layer\\img\\reader-1713700-1453871.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(12, 0, 221, 80);
		panel.add(btnNewButton);
		
	}
}
