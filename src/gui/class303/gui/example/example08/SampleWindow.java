package gui.class303.gui.example.example08;

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

public class SampleWindow extends JFrame implements ActionListener  {
	
	//データ作成
	Object[][] data;

	//列の生成
	String [] titles =  {  "日付", "費目", "メモ", "入金額", "出金額" } ;


	JTable table ;
	JTextField txtField ;

	//DefaultTableModel
	DefaultTableModel model ;
	
	CsvReader csv ;
	
	SampleWindow( String title ) {
		
		super( title ) ;
		csv = new CsvReader();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contPane = getContentPane();
		contPane.setLayout(new BoxLayout( contPane, BoxLayout.Y_AXIS));

		//============JTable/ScrollPane============
		//DefaultTableModel
		model = new DefaultTableModel( data, titles ) ;
		table = new JTable( model );

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
		JLabel label = new JLabel("csv読み込み: ") ;
		JButton button = new JButton( "追加") ;
		button.setActionCommand("追加") ;
		button.addActionListener(this );
		pane1.add( label ) ;
		pane1.add( button ) ;

		contPane.add( pane1, BorderLayout.SOUTH ) ;


		//
		contPane.setPreferredSize(contPane.getPreferredSize());
		pack();
	}



	@Override
	public void actionPerformed( ActionEvent e) {
		if( e.getActionCommand().equals("追加")) {
			data = csv.CsvFileReader();
			
//			
//			String str = txtField.getText() ;
//			if( str == null || str.length() == 0 ) return ;
			for(Object[] d : data) {
				System.out.println(d[0]);
				Object[] rowData = { d[0], d[1], d[2] };
				if(d[0]==null) {
					break;
				}
				
				model.addRow(rowData);
				table.repaint();
				System.out.println("aaa");
			}
			
			
		}
	}
}



