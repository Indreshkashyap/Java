import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class WriteFile {
       static int line=0;
	public static void writeFile() {
		try {
			System.out.println("Enter Names:");
			Scanner obj = new Scanner(System.in);
			FileWriter wfile = new FileWriter("file.txt",true);
			BufferedWriter fwrite = new BufferedWriter(wfile);
			String str;
			while(true) {
				str = obj.nextLine();
				if(str.isEmpty())break;
				fwrite.write(str);
				fwrite.newLine();
                                line++;
			}
			fwrite.close();
			System.out.println("file written sccessfully.");
		} catch(Exception e){System.out.println(e);}
	}

	public static void searchName() {
		try {   int i=1;
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
                                else
                                {   i++;}
			}
                      if(i>line)
                          System.out.println("Match not found");
                    fread.close();
		} catch(Exception e){System.out.println(e);}
	}
	
	
	public static void searchAndReplace() {
		try {

			FileWriter wfile = new FileWriter("temp.txt");
                        BufferedReader fread;
                    try (BufferedWriter fwrite = new BufferedWriter(wfile)) {
                        FileReader rfile = new FileReader("file.txt");
                        fread = new BufferedReader(rfile);
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
                    }
			fread.close();

			// renaming files
                               File f1=new File("file.txt");
                               File f2=new File("temp.txt");
                               boolean c=f1.delete();
                               File f3=new File("file.txt");
                               boolean b=f2.renameTo(f3);
                               if(b)
                                  System.out.println("succsess");
                               else
                                  System.out.println("Failed"); 

		} catch(Exception e){System.out.println(e);}
	}
	

	public static void removeDuplicate() {
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
			
			fwrite.close();
			fread.close();

			// renaming files                       
			File f1 = new File("file.txt");
                        File f2=new File("temp.txt");
                        boolean c= f1.delete();			
			File f3 = new File("file.txt");
                        boolean b=f2.renameTo(f3);
                        if(b)
                            System.out.println("Sucsess");
                        else
                            System.out.println("Failed");
			
			
		} catch(Exception e){System.out.println(e);}
	}
}

class Assign7 {

    public static void main(String[] args) throws IOException {
        
           while(true) 
                {
                    System.out.println("*********************************\nEnter your choice\n1.Enter names in file\n2. Search\n3. Find and replace fromm file\n4. Remove duplicatess\n5.DIsplay File\n6. Exit");
                    Scanner sc2=new Scanner(System.in);
                    int ch=sc2.nextInt();
                    if(ch==1)
                      WriteFile.writeFile();
                    else if(ch==2)
                      WriteFile.searchName();
                    else if(ch==3)
                      WriteFile.searchAndReplace();
                    else if(ch==4)
                       WriteFile.removeDuplicate();
                    else if(ch==5)
                       { 
                         try {
			
			   FileReader rfile = new FileReader("file.txt");
			   BufferedReader fread = new BufferedReader(rfile);
                           String tmp;
                           System.out.println("Conten of files are:");
			   while((tmp=fread.readLine())!=null) 
				System.out.println(tmp);			
			   fread.close();}
		        catch(Exception e){System.out.println(e);}}
                    else if(ch==6)
                        return;
                    else
                        System.out.println("Invalid choice");
                }//while
                }//main
        

       }//class
