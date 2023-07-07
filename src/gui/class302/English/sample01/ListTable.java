package gui.class302.English.sample01;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ListTable extends JPanel implements ActionListener{
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

//	String [] titles =  {  "問題", "解答", "体重(kg)" } ;
	String [] titles =  {  "", "", "" } ;
//	Object[][] data1;
	String[] KakeiboTitles1 = {"日付", "メモ", "出金額","入金額"};
	String[] HimokuTitles1 = {"名称", "メモ"};


	public ListTable() {
		db = new DbAccess();
		
		head = new JPanel();
		listPanel = new JPanel();

		text = new JTextField("");
		//		comb = new JComboBox();
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


		
		//		label = new JLabel("aaaaaaaaaaaaaa");

		//		listPanel.add(label);
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(head);
		add(listPanel);










	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	class SelectActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
			System.out.println(s);
			switch(s){
			case "家計簿":
				model = new DefaultTableModel(null,  KakeiboTitles1);
				table = new JTable(model);
				
				klist = db.dbGetKakeibo();
				listChange(klist);
				
				
				
				table.setDefaultEditor(Object.class,  null);
				
				scp = new JScrollPane( table,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
				//		{
				//			Dimension dim = table.getPreferredSize() ;
				//			dim.width = scp.getPreferredSize().width ;
				//			dim.height += table.getTableHeader().getPreferredSize().height ;
				//			scp.setPreferredSize(dim);
				//		}

				listPanel.add(scp);

				
//				for(int i = 0; i<KakeiboTitles1.length; i++) {
//					model.setColumnIdentifiers(KakeiboTitles1);
//				}
//				for(int i=0; i<ob.length; i++) {
					
					
//					model.addRow(ob[i]);
					
//				}
				
				
				//model = new DefaultTableModel(ob, KakeiboTitles1);
				//table = new JTable(model);
				
				//table.repaint();
				
				listPanel.repaint();
				
				break;
				
			case "費目":
				System.out.println("abc");
				model = new DefaultTableModel(null,  HimokuTitles1);
				
				hlist = db.dbGetHimoku();
				listHimokuChange(hlist);
				
				table.repaint();
				
				
				
				
				

			}

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
//		model.addColumn(KakeiboTitles1);
		for(int i=0; i<data1.length; i++) {
			model.addRow(data1[i]);
		}
		
		jheader = table.getTableHeader();
		jheader.setReorderingAllowed(false);

		
		
		//return data1;
	}
	
	
	public void listHimokuChange(ArrayList<Himoku> list){
		Object[][] data1 = new Object[list.size()][3];
		model.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			data1[i][0] = list.get(i).getName();
			data1[i][1] = list.get(i).getMemo();
		}
//		model.addColumn(KakeiboTitles1);
		for(int i=0; i<data1.length; i++) {
			model.addRow(data1[i]);
		}
		
		
		table = new JTable(model);
		
		jheader = table.getTableHeader();
		jheader.setReorderingAllowed(false);
		
		table.setDefaultEditor(Object.class,  null);
		
		scp = new JScrollPane( table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		table.repaint();
		
		scp.repaint();
		listPanel.add(scp);
		listPanel.repaint();
		
		
		//return data1;
	}
	
	
	

}
