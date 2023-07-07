package gui.class303.gui05.slot.sample02;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SlotMachine extends JFrame {

    private JLabel[] labels;
    private JButton startButton;
    private Thread[] threads;

    private String[] symbols = {"Cherry", "Lemon", "Orange", "Plum", "Bell", "Bar", "Seven"};
    private Random random = new Random();

    public SlotMachine() {
        setTitle("Slot Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //ラベル[配列]、スレッド[配列]を生成
        labels = new JLabel[3];
        threads = new Thread[3];
        //パネルを生成
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        //各ラベルを生成し、パネルに追加
        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setFont(new Font("Arial", Font.BOLD, 24));
            panel.add(labels[i]);
        }
        
        //ボタンを生成、イベントを生成
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                //回転処理？
                startSpinning();
            }
        });
        
        //フレームにパネル、ボタンを追加
        add(panel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
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

//    private void checkResult() {
//        String symbol = labels[0].getText();
//
//        for (int i = 1; i < 3; i++) {
//            if (!labels[i].getText().equals(symbol)) {
//                JOptionPane.showMessageDialog(this, "Sorry, you lose!", "Result", JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }
//        }
//
//        JOptionPane.showMessageDialog(this, "Congratulations, you win!", "Result", JOptionPane.INFORMATION_MESSAGE);
//    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SlotMachine();
            }
        });
    }
}