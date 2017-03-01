package co.edureka;

public class WrapperDemo {

	public static void main(String[] args) {
		int i = 100; // Primitive Type and it cannot be passed as reference
		
		// Boxing
		Integer iRef = new Integer(i); // Seems that we are converting primitive type i into Reference Type of Integer iRef
		// UnBoxing
		int j = iRef.intValue(); // Getting back the primitive from Reference
		
		
		/*			Wrapper Class
		    int 	Integer
			float 	Float
			char 	Character
			long 	Long
		*/
		
		// AutoBoxing
		Integer kRef = i; // Compiler will convert this statement into -> Integer kRef = new Integer(i); 
		
	}

}
