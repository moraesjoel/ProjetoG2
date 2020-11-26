package Views.ModuleCustomerActionsView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Views.ModuleCustomerView;
import manager.CustomerManager;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RelatedServicesCustomerView {

	private JFrame frame;
	private JTable table;
	public static JLabel lblCustomerName;
	public static JTextField textFieldCustomerCpf;
	private JButton btnConsult;

	/**
	 * Launch the application.
	 */
	public static void main(String cpf) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatedServicesCustomerView window = new RelatedServicesCustomerView(cpf);
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
	public RelatedServicesCustomerView(String cpf) {
		initialize(cpf);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String cpf) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("RELATED SERVICES");
		lblTitle.setBounds(0, 0, 434, 32);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		frame.getContentPane().add(lblTitle);
		
		table = CustomerManager.consultServicesRelatedToCustomerTable(cpf);
		table.setBounds(91, 83, 259, 144);
		frame.getContentPane().add(table);
		
		JButton btnMenu = new JButton("menu");
		btnMenu.setBounds(165, 236, 89, 23);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ModuleCustomerView.main(null);
				frame.dispose();
			}
		});
	}

}
