package gui.class303.gui.JFileChooser.sample01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv {
	private static final String CSV_REGEX = "\"([^\"]*)\"|(\\S+)";
	private static String filepath;
	private static String unit;


	//コンストラクタ(引数：ファイルパス)
	Csv(String filepath, String unit){
		Csv.filepath = filepath;
		Csv.unit = unit;
	}
	
	Csv(){
		
	}

	//CSV読み取りメソッド
	public ArrayList<String> csvReader(String path) throws IOException {
		
		ArrayList<String> list = new ArrayList<>();
		System.out.println(filepath);
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



}


