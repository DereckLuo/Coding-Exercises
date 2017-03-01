package co.edureka;

import java.io.IOException; // Checked Exception


// User Defined Exception > Since it is not a child of RunTimeException it will be categorized as Checked Exception
class MyException extends Exception{
	public MyException(String message) {
		super(message);
	}
}

class MyClass{
	
	void hello(int i){
		if(i == 100){
			ArithmeticException ae = new ArithmeticException("Integer value 100 not allowed"); // Uncheckd Exception
			throw ae; // throw used to throw exceptions explicitly
		}else{
			System.out.println("i is: "+i);
		}
	}
	
	void bye(int i) throws IOException{ // Add throws in Signature
		if(i == 1000){
			IOException io = new IOException("Integer value 1000 not allowed"); // Checked Exception
			throw io;
		}else{
			System.out.println("i is: "+i);
		}
	}
	
	void myexception() throws MyException{
		MyException me = new MyException("This is our customized Exception");
		throw me;
	}
	
}

public class ThrowDemo {
	public static void main(String[] args) {
		System.out.println("Main Started");
		MyClass mcRef = new MyClass();
		//mcRef.hello(100); // compiler is not telling you to put this in try catch throwing an unchecked exception
		
		try {
			mcRef.bye(1000); // compiler is telling to put this call in try catch block
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			mcRef.myexception(); // Compiler will give an error to put it in a try catch block
		}catch(MyException me){
			System.out.println(me.getMessage());
		}
		
		System.out.println("Main Finished");
	}
}
