/*class Shape{
	void draw(){
		System.out.println("Drawing a Shape");
	}
}*/

/*abstract class Shape{ // It is a class for which a user cannot create objects
	abstract void draw(); // It is a function which will have no body // It can only be declared in an abstract class
	
	void fun(){ // Regular Functions or Concrete Function
		System.out.println("This is fun");
	}
}*/
// Abstract class is a singleton pattern -> it means only a single object shall be created for inheritance in the background

interface Shape{ // An interface -> It has no objects -> It cannot be instantiated 
	void draw(); // by default public abstract -> public abstract void draw();
	//int a = 10;  // public static final -> public static final int a = 10;
}

interface inf1{
	void hello();
	void show();
}

interface inf2{
	void thanks();
}

interface inf3 extends inf1,inf2{ // Multiple Inheritance in interfaces
	
}

class MyClass implements inf3{//inf1,inf2{ // Multiple Implementation // Class can implement multiple interfaces

	@Override // Annotation in Java
	public void hello() {
		System.out.println("hello");
	}

	public void show() {
		System.out.println("show");
	}

	public void thanks() {
		System.out.println("thanks");
	}
}


class Circle implements Shape{//extends Shape{ // IS-A
	public void draw(){
		System.out.println("Drawing a Circle");
	}
}

class Rectangle implements Shape{//extends Shape{
	public void draw(){
		System.out.println("Drawing a Rectangle");
	}
}

class Polygon implements Shape{//extends Shape{
	public void draw(){
		System.out.println("Drawing a Polygon");
	}
}

public class InfDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Shape s; // Need not to have objects of Shape
				 // Definition of draw function in shape is not required
		
		/*Shape s; // Reference to interface Shape
		
		s = new Circle();
		s.draw();
		
		s = new Rectangle();
		s.draw();
		
		s = new Polygon();
		s.draw();*/
		
		/*inf1 i1;
		i1 = new MyClass();
		
		i1.hello();
		i1.show();
		
		//i1.thanks(); error
		
		inf2 i2;
		i2 = new MyClass();
		i2.thanks();*/
		
		//i2.hello(); err
		//i2.show(); err
		
		// RTP
		inf3 i3;
		i3 = new MyClass();
		
		i3.show();
		i3.hello();
		i3.thanks();
		
		MyClass mcRef = new MyClass();
		mcRef.thanks();

	}

}
