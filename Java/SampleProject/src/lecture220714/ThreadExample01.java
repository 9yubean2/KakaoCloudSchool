package lecture220714;

class Thread01_1 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName());
		}
	}
}
class Thread01_2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
			//Thread.currentThread() 현재 실행되는 thread를 reference
		}
	}
}
public class ThreadExample01 {
	public static void main(String[] args) {
		Thread01_1 t1 = new Thread01_1();
		
		Thread01_2 r = new Thread01_2();
		Thread t2 = new Thread(r);
		
		//multicore 환경에서는 우선순위의 의미가 없음
		t1.setPriority(10);
		t2.setPriority(2);
		
		t1.start();
		t2.start();
		
		System.out.println("Main Thread Quit");
	}
}
