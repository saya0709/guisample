package gui.class303.gui.example.example06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CsvReader {
	private final String filepath ;

	public CsvReader() {
		System.out.println("user.dirプロパティ："+System.getProperty("user.dir"));		
		//filepath = "C:\\Users\\3030855\\Desktop\\302\\授業\\ファイル操作\\TempData.csv";
		filepath = System.getProperty("user.dir") + "\\file\\example06.txt";	
		System.out.println(filepath);
	}


	public ArrayList<String> CsvFileReader() {
		ArrayList<String> list = new ArrayList<>();
		File file;
		FileReader fr = null;
		BufferedReader br = null;


		try {
			file = new File(filepath);

			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					String[] str = line.split(",");
					list.add(line);
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
