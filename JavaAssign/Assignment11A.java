import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

class MyClass {

	public static void main(String args[]) {	
		long start, end;
		ArrayList<String> list1 = new ArrayList<String>();
		System.out.print("Time taken by ReadLine function: ");
		start = System.currentTimeMillis();	
		try {
			FileReader rfile = new FileReader("file.txt");
			BufferedReader fread = new BufferedReader(rfile);
			String tmp;
			while((tmp=fread.readLine())!=null); 
			fread.close();
		} catch(Exception e){System.out.println(e);}
		end = System.currentTimeMillis();	
		System.out.println(end-start);

		start=0;
		end=0;
		System.out.print("Time taken by ReadAllLine function: ");
		start = System.currentTimeMillis();	
		try {
			Path path = Paths.get("file.txt");
			Charset charset = Charset.forName("UTF-8");
			List<String> list = Files.readAllLines(path, charset);
		} catch(Exception e){System.out.println(e);}
		end = System.currentTimeMillis();	
		System.out.println(end-start);
	}
}


