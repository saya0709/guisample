package gui.class303.gui.label.sample01;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleWindow extends JFrame {
	SampleWindow( String title ){
		super( title ) ;
		setSize( 200, 150 ) ;
		Container cntr = this.getContentPane();
		JLabel textLbl00 = new JLabel("-- Hello --") ;
		JLabel textLbl01 = new JLabel("-- Hello --", JLabel.RIGHT) ;
		cntr.add( textLbl00 , BorderLayout.NORTH ) ;
		cntr.add( textLbl01 , BorderLayout.SOUTH ) ;
		// pack();
	}




}
