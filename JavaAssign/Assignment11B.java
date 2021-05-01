import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

class MyClass {

	public static void main(String args[]) throws IOException {	
		long start, end;	
		System.out.println("Read data from file and storing it on List.");
		Path path = Paths.get("file.txt");
		Charset charset = Charset.forName("UTF-8");
		List<String> list = Files.readAllLines(path, charset);

		System.out.println("\nWriting Data Using IO BufferedWriter.write() on a file using Iterable: ");
		FileWriter wfile = new FileWriter("file1.txt");
		BufferedWriter fwrite = new BufferedWriter(wfile);
		start = System.currentTimeMillis();	
		for(String line: list) {
			wfile.write(line);
		}
		fwrite.close();
		end = System.currentTimeMillis();
		System.out.println("Total time taken: "+Long.toString(end-start)+"\n");

		start=0;
		end=0;

		// For Files.write()
		System.out.println("Writing Data Using NIO Files.write() on a file using Iterable: ");
		Path pwrite = Paths.get("file2.txt");
		start = System.currentTimeMillis();
		Files.write(pwrite, list, charset);
		end = System.currentTimeMillis();
		System.out.println("Total time taken: "+Long.toString(end-start));
	}
}
