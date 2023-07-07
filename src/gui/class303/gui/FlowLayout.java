package gui.class303.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FlowLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayout frame = new FlowLayout();
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
	public FlowLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 300);
		//setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setAbsolute();
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(30);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setPreferredSize(new Dimension(120,50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setPreferredSize(new Dimension(120,50));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setPreferredSize(new Dimension(120,50));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setPreferredSize(new Dimension(120,50));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("New button");
		btnNewButton_2_1_1.setPreferredSize(new Dimension(120,50));
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1_1_1 = new JButton("New button");
		btnNewButton_2_1_1_1_1_1.setPreferredSize(new Dimension(120, 50));
		contentPane.add(btnNewButton_2_1_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("New button");
		btnNewButton_2_1_1_1.setPreferredSize(new Dimension(120, 50));
		contentPane.add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_2 = new JButton("New button");
		btnNewButton_2_1_1_2.setPreferredSize(new Dimension(120, 50));
		contentPane.add(btnNewButton_2_1_1_2);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("New button");
		btnNewButton_2_1_1_1_1.setPreferredSize(new Dimension(120, 50));
		contentPane.add(btnNewButton_2_1_1_1_1);
	}

}
