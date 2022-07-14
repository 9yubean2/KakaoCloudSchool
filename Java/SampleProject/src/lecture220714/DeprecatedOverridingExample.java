package lecture220714;

class DeprecatedOverriding implements Runnable{
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;

//	@Override
//	public void run() {
//		while (!stopped && !suspended) {
//			System.out.println(Thread.currentThread().getName());
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}

		@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void stop() {
		stopped = true;
	}
	
	public void resume() {
		suspended = false;
	}
}
public class DeprecatedOverridingExample {
	public static void main(String[] args) {
		
		DeprecatedOverriding r1 = new DeprecatedOverriding();
		DeprecatedOverriding r2 = new DeprecatedOverriding();
		DeprecatedOverriding r3 = new DeprecatedOverriding();
		
		Thread t1 = new Thread(r1,"*"); //두번째 인자는 Thread의 이름
		Thread t2 = new Thread(r2,"**"); //두번째 인자는 Thread의 이름
		Thread t3 = new Thread(r3,"***"); //두번째 인자는 Thread의 이름
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t1.suspend();//t1 일시중지
			Thread.sleep(2000);
			t2.suspend();//t2 일시중지
			
			Thread.sleep(3000);
			t1.resume();//t1 다시 동작
			
			Thread.sleep(3000);
			t1.stop();//t1 stop
			t2.stop();//t2 stop
			
			Thread.sleep(2000);
			t3.stop();//t3 stop
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
