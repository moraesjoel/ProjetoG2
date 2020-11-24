package Views.ModuleCustomerActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Views.ModuleServiceView;
import manager.CustomerManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ConsultCustomerView {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultCustomer = new JLabel("CONSULT CUSTOMER");
		lblConsultCustomer.setBounds(0, 0, 434, 39);
		lblConsultCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblConsultCustomer);
		
		JLabel lblConsultField = new JLabel("");
		lblConsultField.setBounds(29, 50, 379, 166);
		frame.getContentPane().add(lblConsultField);
		
		JButton btnConsult = new JButton("consult");
		btnConsult.setBounds(174, 227, 89, 23);
		frame.getContentPane().add(btnConsult);
		btnConsult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.consult();
			}
		});
	}
}
