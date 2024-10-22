package co.edureka.main;

import co.edureka.packa.CA; // Import the class from other package into this source code

class CB{
	// Has no modifier -> it means default modifier
	private void show(){ 
		System.out.println("This is in show of CB");
	}
	
	void hello(){
		System.out.println("this is hello");
	}
}

class ChildA extends CA{ // When thanks as a protected is inherited it behaves like private outside the package
	void access(){
		thanks();
	}
}

public class Exe {
	public static void main(String[] args) {
		CB cbRef = new CB();
		// cbRef.show(); // error
		cbRef.hello();
		
		CA caRef = new CA();
		//caRef.showA(); // because showA is default and is accessible within the package not outside the package
		caRef.helloA();
		
		//caRef.thanks(); Protected cannot be accessed outsode the package
		
		ChildA chRef = new ChildA();
		//chRef.awesome(); // It is not inherited // private
		//chRef.showA(); // It is not inherited // default
		chRef.helloA();
		//chRef.thanks(); //not accessible directly but it is inherited
		chRef.access();
	}
}
