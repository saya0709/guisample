package gui.class303.gui.button.gui06;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class SampleWindow extends JFrame {
	
	public SampleWindow(String title){
		super( title ) ;
		JButton btn1 = new JButton( "Click Me!");
		JButton btn2 = new JButton( "Yes, yes, yes,,,");
		MyActionListener mal = new MyActionListener(btn1, btn2);
		btn1.addActionListener(mal);
		btn2.addActionListener(mal);
		
		
//		{
//			Dimension dim = btn1.getPreferredSize();
//			dim.width = btn2.getPreferredSize().width;
//			btn1.setPreferredSize(dim);
//			btn1.setMaximumSize(dim);
//			btn2.setPreferredSize(dim);
//			btn2.setMaximumSize(dim);
//		}
		
		Container contPane = this.getContentPane() ;
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane. add(btn1);
		contPane. add(btn2);
		pack();

	
	}
}
