package practiceJava;

import javax.swing.JOptionPane;

class ThreadInterrupt extends Thread {
	@Override
	public void run() {
		int i = 10;
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++);
		}
		System.out.println("Count End!!");
	}
}

public class interruptExample {
	public static void main(String[] args) {
		Thread t1 = new ThreadInterrupt();
		t1.start();
		
		
		String input = JOptionPane.showInputDialog("Input Value");
		System.out.println("value is"+input);
		t1.interrupt();
		System.out.println("interrupted status"+ t1.isInterrupted());
	}
}
