package co.edureka;

public class Exe {
	public static void main(String[] args) {

		System.out.println("Main Started");
		
		int a = 10;
		int b = 0;
		
		int arr[] = {10,20,30,40,50};
		
		try{
			
			System.out.println("arr[5] is: "+arr[3]);
			
			int c = a/b; // error
			System.out.println("c is: "+c);
		}catch(Exception e){ // Polymorphism
			System.out.println(e.getMessage());
		}
		
		/*catch(ArithmeticException ae){
			//System.out.println("Exception due to "+b);
			//System.out.println("Exception: "+ae.getMessage());
			ae.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException aiobe){
			System.out.println(aiobe.getMessage());
		}finally{
			System.out.println("Finally Executed 100 percent");
		}*/
		
		System.out.println("Main Finished");
		
	}
}
