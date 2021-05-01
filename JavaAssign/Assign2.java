import java.util.*;

class Assign2 {
	public static void main(String args[]) {
		// taking input from user
		ArrayList<String> name=new ArrayList<String>();
		Scanner ob = new Scanner(System.in);
		while(true){
			String str = ob.nextLine();
			if(str.length()==0){
				break;
			}
			name.add(str);
		}

		// iterating list
		Iterator itr=name.iterator();
		while(itr.hasNext()) {
			// converting list item into string
			String temp = String.valueOf(itr.next());	
			// converting string into char arry
			String[] sptname = temp.split(" ");	
			int len = sptname.length;
			for(int i=0;i<len-1;i++) {		
				char ch[] = sptname[i].toCharArray();
				System.out.print(String.valueOf(ch[0]).toUpperCase()+".");
			}
			System.out.println(sptname[len-1]);
		}
	}

}
