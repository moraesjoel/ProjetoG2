package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manager.CustomerServiceManager;
import manager.ServiceManager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;

public class ScheduleServiceView extends JFrame {

	private JPanel contentPane;
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
					ScheduleServiceView frame = new ScheduleServiceView();
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
	public ScheduleServiceView() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 80, 29);
		contentPane.add(lblNewLabel);
		
		textFieldDate = new JTextField();
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDate.setBounds(79, 10, 105, 27);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		textFieldDate.getText();
		
		
		JLabel lblHour = new JLabel("Hour:");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHour.setBounds(0, 49, 80, 29);
		contentPane.add(lblHour);
		
		textFieldHour = new JTextField();
		textFieldHour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldHour.setColumns(10);
		textFieldHour.setBounds(79, 49, 105, 27);
		contentPane.add(textFieldHour);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(89, 91, 279, 27);
		contentPane.add(textFieldDescription);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(10, 89, 80, 29);
		contentPane.add(lblDescription);
		
		
		JLabel lblStatus = new JLabel("Status:\r\n");
		lblStatus.setBackground(new Color(240, 240, 240));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(0, 128, 80, 29);
		contentPane.add(lblStatus);
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SCHEDULED", "FINISHED", "CANCELED"}));
//		comboBox.setBounds(79, 134, 105, 23);
//		contentPane.add(comboBox);
		
		JLabel lblCustomerCpf = new JLabel("Customer CPF:\r\n");
		lblCustomerCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerCpf.setBackground(SystemColor.menu);
		lblCustomerCpf.setBounds(10, 167, 98, 29);
		contentPane.add(lblCustomerCpf);
		
		textFieldCustomerCpf = new JTextField();
		textFieldCustomerCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldCustomerCpf.setColumns(10);
		textFieldCustomerCpf.setBounds(108, 167, 248, 27);
		contentPane.add(textFieldCustomerCpf);
		
		JLabel lblEmployeeCpf = new JLabel("Employee CPF:\r\n");
		lblEmployeeCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeCpf.setBackground(SystemColor.menu);
		lblEmployeeCpf.setBounds(3, 206, 105, 29);
		contentPane.add(lblEmployeeCpf);
		
		textFieldEmployeeCpf = new JTextField();
		textFieldEmployeeCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmployeeCpf.setColumns(10);
		textFieldEmployeeCpf.setBounds(108, 208, 248, 27);
		contentPane.add(textFieldEmployeeCpf);
		
		JButton btnNewButton = new JButton("Add service.");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(145, 259, 150, 56);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Schedule adicionado");
				//CustomerServiceManager.insert();
				ServiceManager.insert();
			}
		});
	}
}
