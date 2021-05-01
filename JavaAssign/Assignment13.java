class MyThread extends Thread {
	static int low, high; 
	MyThread(int x, int y) {
		low = x;
		high = y;
	}

	public void run() {
		while(true) {
			synchronized(this) {
				if(low <= high) {
					System.out.println(Thread.currentThread().getName()+": "+(low++));
				} else break;
			}	
		}
	}
}

class MyClass {
	public static void main(String args[]) {
		MyThread td = new MyThread(1, 20000);
		Thread t1 = new Thread(td);
		Thread t2 = new Thread(td);
		Thread t3 = new Thread(td);
		t1.start();
		t2.start();
		t3.start();
	}
}

