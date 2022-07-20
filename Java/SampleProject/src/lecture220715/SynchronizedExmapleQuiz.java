package lecture220715;


class SharedObject{
	public void printName() {
		
		synchronized (this) {
			try {    

				for(int i =0;i<10;i++) {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+":"+i);
					notify();
					wait();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
	}
}

class ThreadEx implements Runnable{
	private SharedObject obj;
	
	public ThreadEx(SharedObject obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		
		obj.printName();
		
		
	}
}


public class SynchronizedExmapleQuiz { 
	public static void main(String[] args) {
		SharedObject obj = new SharedObject();
		ThreadEx r = new ThreadEx(obj);
		
		 
		Thread t1 = new Thread(r,"ThreadA");
		Thread t2 = new Thread(r,"ThreadB");
		
		t1.start();
		t2.start();
		
	}
}
