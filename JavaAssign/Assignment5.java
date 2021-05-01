import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

class WriteFile {

	private static void BufferedWrite() {
		try {
			System.out.println("Buffered Writing.");
			System.out.println("Enter Names:");
			Scanner obj = new Scanner(System.in);
			FileWriter file = new FileWriter("file2.txt");
			BufferedWriter fwrite = new BufferedWriter(file);
			String str;
			while(true) {
				str = obj.nextLine();
				if(str.isEmpty())break;
				fwrite.write(str);
				fwrite.newLine();
			}
			fwrite.close();
			System.out.println("file written sccessfully.");
		} catch(Exception e){System.out.println(e);}
	}

	private static void UnBufferedWrite() {
		try {
			System.out.println("UnBuffered Writing.");
			System.out.println("Enter Names:");
			Scanner obj = new Scanner(System.in);
			FileOutputStream fout = new FileOutputStream("file1.txt");
			String str;
			while(true) {
				str = obj.nextLine();
				if(str.isEmpty())break;
				str+="\n";
				byte b[] = str.getBytes();	
				fout.write(b);
			}
			fout.close();	
			System.out.println("file written sccessfully.");
		} catch(Exception e){System.out.println(e);}
	}

	public static void main(String args[]) {
		UnBufferedWrite();
		BufferedWrite();
	}
	
}

