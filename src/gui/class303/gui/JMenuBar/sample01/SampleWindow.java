package gui.class303.gui.JMenuBar.sample01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SampleWindow extends JFrame implements ActionListener{

	SampleWindow(String title){
		super(title);
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//menuBarインスタンス生成
		JMenuBar menuBar = new JMenuBar();
		//FrameにmenuBarをセット
		setJMenuBar( menuBar );
		//メニューのインスタンスを生成
		JMenu menuFile = new JMenu("ファイル") ;
		JMenu menuColor = new JMenu("色");
		//メニューバーにメニュー(ファイル、色の項目)を追加
		menuBar.add( menuFile ) ;
		menuBar.add( menuColor ) ;

		//各メニューアイテム(項目)をインスタンス生成
		JMenuItem menuItem1New   = new JMenuItem("新規");
		JMenuItem menuItem2OPen  = new JMenuItem("開く");
		JMenuItem menuItem3Close = new JMenuItem("閉じる");
		JMenuItem menuItem4Exit  = new JMenuItem("終了");

		JMenuItem menuItem1Red    = new JMenuItem("赤") ;
		JMenuItem menuItem2Blue   = new JMenuItem("青") ;
		JMenuItem menuItem3Yellow = new JMenuItem("黄色") ;
		
		//「ファイル」の「閉じる」にイベントを追加
		menuItem4Exit.addActionListener(this);
		
		menuItem3Close.addActionListener(this);
		
		//「ファイル」メニューバーに関するもの
		menuFile.setIcon( new ImageIcon());
		menuFile.setHorizontalTextPosition( JMenu.RIGHT) ;
		menuFile.setVerticalTextPosition( JMenu.CENTER ) ;

		//「色」メニューバーに関するもの
		menuColor.setIcon( new ImageIcon("./img/Neru_32x32.gif"));
		menuColor.setHorizontalTextPosition( JMenu.RIGHT) ;
		menuColor.setVerticalTextPosition( JMenu.CENTER ) ;
		
		//「ファイル」メニューバーに「メニューアイテム(項目)」を追加
		menuFile.add(menuItem1New) ;
		menuFile.add(menuItem2OPen) ;
		menuFile.add(menuItem3Close) ;
		menuFile.add(menuItem4Exit) ;
		
		//「色」メニューバーに「メニューアイテム(項目)」を追加
		menuColor.add(menuItem1Red) ;
		menuColor.add(menuItem2Blue) ;
		menuColor.add(menuItem3Yellow) ;
		
		//「色」メニューバーの「メニューアイテム(項目)」に「色の濃さ」メニューバーを追加
		JMenu menuColorLevel = new JMenu("色の濃さ") ;
		JMenuItem menuItem1Dark  = new JMenuItem("濃く") ;
		JMenuItem menuItem2Medium = new JMenuItem("中間") ;
		JMenuItem menuItem3Thin = new JMenuItem("薄く") ;

		menuColorLevel.add(menuItem1Dark) ;
		menuColorLevel.add(menuItem2Medium) ;
		menuColorLevel.add(menuItem3Thin) ;

		menuColor.add( menuColorLevel ) ;

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem)e.getSource() ;
		String txt = mi.getText();
		if( txt.equals("終了")) {
			System.exit(0) ;
		} else if(txt.equals("閉じる")) {
			System.out.println("閉じます");
		}




	}

}
