package gui.bookkeeping.sample01;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
	JComboBox<String> comboBox1 ;
	JComboBox<String> comboBox2 ;



	DefaultTableModel model;
	JTableHeader jheader;

	JTable table;
	JScrollPane scp ;
	DbAccess db ;

	ArrayList<String> title;
	ArrayList<String> innerTitle;
	ArrayList<QA> qa;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	Container contPane ;

	String[] header = {};



	public SampleWindow(String title) {
		super( title) ;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ウィンドウの大きさ
		setSize(600, 400);
		//ウィンドウの初期位置
		setLocationRelativeTo(null);
		//setResizable(false);


		/*=======DefaultTableModel(JTable, String[])作成============================*/
		model = new DefaultTableModel(null, header);
		/*====================ここまで============================*/

		/*=======singletonを使用して、DbAccessをインスタンス生成============================*/
		db = DbAccess.getInstance();
		this.title = db.dbGetTitle();
		/*====================ここまで============================*/

		/*====================画面上部============================*/
		//画面上部のパネルを生成
		head = new JPanel();
		head.setPreferredSize(new Dimension(500,50));
		//テキスト生成
		text = new JTextField("プロ簿記");
		//コンボボックスの初期化
		comboBox = new JComboBox<>();
		comboBox.addItem("選んでください");

		comboBox.addActionListener( new SelectActionListener() );

		for(String s : this.title) {
			comboBox.addItem(s);

		}

		comboBox1 = new JComboBox<>();
		comboBox1.addItem("選んでください");
		//		comboBox1.addActionListener( new SelectActionListener1() );
		//		comboBox1.addActionListener( new SelectActionListener() );
		//		comboBox1.addItem("選んでください");
		//		
		//		comboBox2 = new JComboBox<>();
		//		comboBox2.addActionListener( new SelectActionListener() );
		//		comboBox2.addItem("選んでください");
		//		comboBox2.addItem("家計簿");
		//		comboBox2.addItem("費目");



		//画面上部パネルにテキスト、コンボボックスを追加
		head.add(text);
		head.add(comboBox);
		head.add(comboBox1);
		/*====================ここまで============================*/

		/*====================画面中央============================*/
		//画面中央のパネルを生成
		listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,500));

		/*====================ここまで============================*/

		/*====================Frameに追加============================*/
		contPane = this.getContentPane();
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane.add(head);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		table = new JTable(model);
		scp = new JScrollPane(table);

		listPanel.add(scp);


		add(head);
		add(listPanel);
		/*====================ここまで============================*/
	}





	/*====================コンボボックス選択時の処理============================*/
	class SelectActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
			comboBox1.removeAllItems();
			comboBox1.addItem("==選んでください==");
			switch(s){
			case "title1":
				innerTitle = db.dbGetInnerTitle(1);
				break;
			case "title2":
				innerTitle = db.dbGetInnerTitle(2);
				break;
			case "title13":
				innerTitle = db.dbGetInnerTitle(3);
			}

			if(!(s.equals("選んでください"))) {
				//comboBox1.addItem(innertitle);
				for(String innertitle : innerTitle) {
					comboBox1.addItem(innertitle);
				}	
			}

			//			for(String innertitle : innerTitle) {
			//				if(!(s.equals("==選んでください=="))) {
			//					comboBox1.addItem(innertitle);
			//				}
			//				
			//				
			//			}
			//データテーブルの初期化
			//			table = new JTable(model);
			//			scp = new JScrollPane(table);
			comboBox1.addActionListener(new SelectActionListener1()); 
		}
	}

	class SelectActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int count=0;



			String s = (String)comboBox1.getItemAt(comboBox1.getSelectedIndex());
			System.out.println("comboBox1"+s);
			//			if(s == null) {
			//				count++;
			//			} else if(!(s.equals("選んでください"))) {
			//				count++;
			//			} else {
			//				if(count>0) {
			//					System.out.println("abcd");
			qa = db.dbGetQA(s);
			//				}
			//			}
			Object[][] ob = new Object[qa.size()][2];
			model.setRowCount(0);
			//データテーブルの初期化
			model.setColumnIdentifiers(new String[]{"a", "b"});	


			for (int i = 0; i < qa.size(); i++) {
				ob[i][0] =   qa.get(i).getQuestion() ;
				ob[i][1] = qa.get(i).getAnswer();
			}
			for(int i=0; i<ob.length; i++) {
				model.addRow(ob[i]);

			}
			System.out.println("ob"+ob.length);
			System.out.println(++count);



			//						if(!(s.equals("選んでください")) && !(s == null)) {

			//			}

			//			comboBox2.removeAllItems();
			//			comboBox2.addItem("選んでください");
			//			switch(s){
			//			case "title1":
			//				innerTitle = db.dbGetInnerTitle(1);
			//				break;
			//			case "title2":
			//				innerTitle = db.dbGetInnerTitle(2);
			//				break;
			//			case "title13":
			//				innerTitle = db.dbGetInnerTitle(3);
			//			}
			//			for(String innertitle : innerTitle) {
			//				comboBox1.addItem(innertitle);
			//			}
			//データテーブルの初期化
			//			table = new JTable(model);
			//			scp = new JScrollPane(table);
		}
	}

	/*====================ここまで============================*/


	/*===========DBからデータ取得後、テーブル書き換え============================*/
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
	/*====================ここまで============================*/




}


