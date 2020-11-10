package application;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class TelaClientes extends JFrame {

	
	public TelaClientes() {
		this.setVisible(true);
		this.setSize(500, 400);
		
		JCheckBox caixa1 = new JCheckBox();
		this.add(caixa1);
	}
	
}