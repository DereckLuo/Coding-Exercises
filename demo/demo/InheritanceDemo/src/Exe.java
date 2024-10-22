class Parent{
	
	int a;
	
	Parent(){ // Constructors are not inherited
		a = 10;
	}
	
	void show(){
		System.out.println("This is show in parent");
	}
}

class Child extends Parent{ // Inheritance
	void fun(){
		System.out.println("a is: "+a);
	}
}

class GC extends Child{
	
}

class P{
	void hello(){ // belongs to object
		System.out.println("Hello");
	}
	
	static void bye(){ // belongs to class
		System.out.println("Bye");
	}
}

class Q extends P{
	// Overriding -> For Objects
	// Hiding -> For Classes
	static void bye(){   
		System.out.println("This is a final bye");
	}
}

class Exe {
	public static void main(String[] args) {
		//Child ch = new Child();
		//ch.show();
		//ch.fun();
		
		Q.bye();
	}
}
