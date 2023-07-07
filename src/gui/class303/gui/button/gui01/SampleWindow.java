package gui.class303.gui.button.gui01;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SampleWindow extends JFrame implements ActionListener {
	public SampleWindow(String title) {
		super( title ) ;
		this.setSize( 300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton( "Click");
		btn.addActionListener(this);
		Container contPane = this.getContentPane() ;
		contPane. add(btn);
//	pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource() ;
		System.out.printf("Text:%s\n", btn.getText());
	}

}
