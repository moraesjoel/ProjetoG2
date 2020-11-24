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

import application.mainMenu;
import manager.CustomerManager;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EditCustomerMenuView {

	private JFrame frame;
	public static JTextField textFieldName;
	public static JTextField textFieldCpf;
	public static JTextField textFieldPhoneNumber;
	public static JTextField textFieldBirthday;
	public static JTextField textFieldGender;
	public static JTextField textFieldEmail;
	public static JTextField textFieldMaritalStatus;
	public static JTextField textFieldAddressStreet;
	public static JTextField textFieldAddressNumber;
	public static JTextField textFieldAddressCity;
	public static JTextField textFieldAddressState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCustomerMenuView window = new EditCustomerMenuView();
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
	public EditCustomerMenuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("EDIT");
		lblTitle.setBounds(0, 0, 544, 49);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(lblTitle);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(30, 73, 46, 14);
		frame.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(79, 72, 347, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnEnterName = new JButton("Name");
		btnEnterName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterName.setBounds(445, 69, 140, 23);
		frame.getContentPane().add(btnEnterName);
		btnEnterName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditName();
			}
		});
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(30, 98, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(79, 98, 347, 20);
		frame.getContentPane().add(textFieldCpf);
		
		JButton btnEnterCpf = new JButton("CPF");
		btnEnterCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterCpf.setBounds(445, 96, 140, 23);
		frame.getContentPane().add(btnEnterCpf);
		btnEnterCpf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditCpf();
			}
		});
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(30, 123, 113, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(139, 122, 287, 20);
		frame.getContentPane().add(textFieldPhoneNumber);
		
		JButton btnEnterPhoneNumber = new JButton("Phone Number");
		btnEnterPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterPhoneNumber.setBounds(445, 123, 140, 23);
		frame.getContentPane().add(btnEnterPhoneNumber);
		btnEnterPhoneNumber.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditPhoneNumber();
			}
		});
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBirthday.setBounds(30, 148, 62, 14);
		frame.getContentPane().add(lblBirthday);
		
		textFieldBirthday = new JTextField();
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(102, 147, 324, 20);
		frame.getContentPane().add(textFieldBirthday);
		
		JButton btnEnterBirthday = new JButton("Birthday");
		btnEnterBirthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterBirthday.setBounds(445, 146, 140, 23);
		frame.getContentPane().add(btnEnterBirthday);
		btnEnterBirthday.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditPhoneBirthday();
			}
		});
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(30, 170, 62, 14);
		frame.getContentPane().add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(89, 169, 337, 20);
		frame.getContentPane().add(textFieldGender);
		
		JButton btnEnterGender = new JButton("Gender");
		btnEnterGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterGender.setBounds(445, 168, 140, 23);
		frame.getContentPane().add(btnEnterGender);
		btnEnterGender.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditPhoneNumber();
			}
		});
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(30, 195, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(79, 195, 347, 20);
		frame.getContentPane().add(textFieldEmail);
		
		JButton btnEnterEmail = new JButton("Email");
		btnEnterEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterEmail.setBounds(445, 193, 140, 23);
		frame.getContentPane().add(btnEnterEmail);
		btnEnterEmail.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditEmail();
			}
		});
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaritalStatus.setBounds(30, 220, 96, 14);
		frame.getContentPane().add(lblMaritalStatus);
		
		textFieldMaritalStatus = new JTextField();
		textFieldMaritalStatus.setColumns(10);
		textFieldMaritalStatus.setBounds(120, 219, 306, 20);
		frame.getContentPane().add(textFieldMaritalStatus);
		
		JButton btnEnterMaritalStatus = new JButton("Marital Status");
		btnEnterMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterMaritalStatus.setBounds(445, 218, 140, 23);
		frame.getContentPane().add(btnEnterMaritalStatus);
		btnEnterMaritalStatus.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditMaritalStatus();
			}
		});
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(30, 245, 46, 14);
		frame.getContentPane().add(lblStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ACTIVE", "INACTIVE"}));
		comboBox.setBounds(82, 245, 96, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnEnterComboBox = new JButton("Status");
		btnEnterComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterComboBox.setBounds(445, 243, 140, 23);
		frame.getContentPane().add(btnEnterComboBox);
		btnEnterComboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditStatus();
			}
		});
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(30, 270, 62, 14);
		frame.getContentPane().add(lblAddress);
		
		JButton btnEnterAddress = new JButton("Address");
		btnEnterAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterAddress.setBounds(445, 266, 140, 23);
		frame.getContentPane().add(btnEnterAddress);
		btnEnterAddress.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CustomerManager.readAndSetEditAddress();
			}
		});
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreet.setBounds(64, 295, 46, 14);
		frame.getContentPane().add(lblStreet);
		
		textFieldAddressStreet = new JTextField();
		textFieldAddressStreet.setColumns(10);
		textFieldAddressStreet.setBounds(120, 294, 306, 20);
		frame.getContentPane().add(textFieldAddressStreet);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumber.setBounds(64, 320, 62, 14);
		frame.getContentPane().add(lblNumber);
		
		textFieldAddressNumber = new JTextField();
		textFieldAddressNumber.setColumns(10);
		textFieldAddressNumber.setBounds(120, 319, 306, 20);
		frame.getContentPane().add(textFieldAddressNumber);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(64, 345, 62, 14);
		frame.getContentPane().add(lblCity);

		textFieldAddressCity = new JTextField();
		textFieldAddressCity.setColumns(10);
		textFieldAddressCity.setBounds(120, 345, 306, 20);
		frame.getContentPane().add(textFieldAddressCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblState.setBounds(64, 370, 62, 14);
		frame.getContentPane().add(lblState);
		
		textFieldAddressState = new JTextField();
		textFieldAddressState.setColumns(10);
		textFieldAddressState.setBounds(120, 369, 306, 20);
		frame.getContentPane().add(textFieldAddressState);

		
		JButton btnEnter = new JButton("enter all");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnter.setBounds(157, 409, 89, 23);
		frame.getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerManager.edit();
					frame.dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(285, 409, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mainMenu.main(null);
				frame.dispose();
			}
		});


	}
}
