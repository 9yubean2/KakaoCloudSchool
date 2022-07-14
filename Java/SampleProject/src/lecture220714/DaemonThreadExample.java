package lecture220714;

public class DaemonThreadExample implements Runnable{
	
	static boolean autoSave = false;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);//해당 클래스의 인스턴스로 구성된 thread
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(autoSave==true) {
				System.out.println("자동저장!");
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Thread daemonTread = new Thread(new DaemonThreadExample());
		
		daemonTread.setDaemon(true);
		
		daemonTread.start();
		
		for(int i=0; i<10;i++) {
			try {
				Thread.sleep(1000);//main thread
			}catch (Exception e) {
				
			}
			System.out.println(i);
			
			if(i==5) {
				autoSave = true;
			}
		}
	}
	
}
/*
	0
	1
	2
	3
	4
	5
	6
	7
	자동저장!
	8
	9
 */
