package gui.class303.gui.label.sample04;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SampleWindow extends JFrame {
	SampleWindow( String title ){
		super( title ) ;
		setSize( 500, 500 ) ;
		Container cntr = this.getContentPane();
		JLabel txtImgLbl = new JLabel("Hell", 
				new ImageIcon( "C:\\Users\\3030855\\Desktop\\apple.jpg"),
				JLabel.LEFT ) ;
		//画像とテキストの間隔差を表す
		txtImgLbl.setIconTextGap(400);
//		txtImgLbl.setIconTextGap(400);
		
		//.setTextIconGap( 40 ) ;
		cntr.add( txtImgLbl) ;
		// pack();
	}

}
