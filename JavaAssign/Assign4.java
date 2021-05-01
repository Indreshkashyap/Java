import java.util.*;

class Assign4 {
		public static void main(String args[]) {
			ArrayList<String> name=new ArrayList<String>();
			Scanner ob = new Scanner(System.in);
			String str;
			while(true){
            	str = ob.nextLine();
            	if(str.isEmpty()) {
                	break;
            	}
            	name.add(str);
        	}
	
			for(int i=0;i<name.size();i++) {
				ob = new Scanner(name.get(i));	
				if(ob.hasNextInt()) {
					str = ob.nextLine();
					System.out.println(str+" is Integer");
				} else if(ob.hasNextBoolean()) {	
					str = ob.nextLine();
					System.out.println(str+" is Boolean");
			  	} else if(ob.hasNextFloat()) {
					str = ob.nextLine();
					System.out.println(str+" is Float");
				} else if(ob.hasNextDouble()) {	
					str = ob.nextLine();
					System.out.println(str+" is Double");
				} else if(ob.hasNextLine()){
					str = ob.nextLine();
					System.out.println(str+" is String");
				} 
			}
		}
}

