package gui.class303.gui.example.example06;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SampleWindow extends JFrame implements ActionListener, ItemListener {
	List<String> list;
	JTextArea area;
	
	public SampleWindow( String title) {
		super( title ) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container ContentPane = getContentPane();
		
		JTextField textField = new JTextField("CSVから読み込み");
		JButton btn = new JButton("push");
		btn.addActionListener(this);
		ContentPane.setLayout(new BoxLayout(ContentPane, BoxLayout.Y_AXIS));
		
		area = new JTextArea() {
			
		};
		
		
		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(btn);
		
		ContentPane.add(panel);
		ContentPane.add(area);
		
		
		

//		for(var jc : jcbs) ContentPane.add(jc);
		
		
		
		
		

		
		
//		List<String> list = 
//	    
//		JCheckBox[] jcbs = new JCheckBox[ msg.length ] ;
//		for( int i = 0 ; i < msg.length ; ++i ) {
//            String s = msg[i];
//				jcbs[i] = new JCheckBox( (i+1) + ") " + s ) ;
//			    jcbs[i].setName(s) ;
//			    jcbs[i].setSelected( (i % 2) == 0  ) ;
//			    jcbs[i].addActionListener( this ) ;
//			    jcbs[i].addItemListener( this ) ;
//		}
//
//		for( var jc : jcbs )	ContentPane.add(jc) ;
		
		
		
		
		ContentPane.setPreferredSize( ContentPane.getPreferredSize() ) ;
		pack();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if()
		
//		JCheckBox jcb = (JCheckBox) e.getSource();
		JButton btn = (JButton)e.getSource();
		CsvReader csv = new CsvReader();
		list = csv.CsvFileReader();
//		String state = jcb.isSelected() ? "checked" : "unchecked" ;
//		System.out.printf("Action:%s  %s \n", state, jcb.getName());
		
		for(String s : list) {
			area.setText(s+"\n");
//			area.setText("\n");
//			System.out.println("a");
		}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		JCheckBox jcb = (JCheckBox) e.getSource();
//		String state = 
//			( e.getStateChange() == ItemEvent.SELECTED ) ? "checked" : "unchecked" ;
//		System.out.printf("Item:%s %s\n", state, jcb.getName());
	}
}

	
	

