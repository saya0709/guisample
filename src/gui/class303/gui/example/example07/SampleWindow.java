package gui.class303.gui.example.example07;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;



public class SampleWindow extends JFrame implements ActionListener, ItemListener {
	CsvOperation csv ;
	
	public SampleWindow( String title) {
		super( title ) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container ContentPane = getContentPane();
		ContentPane.setLayout(new BoxLayout(ContentPane, BoxLayout.Y_AXIS));
		
		csv = new CsvOperation();
		
		
		String[] msg = {"わたしは、人です", 
				"わたしは、関西に住んでいます",
				"わたしは、猫が好きです",
		"わたしは、悪人です" } ;

		JCheckBox[] jcbs = new JCheckBox[ msg.length ] ;
		for( int i = 0 ; i < msg.length ; ++i ) {
			String s = msg[i];
			jcbs[i] = new JCheckBox( (i+1) + ") " + s ) ;
			jcbs[i].setName(s) ;
			jcbs[i].addActionListener( this ) ;
			jcbs[i].addItemListener( this ) ;
		}

		for( var jc : jcbs )	ContentPane.add(jc) ;

		ContentPane.setPreferredSize( ContentPane.getPreferredSize() ) ;
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox jcb = (JCheckBox) e.getSource();
		String state = jcb.isSelected() ? "checked" : "unchecked" ;
		System.out.printf("Action:%s  %s \n", state, jcb.getName());
		
		

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox jcb = (JCheckBox) e.getSource();
		String state = 
				( e.getStateChange() == ItemEvent.SELECTED ) ? "checked" : "unchecked" ;
		System.out.printf("Item:%s %s\n", state, jcb.getName());
		if(state.equals("checked")) {
			csv.csvWriter(jcb.getName());
				
		}
		
		
	}




}
