import java.util.Scanner;

public class Exe {
	
	static int findSquare(int num){ // pass by value int num = n
		int sq = num*num;
		return sq;
	}
	
	static void accessMath(MyMath mm){ // Reference Variable -> Passing by reference MyMath mm = mm1
		mm.addNums(10, 20);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyMath mm = new MyMath(); // Object Construction
		// mm is a reference variable which is stored in stack and it contains address of object
		// new is an operator which will create the object in the heap i.e. object will be created at run time
		
		/*mm.sayHello(); // Call or Invoke or Execute the Method/Function
		mm.addNums(10, 20);
		mm.addNums(30, 40);
		mm.addNums(100, 200);
		
		int result = mm.mulNums(10, 5);
		System.out.println("Mul is: "+result);*/
		
		
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scan.nextInt(); // n will contain an integer value
		
		int result = findSquare(n); // passing the value within n to num // calling by value
		//int result = Exe.findSquare(num);
		System.out.println("Result is: "+result);
		
		scan.close(); // release the resources from memory occupied by scanner class*/
		
		MyMath mm1 = new MyMath(); // mm1 will contain address of object
		accessMath(mm1); // calling by reference
	}
}

