package gui.class303.gui02;

import javax.swing.JFrame;

public class Main extends JFrame {
	Main(){
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		Main m = new Main();
		m.setTitle("Hello World");
		m.setVisible(true);
	}

}
