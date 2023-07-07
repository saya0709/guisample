package gui.class303.gui05.slot.sample03;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SampleWindow extends JFrame implements ActionListener{
	private JLabel[] labels;
	private JButton startButton;
	//	private JButton[] stopButton;
	private Thread[] threads;

	private String[] symbols = {"Cherry", "Lemon", "Orange", "Plum", "Bell", "Bar", "Seven"};

	public SampleWindow() {
		setTitle("Slot Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//ラベル[配列]、スレッド[配列]を生成
		labels = new JLabel[3];
		threads = new Thread[3];
		//パネルを生成
		JPanel panel = new JPanel( new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS) );
		JPanel buttonPanel = new JPanel( new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS) );

		panel.setLayout(new GridLayout(1, 3));
		buttonPanel.setLayout(new GridLayout(1, 4));

		//各ラベルを生成し、パネルに追加
		for (int i = 0; i < 3; i++) {
			labels[i] = new JLabel();
			labels[i].setFont(new Font("Arial", Font.BOLD, 24));
			panel.add(labels[i]);
		}
		//ボタンを生成、イベントを生成
		startButton = new JButton("Start");
		buttonPanel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				//回転処理？
				startSpinning();
			}
		});
		
		//ストップボタン
		JButton left = new JButton();
		left.setActionCommand("left");
		left.addActionListener(this);
		buttonPanel.add(left);
		JButton center = new JButton();
		center.setActionCommand("center");
		center.addActionListener(this);
		
		
		buttonPanel.add(center);
		JButton right = new JButton();
		buttonPanel.add(right);
		right.setActionCommand("right");
		right.addActionListener(this);
		

		//


		//フレームにパネル、ボタンを追加
		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
//		setLocationRelativeTo(null);
		setVisible(true);



	}


	//回転処理？
	private void startSpinning() {
		for (int i = 0; i < 3; i++) {
			threads[i] = new SpinThread(labels[i]);
			threads[i].start();
		}

		//        Thread checkResultThread = new Thread(new Runnable() {
		//            @Override
		//            public void run() {
		//                try {
		//                    for (int i = 0; i < 3; i++) {
		//                        threads[i].join();
		//                    }
		//
		//                    checkResult();
		//
		//                    SwingUtilities.invokeLater(new Runnable() {
		//                        @Override
		//                        public void run() {
		//                            startButton.setEnabled(true);
		//                        }
		//                    });
		//                } catch (InterruptedException e) {
		//                    e.printStackTrace();
		//                }
		//            }
		//        });
		//        checkResultThread.start();
	}

	private class SpinThread extends Thread {
		private JLabel label;

		public SpinThread(JLabel label) {
			this.label = label;
		}

		@Override
		public void run() {
			for (int i = 0; ; i++) {
				//                String symbol = symbols[random.nextInt(symbols.length)];
				String symbol = symbols[i%symbols.length];

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						label.setText(symbol);
					}
				});

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if(btn.getActionCommand().equals("left")) {
			threads[0].stop();
			
		} else if(btn.getActionCommand().equals("center")) {
			threads[1].stop();
			
		} else if(btn.getActionCommand().equals("right")) {
			threads[2].stop();
			
		}
		
		
	}




}
