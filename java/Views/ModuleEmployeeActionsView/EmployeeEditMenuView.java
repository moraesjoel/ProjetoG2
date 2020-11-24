package Views.ModuleEmployeeActionsView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import application.mainMenu;
import manager.EmployeeManager;

public class EmployeeEditMenuView extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldEmployeeName;
	public static JTextField textFieldEmployeeCpf;
	public static JTextField textFieldEmployeeEmail;
	public static JTextField textFieldEmployeePhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeEditMenuView frame = new EmployeeEditMenuView();
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
	public EmployeeEditMenuView() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 69, 80, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnEditName = new JButton("Edit name");
		btnEditName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditName.setBounds(241, 73, 99, 23);
		contentPane.add(btnEditName);
		
		btnEditName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit name.");
				try {
					EmployeeManager.editOnlyName();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		textFieldEmployeeName = new JTextField();
		textFieldEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeeName.setBounds(79, 72, 154, 27);
		contentPane.add(textFieldEmployeeName);
		textFieldEmployeeName.setColumns(10);
		textFieldEmployeeName.getText();
		
		
		JLabel lblHour = new JLabel("CPF:");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHour.setBounds(0, 120, 80, 29);
		contentPane.add(lblHour);
		
		JButton btnEditCpf = new JButton("Edit CPF");
		btnEditCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditCpf.setBounds(241, 124, 99, 23);
		contentPane.add(btnEditCpf);
		
		btnEditCpf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit CPF.");
				try {
					EmployeeManager.editOnlyCpf();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		textFieldEmployeeCpf = new JTextField();
		textFieldEmployeeCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeeCpf.setColumns(10);
		textFieldEmployeeCpf.setBounds(79, 123, 154, 27);
		contentPane.add(textFieldEmployeeCpf);
		
		textFieldEmployeeEmail = new JTextField();
		textFieldEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeeEmail.setColumns(10);
		textFieldEmployeeEmail.setBounds(79, 181, 241, 27);
		contentPane.add(textFieldEmployeeEmail);
		
		JLabel lblDescription = new JLabel("Email:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescription.setBounds(0, 178, 80, 29);
		contentPane.add(lblDescription);
		
		JButton btnEditEmail = new JButton("Edit Email");
		btnEditEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditEmail.setBounds(327, 182, 99, 23);
		contentPane.add(btnEditEmail);
		
		btnEditEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit CPF.");
				try {
					EmployeeManager.editOnlyEmail();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JLabel lblStatus = new JLabel("Phone Number:");
		lblStatus.setBackground(new Color(240, 240, 240));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(0, 233, 116, 29);
		contentPane.add(lblStatus);
		
		JButton btnEditPhone = new JButton("Edit Phone");
		btnEditPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditPhone.setBounds(313, 236, 113, 23);
		contentPane.add(btnEditPhone);
		
		btnEditPhone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit CPF.");
				try {
					EmployeeManager.editOnlyPhoneNumber();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		textFieldEmployeePhone = new JTextField();
		textFieldEmployeePhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeePhone.setColumns(10);
		textFieldEmployeePhone.setBounds(112, 235, 187, 27);
		contentPane.add(textFieldEmployeePhone);
		
		JLabel lblNewLabel_1 = new JLabel("EDIT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(175, 10, 116, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAddEmployee = new JButton("Edit all the employee's info");
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddEmployee.setBounds(79, 289, 211, 23);
		contentPane.add(btnAddEmployee);
		
		JButton btnNewButtonMenu = new JButton("Menu");
		btnNewButtonMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonMenu.setBounds(322, 292, 85, 21);
		contentPane.add(btnNewButtonMenu);
		btnNewButtonMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Back to menu.");
				dispose();
				mainMenu.main(null);	
			}
		});
		
		btnAddEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit the employee selected.");
				try {
					EmployeeManager.edit();
					dispose();
					mainMenu.main(null);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
