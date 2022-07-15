package lecture220715;

class Thread07_1 extends Thread{
	@Override
	public void run() {
		for(int i =0; i<300;i++) {
			System.out.print("|");
		}
	}
}
public class ThreadExample07 {
	public static void main(String[] args) {
		Thread t1 = new Thread07_1();
		Thread t2 = new Thread07_1();
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); //t1이 잠깐 끼어드는
			t2.join();
			//이렇게 되면 t1,t2가 종료될때까지 main이 제일 뒤로 밀림(일시적으로 block 됨)
		} catch (Exception e) {
			
		}
		System.out.println("Main 종료");
	}

}
