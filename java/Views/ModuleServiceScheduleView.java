package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Views.ModuleScheduleActionsView.ConsultServiceScheduleView;
import Views.ModuleScheduleActionsView.RemoveServiceScheduleView;
import Views.ModuleScheduleActionsView.ScheduleServiceDateHourView;
import Views.ModuleServiceActionsView.InsertView;
import application.mainMenu;
import manager.CustomerServiceManager;

import javax.swing.JButton;

public class ModuleServiceScheduleView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleServiceScheduleView window = new ModuleServiceScheduleView();
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
	public ModuleServiceScheduleView() {
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
		
		JLabel lblTitle = new JLabel("SCHEDULE MODULE");
		lblTitle.setBounds(0, 0, 434, 39);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		frame.getContentPane().add(lblTitle);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(69, 93, 111, 29);
		frame.getContentPane().add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ScheduleServiceView.main(null);
			}
		});
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(212, 93, 111, 29);
		frame.getContentPane().add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ScheduleServiceDateHourView.main(null);
				
			}
		});
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(69, 165, 111, 29);
		frame.getContentPane().add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RemoveServiceScheduleView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnConsult = new JButton("CONSULT");
		btnConsult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsult.setBounds(212, 165, 111, 29);
		frame.getContentPane().add(btnConsult);
		btnConsult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ConsultServiceScheduleView.main(null);
				frame.dispose();
			}
		});
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMenu.setBounds(137, 221, 111, 29);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mainMenu.main(null);
				frame.dispose();
			}
		});
	}
}
