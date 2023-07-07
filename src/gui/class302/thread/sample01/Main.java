package gui.class302.thread.sample01;

public class Main {
	public static void main(String[] args) {
		ThreadSample1 t1 = new ThreadSample1();
		ThreadSample2 t2 = new ThreadSample2();
		t1.start();
		t2.start();
		
		try {
			t1.join();
			System.out.println("========");
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("終了");
		

	}




}



class ThreadSample1 extends Thread{
	private int count = 10;

	@Override
	public void run() {
		try {
			while(count != 0) {
				sleep(1000);
				System.out.println("t1:"+--count);	
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class ThreadSample2 extends Thread{
	private int count = 10;

	@Override
	public void run() {
		try {
			while(count != 0) {
				sleep(3000);
				System.out.println("t2:"+--count);	
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


