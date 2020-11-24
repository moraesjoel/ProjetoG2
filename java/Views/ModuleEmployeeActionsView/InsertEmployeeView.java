package Views.ModuleEmployeeActionsView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Views.ScheduleServiceView;
import application.mainMenu;
import manager.EmployeeManager;
import manager.ServiceManager;

import javax.swing.JButton;

public class InsertEmployeeView extends JFrame {

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
					InsertEmployeeView frame = new InsertEmployeeView();
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
	public InsertEmployeeView() {
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
		
		textFieldEmployeeCpf = new JTextField();
		textFieldEmployeeCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeeCpf.setColumns(10);
		textFieldEmployeeCpf.setBounds(79, 123, 154, 27);
		contentPane.add(textFieldEmployeeCpf);
		
		textFieldEmployeeEmail = new JTextField();
		textFieldEmployeeEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeeEmail.setColumns(10);
		textFieldEmployeeEmail.setBounds(79, 181, 279, 27);
		contentPane.add(textFieldEmployeeEmail);
		
		JLabel lblDescription = new JLabel("Email:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescription.setBounds(0, 178, 80, 29);
		contentPane.add(lblDescription);
		
		
		JLabel lblStatus = new JLabel("Phone Number:");
		lblStatus.setBackground(new Color(240, 240, 240));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(0, 233, 116, 29);
		contentPane.add(lblStatus);
		
		textFieldEmployeePhone = new JTextField();
		textFieldEmployeePhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeePhone.setColumns(10);
		textFieldEmployeePhone.setBounds(126, 235, 187, 27);
		contentPane.add(textFieldEmployeePhone);
		
		JLabel lblNewLabel_1 = new JLabel("INSERT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(175, 10, 116, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAddEmployee = new JButton("Add employee");
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddEmployee.setBounds(112, 288, 201, 23);
		contentPane.add(btnAddEmployee);
		
		JButton btnNewButtonMenu = new JButton("Menu");
		btnNewButtonMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButtonMenu.setBounds(323, 288, 85, 21);
		contentPane.add(btnNewButtonMenu);
		
		btnNewButtonMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				mainMenu.main(null);
			}
		});
		
		btnAddEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add new employee!.");
				try {
					EmployeeManager.insert();
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
