package gui.class302.enam;

	

	import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

	public class Main extends JFrame {

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Main frame = new Main();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public Main() {

			//最初に画面サイズを指定させる
			Object[] possibleValues = {  FrameSize.LARGE.getSizeMsg(), FrameSize.MEDIUM.getSizeMsg(), FrameSize.SMALL.getSizeMsg() };
			Object selectedValue = JOptionPane.showInputDialog(null,
					"画面サイズを指定してください", "Input",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue == null){
				System.exit(0);
			}

			FrameSize fm = null;
			//定数を順番に見ていく
			for (FrameSize size : FrameSize.values()) {
	            if (size.getSizeMsg().equals(selectedValue)) {
	                fm = size;//定数をenum変数に代入
	                break;
	            }
	        }
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, fm.getX(), fm.getY());		//フレームサイズを、enum定数に応じて可変にさせている。
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
		}

	}

	enum FrameSize{

		//定数の定義
		//第一引数：String、第二引数：int x、第三引数：int y
		SMALL("画面サイズ　450×300",450,300),	
		MEDIUM("画面サイズ　600×400",600,400),
		LARGE("画面サイズ　750×500",750,500);

		private String msg;
		private int x;
		private int y;

		FrameSize(String msg,int x,int y){
			this.msg = msg;
			this.x = x;
			this.y = y;
		}

		public String getSizeMsg() {
			return msg;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}
	
	
	


