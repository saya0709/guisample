package gui.class302.timer.sample01;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("タイマーを作成します");
		System.out.println("秒を入力してください");
		int input = Integer.parseInt(sc.nextLine());
		
		Timer time = new Timer();			//指定された時間間隔ごとにタスクを実行するためのタイマー機能を持っている
		TimerTask task = new TimerTask() {	//Timerクラスによってスケジュールされるタスクを表す
			int count = input;
			@Override
			public void run() {
				System.out.println(count);
				if(count == 0) {
					time.cancel(); //タイマーを終了する
					System.out.println("タイマーストップ");
				} else {
					count--;
				}
			}
			
		};
		
		long delay = 1000; //1000ミリ秒後にタスクを実行させるための変数
		long period = 1000; //1000ミリ秒ごとにタスクを実行させるための変数
		System.out.println("タイマースタート");
		time.scheduleAtFixedRate(task, delay, period); //タスクをdelay秒後からperiodごとに実行する
	}
}

//Timerクラスのよく使われるメソッド
//	schedule(TimerTask task, Date time)：指定した時間井タスクを実行する
