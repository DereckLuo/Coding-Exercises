class Par{ // Which cannot be inherited
	 void purchaseCar(int i){ // Which you cannot override
		System.out.println("Lets purchase Maruti");
	}
}

class Chi extends Par{
	/*void purchaseCar(){
		System.out.println("Lets purchase Maruti");
	}*/
	
	void purchaseCar(int i){ // Redefining the function/method purchaseCar
		System.out.println("Lets purchase Honda");
	}
	
	// Overriding happens -> Child's definition will be executed over parent's definition
}

public class OverridingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chi child = new Chi();
		child.purchaseCar(0);
		
		final int i = 10; // Value of i cannot be changed
		//i = 100; // err
	}

}
