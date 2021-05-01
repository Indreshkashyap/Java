// Reverse the given strings

import java.util.Scanner;

class Assign1 {

	int Compare(char ar1[], char ar2[]) {
		int len = ar1.length;
		for(int i=0;i<len;i++) {
			if(ar1[i]!=ar2[i])
				return 1;
		}
		return 0;

	}

	char[] ReverseStr(char chr[]) {
		int len = chr.length;
        char rev[] = new char[len];
        for(int j=len-1,k=0;j>=0;j--,k++) {
            rev[k]=chr[j];
        }
		return rev;

	}

	public static void main(String args[]) {
		Scanner obj1 = new Scanner(System.in);
		String str[] = new String[10];
	 	for(int i=0;i<10;i++) {
			str[i] = obj1.nextLine();
		}	
		
		Assign1 ob = new Assign1();	
		System.out.println("\nPelindrome String are : \n");
	 	for(int i=0;i<10;i++) {
			// convert sting to char array
			char chr[] = str[i].toCharArray();
			// reverse char array
			char rev[] = ob. ReverseStr(chr);
			// comparing string
			int val = ob.Compare(chr, rev);
			if(val==0) {
				System.out.print(chr);
				System.out.println("");
			}

		}
	}
}
