package gui.bookkeeping.sample05;

import javax.swing.JFrame;

import gui.class303.gui.OverLayout.sample02.ImageJPanel;


public class SampleWindow extends JFrame{
	
	
	SampleWindow(String title){
		setTitle(title);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		ImageJPanel panel = new ImageJPanel("C:\\Users\\3030855\\Desktop\\aaaaaaaaaaaaaaaaaaaaaaaaa.jpg");
		add(panel);
		
		
	}

}
