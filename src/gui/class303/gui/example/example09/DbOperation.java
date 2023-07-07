package gui.class303.gui.example.example09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class DbOperation {
	Connection conn;
	String url;
	String user;
	String password;
	
	
	public DbOperation() {
		url = "jdbc:postgresql://localhost:5432/postgres";
		user = "postgres";
		password = "postgrestest";
	}
	
	
	public void connect() {
		try {
			conn = DriverManager.getConnection ( url, user, password );
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void disConnect() {
		if(conn != null) {
			try {
				//conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public int insertTempData(Date date, double ave, double max, double min) {
//		int resultNum = 0;
//		String sql = "insert into temperature values (?, ?, ?, ?)";
//		try(
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				){
//			pstmt.setDate(1, new java.sql.Date(date.getTime()));
//			pstmt.setDouble(2, ave);
//			pstmt.setDouble(3, max);
//			pstmt.setDouble(4, min);
//			resultNum = pstmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.getStackTrace();
//		}
//		return resultNum;
//	}
	
	
	public Object[][] SelectData() {
		Object[][] ob = new Object[100][];
		
		String sql = "select * from 家計簿アーカイブ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		try(
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery ( sql );
				){
			int i=0;
			while(result.next()) {
				 Object[] str = {result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)};
				ob[i] = str;
				i++;
			}
		} catch(SQLException e) {
			e.getStackTrace();
		}	
		
		
		return ob;
	}
	
	
	
//	public int getSelectData(String month, CsvFileOperation cfr) {
//		int resultCount = 0;
//		String sql = "select * from temperature where to_char(hiduke, 'MM') = month";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		try(
//				Statement stmt = conn.createStatement();
//				ResultSet result = stmt.executeQuery ( sql );
//				){
//			while(result.next()) {
//				cfr.csvWriter( result.getDate(1), result.getDouble(2), result.getDouble(3), result.getDouble(4));
//				resultCount++;
//				
//				
//				//Date update_date = result.getDate(5);
//				System.out.printf("%s　平均気温：%f℃　最高気温：%f℃　最低気温：%f℃", sdf.format( result.getDate(1) ), result.getDouble(2), result.getDouble(3), result.getDouble(4));
////				goods.setUpdate_date(result.getTimestamp(5));
////				goods.setUpdate_date(update_date);
//			}
//		} catch(SQLException e) {
//			e.getStackTrace();
//		}	
//		
//		
//		return resultCount;
//		
//	}
	
	
	
	
	
	
	
	

}

