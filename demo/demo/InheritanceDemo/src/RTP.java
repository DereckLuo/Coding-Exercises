abstract class Shape{ // It is a class for which a user cannot create objects
	abstract void draw(); // It is a function which will have no body // It can only be declared in an abstract class
	int a;
	Shape(){
		a = 10;
	}
	void fun(){
		System.out.println("This is fun");
	}
}
// Abstract class is a singleton pattern -> it means only a single object shall be created for inheritance in the background
/*class Shape{
	void draw(){
		System.out.println("Drawing a Shape");
	}
}*/

class Circle extends Shape{ // IS-A
	
	Circle(){
		
	}
	
	Circle(int a){
		
	}
	
	void draw(){
		System.out.println("Drawing a Circle");
	}
}

class Rectangle extends Shape{
	void draw(){
		System.out.println("Drawing a Rectangle");
	}
}

class Polygon extends Shape{
	void draw(){
		System.out.println("Drawing a Polygon");
	}
}


public class RTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Shape s = new Shape();
		//s.draw(); // Drawing a Shape
		
		//Circle c = new Circle();
		//c.draw(); // Drawing a Circle
		
		Shape s;
		//s = new Shape();
		s = new Circle(); // Polymorphic Statement : LHS (Type: Shape) = RHS (Type:Shape bcoz Circle is a Shape)
		s.draw(); // overriding shall come and draw of circle will be called
		s.fun();

		s = new Rectangle();
		s.draw(); // rectangle's draw
		
		s = new Polygon();
		s.draw(); // polygon's draw
		
		// Typecasting -> Downcasting
		Circle c;
		c = (Circle)s;
		c.draw();
		
		//s = new Shape(); // Objects of shape are not possible
		// defininition of draw is also not required
		
	}

}
