package Views.ModuleEmployeeActionsView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.mainMenu;
import manager.EmployeeManager;
import manager.ServiceManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EditEmployeeView extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldEmployeeCpfEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmployeeView frame = new EditEmployeeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditEmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDIT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(0, 0, 434, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee CPF to Edit:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 84, 168, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEditEmployee = new JButton("Edit Employee");
		btnEditEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditEmployee.setBounds(145, 181, 147, 23);
		contentPane.add(btnEditEmployee);
		
		btnEditEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Edit employee.");
				EmployeeEditMenuView.main(null);
				dispose();
			}
		});
		
		textFieldEmployeeCpfEdit = new JTextField();
		textFieldEmployeeCpfEdit.setColumns(10);
		textFieldEmployeeCpfEdit.setBounds(165, 84, 236, 20);
		contentPane.add(textFieldEmployeeCpfEdit);
		
		JButton btnNewButtonMenu = new JButton("Menu");
		btnNewButtonMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButtonMenu.setBounds(316, 184, 85, 21);
		contentPane.add(btnNewButtonMenu);
		
		btnNewButtonMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				mainMenu.main(null);
			}
		});
	}

}
