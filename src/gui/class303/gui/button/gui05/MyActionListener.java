package gui.class303.gui.button.gui05;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {
	JButton btn1 = null;
	JButton btn2 = null;
	
	MyActionListener(JButton btn1, JButton btn2){
		this.btn1 = btn1;
		this.btn2 = btn2;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == btn1) {
			btn1.setBackground(Color.WHITE);
			btn2.setBackground(Color.GREEN);
		} else {
			btn1.setBackground(Color.BLUE);
			btn2.setBackground(Color.WHITE);
		}
	}

}
