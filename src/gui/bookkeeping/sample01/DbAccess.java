package gui.bookkeeping.sample01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAccess {
	//singleton
	private static DbAccess instance;


	//フィールド
	String url = "jdbc:postgresql://localhost:5432/postgres" ;	//DBのURL
	String user = "postgres" ;		//DBのユーザー名
	String password = "postgrestest" ;	//DBのパスワード
	ArrayList<Kakeibo> list;
	//		int[] randomNumArray = new int[5];

	//コンストラクタ
	public DbAccess() {	
	}

	//singleton
	public static synchronized DbAccess getInstance() {
		if (instance == null) {
			instance = new DbAccess();
		}
		return instance;
	}


	//DBから列名を取得
	public String[] dbGetKakeiboColumn(String tableName) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<String> list = new ArrayList<>();
		String sql = "";
		switch(tableName) {
		case "家計簿":
			sql = "select * from 家計簿 limit 1";
			break;
		case "費目":
			sql = "select * from 費目 limit 1";
			break;
		}
		
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );

			// ResultSetのメタデータ取得
			ResultSetMetaData metaData = result.getMetaData();
			// 列数の取得
			int columnCount = metaData.getColumnCount();
			// 列名の取得
			for (int i = 1; i <= columnCount; i++) {
				list.add(metaData.getColumnName(i));
				String columnName = metaData.getColumnName(i);
				System.out.println("Column Name: " + columnName);
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//リストを調整し、String型配列に変換
		switch(tableName) {
		case "家計簿":
			list.remove(1);
			break;
		case "費目":
			list.remove(0);
			break;
		}
		String[] array = list.toArray( new String[list.size()] );
		return array;
	}




	//DBから家計簿データを取得
	public ArrayList<String> dbGetTitle() {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from proBookkeeping";
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				String memo = result.getString(2);
				list.add(memo);
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public ArrayList<String> dbGetInnerTitle(int id) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from InnerTitle where title_id =" + id;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				String memo = result.getString(2);
				list.add(memo);
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	

	//DBから費目データを取得
	public ArrayList<QA> dbGetQA(String innertitle) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<QA> list = new ArrayList<>();
		
		int innertile_id = dbGetInnerTitle_Id(innertitle);
			
		
		String sql = "select * from qa where innerTitle_id = " + innertile_id;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				int id = result.getInt(1);
				String q = result.getString(2);
				String a = result.getString(3);
				int title_id = result.getInt(4);
				QA qa = new QA(id, q, a, title_id);
				list.add(qa);
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("list:"+list.size());
		return list;
	}
	
	
	public int dbGetInnerTitle_Id(String innertitle) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		int id =0;
