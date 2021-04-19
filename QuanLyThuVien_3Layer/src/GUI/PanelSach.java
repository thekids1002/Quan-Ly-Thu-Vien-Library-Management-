package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSach extends JFrame {

	private JPanel contentPane;
	public static JPanel PanelSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSach frame = new PanelSach();
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
	public PanelSach() {
		setUndecorated(true);
		////setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setPanelSach(new JPanel());
		getPanelSach().setBounds(0, 0, 1105, 672);
		getPanelSach().setBackground(Color.PINK);
		contentPane.add(getPanelSach());
		getPanelSach().setLayout(null);
	}

	public JPanel getPanelSach() {
		return PanelSach;
	}

	public void setPanelSach(JPanel panelSach) {
		PanelSach = panelSach;
	}

}
