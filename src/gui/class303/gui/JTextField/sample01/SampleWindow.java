package gui.class303.gui.JTextField.sample01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SampleWindow extends  JFrame implements ActionListener{
	JLabel 		label;
	JTextField textField;

	SampleWindow(String title){
		setTitle(title);
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField(20);
		JButton button = new JButton("Get");
		button.addActionListener(this);

		JPanel p = new JPanel();
		p.add(textField);
		p.add(button);

		label = new JLabel("",JLabel.CENTER);
		{
			Dimension dim = button.getPreferredSize();
			dim.width = textField.getPreferredSize().width ;
			label.setPreferredSize( dim );
		}

		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		pack() ;
	}

	public void actionPerformed(ActionEvent e){
		label.setText(textField.getText());
	}
}

