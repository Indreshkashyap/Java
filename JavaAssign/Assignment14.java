class MyClass {
	public static void main(String args[]) {
		new Thread(){  
			public void run(){
				Thread.currentThread().setName("Thread-A");
				for(int i=1;i<=50;i++) {
					System.out.println(Thread.currentThread().getName()+": "+i);
					if(i==10) {
						new Thread() {
							public void run() {
								Thread.currentThread().setName("Thread-B");
								for(int j=1;j<=50;j++) {	
									System.out.println(Thread.currentThread().getName()+": 10."+j);
									if(j==20) {
										new Thread() {
											public void run() {
												Thread.currentThread().setName("Thread-C");
												for(int k=1;k<=15;k++) {	
													System.out.println(Thread.currentThread().getName()+": 10.1."+k);
												}
											}
										}.start();
									}
								}
							}
						}.start();
					}
				}		
			}  
		}.start();

	}
}
