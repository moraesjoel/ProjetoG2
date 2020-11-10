package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class calc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc frame = new calc();
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
	public calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 350, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButtonEight = new JButton("8");
		btnNewButtonEight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEight.setBounds(95, 52, 75, 53);
		contentPane.add(btnNewButtonEight);
		
		JButton btnNewButtonSeven = new JButton("7");
		btnNewButtonSeven.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonSeven.setBounds(10, 52, 75, 53);
		contentPane.add(btnNewButtonSeven);
		
		JButton btnNewButtonOne = new JButton("1");
		btnNewButtonOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonOne.setBounds(10, 178, 75, 53);
		contentPane.add(btnNewButtonOne);
		
		JButton btnNewButtonFive = new JButton("5");
		btnNewButtonFive.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonFive.setBounds(95, 115, 75, 53);
		contentPane.add(btnNewButtonFive);
		
		JButton btnNewButtonFour = new JButton("4");
		btnNewButtonFour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonFour.setBounds(10, 115, 75, 53);
		contentPane.add(btnNewButtonFour);
		
		JButton btnNewButtonTwo = new JButton("2");
		btnNewButtonTwo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonTwo.setBounds(95, 178, 75, 53);
		contentPane.add(btnNewButtonTwo);
		
		JLabel lblNewLabelResult = new JLabel("N\u00FAmero inserido");
		lblNewLabelResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabelResult.setBounds(20, 10, 302, 32);
		contentPane.add(lblNewLabelResult);
		
		JButton btnNewButtonZero = new JButton("0");
		btnNewButtonZero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonZero.setBounds(95, 241, 75, 53);
		contentPane.add(btnNewButtonZero);
		
		JButton btnNewButtonClear = new JButton("CLEAR");
		btnNewButtonClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonClear.setBounds(14, 304, 241, 53);
		contentPane.add(btnNewButtonClear);
		
		JButton btnNewButtonSix = new JButton("6");
		btnNewButtonSix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonSix.setBounds(180, 115, 75, 53);
		contentPane.add(btnNewButtonSix);
		
		JButton btnNewButtonNine = new JButton("9");
		btnNewButtonNine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonNine.setBounds(180, 52, 75, 53);
		contentPane.add(btnNewButtonNine);
		
		JButton btnNewButtonThree = new JButton("3");
		btnNewButtonThree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonThree.setBounds(180, 178, 75, 53);
		contentPane.add(btnNewButtonThree);
		
		JButton btnNewButtonPlus = new JButton("+");
		btnNewButtonPlus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonPlus.setBounds(265, 52, 60, 53);
		contentPane.add(btnNewButtonPlus);
		
		JButton btnNewButtonSubtract = new JButton("-");
		btnNewButtonSubtract.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButtonSubtract.setBounds(265, 115, 60, 53);
		contentPane.add(btnNewButtonSubtract);
		
		JButton btnNewButtonMultiply= new JButton("*");
		btnNewButtonMultiply.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonMultiply.setBounds(265, 179, 60, 53);
		contentPane.add(btnNewButtonMultiply);
		
		JButton btnNewButtonDivide = new JButton("/");
		btnNewButtonDivide.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonDivide.setBounds(265, 242, 60, 53);
		contentPane.add(btnNewButtonDivide);
		
		JButton btnNewButtonEqual= new JButton("=");
		btnNewButtonEqual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEqual.setBounds(265, 305, 60, 53);
		contentPane.add(btnNewButtonEqual);
		
	
	}
}
