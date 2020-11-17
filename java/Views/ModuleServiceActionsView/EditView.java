package Views.ModuleServiceActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import application.mainMenu;
import manager.ServiceManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EditView {

	private JFrame frame;
	public static JTextField textFieldServiceNameToEdit;
	public static JTextField textFieldNewServiceName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditView window = new EditView();
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
	public EditView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDIT");
		lblNewLabel.setBounds(0, 0, 434, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Service Name to Edit:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 90, 168, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldServiceNameToEdit = new JTextField();
		textFieldServiceNameToEdit.setBounds(170, 89, 236, 20);
		frame.getContentPane().add(textFieldServiceNameToEdit);
		textFieldServiceNameToEdit.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Service Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 132, 168, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textFieldNewServiceName = new JTextField();
		textFieldNewServiceName.setColumns(10);
		textFieldNewServiceName.setBounds(170, 131, 236, 20);
		frame.getContentPane().add(textFieldNewServiceName);
		
		JButton btnNewButton = new JButton("Edit Service");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(159, 205, 122, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit service!.");
				ServiceManager.edit();
				frame.dispose();
				mainMenu.main(null);
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}
