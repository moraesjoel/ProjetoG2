package Views.ModuleCustomerActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.SwingConstants;

import manager.CustomerManager;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EditCustomerView {

	private JFrame frame;
	public static JTextField textFieldCpfToEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCustomerView window = new EditCustomerView();
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
	public EditCustomerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditTitle = new JLabel("EDIT CUSTOMER");
		lblEditTitle.setBounds(0, 0, 437, 27);
		lblEditTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(lblEditTitle);
		
		JLabel lblNewLabel = new JLabel("Customer CPF to edit:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 116, 138, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldCpfToEdit = new JTextField();
		textFieldCpfToEdit.setBounds(178, 115, 219, 20);
		frame.getContentPane().add(textFieldCpfToEdit);
		textFieldCpfToEdit.setColumns(10);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(163, 206, 89, 23);
		frame.getContentPane().add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EditCustomerMenuView.main(null);
				frame.dispose();
			}
		});
	}
}
