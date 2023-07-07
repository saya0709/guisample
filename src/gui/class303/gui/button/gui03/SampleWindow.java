
/*ボタンのテキストの切り替え*/

package gui.class303.gui.button.gui03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SampleWindow extends JFrame implements ActionListener  {
	public SampleWindow(String title){
		super( title ) ;
		JButton btn = new JButton( "Click Me!");
		btn.addActionListener(this);
		Container contPane = this.getContentPane() ;
		contPane. add(btn);
		pack();

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final String txt1 = "Click Me!";
		final String txt2 = "No Click!";
		
		JButton btn = (JButton)e.getSource();
		if(btn.getText().equals(txt2)) {
			btn.setText(txt1);
		} else {
			btn.setText(txt2);
		}
		
	}

}
