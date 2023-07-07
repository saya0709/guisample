/*sample01　listの要素をIntegerに変更したもの*/


package gui.class303.gui.JList.sample02;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SampleWindow  extends JFrame {
	//リストの作成
	JList<Integer> list = new JList<>( 
			new Integer[]{1, 2, 4, 8, 16});
	//イベントリスナー(ListSelectionListenerを実装)
	class MyListSelectionListener implements  ListSelectionListener{
		JLabel label ;
		JList<Integer> list ;
		MyListSelectionListener( JList<Integer> list, JLabel label ){
			this.list = list ;
			this.label = label ; 
		}
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String str ;
			if (list.getSelectedIndices().length == 1 ) {
				str = list.getSelectedValue().toString() ;
			}else {
				//System.out.println("aaa");
				str = list.getSelectedValuesList().toString() ;
			}
			label.setText( str ) ;
		}
	}


	SampleWindow(String title){
		setTitle(title);
		// setSize(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel(" ");	// ラベルの高さの目安がないので空白１字
		JScrollPane scrollPane = new JScrollPane(list);

		list.addListSelectionListener( 
				new MyListSelectionListener( list, label ) ) ;
		scrollPane.setPreferredSize(scrollPane.getPreferredSize());

		add(scrollPane, BorderLayout.NORTH);
		add(label, BorderLayout.SOUTH);
		pack() ;
	}





}
