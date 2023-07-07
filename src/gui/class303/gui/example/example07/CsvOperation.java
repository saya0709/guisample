package gui.class303.gui.example.example07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvOperation {
	private final String filepath ;

	public CsvOperation() {
		System.out.println("user.dirプロパティ："+System.getProperty("user.dir"));		
		//filepath = "C:\\Users\\3030855\\Desktop\\302\\授業\\ファイル操作\\TempData.csv";
		filepath = System.getProperty("user.dir") + "\\file\\example07.txt";	
		System.out.println(filepath);
	}
	
	public String csvWriter(String str) {
		int count = 0;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))){
				bw.write(str);
				bw.newLine();
				bw.close();
				return  count+"件ファイル書き込みました" ;
			}catch(IOException e) {
				System.out.println(e);
				return "ファイル書き込みエラー";
			} 
		}

}
