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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Views.ModuleServiceActionsView.RemoveView;
import application.mainMenu;
import manager.EmployeeManager;

public class RemoveEmployeeView extends JFrame {

	private JFrame frame;
	public static JTextField textFieldEmployeeCpfToRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployeeView window = new RemoveEmployeeView();
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
	public RemoveEmployeeView() {
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
		lblNewLabel.setBounds(0, 23, 434, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee CPF to remove");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 113, 195, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldEmployeeCpfToRemove = new JTextField();
		textFieldEmployeeCpfToRemove.setBounds(200, 112, 224, 20);
		frame.getContentPane().add(textFieldEmployeeCpfToRemove);
		textFieldEmployeeCpfToRemove.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove employee");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(145, 218, 151, 32);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("REMOVE ACIONADO.");
				EmployeeManager.remove();
				frame.dispose();
				mainMenu.main(null);
			}
		});
	}

}
