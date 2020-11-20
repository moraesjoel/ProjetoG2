package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Views.ModuleCustomerActionsView.InsertCustomerView;
import manager.CustomerManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ModuleCustomerView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleCustomerView window = new ModuleCustomerView();
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
	public ModuleCustomerView() {
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
		
		JLabel lblNewLabel = new JLabel("MODULE CUSTOMER");
		lblNewLabel.setBounds(0, 0, 434, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(32, 66, 153, 27);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("INSERT ACIONADO.");
				InsertCustomerView.main(null);
	
			}
		});
		
		JButton btnActives = new JButton("ACTIVES");
		btnActives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActives.setBounds(230, 66, 153, 27);
		frame.getContentPane().add(btnActives);
		
		JButton btnConsult = new JButton("CONSULT");
		btnConsult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsult.setBounds(32, 121, 153, 27);
		frame.getContentPane().add(btnConsult);
		btnConsult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acessando modulo Employee.");
				CustomerManager.consult();
			}
		});
		
		JButton btnInactives = new JButton("INACTIVES");
		btnInactives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInactives.setBounds(230, 121, 153, 27);
		frame.getContentPane().add(btnInactives);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(32, 174, 153, 27);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRelated = new JButton("RELATED");
		btnRelated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRelated.setBounds(230, 174, 153, 27);
		frame.getContentPane().add(btnRelated);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(32, 223, 153, 27);
		frame.getContentPane().add(btnRemove);
	}
}
