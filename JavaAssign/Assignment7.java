import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.RandomAccessFile;  
import java.io.File;  
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;

class WriteFile {

	private static void WriteFile() {
		try {
			System.out.println("Enter Names:");
			Scanner obj = new Scanner(System.in);
			FileWriter wfile = new FileWriter("file.txt");
			BufferedWriter fwrite = new BufferedWriter(wfile);
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

	private static void SearchName() {
		try {
			System.out.println("Enter Name To Search:");
			Scanner obj = new Scanner(System.in);
			String name = obj.nextLine();
			String tmp;
			FileReader rfile = new FileReader("file.txt");
			BufferedReader fread = new BufferedReader(rfile);
			while((tmp=fread.readLine())!=null) {
				if(name.equals(tmp)) {
					System.out.println("Match Found");
					break;
				}
			}
			fread.close();
		} catch(Exception e){System.out.println(e);}
	}

/*
The Problem with this code is It Overwrites the exsisting bytes and 
other Writers like BufferedWriter has not any positional method like seek() etc

	private static void SearchAndReplace() {
		try {
			System.out.println("Enter Name To Search:");
			Scanner obj = new Scanner(System.in);
			String name = obj.nextLine();
			String tmp;
			RandomAccessFile rwfile = new RandomAccessFile("file.txt", "rw");
		  	long posOld = 0;
			long posNew = 0;	
			while((tmp=rwfile.readLine())!=null) {
				posNew = rwfile.getChannel().position();
				if(name.equals(tmp)) {
					System.out.println("Match Found");
					System.out.println("Enter Replacement Name: ");
					String reps = obj.nextLine();
					rwfile.seek(posOld);
					rwfile.writeBytes(reps);
					break;
				}
				posOld=posNew;
			}
			rwfile.close();
		} catch(Exception e){System.out.println(e);}
	}
*/	
	
	private static void SearchAndReplace() {
		try {

			FileWriter wfile = new FileWriter("temp.txt");
			BufferedWriter fwrite = new BufferedWriter(wfile);
			FileReader rfile = new FileReader("file.txt");
			BufferedReader fread = new BufferedReader(rfile);
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter Name to Replace: ");
			String Srch = obj.nextLine();
			String tmp;
			while((tmp=fread.readLine())!=null) {
				if(Srch.equals(tmp)) {
					System.out.println("Match Found");
					System.out.println("Enter Replcaement: ");
					String Repl = obj.nextLine();
					fwrite.write(Repl);
				} else {
					fwrite.write(tmp);
				}
				fwrite.newLine();
			}
			fwrite.close();
			fread.close();

			// renaming files
			String backupFile = "file.txt.bak";
			File f1 = new File("file.txt");
			File f2 = new File(backupFile);
			if(f1.renameTo(f2)) {
				f1 = new File("temp.txt");
				f2 = new File("file.txt");
				f1.renameTo(f2);
			}

		} catch(Exception e){System.out.println(e);}
	}
	

	private static void RemoveDuplicate() {
		try {
			FileWriter wfile = new FileWriter("temp.txt");
			BufferedWriter fwrite = new BufferedWriter(wfile);
			FileReader rfile = new FileReader("file.txt");
			BufferedReader fread = new BufferedReader(rfile);
			ArrayList<String> list = new ArrayList<String>();
			String str;
			while((str=fread.readLine())!=null) {
				list.add(str);
			}
			fread.close();		
			HashSet<String> set = new HashSet<String>(list);
			// sorting list	
			ArrayList<String> newlist = new ArrayList<String>(set);
			Collections.sort(newlist);
			Iterator<String> it = newlist.iterator();
			while(it.hasNext()){
				str = (it.next()).toString();
				fwrite.write(str);
				fwrite.newLine();
			}
			
			//set.forEach(line->{fwrite.write((String)line);fwrite.newLine();});
			//set.forEach(line->{System.out.println(line);});
			fwrite.close();
			fread.close();

			// renaming files
			String backupFile = "file.txt.bak";
			File f1 = new File("file.txt");
			File f2 = new File(backupFile);
			if(f1.renameTo(f2)) {
				f1 = new File("temp.txt");
				f2 = new File("file.txt");
				f1.renameTo(f2);
			}
			
		} catch(Exception e){System.out.println(e);}
	}
	
	public static void main(String args[]) {
		WriteFile();	
		SearchName();
		SearchAndReplace();
		RemoveDuplicate();
	}
	
}
