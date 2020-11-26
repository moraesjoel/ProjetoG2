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

import javax.swing.JTextField;
import javax.swing.JButton;

public class RelatedCpfView {

	private JFrame frame;
	public static JTextField textFieldCustomerCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatedCpfView window = new RelatedCpfView();
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
	public RelatedCpfView() {
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
		
		JLabel lblNewLabel = new JLabel("RELATED SERVICES");
		lblNewLabel.setBounds(0, 0, 434, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 124, 106, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldCustomerCpf = new JTextField();
		textFieldCustomerCpf.setBounds(136, 123, 215, 20);
		frame.getContentPane().add(textFieldCustomerCpf);
		textFieldCustomerCpf.setColumns(10);
		
		JButton btnConsult = new JButton("CONSULT");
		btnConsult.setBounds(136, 227, 89, 23);
		frame.getContentPane().add(btnConsult);
		btnConsult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCustomerCpf.getText();
				RelatedServicesCustomerView.main(cpf);
				frame.dispose();
			}
		});
		
		JButton btnBack = new JButton("back");
		btnBack.setBounds(239, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ModuleCustomerView.main(null);
				frame.dispose();
			}
		});
	}

}
