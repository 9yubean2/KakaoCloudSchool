package lecture220715;

class ThreadEx08_1 extends Thread {
	//fields
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	 
	 @Override
	public void run() {
		 while(true) {
			 try {
				Thread.sleep(10000); //	10초 동안 자요
			} catch (Exception e) {
				System.out.println("interrupt()에 의해서 깨어났어요!");
			}
			gc();
			System.out.println("메모리 청소 완료");
			System.out.println("현재 사용가능한 메모리량: " + freeMemory());
		 }
	}
	private void gc() {
		usedMemory -= 300;
		if (usedMemory < 0) {
			usedMemory = 0;//음수가 안되게 처리
		}
	}
	public int totalMemory () {
		return MAX_MEMORY;
	}
	public int freeMemory () {
		return MAX_MEMORY - usedMemory;
	}
}

public class ThreadExam08 {
	
	public static void main(String[] args) {
		ThreadEx08_1 t = new ThreadEx08_1();
		t.setDaemon(true);
		t.start();
		
		int requiredMemory = 0;
		
		for (int i =0;i<20;i++) {
			requiredMemory = (int)(Math.random()*10)*20; //0.0보다 같거나 크고 200보다 작은 정수
			//필요한 메모리가 사용할 수 있는 양보다 크거나
			//현재 전체 메모리양의 60% 이상을 사용하고 있을 때 gc호출
			if ((requiredMemory > t.freeMemory())||
					(t.freeMemory() < t.totalMemory()*0.4)) {
				t.interrupt(); //자고 있는 Thread 깨우기 // gc실행 끝날때 까지 기다리지 않아요
				try {
					t.join(100);//0.1초 정도만 끼어들게 해줌
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			t.usedMemory += requiredMemory;
			System.out.println("사용된 메모리 량: " + t.usedMemory);
		}
		
	}
}
