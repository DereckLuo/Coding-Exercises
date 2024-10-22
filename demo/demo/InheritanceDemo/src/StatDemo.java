class Counter{
	
	// non static fileds or methods in class belongs to object
	// static belongs to class
	
	int count; // belong to object
	
	// Since their is a single class Counter so sCount will have a single copy
	static int scount; // which do not belong to object
	// it belongs to class
	
	Counter(){
		count = 1;
		scount = 1;
	}
	
	void incrementCount(){
		count++;
		scount++;
	}
	
	void showCount(){
		System.out.println("count is: "+count);
		System.out.println("count is: "+scount);
	}
	
	static void fun(){
		System.out.println("This belongs to class");
	}
	
}

public class StatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c1 = new Counter(); //1
		Counter c2 = new Counter(); //1
		Counter c3 = new Counter(); //1
		
		c1.incrementCount(); //2 2
		c1.incrementCount(); //3 3
		c2.incrementCount(); //2 4
		
		c1.incrementCount(); //4
		c2.incrementCount(); //3
		c2.incrementCount(); //4
		
		c1.incrementCount(); //5
		c2.incrementCount(); //5
		
		c1.incrementCount(); //6
		
		c3.incrementCount(); //2 11
		
		c1.showCount(); // 11 5 7 6 5 5 6 5
		c2.showCount(); // 11 6 6 5 2 4 5 3
		c3.showCount(); // 11 2 3 2 1 1 5 2
		
		c1.fun();
		c2.fun();
		c3.fun();
		Counter.fun(); // Accessed using Class since it belongs to class
		//Class.incrementCount();
	
	}

}
