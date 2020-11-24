package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Views.ModuleCustomerView;
import Views.ModuleEmployeeView;
import Views.ModuleServiceView;
import Views.ScheduleServiceView;
import entities.Address;
import entities.Customer;
import entities.Employee;
import entities.Service;
import enums.Status;
import manager.CustomerServiceManager;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.SwingConstants;

public class mainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 465, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Schedule Service");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(21, 10, 194, 75);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("O botão foi clicado e o conteúdo digitado pelo usuário.");
				ScheduleServiceView.main(null);
			}
		});
		
		JButton btnShowScheduleFor = new JButton("Show Schedule for date");
		btnShowScheduleFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowScheduleFor.setBounds(234, 10, 194, 75);
		contentPane.add(btnShowScheduleFor);
		
		JButton btnNewButton_2_1 = new JButton("Module Employee");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(21, 108, 194, 75);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acessando modulo Employee.");
				dispose();
				ModuleEmployeeView.main(null);
			}
		});
		
		JButton btnNewButton_2_2 = new JButton("Module Customer");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_2.setBounds(234, 108, 194, 75);
		contentPane.add(btnNewButton_2_2);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acessando modulo Customer.");
				dispose();
				ModuleCustomerView.main(null);
			}
		});
		
		JButton btnNewButton_2_1_1 = new JButton("Module Service");
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_1.setBounds(21, 206, 194, 75);
		contentPane.add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("O botão foi clicado e o conteúdo digitado pelo usuário.");
				//setVisible(false);
				dispose();
				ModuleServiceView.main(null);				
				
			}
		});
		
		JButton btnNewButton_2_1_2 = new JButton("Module Service Schedule ");
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_1_2.setBounds(234, 206, 194, 75);
		contentPane.add(btnNewButton_2_1_2);
	}
}
