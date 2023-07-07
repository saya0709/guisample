package gui.class302.English.sample01;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HeadFrame extends JPanel implements ActionListener{
	JPanel panel;
	CardLayout layout;
	
	public HeadFrame(JPanel panel, CardLayout layout) {
		this.panel = panel;
		this.layout = layout;
		
		
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(this);
		JButton btn2 = new JButton("2");
		btn2.addActionListener(this);
		JButton btn3 = new JButton("一覧表示");
		btn3.addActionListener(this);
		JButton btn4 = new JButton("4");
		btn4.addActionListener(this);
		JButton btn5 = new JButton("5");
		btn5.addActionListener(this);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		switch(btn.getText()) {
		case "一覧表示":
			System.out.println("aaa");
			panel.add(new ListTable(), "list");
			layout.show(panel, "list");
			System.out.println("bbb");
			break;
		}
		
	}

}
