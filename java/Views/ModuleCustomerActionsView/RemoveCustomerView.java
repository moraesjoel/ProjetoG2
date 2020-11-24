package Views.ModuleCustomerActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import application.mainMenu;
import manager.CustomerManager;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RemoveCustomerView {

	private JFrame frame;
	public static JTextField textFieldCpfToRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveCustomerView window = new RemoveCustomerView();
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
	public RemoveCustomerView() {
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
		
		JLabel lblTitle = new JLabel("REMOVE CUSTOMER");
		lblTitle.setBounds(0, 0, 434, 42);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		frame.getContentPane().add(lblTitle);
		
		JLabel lblCpfToRemove = new JLabel("Customer CPF:");
		lblCpfToRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpfToRemove.setBounds(10, 109, 125, 14);
		frame.getContentPane().add(lblCpfToRemove);
		
		textFieldCpfToRemove = new JTextField();
		textFieldCpfToRemove.setBounds(126, 108, 251, 20);
		frame.getContentPane().add(textFieldCpfToRemove);
		textFieldCpfToRemove.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(114, 212, 89, 23);
		frame.getContentPane().add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.remove();
				mainMenu.main(null);
				frame.dispose();
			}
		});
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(223, 212, 89, 23);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mainMenu.main(null);
				frame.dispose();
			}
		});
	}
}
