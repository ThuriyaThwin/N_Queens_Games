import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plateau {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plateau window = new Plateau();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Plateau() {
		frame = new JFrame();
		frame.setBounds(290, 90, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize(frame);
		ChargePlateau(frame);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 8));
		for(int i=0;i<8;i++)
		panel.add(new JLabel(Integer.toString(i), SwingConstants.CENTER));
		

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(8, 1));
		for (int j = 0; j < 8; j++)
			panel_1.add(new JLabel("  " + Integer.toString(j) + "  ",
					SwingConstants.CENTER));

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);

	}

	public void ChargePlateau(JFrame frame) {
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.DARK_GRAY));
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				Trone t = new Trone(i, j);
				Case c = new Case(t);
				c.addMouseListener(new ListenerCase(c));
				panel_4.add(c);
			}
	}

	

}
