package gui.class303.gui.JRadioButton.sample01;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SampleWindow extends JFrame implements ActionListener, ItemListener {
	public SampleWindow( String title ) {
		super( title ) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ContentPaneをFrameに追加
		Container ContentPane = getContentPane();
		
		//panelインスタンス生成
		JPanel panel = new JPanel() ;
		panel.setLayout(new FlowLayout());
		
		
		//ButtonGroupインスタンス生成
		//ButtonGroupで１つしか選択できない機能がある？
		ButtonGroup BtnGrp = new ButtonGroup();
		//JRadioButtonインスタンス３つ生成
		JRadioButton rad1 = new JRadioButton("a) West", true);
		JRadioButton rad2 = new JRadioButton("b) Middle");
		JRadioButton rad3 = new JRadioButton("c) East");
		
		//JRadioButtonに名前をセット
		rad1.setName("West");
		rad2.setName("Middle");
		rad3.setName("East");
		
		//JRadioButtonにItemListenerを追加
		rad1.addItemListener(this);
		rad2.addItemListener(this);
		rad3.addItemListener(this);

		//JRadioButtonにActionListenerを追加
		rad1.addActionListener(this);
		rad2.addActionListener(this);
		rad3.addActionListener(this);
		
		//ButtonGroupに各JRadioButtonを追加
		BtnGrp.add( rad1 ) ;
		BtnGrp.add( rad2 ) ;
		BtnGrp.add( rad3 ) ;
				
		//panelに各JRadioButtonを追加
		panel.add(rad1) ;
		panel.add(rad2) ;
		panel.add(rad3) ;
		
		
		//dimension：寸法の設定
		{ 
			Dimension dim = panel.getPreferredSize() ;
			dim.width += 20 ;
			dim.height += 20 ;
			panel.setPreferredSize( dim ) ;
		}
		
		//ContentPaneにpanelを追加
		ContentPane.add(panel);

		pack();
	}




	@Override
	public void itemStateChanged(ItemEvent e) {
		//受け取ったものをJRadioButtonに変換
		JRadioButton rbtn = (JRadioButton) e.getSource();
		String state = "selected" ;
		if( e.getStateChange() != ItemEvent.SELECTED ){
			state = "unselected";
//			System.out.println("aaa");
		}
		System.out.printf("Item:%s %s\n", state, rbtn.getName());
//		System.out.println("bbb");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton rbtn = (JRadioButton) e.getSource();
		String state = rbtn.isSelected() ? "selected" : "unselected" ;
		System.out.printf("Action:%s %s \n", state, rbtn.getName());	}




}
