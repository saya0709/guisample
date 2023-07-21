package gui.bookkeeping.sample04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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


//	




	//DBからprobookkeepingデータを取得
	public ArrayList<ProBookKeeping> dbGetProBookKeeping() {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<ProBookKeeping> list = new ArrayList<>();
		String sql = "select * from proBookkeeping";
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				int id = result.getInt(1);
				String subject = result.getString(2);
				list.add(new ProBookKeeping(id, subject));
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
	
	
	
	//DBからtitleデータを取得
	public ArrayList<Title> dbGetTitle(int subId) {
	Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<Title> list = new ArrayList<>();
		String sql = "select * from Title where subject_id =" + subId;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				int id = result.getInt(1);
				String title = result.getString(2);
				int subject_id = result.getInt(3);
				list.add(new Title(id, title, subject_id));
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
	
	
	//DBからInnerTitleデータを取得
	public ArrayList<InnerTitle> dbGetInnerTitle(int titleId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<InnerTitle> list = new ArrayList<>();
		String sql = "select * from InnerTitle where title_id =" + titleId;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				int id = result.getInt(1);
				String innertitle = result.getString(2);
				int title_id = result.getInt(3);
				list.add(new InnerTitle(id, innertitle, title_id));
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
	public ArrayList<QA> dbGetQA(int innertitleId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<QA> list = new ArrayList<>();
			
		
		String sql = "select * from qa where innertitle_id = " + innertitleId;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while ( result.next() ) {
				int id = result.getInt(1);
				String qasub = result.getString(2);
				String q = result.getString(3);
				String a = result.getString(4);
				int title_id = result.getInt(5);
				QA qa = new QA(id, qasub, q, a, title_id);
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

}
