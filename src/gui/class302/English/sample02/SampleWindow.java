package gui.class302.English.sample02;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class SampleWindow extends JFrame {
	
	
	
	JPanel head ;
	JPanel listPanel;
	JTextField text ;
	JComboBox<String> comboBox ;
	DefaultTableModel model;
	JTableHeader jheader;

	JTable table;
	JLabel label;
	JScrollPane scp ;
	DbAccess db ;

	ArrayList<Kakeibo> klist;
	ArrayList<Himoku> hlist;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Container contPane ;
	
	String [] titles =  {  "", "", "" } ;
	String[] KakeiboTitles1 = {"日付", "メモ", "出金額","入金額"};
	String[] HimokuTitles1 = {"名称", "メモ"};
	String[] header = {};

	public SampleWindow(String title) {
		super( title) ;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ウィンドウの大きさ
		setSize(600, 400);
		//ウィンドウの初期位置
		setLocationRelativeTo(null);
		//		setResizable(false);
		
		//テーブルデータの初期化
//		String[][] tableNames1 = {KakeiboTitles1, HimokuTitles1};
		
		model = new DefaultTableModel(null, header);
		
		
		db = new DbAccess();
		head = new JPanel();
		listPanel = new JPanel();
		
		
		//コンボボックスの初期化
//		String[] tableNames = {"家計簿", "費目"};
		text = new JTextField("家計簿項目");
		comboBox = new JComboBox<>();
		comboBox.addActionListener( new SelectActionListener() );
		comboBox.addItem("選んでください");
		comboBox.addItem("家計簿");
		comboBox.addItem("費目");
		
		//head.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		head.add(text);
		head.add(comboBox);

		head.setPreferredSize(new Dimension(500,50));
		listPanel.setPreferredSize(new Dimension(500,500));
		
		contPane = this.getContentPane();
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane.add(head);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		listPanel.add(scp);
		add(head);
		add(listPanel);
		
	}





	
	class SelectActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
			System.out.println(s);
			switch(s){
			case "選んでください":
				model.setColumnIdentifiers(header);
				model.setRowCount(0);
				break;
			case "家計簿":
				model.setColumnIdentifiers(KakeiboTitles1);
				klist = db.dbGetKakeibo();
				listChange(klist);
				break;
			case "費目":
				model.setColumnIdentifiers(HimokuTitles1);
				hlist = db.dbGetHimoku();
				listHimokuChange(hlist);
			}
			//データテーブルの初期化
			table = new JTable(model);
			scp = new JScrollPane(table);
		}
	}


	public void listChange(ArrayList<Kakeibo> list){
		Object[][] data1 = new Object[list.size()][4];
		model.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			data1[i][0] = sdf.format(  list.get(i).getDate() );
			data1[i][1] = list.get(i).getMemo();
			data1[i][2] = list.get(i).getDeposit();
			data1[i][3] = list.get(i).getWithdraw();
		}
		for(int i=0; i<data1.length; i++) {
			model.addRow(data1[i]);
		}
		System.out.println("abdc");
	}
	
	
	public Object[][] listHimokuChange(ArrayList<Himoku> list){
		Object[][] data1 = new Object[list.size()][3];
		model.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			data1[i][0] = list.get(i).getName();
			data1[i][1] = list.get(i).getMemo();
		}
		for(int i=0; i<data1.length; i++) {
			model.addRow(data1[i]);
		}
		return data1;
	}
	
	
	

}


