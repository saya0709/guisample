package gui.class303.gui.JTable.sample02;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SampleWindow extends JFrame{
	//データ(行)を生成
	Object[][]  data = {
			{ "太郎",      "犬",  5 },  
			{ "ミケ",      "猫",  2 },
			{ "ショーン",  "羊",  4 },
			{ "次郎",      "犬",  4 },
			{ "タマ",      "猫",  3 },
			{ "マル",      "猫" , 2 }
	} ;

	//列を生成
	String [] titles =  
		{  "名前", "種類", "体重(kg)" } ;


	SampleWindow( String title ) {
		super( title ) ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contPane = getContentPane();
		contPane.setLayout(new BoxLayout( contPane, BoxLayout.Y_AXIS));

		JTable table = new JTable(data, titles );

		//スクロールペインにテーブルを追加
		JScrollPane scp = new JScrollPane( table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
				);

		// JScrollPane の高さを合わせる
		{
			Dimension dim = table.getPreferredSize() ;
			dim.width = scp.getPreferredSize().width ;
			dim.height += table.getTableHeader().getPreferredSize().height ;
			scp.setPreferredSize(dim);
		}

		contPane.add( scp ) ;
		
		
		
		
		pack();
	}


}
