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

import Views.ModuleCustomerView;
import manager.CustomerManager;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class InsertCustomerView {

	private JFrame frame;
	public static JTextField textFieldName;
	public static JTextField textFieldCpf;
	public static JTextField textFieldPhoneNumber;
	public static JTextField textFieldBirthday;
	public static JTextField textFieldGender;
	public static JTextField textFieldEmail;
	public static JTextField textFieldMaritalStatus;
	public static JComboBox comboBox;
	private JTextField textFieldAddressStreet;
	private JTextField textFieldAddressNumber;
	private JTextField textFieldAddressCity;
	private JTextField textFieldAddressState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCustomerView window = new InsertCustomerView();
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
	public InsertCustomerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD CUSTOMER");
		lblNewLabel.setBounds(0, 0, 464, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(27, 52, 48, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(27, 77, 48, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(27, 113, 120, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblBirthday = new JLabel("BIRTHDAY:");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBirthday.setBounds(27, 138, 78, 14);
		frame.getContentPane().add(lblBirthday);
		
		JLabel lblGender = new JLabel("GENDER:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(27, 163, 63, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(27, 188, 48, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMaritalStatus = new JLabel("MARITAL STATUS:");
		lblMaritalStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaritalStatus.setBounds(27, 213, 130, 14);
		frame.getContentPane().add(lblMaritalStatus);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(27, 238, 78, 14);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(27, 263, 78, 14);
		frame.getContentPane().add(lblAddress);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(85, 51, 335, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(85, 76, 335, 20);
		frame.getContentPane().add(textFieldCpf);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(142, 112, 278, 20);
		frame.getContentPane().add(textFieldPhoneNumber);
		
		textFieldBirthday = new JTextField();
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(103, 138, 317, 20);
		frame.getContentPane().add(textFieldBirthday);
		
		textFieldGender = new JTextField();
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(103, 162, 317, 20);
		frame.getContentPane().add(textFieldGender);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(85, 187, 335, 20);
		frame.getContentPane().add(textFieldEmail);
		
		textFieldMaritalStatus = new JTextField();
		textFieldMaritalStatus.setColumns(10);
		textFieldMaritalStatus.setBounds(151, 212, 269, 20);
		frame.getContentPane().add(textFieldMaritalStatus);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ACTIVE", "INACTIVE"}));
		comboBox.setBounds(103, 238, 110, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Street:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(51, 288, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(51, 313, 54, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("City:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(51, 338, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("State:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(51, 363, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textFieldAddressStreet = new JTextField();
		textFieldAddressStreet.setColumns(10);
		textFieldAddressStreet.setBounds(103, 287, 269, 20);
		frame.getContentPane().add(textFieldAddressStreet);
		
		textFieldAddressNumber = new JTextField();
		textFieldAddressNumber.setColumns(10);
		textFieldAddressNumber.setBounds(113, 312, 259, 20);
		frame.getContentPane().add(textFieldAddressNumber);
		
		textFieldAddressCity = new JTextField();
		textFieldAddressCity.setColumns(10);
		textFieldAddressCity.setBounds(103, 338, 269, 20);
		frame.getContentPane().add(textFieldAddressCity);
		
		textFieldAddressState = new JTextField();
		textFieldAddressState.setColumns(10);
		textFieldAddressState.setBounds(103, 362, 269, 20);
		frame.getContentPane().add(textFieldAddressState);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddCustomer.setBounds(113, 401, 130, 23);
		frame.getContentPane().add(btnAddCustomer);
		btnAddCustomer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Inserindo...");
				try {
					CustomerManager.insert();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				ModuleCustomerView.main(null);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(253, 401, 130, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acessando modulo Employee.");
				ModuleCustomerView.main(null);
			}
		});
	}
}
