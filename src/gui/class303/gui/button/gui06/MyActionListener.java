package gui.class303.gui.button.gui06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class MyActionListener implements ActionListener{
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
			btn1.setBorder(new BevelBorder(BevelBorder.RAISED));
			btn2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		} else {
			btn1.setBorder(new BevelBorder(BevelBorder.LOWERED));
			btn2.setBorder(new BevelBorder(BevelBorder.RAISED));
		}
	}

}
