package gui.class303.gui.button.gui04;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SampleWindow extends JFrame implements ActionListener{
	
	public SampleWindow(String title){
		super( title ) ;
		JButton btn1 = new JButton( "Click");
		btn1.addActionListener(this);
		JButton btn2 = new JButton( "Yes, yes, yes ----- !");
		btn2.addActionListener(this);
		
		
		Container contPane = this.getContentPane() ;
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane. add(btn1);
		contPane. add(btn2);
		pack();

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		System.out.printf("text:%s\n", btn.getText());
		
	}

}
