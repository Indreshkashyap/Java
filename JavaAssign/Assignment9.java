import java.util.ArrayList;
import java.util.Scanner;

class MyClass {

	private static boolean isPrime(int number) {
		boolean isPrime = false;
		int i = (int)Math.ceil(Math.sqrt(number));
		while(i > 1) {
			if((number!=i)&&(number%i==0)) {
				isPrime = false;
				break;
			} else if(!isPrime) {
				isPrime = true;
			}
			--i;
		}
		return isPrime;
	}

	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> Pnum = new ArrayList<Integer>();
		Scanner  sc = new Scanner(System.in);
		String str;
		while(!(str=sc.nextLine()).isEmpty()) {
			list.add(Integer.parseInt(str));	
		}
		int count=0;
		list.forEach(num->{if(isPrime(num))Pnum.add(num);});
		list.removeIf(n->(!isPrime(n)));		

		System.out.println("Main List: ");
		list.forEach(num->System.out.println(num));

		System.out.println("\nNew List: ");
		Pnum.forEach(num->System.out.println(num));

	}
}

