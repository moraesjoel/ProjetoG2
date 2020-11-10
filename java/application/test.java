package application;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class test {

	public static void main(String[] args) {
		
		
		new TelaClientes();
		
		System.out.println("Teste");
//		JOptionPane.showMessageDialog(null, "Olá, turma! Nosso primeiro programa Swing!");
//		String x = JOptionPane.showInputDialog("Digite o valor de x: ");
//		System.out.println(x);
		
		JFrame janela = new JFrame();
		janela.setSize(600, 400);
		janela.setLocation(500, 250);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// Criar o gerenciador de layout responsável por organizar os componentes
		FlowLayout layout = new FlowLayout();
		janela.setLayout(layout);
		
		
		JButton btSalvar = new JButton();
		btSalvar.setText("Salvar");

		JTextField caixaTextoNomeCliente = new JTextField();
		caixaTextoNomeCliente.setColumns(20);
		
		

		JComboBox selecaoAtivoInativo = new JComboBox();
		selecaoAtivoInativo.addItem("Ativo");
		selecaoAtivoInativo.addItem("Inativo");
		

		janela.add(caixaTextoNomeCliente);
		janela.add(selecaoAtivoInativo);
		janela.add(btSalvar);
		
		System.out.println(selecaoAtivoInativo.getSelectedItem());
		
	}

}