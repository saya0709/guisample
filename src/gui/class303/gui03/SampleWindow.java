package gui.class303.gui03;

import javax.swing.JFrame;

public class SampleWindow extends JFrame {
	SampleWindow(String title){
		super(title);
		this.setSize( 300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
