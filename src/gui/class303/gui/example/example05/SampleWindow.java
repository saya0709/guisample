package gui.class303.gui.example.example05;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SampleWindow extends JFrame implements ActionListener {

	JTextField textField;
	JLabel label;
	
	
	public SampleWindow(String title) {
		super(title);
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//文字数指定
		textField = new JTextField(20);

		//ボタン生成
		JButton btn = new JButton("Click");
		btn.addActionListener(this);
		
		//ラベル作成
		label = new JLabel(" ");
		
		//panel生成
		JPanel panel = new JPanel();

		//panelにテキスト、ラベル、ボタンを追加
		panel.add(textField);
		panel.add(label);
		panel.add(btn);


//		{Dimension dim = btn.getPreferredSize();
//		dim.width = textField.getPreferredSize().width;
//		btn.setPreferredSize(dim);
//		btn.setMaximumSize(dim);
//		//		textField.setPreferredSize(dim);
//		//		textField.setMaximumSize(dim);
//
//		}


		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		
		//以下を追加で記述すると、panelの上にボタンが乗っかる状態になり、panelが表示されない
		//contentPane.add(btn);

		pack();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//		JButton btn = (JButton)e.getSource();
		if(textField.getText().equals("")) {
			//ラベルに出力
			label.setText("入力してください");
			//ラベルテキストを赤色に
			label.setForeground(Color.RED);
			//			textField.setText("null");
			System.out.println("入力してください");
		} else {
			//ラベルに出力
			label.setForeground(getForeground());
			//ラベルテキストを黒色に
			label.setText(textField.getText());
			//テキストを出力
			System.out.println(textField.getText());
			//テキストを空にする
			textField.setText("");
		}
	}

}
