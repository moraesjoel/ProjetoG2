package Views.ModuleScheduleActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.SwingConstants;

import Views.ModuleServiceScheduleView;
import manager.CustomerServiceManager;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RemoveServiceScheduleView {

	private JFrame frame;
	public static JTextField textFieldDate;
	public static JTextField textFieldHour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveServiceScheduleView window = new RemoveServiceScheduleView();
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
	public RemoveServiceScheduleView() {
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
		
		JLabel lblNewLabel = new JLabel("REMOVE");
		lblNewLabel.setBounds(0, 0, 434, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DATE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 99, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(97, 98, 246, 20);
		frame.getContentPane().add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("HOUR:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(41, 158, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textFieldHour = new JTextField();
		textFieldHour.setColumns(10);
		textFieldHour.setBounds(97, 157, 246, 20);
		frame.getContentPane().add(textFieldHour);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(127, 227, 89, 23);
		frame.getContentPane().add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					CustomerServiceManager.remove();
					ModuleServiceScheduleView.main(null);	
				} catch (ParseException e1) {
					e1.printStackTrace();
				}				
				
			}
		});
		
		JButton btnMenu = new JButton("menu");
		btnMenu.setBounds(226, 227, 89, 23);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModuleServiceScheduleView.main(null);				
				
			}
		});
	}

}
