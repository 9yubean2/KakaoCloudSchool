package lecture220715;

class Account {
	
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
//	//출금하는 method => 동기화 처리
//	public synchronized void withdraw(int money) {
//		if ( balance >= money) {
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			balance -= money;
//		}
//		
//	}
	 
	
	
	public void withdraw(int money) {
		 synchronized (this) {
			 if ( balance >= money) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					balance -= money;
				}
		 }
	}
}

class ThreadEx09_1 implements Runnable{
	
	Account acc = new Account();
	
	@Override
	public void run() {
		while (acc.getBalance()>0) {
			int money = (int)(Math.random() * 3 + 1)*100; //100~400 까지의 정수
			acc.withdraw(money);
			System.out.println("남은 잔액은 : " + acc.getBalance());
		}
	}
}

public class ThreadExam09 {
	public static void main(String[] args) {
		 ThreadEx09_1 r = new  ThreadEx09_1();
		 Thread t1 = new Thread(r);
		 Thread t2 = new Thread(r);
		 
		 t1.start();
		 t2.start();
	}
}
