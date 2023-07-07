package gui.class303.gui.JTextField.exsample01;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SampleWindow extends JFrame {
	JTextField textField;
	
	public SampleWindow(String title) {
		super(title);
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//文字数指定
		textField = new JTextField(20);
		//初期テキストを設定
		//textField = new JTextField("aa");
		
		//テキストを設定
		textField.setText("aaaa");
		//テキストを取得し、出力
		System.out.println(textField.getText());
		
		
		Container contentPane = getContentPane();
		contentPane.add(textField);
		pack();
		
	}
	
	

}
