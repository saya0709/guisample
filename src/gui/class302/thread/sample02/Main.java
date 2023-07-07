package gui.class302.thread.sample02;

public class Main {
	public static void main(String[] args) {
		ThreadSample1 t1 = new ThreadSample1(10);
		ThreadSample1 t2 = new ThreadSample1(20);
		//start()：runメソッドを呼び出す
		t1.start();
		t2.start();
		
		//join()が終わるまでmainメソッドは進まない
		try {
			t1.join();//スレッド１の終了待機
			System.out.println("========");
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("終了");


	}




}



class ThreadSample1 extends Thread{
	private static int counter = 0;
	private int count ;
	
	ThreadSample1(int count){
		this.count = count;
	}
	
	@Override
	public void run() {
		try {
			while(count != 0) {
				sleep(1000);
				System.out.println("t1:"+--count);	
				counter++;
				System.out.println("counter:"+counter);
				
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


