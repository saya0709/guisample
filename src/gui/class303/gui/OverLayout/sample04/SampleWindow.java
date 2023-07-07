package gui.class303.gui.OverLayout.sample04;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import gui.class303.gui.OverLayout.sample02.ImageJPanel;

public class SampleWindow extends JFrame {


	SampleWindow(String title){
		setTitle(title);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//=======背景画像パネル生成========
		ImageJPanel panel = new ImageJPanel( "C:\\Users\\3030855\\Desktop\\apple.jpg" );
		panel.setLayout( new BorderLayout() ) ;
		
		
		//=======ラベル(上乗せ画像)生成========
		Dimension dim = new Dimension( 200, 150) ;
		JLabel label1 = new JLabel(new ImageIcon("C:\\Users\\3030855\\Desktop\\mikan.jpg"));
		label1.setPreferredSize(dim) ;
		
		//=======ラベル(上乗せテキスト)生成========
		JLabel label2 = new JLabel(" Hello World ! ");
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		//=======パネル生成========
		JPanel pnl1 = new JPanel() ;
		JPanel pnl2 = new JPanel() ;
		pnl1.setLayout( new BorderLayout() ) ;
		pnl2.setLayout( new BorderLayout() ) ;
		//pnl1にラベル(上乗せ画像)を透明にし、追加
		pnl1.add(label1);
		pnl1.setOpaque(false);
		//pnl1にラベル(上乗せテキスト)を透明にし、追加
		pnl2.add(label2);
		pnl2.setOpaque(false);
		
		
		//背景画像パネルに
		panel.setLayout( new OverlayLayout( panel));
		panel.add(pnl2) ;
		panel.add(pnl1) ;

		panel.setPreferredSize( dim  ) ;
		add(panel, BorderLayout.CENTER);
		pack();
	}
}

