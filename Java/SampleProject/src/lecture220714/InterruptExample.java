package lecture220714;

import javax.swing.JOptionPane;

class TestThread extends Thread {

	@Override
	public void run() {
		int i = 10;
		while( i != 0 && !isInterrupted() ) {
			System.out.println(--i);
			
//			try {
//				Thread.sleep(4000);
//			} catch (Exception e) {
//				// TODO: handle exception
//				interrupt();
//			}
			for(long k=0; k<12500000000L;k++);//시간지연 하려고
		}
		System.out.println("카운트 종료!!!");
	}
}


public class InterruptExample {

	public static void main(String[] args) {
		Thread t2 = new TestThread();
		
		t2.start();
		
		String input = JOptionPane.showInputDialog("Input value!");
		System.out.println("input value is... "+input);
		
		t2.interrupt();
		//Thread t의 interrupted 상태가 true가 된다.
		
		System.out.println("Thread 상태값은 : " + t2.isInterrupted());
	}
	
}
