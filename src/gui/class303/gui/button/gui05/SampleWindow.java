package gui.class303.gui.button.gui05;

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
		btn1.setAlignmentX(CENTER_ALIGNMENT);
		btn2.setAlignmentX(CENTER_ALIGNMENT);
		
		/*
		  setAlignmentX(float alignmentX)
		     :コンテナ内でのボタンの配置を制御
		  setHorizontalAlignment(int alignment)
		     :ボタン内のコンテンツの配置を制御します
		*/
		Container contPane = this.getContentPane() ;
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane. add(btn1);
		contPane. add(btn2);
		pack();

	}
}
