package gui.class303.gui05.slot.sample03;

import javax.swing.SwingUtilities;




public class Main {


	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	SampleWindow sw = new SampleWindow();
        		sw.setVisible(true); 
            }
        });

	}

}
