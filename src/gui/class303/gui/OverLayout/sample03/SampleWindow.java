package gui.class303.gui.OverLayout.sample03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.class303.gui.OverLayout.sample02.ImageJPanel;


public class SampleWindow  extends JFrame {

	SampleWindow(String title){
		setTitle(title);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//=======背景画像パネル生成========
		ImageJPanel panel = new ImageJPanel( "C:\\Users\\3030855\\Desktop\\apple.jpg" );
		panel.setLayout( new FlowLayout() )  ;
		
		//=======ラベル生成========
		JLabel label = new JLabel("Image Jpanel");
		label.setHorizontalAlignment(JLabel.CENTER);
		
		//=======ボタン生成========
		JButton button = new JButton("Click Here!");
		button.setHorizontalAlignment(JButton.CENTER);
		button.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Mouse Clicked");
			}
		}) ;
		
		//背景画像パネルにラベルとボタンを追加
		panel.add( label) ;
		panel.add( button) ;
		
		//Frameに背景画像パネルを追加
		add(panel);
	}
}



