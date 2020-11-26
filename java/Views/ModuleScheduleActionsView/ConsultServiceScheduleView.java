package Views.ModuleScheduleActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Views.ModuleServiceScheduleView;
import manager.CustomerServiceManager;

import javax.swing.JButton;
import javax.swing.JTable;

public class ConsultServiceScheduleView {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultServiceScheduleView window = new ConsultServiceScheduleView();
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
	public ConsultServiceScheduleView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 646, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULT");
		lblNewLabel.setBounds(0, 0, 434, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		frame.getContentPane().add(lblNewLabel);
		
		table = CustomerServiceManager.consultAndInputInTable();
		table.setBounds(26, 64, 594, 190);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBounds(172, 265, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModuleServiceScheduleView.main(null);				
				
			}
		});
	}
}
