import java.util.*;

class BaseChange {
	String baseBin(String num) {
		return Integer.toString(Integer.parseInt(num, 10), 2);
	}

	String baseHex(String num) {
		return Integer.toString(Integer.parseInt(num, 10), 16);
	}
}

class Assign3 {
	public static void main(String args[]) {
		// taking input from user
        ArrayList<String> name=new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        while(true){
            String str = input.nextLine();
			if(str.isEmpty()) {
				break;
			}	
            name.add(str);
        }

		BaseChange ob = new BaseChange();
		
        // iterating list
        Iterator itr=name.iterator();
        while(itr.hasNext()) {
            // converting list item into string
            String temp = String.valueOf(itr.next());
			System.out.println("\nNumber: "+temp);	
			System.out.println("Binary: "+ob.baseBin(temp));	
			System.out.println("Hexadeciaml: "+ob.baseHex(temp));	
		}
	}
}
