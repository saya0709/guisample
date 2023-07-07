package gui.class302.English.sample01;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	Container contPane ;
	JPanel cardPanel;
	CardLayout layout;
	
	public MainFrame(String title){
		super( title) ;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ウィンドウの大きさ
		setSize(600, 400);
		//ウィンドウの初期位置
		setLocationRelativeTo(null);
		//		setResizable(false);
		
		
		cardPanel = new JPanel();
		layout = new CardLayout();
		cardPanel.setLayout(layout);
		
		TopPanel top = new TopPanel();
		ListTable list = new ListTable();
		
		cardPanel.add(top, "top");
		cardPanel.add(list, "list");
		
		layout.show(cardPanel, "top");
		HeadFrame head = new HeadFrame(cardPanel, layout);
		head.setPreferredSize(new Dimension(500,50));
		
		ShowFrame show = new ShowFrame(cardPanel, layout);
		show.setPreferredSize(new Dimension(500, 200));
		
		
		contPane = this.getContentPane();
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane.add(head);
//		contPane.add(show);
		contPane.add(cardPanel);
		
		
	
		//		pack();
		
	
	}

}
