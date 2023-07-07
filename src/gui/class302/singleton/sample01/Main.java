package gui.class302.singleton.sample01;

public class Main {
	public static void main(String[] args) {
		
		Singleton singleton1 = Singleton.getInstance();	//シングルトンのインスタンスを作ってから取得
		Singleton singleton2 = Singleton.getInstance();	//すでにシングルトンのインスタンスが作られているので、ただ取得だけをする
		
		System.out.println(singleton1 == singleton2);	//参照値が等しいかどうか
		
		//シングルトンのインスタンスにあるメソッドを呼ぶ
		singleton1.Aaa();//ハッシュコード：オブジェクトの識別子として使用される
		singleton2.Aaa();
		
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
	}
	

	
}


class Singleton{
	//自分自身を持つ
	private static Singleton instance;
	
	//プライベートなコンストラクタを使用してインスタンス化を制御する
	private Singleton() {
		
	}
	
	//偶然同時にメソッドが呼ばれてインスタンス作成が同時に発生しないようにシンクロナイズドを付ける
	public static synchronized Singleton getInstance() {
		if(instance == null) {//インスタンスが作られてなければ
			instance = new Singleton();//インスタンスを作る
		}
		return instance;
	}
	
	public void Aaa() {
		System.out.println("aaaaasa");
	}
	
}

