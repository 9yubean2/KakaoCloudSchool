package lecture220714;

class Sleep1 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		
		for(int i =0;i<300;i++) {
		
			System.out.print("-");
		}
		System.out.println("<< Thread1 종료 >>");
	}

}

class Sleep2 extends Thread{
	@Override
	public void run() {
		for(int i =0;i<300;i++) {
			System.out.print("|");
		}
		System.out.println("<< Thread2 종료 >>");
	}

}

public class SleepExample {
	public static void main(String[] args) {
		Sleep1 t1 = new Sleep1();
		Sleep2 t2 = new Sleep2();
		
		t1.start();
		t2.start();
		
//		try {
//			//t1.sleep(2000);//의미가 없어... 현재 실행 되는 thread를 재우는거니까
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			
//		}
		System.out.println("<< Main Thread 종료 >>");
		
	}

}