//		ArrayList<QA> list = new ArrayList<>();
		String sql = "select id from innertitle where innertitle = '" + innertitle+"'";
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				id = result.getInt(1);
//				String q = result.getString(2);
//				String a = result.getString(3);
//				int title_id = result.getInt(4);
//				QA qa = new QA(id, q, a, title_id);
//				list.add(qa);
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	
	
	
	
	
	
	
	



	//DBから最初の１件を取得
	//	public int dbGetFirst(String unit) {
	//		Connection con = null;
	//		Statement stmt = null;
	//		ResultSet result = null;
	//		int firstId=0;
	//		int count=0;
	//		String sql = "select id from "+ unit ;
	//		try {
	//			con = DriverManager.getConnection ( url, user, password );
	//			stmt = con.createStatement();
	//			result = stmt.executeQuery ( sql );
	//			while (result.next()) {
	//				firstId = result.getInt("id");
	//				System.out.println("firstId:"+firstId);
	//				count++;
	//				if(count>0) {
	//					break;
	//				}
	//			}
	//		} catch ( SQLException e ){
	//			e.printStackTrace() ;
	//		}finally{
	//			try {////クローズ処理クローズ処理
	//				if(con != null) con.close();
	//				if(stmt != null) stmt.close();
	//				if(result != null) result.close();
	//			}catch(Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//		return firstId;
	//	}
	//
	//
	//
	//	//DBから件数を取得
	//	public int dbGetCount(String unit) {
	//		Connection con = null;
	//		Statement stmt = null;
	//		ResultSet result = null;
	//		int count=0;
	//		String sql = "select count(*) from "+ unit;
	//		try {
	//			con = DriverManager.getConnection ( url, user, password );
	//			stmt = con.createStatement();
	//			result = stmt.executeQuery ( sql );
	//			if (result.next()) {
	//				count = result.getInt("count");
	//			}
	//		} catch ( SQLException e ){
	//			e.printStackTrace() ;
	//		}finally{
	//			try {////クローズ処理クローズ処理
	//				if(con != null) con.close();
	//				if(stmt != null) stmt.close();
	//				if(result != null) result.close();
	//			}catch(Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//		return count;
	//	}
	//
	//
	//
	//	//乱数作成メソッド
	//	public int[] array(int num, String unit) {
	//		System.out.println("件数: " + num);
	//		Random rand = new Random();
	//		for(int i=0; i<randomNumArray.length; i++) {
	//			randomNumArray[i]=rand.nextInt(num)+dbGetFirst(unit);
	//		}
	//		return randomNumArray;
	//	}
	//
	//
	//
	//}






	//DBから文型問題一覧を選択
	//		public ArrayList<QA> dbGetSentence() {
	//			int[] array = array(dbGetCount());
	//			Connection con = null;
	//			Statement stmt = null;
	//			ResultSet result = null;
	//			ArrayList<QA> list = new ArrayList<>();
	//			//5回回して主キーが乱数であるものをとってくる
	//			for(int i=0; i<array.length; i++) {
	//				String sql = "select * from sentence\n"
	//						+ "WHERE id = '" + array[i] + "'\n";
	//				try {
	//					con = DriverManager.getConnection ( url, user, password );
	//					stmt = con.createStatement();
	//					result = stmt.executeQuery ( sql );
	//					while ( result.next() ) {
	//						int id = result.getInt(1);
	//						String question = result.getString(2);
	//						String answer = result.getString(3);
	//						String translation = result.getString(4);
	//						QA qa = new QA(id, question, answer, translation);
	//						list.add(qa);
	//					}
	//				} catch ( SQLException e ){
	//					e.printStackTrace() ;
	//				}finally{
	//					try {////クローズ処理クローズ処理
	//						if(con != null) con.close();
	//						if(stmt != null) stmt.close();
	//						if(result != null) result.close();
	//					}catch(Exception e) {
	//						e.printStackTrace();
	//					}
	//				}
	//			}
	//			return list;
	//		}


	//DBから不定詞問題一覧を選択
	//			public ArrayList<QA> dbGetInfinitive() {
	//				int[] array = array(dbGetCount());
	//				Connection con = null;
	//				Statement stmt = null;
	//				ResultSet result = null;
	//				ArrayList<QA> list = new ArrayList<>();
	//				//5回回して主キーが乱数であるものをとってくる
	//				for(int i=0; i<array.length; i++) {
	//					String sql = "select * from infinitive\n"
	//							+ "WHERE id = '" + array[i] + "'\n";
	//					try {
	//						con = DriverManager.getConnection ( url, user, password );
	//						stmt = con.createStatement();
	//						result = stmt.executeQuery ( sql );
	//						while ( result.next() ) {
	//							int id = result.getInt(1);
	//							String question = result.getString(2);
	//							String answer = result.getString(3);
	//							String translation = result.getString(4);
	//							QA qa = new QA(id, question, answer, translation);
	//							list.add(qa);
	//						}
	//					} catch ( SQLException e ){
	//						e.printStackTrace() ;
	//					}finally{
	//						try {////クローズ処理クローズ処理
	//							if(con != null) con.close();
	//							if(stmt != null) stmt.close();
	//							if(result != null) result.close();
	//						}catch(Exception e) {
	//							e.printStackTrace();
	//						}
	//					}
	//				}
	//				return list;
	//			}
	//			
	//DBから文型問題一覧を選択
	//		public ArrayList<QA> dbGetSentence() {
	//			int[] array = array(dbGetCount());
	//			Connection con = null;
	//			Statement stmt = null;
	//			ResultSet result = null;
	//			ArrayList<QA> list = new ArrayList<>();
	//			//5回回して主キーが乱数であるものをとってくる
	//			for(int i=0; i<array.length; i++) {
	//				String sql = "select * from sentence\n"
	//						+ "WHERE id = '" + array[i] + "'\n";
	//				try {
	//					con = DriverManager.getConnection ( url, user, password );
	//					stmt = con.createStatement();
	//					result = stmt.executeQuery ( sql );
	//					while ( result.next() ) {
	//						int id = result.getInt(1);
	//						String question = result.getString(2);
	//						String answer = result.getString(3);
	//						String translation = result.getString(4);
	//						QA qa = new QA(id, question, answer, translation);
	//						list.add(qa);
	//					}
	//				} catch ( SQLException e ){
	//					e.printStackTrace() ;
	//				}finally{
	//					try {////クローズ処理クローズ処理
	//						if(con != null) con.close();
	//						if(stmt != null) stmt.close();
	//						if(result != null) result.close();
	//					}catch(Exception e) {
	//						e.printStackTrace();
	//					}
	//				}
	//			}
	//			return list;
	//		}


	//DBから不定詞問題一覧を選択
	//			public ArrayList<QA> dbGetInfinitive() {
	//				int[] array = array(dbGetCount());
	//				Connection con = null;
	//				Statement stmt = null;
	//				ResultSet result = null;
	//				ArrayList<QA> list = new ArrayList<>();
	//				//5回回して主キーが乱数であるものをとってくる
	//				for(int i=0; i<array.length; i++) {
	//					String sql = "select * from infinitive\n"
	//							+ "WHERE id = '" + array[i] + "'\n";
	//					try {
	//						con = DriverManager.getConnection ( url, user, password );
	//						stmt = con.createStatement();
	//						result = stmt.executeQuery ( sql );
	//						while ( result.next() ) {
	//							int id = result.getInt(1);
	//							String question = result.getString(2);
	//							String answer = result.getString(3);
	//							String translation = result.getString(4);
	//							QA qa = new QA(id, question, answer, translation);
	//							list.add(qa);
	//						}
	//					} catch ( SQLException e ){
	//						e.printStackTrace() ;
	//					}finally{
	//						try {////クローズ処理クローズ処理
	//							if(con != null) con.close();
	//							if(stmt != null) stmt.close();
	//							if(result != null) result.close();
	//						}catch(Exception e) {
	//							e.printStackTrace();
	//						}
	//					}
	//				}
	//				return list;
	//			}
	//			





}
