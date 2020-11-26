package Views.ModuleEmployeeActionsView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import application.mainMenu;
import manager.EmployeeManager;
import manager.ServiceManager;
import javax.swing.JTable;

public class ConsultEmployeeView extends JFrame {

	private JPanel contentPane;
	public static JLabel labelTextConsult;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultEmployeeView frame = new ConsultEmployeeView();
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
	public ConsultEmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULT");
		lblNewLabel.setBounds(5, 5, 424, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);
		
//		labelTextConsult = new JLabel();
//		labelTextConsult.setBounds(20, 61, 409, 141);
//		contentPane.add(labelTextConsult);
		
//		JButton btnNewButton = new JButton("Consult employees");
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNewButton.setBounds(101, 221, 153, 32);
//		contentPane.add(btnNewButton);
//		btnNewButton.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				EmployeeManager.consult();
//			}
//		});
		
		JButton btnNewButtonMenu = new JButton("Menu");
		btnNewButtonMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButtonMenu.setBounds(158, 218, 99, 32);
		contentPane.add(btnNewButtonMenu);
		btnNewButtonMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				mainMenu.main(null);
			}
		});
		
		table = EmployeeManager.consultIntoTable();
		table.setBounds(71, 48, 325, 154);
		contentPane.add(table);
		
	}
}
