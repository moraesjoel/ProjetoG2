package Views.ModuleCustomerActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Views.ModuleCustomerView;
import manager.CustomerManager;

import javax.swing.JTable;
import javax.swing.JButton;

public class ActivesCustomerView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivesCustomerView window = new ActivesCustomerView();
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
	public ActivesCustomerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1310, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("COSTUMERS ACTIVES");
		lblTitle.setBounds(0, 0, 1284, 27);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(lblTitle);
		
		table = CustomerManager.consultActiveTable();
		table.setBounds(44, 50, 1200, 195);
		frame.getContentPane().add(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(596, 276, 89, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ModuleCustomerView.main(null);
				frame.dispose();
			}
		});
	}
}
