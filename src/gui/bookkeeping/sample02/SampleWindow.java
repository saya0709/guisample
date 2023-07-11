package gui.bookkeeping.sample02;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	ArrayList<ProBookKeeping> probookkeeping;
	ArrayList<Title> title;
	ArrayList<InnerTitle> innertitle;
	ArrayList<QA> qa;

	//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	Container contPane ;

	String[] header = {};



	public SampleWindow(String title) {
		super( title) ;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ウィンドウの大きさ
		setSize(1000, 600);
		//ウィンドウの初期位置
		setLocationRelativeTo(null);
		//setResizable(false);


		/*=======DefaultTableModel(JTable, String[])作成============================*/
		model = new DefaultTableModel(null, header);
		/*====================ここまで============================*/

		/*=======singletonを使用して、DbAccessをインスタンス生成============================*/
		db = DbAccess.getInstance();
		probookkeeping = db.dbGetProBookKeeping();
		/*====================ここまで============================*/

		/*====================画面上部============================*/
		//画面上部のパネルを生成
		head = new JPanel();
		head.setPreferredSize(new Dimension(900,50));
		//テキスト生成
		text = new JTextField("プロ簿記");
		//コンボボックスの初期化(subject科目選択)
		comboBox = new JComboBox<>();
		comboBox.addItem("選んでください");

		comboBox.addActionListener( new SelectActionListener() );

		for(ProBookKeeping s : probookkeeping) {
			comboBox.addItem(s.getSubject());
		}

		comboBox1 = new JComboBox<>();
		comboBox1.addItem("選んでください");
		comboBox2 = new JComboBox<>();
		comboBox2.addItem("選んでください");
		//画面上部パネルにテキスト、コンボボックスを追加
		head.add(text);
		head.add(comboBox);
		head.add(comboBox1);
		head.add(comboBox2);
		/*====================ここまで============================*/

		/*====================画面中央============================*/
		//画面中央のパネルを生成
		listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(900,400));

		/*====================ここまで============================*/

		/*====================Frameに追加============================*/
		contPane = this.getContentPane();
		contPane.setLayout(new BoxLayout(contPane, BoxLayout.Y_AXIS));
		contPane.add(head);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		table = new JTable(model);
		table.setPreferredSize(new Dimension(900, 200));
		scp = new JScrollPane(table);
		scp.setPreferredSize(new Dimension(900, 300));
		listPanel.add(scp);


		add(head);
		add(listPanel);
		/*====================ここまで============================*/
	}





	/*====================コンボボックス選択時の処理============================*/
	/*========subject・科目選択============================*/
	class SelectActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
			int subId = getSubId(probookkeeping, s);
			comboBox1.removeAllItems();
			comboBox1.addItem("==選んでください==");
			title = db.dbGetTitle(subId);

			if(!(s.equals("選んでください"))) {
				for(Title t : title) {
					comboBox1.addItem(t.getTitle());
				}	
			}
			comboBox1.addActionListener(new SelectActionListener1()); 
		}
	}



	class SelectActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = (String)comboBox1.getItemAt(comboBox1.getSelectedIndex());
			int titleId = getTitleId(title, s);
			comboBox2.removeAllItems();
			comboBox2.addItem("====選んでください====");
			innertitle = db.dbGetInnerTitle(titleId);
			if(!(s.equals("==選んでください=="))) {
				for(InnerTitle t : innertitle) {
					comboBox2.addItem(t.getInnertitle());
				}	
			}
			comboBox2.addActionListener(new SelectActionListener2()); 
		}
	}

	class SelectActionListener2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = (String)comboBox2.getItemAt(comboBox2.getSelectedIndex());
			int innertitleId = getInnerTitleId(innertitle, s);
			qa = db.dbGetQA(innertitleId);
			//			System.out.println("qa:"+qa.size());
			System.out.println(innertitleId);

			Object[][] data = new Object[qa.size()][4];
			model.setRowCount(0);
			model.setColumnIdentifiers(new String[] {"問題番号", "サブタイトル", "問題", "解答"});
			for (int i = 0; i < qa.size(); i++) {

				data[i][0] = qa.get(i).getId();
				data[i][1] = qa.get(i).getQasub();
				data[i][2] = qa.get(i).getQuestion();
				data[i][3] = qa.get(i).getAnswer();
			}
			for(int i=0; i<data.length; i++) {
				model.addRow(data[i]);
			}
			System.out.println("abdc");
		}
	}






	//probookkeepingから選択肢と同じもののidを返すメソッド
	public int getSubId(ArrayList<ProBookKeeping> list, String str) {
		for(ProBookKeeping pbk : list) {
			if(pbk.getSubject().equals(str)) {
				return pbk.getId();			}
		}
		return 0;
	}


	//titleから選択肢と同じもののidを返すメソッド
	public int getTitleId(ArrayList<Title> list, String str) {
		for(Title t : list) {
			if(t.getTitle().equals(str)) {
				return t.getId();			}
		}
		return 0;
	}


	public int getInnerTitleId(ArrayList<InnerTitle> list, String str) {
		System.out.println("innertitle.size:"+list.size());
		System.out.println("str:"+str);
		for(InnerTitle t : list) {
			System.out.println(t.getInnertitle());
			if(t.getInnertitle().equals(str)) {

				System.out.println("id:"+t.getId());
				return t.getId();			}
		}
		return 0;
	}





}


