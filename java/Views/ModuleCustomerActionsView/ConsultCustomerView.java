package Views.ModuleCustomerActionsView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Views.ModuleCustomerView;
import application.mainMenu;

import manager.CustomerManager;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

public class ConsultCustomerView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultCustomerView window = new ConsultCustomerView();
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
	public ConsultCustomerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1310, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultCustomer = new JLabel("CONSULT CUSTOMER");
		lblConsultCustomer.setBounds(10, 0, 1274, 39);
		lblConsultCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblConsultCustomer);
		
		table = CustomerManager.consultAndInputInTable();
		table.setBounds(44, 50, 1200, 195);
		frame.getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		frame.getContentPane().add(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(604, 272, 89, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ModuleCustomerView.main(null);
				frame.dispose();
			}
		});
	}
}
