package gui.class303.gui.JTextField.exsample02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SampleWindow extends JFrame implements ActionListener {
	JTextField textField;
	
	public SampleWindow(String title) {
		super(title);
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//文字数指定
		textField = new JTextField(20);
		
		//ボタン生成
		JButton btn = new JButton("Click");
		btn.addActionListener(this);
		
		//panel生成
		JPanel panel = new JPanel();
		
		//panelにテキスト、ボタンを追加
		panel.add(textField);
		panel.add(btn);
		
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		//以下を追加で記述すると、panelの上にボタンが乗っかる状態になり、panelが表示されない
		//contentPane.add(btn);
		
		pack();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		JButton btn = (JButton)e.getSource();
		//テキストを出力
		System.out.println(textField.getText());
		//テキストを空にする
		textField.setText("");
		
		
	}

}
