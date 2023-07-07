package gui.class302.thread.sample03;

public class Main {
	public static void main(String[] args) {
		ThreadSample1 t1 = new ThreadSample1("スレッドA");
		ThreadSample1 t2 = new ThreadSample1("スレッドB");
		
		//start()：runメソッドを呼び出す
		t1.start();

		//join()が終わるまでmainメソッドは進まない
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
		
		System.out.println("終了");


	}




}



class ThreadSample1 extends Thread{
	private static int counter = 0;
	private String name ;

	ThreadSample1(String name){
		this.name = name;
	}

	@Override
	public void run() {
		try {
			while(true) {
				sleep(1000);
				countCounter();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void countCounter() {
		counter++;
		System.out.println(name + ":" + counter);
		
	}
	
	
	//synchronized ：同時にそのスレッドにいけない？
	
	
}




