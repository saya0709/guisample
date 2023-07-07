package gui.class303.gui.button.gui02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SampleWindow extends JFrame implements ActionListener {
	public SampleWindow(String title){
		super( title ) ;
		JButton btn = new JButton( "Click");
		btn.setName("Button 1");
		btn.setActionCommand("I got a click!");
		btn.addActionListener(this);
		Container contPane = this.getContentPane() ;
		contPane. add(btn);
		pack();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		System.out.printf("Text:%s  Name:%s Command:%s\n", btn.getText(), btn.getName(), e.getActionCommand());


	}

}
