package gui.class303.gui.label.sample02;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleWindow extends JFrame {
	public SampleWindow(String title){
		super( title ) ;
		setSize( 200, 150 ) ;
		Container cntr = this.getContentPane();
		JLabel imgLbl = 
				new JLabel( new ImageIcon( "C:\\Users\\3030855\\Desktop\\apple.jpg") ) ;
		//"C:\Users\3030855\Desktop\apple.jpg"
		
		cntr.add( imgLbl) ;
		pack();
		


	}

}
