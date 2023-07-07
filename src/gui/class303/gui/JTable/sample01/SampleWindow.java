package gui.class303.gui.JTable.sample01;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTable;

public class SampleWindow extends JFrame {
	//テーブルのデータ内容(行)を配列で作成
	Object[][]  data = {
			{ "太郎",     "犬",  5 },  
			{ "ミケ",     "猫",  2 },
			{ "ショーン", "羊",  4 },
			{ "次郎",     "犬",  4 },
			{ "タマ",     "猫",  3 },
			{ "マル",     "猫" , 2 }
	} ;
	
	//テーブルの列名
	String [] titles =  
			{  "名前", "種類", "体重(kg)" } ;
	
	
	SampleWindow( String title ) {
		super( title ) ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contPane = getContentPane();
		contPane.setLayout(new BoxLayout( contPane, BoxLayout.Y_AXIS));
		
		//JTableをインスタンス生成、コンストラクタ(データ、列)
		JTable table = new JTable(data, titles );
		
		//JTableを追加
		//列(第１引数)をContentPaneに追加
		contPane.add( table.getTableHeader() ) ;
		//データ(行、第２引数)をContentPaneに追加
		contPane.add( table ) ;
		pack();
	}

}
