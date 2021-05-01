import java.io.RandomAccessFile;

class RandomAccess {

	static final String fpath = "file.txt";
	
	RandomAccess() {
	try {
		RandomAccessFile file = new RandomAccessFile(fpath, "rw");
		file.writeBytes("Hello world\n");
		file.writeBytes("This is Test String\n");
		file.writeBytes("This is Another Test string\n");
		file.writeBytes("Hello world Again\n");
		file.close();
	} catch(Exception e){System.out.println(e);}
	}
	
	private static void ReadFile(int pos) {	
		try {
			RandomAccessFile file = new RandomAccessFile(fpath, "r");
			file.skipBytes(pos);
			String str;
			while((str=file.readLine())!=null) {
				System.out.println(str);
			}
			file.close();	
		} catch(Exception e){System.out.println(e);}
	}

	private static void WriteFile(int pos) {	
		try {
			RandomAccessFile file = new RandomAccessFile(fpath, "rw");
			file.skipBytes(pos);
			file.writeBytes("New at Line\n");
			file.writeBytes("Another New Line\n");
			file.writeBytes("This is end of New Line\n");
			file.close();
		} catch(Exception e){System.out.println(e);}
	}
	

	public static void main(String args[]) {

		try {
			RandomAccessFile file = new RandomAccessFile(fpath, "rw");
			file.writeBytes("Hello world\n");
			file.writeBytes("This is Test String\n");
			file.writeBytes("This is Another Test string\n");
			file.writeBytes("Hello world Again\n");
			file.close();
		} catch(Exception e){System.out.println(e);}

		System.out.println("[*] Read last line:");	
		ReadFile(60);
		WriteFile(32);
		System.out.println("[*] Modified line:");	
		ReadFile(0);
	}	
}

