package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Views.ModuleCustomerActionsView.ActivesCustomerView;
import Views.ModuleCustomerActionsView.ConsultCustomerView;
import Views.ModuleCustomerActionsView.EditCustomerView;
import Views.ModuleCustomerActionsView.InactivesCustomerView;
import Views.ModuleCustomerActionsView.InsertCustomerView;
import Views.ModuleCustomerActionsView.RelatedCpfView;
import Views.ModuleCustomerActionsView.RemoveCustomerView;

import application.mainMenu;

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
				InsertCustomerView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnActives = new JButton("ACTIVES");
		btnActives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActives.setBounds(230, 66, 153, 27);
		frame.getContentPane().add(btnActives);
		btnActives.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ActivesCustomerView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnConsult = new JButton("CONSULT");
		btnConsult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsult.setBounds(32, 121, 153, 27);
		frame.getContentPane().add(btnConsult);
		btnConsult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acessando modulo Employee.");
				ConsultCustomerView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnInactives = new JButton("INACTIVES");
		btnInactives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInactives.setBounds(230, 121, 153, 27);
		frame.getContentPane().add(btnInactives);
		btnInactives.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				InactivesCustomerView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(32, 174, 153, 27);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EditCustomerView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnRelated = new JButton("RELATED");
		btnRelated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRelated.setBounds(230, 174, 153, 27);
		frame.getContentPane().add(btnRelated);
		btnRelated.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RelatedCpfView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(32, 223, 153, 27);
		frame.getContentPane().add(btnRemove);

		btnRemove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RemoveCustomerView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMenu.setBounds(230, 223, 153, 27);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mainMenu.main(null);
				frame.dispose();
			}
		});
	}
}
