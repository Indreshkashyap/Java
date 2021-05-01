import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

class TDemo implements Runnable {
	ArrayList<String> list = new ArrayList<String>(); 
	static int count = 0;
	static int lsize;	
	static String str;
	public void CreateList() {	
		for(int i=0;i<1000;i++) {
			list.add("This is the test Sting");
		}
		lsize = list.size();
	}
	
 	public void run() {
	  try {
		File file = new File("file.txt");
		FileWriter fwrite =  new FileWriter(file, true);
		while(true) { 
			synchronized(this) {
				if(count < lsize) {
					System.out.println("Writing file: "+Thread.currentThread().getName());
					fwrite.write(list.get(count++)+"\n");
				} else {	
					System.out.println(Thread.currentThread().getName()+" Exiting....");	
					break;
				}
			}
		}
		fwrite.close();
		Thread.currentThread().interrupt();
	  } catch(Exception e){}
	}
}

class MyClass {
	public static void main(String args[]) {
		TDemo td = new TDemo();
		td.CreateList();
		Thread t1 = new Thread(td);
		Thread t2 = new Thread(td);
		Thread t3 = new Thread(td);
		t1.start();
		t2.start();
		t3.start();
	}
}

