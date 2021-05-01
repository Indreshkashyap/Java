import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.text.DateFormatSymbols;  

class Assign12 {
	
	public static void CreateDBFiles() throws IOException {
		
		String[] transcData = {
			"01/01/2019~2000~103~1210",
			"05/01/2019~3000~101~1211",
			"27/01/2019~1500~102~1212",
			"03/02/2019~1000~105~1213",
			"21/02/2019~2000~104~1214",
			"01/03/2019~2000~101~1215",
			"10/03/2019~1500~104~1216",
			"15/03/2019~1500~103~1217"
		};

		String[] SalemData = {
			"101~John~NorthVelly",
			"102~Bruce~Gotham",
			"103~Peter~NewYark",
			"104~Tony~California",
			"105~Frank~NewYark"	
		};

		String[] InvData = {
			"1210~Hard Drive~4~500",
			"1211~Graphics Card~3~1000",
			"1212~Hard Drive~3~500",
			"1213~MotherBoard~1~1000",
			"1214~RAM~4~500",
			"1215~Graphics Card~2~1000",
			"1216~Hard Drive~3~500",
			"1217~RAM~3~500"
		};

		WriteFile(transcData, "transaction.data");
		WriteFile(SalemData, "salesman.data");
		WriteFile(InvData, "invoice.data");
	}

	private static void WriteFile(String[] str, String fileName) throws IOException {	
		Path path = Paths.get(fileName);
		try(BufferedWriter fwrite = Files.newBufferedWriter(path)) {	
			for(String s : str) {
				fwrite.write(s);
				fwrite.newLine();	
			}
			fwrite.close();
		}
	}


	private static ArrayList<String> LoadData(String fileName) throws IOException {	
		Path path = Paths.get(fileName);
		ArrayList<String> list = new ArrayList<String>();
		String str;
		try(BufferedReader fread = Files.newBufferedReader(path)) {	
			while((str=fread.readLine())!=null) {
				list.add(str);
			}
		fread.close();
		}
		return(list);
	}

	private static String getMonth(int month) {      
		return new DateFormatSymbols().getMonths()[month];  
	}

	public static void Method1() throws IOException {
		ArrayList<String> transData = LoadData("transaction.data");
		ArrayList<String> salesmData = LoadData("salesman.data");
		HashMap<Integer,Integer> trDt = new HashMap<Integer,Integer>();
		HashMap<Integer,String> slDt = new HashMap<Integer,String>();
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter Month No: ");
		int mn = obj.nextInt();
		transData.forEach((line)->{
			if(mn==Integer.parseInt(line.split("~")[0].split("/")[1])) {
				trDt.put(Integer.parseInt(line.split("~")[2]), Integer.parseInt(line.split("~")[1]));
			}
		});

		for(int i: trDt.keySet()) {
			salesmData.forEach((line)->{
				if(i==Integer.parseInt(line.split("~")[0])) {
					slDt.put(Integer.parseInt(line.split("~")[0]),line.split("~")[1]);
				}
			});
		}

		ArrayList<String> mainlist = new ArrayList<String>();
		for(int i: trDt.keySet()) {
			mainlist.add(trDt.get(i)+"\t"+getMonth(mn-1)+"\t"+slDt.get(i));
		}
		Collections.sort(mainlist, Collections.reverseOrder());	
		System.out.println("\nName\tMonth\tAmount");
		mainlist.forEach((line)->System.out.println(line));
	}

	public static void Method2() throws IOException {
		ArrayList<String> transData = LoadData("transaction.data");
		ArrayList<String> salesmData = LoadData("salesman.data");
		ArrayList<String> invData = LoadData("invoice.data");
		Scanner obj = new Scanner(System.in);
		System.out.print("\nEnter Month No: ");
		int mn = obj.nextInt();
		int max=0;
		ArrayList<String> tmp1 = new ArrayList<String>();
		for(String line: transData) {
			if(mn==Integer.parseInt(line.split("~")[0].split("/")[1])) {
				if(max<Integer.parseInt(line.split("~")[1])) {
					max = Integer.parseInt(line.split("~")[1]);
					tmp1.clear();
					tmp1.add(line.split("~")[2]+"~"+line.split("~")[3]);
				} else if(max==Integer.parseInt(line.split("~")[1])) {
					tmp1.add(line.split("~")[2]+"~"+line.split("~")[3]);
				}

			}
		}

		ArrayList<String> tmp2 = new ArrayList<String>();
		for(String line: tmp1) {
			salesmData.forEach((inline)->{		
				if(Integer.parseInt(line.split("~")[0])==Integer.parseInt(inline.split("~")[0])) {
					tmp2.add(line.split("~")[1]+"~"+inline.split("~")[1]);
				}
			});
		}

		ArrayList<String> tmp3 = new ArrayList<String>();
		for(String line: tmp2) {
			invData.forEach((inline)->{
				if(Integer.parseInt(line.split("~")[0])==Integer.parseInt(inline.split("~")[0])) {
					tmp3.add(line.split("~")[1]+"~"+inline.split("~")[1]+"~"+inline.split("~")[2]);
				}			
			});
		}

		System.out.println("\nName\tQty\tItem");
		tmp3.forEach((line)->System.out.println(line.split("~")[0]+"\t"+line.split("~")[2]+"\t"+line.split("~")[1]));
	}

	public static void main(String str[]) throws IOException {
		CreateDBFiles();
		Method1();
		Method2();
	}
}
