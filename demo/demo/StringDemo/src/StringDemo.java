
public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*char ch = 'A';
		char[] name = {'H','E','L','L','O'};
		
		 
		
		// String is a Data Type in Java. It is predefined. It is a class.
		// so str1 is a reference variable // String is a Reference Data Type just like array is
		
		String str1 = "Good Morning"; // Interned String
		String str2 = new String("Hello"); // Non Interned String

		String str3 = str1+str2; // concatenate
		
		System.out.println("str1 is: "+str1);
		System.out.println("str2 is: "+str2);
		System.out.println("str3 is: "+str3);
		
		// String is IMMUTABLE - it cannot be changed
		
		String title = "This is Awesome";
		//title.toLowerCase();
		String str4 = title.toUpperCase();
		System.out.println("title is: "+title);
		System.out.println("str4 is: "+str4);
		
		str4 = str4.concat(" This will be added");
		System.out.println("str4 now is: "+str4);
		//System.out.println("str5 is: "+str5);
		
		String s1 = "hello";
		String s2 = "HeLLo";
		
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("s1 is equal to s2");
		} else {
			System.out.println("s1 is not equal to s2");
		}
		
		String s3 = s1.substring(1,3);
		System.out.println("s3 is: "+s3);
		
		String s4 = "Hi,Hello,How,are,you";
		String[] arr = s4.split(",");
		
		for(String s : arr)
			System.out.println(s);*/
		
		// Interned Strings
		String str1 = "Hello"; // str1 is a reference variable -> it holds the address of literal Hello
		String str2 = "Hello"; // str2 is a reference variable -> it holds the address of literal Hello
		if(str1 == str2){
			System.out.println("str1 == str2");
		}else{
			System.out.println("str1 != str2");
		}
		
		// Non Interned String
		String str3 = new String("Hello"); // An Object is constructed in the heap and hello is passed to constructor
		String str4 = new String("Hello");
		if(str1 == str4){
			System.out.println("str1 == str4");
		}else{
			System.out.println("str1 != str4");
		}
		
		str4.concat(" This is Awesome");
		System.out.println("str4 is: "+str4);
		
		if(str1.equals(str4)){
			System.out.println("str1 equals str4");
		}
		
		String str5 = str3.toLowerCase(); // IMMUTABLE
		
		// MUTABLE Strings
		// StringBuffer and StringBuilder
		
		StringBuffer strBuf = new StringBuffer("Hello");
		strBuf.append(" This is Awesome");
		
		System.out.println("strBuf is: "+strBuf);
		
		
	}

}
