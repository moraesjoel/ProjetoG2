package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Views.ModuleServiceActionsView.ConsultView;
import Views.ModuleServiceActionsView.EditView;
import Views.ModuleServiceActionsView.InsertView;
import Views.ModuleServiceActionsView.RemoveView;
import application.mainMenu;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ModuleServiceView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleServiceView frame = new ModuleServiceView();
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
	public ModuleServiceView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICE MODULE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(34, 69, 168, 51);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("INSERT ACIONADO.");
				dispose();
				InsertView.main(null);
	
			}
		});
		
		JButton btnConsult = new JButton("CONSULT");
		btnConsult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsult.setBounds(228, 69, 168, 51);
		contentPane.add(btnConsult);
		btnConsult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("CONSULT ACIONADO.");
				ConsultView.main(null);
			}
		});
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(34, 147, 168, 51);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("EDIT ACIONADO.");
				EditView.main(null);
			}
		});
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(228, 147, 168, 51);
		contentPane.add(btnRemove);
		
		JButton btnNewButtonMenu = new JButton("Menu");
		btnNewButtonMenu.setBounds(168, 232, 85, 21);
		contentPane.add(btnNewButtonMenu);
		btnRemove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("REMOVE ACIONADO.");
				RemoveView.main(null);
			}
		});
		
		btnNewButtonMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mainMenu.main(null);
			}
		});
	}
}
