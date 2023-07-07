package gui.class303.gui.JTable.sample03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import customtablemodel.CustomTableModel;

public class SampleWindow extends JFrame implements ActionListener {
	//データ(行)の生成
	Object[][]  data = {
			{ "太郎",      "犬",  5 },  
			{ "ミケ",      "猫",  2 },
			{ "ショーン",  "羊",  4 },
			{ "次郎",      "犬",  4 },
			{ "タマ",      "猫",  3 },
			{ "マル",      "猫" , 2 }
	} ;
	
	//列の生成
	String [] titles =  {  "名前", "種類", "体重(kg)" } ;
	CustomTableModel cmodel;

	JTable table ;
	JTextField txtField ;
	
	//DefaultTableModel
	DefaultTableModel model ;

	SampleWindow( String title ) {
		super( title ) ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contPane = getContentPane();
		contPane.setLayout(new BoxLayout( contPane, BoxLayout.Y_AXIS));
		
		//============JTable/ScrollPane============
		//DefaultTableModel
		cmodel = new CustomTableModel(data,titles);
		//model = new DefaultTableModel( data, titles ) ;
		table = new JTable( cmodel );

		JScrollPane scp = new JScrollPane( table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		{
			Dimension dim = table.getPreferredSize() ;
			dim.width = scp.getPreferredSize().width ;
			dim.height += table.getTableHeader().getPreferredSize().height ;
			scp.setPreferredSize(dim);
		}

		contPane.add( scp, BorderLayout.CENTER ) ;
		//============ここまでJTable============
		
		
		//======データ入力箇所をpane1に追加
		JPanel pane1 = new JPanel() ;
		JLabel label = new JLabel("データ入力 : ") ;
		txtField = new JTextField(25) ;
		JButton button = new JButton( "追加") ;
		button.setActionCommand("追加") ;
		button.addActionListener(this );
		pane1.add( label ) ;
		pane1.add(txtField) ;
		pane1.add( button ) ;

		contPane.add( pane1, BorderLayout.SOUTH ) ;
		
		
		//
		contPane.setPreferredSize(contPane.getPreferredSize());
		pack();
	}
	
	
	
	@Override
	public void actionPerformed( ActionEvent e) {
		if( e.getActionCommand().equals("追加")) {
			String str = txtField.getText() ;
//			if( str == null || str.length() == 0 ) return ;
//
//			String[] rdata =  str.split(" +") ;
//			Object[] rowData = { rdata[0], rdata[1], Integer.valueOf(rdata[2]) };
//			System.out.println( rowData );
//			model.addRow(rowData);
//			table.repaint();
			cmodel.filterData(str);
			
		}
	}
}


