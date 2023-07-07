package gui.class303.gui.JFileChooser.sample01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SampleWindow  extends JFrame implements ActionListener {
	//=======拡張子による選別========
	static FileNameExtensionFilter fileExtensionfilter
	= new FileNameExtensionFilter(" テキスト", "txt", "text") ;
	//===============================
	JTextField txfFileName = null ;
	ArrayList<String> list;
	
	
	SampleWindow(String title){

		super(  title ) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contPane = getContentPane();
		contPane.setLayout(new BorderLayout());
		
		//pane1作成
		JPanel pane1 = new JPanel() ;
		
		//ラベル作成・テキストフィールドに代入
		JLabel lblFileName = new JLabel(" ファイル名： ");
		txfFileName = new JTextField( "<<ファイル名>>", 20 ) ;
		
		//pane1にラベル、テキストフィールドを追加
		pane1.add(lblFileName) ;
		pane1.add(txfFileName) ;
		
		//ボタン作成
		JButton btnFileChooser = new JButton(" ファイルを選択 ") ;
		btnFileChooser.addActionListener( this ) ;
		
		//pane0作成
		JPanel pane0 = new JPanel() ;
		pane0.setLayout( new BoxLayout( pane0, BoxLayout.Y_AXIS ) ) ;
		
		//pane0にpane1、ボタンを追加
		pane0.add(pane1) ;
		pane0.add(btnFileChooser) ;
		contPane.add(pane0, BorderLayout.NORTH);
		contPane.setPreferredSize( contPane.getPreferredSize() ) ;
		pack();


	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		
		//setFileFilter(引数)：引数でファイルを選別する
		fileChooser.setFileFilter(fileExtensionfilter);

		//setCurrentDirectory()：指定したディレクトリ（フォルダー）をダイアログ表示時のフォルダーにする
		fileChooser.setCurrentDirectory( new File("C:\\Temp") ) ;
		//ファイル選択ダイアログボックスを表示し、ユーザーがファイルを選択すると選択したファイルに関する情報を返す
		//thisは現在の現在のインスタンスを指し、ダイアログボックスの親コンポーネントとして使用される。
		//通常はダイアログを表示する親コンテナ(Frame?)を指定するために使用される
		int selected = fileChooser.showOpenDialog(this);
		
		if (selected == JFileChooser.APPROVE_OPTION) {
			//fileChooser.getSelectedFile()の戻り値はFile型でパスを表す
			File file = fileChooser.getSelectedFile();
			//file.getName();パスからファイル名だけを取り、String型で表す
			String fileName = file.getName() ;
			txfFileName.setText( fileName );
			System.out.println(fileChooser.getSelectedFile());
			
			
			//filepath・csv読み取り
			//fileChooser.getSelectedFile().getAbsolutePath();パスをString型に変換
			String path =  fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println("fileName:"+fileName);
			System.out.println(path);
			Csv csv = new Csv();
			try {
				list = csv.csvReader(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(list.size());
		}

	}

}
