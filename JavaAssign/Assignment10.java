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
import java.util.HashMap;
import java.util.Collections;
import java.io.IOException;

class Assign10 {

	private static void WriteData() throws IOException {
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
		System.out.println("file written sccessfully.");
		fwrite.close();
	}

	private static HashMap<Integer, String> LoadData(String path) throws IOException {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		int count=1;
		String str;
		FileReader rfile = new FileReader(path);
		BufferedReader fread = new BufferedReader(rfile);
		while((str=fread.readLine())!=null) {
			hm.put(count, str);
			count++;		
		}
		fread.close();
		return(hm);
	}	

	public static void MethodA() throws IOException {
		HashMap<Integer, String> map = LoadData("file.txt");
		ArrayList<String> newList = new ArrayList<String>(map.values()); // store this valu into the array
		Scanner obj1 = new Scanner(System.in);
		Scanner obj2 = new Scanner(System.in);
		int pos;
		String str;
		System.out.print("Insert Position to insert Item: ");
		pos = obj1.nextInt();
		System.out.print("Insert New Item: ");
		str = obj2.nextLine();
		newList.add(pos-1, str);
		FileWriter wfile = new FileWriter("file.txt");
		BufferedWriter fwrite = new BufferedWriter(wfile);
		for(String line: newList) {
			fwrite.write(line);
			fwrite.newLine();
		}
		fwrite.close();
		System.out.println("file written sccessfully.");
	}

	public static void MethodB() throws IOException {
		HashMap<Integer, String> map = LoadData("file.txt");
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter an Integer key to Search: ");
		int k = obj.nextInt();
		if(map.containsKey(k)) {
			System.out.println("Key Found.");
			System.out.println("Element is: "+map.get(k));
		} else {	
			System.out.println("Key not Found.");
		}
	}	

	public static void MethodC() throws IOException {	
		HashMap<Integer, String> map = LoadData("file.txt");
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter an Integer key to Delete its Value: ");
		int k = obj.nextInt();	
		if(map.containsKey(k)) {
			System.out.println("Key Found.");
			System.out.println("Element is: "+map.get(k));
			map.remove(k);	
			System.out.println("Value Deleted.");
			FileWriter wfile = new FileWriter("file.txt");
			BufferedWriter fwrite = new BufferedWriter(wfile);
			for(int i: map.keySet()) {
				fwrite.write(map.get(i));
				fwrite.newLine();
			}
			fwrite.close();
			System.out.println("File updated.");
		} else {	
			System.out.println("Key not Found.");
		}
	}

	public static void MethodD() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		String str;	
		FileReader rfile = new FileReader("file.txt");
		BufferedReader fread = new BufferedReader(rfile);
		while((str=fread.readLine())!=null) {
			list.add(str);		
		}
		fread.close();
		Collections.sort(list);	
		FileWriter wfile = new FileWriter("file.txt");
		BufferedWriter fwrite = new BufferedWriter(wfile);
		for(String line: list) {
			fwrite.write(line);
			fwrite.newLine();
		}
		fwrite.close();
		System.out.println("file written sccessfully.");
	}


	public static void PrintFunc() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		String str;	
		FileReader rfile = new FileReader("file.txt");
		BufferedReader fread = new BufferedReader(rfile);
		while((str=fread.readLine())!=null) {
			list.add(str);		
		}
		fread.close();
		System.out.println("\n======Current List Elements:=======");
		list.forEach((line)->System.out.println(line));
		System.out.println("======Current List Elements:=======\n");
	}
	
	public static void main(String args[]) throws IOException {
		WriteData();
		PrintFunc();
		MethodA();
		PrintFunc();
		MethodB();
		PrintFunc();
		MethodC();
		PrintFunc();
		MethodD();
		PrintFunc();
	}	
}
