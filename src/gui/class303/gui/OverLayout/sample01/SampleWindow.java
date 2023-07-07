package gui.class303.gui.OverLayout.sample01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class SampleWindow extends JFrame {
	SampleWindow(String title){
		final int PANE_WIDTH = 300 ;

		setTitle(title);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//=========背景画像の設定処理============
		// 背景画像の取得 と 背景画像に合わせたウィンドウサイズの取得
		// (横幅は PANE_WIDTH)
		Image img ; 	// 表示画像
		Dimension dim ;	// 表示サイズ
		{
			ImageIcon icon = new ImageIcon("C:\\Users\\3030855\\Desktop\\apple.jpg") ;

			int	height = (int)(icon.getIconHeight() *
					((double)PANE_WIDTH / icon.getIconWidth() )) ;
			dim = new Dimension( PANE_WIDTH, height) ;
			Image simgOrg = icon.getImage();
			img = simgOrg.getScaledInstance(
					dim.width, dim.height, Image.SCALE_FAST) ;
		}

		JLabel lblBase = new JLabel( new ImageIcon(img)) ;
		//=========背景画像の設定処理ここまで============
		
		
		JLabel lblCat = new JLabel( new ImageIcon("C:\\Users\\3030855\\Desktop\\mikan.jpg")) ;
		JLabel lblMsg = new JLabel( " Hello! Good Mornnig: ")  ;
		JButton btnPush = new JButton("Push Me") ;

		JPanel	p1 = new JPanel() ;
		JPanel	p2 = new JPanel() ;
		JPanel	p3 = new JPanel() ;
		
		//p1にテキスト、ボタンをセット
		p1.setLayout(new BorderLayout()) ;
		p1.add(lblMsg, BorderLayout.WEST) ;
		p1.add(btnPush, BorderLayout.EAST) ;
		{
			Dimension dim1 = lblMsg.getPreferredSize() ;
			dim1.height *= 2 ;
			dim1.width += 10 + btnPush.getPreferredSize().width ;
			p1.setPreferredSize( dim1 ) ;
			p1.setMaximumSize( dim1 ) ;
			p1.setMinimumSize( dim1 ) ;
		}
		
		
		//p2に画像(みかん)をセット
		p2.setLayout(new BorderLayout()) ;
		p2.add(lblCat) ;
		
		//p3に画像(りんご)をセット
		p3.add( lblBase ) ;
		
		//p1,p2を透明に
		p1.setOpaque(false) ;
		p2.setOpaque(false) ;
		
		
		Container contPane = this.getContentPane() ;
		contPane.setLayout( new OverlayLayout(contPane)) ;

		add( p1 ) ;
		add( p2 ) ;
		add( lblCat ) ;
		add( p3 ) ;
		// pack() ;
	}
}



