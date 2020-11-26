package Views.ModuleScheduleActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import manager.CustomerServiceManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EditScheduleView {

	private JFrame frame;
	public static JTextField textFieldDate;
	public static JTextField textFieldHour;
	public static JTextField textFieldDescription;
	public static JTextField textFieldCustomerCpf;
	public static JTextField textFieldEmployeeCpf;
	public static JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditScheduleView window = new EditScheduleView();
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
	public EditScheduleView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDIT SCHEDULE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDate = new JLabel("DATE:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(26, 80, 46, 14);
		frame.getContentPane().add(lblDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(83, 79, 275, 20);
		frame.getContentPane().add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblHour = new JLabel("HOUR:");
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHour.setBounds(26, 125, 46, 14);
		frame.getContentPane().add(lblHour);
		
		JLabel lblDescrition = new JLabel("DESCRITION:");
		lblDescrition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrition.setBounds(26, 157, 90, 14);
		frame.getContentPane().add(lblDescrition);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(26, 198, 61, 14);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblCustomerCpf = new JLabel("CUSTOMER CPF:");
		lblCustomerCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerCpf.setBounds(26, 223, 112, 14);
		frame.getContentPane().add(lblCustomerCpf);
		
		JLabel lblEmployeeCpf = new JLabel("EMPLOYEE CPF:");
		lblEmployeeCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmployeeCpf.setBounds(26, 261, 106, 14);
		frame.getContentPane().add(lblEmployeeCpf);
		
		textFieldHour = new JTextField();
		textFieldHour.setColumns(10);
		textFieldHour.setBounds(83, 124, 275, 20);
		frame.getContentPane().add(textFieldHour);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(113, 156, 242, 20);
		frame.getContentPane().add(textFieldDescription);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SCHEDULED", "FINISHED", "CANCELED"}));
		comboBox.setBounds(83, 196, 106, 22);
		frame.getContentPane().add(comboBox);
		
		textFieldCustomerCpf = new JTextField();
		textFieldCustomerCpf.setColumns(10);
		textFieldCustomerCpf.setBounds(133, 222, 222, 20);
		frame.getContentPane().add(textFieldCustomerCpf);
		
		textFieldEmployeeCpf = new JTextField();
		textFieldEmployeeCpf.setColumns(10);
		textFieldEmployeeCpf.setBounds(133, 260, 222, 20);
		frame.getContentPane().add(textFieldEmployeeCpf);
		
		JButton btnEditAll = new JButton("EDIT ALL");
		btnEditAll.setBounds(133, 298, 89, 23);
		frame.getContentPane().add(btnEditAll);
		btnEditAll.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerServiceManager.edit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setBounds(243, 298, 89, 23);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		
		
	}
}
