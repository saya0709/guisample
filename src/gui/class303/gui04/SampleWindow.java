package gui.class303.gui04;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleWindow extends JFrame {

	SampleWindow(String title){
		super(title);
		this.setSize( 300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contPane = this.getContentPane();
		//JLabel lbl = new JLabel("Hello");
		JLabel lbl = new JLabel("Hello", JLabel.CENTER);
		JLabel lbl2 = new JLabel("World", JLabel.CENTER);
		
		
		
		contPane.add(lbl, BorderLayout.CENTER);
		contPane.add(lbl2, BorderLayout.EAST);
		
		
		
		
		
	}


}
