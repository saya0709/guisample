package gui.class303.gui.JSpinner.sample01;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class SampleWindow  extends JFrame implements ActionListener {
	SpinnerListModel model = null ;

	public SampleWindow(String tytle) {
		super(tytle);
		List<String> lst = new ArrayList<>() {{
			add("North"); add("East"); add("West");
			add("South"); add("Center");
		}};
		
		//SpinnerListModelにリストを追加
		model = new SpinnerListModel( lst ) ;
		//JSpinnerにSpinnerListModelを渡してインスタンス化
		JSpinner spinner = new JSpinner( model ) ;
		//ボタンをインスタンス化
		JButton button = new JButton("確定");
		button.addActionListener(this) ;
		
		
		Container contPane = this.getContentPane() ;
		//ラベルの生成
		JLabel label = new JLabel("Name",JLabel.CENTER);
		label.setAlignmentX(CENTER_ALIGNMENT);
		spinner.setAlignmentX(CENTER_ALIGNMENT);
		button.setAlignmentX(CENTER_ALIGNMENT);
		
		//ContentPaneの設定、ラベル等の追加
		contPane.setLayout(
				new BoxLayout( contPane, BoxLayout.Y_AXIS) );
		contPane.add( label);
		contPane.add( spinner);
		contPane.add( button );
		pack();
	}

	public void actionPerformed(ActionEvent e){
		String value = (String)model.getValue();
		//thisを使用することで、現在のクラスのインスタンスを親コンポーネントとして指定できる
		JOptionPane.showMessageDialog(this, value);
	}
}





