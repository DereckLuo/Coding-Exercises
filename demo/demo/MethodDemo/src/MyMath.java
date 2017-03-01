public class MyMath {
	
	//ack nof no input
		void sayHello(){
			System.out.println("This is Hello Start");
			System.out.println("This is Hello End");
		}
		
		void addNums(int a, int b){
			int c = a+b;
			System.out.println("Sum is: "+c);
		}
	
		
		int mulNums(int a, int b){
			int c = a*b;
			return c;
		}
		
		
		static int findSquare(int num){
			int sq = num*num;
			return sq;
		}
}
